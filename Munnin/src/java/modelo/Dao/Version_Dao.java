package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import modelo.Beans.Version_Bean;
import util.ClassConexion;

public class Version_Dao extends ClassConexion {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_version;
    public long numero_version;
    public String url_version;
    public boolean notificacion_version;
    public Date fecha_version;
    public Date fecha_caducidad_version;
    public Date fecha_aprovacion_version;
    public int id_estdo_version;
    public int id_tipo_archivo_version;
    public int id_producto_version;
    public String id_centro_version;

    public Version_Dao(Version_Bean Version) {
        super();
        conn = this.obtenerConexion();

        id_version = Version.getId_version();
        numero_version = Version.getNumero_version();
        url_version = Version.getUrl_version();
        notificacion_version = Version.isNotificacion_version();
        fecha_version = Version.getFecha_version();
        fecha_caducidad_version = Version.getFecha_caducidad_version();
        fecha_aprovacion_version = Version.getFecha_aprovacion_version();
        id_estdo_version = Version.getId_estdo_version();
        id_tipo_archivo_version = Version.getId_tipo_archivo_version();
        id_producto_version = Version.getId_producto_version();
        id_centro_version = Version.getId_centro_version();
    }

    public boolean insertar_version() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_version (?,?,?,?,?,?,?,?,?,?,?)}");
            cst.setLong(1, id_version);
            cst.setLong(2, numero_version);
            cst.setString(3, url_version);
            cst.setBoolean(4, notificacion_version);
            cst.setDate(5, (java.sql.Date) fecha_version);
            cst.setDate(6, (java.sql.Date) fecha_caducidad_version);
            cst.setDate(7, (java.sql.Date) fecha_aprovacion_version);
            cst.setInt(8, id_estdo_version);
            cst.setInt(9, id_tipo_archivo_version);
            cst.setInt(10, id_producto_version);
            cst.setString(11, id_centro_version);

            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_version() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_lista_chequeo (?,?,?,?,?,?,?,?,?,?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_version);
            cst.setLong(2, numero_version);
            cst.setString(3, url_version);
            cst.setBoolean(4, notificacion_version);
            cst.setDate(5, (java.sql.Date) fecha_version);
            cst.setDate(6, (java.sql.Date) fecha_caducidad_version);
            cst.setDate(7, (java.sql.Date) fecha_aprovacion_version);
            cst.setInt(8, id_estdo_version);
            cst.setInt(9, id_tipo_archivo_version);
            cst.setInt(10, id_producto_version);
            cst.setString(11, id_centro_version);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_version() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_version (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_version);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Version_Bean ver_eval_version_general() {
        Version_Bean vb = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_lista_chequeo (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_version);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.DOUBLE);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            cst.registerOutParameter(4, java.sql.Types.BOOLEAN);
            cst.registerOutParameter(5, java.sql.Types.DATE);
            cst.registerOutParameter(6, java.sql.Types.DATE);
            cst.registerOutParameter(7, java.sql.Types.DATE);
            cst.registerOutParameter(8, java.sql.Types.INTEGER);
            cst.registerOutParameter(9, java.sql.Types.INTEGER);
            cst.registerOutParameter(10, java.sql.Types.INTEGER);
            cst.registerOutParameter(11, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            vb = new Version_Bean(id_version, cst.getLong(2), cst.getString(3), cst.getBoolean(4), cst.getDate(5), cst.getDate(6), cst.getDate(7), cst.getInt(8), cst.getInt(9), cst.getInt(10), cst.getString(11));
        } catch (SQLException e) {
        }
        return vb;
    }
}
