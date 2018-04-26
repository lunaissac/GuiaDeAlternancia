
package com.GuiAlterElect.bean;

import com.GuiaAlterElect.dao.VentaDao;
import com.GuiaAlterElect.model.Actividades;
import com.GuiaAlterElect.model.DetalleVenta;
import com.GuiaAlterElect.model.Ventas;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class VentaBean {
    private Ventas venta= new Ventas();
    private Actividades activid = new Actividades();
    private int cantidad;
    private List<DetalleVenta>lista=new ArrayList();

    public List<DetalleVenta> getLista() {
        return lista;
    }

    public void setLista(List<DetalleVenta> lista) {
        this.lista = lista;
    }
    
    
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    public Actividades getActivid() {
        return activid;
    }

    public void setActivid(Actividades activid) {
        this.activid = activid;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }
    public void agregar(){
        DetalleVenta det = new DetalleVenta();
        det.setCantidad(cantidad);
        det.setActivi(activid);
        this.lista.add(det);
    }
    public void registrar() throws Exception{
        VentaDao dao;
        double monto = 0;
        try {
            for(DetalleVenta det:lista){
                //sumar el precio de la lista
                monto +=det.getActivi().getPrecio();
            }
            dao=new VentaDao();
            venta.setMonto(monto);
            
            dao.registrar(venta, lista);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
