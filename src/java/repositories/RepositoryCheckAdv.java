
package repositories;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.ModeloAdminReview;
import models.ModeloItemList;
import models.ModeloOrders;
import models.ModeloOrdersArt;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Articulospro;
import pojos.Carritopro;
import pojos.Categoriapro;
import pojos.Clientespro;
import pojos.Comprapro;
import pojos.HibernateUtil;
import pojos.Parampro;
import pojos.ParamproId;
import pojos.PedidosproId;
import pojos.Pedidospro;
import pojos.Reviewpro;
import pojos.ReviewproId;

public class RepositoryCheckAdv {
    Session sesion;
    Transaction tran;
    Session sesion2;
    Transaction tran2;
    RepositorySession repo;
    RepositoryGeneral repog;
    
    public RepositoryCheckAdv(){
    this.sesion = HibernateUtil.getSessionFactory().getCurrentSession();
    this.sesion2 = HibernateUtil.getSessionFactory().getCurrentSession();
    this.repo = new RepositorySession();
    this.repog = new RepositoryGeneral();
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
    
    public void InsertOrder(Long idcli, Long prectot, String text, ArrayList<Carritopro> carpro, String modop){
        Clientespro cliente = repo.getOneCliente(idcli.intValue());
        Long idcompra = getNextIdCompra();
        crearConexion();
        java.util.Date date=new java.util.Date();
        Comprapro compr = new Comprapro();
        compr.setIdcompra(idcompra.intValue());
        compr.setClientespro(cliente);
        compr.setFechacompra(date);
        compr.setPreciototal(prectot.intValue());
        compr.setText(text);
        compr.setModopago(modop);
        compr.setFechaenvio("NONE");
        sesion.save(compr);
        sesion.getTransaction().commit();
        sesion.close();
        InsertPedidospro(carpro, compr);
        for(Carritopro pro:carpro){
            String idart = String.valueOf(pro.getArticulospro().getIdarticulo());
            Long idcart = repo.getCurrentIdCart(idcli, Long.valueOf(idart), pro.getAdd1(), pro.getAdd2(), pro.getAdd3(), pro.getAdd4());
            repo.DeleteCarrito(idcart);
        }
    }
    
    public Long getNextIdCompra(){
        String hql="select coalesce(max(v.idcompra)+1,1) from Comprapro as v";
        crearConexion();
        Query q = sesion.createQuery(hql);
        int idnextconv = (int) q.uniqueResult();
        Long idnext = Long.parseLong(String.valueOf(idnextconv));
        sesion.close();
        return idnext;
    }
    
    public void InsertPedidospro(ArrayList<Carritopro> carpro, Comprapro compr){
         for(Carritopro pro:carpro){
             crearConexion();
             PedidosproId pedid = new PedidosproId();
             pedid.setIdcompra(compr.getIdcompra());
             pedid.setIdarticulo(pro.getArticulospro().getIdarticulo());
             pedid.setAdd1(pro.getAdd1());
             pedid.setAdd2(pro.getAdd2());
             pedid.setAdd3(pro.getAdd3());
             pedid.setAdd4(pro.getAdd4());
             Pedidospro ped = new Pedidospro();
             ped.setId(pedid);
             ped.setCantidad(pro.getCantidad());
             ped.setComprapro(compr);
             String idartc = String.valueOf(pro.getArticulospro().getIdarticulo());
             Long idart = Long.parseLong(idartc);
             ped.setArticulospro(repog.getOneArticle(idart.intValue()));
             sesion.save(ped);
             sesion.getTransaction().commit();
             sesion.close();
         }
        
    }
    
    public ArrayList<ModeloOrders> getTodosPedidos(Long idcli){
        String hql="from Comprapro as v where v.clientespro=? order by v.fechacompra desc";
        crearConexion();
        Query q = sesion.createQuery(hql);
        q.setLong(0, idcli);
        ArrayList<Comprapro> prolist = (ArrayList<Comprapro>) q.list();
        sesion.close();
        ArrayList<ModeloOrders> orderlist = new ArrayList<>();
        for(Comprapro pro:prolist){
            String hql2 ="from Pedidospro as v where v.id.idcompra=?";
            crearConexion();
            Query q2 = sesion.createQuery(hql2);
            q2.setLong(0, pro.getIdcompra());
            ArrayList<Pedidospro> pedlist = (ArrayList<Pedidospro>) q2.list();
            sesion.close();
            ArrayList<ModeloOrdersArt> modartlist = new ArrayList<>();
            for (Pedidospro ped:pedlist){
                ModeloOrdersArt modart = new ModeloOrdersArt();
                Long idart = Long.valueOf(String.valueOf(ped.getArticulospro().getIdarticulo()));
                modart.setIdart(idart);
                Long artid = idart;
                Articulospro art = repog.getOneArticle(artid.intValue());
                Long precio = Long.valueOf(String.valueOf(art.getPrecio()));
                modart.setPrecio(precio);
                modart.setNombre(art.getNombre());
                modart.setFoto(art.getFoto1());
                modart.setAdd1(ped.getId().getAdd1());
                modart.setAdd2(ped.getId().getAdd2());
                modart.setAdd3(ped.getId().getAdd3());
                modart.setAdd4(ped.getId().getAdd4());
                Long cant = Long.valueOf(String.valueOf(ped.getCantidad()));
                modart.setCant(cant);
                modartlist.add(modart);
            }
            ModeloOrders order = new ModeloOrders();
            String date = pro.getFechacompra().toString();
            order.setFechacompra(date);
            order.setFechaenvio(pro.getFechaenvio());
            String stat;
            if(pro.getFechaenvio().equalsIgnoreCase("none")){
                stat = "PROCESSING";
            }else{
                stat = "SENT";
            }
            order.setStatus(stat);
            order.setIdcompra(pro.getIdcompra());
            order.setModopago(pro.getModopago());
            order.setPreciototal(pro.getPreciototal());
            order.setText(pro.getText());
            order.setPedlist(modartlist);
            orderlist.add(order);
        }
        
        return orderlist;
    }
    
    public List<Clientespro> gettodosClientes(){
        String hql = "from Clientespro as v";
        crearConexion();
        Query q = sesion.createQuery(hql);
        List<Clientespro> datos = q.list();
        sesion.close();
        return datos;
    }
    
    public void DeleteCliente(Long idcli){
        crearConexion();
        Object o=sesion.load(Clientespro.class, idcli.intValue());
        Clientespro rev = (Clientespro) o;
        sesion.delete(rev);
        tran.commit();
        sesion.close();
    }
    
    public void InsertArtPro(Long idcat, String name, Long precio, String mat, String dim, String text, String foto1, String foto2, String foto3, String foto4, String foto5, String pass, String f1name, String f1type, String f1p1, String f1p2, String f1p3, String f1p4, String f1p5, String f1p6, String f1p7, String f1p8, String f1p9, String f2name, String f2type, String f2p1, String f2p2, String f2p3, String f2p4, String f2p5, String f2p6, String f2p7, String f2p8, String f2p9, String f3name, String f3type, String f3p1, String f3p2, String f3p3, String f3p4, String f3p5, String f3p6, String f3p7, String f3p8, String f3p9, String f4name, String f4type, String f4p1, String f4p2, String f4p3, String f4p4, String f4p5, String f4p6, String f4p7, String f4p8, String f4p9){
        Articulospro artic = new Articulospro();
        Long idart = getNextIdArt();
        Categoriapro catpro = getCatArt(idcat);
        crearConexion();
        artic.setCategoriapro(catpro);
        artic.setDimensions(dim);
        artic.setFoto1(foto1);
        artic.setFoto2(foto2);
        artic.setFoto3(foto3);
        artic.setFoto4(foto4);
        artic.setFoto5(foto5);
        artic.setIdarticulo(idart.intValue());
        artic.setMaterials(mat);
        artic.setNombre(name);
        artic.setPass(pass);
        artic.setPrecio(precio.intValue());
        artic.setText(text);
        sesion.save(artic);
        sesion.getTransaction().commit();
        sesion.close();
        if(pass.equalsIgnoreCase("TRUE")){
            InsertParamPro(idart, f1name, f1type, f1p1, f1p2, f1p3, f1p4, f1p5, f1p6, f1p7, f1p8, f1p9);
            if(!f2name.equalsIgnoreCase("NONE")&&f2name!=null){
                InsertParamPro(idart, f2name, f2type, f2p1, f2p2, f2p3, f2p4, f2p5, f2p6, f2p7, f2p8, f2p9);
                if(!f3name.equalsIgnoreCase("NONE")&&f3name!=null){
                    InsertParamPro(idart, f3name, f3type, f3p1, f3p2, f3p3, f3p4, f3p5, f3p6, f3p7, f3p8, f3p9);
                    if(!f4name.equalsIgnoreCase("NONE")&&f4name!=null){
                        InsertParamPro(idart, f4name, f4type, f4p1, f4p2, f4p3, f4p4, f4p5, f4p6, f4p7, f4p8, f4p9);
                    }
                }
            }
        }
    }
    
    public Long getNextIdArt(){
        String hql="select max(v.idarticulo)+1 from Articulospro as v";
        crearConexion();
        Query q = sesion.createQuery(hql);
        int idnext = (int) q.uniqueResult();
        Long idnext2 = Long.parseLong(String.valueOf(idnext));
        sesion.close();
        return idnext2;
    }
    
    public Categoriapro getCatArt(Long idcat){
        String hql="from Categoriapro as v where v.idcategoria="+idcat;
        crearConexion();
        Query q = sesion.createQuery(hql);
        Categoriapro catpro = (Categoriapro) q.uniqueResult();
        sesion.close();
        return catpro;
    }
    
    public void InsertParamPro(Long idart, String paramname, String ptype, String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8, String p9){
        Articulospro artic = repog.getOneArticle(idart.intValue());
        crearConexion2();
        Parampro par = new Parampro();
        ParamproId parid = new ParamproId();
        parid.setIdarticulo(idart.intValue());
        parid.setParamName(paramname);
        par.setArticulospro(artic);
        par.setId(parid);
        par.setParam1(p1);
        par.setParam2(p2);
        par.setParam3(p3);
        par.setParam4(p4);
        par.setParam5(p5);
        par.setParam6(p6);
        par.setParam7(p7);
        par.setParam8(p8);
        par.setParam9(p9);
        par.setParamType(ptype);
        sesion2.save(par);
        sesion2.getTransaction().commit();
        sesion2.close();
    }
    
    public ArrayList<ModeloItemList> getItemList(){
        String hql = "from Articulospro as v";
        crearConexion();
        Query q = sesion.createQuery(hql);
        List<Articulospro> datos = q.list();
        sesion.close();
        ArrayList<ModeloItemList> itemlist = new ArrayList<>();
        for (Articulospro pro:datos){
            ModeloItemList item = new ModeloItemList();
            Long idarti = Long.valueOf(String.valueOf(pro.getIdarticulo()));
            ArrayList<Parampro> paramlist = (ArrayList<Parampro>)getOneArtParams(idarti);
            int i = 1;
            String add1 = "NONE";
            String add2 = "NONE";
            String add3 = "NONE";
            String add4 = "NONE";
            for (Parampro param:paramlist){
                if(i==1){
                    add1=param.getId().getParamName();
                }else if(i==2){
                    add2=param.getId().getParamName();
                }else if(i==3){
                    add3=param.getId().getParamName();
                }else if(i==4){
                    add4=param.getId().getParamName();
                }
                i++;
            }
            Long idartic = Long.valueOf(String.valueOf(pro.getIdarticulo()));
            item.setIdarticulo(idartic);
            item.setNombre(pro.getNombre());
            Long prec = Long.valueOf(String.valueOf(pro.getPrecio()));
            item.setPrecio(prec);
            item.setMaterials(pro.getMaterials());
            item.setFoto1(pro.getFoto1());
            item.setAdd1(add1);
            item.setAdd2(add2);
            item.setAdd3(add3);
            item.setAdd4(add4);
            itemlist.add(item);
        }
        
        return itemlist;
    }
    
    public List<Parampro> getOneArtParams(Long idart){
        String hql = "from Parampro as v where v.id.idarticulo="+idart;
        crearConexion();
        Query q = sesion.createQuery(hql);
        List<Parampro> datos = q.list();
        sesion.close();
        return datos;
    }
    
    public void DeleteArticulo(Long idart){
        crearConexion();
        Object o=sesion.load(Articulospro.class, idart.intValue());
        Articulospro c = (Articulospro) o;
        sesion.delete(c);
        tran.commit();
        sesion.close();
    }
    
    public ArrayList<ModeloOrders> getAdminOrders(){
        String hql="from Comprapro as v order by v.fechacompra desc";
        crearConexion();
        Query q = sesion.createQuery(hql);
        ArrayList<Comprapro> prolist = (ArrayList<Comprapro>) q.list();
        sesion.close();
        ArrayList<ModeloOrders> orderlist = new ArrayList<>();
        for(Comprapro pro:prolist){
            String hql2 ="from Pedidospro as v where v.id.idcompra=?";
            crearConexion();
            Query q2 = sesion.createQuery(hql2);
            q2.setLong(0, pro.getIdcompra());
            ArrayList<Pedidospro> pedlist = (ArrayList<Pedidospro>) q2.list();
            sesion.close();
            ArrayList<ModeloOrdersArt> modartlist = new ArrayList<>();
            for (Pedidospro ped:pedlist){
                ModeloOrdersArt modart = new ModeloOrdersArt();
                Long idart = Long.valueOf(String.valueOf(ped.getArticulospro().getIdarticulo()));
                modart.setIdart(idart);
                Long artid = idart;
                Articulospro art = repog.getOneArticle(artid.intValue());
                Long prec = Long.valueOf(String.valueOf(art.getPrecio()));
                modart.setPrecio(prec);
                modart.setNombre(art.getNombre());
                modart.setFoto(art.getFoto1());
                modart.setAdd1(ped.getId().getAdd1());
                modart.setAdd2(ped.getId().getAdd2());
                modart.setAdd3(ped.getId().getAdd3());
                modart.setAdd4(ped.getId().getAdd4());
                Long cant = Long.valueOf(String.valueOf(ped.getCantidad()));
                modart.setCant(cant);
                modartlist.add(modart);
            }
            ModeloOrders order = new ModeloOrders();
            String date = pro.getFechacompra().toString();
            order.setFechacompra(date);
            order.setFechaenvio(pro.getFechaenvio());
            String stat;
            if(pro.getFechaenvio().equalsIgnoreCase("none")){
                stat = "PROCESSING";
            }else{
                stat = "SENT";
            }
            order.setStatus(stat);
            order.setIdcompra(pro.getIdcompra());
            order.setModopago(pro.getModopago());
            order.setPreciototal(pro.getPreciototal());
            order.setText(pro.getText());
            order.setPedlist(modartlist);
            int clilong = pro.getClientespro().getIdcliente();
            Clientespro cli = repo.getOneCliente(clilong);
            Long idclie = Long.valueOf(String.valueOf(cli.getIdcliente()));
            order.setIdcliente(idclie);
            order.setNombre(cli.getNombre());
            order.setDireccion(cli.getDireccion());
            order.setTelefono(cli.getTelefono());
            order.setCorreo(cli.getCorreo());
            orderlist.add(order);
        }
        
        return orderlist;
    }
    
    public void UpdateOrderStatus(Long idcompra){
        crearConexion();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Object o=sesion.load(Comprapro.class, idcompra.intValue());
        Comprapro c = (Comprapro) o;
        c.setFechaenvio(date.format(new Date()));
        tran.commit();
        sesion.close();
    }
    
    public List<ModeloAdminReview> getAdminReview(){
        String hql = "select c.nombre, v.stars, v.text, v.fecha, c.idcliente, v.articulospro.idarticulo from Reviewpro as v, Clientespro as c where v.clientespro=c.idcliente order by v.fecha desc";
        crearConexion();
        Query q = sesion.createQuery(hql);
        List datos = q.list();
        sesion.close();
        ArrayList<ModeloAdminReview> arr = new ArrayList<>();
        for (Object objeto: datos){
                ModeloAdminReview rev = new ModeloAdminReview();
                Object[] registro = (Object[]) objeto;
                String nom = (String) registro[0];
                int star = (int) registro[1];
                String text = (String) registro[2];
                Date fecha = (Date) registro [3];
                int idcli = (int) registro [4];
                int idart = (int) registro [5];
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String s = df.format(fecha);
                rev.setNombre(nom);
                rev.setStars(star);
                rev.setText(text);
                rev.setFecha(s);
                rev.setIdcliente(idcli);
                rev.setVercompra(repog.getVerificarCompra(idcli, idart));
                Long idart2 = Long.parseLong(String.valueOf(idart));
                rev.setIdarticulo(idart2);
                rev.setArtnombre(repog.getOneArticle(idart).getNombre());
                arr.add(rev);
        }
        return arr;
    }
    
    public void DeleteReview(Long idcli, Long idart){
        crearConexion();
        ReviewproId revid = new ReviewproId();
        revid.setIdarticulo(idart.intValue());
        revid.setIdcliente(idcli.intValue());
        Object o=sesion.load(Reviewpro.class, revid);
        Reviewpro rev = (Reviewpro) o;
        sesion.delete(rev);
        tran.commit();
        sesion.close();
    }
    
    public List<ModeloAdminReview> getAdminReviewOneClient(Long idcliente){
        String hql = "select c.nombre, v.stars, v.text, v.fecha, c.idcliente, v.articulospro.idarticulo from Reviewpro as v, Clientespro as c where v.clientespro=c.idcliente and v.clientespro.idcliente="+idcliente+"order by v.fecha desc";
        crearConexion();
        Query q = sesion.createQuery(hql);
        List datos = q.list();
        sesion.close();
        ArrayList<ModeloAdminReview> arr = new ArrayList<>();
        for (Object objeto: datos){
                ModeloAdminReview rev = new ModeloAdminReview();
                Object[] registro = (Object[]) objeto;
                String nom = (String) registro[0];
                int star = (int) registro[1];
                String text = (String) registro[2];
                Date fecha = (Date) registro [3];
                int idcli = (int) registro [4];
                int idart = (int) registro [5];
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String s = df.format(fecha);
                rev.setNombre(nom);
                rev.setStars(star);
                rev.setText(text);
                rev.setFecha(s);
                rev.setIdcliente(idcli);
                rev.setVercompra(repog.getVerificarCompra(idcli, idart));
                Long idart2 = Long.parseLong(String.valueOf(idart));
                rev.setIdarticulo(idart2);
                rev.setArtnombre(repog.getOneArticle(idart).getNombre());
                arr.add(rev);
        }
        return arr;
    }
    
    
    
}
