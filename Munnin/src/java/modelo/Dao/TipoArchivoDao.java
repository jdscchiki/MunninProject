package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.TipoArchivoBean;
import util.ClassConexion;
import util.ConexionBD;

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * TipoArchivo.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

public class TipoArchivoDao extends ConexionBD {

    private static final String COL_ID_TIPO_ARCHIVO= "id_tipo_archivo";
    private static final String COL_EXTENCION_TIPO_ARCHIVO = "extencion_tipo_archivo";


    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public TipoArchivoDao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param tipoArchivo
     * @return Retorna Null si el TipoArchivo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del TipoArchivo.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean InsertarTipoArchivo(TipoArchivoBean tipoArchivo) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL INSERTAR_TIPO_ARCHIVO(?,?)}";
        int indexIdTipoArchivo = 1;
        int indexExtencionTipoArchivo = 2;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdTipoArchivo, tipoArchivo.getId_tipo_archivo());
        statement.setString(indexExtencionTipoArchivo, tipoArchivo.getExtencion_tipo_archivo());        
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
     * @return Retorna Null si el TipoArchivo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del TipoArchivo.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean UpdateTipoArchivo(TipoArchivoBean tipoArchivo) throws SQLException {
       boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL EDITAR_TIPO_ARCHIVO(?,?)}";
        int indexIdTipoArchivo = 1;
        int indexExtencionTipoArchivo = 2;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdTipoArchivo, tipoArchivo.getId_tipo_archivo());
        statement.setString(indexExtencionTipoArchivo, tipoArchivo.getExtencion_tipo_archivo());        
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
    public boolean DeleteArea(TipoArchivoBean tipoArchivo) throws SQLException {
       boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL ELIMINAR_TIPO_ARCHIVO(?)}";
        int indexIdTipoArchivo = 1;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdTipoArchivo, tipoArchivo.getId_tipo_archivo());     
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
