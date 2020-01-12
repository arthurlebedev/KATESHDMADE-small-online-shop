
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import pojos.Clientespro;
import repositories.RepositorySession;


public class AccountController implements Controller{
    RepositorySession repo;
    
    public AccountController(){
        this.repo = new RepositorySession();
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView("secure/account");
        view.addObject("message", null);
        if(hsr.getParameter("logout")!=null){
                hsr.getSession().removeAttribute("userid");
        }
        
        if(hsr.getParameter("username")!=null){
            int usidconv = (int)hsr.getSession().getAttribute("userid");
            Long usid = Long.parseLong(String.valueOf(usidconv));        
            Clientespro cliente = repo.getCheckCurrentPass(usid, hsr.getParameter("passconfirm"));
            if(cliente!=null){
                if(!hsr.getParameter("newpass").equalsIgnoreCase("")||!hsr.getParameter("newpass2").equalsIgnoreCase("")){
                    if(hsr.getParameter("newpass").equals(hsr.getParameter("newpass2"))){
                        int idusconv = (int) hsr.getSession().getAttribute("userid");
                        Long idus = Long.parseLong(String.valueOf(idusconv));
                        repo.UpdateClient(hsr.getParameter("username"), hsr.getParameter("usercard"), hsr.getParameter("dir"), hsr.getParameter("tel"), hsr.getParameter("mail"), hsr.getParameter("newpass"), idus);
                        view.addObject("message", "SUCCESSFULL UPDATE");
                    }else{
                       view.addObject("message", "NEW PASSWORDS ARE DIFFERENT"); 
                    }
                }else{
                    repo.UpdateClient(hsr.getParameter("username"), hsr.getParameter("usercard"), hsr.getParameter("dir"), hsr.getParameter("tel"), hsr.getParameter("mail"), hsr.getParameter("passconfirm"), usid);
                    view.addObject("message", "SUCCESSFULL UPDATE");  
                }
            }else{
                view.addObject("message", "YOUR CURRENT PASSWORD IS INCORRECT");
            }
        }
        
        if(hsr.getSession().getAttribute("userid")!=null){
            int iduserconv = (int) hsr.getSession().getAttribute("userid");
            Long iduser = Long.parseLong(String.valueOf(iduserconv));
            view.addObject("cliente", repo.getOneCliente(iduser.intValue()));
            view.addObject("userid", iduser);
        }else{
            return new ModelAndView("forward:/index.htm");
        }
        
        return view;
    }
    
}
