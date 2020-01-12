
package models;

import java.util.ArrayList;


public class ModeloOrders {
    private long idcompra;
    private String fechacompra;
    private long preciototal;
    private String text;
    private String modopago;
    private String fechaenvio;
    private String status;
    private ArrayList<ModeloOrdersArt> pedlist; 
    private Long idcliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(long idcompra) {
        this.idcompra = idcompra;
    }

    public String getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(String fechacompra) {
        this.fechacompra = fechacompra;
    }

    public long getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(long preciototal) {
        this.preciototal = preciototal;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getModopago() {
        return modopago;
    }

    public void setModopago(String modopago) {
        this.modopago = modopago;
    }

    public String getFechaenvio() {
        return fechaenvio;
    }

    public void setFechaenvio(String fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ModeloOrdersArt> getPedlist() {
        return pedlist;
    }

    public void setPedlist(ArrayList<ModeloOrdersArt> pedlist) {
        this.pedlist = pedlist;
    }
    
}
