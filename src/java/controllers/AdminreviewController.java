
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryCheckAdv;


public class AdminreviewController implements Controller{
    RepositoryCheckAdv repoc;
    
    public AdminreviewController(){
        this.repoc = new RepositoryCheckAdv();
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView("secure/adminreview");
        if(hsr.getSession().getAttribute("userid")!=null){
            if((int)hsr.getSession().getAttribute("userid")==Integer.parseInt("1")){
                view.addObject("reviewlist", null);
                view.addObject("message", null);
                if(hsr.getParameter("erase")!=null){
                    repoc.DeleteReview(Long.parseLong(hsr.getParameter("idcli")), Long.parseLong(hsr.getParameter("erase")));
                    view.addObject("message", "You removed one review successfully");
                }
                if(!repoc.getAdminReview().isEmpty()){
                    view.addObject("reviewlist", repoc.getAdminReview());
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
