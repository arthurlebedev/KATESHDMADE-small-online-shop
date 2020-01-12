
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryCheckAdv;


public class AdminordersController implements Controller{
    RepositoryCheckAdv repoc;
    
    public AdminordersController(){
        this.repoc = new RepositoryCheckAdv();
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView("secure/adminorders");
        if(hsr.getSession().getAttribute("userid")!=null){
            if((int)hsr.getSession().getAttribute("userid")==Integer.parseInt("1")){
                if(hsr.getParameter("update")!=null){
                    repoc.UpdateOrderStatus(Long.parseLong(hsr.getParameter("update")));
                }
                if(!repoc.getAdminOrders().isEmpty()){
                    view.addObject("orderlist", repoc.getAdminOrders());
                }else{
                    view.addObject("orderlist", null);
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
