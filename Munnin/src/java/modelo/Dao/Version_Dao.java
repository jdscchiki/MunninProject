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


    private static final String PROCEDURE_INSERT_VERSION = "{CALL INSERTAR_VERSION(?,?,?,?,?,?,?,?,?,?,?)}";    
    private static final String PROCEDURE_UPDATE_VERSION = "{CALL EDITAR_VERSION(?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String PROCEDURE_DELETE_VERSION = "{CALL ElIMINAR_VERSION(?,?,?,?,?,?,?,?,?,?,?)}";
    
    private static final int PROCEDURE_INSERTAR_VERSION_ID_VERSION_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_VERSION_NUMERO_VERSION_INDEX = 2;
    private static final int PROCEDURE_INSERTAR_VERSION_URL_VERSION_INDEX = 3;
    private static final int PROCEDURE_INSERTAR_VERSION_NOTIFICACION_VERSION_INDEX = 4;
    private static final int PROCEDURE_INSERTAR_VERSION_FECHA_VERSION_INDEX = 5;
    private static final int PROCEDURE_INSERTAR_VERSION_FECHAR_CADUCIDAD_VERSION_INDEX = 6;
    private static final int PROCEDURE_INSERTAR_VERSION_FECHA_APROBACION_VERSION_INDEX = 7;
    private static final int PROCEDURE_INSERTAR_VERSION_ID_ESTADO_VERSION_INDEX = 8;
    private static final int PROCEDURE_INSERTAR_VERSION_ID_TIPO_ARCHIVO_VERSION_INDEX = 9;
    private static final int PROCEDURE_INSERTAR_VERSION_ID_PRODUCTO_VERSION_INDEX = 10;
    private static final int PROCEDURE_INSERTAR_VERSION_ID_CENTRO_VERSION_INDEX = 11;
    
    private static final int PROCEDURE_UPDATE_VERSION_ID_VERSION_INDEX = 1;
    private static final int PROCEDURE_UPDATE_VERSION_NUMERO_VERSION_INDEX = 2;
    private static final int PROCEDURE_UPDATE_VERSION_URL_VERSION_INDEX = 3;
    private static final int PROCEDURE_UPDATE_VERSION_NOTIFICACION_VERSION_INDEX = 4;
    private static final int PROCEDURE_UPDATE_VERSION_FECHA_VERSION_INDEX = 5;
    private static final int PROCEDURE_UPDATE_VERSION_FECHAR_CADUCIDAD_VERSION_INDEX = 6;
    private static final int PROCEDURE_UPDATE_VERSION_FECHA_APROBACION_VERSION_INDEX = 7;
    private static final int PROCEDURE_UPDATE_VERSION_ID_ESTADO_VERSION_INDEX = 8;
    private static final int PROCEDURE_UPDATE_VERSION_ID_TIPO_ARCHIVO_VERSION_INDEX = 9;
    private static final int PROCEDURE_UPDATE_VERSION_ID_PRODUCTO_VERSION_INDEX = 10;
    private static final int PROCEDURE_UPDATE_VERSION_ID_CENTRO_VERSION_INDEX = 11;  
    

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
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarVersion(Version_Bean version) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_VERSION);
        statement.setLong(PROCEDURE_INSERTAR_VERSION_ID_VERSION_INDEX, version.getId_version());//asigna los valores necesarios para ejecutar el QUERY
        statement.setLong(PROCEDURE_INSERTAR_VERSION_NUMERO_VERSION_INDEX, version.getNumero_version());
        statement.setString(PROCEDURE_INSERTAR_VERSION_URL_VERSION_INDEX, version.getUrl_version());
        statement.setBoolean(PROCEDURE_INSERTAR_VERSION_NOTIFICACION_VERSION_INDEX, version.isNotificacion_version());
        statement.setDate(PROCEDURE_INSERTAR_VERSION_FECHA_VERSION_INDEX, (java.sql.Date) version.getFecha_version());
        statement.setDate(PROCEDURE_INSERTAR_VERSION_FECHAR_CADUCIDAD_VERSION_INDEX, (java.sql.Date) version.getFecha_caducidad_version());
        statement.setDate(PROCEDURE_INSERTAR_VERSION_FECHA_APROBACION_VERSION_INDEX, (java.sql.Date) version.getFecha_aprovacion_version());
        statement.setLong(PROCEDURE_INSERTAR_VERSION_ID_ESTADO_VERSION_INDEX, version.getId_estdo_version());
        statement.setLong(PROCEDURE_INSERTAR_VERSION_ID_TIPO_ARCHIVO_VERSION_INDEX, version.getId_tipo_archivo_version());
        statement.setLong(PROCEDURE_INSERTAR_VERSION_ID_PRODUCTO_VERSION_INDEX, version.getId_producto_version());
        statement.setString(PROCEDURE_INSERTAR_VERSION_ID_CENTRO_VERSION_INDEX, version.getId_centro_version());               
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
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_VERSION);
        statement.setLong(PROCEDURE_UPDATE_VERSION_ID_VERSION_INDEX, version.getId_version());//asigna los valores necesarios para ejecutar el QUERY
        statement.setLong(PROCEDURE_UPDATE_VERSION_NUMERO_VERSION_INDEX, version.getNumero_version());
        statement.setString(PROCEDURE_UPDATE_VERSION_URL_VERSION_INDEX, version.getUrl_version());
        statement.setBoolean(PROCEDURE_UPDATE_VERSION_NOTIFICACION_VERSION_INDEX, version.isNotificacion_version());
        statement.setDate(PROCEDURE_UPDATE_VERSION_FECHA_VERSION_INDEX, (java.sql.Date) version.getFecha_version());
        statement.setDate(PROCEDURE_UPDATE_VERSION_FECHAR_CADUCIDAD_VERSION_INDEX, (java.sql.Date) version.getFecha_caducidad_version());
        statement.setDate(PROCEDURE_UPDATE_VERSION_FECHA_APROBACION_VERSION_INDEX, (java.sql.Date) version.getFecha_aprovacion_version());
        statement.setLong(PROCEDURE_UPDATE_VERSION_ID_ESTADO_VERSION_INDEX, version.getId_estdo_version());
        statement.setLong(PROCEDURE_UPDATE_VERSION_ID_TIPO_ARCHIVO_VERSION_INDEX, version.getId_tipo_archivo_version());
        statement.setLong(PROCEDURE_UPDATE_VERSION_ID_PRODUCTO_VERSION_INDEX, version.getId_producto_version());
        statement.setString(PROCEDURE_UPDATE_VERSION_ID_CENTRO_VERSION_INDEX, version.getId_centro_version());  
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
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_VERSION);
        statement.setLong(PROCEDURE_UPDATE_VERSION_ID_VERSION_INDEX, version.getId_version());//asigna los valores necesarios para ejecutar el QUERY
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
