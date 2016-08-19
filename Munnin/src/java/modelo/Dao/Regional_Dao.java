package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Regional_Bean;
import util.ClassConexion;


public class Regional_Dao extends ClassConexion{

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_regional;
    public String nombre_regional;

    public Regional_Dao(Regional_Bean Regional) {
        super();
            conn = this.obtenerConexion();

            id_regional = Regional.getId_regional();
            nombre_regional = Regional.getNombre_regional();
    }
    
    public boolean insertar_regional() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_regional (?,?)}");
            cst.setLong(1, id_regional);
            cst.setString(2, nombre_regional);

            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_regional() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_regional (?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_regional);
            cst.setString(2, nombre_regional);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_regional() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_regional (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_regional);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Regional_Bean ver_regional() {
        Regional_Bean rb = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_regional (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_regional);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            rb = new Regional_Bean(id_regional, cst.getString(2));
        } catch (SQLException e) {
        }
        return rb;
    }
}
