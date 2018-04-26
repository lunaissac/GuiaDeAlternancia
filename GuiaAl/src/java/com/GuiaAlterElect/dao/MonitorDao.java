
package com.GuiaAlterElect.dao;

import com.GuiaAlterElect.model.Monitor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MonitorDao extends Dao{
    
        
    public  void registrar(Monitor per) throws Exception {
        try {
            this.Conectar();
             PreparedStatement st =this.getCn().prepareStatement("insert into Monitor (nombre,apellido,dni,email,telf,dir) values (?,?,?,?,?,?)");
          
            st.setString(1, per.getNombre());
            st.setString(2,per.getApellido());
            st.setInt(3, per.getDni());
            st.setString(4,per.getEmail());
            st.setInt(5, per.getTelf());
            st.setString(6,per.getDir());
            
            st.executeUpdate();
          
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    public List<Monitor> listar() throws Exception{
        List<Monitor> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st=this.getCn().prepareCall("Select codigo,nombre,apellido,dni,email,telf,dir from Monitor");
            rs=st.executeQuery();
            lista=new ArrayList();
            while(rs.next()){
               Monitor per =new Monitor() ;
               per.setCodigo(rs.getInt("codigo"));
                    per.setNombre(rs.getString("nombre"));
                         per.setApellido(rs.getString("apellido"));
                         per.setDni(rs.getInt("dni"));
                    per.setEmail(rs.getString("email"));
                         per.setTelf(rs.getInt("telf"));
                               per.setDir(rs.getString("dir"));
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
    
    public Monitor LeerID(Monitor per) throws Exception{
        Monitor pers = null;
        ResultSet rs;
         
    try {
            this.Conectar();
             PreparedStatement st =this.getCn().prepareStatement("SELECT codigo, nombre,apellido,dni,email,telf,dir FROM Monitor WHERE codigo = ?");
          
            st.setInt(1, per.getCodigo());
            rs=st.executeQuery();
            while(rs.next()){
                pers=new Monitor();
                pers.setCodigo(rs.getInt("codigo"));
                  pers.setNombre(rs.getString("nombre"));
                    pers.setApellido(rs.getString("apellido"));
                     pers.setDni(rs.getInt("dni"));
                  pers.setEmail(rs.getString("email"));
                    pers.setTelf(rs.getInt("telf"));
                       pers.setDir(rs.getString("dir"));
            }
          
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    return pers;
    }
   
    
     public  void modificar(Monitor per) throws Exception {
        try {
            this.Conectar();
             PreparedStatement st =this.getCn().prepareStatement("UPDATE Monitor SET nombre=?,apellido=?,dni=?,email=?,telf=?,dir=? WHERE codigo = ?");
          
            st.setString(1, per.getNombre());
            st.setString(2,per.getApellido());
             st.setInt(3,per.getDni());
              st.setString(4, per.getEmail());
            st.setInt(5,per.getTelf());
             st.setString(6,per.getDir());
               st.setInt(7,per.getCodigo());
            st.executeUpdate();
          
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
public  void eliminar(Monitor per) throws Exception {
        try {
            this.Conectar();
             PreparedStatement st =this.getCn().prepareStatement("DELETE FROM Monitor WHERE codigo =?");
             st.setInt(1,per.getCodigo());
            st.executeUpdate();
          
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
 }
