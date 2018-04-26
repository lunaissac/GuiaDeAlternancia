
package com.GuiaAlterElect.dao;

import com.GuiaAlterElect.model.Actividades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ActividadDao extends Dao{
    
        
    public  void registrar(Actividades per) throws Exception {
        try {
            this.Conectar();
             PreparedStatement st =this.getCn().prepareStatement("insert into Actividades (nombre,precio) values (?,?)");
          
            st.setString(1, per.getNombre());
            st.setDouble(2, per.getPrecio());
            st.executeUpdate();
          
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    public List<Actividades> listar() throws Exception{
        List<Actividades> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st=this.getCn().prepareCall("Select codigo,nombre,precio from Actividades");
            rs=st.executeQuery();
            lista=new ArrayList();
            while(rs.next()){
               Actividades per =new Actividades() ;
               per.setCodigo(rs.getInt("codigo"));
                    per.setNombre(rs.getString("nombre"));
                      per.setPrecio(rs.getDouble("precio"));
               lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
          this.Cerrar();
            
        }
        return lista;
     } 
    
    public Actividades LeerID(Actividades per) throws Exception{
        Actividades pers = null;
        ResultSet rs;
         
    try {
            this.Conectar();
             PreparedStatement st =this.getCn().prepareStatement("SELECT codigo, nombre,precio FROM Actividades WHERE codigo = ?");
          
            st.setInt(1, per.getCodigo());
            rs=st.executeQuery();
            while(rs.next()){
                pers=new Actividades();
                pers.setCodigo(rs.getInt("codigo"));
                  pers.setNombre(rs.getString("nombre"));
                    pers.setPrecio(rs.getDouble("precio"));
            }
          
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    return pers;
    }
   
    
     public  void modificar(Actividades per) throws Exception {
        try {
            this.Conectar();
             PreparedStatement st =this.getCn().prepareStatement("UPDATE Actividades SET nombre=?,precio=? WHERE codigo = ?");
          
            st.setString(1, per.getNombre());
            st.setDouble(2, per.getPrecio());
             st.setInt(3,per.getCodigo());
            st.executeUpdate();
          
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
public  void eliminar(Actividades per) throws Exception {
        try {
            this.Conectar();
             PreparedStatement st =this.getCn().prepareStatement("DELETE FROM Actividades WHERE codigo =?");
             st.setInt(1,per.getCodigo());
            st.executeUpdate();
          
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
 }
