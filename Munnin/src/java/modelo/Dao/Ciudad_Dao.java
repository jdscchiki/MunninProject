package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Ciudad_Bean;
import util.ClassConexion;

public class Ciudad_Dao extends ClassConexion {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public String id_ciudad = "";
    public String nombre_ciudad = "";

    public Ciudad_Dao(Ciudad_Bean Ciudad) {
        super();
        conn = this.obtenerConexion();
        id_ciudad = Ciudad.getId_ciudad();
        nombre_ciudad = Ciudad.getNombre_ciudad();

    }
    public boolean insertar_ciudad() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_ciudad (?,?)}");
            
            cst.setString(1, id_ciudad);
            cst.setString(2, nombre_ciudad);
            cst.execute();
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_ciudad() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_ciudad (?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setString(1, id_ciudad);
            cst.setString(2, nombre_ciudad);
           // Ejecuta el procedimiento almacenado
            cst.execute();
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_ciudad() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_ciudad (?)}");
// Se envian parametros del procedimiento almacenado
            cst.setString(1, id_ciudad);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            } catch (SQLException e) {
        }
        return listo;
    }

    public Ciudad_Bean ver_ciudad() {
        Ciudad_Bean ciu = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_ciudad (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setString(1, id_ciudad);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            ciu = new Ciudad_Bean(id_ciudad, cst.getString(2));
        } catch (SQLException e) {
        }
        return ciu;
    }
}
     
