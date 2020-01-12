package repositories;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Carritopro;
import pojos.Clientespro;
import pojos.HibernateUtil;
import pojos.Reviewpro;
import pojos.ReviewproId;
import pojos.Wishlistpro;
import pojos.WishlistproId;


public class RepositorySession {
    
    Session sesion;
    Transaction tran;
    Session sesion2;
    Transaction tran2;
    
    public RepositorySession(){
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
    
    public Clientespro getOneCliente(int id){
        String hql = "from Clientespro as v where v.idcliente="+id;
        crearConexion();
        Query q = sesion.createQuery(hql);
        Clientespro datos = (Clientespro) q.uniqueResult();
        sesion.close();
        return datos;
    }
    
    public Long getOneClienteName(String nom){
        String hql = "from Clientespro as v where v.nombre='"+nom+"'";
        crearConexion();
        Query q = sesion.createQuery(hql);
        Clientespro datos = (Clientespro) q.uniqueResult();
        sesion.close();
        Long idcli = Long.valueOf(String.valueOf(datos.getIdcliente()));
        return idcli;
    }
    
    public Clientespro getCheckPass(String correo, String pass){
        String hql = "from Clientespro as v where v.correo=? and v.password=?";
        crearConexion();
        Query q = sesion.createQuery(hql);
        q.setString(0, correo);
        q.setString(1, pass);
        Clientespro datos = (Clientespro) q.uniqueResult();
        sesion.close();
        return datos;
    }
    
    public Clientespro getCheckCurrentPass(Long id, String pass){
        String hql = "from Clientespro as v where v.idcliente=? and v.password=?";
        crearConexion();
        Query q = sesion.createQuery(hql);
        q.setLong(0, id);
        q.setString(1, pass);
        Clientespro datos = (Clientespro) q.uniqueResult();
        sesion.close();
        return datos;
    }
    
    public void UpdateClient(String nombre, String dni, String dir, String tel, String mail, String pass,Long idcli){
        crearConexion();
        Object o=sesion.load(Clientespro.class, idcli.intValue());
        Clientespro cli = (Clientespro) o;
        cli.setNombre(nombre);
        cli.setDni(dni);
        cli.setDireccion(dir);
        cli.setTelefono(tel);
        cli.setCorreo(mail);
        cli.setPassword(pass);
        tran.commit();
        sesion.close();
    }
    
    public int InsertClient(String nom, String mail, String pass){
        crearConexion();
        Clientespro cli = new Clientespro();
        cli.setIdcliente(getNextId().intValue());
        cli.setNombre(nom);
        cli.setDni("NONE");
        cli.setDireccion("NONE");
        cli.setTelefono("NONE");
        cli.setCorreo(mail);
        cli.setPassword(pass);
        cli.setAdmin("FALSE");
        sesion.save(cli);
        sesion.getTransaction().commit();
        sesion.close();
        return getOneClienteName(nom).intValue();
    }
    
    public Long getNextId(){
        String hql="select max(v.idcliente)+1 from Clientespro as v";
        crearConexion2();
        Query q = sesion2.createQuery(hql);
        int idnext = (int) q.uniqueResult();
        Long idnext2 = Long.parseLong(String.valueOf(idnext));
        sesion2.close();
        return idnext2;
    }
    
    public void InsertReview(Long idcli, Long idart, int stars, String text){
        crearConexion();
        java.util.Date date=new java.util.Date();
        Reviewpro rev = new Reviewpro();
        ReviewproId revid = new ReviewproId();
        revid.setIdarticulo(idart.intValue());
        revid.setIdcliente(idcli.intValue());
        rev.setId(revid);
        rev.setStars(stars);
        rev.setText(text);
        rev.setFecha(date);
        sesion.save(rev);
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    public void DeleteReview(Long idcli, Long idart){
        crearConexion();
        ReviewproId revid = new ReviewproId();
        revid.setIdcliente(idcli.intValue());
        revid.setIdarticulo(idart.intValue());
        Object o=sesion.load(Reviewpro.class, revid);
        Reviewpro rev = (Reviewpro) o;
        sesion.delete(rev);
        tran.commit();
        sesion.close();
    }
    
    public void InsertWish(Long idcli, Long idart, Long quant){
        crearConexion();
        Wishlistpro wish = new Wishlistpro();
        WishlistproId wishid = new WishlistproId();
        wishid.setIdarticulo(idart.intValue());
        wishid.setIdcliente(idcli.intValue());
        wish.setId(wishid);
        wish.setQuantity(quant.intValue());
        sesion.save(wish);
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    public void UpdateWish(Long idcli, Long idart, Long quant){
        crearConexion();
        WishlistproId wishid = new WishlistproId();
        wishid.setIdarticulo(idart.intValue());
        wishid.setIdcliente(idcli.intValue());
        Object o=sesion.load(Wishlistpro.class, wishid);
        Wishlistpro wish = (Wishlistpro) o;
        wish.setQuantity(quant.intValue());
        tran.commit();
        sesion.close();
    }
    
    public void DeleteWish(Long idcli, Long idart){
        crearConexion();
        WishlistproId wishid = new WishlistproId();
        wishid.setIdarticulo(idart.intValue());
        wishid.setIdcliente(idcli.intValue());
        Object o=sesion.load(Wishlistpro.class, wishid);
        Wishlistpro wish = (Wishlistpro) o;
        sesion.delete(wish);
        tran.commit();
        sesion.close();
    }
    
    public List<Wishlistpro> gettodosWish(Long idcli){
        String hql = "from Wishlistpro as v where v.id.idcliente="+idcli;
        crearConexion();
        Query q = sesion.createQuery(hql);
        List<Wishlistpro> datos = q.list();
        sesion.close();
        return datos;
    }
    
    public void InsertCarrito(Carritopro cart){
        crearConexion();
        Carritopro c = cart;
        sesion.save(c);
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    public void UpdateCarrito(Long idc, Long quant){
        crearConexion();
        Object o=sesion.load(Carritopro.class, idc.intValue());
        Carritopro c = (Carritopro) o;
        c.setCantidad(quant.intValue());
        tran.commit();
        sesion.close();
    }
    
    public void DeleteCarrito(Long idc){
        crearConexion();
        Object o=sesion.load(Carritopro.class, idc.intValue());
        Carritopro c = (Carritopro) o;
        sesion.delete(c);
        tran.commit();
        sesion.close();
    }
    
    public Long getCurrentIdCart(Long idcli, Long idart, String add1, String add2, String add3, String add4){
        String hql="select v.idcart from Carritopro as v where v.clientespro=? and v.articulospro=? and upper(v.add1)=upper(?) and upper(v.add2)=upper(?) and upper(v.add3)=upper(?) and upper(v.add4)=upper(?)";
        crearConexion();
        Query q = sesion.createQuery(hql);
        q.setLong(0, idcli);
        q.setLong(1, idart);
        q.setString(2, add1);
        q.setString(3, add2);
        q.setString(4, add3);
        q.setString(5, add4);
        int idcart = (int) q.uniqueResult();
        Long idcart2 = Long.parseLong(String.valueOf(idcart));
        sesion.close();
        return idcart2;
    }
    
    public Long checkEqualArticCarrito(Long idcli, Long idart, String add1, String add2, String add3, String add4){
        String hql="select count(v.idcart) from Carritopro as v where v.clientespro=? and v.articulospro=? and upper(v.add1)=upper(?) and upper(v.add2)=upper(?) and upper(v.add3)=upper(?) and upper(v.add4)=upper(?)";
        crearConexion();
        Query q = sesion.createQuery(hql);
        q.setLong(0, idcli);
        q.setLong(1, idart);
        q.setString(2, add1);
        q.setString(3, add2);
        q.setString(4, add3);
        q.setString(5, add4);
        Long idcart = (Long) q.uniqueResult();
        sesion.close();
        return idcart;
    }
    
    public List<Carritopro> gettodosCarrito(Long idcli){
        String hql = "from Carritopro as v where v.clientespro="+idcli;
        crearConexion();
        Query q = sesion.createQuery(hql);
        List<Carritopro> datos = q.list();
        sesion.close();
        return datos;
    }
    
    
}

