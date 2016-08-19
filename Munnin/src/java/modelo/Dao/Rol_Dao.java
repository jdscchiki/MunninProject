
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Rol_Bean;

public class Rol_Dao {
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_rol;
    public String nombre_rol;
    public String descripcion_rol;

    public Rol_Dao(Rol_Bean Rol) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_rol = Rol.getId_rol();
            nombre_rol = Rol.getNombre_rol();
            descripcion_rol = Rol.getDescripcion_rol();

        } catch (SQLException e) {
        }
    }
}
