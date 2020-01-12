package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ModeloCarSes;
import models.ModeloWishlist;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import pojos.Articulospro;
import pojos.Carritopro;
import pojos.Clientespro;
import pojos.Wishlistpro;
import repositories.RepositoryGeneral;
import repositories.RepositorySession;


public class LoginController implements Controller, Serializable{
    RepositorySession repo;
    RepositoryGeneral repog;
    
    public LoginController(){
        this.repo = new RepositorySession();
        this.repog = new RepositoryGeneral();
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView();
        view.addObject("noexiste", null);
        if(hsr.getParameter("mail")!=null){
            Clientespro cliente = repo.getCheckPass(hsr.getParameter("mail"), hsr.getParameter("pass"));
            if(cliente!=null){
                hsr.getSession().setAttribute("userid", cliente.getIdcliente());
                int usconv = (int) hsr.getSession().getAttribute("userid");
                Long us = Long.parseLong(String.valueOf(usconv));
                if(hsr.getSession().getAttribute("wishlist")!=null){
                    ArrayList<ModeloWishlist> wishlist = (ArrayList<ModeloWishlist>) hsr.getSession().getAttribute("wishlist");
                    ArrayList<Wishlistpro> wishbbdd = (ArrayList<Wishlistpro>) repo.gettodosWish(us);
                    ArrayList<ModeloWishlist> wishcheck = new ArrayList<>();
                    if(!wishbbdd.isEmpty()){
                        for (ModeloWishlist wishmodelo: wishlist){
                            for(Wishlistpro wishpro: wishbbdd){
                                if(wishmodelo.getIdarticulo()==wishpro.getId().getIdarticulo()){
                                    if(wishmodelo.getQuantity().intValue()==wishpro.getQuantity()){
                                        
                                    }else{
                                        if(wishmodelo.getQuantity()<wishpro.getQuantity()){
                                            
                                        }else{
                                            repo.UpdateWish(us, wishmodelo.getIdarticulo(), wishmodelo.getQuantity());
                                        }
                                    }
                                    wishcheck.add(wishmodelo);
                                }
                            }
                        }
                        if(!wishcheck.isEmpty()){
                            for (ModeloWishlist check: wishcheck){
                                wishlist.remove(check);
                            }
                            for (ModeloWishlist add: wishlist){
                                repo.InsertWish(us, add.getIdarticulo(), add.getQuantity());
                            }
                        }else{
                            for (ModeloWishlist add: wishlist){
                                repo.InsertWish(us, add.getIdarticulo(), add.getQuantity());
                            }    
                        }
                    }else{
                        for (ModeloWishlist add: wishlist){
                            repo.InsertWish(us, add.getIdarticulo(), add.getQuantity());
                        } 
                    }    
                    hsr.getSession().removeAttribute("wishlist");
                }else{
                    if(!repo.gettodosWish(us).isEmpty()&&hsr.getSession().getAttribute("wishlist")==null){
                        ArrayList<Wishlistpro> wishpro = (ArrayList<Wishlistpro>) repo.gettodosWish(us);
                        ArrayList<ModeloWishlist> wishmod = new ArrayList<>();
                        for(Wishlistpro wpro:wishpro){
                            ModeloWishlist wmod = new ModeloWishlist();
                            int idart = wpro.getId().getIdarticulo();
                            wmod = repog.getArticleWishlist(idart);
                            wmod.setQuantity(wpro.getQuantity().longValue());
                            wishmod.add(wmod);
                        }
                        hsr.getSession().setAttribute("wishlist", wishmod);
                    }
                }
                if(hsr.getSession().getAttribute("cart")!=null){
                    ArrayList<Carritopro> carpro = (ArrayList<Carritopro>) repo.gettodosCarrito(us);
                    ArrayList<ModeloCarSes> carmod = (ArrayList<ModeloCarSes>) hsr.getSession().getAttribute("cart");
                    ArrayList<ModeloCarSes> check = new ArrayList<>();
                    if(!carpro.isEmpty()){
                        for(ModeloCarSes mod:carmod){
                            for(Carritopro pro:carpro){
                                if(mod.getIdarticulo()==pro.getArticulospro().getIdarticulo()){
                                    if(mod.getAdd1().equalsIgnoreCase(pro.getAdd1())&&mod.getAdd2().equalsIgnoreCase(pro.getAdd2())&&mod.getAdd3().equalsIgnoreCase(pro.getAdd3())&&mod.getAdd4().equalsIgnoreCase(pro.getAdd4())){
                                         if(mod.getCantidad()!=pro.getCantidad()){
                                             if(mod.getCantidad()>pro.getCantidad()){
                                                 repo.UpdateCarrito(repo.getCurrentIdCart(us, mod.getIdarticulo(), mod.getAdd1(), mod.getAdd2(), mod.getAdd3(), mod.getAdd4()), mod.getCantidad());
                                             }
                                         }
                                         check.add(mod);
                                    }
                                }
                            }
                        }
                        if(!check.isEmpty()){
                            for(ModeloCarSes mod:check){
                                carmod.remove(mod);
                            }
                            for(ModeloCarSes mod:carmod){
                                Carritopro c = new Carritopro();
                                c.setIdcart(repog.getNextIdCart().intValue());
                                c.setClientespro(repo.getOneCliente(us.intValue()));
                                Long idart = mod.getIdarticulo();
                                c.setArticulospro(repog.getOneArticle(idart.intValue()));
                                Long cant = Long.parseLong(String.valueOf(mod.getCantidad()));
                                c.setCantidad(cant.intValue());
                                c.setFoto1(mod.getFoto1());
                                c.setAdd1(mod.getAdd1());
                                c.setAdd2(mod.getAdd2());
                                c.setAdd3(mod.getAdd3());
                                c.setAdd4(mod.getAdd4());
                                repo.InsertCarrito(c);
                            }
                            ArrayList<Carritopro> carpr = (ArrayList<Carritopro>) repo.gettodosCarrito(us);
                            if(!carpr.isEmpty()){
                                ArrayList<ModeloCarSes> modif = new ArrayList<>();
                                for(Carritopro pro:carpr){
                                    ModeloCarSes m = new ModeloCarSes();
                                    int idart = pro.getArticulospro().getIdarticulo();
                                    Articulospro art = repog.getOneArticle(idart);
                                    m.setIdarticulo(pro.getArticulospro().getIdarticulo());
                                    m.setNombre(art.getNombre());
                                    m.setPrecio(art.getPrecio());
                                    m.setFoto1(pro.getFoto1());
                                    m.setCantidad(pro.getCantidad());
                                    m.setAdd1(pro.getAdd1());
                                    m.setAdd2(pro.getAdd2());
                                    m.setAdd3(pro.getAdd3());
                                    m.setAdd4(pro.getAdd4());
                                    modif.add(m);
                                }
                                hsr.getSession().setAttribute("cart", modif);
                            }
                        }else{
                            for(ModeloCarSes mod:carmod){
                                Carritopro c = new Carritopro();
                                c.setIdcart(repog.getNextIdCart().intValue());
                                c.setClientespro(repo.getOneCliente(us.intValue()));
                                Long idart = mod.getIdarticulo();
                                c.setArticulospro(repog.getOneArticle(idart.intValue()));
                                Long cant = Long.parseLong(String.valueOf(mod.getCantidad()));
                                c.setCantidad(cant.intValue());
                                c.setFoto1(mod.getFoto1());
                                c.setAdd1(mod.getAdd1());
                                c.setAdd2(mod.getAdd2());
                                c.setAdd3(mod.getAdd3());
                                c.setAdd4(mod.getAdd4());
                                repo.InsertCarrito(c);
                            }
                            ArrayList<Carritopro> carpr = (ArrayList<Carritopro>) repo.gettodosCarrito(us);
                            if(!carpr.isEmpty()){
                                ArrayList<ModeloCarSes> modif = new ArrayList<>();
                                for(Carritopro pro:carpr){
                                    ModeloCarSes m = new ModeloCarSes();
                                    int idart = pro.getArticulospro().getIdarticulo();
                                    Articulospro art = repog.getOneArticle(idart);
                                    m.setIdarticulo(pro.getArticulospro().getIdarticulo());
                                    m.setNombre(art.getNombre());
                                    m.setPrecio(art.getPrecio());
                                    m.setFoto1(pro.getFoto1());
                                    m.setCantidad(pro.getCantidad());
                                    m.setAdd1(pro.getAdd1());
                                    m.setAdd2(pro.getAdd2());
                                    m.setAdd3(pro.getAdd3());
                                    m.setAdd4(pro.getAdd4());
                                    modif.add(m);
                                }
                                hsr.getSession().setAttribute("cart", modif);
                            }
                        }
                    }else{
                        for(ModeloCarSes mod:carmod){
                            Carritopro c = new Carritopro();
                            c.setIdcart(repog.getNextIdCart().intValue());
                            c.setClientespro(repo.getOneCliente(us.intValue()));
                            Long idart = mod.getIdarticulo();
                            c.setArticulospro(repog.getOneArticle(idart.intValue()));
                            Long cant = Long.parseLong(String.valueOf(mod.getCantidad()));
                            c.setCantidad(cant.intValue());
                            c.setFoto1(mod.getFoto1());
                            c.setAdd1(mod.getAdd1());
                            c.setAdd2(mod.getAdd2());
                            c.setAdd3(mod.getAdd3());
                            c.setAdd4(mod.getAdd4());
                            repo.InsertCarrito(c);
                        }
                    }
                }else{
                    ArrayList<Carritopro> carpro = (ArrayList<Carritopro>) repo.gettodosCarrito(us);
                    if(!carpro.isEmpty()){
                        ArrayList<ModeloCarSes> modif = new ArrayList<>();
                        for(Carritopro pro:carpro){
                            ModeloCarSes m = new ModeloCarSes();
                            int idart = pro.getArticulospro().getIdarticulo();
                            Articulospro art = repog.getOneArticle(idart);
                            m.setIdarticulo(pro.getArticulospro().getIdarticulo());
                            m.setNombre(art.getNombre());
                            m.setPrecio(art.getPrecio());
                            m.setFoto1(pro.getFoto1());
                            m.setCantidad(pro.getCantidad());
                            m.setAdd1(pro.getAdd1());
                            m.setAdd2(pro.getAdd2());
                            m.setAdd3(pro.getAdd3());
                            m.setAdd4(pro.getAdd4());
                            modif.add(m);
                        }
                        hsr.getSession().setAttribute("cart", modif);
                    }
                }
                if(hsr.getParameter("checkout")!=null){
                    return new ModelAndView("forward:/checkout.htm");
                }else{
                    return new ModelAndView("forward:/index.htm");
                } 
            }else{
                view.addObject("noexiste", "1");
            }
        }
        
        if(hsr.getParameter("namereg")!=null){
            hsr.getSession().setAttribute("userid", repo.InsertClient(hsr.getParameter("namereg"), hsr.getParameter("emailreg"), hsr.getParameter("passreg")));
            int usconv = (int) hsr.getSession().getAttribute("userid");
            Long us = Long.parseLong(String.valueOf(usconv));
                if(hsr.getSession().getAttribute("wishlist")!=null){
                    ArrayList<ModeloWishlist> wishlist = (ArrayList<ModeloWishlist>) hsr.getSession().getAttribute("wishlist");
                    ArrayList<Wishlistpro> wishbbdd = (ArrayList<Wishlistpro>) repo.gettodosWish(us);
                    ArrayList<ModeloWishlist> wishcheck = null;
                    for (ModeloWishlist wishmodelo: wishlist){
                        for(Wishlistpro wishpro: wishbbdd){
                            if(wishmodelo.getIdarticulo()==wishpro.getId().getIdarticulo()){
                                repo.UpdateWish(us, wishmodelo.getIdarticulo(), wishmodelo.getQuantity()+wishpro.getQuantity());
                                wishcheck.add(wishmodelo);
                            }
                        }
                    }
                    if(wishcheck!=null){
                        for (ModeloWishlist check: wishcheck){
                            wishlist.remove(check);
                        }
                        for (ModeloWishlist add: wishlist){
                            repo.InsertWish(us, add.getIdarticulo(), add.getQuantity());
                        }
                    }else{
                        for (ModeloWishlist add: wishlist){
                            repo.InsertWish(us, add.getIdarticulo(), add.getQuantity());
                        }    
                    }
                    hsr.getSession().removeAttribute("wishlist");
                }
                if(hsr.getSession().getAttribute("cart")!=null){
                    ArrayList<ModeloCarSes> carmod = (ArrayList<ModeloCarSes>) hsr.getSession().getAttribute("cart");
                    ArrayList<ModeloCarSes> check = new ArrayList<>();
                        for(ModeloCarSes mod:carmod){
                            Carritopro c = new Carritopro();
                            c.setIdcart(repog.getNextIdCart().intValue());
                            c.setClientespro(repo.getOneCliente(us.intValue()));
                            Long idart = mod.getIdarticulo();
                            c.setArticulospro(repog.getOneArticle(idart.intValue()));
                            Long cant = Long.parseLong(String.valueOf(mod.getCantidad()));
                            c.setCantidad(cant.intValue());
                            c.setFoto1(mod.getFoto1());
                            c.setAdd1(mod.getAdd1());
                            c.setAdd2(mod.getAdd2());
                            c.setAdd3(mod.getAdd3());
                            c.setAdd4(mod.getAdd4());
                            repo.InsertCarrito(c);
                        }
                    
                }
            if(hsr.getParameter("checkout")!=null){
                return new ModelAndView("forward:/checkout.htm");
            }else{
                return new ModelAndView("forward:/account.htm");
            }    
        }
        if(hsr.getParameter("checkout")!=null){
            view.addObject("checkout", "1");
        }else{
            view.addObject("checkout", null);
        }
        return view;
    }
    
}
