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
    //private static final int PROCEDURE_INGR_CORREO_INDEX = 1;
    private static final String PROCEDURE_UPDATE_VERSION = "{CALL EDITAR_VERSION(?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String PROCEDURE_DELETE_VERSION = "{CALL ElIMINAR_VERSION(?,?,?,?,?,?,?,?,?,?,?)}";

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
     * @param Id_version Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Version_Bean InsertarVersion(Long Id_version) throws SQLException {
        Version_Bean version = new Version_Bean();//el objeto en donde se guardan los resultados de la consulta
        version.setId_version(Id_version);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_AREA(?,?,?,?,?,?,?,?,?,?,?)}");
        statement.setLong(PROCEDURE_INSERT_VERSION, Id_version);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NUMERO_VERSION);
        statement.setString(3, COL_URL_VERSION);
        statement.setString(4, COL_NOTIFICACION_VERSION);
        statement.setString(5, COL_FECHA_VERSION);
        statement.setString(6, COL_FECHA_CADUCIDAD_VERSION);
        statement.setString(7, COL_FECHA_APROVACION_VERSION);
        statement.setString(8, COL_ID_ESTADO_VERSION);
        statement.setString(9, COL_ID_TIPO_ARCHIVO_VERSION);
        statement.setString(10, COL_ID_PRODUCTO_VERSION);
        statement.setString(11, COL_ID_CENTRO_VERSION);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

       
        return version;
    }

    /**
     * @param Id_version Id de la version
     * @return Retorna Null si la version no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la version.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Version_Bean UpdateVersion(Long Id_version) throws SQLException {
        Version_Bean version = new Version_Bean();//el objeto en donde se guardan los resultados de la consulta
        version.setId_version(Id_version);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_AREA(?,?,?,?,?,?,?,?,?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_VERSION, Id_version);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NUMERO_VERSION);
        statement.setString(3, COL_URL_VERSION);
        statement.setString(4, COL_NOTIFICACION_VERSION);
        statement.setString(5, COL_FECHA_VERSION);
        statement.setString(6, COL_FECHA_CADUCIDAD_VERSION);
        statement.setString(7, COL_FECHA_APROVACION_VERSION);
        statement.setString(8, COL_ID_ESTADO_VERSION);
        statement.setString(9, COL_ID_TIPO_ARCHIVO_VERSION);
        statement.setString(10, COL_ID_PRODUCTO_VERSION);
        statement.setString(11, COL_ID_CENTRO_VERSION);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return version;
    }

    /**
     * @param Id_version Id de la version
     * @return Retorna Null si la version no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la version.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Version_Bean DeleteVersion(long Id_version) throws SQLException {
        Version_Bean version = new Version_Bean();//el objeto en donde se guardan los resultados de la consulta
        version.setId_version(Id_version);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_VERSION(?,?,?,?,?,?,?,?,?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_VERSION, Id_version);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NUMERO_VERSION);
        statement.setString(3, COL_URL_VERSION);
        statement.setString(4, COL_NOTIFICACION_VERSION);
        statement.setString(5, COL_FECHA_VERSION);
        statement.setString(6, COL_FECHA_CADUCIDAD_VERSION);
        statement.setString(7, COL_FECHA_APROVACION_VERSION);
        statement.setString(8, COL_ID_ESTADO_VERSION);
        statement.setString(9, COL_ID_TIPO_ARCHIVO_VERSION);
        statement.setString(10, COL_ID_PRODUCTO_VERSION);
        statement.setString(11, COL_ID_CENTRO_VERSION);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return version;
    }

}
