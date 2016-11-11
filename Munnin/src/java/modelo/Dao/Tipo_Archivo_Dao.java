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
    private static final String PROCEDURE_DELETE_TIPO_ARCHIVO = "{CALL ElIMINAR_TIPO_ARCHIVO(?,?)}";

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
     * @param Id_tipo_archivo Id del Tipo_Archivo
     * @return Retorna Null si el Tipo_Archivo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Tipo_Archivo.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Tipo_Archivo_Bean InsertarTipoArchivo(Long Id_tipo_archivo) throws SQLException {
        Tipo_Archivo_Bean tipo = new Tipo_Archivo_Bean();//el objeto en donde se guardan los resultados de la consulta
        tipo.setId_tipo_archivo(Id_tipo_archivo);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_TIPO_ARCHIVO(?,?)}");
        statement.setLong(PROCEDURE_INSERT_TIPO_ARCHIVO, Id_tipo_archivo);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_EXTENCION_TIPO_ARCHIVO);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

       
        return tipo;
    }

    /**
     * @param Id_tipo_archivo Id del Tipo_Archivo
     * @return Retorna Null si el Tipo_Archivo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Tipo_Archivo.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Tipo_Archivo_Bean UpdateTipoArchivo(Long Id_tipo_archivo) throws SQLException {
        Tipo_Archivo_Bean tipo = new Tipo_Archivo_Bean();//el objeto en donde se guardan los resultados de la consulta
        tipo.setId_tipo_archivo(Id_tipo_archivo);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_TIPO_ARCHIVO(?,?)}");
        statement.setLong(PROCEDURE_UPDATE_TIPO_ARCHIVO, Id_tipo_archivo);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_EXTENCION_TIPO_ARCHIVO);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return tipo;
    }

    /**
     * @param Id_tipo_archivo Id del Tipo_Archivo
     * @return Retorna Null si el Tipo_Archivo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Tipo_Archivo.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Tipo_Archivo_Bean DeleteArea(long Id_tipo_archivo) throws SQLException {
        Tipo_Archivo_Bean tipo = new Tipo_Archivo_Bean();//el objeto en donde se guardan los resultados de la consulta
        tipo.setId_tipo_archivo(Id_tipo_archivo);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_TIPO_ARCHIVO(?,?)}");
        statement.setLong(PROCEDURE_DELETE_TIPO_ARCHIVO, Id_tipo_archivo);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_EXTENCION_TIPO_ARCHIVO);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return tipo;
    }

}
