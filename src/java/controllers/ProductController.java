
package controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ModeloAllReview;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryGeneral;
import repositories.RepositorySession;
import repositories.RepositoryShop;


public class ProductController implements Controller{
    RepositoryGeneral repo;
    RepositoryShop reposhop;
    RepositorySession reposes;
    
    public ProductController(){
        this.repo = new RepositoryGeneral();
        this.reposhop = new RepositoryShop();
        this.reposes = new RepositorySession();
        
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView("product");
        if(hsr.getParameter("check")!=null){
            view.addObject("che", "1");
        }else{
            view.addObject("che", null);
        }
        if(hsr.getSession().getAttribute(hsr.getParameter("tit"))!=null){
            Long num = (Long)hsr.getSession().getAttribute(hsr.getParameter("tit"));
            String vov = null;
            switch(num.intValue()){
                case 8:
                    vov = "seventh to last";
                break;
                case 7:
                    vov = "sixth to last";
                break;
                case 6:
                    vov = "fifth to last";
                break;
                case 5:
                    vov = "fourth to last";
                break;
                case 4:
                    vov = "third to last";
                break;
                case 3:
                    vov = "second to last";
                break;
                case 2:
                    vov = "first to last";
                break;
                default:
                    vov= "last";
                break;
            }
            view.addObject("wishal", "Choose all parameters to add this <span style='font-weight:bold'>"+vov.toUpperCase()+"</span> item to cart from your wishlist");
        }else{
            view.addObject("wishal", null);
        }
        if(hsr.getParameter("ratestars")!=null){
            int usconv = (int) hsr.getSession().getAttribute("userid");
            Long us = Long.parseLong(String.valueOf(usconv));
            Long art = (Long) hsr.getSession().getAttribute("idarticul");
            reposes.InsertReview(us, art, Integer.parseInt(hsr.getParameter("ratestars")), hsr.getParameter("texta"));
        }
        if(hsr.getParameter("erase")!=null){
            Long us = Long.parseLong(hsr.getParameter("erase"));
            Long art = (Long) hsr.getSession().getAttribute("idarticul");
            reposes.DeleteReview(us, art);
        }
        if(hsr.getParameter("id")!=null){
            view.addObject("oneart", repo.getOneArticle(Integer.parseInt(hsr.getParameter("id"))));
            view.addObject("stars", repo.getStarsMedia(Integer.parseInt(hsr.getParameter("id"))));
            hsr.getSession().setAttribute("idarticul", Long.parseLong(hsr.getParameter("id")));
            if (!repo.getOneArticle(Integer.parseInt(hsr.getParameter("id"))).getPass().equalsIgnoreCase("false")){
                view.addObject("params", repo.getParamArticle(Integer.parseInt(hsr.getParameter("id"))));
            }
            view.addObject("reviews", repo.getAllReview(Integer.parseInt(hsr.getParameter("id"))));
            if(hsr.getSession().getAttribute("userid")!=null){
                int usconv = (int) hsr.getSession().getAttribute("userid");
                Long us = Long.parseLong(String.valueOf(usconv));
                view.addObject("client", reposes.getOneCliente(us.intValue()));
                view.addObject("reviewcheck", repo.getReviewCheck(us, Long.parseLong(hsr.getParameter("id"))));
            }
        }else{
            Long art = (Long) hsr.getSession().getAttribute("idarticul");
            view.addObject("oneart", repo.getOneArticle(art.intValue()));
            view.addObject("stars", repo.getStarsMedia(art.intValue()));
            hsr.getSession().setAttribute("idarticul", art);
            if (!repo.getOneArticle(art.intValue()).getPass().equalsIgnoreCase("false")){
                view.addObject("params", repo.getParamArticle(art.intValue()));
            }
            view.addObject("reviews", repo.getAllReview(art.intValue()));
            if(hsr.getSession().getAttribute("userid")!=null){
                int us = (int) hsr.getSession().getAttribute("userid");
                view.addObject("client", reposes.getOneCliente(us));
                Long us2 = Long.parseLong(String.valueOf(us));
                view.addObject("reviewcheck", repo.getReviewCheck(us2, art));
            }
        }
        return view;
    }
    
}
