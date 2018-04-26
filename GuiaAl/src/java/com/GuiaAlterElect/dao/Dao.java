/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GuiaAlterElect.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alumno
 */
public class Dao {
    
   
    
    public  Connection cn;

    public Connection getCn(){
        // si esta abierta la conexión
            return cn;
          }
    public void setCon(Connection cn){
        this.cn=cn;
    }
        public void Conectar() throws Exception{
            
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           cn=DriverManager.getConnection("jdbc:sqlserver://35.229.54.77:1433;database=GuiaElect", "root", "root");
  
        } catch (Exception e) {
         throw e;
        }
       
    }
   public void Cerrar()  throws Exception{
       try {
           if(cn !=null){
               if(cn.isClosed() ==false){
                   cn.close();
               }
           }
       } catch (Exception e) {
           throw e;
       }
   }

        
    
}
