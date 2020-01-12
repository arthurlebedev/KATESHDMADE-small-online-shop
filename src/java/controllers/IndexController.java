
package controllers;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryGeneral;


public class IndexController implements Controller {
    RepositoryGeneral repo;

    
    public IndexController(){
        this.repo = new RepositoryGeneral();
        
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView("index");
        if (hsr.getParameter("quick")!=null){
            ModelAndView view2 = new ModelAndView("quick");
            view2.addObject("artic", repo.getOneArticle(Integer.parseInt(hsr.getParameter("quick"))));
            view2.addObject("stars", repo.getStarsMedia(Integer.parseInt(hsr.getParameter("quick"))));
            if (!repo.getOneArticle(Integer.parseInt(hsr.getParameter("quick"))).getPass().equalsIgnoreCase("false")){
                view2.addObject("params", repo.getParamArticle(Integer.parseInt(hsr.getParameter("quick"))));
            }
            return view2;
        }
        view.addObject("popular", repo.buscarArticulosPopulares());
        return view;
    }
    
}
