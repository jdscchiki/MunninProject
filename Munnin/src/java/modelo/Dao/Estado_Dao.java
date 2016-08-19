
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Estado_Bean;
import util.ClassConexion;


public class Estado_Dao extends ClassConexion {
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_estado;
    public String nombre_estado;

    

    
    public Estado_Dao(Estado_Bean Estado) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_estado = Estado.getId_estado();
            nombre_estado = Estado.getNombre_estado();
            

        } catch (SQLException e) {
        }
    
    }
    
}
