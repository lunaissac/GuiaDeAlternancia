
package com.GuiaAlterElect.model;

public class DetalleVenta {
    private int codigo;
    private Ventas venta;
    private Actividades activi; 
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public Actividades getActivi() {
        return activi;
    }

    public void setActivi(Actividades activi) {
        this.activi = activi;
    }
    
    
}
