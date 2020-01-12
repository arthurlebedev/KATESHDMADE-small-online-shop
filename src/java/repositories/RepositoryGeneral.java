
package repositories;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Modelo8Review;
import models.ModeloAllReview;
import models.ModeloStarsMedia;
import models.ModeloWishlist;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Articulospro;
import pojos.HibernateUtil;
import pojos.Parampro;


public class RepositoryGeneral {
    Session sesion;
    Session sesion2;
    Transaction tran;
    Transaction tran2;
    
    public RepositoryGeneral(){
        this.sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        this.sesion2 = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    private void crearConexion(){
        if (sesion.isOpen()==false){
            sesion = HibernateUtil.getSessionFactory().openSession();
        }
        tran = sesion.beginTransaction();
    }
    
    private void crearConexion2(){
        if (sesion2.isOpen()==false){
            sesion2 = HibernateUtil.getSessionFactory().openSession();
        }
        tran2 = sesion2.beginTransaction();
    }
    
    public List<Articulospro> buscarArticulosPopulares (){
        String hql = "SELECT r.id.idarticulo, (SUM (r.stars)/COUNT(r.id.idarticulo)) FROM Reviewpro as r GROUP BY r.id.idarticulo order by (SUM (r.stars)/COUNT(r.id.idarticulo)) desc));";
        crearConexion();
        Query q = sesion.createQuery(hql);
        List datos = q.list();
        ArrayList<Modelo8Review> mod8list = new ArrayList<>();
        for (Object objeto: datos){
                Object[] registro = (Object[]) objeto;
                int idart = (int) registro[0];
                Long stars = (Long) registro[1];
                Modelo8Review rev8= new Modelo8Review();
                rev8.setIdart(idart);
                rev8.setStars(stars.intValue());
                mod8list.add(rev8);
        }
        sesion.close();
        ArrayList<Articulospro> artlist = new ArrayList<>();
        for(Modelo8Review mod:mod8list){
            Articulospro art = new Articulospro();
            art = getOneArticle(mod.getIdart());
            artlist.add(art);
        }
        ArrayList<Articulospro> articulos2 = new ArrayList<>();
        int i = 1;
        for(Articulospro art: artlist){
            if(i<=8){
                articulos2.add(art);
            }
            i++;
        }
        return articulos2;
    }
    
    public List<Articulospro> gettodosArticulos(){
        String hql = "from Articulospro as v order by v.nombre";
        crearConexion();
        Query q = sesion.createQuery(hql);
        List<Articulospro> datos = q.list();
        sesion.close();
        return datos;
    }
    
    public Articulospro getOneArticle(int id){
        String hql = "from Articulospro as v where v.idarticulo="+id;
        crearConexion();
        Query q = sesion.createQuery(hql);
        Articulospro datos = (Articulospro) q.uniqueResult();
        sesion.close();
        return datos;
    }
    
    public ModeloWishlist getArticleWishlist(int id){
        String hql = "select v.nombre, v.precio, v.foto1, v.idarticulo from Articulospro as v where v.idarticulo="+id;
        crearConexion();
        Query q = sesion.createQuery(hql);
        List datos = q.list();
        ModeloWishlist wish = new ModeloWishlist();
        for (Object objeto: datos){
                Object[] registro = (Object[]) objeto;
                String nom = (String) registro[0];
                int precioconv = (int) registro[1];
                Long precio = Long.parseLong(String.valueOf(precioconv));
                String foto = (String) registro[2];
                int idartconv = (int) registro[3];
                Long idart = Long.parseLong(String.valueOf(idartconv));
                wish.setNombre(nom);
                wish.setPrecio(precio);
                wish.setFoto1(foto);
                wish.setQuantity(Long.parseLong("1"));
                wish.setIdarticulo(idart);
        }
        sesion.close();
        return wish;
    }
    
    public List<Parampro> getParamArticle(int id){
        String hql = "from Parampro as v where v.id.idarticulo=?";
        crearConexion();
        Query q = sesion.createQuery(hql);
        q.setInteger(0, id);
        List<Parampro> datos = q.list();
        sesion.close();
        return datos;
    }
    
    public ModeloStarsMedia getStarsMedia(int idart){
        String hql = "select (sum(v.stars)/count(v.stars)), count(v.clientespro) from Reviewpro as v where v.articulospro=?";
        crearConexion();
        Query q = sesion.createQuery(hql);
        q.setInteger(0, idart);
        List datos = q.list();
        ModeloStarsMedia stars = new ModeloStarsMedia();
        for (Object objeto: datos){
                Object[] registro = (Object[]) objeto;
                Long star = (Long) registro[0];
                if(star==null){
                    star = Long.parseLong("0");
                }
                Long cli = (Long) registro[1];
                stars.setStarsmedia(star.intValue());
                stars.setClientes(cli.intValue());
        }
        sesion.close();
        return stars;
    }
    
    public List<ModeloAllReview> getAllReview(int id){
        String hql = "select c.nombre, v.stars, v.text, v.fecha, c.idcliente from Reviewpro as v, Clientespro as c where v.clientespro=c.idcliente and v.articulospro=?";
        crearConexion();
        Query q = sesion.createQuery(hql);
        q.setInteger(0, id);
        List datos = q.list();
        ArrayList<ModeloAllReview> arr = new ArrayList<>();
        for (Object objeto: datos){
                ModeloAllReview rev = new ModeloAllReview();
                Object[] registro = (Object[]) objeto;
                String nom = (String) registro[0];
                int star = (int) registro[1];
                String text = (String) registro[2];
                Date fecha = (Date) registro [3];
                int idcli = (int) registro [4];
                rev.setNombre(nom);
                rev.setStars(star);
                rev.setText(text);
                rev.setFecha(fecha);
                rev.setIdcliente(idcli);
                rev.setVercompra(getVerificarCompra(idcli, id));
                arr.add(rev);
        }
        sesion.close();
        return arr;
    }
    
    public Long getReviewCheck(Long id, Long idart){
        String hql = "select count(v.stars) from Reviewpro as v where v.clientespro=? and v.articulospro=?";
        crearConexion();
        Query q = sesion.createQuery(hql);
        q.setLong(0, id);
        q.setLong(1, idart);
        Long datos = (Long) q.uniqueResult();
        sesion.close();
        return datos;
    }
    
    public int getVerificarCompra(int idcli, int idart){
        String hql = "select count(c.cantidad) from Comprapro as v, Pedidospro as c where v.idcompra=c.comprapro and v.clientespro=? and c.articulospro=?";
        crearConexion2();
        Query q = sesion2.createQuery(hql);
        q.setInteger(0, idcli);
        q.setInteger(1, idart);
        Long datoslong = (Long) q.uniqueResult();
        int datos = datoslong.intValue();
        sesion2.close();
        return datos;
    }
    
    public Long getNextIdCart(){
        String hql="select coalesce(max(v.idcart)+1,1) from Carritopro as v";
        crearConexion();
        Query q = sesion.createQuery(hql);
        int idnextconv = (int) q.uniqueResult();
        Long idnext = Long.parseLong(String.valueOf(idnextconv));
        
        sesion.close();
        return idnext;
    }
    
    
    
}
