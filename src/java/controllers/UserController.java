
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryCheckAdv;


public class UserController implements Controller{
    RepositoryCheckAdv repo;
    
    public UserController(){
        this.repo = new RepositoryCheckAdv();
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView("secure/users");
        if(hsr.getSession().getAttribute("userid")!=null){
            if((int)hsr.getSession().getAttribute("userid")==Integer.parseInt("1")){
                if(hsr.getParameter("erase")!=null){
                    repo.DeleteCliente(Long.parseLong(hsr.getParameter("erase")));
                }
                view.addObject("users", repo.gettodosClientes());
                return view;
            }else{
                return new ModelAndView("forward:/index.htm");
            }
        }else{
            return new ModelAndView("forward:/index.htm");
        }    
    }
    
}
