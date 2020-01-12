
package controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ModeloCarSes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import pojos.Carritopro;
import pojos.Clientespro;
import repositories.RepositoryCheckAdv;
import repositories.RepositorySession;


public class CheckoutController implements Controller{
    RepositorySession repo;
    RepositoryCheckAdv repoc;
    
    public CheckoutController(){
        this.repo = new RepositorySession();
        this.repoc = new RepositoryCheckAdv();
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView("secure/checkout");
        int idcli = (int) hsr.getSession().getAttribute("userid");
        Clientespro cli = repo.getOneCliente(idcli);
        view.addObject("cliente", cli);
        if(hsr.getParameter("message")!=null){
            ArrayList<ModeloCarSes> list = (ArrayList<ModeloCarSes>) hsr.getSession().getAttribute("cart");
            Long total = Long.parseLong("0");
            for (ModeloCarSes mod: list){
                total += mod.getPrecio()*mod.getCantidad();
            }
            Long idcli2 = Long.parseLong(String.valueOf(idcli));
            ArrayList<Carritopro> cartlist = (ArrayList<Carritopro>) repo.gettodosCarrito(idcli2);
            repoc.InsertOrder(idcli2, total, hsr.getParameter("message"), cartlist, hsr.getParameter("pays"));
            hsr.getSession().removeAttribute("cart");
            view.addObject("checkorder", "1");
        }else{
            view.addObject("checkorder", null);
        }
        return view;
    }
    
}
