package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Programa_Bean;
import util.ClassConexion;

public class Programa_Dao extends ClassConexion {


    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_programa;
    public String nombre_programa;
    public long id_area_programa;

    public Programa_Dao(Programa_Bean Programa) {
        super();
            conn = this.obtenerConexion();

            id_programa = Programa.getId_programa();
            nombre_programa = Programa.getNombre_programa();
            id_area_programa = Programa.getId_area_programa();
    }
    
    public boolean insertar_programa() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_programa (?,?,?)}");
            cst.setLong(1, id_programa);
            cst.setString(2, nombre_programa);
            cst.setLong(3, id_area_programa);

            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_programa() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_programa (?,?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_programa);
            cst.setString(2, nombre_programa);
            cst.setLong(3, id_area_programa);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_programa() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_programa (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_programa);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Programa_Bean ver_estado() {
        Programa_Bean pb = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_programa (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_programa);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(2, java.sql.Types.DOUBLE);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            pb = new Programa_Bean(id_programa, cst.getString(2), cst.getLong(3));
        } catch (SQLException e) {
        }
        return pb;
    }
}
