/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GuiAlterElect.bean;

import com.GuiaAlterElect.dao.EstudianteDao;
import com.GuiaAlterElect.model.Estudiante;
import com.GuiaAlterElect.model.Estudiante;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

@ManagedBean
@SessionScoped
public class EstudianteBean {
    private Estudiante estudiante =new Estudiante();
    private List<Estudiante> listEstudiantes;

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    private String accion;
    

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
        this.limpiar();
    }
    

    public List<Estudiante> getListEstudiantes() {
        return listEstudiantes;
    }

    public void setListEstudiantes(List<Estudiante> listEstudiantes) {
        this.listEstudiantes = listEstudiantes;
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
       this.estudiante.setCodigo(0);
       this.estudiante.setNombre("");
       this.estudiante.setApellido("");
        this.estudiante.setDni(0);
       this.estudiante.setEmail("");
        this.estudiante.setTelf(0);
       this.estudiante.setDir("");
       
   }
    
    
   private void registrar()throws Exception{
        EstudianteDao dao;
        try {
            dao=new EstudianteDao();
            dao.registrar(estudiante);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
          private void modificar()throws Exception{
        EstudianteDao dao;
        try {
            dao=new EstudianteDao();
            dao.modificar(estudiante);
            this.listar("V");
        } catch (Exception e) {
            throw e;
        }
    }
          
          
          
          
    
      public void listar(String valor)throws Exception{
        EstudianteDao dao;
        
        try {
            if(valor.equals("F")){
                if(isPostBack()==false){
               dao=new EstudianteDao();
            listEstudiantes =dao.listar(); 
            }
                
            }else{
                dao=new EstudianteDao();
            listEstudiantes =dao.listar();  
            }
            
            
        } catch (Exception e) {
            throw e;
        }
    
    }
      public void leerID(Estudiante per) throws Exception{
             EstudianteDao dao;
             Estudiante temp;
        try {
            dao=new EstudianteDao();
            temp=dao.LeerID(per);
            if(temp!=null){
                this.estudiante=temp;
                this.accion="Modificar";
                
            }
        } catch (Exception e) {
            throw e;
        } 
        
      }
   
    public void EliminarID(Estudiante per) throws Exception{
             EstudianteDao dao;
        
        try {
            dao=new EstudianteDao();
           dao.eliminar(per);
           this.listar("V");
        } catch (Exception e) {
            throw e;
        } 
      }
      
}
