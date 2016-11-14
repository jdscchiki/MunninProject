package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Tipo_Archivo_Bean;
import util.ClassConexion;
import util.ConexionBD;


public class Tipo_Archivo_Dao extends ConexionBD {

    private static final String COL_ID_TIPO_ARCHIVO= "id_tipo_archivo";
    private static final String COL_EXTENCION_TIPO_ARCHIVO = "extencion_tipo_archivo";

    private static final String PROCEDURE_INSERT_TIPO_ARCHIVO = "{CALL INSERTAR_TIPO_ARCHIVO(?,?)}";
    private static final String PROCEDURE_UPDATE_TIPO_ARCHIVO = "{CALL EDITAR_TIPO_ARCHIVO(?,?)}";
    private static final String PROCEDURE_DELETE_TIPO_ARCHIVO = "{CALL ElIMINAR_TIPO_ARCHIVO(?)}";
    
    private static final int PROCEDURE_INSERTAR_ID_TIPO_ARCHIVO_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_EXTENCION_TIPO_ARCHIVO_INDEX = 2;
    
    private static final int PROCEDURE_UPDATE_ID_TIPO_ARCHIVO_INDEX = 1;
    private static final int PROCEDURE_UPDATE_EXTENCION_TIPO_ARCHIVO_INDEX = 2;
    
    private static final int PROCEDURE_DELETE_ID_TIPO_ARCHIVO_INDEX = 1;
    

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Tipo_Archivo_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param tipoArchivo
     * @return Retorna Null si el Tipo_Archivo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Tipo_Archivo.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarTipoArchivo(Tipo_Archivo_Bean tipoArchivo) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_TIPO_ARCHIVO);
        statement.setLong(PROCEDURE_INSERTAR_ID_TIPO_ARCHIVO_INDEX, tipoArchivo.getId_tipo_archivo());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_INSERTAR_EXTENCION_TIPO_ARCHIVO_INDEX, tipoArchivo.getExtencion_tipo_archivo());        
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
     * @param tipoArchivo
     * @return Retorna Null si el Tipo_Archivo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Tipo_Archivo.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateTipoArchivo(Tipo_Archivo_Bean tipoArchivo) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_TIPO_ARCHIVO);
        statement.setLong(PROCEDURE_UPDATE_ID_TIPO_ARCHIVO_INDEX, tipoArchivo.getId_tipo_archivo());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_UPDATE_EXTENCION_TIPO_ARCHIVO_INDEX, tipoArchivo.getExtencion_tipo_archivo());        
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
     * @param tipoArchivo
     * @return Retorna Null si el Tipo_Archivo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Tipo_Archivo.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteArea(Tipo_Archivo_Bean tipoArchivo) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_TIPO_ARCHIVO);
        statement.setLong(PROCEDURE_DELETE_ID_TIPO_ARCHIVO_INDEX, tipoArchivo.getId_tipo_archivo());//asigna los valores necesarios para ejecutar el QUERY                
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
