
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Ciudad_Bean;


public class Ciudad_Dao {
  
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;
    
    public boolean encontrado = false;
    public boolean listo = false;
    
     public String id_ciudad = "";
    public String nombre_ciudad="";
    
    public Ciudad_Dao(Ciudad_Bean Ciudad){
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();
            
            
            id_ciudad = Ciudad.getId_ciudad();
            nombre_ciudad= Ciudad.getNombre_ciudad();
            
        } catch (SQLException e) {            
        }
    }
    
}
