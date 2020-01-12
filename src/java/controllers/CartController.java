
package controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ModeloCarSes;
import models.ModeloWishlist;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import pojos.Articulospro;
import pojos.Carritopro;
import repositories.RepositoryGeneral;
import repositories.RepositorySession;


public class CartController implements Controller{
    RepositoryGeneral repo;
    RepositorySession reposes;
    
    public CartController(){
        this.repo = new RepositoryGeneral();
        this.reposes = new RepositorySession();
    }
    
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView view = new ModelAndView();
        
        if(hsr.getParameter("wish")!=null){
            Articulospro artic = repo.getOneArticle(Integer.parseInt(hsr.getParameter("id")));
            if(!artic.getPass().equalsIgnoreCase("false")){
                hsr.getSession().setAttribute("wishcheck"+hsr.getParameter("id"), Long.parseLong(hsr.getParameter("wishquant")));
                return new ModelAndView("forward:/product.htm?tit=wishcheck"+hsr.getParameter("id"));
            }
        }
        
        if(hsr.getParameter("logout")!=null){
                hsr.getSession().removeAttribute("userid");
        }
        
        view.addObject("us", null);
        if(hsr.getSession().getAttribute("userid")!=null){
            view.addObject("us", "1");
        }
        
        if(hsr.getParameter("quant")!=null){
            ArrayList<ModeloCarSes> listart = (ArrayList<ModeloCarSes>) hsr.getSession().getAttribute("cart");
            ArrayList<ModeloCarSes> check = new ArrayList<>();
            ArrayList<ModeloCarSes> modif = new ArrayList<>();
            for (ModeloCarSes mod:listart){
                if(mod.getIdarticulo()==Long.parseLong(hsr.getParameter("id"+String.valueOf(mod.getIdarticulo())))&&mod.getAdd1().equalsIgnoreCase(hsr.getParameter("add1"+String.valueOf(mod.getIdarticulo())+mod.getAdd1()+mod.getAdd2()+mod.getAdd3()+mod.getAdd4()))&&mod.getAdd2().equalsIgnoreCase(hsr.getParameter("add2"+String.valueOf(mod.getIdarticulo())+mod.getAdd1()+mod.getAdd2()+mod.getAdd3()+mod.getAdd4()))&&mod.getAdd3().equalsIgnoreCase(hsr.getParameter("add3"+String.valueOf(mod.getIdarticulo())+mod.getAdd1()+mod.getAdd2()+mod.getAdd3()+mod.getAdd4()))&&mod.getAdd4().equalsIgnoreCase(hsr.getParameter("add4"+String.valueOf(mod.getIdarticulo())+mod.getAdd1()+mod.getAdd2()+mod.getAdd3()+mod.getAdd4()))){
                    if(mod.getCantidad()!=Long.parseLong(hsr.getParameter(String.valueOf(mod.getIdarticulo())+mod.getAdd1()+mod.getAdd2()+mod.getAdd3()+mod.getAdd4()))){
                        check.add(mod);
                        mod.setCantidad(Long.parseLong(hsr.getParameter(String.valueOf(mod.getIdarticulo())+mod.getAdd1()+mod.getAdd2()+mod.getAdd3()+mod.getAdd4())));
                        modif.add(mod);
                    }
                }
            }
            for(ModeloCarSes mod:check){
                listart.remove(mod);
            }
            for(ModeloCarSes mod:modif){
                listart.add(mod);
            }
            hsr.getSession().setAttribute("cart", listart);
            if(hsr.getSession().getAttribute("userid")!=null){
                int usconv = (int) hsr.getSession().getAttribute("userid");
                Long us = Long.parseLong(String.valueOf(usconv));
                ArrayList<Carritopro> carpro = (ArrayList<Carritopro>) reposes.gettodosCarrito(us);
                ArrayList<Carritopro> modif2= new ArrayList<>();
                for (Carritopro mod:carpro){
                    if(mod.getArticulospro().getIdarticulo()==Long.parseLong(hsr.getParameter("id"+String.valueOf(mod.getArticulospro().getIdarticulo())))&&mod.getAdd1().equalsIgnoreCase(hsr.getParameter("add1"+String.valueOf(mod.getArticulospro().getIdarticulo())+mod.getAdd1()+mod.getAdd2()+mod.getAdd3()+mod.getAdd4()))&&mod.getAdd2().equalsIgnoreCase(hsr.getParameter("add2"+String.valueOf(mod.getArticulospro().getIdarticulo())+mod.getAdd1()+mod.getAdd2()+mod.getAdd3()+mod.getAdd4()))&&mod.getAdd3().equalsIgnoreCase(hsr.getParameter("add3"+String.valueOf(mod.getArticulospro().getIdarticulo())+mod.getAdd1()+mod.getAdd2()+mod.getAdd3()+mod.getAdd4()))&&mod.getAdd4().equalsIgnoreCase(hsr.getParameter("add4"+String.valueOf(mod.getArticulospro().getIdarticulo())+mod.getAdd1()+mod.getAdd2()+mod.getAdd3()+mod.getAdd4()))){
                        if(mod.getCantidad()!=Long.parseLong(hsr.getParameter(String.valueOf(mod.getArticulospro().getIdarticulo())+mod.getAdd1()+mod.getAdd2()+mod.getAdd3()+mod.getAdd4()))){
                            mod.setCantidad(Integer.parseInt(hsr.getParameter(String.valueOf(mod.getArticulospro().getIdarticulo())+mod.getAdd1()+mod.getAdd2()+mod.getAdd3()+mod.getAdd4())));
                            modif2.add(mod);
                        }
                    }
                }
                for(Carritopro mod:modif2){
                    Long idart = Long.parseLong(String.valueOf(mod.getArticulospro().getIdarticulo()));
                    Long cant = Long.parseLong(String.valueOf(mod.getCantidad()));
                    reposes.UpdateCarrito(reposes.getCurrentIdCart(us, idart, mod.getAdd1(), mod.getAdd2(), mod.getAdd3(), mod.getAdd4()), cant);
                }
            }
        }
        
        if(hsr.getParameter("erase")!=null){
            ArrayList<ModeloCarSes> listart = (ArrayList<ModeloCarSes>) hsr.getSession().getAttribute("cart");
            ModeloCarSes check = new ModeloCarSes();
            for (ModeloCarSes mod:listart){
                if(mod.getIdarticulo()==Long.parseLong(hsr.getParameter("erase"))&&mod.getAdd1().equalsIgnoreCase(hsr.getParameter("add1"))&&mod.getAdd2().equalsIgnoreCase(hsr.getParameter("add2"))&&mod.getAdd3().equalsIgnoreCase(hsr.getParameter("add3"))&&mod.getAdd4().equalsIgnoreCase(hsr.getParameter("add4"))){
                    check = mod;
                }
            }
            listart.remove(check);
            if(listart.size()<1){
                hsr.getSession().setAttribute("cart", null);
            }else{
                hsr.getSession().setAttribute("cart", listart);
            }
            if(hsr.getSession().getAttribute("userid")!=null){
                int usconv = (int) hsr.getSession().getAttribute("userid");
                Long us = Long.parseLong(String.valueOf(usconv));
                reposes.DeleteCarrito(reposes.getCurrentIdCart(us, check.getIdarticulo(), check.getAdd1(), check.getAdd2(), check.getAdd3(), check.getAdd4()));
            }
        }
        
        if(hsr.getParameter("id")!=null){
            Articulospro artic = repo.getOneArticle(Integer.parseInt(hsr.getParameter("id")));
            if(artic.getPass().equalsIgnoreCase("false")){
                ModeloCarSes car = new ModeloCarSes();
                car.setIdarticulo(Long.parseLong(hsr.getParameter("id")));
                car.setFoto1(artic.getFoto1());
                if(hsr.getParameter("wishquant")!=null){
                   car.setCantidad(Long.parseLong(hsr.getParameter("wishquant"))); 
                }else{
                   car.setCantidad(Long.parseLong("1")); 
                }
                car.setPrecio(artic.getPrecio());
                car.setNombre(artic.getNombre());
                car.setAdd1("NONE");
                car.setAdd2("NONE");
                car.setAdd3("NONE");
                car.setAdd4("NONE");
                ArrayList<ModeloCarSes> listart = new ArrayList<>();
                Long idarti = car.getIdarticulo();
                if(hsr.getSession().getAttribute("cart")!=null){
                    listart = (ArrayList<ModeloCarSes>) hsr.getSession().getAttribute("cart");
                    ModeloCarSes check = new ModeloCarSes();
                    ModeloCarSes modif = new ModeloCarSes();
                    for (ModeloCarSes mod:listart){
                        if(mod.getIdarticulo()==idarti){
                            check = mod;
                            mod.setCantidad(mod.getCantidad()+1);
                            modif = mod;
                        }
                    }
                    System.out.println(check.getIdarticulo());
                    if(check.getIdarticulo()!=0){
                        listart.remove(check);
                        car = modif;
                    }
                }
                listart.add(car);  
                hsr.getSession().setAttribute("cart", listart);
                if(hsr.getSession().getAttribute("userid")!=null){
                    int usconv = (int) hsr.getSession().getAttribute("userid");
                    Long us = Long.parseLong(String.valueOf(usconv));
                    Long idart = Long.parseLong(String.valueOf(artic.getIdarticulo()));
                    Long equal = reposes.checkEqualArticCarrito(us, idart, car.getAdd1(), car.getAdd2(), car.getAdd3(), car.getAdd4());
                    Carritopro c = new Carritopro();
                    c.setIdcart(repo.getNextIdCart().intValue());
                    c.setClientespro(reposes.getOneCliente(us.intValue()));
                    c.setArticulospro(artic);
                    c.setFoto1(artic.getFoto1());
                    if(hsr.getParameter("wishquant")!=null){
                       c.setCantidad(Integer.parseInt(hsr.getParameter("wishquant"))); 
                    }else{
                       c.setCantidad(Integer.parseInt("1")); 
                    }
                    c.setAdd1("NONE");
                    c.setAdd2("NONE");
                    c.setAdd3("NONE");
                    c.setAdd4("NONE");
                    Carritopro modif = new Carritopro();
                    ArrayList<Carritopro> prolist = (ArrayList<Carritopro>)reposes.gettodosCarrito(us);
                    if(!prolist.isEmpty()){
                        for(Carritopro cpr:prolist){
                            if(cpr.getArticulospro().getIdarticulo()==artic.getIdarticulo()){
                                cpr.setCantidad(cpr.getCantidad()+1);
                                modif = cpr;
                            }
                        }
                        if(modif.getIdcart()!=0){
                            Long idar = Long.parseLong(String.valueOf(modif.getArticulospro().getIdarticulo()));
                            Long canti = Long.parseLong(String.valueOf(modif.getCantidad()));
                            reposes.UpdateCarrito(reposes.getCurrentIdCart(us, idar, modif.getAdd1(), modif.getAdd2(), modif.getAdd3(), modif.getAdd4()), canti);
                        }else{
                            reposes.InsertCarrito(c);
                        }
                    }else{
                        reposes.InsertCarrito(c);
                    }
                }
                if(hsr.getParameter("wishquant")!=null){
                    ArrayList<ModeloWishlist> wishlist = (ArrayList<ModeloWishlist>) hsr.getSession().getAttribute("wishlist");
                    ModeloWishlist checkw = new ModeloWishlist();
                    for(ModeloWishlist mod:wishlist){
                        if(artic.getIdarticulo()==mod.getIdarticulo()){
                            checkw = mod;
                        }
                    }
                    wishlist.remove(checkw);
                    if(wishlist.isEmpty()){
                       hsr.getSession().setAttribute("wishlist", null); 
                    }else{
                       hsr.getSession().setAttribute("wishlist", wishlist); 
                    }
                    if(hsr.getSession().getAttribute("userid")!=null){
                        int usconv = (int) hsr.getSession().getAttribute("userid");
                        Long us = Long.parseLong(String.valueOf(usconv));
                        Long idartic = Long.parseLong(String.valueOf(artic.getIdarticulo()));
                        reposes.DeleteWish(us, idartic);
                    }
                }
            }else{
                if(hsr.getParameter("text0")!=null||hsr.getParameter("combo0")!=null){
                    String add1 = null;
                    String add2 = null;
                    String add3 = null;
                    String add4 = null;
                    if(hsr.getParameter("combo0")!=null||hsr.getParameter("text0")!=null){
                        if(hsr.getParameter("combo0")!=null){
                            add1= hsr.getParameter("combo0");
                        }else{
                            add1= hsr.getParameter("hidden0")+": "+hsr.getParameter("text0"); 
                        }
                    }
                    if(hsr.getParameter("combo1")!=null||hsr.getParameter("text1")!=null){
                        if(hsr.getParameter("combo1")!=null){
                            add2= hsr.getParameter("combo1");
                        }else{
                            add2= hsr.getParameter("hidden1")+": "+hsr.getParameter("text1"); 
                        }
                    }
                    if(hsr.getParameter("combo2")!=null||hsr.getParameter("text2")!=null){
                        if(hsr.getParameter("combo2")!=null){
                            add3= hsr.getParameter("combo2");
                        }else{
                            add3= hsr.getParameter("hidden2")+": "+hsr.getParameter("text2"); 
                        }
                    }
                    if(hsr.getParameter("combo3")!=null||hsr.getParameter("text3")!=null){
                        if(hsr.getParameter("combo3")!=null){
                            add4= hsr.getParameter("combo3");
                        }else{
                            add4= hsr.getParameter("hidden3")+": "+hsr.getParameter("text3"); 
                        }
                    }
                    ModeloCarSes car = new ModeloCarSes();
                    car.setIdarticulo(Long.parseLong(hsr.getParameter("id")));
                    car.setFoto1(artic.getFoto1());
                    if(hsr.getParameter("cant")!=null){
                       car.setCantidad(Long.parseLong(hsr.getParameter("cant"))); 
                    }else{
                       car.setCantidad(Long.parseLong("1")); 
                    }
                    car.setPrecio(artic.getPrecio());
                    car.setNombre(artic.getNombre());
                    car.setAdd1(add1);
                    if(add2!=null){
                        car.setAdd2(add2);
                    }else{
                        car.setAdd2("NONE");
                    }
                    if(add3!=null){
                        car.setAdd3(add3);
                    }else{
                        car.setAdd3("NONE");
                    }
                    if(add4!=null){
                        car.setAdd4(add4);
                    }else{
                        car.setAdd4("NONE");
                    }
                    ArrayList<ModeloCarSes> listart = new ArrayList<>();
                    if(hsr.getSession().getAttribute("cart")!=null){
                        listart = (ArrayList<ModeloCarSes>) hsr.getSession().getAttribute("cart");
                        ModeloCarSes check = new ModeloCarSes();
                        ModeloCarSes modif = new ModeloCarSes();
                        for (ModeloCarSes mod:listart){
                            if(mod.getIdarticulo()==car.getIdarticulo()&&mod.getAdd1().equalsIgnoreCase(car.getAdd1())&&mod.getAdd2().equalsIgnoreCase(car.getAdd2())&&mod.getAdd3().equalsIgnoreCase(car.getAdd3())&&mod.getAdd4().equalsIgnoreCase(car.getAdd4())){
                                check = mod;
                                mod.setCantidad(mod.getCantidad()+1);
                                modif = mod;
                            }
                        }
                        if(check.getIdarticulo()!=0){
                            listart.remove(check);
                            car = modif;
                        }
                    }
                    listart.add(car);
                    hsr.getSession().setAttribute("cart", listart);
                    if(hsr.getSession().getAttribute("userid")!=null){
                        int usconv = (int) hsr.getSession().getAttribute("userid");
                        Long us = Long.parseLong(String.valueOf(usconv));
                        Carritopro c = new Carritopro();
                        c.setIdcart(repo.getNextIdCart().intValue());
                        c.setClientespro(reposes.getOneCliente(us.intValue()));
                        c.setArticulospro(artic);
                        c.setFoto1(artic.getFoto1());
                        if(hsr.getParameter("cant")!=null){
                            c.setCantidad(Integer.parseInt(hsr.getParameter("cant"))); 
                        }else{
                            c.setCantidad(Integer.parseInt("1")); 
                        }
                        c.setAdd1(add1);
                        if(add2!=null){
                            c.setAdd2(add2);
                        }else{
                            c.setAdd2("NONE");
                        }
                        if(add3!=null){
                            c.setAdd3(add3);
                        }else{
                            c.setAdd3("NONE");
                        }
                        if(add4!=null){
                            c.setAdd4(add4);
                        }else{
                            c.setAdd4("NONE");
                        }
                        Carritopro modif = new Carritopro();
                        ArrayList<Carritopro> prolist = (ArrayList<Carritopro>)reposes.gettodosCarrito(us);
                        if(!prolist.isEmpty()){
                            for(Carritopro cpr:prolist){
                                if(cpr.getArticulospro().getIdarticulo()==artic.getIdarticulo()&&cpr.getAdd1().equalsIgnoreCase(c.getAdd1())&&cpr.getAdd2().equalsIgnoreCase(c.getAdd2())&&cpr.getAdd3().equalsIgnoreCase(c.getAdd3())&&cpr.getAdd4().equalsIgnoreCase(c.getAdd4())){
                                    cpr.setCantidad(cpr.getCantidad()+1);
                                    modif = cpr;
                                }
                            }
                            if(modif.getIdcart()!=0){
                                Long idartic = Long.parseLong(String.valueOf(modif.getArticulospro().getIdarticulo()));
                                Long cant = Long.parseLong(String.valueOf(modif.getCantidad()));
                                reposes.UpdateCarrito(reposes.getCurrentIdCart(us, idartic, modif.getAdd1(), modif.getAdd2(), modif.getAdd3(), modif.getAdd4()), cant);
                            }else{
                                reposes.InsertCarrito(c);
                            }
                        }else{
                            reposes.InsertCarrito(c);
                        }
                    }
                    if(hsr.getSession().getAttribute("wishcheck"+artic.getIdarticulo())!=null){
                        hsr.getSession().setAttribute("wishcheck"+artic.getIdarticulo(), (Long)hsr.getSession().getAttribute("wishcheck"+artic.getIdarticulo())-1);
                        ArrayList<ModeloWishlist> wishlist = (ArrayList<ModeloWishlist>) hsr.getSession().getAttribute("wishlist");
                        ModeloWishlist checkw = new ModeloWishlist();
                        ModeloWishlist modifw = new ModeloWishlist();
                        for(ModeloWishlist mod:wishlist){
                            if(car.getIdarticulo()==mod.getIdarticulo()){
                                checkw = mod;
                                if((mod.getQuantity()-1)!=0){
                                    mod.setQuantity(mod.getQuantity()-1);
                                    modifw=mod;
                                }else{
                                    modifw=null;
                                }
                            }
                        }
                        wishlist.remove(checkw);
                        if(modifw!=null){
                            wishlist.add(modifw);
                        }
                        if(wishlist.isEmpty()){
                            hsr.getSession().setAttribute("wishlist", null);
                        }else{
                            hsr.getSession().setAttribute("wishlist", wishlist);
                        }
                        if(hsr.getSession().getAttribute("userid")!=null){
                            int usres = (int) hsr.getSession().getAttribute("userid");
                            Long us = Long.parseLong(String.valueOf(usres));
                            if(modifw!=null){
                                reposes.UpdateWish(us, car.getIdarticulo(), modifw.getQuantity());
                            }else{
                                reposes.DeleteWish(us, car.getIdarticulo());
                            }
                        }
                        if((Long)hsr.getSession().getAttribute("wishcheck"+artic.getIdarticulo())==0){
                            hsr.getSession().setAttribute("wishcheck"+artic.getIdarticulo(), null);
                        }else{
                            return new ModelAndView("forward:/product.htm?tit=wishcheck"+artic.getIdarticulo());
                        }
                    }
                }else{
                    return new ModelAndView("forward:/product.htm?check=1");
                }    
            }
        }
        if(hsr.getSession().getAttribute("cart")!=null){
            ArrayList<ModeloCarSes> list = (ArrayList<ModeloCarSes>) hsr.getSession().getAttribute("cart");
            Long total = Long.parseLong("0");
            for (ModeloCarSes mod: list){
                total += mod.getPrecio()*mod.getCantidad();
            }
            view.addObject("carttotal", total);
            view.addObject("cartlist", hsr.getSession().getAttribute("cart"));
        }else{
            view.addObject("cartlist", null);
        }
        if(hsr.getSession().getAttribute("userid")!=null){
            view.addObject("userid", hsr.getSession().getAttribute("userid"));
        }
        return view;
    }
    
}
