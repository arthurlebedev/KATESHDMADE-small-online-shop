
package controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ModeloWishlist;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import pojos.Wishlistpro;
import repositories.RepositoryGeneral;
import repositories.RepositorySession;


public class WishlistController implements Controller{
    RepositoryGeneral repo;
    RepositorySession reposes;
    
    public WishlistController(){
        this.repo = new RepositoryGeneral();
        this.reposes = new RepositorySession();
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView();
        
        if(hsr.getParameter("quant")!=null){
            ArrayList<ModeloWishlist> wishlist = (ArrayList<ModeloWishlist>) hsr.getSession().getAttribute("wishlist");
            ArrayList<ModeloWishlist> check= new ArrayList<>();
            ArrayList<ModeloWishlist> modif= new ArrayList<>();
            for (ModeloWishlist mod:wishlist){
                if(mod.getIdarticulo()==Long.parseLong(hsr.getParameter("id"+String.valueOf(mod.getIdarticulo())))){
                    if(mod.getQuantity()!=Long.parseLong(hsr.getParameter(String.valueOf(mod.getIdarticulo())))){
                        check.add(mod);
                        mod.setQuantity(Long.parseLong(hsr.getParameter(String.valueOf(mod.getIdarticulo()))));
                        modif.add(mod);
                    }
                }
            }
            for(ModeloWishlist mod:check){
                wishlist.remove(mod);
            }    
            for (ModeloWishlist mod:modif){
                wishlist.add(mod);
            }
            hsr.getSession().setAttribute("wishlist", wishlist);
            if(hsr.getSession().getAttribute("userid")!=null){
                int usconv = (int) hsr.getSession().getAttribute("userid");
                Long us = Long.parseLong(String.valueOf(usconv));
                ArrayList<Wishlistpro> wishpro = (ArrayList<Wishlistpro>) reposes.gettodosWish(us);
                ArrayList<Wishlistpro> modif2= new ArrayList<>();
                for (Wishlistpro mod:wishpro){
                    if(mod.getId().getIdarticulo()==Long.parseLong(hsr.getParameter("id"+String.valueOf(mod.getId().getIdarticulo())))){
                        if(mod.getQuantity()!=Long.parseLong(hsr.getParameter(String.valueOf(mod.getId().getIdarticulo())))){
                            mod.setQuantity(Integer.parseInt(hsr.getParameter(String.valueOf(mod.getId().getIdarticulo()))));
                            modif2.add(mod);
                        }
                    }
                }
                for (Wishlistpro mod:modif2){
                    Long idart = Long.parseLong(String.valueOf(mod.getId().getIdarticulo()));
                    reposes.UpdateWish(us.longValue(), idart, mod.getQuantity().longValue());
                }
            }
        }
        
        if(hsr.getParameter("logout")!=null){
                hsr.getSession().removeAttribute("userid");
        }
        view.addObject("us", null);
        if(hsr.getSession().getAttribute("userid")!=null){
            view.addObject("us", "1");
        }    
        if(hsr.getParameter("erase")!=null){
            ModeloWishlist artic = repo.getArticleWishlist(Integer.parseInt(hsr.getParameter("erase")));
            ArrayList<ModeloWishlist> wishlist = (ArrayList<ModeloWishlist>) hsr.getSession().getAttribute("wishlist");
            Long idart=null;
            for (ModeloWishlist mod:wishlist){
                    if(artic.getNombre().equalsIgnoreCase(mod.getNombre())){
                        artic=mod;
                        idart=mod.getIdarticulo();
                    }
                }
            wishlist.remove(artic);
            if(wishlist.size()<1){
                hsr.getSession().removeAttribute("wishlist");
            }else{
                hsr.getSession().setAttribute("wishlist", wishlist);
            }
            if(hsr.getSession().getAttribute("userid")!=null){
                int usconv = (int) hsr.getSession().getAttribute("userid");
                Long us = Long.parseLong(String.valueOf(usconv));
                reposes.DeleteWish(us, idart);
            }
        }
        if(hsr.getParameter("id")!=null){
            ModeloWishlist artic = repo.getArticleWishlist(Integer.parseInt(hsr.getParameter("id")));
            ModeloWishlist articcheck = artic;
            Long quant=null;
            Long idart=null;
            if(hsr.getSession().getAttribute("wishlist")!=null){
                ArrayList<ModeloWishlist> wishlist = (ArrayList<ModeloWishlist>) hsr.getSession().getAttribute("wishlist");
                for (ModeloWishlist mod:wishlist){
                    if(artic.getNombre().equalsIgnoreCase(mod.getNombre())){
                        wishlist.remove(mod);
                        mod.setQuantity(mod.getQuantity()+1);
                        wishlist.add(mod);
                        articcheck = null;
                        quant=mod.getQuantity();
                        idart=mod.getIdarticulo();
                    }
                }
                if(articcheck!=null){
                    wishlist.add(articcheck);
                }
                hsr.getSession().setAttribute("wishlist", wishlist);
                if(hsr.getSession().getAttribute("userid")!=null){
                    if(quant!=null){
                       Long us = (Long) hsr.getSession().getAttribute("userid");
                       reposes.UpdateWish(us, idart, quant);  
                    }else{
                       int usconv = (int) hsr.getSession().getAttribute("userid");
                       Long us = Long.parseLong(String.valueOf(usconv));
                       reposes.InsertWish(us, Long.parseLong(hsr.getParameter("id")), Long.parseLong("1")); 
                    }
                }
            }else{
                ArrayList<ModeloWishlist> wishlist = new ArrayList<>();
                wishlist.add(artic);
                hsr.getSession().setAttribute("wishlist", wishlist);
                if(hsr.getSession().getAttribute("userid")!=null){
                    int usconv = (int) hsr.getSession().getAttribute("userid");
                    Long us = Long.parseLong(String.valueOf(usconv));
                    reposes.InsertWish(us, Long.parseLong(hsr.getParameter("id")), Long.parseLong("1"));
                }
            }
        }
        if(hsr.getSession().getAttribute("wishlist")!=null){
            view.addObject("wish", hsr.getSession().getAttribute("wishlist"));
        }else{
            view.addObject("wish", null);
        }
        if(hsr.getSession().getAttribute("userid")!=null){
            view.addObject("userid", hsr.getSession().getAttribute("userid"));
        }
        return view;
    }
    
}
