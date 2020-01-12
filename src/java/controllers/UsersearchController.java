
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryCheckAdv;
import repositories.RepositorySession;


public class UsersearchController implements Controller{
    RepositoryCheckAdv repoc;
    RepositorySession reposes;
    
    public UsersearchController(){
        this.repoc = new RepositoryCheckAdv();
        this.reposes = new RepositorySession();
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView("secure/usersearch");
        if(hsr.getSession().getAttribute("userid")!=null){
            if((int)hsr.getSession().getAttribute("userid")==Integer.parseInt("1")){
                view.addObject("message", null);
                if(hsr.getParameter("userid")!=null){
                    hsr.getSession().setAttribute("usercurrent", Integer.parseInt(hsr.getParameter("userid")));
                        if(reposes.getOneCliente(Integer.parseInt(hsr.getParameter("userid")))!=null){
                            view.addObject("users", reposes.getOneCliente(Integer.parseInt(hsr.getParameter("userid"))));
                        }
                        if(repoc.getTodosPedidos(Long.parseLong(hsr.getParameter("userid")))!=null){
                            view.addObject("orderlist", repoc.getTodosPedidos(Long.parseLong(hsr.getParameter("userid"))));
                        }
                        if(!repoc.getAdminReviewOneClient(Long.parseLong(hsr.getParameter("userid"))).isEmpty()){
                            view.addObject("reviewlist", repoc.getAdminReviewOneClient(Long.parseLong(hsr.getParameter("userid"))));
                        }
                    
                        
                        
                }
                if(hsr.getParameter("del")!=null){
                        repoc.DeleteCliente(Long.parseLong(hsr.getParameter("del")));
                        view.addObject("message", "You deleted one user successfully");
                    }
                if(hsr.getParameter("idcli")!=null){
                    repoc.DeleteReview(Long.parseLong(hsr.getParameter("idcli")), Long.parseLong(hsr.getParameter("erase")));
                    view.addObject("message", "You removed one review successfully");
                    int usercur = (int) hsr.getSession().getAttribute("usercurrent");
                        Long usercurl = Long.parseLong(String.valueOf(usercur));
                        if(reposes.getOneCliente(usercur)!=null){
                            view.addObject("users", reposes.getOneCliente(usercur));
                        }
                        if(repoc.getTodosPedidos(usercurl)!=null){
                            view.addObject("orderlist", repoc.getTodosPedidos(usercurl));
                        }
                        if(!repoc.getAdminReviewOneClient(usercurl).isEmpty()){
                            view.addObject("reviewlist", repoc.getAdminReviewOneClient(usercurl));
                        }
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
