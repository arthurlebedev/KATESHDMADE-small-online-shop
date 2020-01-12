
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryGeneral;
import repositories.RepositoryShop;


public class ShopController implements Controller{
    RepositoryGeneral repo;
    RepositoryShop reposhop;
    
    public ShopController(){
        this.repo = new RepositoryGeneral();
        this.reposhop = new RepositoryShop();
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView("shop");
        if(hsr.getParameter("searchengine")!=null){
            view.addObject("todo", reposhop.getSeacrh(hsr.getParameter("searchengine")));
            view.addObject("catlist", reposhop.getCategoriesCount());
            view.addObject("procount", reposhop.getCountAll());
            return view;
        }
        if (hsr.getParameter("reset")!=null){
            hsr.getSession().removeAttribute("min");
            hsr.getSession().removeAttribute("max");
        }
        if (hsr.getParameter("quick")!=null){
            ModelAndView view2 = new ModelAndView("quickshop");
            view2.addObject("artic", repo.getOneArticle(Integer.parseInt(hsr.getParameter("quick"))));
            view2.addObject("stars", repo.getStarsMedia(Integer.parseInt(hsr.getParameter("quick"))));
            
            if (!repo.getOneArticle(Integer.parseInt(hsr.getParameter("quick"))).getPass().equalsIgnoreCase("false")){
                view2.addObject("params", repo.getParamArticle(Integer.parseInt(hsr.getParameter("quick"))));
            }
            return view2;
        }
        if (hsr.getParameter("cat")!=null||hsr.getSession().getAttribute("cat")!=null){
            String checkcat;
            if (hsr.getParameter("cat")!=null){
                checkcat = hsr.getParameter("cat");
            }else{
                checkcat = (String) hsr.getSession().getAttribute("cat");
            }
            hsr.getSession().setAttribute("cat", checkcat);
            view.addObject("categ", checkcat);
            if(hsr.getParameter("combosort")!=null||hsr.getSession().getAttribute("combo")!=null){
                String checkcombo;
                if (hsr.getParameter("combosort")!=null){
                    checkcombo = hsr.getParameter("combosort");
                }else{
                    checkcombo = (String) hsr.getSession().getAttribute("combo");
                }
                hsr.getSession().setAttribute("combo", checkcombo);
                view.addObject("combosort", checkcombo);
                if(hsr.getParameter("amountmin")!=null||hsr.getSession().getAttribute("min")!=null){
                    String min;
                    String max;
                    if (hsr.getParameter("amountmin")!=null){
                        min = hsr.getParameter("amountmin");
                        max = hsr.getParameter("amountmax");
                    }else{
                        min = (String) hsr.getSession().getAttribute("min");
                        max = (String) hsr.getSession().getAttribute("max");
                    }
                    hsr.getSession().setAttribute("min", min);
                    hsr.getSession().setAttribute("max", max);
                    if(!checkcat.equalsIgnoreCase("all")){
                        view.addObject("todo", reposhop.gettodosArticulosMultipleTRESOptions(checkcat, Integer.parseInt(min), Integer.parseInt(max), checkcombo));
                    }else{
                        view.addObject("todo", reposhop.gettodosArticulosMultipleOrderPrecio(Integer.parseInt(min), Integer.parseInt(max), checkcombo));
                    }
                }else{
                    if(!checkcat.equalsIgnoreCase("all")){
                        view.addObject("todo", reposhop.gettodosArticulosMultipleTRESOptions(checkcat, 1, 99, checkcombo));
                    }else{
                        view.addObject("todo", reposhop.gettodosArticulosMultipleOrderPrecio(1, 99, checkcombo));
                    }
                }
            }else{
                if(hsr.getParameter("amountmin")!=null||hsr.getSession().getAttribute("min")!=null){
                    String min;
                    String max;
                    if (hsr.getParameter("amountmin")!=null){
                        min = hsr.getParameter("amountmin");
                        max = hsr.getParameter("amountmax");
                    }else{
                        min = (String) hsr.getSession().getAttribute("min");
                        max = (String) hsr.getSession().getAttribute("max");
                    }
                    hsr.getSession().setAttribute("min", min);
                    hsr.getSession().setAttribute("max", max);
                    if(!checkcat.equalsIgnoreCase("all")){
                        view.addObject("todo", reposhop.gettodosArticulosMultipleTRESOptions(checkcat, Integer.parseInt(min), Integer.parseInt(max), "1"));
                    }else{
                        view.addObject("todo", reposhop.gettodosArticulosMultipleOrderPrecio(Integer.parseInt(min), Integer.parseInt(max), "1"));
                    }
                }else{
                    if(!checkcat.equalsIgnoreCase("all")){
                        view.addObject("todo", reposhop.gettodosArticulosMultipleTRESOptions(checkcat, 1, 99, "1"));
                    }else{
                        view.addObject("todo", repo.gettodosArticulos());
                    }
                }
            }
        }else{
            if(hsr.getParameter("combosort")!=null||hsr.getSession().getAttribute("combo")!=null){
                String checkcombo;
                if (hsr.getParameter("combosort")!=null){
                    checkcombo = hsr.getParameter("combosort");
                }else{
                    checkcombo = (String) hsr.getSession().getAttribute("combo");
                }
                hsr.getSession().setAttribute("combo", checkcombo);
                view.addObject("combosort", checkcombo);
                if(hsr.getParameter("amountmin")!=null||hsr.getSession().getAttribute("min")!=null){
                    String min;
                    String max;
                    if (hsr.getParameter("amountmin")!=null){
                        min = hsr.getParameter("amountmin");
                        max = hsr.getParameter("amountmax");
                    }else{
                        min = (String) hsr.getSession().getAttribute("min");
                        max = (String) hsr.getSession().getAttribute("max");
                    }
                    hsr.getSession().setAttribute("min", min);
                    hsr.getSession().setAttribute("max", max);
                    view.addObject("todo", reposhop.gettodosArticulosMultipleOrderPrecio(Integer.parseInt(min), Integer.parseInt(max), checkcombo));
                }else{
                    view.addObject("todo", reposhop.gettodosArticulosMultipleOrderPrecio(1, 99, checkcombo));
                }
                
            }else{
                if(hsr.getParameter("amountmin")!=null||hsr.getSession().getAttribute("min")!=null){
                    String min;
                    String max;
                    if (hsr.getParameter("amountmin")!=null){
                        min = hsr.getParameter("amountmin");
                        max = hsr.getParameter("amountmax");
                    }else{
                        min = (String) hsr.getSession().getAttribute("min");
                        max = (String) hsr.getSession().getAttribute("max");
                    }
                    hsr.getSession().setAttribute("min", min);
                    hsr.getSession().setAttribute("max", max);
                    view.addObject("todo", reposhop.gettodosArticulosMultiplePrecio(Integer.parseInt(min), Integer.parseInt(max)));
                }else{
                    view.addObject("todo", repo.gettodosArticulos());
                    view.addObject("categ", "all");
                }
            }
        }
        view.addObject("catlist", reposhop.getCategoriesCount());
        view.addObject("procount", reposhop.getCountAll());
        return view;
    }
}