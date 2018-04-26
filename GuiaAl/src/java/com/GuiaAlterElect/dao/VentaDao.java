
package com.GuiaAlterElect.dao;

import com.GuiaAlterElect.model.DetalleVenta;
import com.GuiaAlterElect.model.Ventas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;



public class VentaDao extends Dao{
        public void registrar(Ventas venta, List<DetalleVenta> lista) throws Exception {
        try {
            this.Conectar();
            this.getCn().setAutoCommit(false);
             PreparedStatement st =this.getCn().prepareStatement("insert into Venta (fecha,codPersona,monto) values (?,?,?)");
          
            st.setDate(1,venta.getFecha());
            st.setInt(2,venta.getEstudiante().getCodigo());
            st.setDouble(3,venta.getMonto());
            st.executeUpdate();
          st.close();
           PreparedStatement st2=this.getCn().prepareStatement("SELECT LAST_INSERT_ID() FROM Venta limit 1");
                   ResultSet rs;
                   int codVenta=0;
                   rs=st2.executeQuery();
                   while(rs.next()){
                       codVenta=rs.getInt(1);
                   }
                   rs.close();
          for(DetalleVenta det :lista){
               PreparedStatement st3 =this.getCn().prepareStatement("insert into DetalleVenta (codVenta,codActivid,cantidad) values (?,?,?)");
            st3.setInt(1, codVenta);
            st3.setInt(2,det.getActivi().getCodigo());
            st3.setDouble(3,det.getCantidad());
            st3.executeUpdate();
            st3.close();
          }
          this.getCn().commit();
           
        } catch (Exception e) {
            this.getCn().rollback();
            throw e;
        }finally{
            this.Cerrar();
        }
    }
}
