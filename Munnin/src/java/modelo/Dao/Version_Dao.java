package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.naming.NamingException;
import modelo.Beans.Version_Bean;
import util.ClassConexion;
import util.ConexionBD;

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * Version.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

public class Version_Dao extends ConexionBD {

    private static final String COL_ID_VERSION = "id_version";
    private static final String COL_NUMERO_VERSION = "numero_version";
    private static final String COL_URL_VERSION = "url_version";
    private static final String COL_NOTIFICACION_VERSION = "notificacion_version";
    private static final String COL_FECHA_VERSION = "fecha_version";
    private static final String COL_FECHA_CADUCIDAD_VERSION= "fecha_caducidad_version";
    private static final String COL_FECHA_APROVACION_VERSION = "fecha_aprovacion_version";
    private static final String COL_ID_ESTADO_VERSION = "id_estdo_version";
    private static final String COL_ID_TIPO_ARCHIVO_VERSION = "id_tipo_archivo_version";
    private static final String COL_ID_PRODUCTO_VERSION = "id_producto_version";
    private static final String COL_ID_CENTRO_VERSION = "id_centro_version";
    
    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Version_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param version
     * @return Retorna Null si el Version no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Version.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean InsertarVersion(Version_Bean version) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        // datos de la consulta en base de datos
        String query ="{CALL INSERTAR_VERSION(?,?,?,?,?,?,?,?,?,?,?)}";
        int indexIdVersion =1;
        int indexNumeroversion =2;
        int indexUrlVersion =3;
        int indexNotificacionVersion =4;
        int indexFechaVersion =5;
        int indexfechaCaducidad =6;
        int indexfechaAprovacion =7;
        int indexIdEstadoVersion =8;
        int indexIdTipoArchivo =9;
        int indexIdProductoversion =10;
        int indexIdCentroVersion =11;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdVersion, version.getId_version());
        statement.setLong(indexNumeroversion, version.getNumero_version());
        statement.setString(indexUrlVersion, version.getUrl_version());
        statement.setBoolean(indexNotificacionVersion, version.isNotificacion_version());
        statement.setDate(indexFechaVersion, (java.sql.Date) version.getFecha_version());
        statement.setDate(indexfechaCaducidad, (java.sql.Date) version.getFecha_caducidad_version());
        statement.setDate(indexfechaAprovacion, (java.sql.Date) version.getFecha_aprovacion_version());
        statement.setLong(indexIdEstadoVersion, version.getId_estdo_version());
        statement.setLong(indexIdTipoArchivo, version.getId_tipo_archivo_version());
        statement.setLong(indexIdProductoversion, version.getId_producto_version());
        statement.setString(indexIdCentroVersion, version.getId_centro_version());               
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * @param version
     * @return Retorna Null si la version no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la version.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateVersion(Version_Bean version) throws SQLException {
       boolean resultado;// esta es la futura respuesta
        
        // datos de la consulta en base de datos
        String query ="{CALL EDITAR_VERSION(?,?,?,?,?,?,?,?,?,?,?)}";
        int indexIdVersion =1;
        int indexNumeroversion =2;
        int indexUrlVersion =3;
        int indexNotificacionVersion =4;
        int indexFechaVersion =5;
        int indexfechaCaducidad =6;
        int indexfechaAprovacion =7;
        int indexIdEstadoVersion =8;
        int indexIdTipoArchivo =9;
        int indexIdProductoversion =10;
        int indexIdCentroVersion =11;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdVersion, version.getId_version());
        statement.setLong(indexNumeroversion, version.getNumero_version());
        statement.setString(indexUrlVersion, version.getUrl_version());
        statement.setBoolean(indexNotificacionVersion, version.isNotificacion_version());
        statement.setDate(indexFechaVersion, (java.sql.Date) version.getFecha_version());
        statement.setDate(indexfechaCaducidad, (java.sql.Date) version.getFecha_caducidad_version());
        statement.setDate(indexfechaAprovacion, (java.sql.Date) version.getFecha_aprovacion_version());
        statement.setLong(indexIdEstadoVersion, version.getId_estdo_version());
        statement.setLong(indexIdTipoArchivo, version.getId_tipo_archivo_version());
        statement.setLong(indexIdProductoversion, version.getId_producto_version());
        statement.setString(indexIdCentroVersion, version.getId_centro_version());               
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * @param version
     * @return Retorna Null si la version no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la version.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteVersion(Version_Bean version) throws SQLException {
       boolean resultado;// esta es la futura respuesta
        
        // datos de la consulta en base de datos
        String query ="{CALL ELIMINAR_VERSION(?)}";
        int indexIdVersion =1;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdVersion, version.getId_version());             
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

}
