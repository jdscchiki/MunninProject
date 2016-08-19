
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Centro_Bean;
import util.ClassConexion;


public class Centro_Dao extends ClassConexion {
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public String id_centro;
    public String nombre_centro;
    public String id_regional_centro;
    public String id_ciudad_centro;

    
    public Centro_Dao(Centro_Bean Centro) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_centro = Centro.getId_centro();
            nombre_centro = Centro.getNombre_centro();
            id_regional_centro = Centro.getId_regional_centro();
            id_ciudad_centro = Centro.getId_centro();
            

        } catch (SQLException e) {
        }
}
}
