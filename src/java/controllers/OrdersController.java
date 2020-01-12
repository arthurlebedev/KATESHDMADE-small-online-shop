
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryCheckAdv;


public class OrdersController implements Controller{
    RepositoryCheckAdv repo;
    
    public OrdersController(){
        this.repo = new RepositoryCheckAdv();
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView("secure/orders");
        if(hsr.getSession().getAttribute("userid")!=null){
            int idcliconv = (int) hsr.getSession().getAttribute("userid");
            Long idcli = Long.parseLong(String.valueOf(idcliconv));
            view.addObject("userid", idcli);
            if(!repo.getTodosPedidos(idcli).isEmpty()){
                view.addObject("orderlist", repo.getTodosPedidos(idcli));
            }else{
               view.addObject("orderlist", null); 
            }
            return view;
        }else{
            return new ModelAndView("forward:/index.htm");
        }
    }
    
}
