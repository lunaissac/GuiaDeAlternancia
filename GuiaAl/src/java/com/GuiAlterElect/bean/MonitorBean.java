/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GuiAlterElect.bean;

import com.GuiaAlterElect.dao.MonitorDao;
import com.GuiaAlterElect.model.Monitor;
import com.GuiaAlterElect.model.Monitor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

@ManagedBean
@SessionScoped
public class MonitorBean {
    private Monitor monitor =new Monitor();
    private List<Monitor> listMonitors;

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
    
    private String accion;
    

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
        this.limpiar();
    }
    

    public List<Monitor> getListMonitors() {
        return listMonitors;
    }

    public void setListMonitors(List<Monitor> listMonitors) {
        this.listMonitors = listMonitors;
    }
    
    

    
private boolean isPostBack(){
    boolean rpta ;
    rpta=FacesContext.getCurrentInstance().isPostback();
        return rpta;
}
    
    
    
    
    public void operar() throws Exception{
        switch(accion){
            case "Registrar":this.registrar();this.limpiar();break;
             case "Modificar":this.modificar();this.limpiar();break;
            
        }
        
    }
   public void limpiar(){
       this.monitor.setCodigo(0);
       this.monitor.setNombre("");
       this.monitor.setApellido("");
        this.monitor.setDni(0);
       this.monitor.setEmail("");
        this.monitor.setTelf(0);
       this.monitor.setDir("");
       
   }
    
    
   private void registrar()throws Exception{
        MonitorDao dao;
        try {
            dao=new MonitorDao();
            dao.registrar(monitor);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
          private void modificar()throws Exception{
        MonitorDao dao;
        try {
            dao=new MonitorDao();
            dao.modificar(monitor);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
          
          
          
          
    
      public void listar(String valor)throws Exception{
        MonitorDao dao;
        
        try {
            if(valor.equals("F")){
                if(isPostBack()==false){
               dao=new MonitorDao();
            listMonitors =dao.listar(); 
            }
                
            }else{
                dao=new MonitorDao();
            listMonitors =dao.listar();  
            }
            
            
        } catch (Exception e) {
            throw e;
        }
    
    }
      public void leerID(Monitor per) throws Exception{
             MonitorDao dao;
             Monitor temp;
        try {
            dao=new MonitorDao();
            temp=dao.LeerID(per);
            if(temp!=null){
                this.monitor=temp;
                this.accion="Modificar";
                
            }
        } catch (Exception e) {
            throw e;
        } 
        
      }
   
    public void EliminarID(Monitor per) throws Exception{
             MonitorDao dao;
        
        try {
            dao=new MonitorDao();
           dao.eliminar(per);
           this.listar("V");
        } catch (Exception e) {
            throw e;
        } 
      }
      
}
