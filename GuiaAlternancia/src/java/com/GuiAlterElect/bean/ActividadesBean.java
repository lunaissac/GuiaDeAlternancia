/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GuiAlterElect.bean;

import com.GuiaAlterElect.dao.ActividadDao;
import com.GuiaAlterElect.model.Actividades;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ActividadesBean {
    private Actividades Activid =new Actividades();
    private List<Actividades> listActivid;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
        this.limpiar();
    }
    

    public List<Actividades> getListActivid() {
        return listActivid;
    }

    public void setListActivid(List<Actividades> listActivid) {
        this.listActivid = listActivid;
    }
    
    
    public Actividades getActivid() {
        return Activid;
    }

    public void setActivid(Actividades persona) {
        this.Activid = persona;
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
       this.Activid.setCodigo(0);
       this.Activid.setNombre("");
  
   }
    
    
   private void registrar()throws Exception{
        ActividadDao dao;
        try {
            dao=new ActividadDao();
            dao.registrar(Activid);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
          private void modificar()throws Exception{
        ActividadDao dao;
        try {
            dao=new ActividadDao();
            dao.modificar(Activid);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
          
          
          
          
             
    
      public void listar(String valor)throws Exception{
        ActividadDao dao;
        
        try {
            if(valor.equals("F")){
                if(isPostBack()==false){
               dao=new ActividadDao();
            listActivid =dao.listar(); 
            }
                
            }else{
                dao=new ActividadDao();
            listActivid =dao.listar();  
            }
            
            
        } catch (Exception e) {
            throw e;
        }
    
    }
      public void leerID(Actividades per) throws Exception{
             ActividadDao dao;
             Actividades temp;
        try {
            dao=new ActividadDao();
            temp=dao.LeerID(per);
            if(temp!=null){
                this.Activid=temp;
                this.accion="Modificar";
                
            }
        } catch (Exception e) {
            throw e;
        } 
        
      }
   
    public void EliminarID(Actividades per) throws Exception{
             ActividadDao dao;
        
        try {
            dao=new ActividadDao();
           dao.eliminar(per);
           this.listar("V");
        } catch (Exception e) {
            throw e;
        } 
      }
      
}
