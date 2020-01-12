
package beans;

import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ModeloCarSes;
import models.ModeloWishlist;
import pojos.Articulospro;
import pojos.Carritopro;
import pojos.Clientespro;
import pojos.Wishlistpro;
import repositories.RepositoryGeneral;
import repositories.RepositorySession;


public class BeanSession extends HttpServlet{
    RepositorySession repo;
    RepositoryGeneral repog;
    
    public BeanSession(){
        this.repo = new RepositorySession();
        this.repog = new RepositoryGeneral();
    }
    
    
    public String getNombreCliente(HttpServletRequest request, HttpServletResponse response){
        if(request.getSession().getAttribute("userid")!=null){
            int datoconv = (int) request.getSession().getAttribute("userid");
            Long dato = Long.parseLong(String.valueOf(datoconv));
            Clientespro cli = repo.getOneCliente(dato.intValue());
            String temp = cli.getNombre();
            boolean check = false;
            for(int i = 0; i < temp.length(); i++){
                if(Character.isWhitespace(temp.charAt(i))){
                    check= true;
                }
            }
            String nickname;
            if(check){
                nickname = temp.substring(0, temp.indexOf(' '));
            }else{
                nickname = temp;
            }
            return nickname;
        }
     return "";   
    }
    
    public String getLogout(HttpServletRequest request, HttpServletResponse response){
        if(request.getSession().getAttribute("userid")!=null){
            return "<li><a href=\"account.htm?logout=1\"><span class=\"ti-close\"></span></a></li>";
        }
     return "";   
    }
    
    public String getAllCart (HttpServletRequest request, HttpServletResponse response){
        String cart = null;
        if(request.getSession().getAttribute("cart")!=null){
            cart = "<div class=\"shp__cart__wrap\">";
            ArrayList<ModeloCarSes> listcart = new ArrayList<>();
            listcart = (ArrayList<ModeloCarSes>) request.getSession().getAttribute("cart");
            int total=0;
            for(ModeloCarSes mod:listcart){
                cart += "<div class=\"shp__single__product\">";
                    cart += "<div class=\"shp__pro__thumb\">";
                        cart += "<a href='product.htm?id="+mod.getIdarticulo()+"'>";
                            cart += "<img style='width:150px' src=\"https://blobkateshdmade.blob.core.windows.net/images2/"+mod.getFoto1()+"\" alt=\"product images\">";
                        cart += "</a>";
                    cart += "</div>"; 
                    cart += "<div class=\"shp__pro__details\">";
                        cart += "<h2><a href=\"product.htm?id="+mod.getIdarticulo()+"\">"+mod.getNombre()+"</a></h2>";
                        cart += "<span class=\"quantity\">QTY: "+mod.getCantidad()+"</span>";
                        cart += "<span class=\"shp__price\">€"+mod.getPrecio()+".00</span>";
                    cart += "</div>"; 
                    cart += "<div class=\"remove__btn\">";
                        cart += "<a href=\"cart.htm?erase="+mod.getIdarticulo()+"&&add1="+mod.getAdd1()+"&&add2="+mod.getAdd2()+"&&add3="+mod.getAdd3()+"&&add4="+mod.getAdd4()+"\" title=\"Remove this item\"><i class=\"zmdi zmdi-close\"></i></a>";
                    cart += "</div>";
                cart += "</div>";
                total += mod.getPrecio()*mod.getCantidad();
            }
            cart += "</div>";
            cart += "<ul class=\"shoping__total\">";
                cart += "<li class=\"subtotal\">Subtotal:</li>";
                cart += "<li class=\"total__price\">€"+total+".00</li>";
            cart += "</ul>";
            cart += "<ul class=\"shopping__btn\"><li><a href=\"cart.htm\">View Cart</a></li><li class=\"shp__checkout\"><a href=\"checkout.htm\">Checkout</a></li></ul>";
            return cart;
        }
        return "<div style='color:red; font-weight: bold; font-size:2em'>Your cart is empty</div>";
    }
    
    public void getCarSession(HttpServletRequest request, HttpServletResponse response){
        if(request.getSession().getAttribute("userid")!=null){
            int usconv = (int) request.getSession().getAttribute("userid");
            Long us = Long.parseLong(String.valueOf(usconv));
            if(request.getSession().getAttribute("cart")==null&&!repo.gettodosCarrito(us).isEmpty()){
                ArrayList<Carritopro> carpro = (ArrayList<Carritopro>) repo.gettodosCarrito(us);
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
                        request.getSession().setAttribute("cart", modif);
            }
            
            if(request.getSession().getAttribute("wishlist")==null&&!repo.gettodosWish(us).isEmpty()){
                ArrayList<Wishlistpro> wishpro = (ArrayList<Wishlistpro>) repo.gettodosWish(us);
                ArrayList<ModeloWishlist> wishmod = new ArrayList<>();
                for(Wishlistpro wpro:wishpro){
                    ModeloWishlist wmod = new ModeloWishlist();
                    int idart = wpro.getId().getIdarticulo();
                    wmod = repog.getArticleWishlist(idart);
                    wmod.setQuantity(wpro.getQuantity().longValue());
                    wishmod.add(wmod);
                }
                request.getSession().setAttribute("wishlist", wishmod);
            }
        }
    }
    
    public String getCartNumber(HttpServletRequest request, HttpServletResponse response){
        Long count=Long.valueOf("0");
        if(request.getSession().getAttribute("cart")!=null){
            ArrayList<ModeloCarSes> listcart = (ArrayList<ModeloCarSes>) request.getSession().getAttribute("cart");
            for (ModeloCarSes mod:listcart){
                count+= mod.getCantidad();
            }
        }
        String conv = "";
        if(count!=0){
            conv = String.valueOf(count);
        }
     return conv;   
    }
    
    public String getMenuOrder(HttpServletRequest request, HttpServletResponse response){
        if(request.getSession().getAttribute("userid")!=null){
            return "<li><a href=\"orders.htm\">my orders</a></li>";
        }
     return "";   
    }
    
}
