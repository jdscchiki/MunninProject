package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Tipo_Objeto_Aprendizaje_Bean;
import util.ClassConexion;

public class Tipo_Objeto_Aprendizaje_Dao extends ClassConexion {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_tipo_objeto_aprendizaje;
    public String nombre_tipo_objeto_aprendizaje;

    public Tipo_Objeto_Aprendizaje_Dao(Tipo_Objeto_Aprendizaje_Bean Tipo_Objeto_Apre) {
        super();
        conn = this.obtenerConexion();
        id_tipo_objeto_aprendizaje = Tipo_Objeto_Apre.getId_tipo_objeto_aprendizaje();
        nombre_tipo_objeto_aprendizaje = Tipo_Objeto_Apre.getNombre_tipo_objeto_aprendizaje();

    }
    
public boolean insertar_tipo_objeto_aprendizaje() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_tipo_objeto_aprendizaje (?,?)}");
            cst.setLong(1, id_tipo_objeto_aprendizaje);
            cst.setString(2, nombre_tipo_objeto_aprendizaje);
            cst.execute();
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_tipo_objeto_aprendizaje() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_tipo_objeto_aprendizaje(?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_tipo_objeto_aprendizaje);
            cst.setString(2, nombre_tipo_objeto_aprendizaje);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_tipo_objeto_aprendizaje() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_tipo_objeto_aprendizaje (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_tipo_objeto_aprendizaje);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            } catch (SQLException e) {
        }
        return listo;
    }

    public Tipo_Objeto_Aprendizaje_Bean ver_tipo_objeto_aprendizaje() {
        Tipo_Objeto_Aprendizaje_Bean tad = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_tipo_objeto_aprendizaje (?)}");
             // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_tipo_objeto_aprendizaje);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            tad = new Tipo_Objeto_Aprendizaje_Bean(id_tipo_objeto_aprendizaje, cst.getString(2));
        } catch (SQLException e) {
        }
        return tad;
    }
}
