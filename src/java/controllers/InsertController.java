
package controllers;



import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.BlobContainerPermissions;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import repositories.RepositoryCheckAdv;

@Controller
@MultipartConfig
public class InsertController{
    RepositoryCheckAdv repoc;
    
    public InsertController(){
        this.repoc = new RepositoryCheckAdv();
    }
    
    

    @RequestMapping(method= RequestMethod.POST)
    ModelAndView register( @RequestParam MultipartFile imagen1, @RequestParam MultipartFile imagen2, @RequestParam MultipartFile imagen3, @RequestParam MultipartFile imagen4, @RequestParam MultipartFile imagen5, HttpServletRequest hsr)
            throws ServletException, IOException {
        if(hsr.getSession().getAttribute("userid")!=null){
            if((int)hsr.getSession().getAttribute("userid")==Integer.parseInt("1")){
                if(!imagen1.isEmpty()){
                    try {
                        String storageConnectionString = "DefaultEndpointsProtocol=https;" + "AccountName=DELETED;" + "AccountKey=DELETED==";
                        CloudStorageAccount account;
                        CloudBlobClient serviceClient;
                        CloudBlobContainer container;
                        CloudBlockBlob blob;

                        account = CloudStorageAccount.parse(storageConnectionString);
                        serviceClient = account.createCloudBlobClient();
                        // Container name must be lower case.
                        container = serviceClient.getContainerReference("images2");
                        container.createIfNotExists();

                        // Set anonymous access on the container.
                        BlobContainerPermissions containerPermissions;
                        containerPermissions = new BlobContainerPermissions();
                        containerPermissions.setPublicAccess(BlobContainerPublicAccessType.CONTAINER);
                        container.uploadPermissions(containerPermissions);

                        String name1 = imagen1.getOriginalFilename();
                        // Upload an image file.
                        blob = container.getBlockBlobReference(name1);
                        blob.upload(imagen1.getInputStream(), imagen1.getSize());
                        
                        String foto1 = imagen1.getOriginalFilename();
                        String foto2 = "NONE";
                        String foto3 = "NONE";
                        String foto4 = "NONE";
                        String foto5 = "NONE";
                        if(!imagen2.isEmpty()){
                            String name2 = imagen2.getOriginalFilename();
                            blob = container.getBlockBlobReference(name2);
                            blob.upload(imagen2.getInputStream(), imagen2.getSize());
                            foto2 = imagen2.getOriginalFilename();
                        }
                        if(!imagen3.isEmpty()){
                            String name3 = imagen3.getOriginalFilename();
                            blob = container.getBlockBlobReference(name3);
                            blob.upload(imagen3.getInputStream(), imagen3.getSize());
                            foto3 = imagen3.getOriginalFilename();
                        }
                        if(!imagen4.isEmpty()){
                            String name4 = imagen4.getOriginalFilename();
                            blob = container.getBlockBlobReference(name4);
                            blob.upload(imagen4.getInputStream(), imagen4.getSize());
                            foto4 = imagen4.getOriginalFilename();
                        }
                        if(!imagen5.isEmpty()){
                            String name5 = imagen5.getOriginalFilename();
                            blob = container.getBlockBlobReference(name5);
                            blob.upload(imagen5.getInputStream(), imagen5.getSize());
                            foto5 = imagen5.getOriginalFilename();
                        }
                        
                        Long idcat = Long.parseLong(hsr.getParameter("idcat"));
                        String nombreart = hsr.getParameter("nombreart");
                        Long priceart = Long.parseLong(hsr.getParameter("priceart"));
                        String textart = hsr.getParameter("textart");
                        String matart = hsr.getParameter("matart");
                        String dimart = hsr.getParameter("dimart");
                        String pass;
                        String f1name = null;
                        String f1type = null;
                            String f1opt1 = null;
                            String f1opt2 = null;
                            String f1opt3= null;
                            String f1opt4= null;
                            String f1opt5= null;
                            String f1opt6= null;
                            String f1opt7= null;
                            String f1opt8= null;
                            String f1opt9= null;
                        String f2name= null;
                        String f2type= null;
                            String f2opt1= null;
                            String f2opt2= null;
                            String f2opt3= null;
                            String f2opt4= null;
                            String f2opt5= null;
                            String f2opt6= null;
                            String f2opt7= null;
                            String f2opt8= null;
                            String f2opt9= null;
                        String f3name= null;
                        String f3type= null;
                            String f3opt1= null;
                            String f3opt2= null;
                            String f3opt3= null;
                            String f3opt4= null;
                            String f3opt5= null;
                            String f3opt6= null;
                            String f3opt7= null;
                            String f3opt8= null;
                            String f3opt9= null;
                        String f4name= null;
                        String f4type= null;
                            String f4opt1= null;
                            String f4opt2= null;
                            String f4opt3= null;
                            String f4opt4= null;
                            String f4opt5= null;
                            String f4opt6= null;
                            String f4opt7= null;
                            String f4opt8= null;
                            String f4opt9= null;
                        if(!hsr.getParameter("text1name").equals("")||!hsr.getParameter("combo1name").equals("")){
                            pass = "TRUE";
                            if(!hsr.getParameter("combo1name").equals("")){
                                f1name = hsr.getParameter("combo1name");
                                f1type = "COMBO";
                                if(!hsr.getParameter("combo1opt1").equals("")){
                                    f1opt1 = hsr.getParameter("combo1opt1");
                                }else{
                                    f1opt1 = "NONE";
                                }
                                if(!hsr.getParameter("combo1opt2").equals("")){
                                    f1opt2 = hsr.getParameter("combo1opt2");
                                }else{
                                    f1opt2 = "NONE";
                                }
                                if(!hsr.getParameter("combo1opt3").equals("")){
                                    f1opt3 = hsr.getParameter("combo1opt3");
                                }else{
                                    f1opt3 = "NONE";
                                }
                                if(!hsr.getParameter("combo1opt4").equals("")){
                                    f1opt4 = hsr.getParameter("combo1opt4");
                                }else{
                                    f1opt4 = "NONE";
                                }
                                if(!hsr.getParameter("combo1opt5").equals("")){
                                    f1opt5 = hsr.getParameter("combo1opt5");
                                }else{
                                    f1opt5 = "NONE";
                                }
                                if(!hsr.getParameter("combo1opt6").equals("")){
                                    f1opt6 = hsr.getParameter("combo1opt6");
                                }else{
                                    f1opt6 = "NONE";
                                }
                                if(!hsr.getParameter("combo1opt7").equals("")){
                                    f1opt7 = hsr.getParameter("combo1opt7");
                                }else{
                                    f1opt7 = "NONE";
                                }
                                if(!hsr.getParameter("combo1opt8").equals("")){
                                    f1opt8 = hsr.getParameter("combo1opt8");
                                }else{
                                    f1opt8 = "NONE";
                                }
                                if(!hsr.getParameter("combo1opt9").equals("")){
                                    f1opt9 = hsr.getParameter("combo1opt9");
                                }else{
                                    f1opt9 = "NONE";
                                }
                                if(!hsr.getParameter("text2name").equals("")||!hsr.getParameter("combo2name").equals("")){
                                    if(!hsr.getParameter("combo2name").equals("")){
                                        f2name = hsr.getParameter("combo2name");
                                        f2type = "COMBO";
                                        if(!hsr.getParameter("combo2opt1").equals("")){
                                            f2opt1 = hsr.getParameter("combo2opt1");
                                        }else{
                                            f2opt1 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt2").equals("")){
                                            f2opt2 = hsr.getParameter("combo2opt2");
                                        }else{
                                            f2opt2 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt3").equals("")){
                                            f2opt3 = hsr.getParameter("combo2opt3");
                                        }else{
                                            f2opt3 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt4").equals("")){
                                            f2opt4 = hsr.getParameter("combo2opt4");
                                        }else{
                                            f2opt4 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt5").equals("")){
                                            f2opt5 = hsr.getParameter("combo2opt5");
                                        }else{
                                            f2opt5 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt6").equals("")){
                                            f2opt6 = hsr.getParameter("combo2opt6");
                                        }else{
                                            f2opt6 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt7").equals("")){
                                            f2opt7 = hsr.getParameter("combo2opt7");
                                        }else{
                                            f2opt7 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt8").equals("")){
                                            f2opt8 = hsr.getParameter("combo2opt8");
                                        }else{
                                            f2opt8 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt9").equals("")){
                                            f2opt9 = hsr.getParameter("combo2opt9");
                                        }else{
                                            f2opt9 = "NONE";
                                        }
                                        if(!hsr.getParameter("text3name").equals("")||!hsr.getParameter("combo3name").equals("")){
                                            if(!hsr.getParameter("combo3name").equals("")){
                                                f3name = hsr.getParameter("combo3name");
                                                f3type = "COMBO";
                                                if(!hsr.getParameter("combo3opt1").equals("")){
                                                    f3opt1 = hsr.getParameter("combo3opt1");
                                                }else{
                                                    f3opt1 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt2").equals("")){
                                                    f3opt2 = hsr.getParameter("combo3opt2");
                                                }else{
                                                    f3opt2 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt3").equals("")){
                                                    f3opt3 = hsr.getParameter("combo3opt3");
                                                }else{
                                                    f3opt3 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt4").equals("")){
                                                    f3opt4 = hsr.getParameter("combo3opt4");
                                                }else{
                                                    f3opt4 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt5").equals("")){
                                                    f3opt5 = hsr.getParameter("combo3opt5");
                                                }else{
                                                    f3opt5 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt6").equals("")){
                                                    f3opt6 = hsr.getParameter("combo3opt6");
                                                }else{
                                                    f3opt6 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt7").equals("")){
                                                    f3opt7 = hsr.getParameter("combo3opt7");
                                                }else{
                                                    f3opt7 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt8").equals("")){
                                                    f3opt8 = hsr.getParameter("combo3opt8");
                                                }else{
                                                    f3opt8 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt9").equals("")){
                                                    f3opt9 = hsr.getParameter("combo3opt9");
                                                }else{
                                                    f3opt9 = "NONE";
                                                }
                                                if(!hsr.getParameter("text4name").equals("")||!hsr.getParameter("combo4name").equals("")){
                                                    if(!hsr.getParameter("combo4name").equals("")){
                                                        f4name = hsr.getParameter("combo4name");
                                                        f4type = "COMBO";
                                                        if(!hsr.getParameter("combo4opt1").equals("")){
                                                            f4opt1 = hsr.getParameter("combo4opt1");
                                                        }else{
                                                            f4opt1 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt2").equals("")){
                                                            f4opt2 = hsr.getParameter("combo4opt2");
                                                        }else{
                                                            f4opt2 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt3").equals("")){
                                                            f4opt3 = hsr.getParameter("combo4opt3");
                                                        }else{
                                                            f4opt3 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt4").equals("")){
                                                            f4opt4 = hsr.getParameter("combo4opt4");
                                                        }else{
                                                            f4opt4 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt5").equals("")){
                                                            f4opt5 = hsr.getParameter("combo4opt5");
                                                        }else{
                                                            f4opt5 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt6").equals("")){
                                                            f4opt6 = hsr.getParameter("combo4opt6");
                                                        }else{
                                                            f4opt6 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt7").equals("")){
                                                            f4opt7 = hsr.getParameter("combo4opt7");
                                                        }else{
                                                            f4opt7 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt8").equals("")){
                                                            f4opt8 = hsr.getParameter("combo4opt8");
                                                        }else{
                                                            f4opt8 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt9").equals("")){
                                                            f4opt9 = hsr.getParameter("combo4opt9");
                                                        }else{
                                                            f4opt9 = "NONE";
                                                        }
                                                    }else{
                                                        f4name = hsr.getParameter("text4name");
                                                        f4type = "TEXT";
                                                        f4opt1 = "NONE";
                                                        f4opt2 = "NONE";
                                                        f4opt3 = "NONE";
                                                        f4opt4 = "NONE";
                                                        f4opt5 = "NONE";
                                                        f4opt6 = "NONE";
                                                        f4opt7 = "NONE";
                                                        f4opt8 = "NONE";
                                                        f4opt9 = "NONE";
                                                    }
                                                }else{
                                                    f4name = "NONE";
                                                }
                                            }else{
                                                f3name = hsr.getParameter("text3name");
                                                f3type = "TEXT";
                                                f3opt1 = "NONE";
                                                f3opt2 = "NONE";
                                                f3opt3 = "NONE";
                                                f3opt4 = "NONE";
                                                f3opt5 = "NONE";
                                                f3opt6 = "NONE";
                                                f3opt7 = "NONE";
                                                f3opt8 = "NONE";
                                                f3opt9 = "NONE";
                                                if(!hsr.getParameter("text4name").equals("")||!hsr.getParameter("combo4name").equals("")){
                                                    if(!hsr.getParameter("combo4name").equals("")){
                                                        f4name = hsr.getParameter("combo4name");
                                                        f4type = "COMBO";
                                                        if(!hsr.getParameter("combo4opt1").equals("")){
                                                            f4opt1 = hsr.getParameter("combo4opt1");
                                                        }else{
                                                            f4opt1 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt2").equals("")){
                                                            f4opt2 = hsr.getParameter("combo4opt2");
                                                        }else{
                                                            f4opt2 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt3").equals("")){
                                                            f4opt3 = hsr.getParameter("combo4opt3");
                                                        }else{
                                                            f4opt3 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt4").equals("")){
                                                            f4opt4 = hsr.getParameter("combo4opt4");
                                                        }else{
                                                            f4opt4 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt5").equals("")){
                                                            f4opt5 = hsr.getParameter("combo4opt5");
                                                        }else{
                                                            f4opt5 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt6").equals("")){
                                                            f4opt6 = hsr.getParameter("combo4opt6");
                                                        }else{
                                                            f4opt6 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt7").equals("")){
                                                            f4opt7 = hsr.getParameter("combo4opt7");
                                                        }else{
                                                            f4opt7 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt8").equals("")){
                                                            f4opt8 = hsr.getParameter("combo4opt8");
                                                        }else{
                                                            f4opt8 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt9").equals("")){
                                                            f4opt9 = hsr.getParameter("combo4opt9");
                                                        }else{
                                                            f4opt9 = "NONE";
                                                        }
                                                    }else{
                                                        f4name = hsr.getParameter("text4name");
                                                        f4type = "TEXT";
                                                        f4opt1 = "NONE";
                                                        f4opt2 = "NONE";
                                                        f4opt3 = "NONE";
                                                        f4opt4 = "NONE";
                                                        f4opt5 = "NONE";
                                                        f4opt6 = "NONE";
                                                        f4opt7 = "NONE";
                                                        f4opt8 = "NONE";
                                                        f4opt9 = "NONE";
                                                    }
                                                }else{
                                                    f4name = "NONE";
                                                }
                                            }
                                        }else{
                                            f3name = "NONE";
                                        }
                                    }else{
                                        f2name = hsr.getParameter("text2name");
                                        f2type = "TEXT";
                                        f2opt1 = "NONE";
                                        f2opt2 = "NONE";
                                        f2opt3 = "NONE";
                                        f2opt4 = "NONE";
                                        f2opt5 = "NONE";
                                        f2opt6 = "NONE";
                                        f2opt7 = "NONE";
                                        f2opt8 = "NONE";
                                        f2opt9 = "NONE";
                                        if(!hsr.getParameter("text3name").equals("")||!hsr.getParameter("combo3name").equals("")){
                                            if(!hsr.getParameter("combo3name").equals("")){
                                                f3name = hsr.getParameter("combo3name");
                                                f3type = "COMBO";
                                                if(!hsr.getParameter("combo3opt1").equals("")){
                                                    f3opt1 = hsr.getParameter("combo3opt1");
                                                }else{
                                                    f3opt1 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt2").equals("")){
                                                    f3opt2 = hsr.getParameter("combo3opt2");
                                                }else{
                                                    f3opt2 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt3").equals("")){
                                                    f3opt3 = hsr.getParameter("combo3opt3");
                                                }else{
                                                    f3opt3 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt4").equals("")){
                                                    f3opt4 = hsr.getParameter("combo3opt4");
                                                }else{
                                                    f3opt4 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt5").equals("")){
                                                    f3opt5 = hsr.getParameter("combo3opt5");
                                                }else{
                                                    f3opt5 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt6").equals("")){
                                                    f3opt6 = hsr.getParameter("combo3opt6");
                                                }else{
                                                    f3opt6 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt7").equals("")){
                                                    f3opt7 = hsr.getParameter("combo3opt7");
                                                }else{
                                                    f3opt7 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt8").equals("")){
                                                    f3opt8 = hsr.getParameter("combo3opt8");
                                                }else{
                                                    f3opt8 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt9").equals("")){
                                                    f3opt9 = hsr.getParameter("combo3opt9");
                                                }else{
                                                    f3opt9 = "NONE";
                                                }
                                                if(!hsr.getParameter("text4name").equals("")||!hsr.getParameter("combo4name").equals("")){
                                                    if(!hsr.getParameter("combo4name").equals("")){
                                                        f4name = hsr.getParameter("combo4name");
                                                        f4type = "COMBO";
                                                        if(!hsr.getParameter("combo4opt1").equals("")){
                                                            f4opt1 = hsr.getParameter("combo4opt1");
                                                        }else{
                                                            f4opt1 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt2").equals("")){
                                                            f4opt2 = hsr.getParameter("combo4opt2");
                                                        }else{
                                                            f4opt2 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt3").equals("")){
                                                            f4opt3 = hsr.getParameter("combo4opt3");
                                                        }else{
                                                            f4opt3 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt4").equals("")){
                                                            f4opt4 = hsr.getParameter("combo4opt4");
                                                        }else{
                                                            f4opt4 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt5").equals("")){
                                                            f4opt5 = hsr.getParameter("combo4opt5");
                                                        }else{
                                                            f4opt5 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt6").equals("")){
                                                            f4opt6 = hsr.getParameter("combo4opt6");
                                                        }else{
                                                            f4opt6 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt7").equals("")){
                                                            f4opt7 = hsr.getParameter("combo4opt7");
                                                        }else{
                                                            f4opt7 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt8").equals("")){
                                                            f4opt8 = hsr.getParameter("combo4opt8");
                                                        }else{
                                                            f4opt8 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt9").equals("")){
                                                            f4opt9 = hsr.getParameter("combo4opt9");
                                                        }else{
                                                            f4opt9 = "NONE";
                                                        }
                                                    }else{
                                                        f4name = hsr.getParameter("text4name");
                                                        f4type = "TEXT";
                                                        f4opt1 = "NONE";
                                                        f4opt2 = "NONE";
                                                        f4opt3 = "NONE";
                                                        f4opt4 = "NONE";
                                                        f4opt5 = "NONE";
                                                        f4opt6 = "NONE";
                                                        f4opt7 = "NONE";
                                                        f4opt8 = "NONE";
                                                        f4opt9 = "NONE";
                                                    }
                                                }else{
                                                    f4name = "NONE";
                                                }
                                            }else{
                                                f3name = hsr.getParameter("text3name");
                                                f3type = "TEXT";
                                                f3opt1 = "NONE";
                                                f3opt2 = "NONE";
                                                f3opt3 = "NONE";
                                                f3opt4 = "NONE";
                                                f3opt5 = "NONE";
                                                f3opt6 = "NONE";
                                                f3opt7 = "NONE";
                                                f3opt8 = "NONE";
                                                f3opt9 = "NONE";
                                            }
                                        }else{
                                            f3name = "NONE";
                                        }
                                    }
                                }else{
                                    f2name = "NONE";
                                }
                            }else{
                                f1name = hsr.getParameter("text1name");
                                f1type = "TEXT";
                                f1opt1 = "NONE";
                                f1opt2 = "NONE";
                                f1opt3 = "NONE";
                                f1opt4 = "NONE";
                                f1opt5 = "NONE";
                                f1opt6 = "NONE";
                                f1opt7 = "NONE";
                                f1opt8 = "NONE";
                                f1opt9 = "NONE";
                                if(!hsr.getParameter("text2name").equals("")||!hsr.getParameter("combo2name").equals("")){
                                    if(!hsr.getParameter("combo2name").equals("")){
                                        f2name = hsr.getParameter("combo2name");
                                        f2type = "COMBO";
                                        if(!hsr.getParameter("combo2opt1").equals("")){
                                            f2opt1 = hsr.getParameter("combo2opt1");
                                        }else{
                                            f2opt1 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt2").equals("")){
                                            f2opt2 = hsr.getParameter("combo2opt2");
                                        }else{
                                            f2opt2 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt3").equals("")){
                                            f2opt3 = hsr.getParameter("combo2opt3");
                                        }else{
                                            f2opt3 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt4").equals("")){
                                            f2opt4 = hsr.getParameter("combo2opt4");
                                        }else{
                                            f2opt4 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt5").equals("")){
                                            f2opt5 = hsr.getParameter("combo2opt5");
                                        }else{
                                            f2opt5 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt6").equals("")){
                                            f2opt6 = hsr.getParameter("combo2opt6");
                                        }else{
                                            f2opt6 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt7").equals("")){
                                            f2opt7 = hsr.getParameter("combo2opt7");
                                        }else{
                                            f2opt7 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt8").equals("")){
                                            f2opt8 = hsr.getParameter("combo2opt8");
                                        }else{
                                            f2opt8 = "NONE";
                                        }
                                        if(!hsr.getParameter("combo2opt9").equals("")){
                                            f2opt9 = hsr.getParameter("combo2opt9");
                                        }else{
                                            f2opt9 = "NONE";
                                        }
                                        if(!hsr.getParameter("text3name").equals("")||!hsr.getParameter("combo3name").equals("")){
                                            if(!hsr.getParameter("combo3name").equals("")){
                                                f3name = hsr.getParameter("combo3name");
                                                f3type = "COMBO";
                                                if(!hsr.getParameter("combo3opt1").equals("")){
                                                    f3opt1 = hsr.getParameter("combo3opt1");
                                                }else{
                                                    f3opt1 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt2").equals("")){
                                                    f3opt2 = hsr.getParameter("combo3opt2");
                                                }else{
                                                    f3opt2 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt3").equals("")){
                                                    f3opt3 = hsr.getParameter("combo3opt3");
                                                }else{
                                                    f3opt3 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt4").equals("")){
                                                    f3opt4 = hsr.getParameter("combo3opt4");
                                                }else{
                                                    f3opt4 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt5").equals("")){
                                                    f3opt5 = hsr.getParameter("combo3opt5");
                                                }else{
                                                    f3opt5 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt6").equals("")){
                                                    f3opt6 = hsr.getParameter("combo3opt6");
                                                }else{
                                                    f3opt6 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt7").equals("")){
                                                    f3opt7 = hsr.getParameter("combo3opt7");
                                                }else{
                                                    f3opt7 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt8").equals("")){
                                                    f3opt8 = hsr.getParameter("combo3opt8");
                                                }else{
                                                    f3opt8 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt9").equals("")){
                                                    f3opt9 = hsr.getParameter("combo3opt9");
                                                }else{
                                                    f3opt9 = "NONE";
                                                }
                                                if(!hsr.getParameter("text4name").equals("")||!hsr.getParameter("combo4name").equals("")){
                                                    if(!hsr.getParameter("combo4name").equals("")){
                                                        f4name = hsr.getParameter("combo4name");
                                                        f4type = "COMBO";
                                                        if(!hsr.getParameter("combo4opt1").equals("")){
                                                            f4opt1 = hsr.getParameter("combo4opt1");
                                                        }else{
                                                            f4opt1 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt2").equals("")){
                                                            f4opt2 = hsr.getParameter("combo4opt2");
                                                        }else{
                                                            f4opt2 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt3").equals("")){
                                                            f4opt3 = hsr.getParameter("combo4opt3");
                                                        }else{
                                                            f4opt3 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt4").equals("")){
                                                            f4opt4 = hsr.getParameter("combo4opt4");
                                                        }else{
                                                            f4opt4 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt5").equals("")){
                                                            f4opt5 = hsr.getParameter("combo4opt5");
                                                        }else{
                                                            f4opt5 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt6").equals("")){
                                                            f4opt6 = hsr.getParameter("combo4opt6");
                                                        }else{
                                                            f4opt6 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt7").equals("")){
                                                            f4opt7 = hsr.getParameter("combo4opt7");
                                                        }else{
                                                            f4opt7 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt8").equals("")){
                                                            f4opt8 = hsr.getParameter("combo4opt8");
                                                        }else{
                                                            f4opt8 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt9").equals("")){
                                                            f4opt9 = hsr.getParameter("combo4opt9");
                                                        }else{
                                                            f4opt9 = "NONE";
                                                        }
                                                    }else{
                                                        f4name = hsr.getParameter("text4name");
                                                        f4type = "TEXT";
                                                        f4opt1 = "NONE";
                                                        f4opt2 = "NONE";
                                                        f4opt3 = "NONE";
                                                        f4opt4 = "NONE";
                                                        f4opt5 = "NONE";
                                                        f4opt6 = "NONE";
                                                        f4opt7 = "NONE";
                                                        f4opt8 = "NONE";
                                                        f4opt9 = "NONE";
                                                    }
                                                }else{
                                                    f4name = "NONE";
                                                }
                                            }else{
                                                f3name = hsr.getParameter("text3name");
                                                f3type = "TEXT";
                                                f3opt1 = "NONE";
                                                f3opt2 = "NONE";
                                                f3opt3 = "NONE";
                                                f3opt4 = "NONE";
                                                f3opt5 = "NONE";
                                                f3opt6 = "NONE";
                                                f3opt7 = "NONE";
                                                f3opt8 = "NONE";
                                                f3opt9 = "NONE";
                                                if(!hsr.getParameter("text4name").equals("")||!hsr.getParameter("combo4name").equals("")){
                                                    if(!hsr.getParameter("combo4name").equals("")){
                                                        f4name = hsr.getParameter("combo4name");
                                                        f4type = "COMBO";
                                                        if(!hsr.getParameter("combo4opt1").equals("")){
                                                            f4opt1 = hsr.getParameter("combo4opt1");
                                                        }else{
                                                            f4opt1 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt2").equals("")){
                                                            f4opt2 = hsr.getParameter("combo4opt2");
                                                        }else{
                                                            f4opt2 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt3").equals("")){
                                                            f4opt3 = hsr.getParameter("combo4opt3");
                                                        }else{
                                                            f4opt3 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt4").equals("")){
                                                            f4opt4 = hsr.getParameter("combo4opt4");
                                                        }else{
                                                            f4opt4 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt5").equals("")){
                                                            f4opt5 = hsr.getParameter("combo4opt5");
                                                        }else{
                                                            f4opt5 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt6").equals("")){
                                                            f4opt6 = hsr.getParameter("combo4opt6");
                                                        }else{
                                                            f4opt6 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt7").equals("")){
                                                            f4opt7 = hsr.getParameter("combo4opt7");
                                                        }else{
                                                            f4opt7 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt8").equals("")){
                                                            f4opt8 = hsr.getParameter("combo4opt8");
                                                        }else{
                                                            f4opt8 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt9").equals("")){
                                                            f4opt9 = hsr.getParameter("combo4opt9");
                                                        }else{
                                                            f4opt9 = "NONE";
                                                        }
                                                    }else{
                                                        f4name = hsr.getParameter("text4name");
                                                        f4type = "TEXT";
                                                        f4opt1 = "NONE";
                                                        f4opt2 = "NONE";
                                                        f4opt3 = "NONE";
                                                        f4opt4 = "NONE";
                                                        f4opt5 = "NONE";
                                                        f4opt6 = "NONE";
                                                        f4opt7 = "NONE";
                                                        f4opt8 = "NONE";
                                                        f4opt9 = "NONE";
                                                    }
                                                }else{
                                                    f4name = "NONE";
                                                }
                                            }
                                        }else{
                                            f3name = "NONE";
                                        }
                                    }else{
                                        f2name = hsr.getParameter("text2name");
                                        f2type = "TEXT";
                                        f2opt1 = "NONE";
                                        f2opt2 = "NONE";
                                        f2opt3 = "NONE";
                                        f2opt4 = "NONE";
                                        f2opt5 = "NONE";
                                        f2opt6 = "NONE";
                                        f2opt7 = "NONE";
                                        f2opt8 = "NONE";
                                        f2opt9 = "NONE";
                                        if(!hsr.getParameter("text3name").equals("")||!hsr.getParameter("combo3name").equals("")){
                                            if(!hsr.getParameter("combo3name").equals("")){
                                                f3name = hsr.getParameter("combo3name");
                                                f3type = "COMBO";
                                                if(!hsr.getParameter("combo3opt1").equals("")){
                                                    f3opt1 = hsr.getParameter("combo3opt1");
                                                }else{
                                                    f3opt1 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt2").equals("")){
                                                    f3opt2 = hsr.getParameter("combo3opt2");
                                                }else{
                                                    f3opt2 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt3").equals("")){
                                                    f3opt3 = hsr.getParameter("combo3opt3");
                                                }else{
                                                    f3opt3 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt4").equals("")){
                                                    f3opt4 = hsr.getParameter("combo3opt4");
                                                }else{
                                                    f3opt4 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt5").equals("")){
                                                    f3opt5 = hsr.getParameter("combo3opt5");
                                                }else{
                                                    f3opt5 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt6").equals("")){
                                                    f3opt6 = hsr.getParameter("combo3opt6");
                                                }else{
                                                    f3opt6 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt7").equals("")){
                                                    f3opt7 = hsr.getParameter("combo3opt7");
                                                }else{
                                                    f3opt7 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt8").equals("")){
                                                    f3opt8 = hsr.getParameter("combo3opt8");
                                                }else{
                                                    f3opt8 = "NONE";
                                                }
                                                if(!hsr.getParameter("combo3opt9").equals("")){
                                                    f3opt9 = hsr.getParameter("combo3opt9");
                                                }else{
                                                    f3opt9 = "NONE";
                                                }
                                                if(!hsr.getParameter("text4name").equals("")||!hsr.getParameter("combo4name").equals("")){
                                                    if(!hsr.getParameter("combo4name").equals("")){
                                                        f4name = hsr.getParameter("combo4name");
                                                        f4type = "COMBO";
                                                        if(!hsr.getParameter("combo4opt1").equals("")){
                                                            f4opt1 = hsr.getParameter("combo4opt1");
                                                        }else{
                                                            f4opt1 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt2").equals("")){
                                                            f4opt2 = hsr.getParameter("combo4opt2");
                                                        }else{
                                                            f4opt2 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt3").equals("")){
                                                            f4opt3 = hsr.getParameter("combo4opt3");
                                                        }else{
                                                            f4opt3 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt4").equals("")){
                                                            f4opt4 = hsr.getParameter("combo4opt4");
                                                        }else{
                                                            f4opt4 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt5").equals("")){
                                                            f4opt5 = hsr.getParameter("combo4opt5");
                                                        }else{
                                                            f4opt5 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt6").equals("")){
                                                            f4opt6 = hsr.getParameter("combo4opt6");
                                                        }else{
                                                            f4opt6 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt7").equals("")){
                                                            f4opt7 = hsr.getParameter("combo4opt7");
                                                        }else{
                                                            f4opt7 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt8").equals("")){
                                                            f4opt8 = hsr.getParameter("combo4opt8");
                                                        }else{
                                                            f4opt8 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt9").equals("")){
                                                            f4opt9 = hsr.getParameter("combo4opt9");
                                                        }else{
                                                            f4opt9 = "NONE";
                                                        }
                                                    }else{
                                                        f4name = hsr.getParameter("text4name");
                                                        f4type = "TEXT";
                                                        f4opt1 = "NONE";
                                                        f4opt2 = "NONE";
                                                        f4opt3 = "NONE";
                                                        f4opt4 = "NONE";
                                                        f4opt5 = "NONE";
                                                        f4opt6 = "NONE";
                                                        f4opt7 = "NONE";
                                                        f4opt8 = "NONE";
                                                        f4opt9 = "NONE";
                                                    }
                                                }else{
                                                    f4name = "NONE";
                                                }
                                            }else{
                                                f3name = hsr.getParameter("text3name");
                                                f3type = "TEXT";
                                                f3opt1 = "NONE";
                                                f3opt2 = "NONE";
                                                f3opt3 = "NONE";
                                                f3opt4 = "NONE";
                                                f3opt5 = "NONE";
                                                f3opt6 = "NONE";
                                                f3opt7 = "NONE";
                                                f3opt8 = "NONE";
                                                f3opt9 = "NONE";
                                                if(!hsr.getParameter("text4name").equals("")||!hsr.getParameter("combo4name").equals("")){
                                                    if(!hsr.getParameter("combo4name").equals("")){
                                                        f4name = hsr.getParameter("combo4name");
                                                        f4type = "COMBO";
                                                        if(!hsr.getParameter("combo4opt1").equals("")){
                                                            f4opt1 = hsr.getParameter("combo4opt1");
                                                        }else{
                                                            f4opt1 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt2").equals("")){
                                                            f4opt2 = hsr.getParameter("combo4opt2");
                                                        }else{
                                                            f4opt2 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt3").equals("")){
                                                            f4opt3 = hsr.getParameter("combo4opt3");
                                                        }else{
                                                            f4opt3 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt4").equals("")){
                                                            f4opt4 = hsr.getParameter("combo4opt4");
                                                        }else{
                                                            f4opt4 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt5").equals("")){
                                                            f4opt5 = hsr.getParameter("combo4opt5");
                                                        }else{
                                                            f4opt5 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt6").equals("")){
                                                            f4opt6 = hsr.getParameter("combo4opt6");
                                                        }else{
                                                            f4opt6 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt7").equals("")){
                                                            f4opt7 = hsr.getParameter("combo4opt7");
                                                        }else{
                                                            f4opt7 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt8").equals("")){
                                                            f4opt8 = hsr.getParameter("combo4opt8");
                                                        }else{
                                                            f4opt8 = "NONE";
                                                        }
                                                        if(!hsr.getParameter("combo4opt9").equals("")){
                                                            f4opt9 = hsr.getParameter("combo4opt9");
                                                        }else{
                                                            f4opt9 = "NONE";
                                                        }
                                                    }else{
                                                        f4name = hsr.getParameter("text4name");
                                                        f4type = "TEXT";
                                                        f4opt1 = "NONE";
                                                        f4opt2 = "NONE";
                                                        f4opt3 = "NONE";
                                                        f4opt4 = "NONE";
                                                        f4opt5 = "NONE";
                                                        f4opt6 = "NONE";
                                                        f4opt7 = "NONE";
                                                        f4opt8 = "NONE";
                                                        f4opt9 = "NONE";
                                                    }
                                                }else{
                                                    f4name = "NONE";
                                                }
                                            }
                                        }else{
                                            f3name = "NONE";
                                        }
                                        
                                    }
                                }else{
                                    f2name = "NONE";
                                }
                            }
                        }else{
                            pass = "FALSE";
                        }
                        repoc.InsertArtPro(idcat, nombreart, priceart, matart, dimart, textart, foto1, foto2, foto3, foto4, foto5, pass, f1name, f1type, f1opt1, f1opt2, f1opt3, f1opt4, f1opt5, f1opt6, f1opt7, f1opt8, f1opt9, f2name, f2type, f2opt1, f2opt2, f2opt3, f2opt4, f2opt5, f2opt6, f2opt7, f2opt8, f2opt9, f3name, f3type, f3opt1, f3opt2, f3opt3, f3opt4, f3opt5, f3opt6, f3opt7, f3opt8, f3opt9, f4name, f4type, f4opt1, f4opt2, f4opt3, f4opt4, f4opt5, f4opt6, f4opt7, f4opt8, f4opt9);
                        
                    } catch (Exception ex) {
                            Logger.getLogger(InsertController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ModelAndView view = new ModelAndView("secure/insert");
                        view.addObject("message", "You added new item to shop. Congratulations!");
                    return view;
                }
            }else{
                return new ModelAndView("forward:/index.htm");
            }    
        }else{
           return new ModelAndView("forward:/index.htm");
        }    
       return new ModelAndView("forward:/index.htm");      
    }        
    
    @RequestMapping(method = RequestMethod.GET)
   public ModelAndView inicio(HttpServletResponse hsr1, HttpServletRequest hsr) {
      ModelAndView view = new ModelAndView("secure/insert");
        if(hsr.getSession().getAttribute("userid")!=null){
            if((int)hsr.getSession().getAttribute("userid")==Integer.parseInt("1")){
                if(hsr.getParameter("iname")!=null){
                    view.addObject("message", null);
                    
                }
                return view;
            }else{
                return new ModelAndView("forward:/index.htm");
            }
        }else{
            return new ModelAndView("forward:/index.htm");
        }    
   }
   
   
}    
    

