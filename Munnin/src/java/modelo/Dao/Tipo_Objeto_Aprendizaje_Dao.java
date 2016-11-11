package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Tipo_Objeto_Aprendizaje_Bean;
import util.ClassConexion;
import util.ConexionBD;

public class Tipo_Objeto_Aprendizaje_Dao extends ConexionBD {

    private static final String COL_ID_TIPO_OBJETO_APRENDIZAJE = "id_tipo_objeto_aprendizaje";
    private static final String COL_NOMBRE_TIPO_OBJETO_APRENDIZAJE = "nombre_tipo_objeto_aprendizaje";

    private static final String PROCEDURE_INSERT_TIPO_OBJETO = "{CALL INSERTAR_TIPO_OBJETO(?,?)}";
    private static final String PROCEDURE_UPDATE_TIPO_OBJETO = "{CALL EDITAR_TIPO_OBJETO(?,?)}";
    private static final String PROCEDURE_DELETE_TIPO_OBJETO = "{CALL ElIMINAR_TIPO_OBJETO(?,?)}";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Tipo_Objeto_Aprendizaje_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_tipo_objeto_aprendizaje Id del Tipo_Objeto
     * @return Retorna Null si el Tipo_Objeto no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Tipo_Objeto.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Tipo_Objeto_Aprendizaje_Bean InsertarArea(Long Id_tipo_objeto_aprendizaje) throws SQLException {
        Tipo_Objeto_Aprendizaje_Bean tipoobj = new Tipo_Objeto_Aprendizaje_Bean();//el objeto en donde se guardan los resultados de la consulta
        tipoobj.setId_tipo_objeto_aprendizaje(Id_tipo_objeto_aprendizaje);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_TIPO_OBJETO(?,?)}");
        statement.setLong(PROCEDURE_INSERT_TIPO_OBJETO, Id_tipo_objeto_aprendizaje);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_TIPO_OBJETO_APRENDIZAJE);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

       
        return tipoobj;
    }

    /**
     * @param Id_tipo_objeto_aprendizaje Id del Tipo_Objeto
     * @return Retorna Null si el Tipo_Objeto no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Tipo_Objeto.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Tipo_Objeto_Aprendizaje_Bean UpdateArea(Long Id_tipo_objeto_aprendizaje) throws SQLException {
        Tipo_Objeto_Aprendizaje_Bean tipoobj = new Tipo_Objeto_Aprendizaje_Bean();//el objeto en donde se guardan los resultados de la consulta
        tipoobj.setId_tipo_objeto_aprendizaje(Id_tipo_objeto_aprendizaje);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_TIPO_APRENDIZAJE(?,?)}");
        statement.setLong(PROCEDURE_UPDATE_TIPO_OBJETO, Id_tipo_objeto_aprendizaje);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_TIPO_OBJETO_APRENDIZAJE);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return tipoobj;
    }

    /**
     * @param Id_tipo_objeto_aprendizaje Id del Tipo_Objeto
     * @return Retorna Null si el Tipo_Objeto no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Tipo_Objeto.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Tipo_Objeto_Aprendizaje_Bean DeleteArea(long Id_tipo_objeto_aprendizaje) throws SQLException {
        Tipo_Objeto_Aprendizaje_Bean tipoobj = new Tipo_Objeto_Aprendizaje_Bean();//el objeto en donde se guardan los resultados de la consulta
        tipoobj.setId_tipo_objeto_aprendizaje(Id_tipo_objeto_aprendizaje);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_TIPO_OBJETO(?,?)}");
        statement.setLong(PROCEDURE_DELETE_TIPO_OBJETO, Id_tipo_objeto_aprendizaje);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_TIPO_OBJETO_APRENDIZAJE);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return tipoobj;
    }

}
