
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import modelo.Beans.Lista_Chequeo_Bean;
import util.ClassConexion;


public class Lista_Chequeo_Dao extends ClassConexion{
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_lista;
    public String nombre_lista;
    public String descripcion_lista;
    public Date fecha_lista;
    public String tipo_lista;
    public long id_autor_lista;
    
    public Lista_Chequeo_Dao(Lista_Chequeo_Bean Lista_Chequeo) {
        super();
            conn = this.obtenerConexion();

            id_lista = Lista_Chequeo.getId_lista();
            nombre_lista = Lista_Chequeo.getNombre_lista();
            descripcion_lista = Lista_Chequeo.getDescripcion_lista();
            fecha_lista = Lista_Chequeo.getFecha_lista();
            tipo_lista = Lista_Chequeo.getTipo_lista();
            id_autor_lista = Lista_Chequeo.getId_autor_lista();
    
    } 
    
    public boolean insertar_lista_chequeo_dao() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_lista_chequeo_dao (?,?,?,?,?,?,?)}");
            cst.setLong(1, id_lista);
            cst.setString(2, nombre_lista);
            cst.setString(3, descripcion_lista);
            cst.setDate(4, (java.sql.Date) fecha_lista);
            cst.setString(5, tipo_lista);
            cst.setLong(6, id_autor_lista);            

            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_lista_chequeo() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_lista_chequeo (?,?,?,?,?,?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_lista);
            cst.setString(2, nombre_lista);
            cst.setString(3, descripcion_lista);
            cst.setDate(4, (java.sql.Date) fecha_lista);
            cst.setString(5, tipo_lista);
            cst.setLong(6, id_autor_lista);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_lista_chequeo() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_lista_chequeo (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_lista);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Lista_Chequeo_Bean ver_eval_version_general() {
        Lista_Chequeo_Bean lcb = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_lista_chequeo (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_lista);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            cst.registerOutParameter(4, java.sql.Types.DATE);
            cst.registerOutParameter(5, java.sql.Types.VARCHAR);
            cst.registerOutParameter(6, java.sql.Types.DOUBLE);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            lcb = new Lista_Chequeo_Bean(id_lista, cst.getString(2), cst.getString(3), cst.getDate(4), cst.getString(5),cst.getLong(6));
        } catch (SQLException e) {
        }
        return lcb;
    }
}
