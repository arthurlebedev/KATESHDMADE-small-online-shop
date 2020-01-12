
package models;

import java.util.Date;


public class ModeloAdminReview {
    private String nombre;
    private int stars;
    private String text;
    private String fecha;
    private int idcliente;
    private int vercompra;
    private Long idarticulo;
    private String artnombre;

    public String getArtnombre() {
        return artnombre;
    }

    public void setArtnombre(String artnombre) {
        this.artnombre = artnombre;
    }

    public Long getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Long idarticulo) {
        this.idarticulo = idarticulo;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getVercompra() {
        return vercompra;
    }

    public void setVercompra(int vercompra) {
        this.vercompra = vercompra;
    }
}
