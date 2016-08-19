
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Estado_Bean;
import util.ClassConexion;


public class Estado_Dao extends ClassConexion{

    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_estado;
    public String nombre_estado;

    

    
    public Estado_Dao(Estado_Bean Estado) {
        super();
            conn = this.obtenerConexion();

            id_estado = Estado.getId_estado();
            nombre_estado = Estado.getNombre_estado();
    
    }
    
    public boolean insertar_estado() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_estado (?,?)}");
            cst.setLong(1, id_estado);
            cst.setString(2, nombre_estado);

            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_estado() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_estado (?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_estado);
            cst.setString(2, nombre_estado);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_estado() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_estado (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_estado);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Estado_Bean ver_estado() {
        Estado_Bean eb = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_estado (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_estado);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            eb = new Estado_Bean(id_estado, cst.getString(2));
        } catch (SQLException e) {
        }
        return eb;
    }
}
