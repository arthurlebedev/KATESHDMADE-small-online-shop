
package controllers;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.BlobContainerPermissions;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ModeloCarSes;
import models.ModeloWishlist;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import pojos.Articulospro;
import repositories.RepositoryCheckAdv;
import repositories.RepositoryGeneral;


public class ArtlistController implements Controller{
    RepositoryCheckAdv repoc;
    RepositoryGeneral repo;
    
    public ArtlistController(){
        this.repoc = new RepositoryCheckAdv();
        this.repo = new RepositoryGeneral();
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView("secure/artlist");
        if(hsr.getSession().getAttribute("userid")!=null){
            if((int)hsr.getSession().getAttribute("userid")==Integer.parseInt("1")){
                view.addObject("message", null);
                    if(hsr.getParameter("erase")!=null){
                        String storageConnectionString = "DefaultEndpointsProtocol=https;" + "AccountName=DELETED;" + "AccountKey=DELETED==";
                        CloudStorageAccount account;
                        CloudBlobClient serviceClient;
                        CloudBlobContainer container;
                        CloudBlockBlob blob;
                        CloudBlockBlob blob2;
                        CloudBlockBlob blob3;
                        CloudBlockBlob blob4;
                        CloudBlockBlob blob5;
                        account = CloudStorageAccount.parse(storageConnectionString);
                        serviceClient = account.createCloudBlobClient();
                        container = serviceClient.getContainerReference("images2");
                        container.createIfNotExists();
                        BlobContainerPermissions containerPermissions;
                        containerPermissions = new BlobContainerPermissions();
                        containerPermissions.setPublicAccess(BlobContainerPublicAccessType.CONTAINER);
                        container.uploadPermissions(containerPermissions);

                        Articulospro art = repo.getOneArticle(Integer.parseInt(hsr.getParameter("erase")));
                        // Upload an image file.
                        blob = container.getBlockBlobReference(art.getFoto1());
                        blob.delete();
                        if(!art.getFoto2().equalsIgnoreCase("NONE")){
                            blob2 = container.getBlockBlobReference(art.getFoto2());
                            blob2.delete();
                        }
                        if(!art.getFoto3().equalsIgnoreCase("NONE")){
                            blob3 = container.getBlockBlobReference(art.getFoto3());
                            blob3.delete();
                        }
                        if(!art.getFoto4().equalsIgnoreCase("NONE")){
                            blob4 = container.getBlockBlobReference(art.getFoto4());
                            blob4.delete();
                        }
                        if(!art.getFoto5().equalsIgnoreCase("NONE")){
                            blob5 = container.getBlockBlobReference(art.getFoto5());
                            blob5.delete();
                        }
                        repoc.DeleteArticulo(Long.parseLong(hsr.getParameter("erase")));
                        view.addObject("message", "You removed one item successfully");
                        if(hsr.getSession().getAttribute("wishlist")!=null){
                            ArrayList<ModeloWishlist> wishlist = (ArrayList<ModeloWishlist>) hsr.getSession().getAttribute("wishlist");
                            ModeloWishlist wish = new ModeloWishlist();
                            for(ModeloWishlist mod:wishlist){
                                if(mod.getIdarticulo()==art.getIdarticulo()){
                                    wish=mod;
                                }
                            }
                            wishlist.remove(wish);
                            if(!wishlist.isEmpty()){
                                hsr.getSession().setAttribute("wishlist", wishlist);
                            }else{
                                hsr.getSession().removeAttribute("wishlist");
                            }
                        }
                        if(hsr.getSession().getAttribute("cart")!=null){
                             ArrayList<ModeloCarSes> listart = (ArrayList<ModeloCarSes>) hsr.getSession().getAttribute("cart");
                             ArrayList<ModeloCarSes> car = new ArrayList<>();
                             for(ModeloCarSes mod:listart){
                                 if(art.getIdarticulo()==mod.getIdarticulo()){
                                     car.add(mod);
                                 }
                             }
                             for(ModeloCarSes mod:car){
                                 listart.remove(mod);
                             }
                             if(!listart.isEmpty()){
                                 hsr.getSession().setAttribute("cart", listart);
                             }else{
                                 hsr.getSession().removeAttribute("cart");
                             }
                        }
                    }
                view.addObject("itemlist", repoc.getItemList());    
                return view;
            }else{
               return new ModelAndView("forward:/index.htm"); 
            }
            
        }else{
            return new ModelAndView("forward:/index.htm");
        }
    }
    
}
