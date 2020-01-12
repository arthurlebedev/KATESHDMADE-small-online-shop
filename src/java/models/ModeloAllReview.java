package models;

import java.util.Date;


public class ModeloAllReview {
    private String nombre;
    private int stars;
    private String text;
    private Date fecha;
    private int idcliente;
    private int vercompra;




    public int getVercompra() {
        return vercompra;
    }

    public void setVercompra(int vercompra) {
        this.vercompra = vercompra;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
