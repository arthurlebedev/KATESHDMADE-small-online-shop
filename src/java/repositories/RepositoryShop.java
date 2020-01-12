
package repositories;

import java.util.ArrayList;
import java.util.List;
import models.ModeloCategoriesCount;
import models.ModeloShopArticulos;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Articulospro;
import pojos.HibernateUtil;


public class RepositoryShop {
    Session sesion;
    Transaction tran;
    
    public RepositoryShop(){
        this.sesion = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    private void crearConexion(){
        if (sesion.isOpen()==false){
            sesion = HibernateUtil.getSessionFactory().openSession();
        }
        tran = sesion.beginTransaction();
    }
    
    public List<ModeloShopArticulos> gettodosArticulosMultipleTRESOptions(String cat, int pricemin, int pricemax, String orderin){
        String order;
        switch (orderin){
            case "1":
                order = "v.nombre";
            break;
            case "2":
                order = "v.precio";
            break;
            default:
                order = "v.categoriapro";
            break;    
        }
        String hql="select v.idarticulo, v.nombre, v.precio, v.text, v.foto1 from Articulospro as v, Categoriapro as c where v.categoriapro=c.idcategoria and upper(c.nombre)=upper(?) and v.precio>=? and v.precio<=? order by "+order;
        crearConexion();
        Query q = sesion.createQuery(hql);
        q.setString(0, cat);
        q.setInteger(1, pricemin);
        q.setInteger(2, pricemax);
        List datos = q.list();
        ArrayList<ModeloShopArticulos> art = new ArrayList<>();
        for (Object objeto: datos){
                ModeloShopArticulos shop = new ModeloShopArticulos();
                Object[] registro = (Object[]) objeto;
                int idart= (int) registro[0];
                String nom  = (String) registro[1];
                int prec= (int) registro[2];
                String text  = (String) registro[3];
                String foto  = (String) registro[4];
                shop.setIdarticulo(idart);
                shop.setNombre(nom);
                shop.setPrecio(prec);
                shop.setText(text);
                shop.setFoto1(foto);
                art.add(shop);
        }
        sesion.close();
        return art;
    }
    
    public List<ModeloShopArticulos> gettodosArticulosMultipleOrderPrecio(int pricemin, int pricemax, String orderin){
        String order;
        switch (orderin){
            case "1":
                order = "v.nombre";
            break;
            case "2":
                order = "v.precio";
            break;
            default:
                order = "v.categoriapro";
            break;    
        }
        String hql="select v.idarticulo, v.nombre, v.precio, v.text, v.foto1 from Articulospro as v where v.precio>=? and v.precio<=? order by "+order;
        crearConexion();
        Query q = sesion.createQuery(hql);
        q.setInteger(0, pricemin);
        q.setInteger(1, pricemax);
        List datos = q.list();
        ArrayList<ModeloShopArticulos> art = new ArrayList<>();
        for (Object objeto: datos){
                ModeloShopArticulos shop = new ModeloShopArticulos();
                Object[] registro = (Object[]) objeto;
                int idart= (int) registro[0];
                String nom  = (String) registro[1];
                int prec= (int) registro[2];
                String text  = (String) registro[3];
                String foto  = (String) registro[4];
                shop.setIdarticulo(idart);
                shop.setNombre(nom);
                shop.setPrecio(prec);
                shop.setText(text);
                shop.setFoto1(foto);
                art.add(shop);
        }
        sesion.close();
        return art;
    }
    
    public List<ModeloShopArticulos> gettodosArticulosMultiplePrecio(int pricemin, int pricemax){
        String hql="select v.idarticulo, v.nombre, v.precio, v.text, v.foto1 from Articulospro as v where  v.precio>=? and v.precio<=?";
        crearConexion();
        Query q = sesion.createQuery(hql);
        q.setInteger(0, pricemin);
        q.setInteger(1, pricemax);
        List datos = q.list();
        ArrayList<ModeloShopArticulos> art = new ArrayList<>();
        for (Object objeto: datos){
                ModeloShopArticulos shop = new ModeloShopArticulos();
                Object[] registro = (Object[]) objeto;
                Long idart= (Long) registro[0];
                String nom  = (String) registro[1];
                Long prec= (Long) registro[2];
                String text  = (String) registro[3];
                String foto  = (String) registro[4];
                shop.setIdarticulo(idart.intValue());
                shop.setNombre(nom);
                shop.setPrecio(prec.intValue());
                shop.setText(text);
                shop.setFoto1(foto);
                art.add(shop);
        }
        sesion.close();
        return art;
    }
    
    public ArrayList<ModeloCategoriesCount> getCategoriesCount(){
        String hql = "select c.nombre, count(a.nombre) from Articulospro as a, Categoriapro as c where a.categoriapro=c.idcategoria group by c.nombre order by c.nombre";
        crearConexion();
        Query q = sesion.createQuery(hql);
        List datos = q.list();
        ArrayList<ModeloCategoriesCount> cat = new ArrayList<>();
        for (Object objeto: datos){
                ModeloCategoriesCount mod = new ModeloCategoriesCount();
                Object[] registro = (Object[]) objeto;
                String catname = (String) registro[0];
                Long count  = (Long) registro[1];
                mod.setCatname(catname);
                mod.setCount(count.intValue());
                cat.add(mod);
        }
        sesion.close();
        return cat;
    }
    
    public int getCountAll(){
        String hql = "select count(v.nombre) from Articulospro as v";
        crearConexion();
        Query q = sesion.createQuery(hql);
        Long datos2 = (Long) q.uniqueResult();
        int datos = datos2.intValue();
        sesion.close();
        return datos;
    }
    
    public List<Articulospro> getSeacrh(String item){
        String hql = "from Articulospro as v where upper(v.nombre) like upper(?) or upper(v.text) like upper(?) or upper(v.materials) like upper(?) or upper(dimensions) like upper(?)";
        crearConexion();
        Query q = sesion.createQuery(hql);
        q.setString(0, '%'+item+'%');
        q.setString(1, '%'+item+'%');
        q.setString(2, '%'+item+'%');
        q.setString(3, '%'+item+'%');
        List<Articulospro> datos = q.list();
        sesion.close();
        return datos;
    }
}
