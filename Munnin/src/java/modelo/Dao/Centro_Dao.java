package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.ClassConexion;
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
        conn = this.obtenerConexion();

        id_centro = Centro.getId_centro();
        nombre_centro = Centro.getNombre_centro();
        id_regional_centro = Centro.getId_regional_centro();
        id_ciudad_centro = Centro.getId_centro();
    }

    public boolean insertar_centro() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_centro (?,?,?,?)}");
            cst.setString(1, id_centro);
            cst.setString(2, nombre_centro);
            cst.setString(3, id_regional_centro);
            cst.setString(4, id_ciudad_centro);

            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_centro() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_centro (?,?,?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setString(1, id_centro);
            cst.setString(2, nombre_centro);
            cst.setString(3, id_regional_centro);
            cst.setString(4, id_ciudad_centro);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_centro() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_centro (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setString(1, id_centro);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Centro_Bean ver_centro() {
        Centro_Bean ceb = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_centro (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setString(1, id_centro);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            cst.registerOutParameter(4, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            ceb = new Centro_Bean(id_centro, cst.getString(2), cst.getString(3), cst.getString(4));
        } catch (SQLException e) {
        }
        return ceb;
    }
}
