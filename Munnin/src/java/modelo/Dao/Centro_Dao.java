package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import util.ClassConexion;
import modelo.Beans.Centro_Bean;
import util.ConexionBD;



 //cosas a tener en cuenta:
//  documentar los metodos, es facil con la herramienta javadoc
//  traten de ser lo mas explicitos posibles en la descripcion de los metodos
/**
 * Esta clase realiza y procesa las consultas a bases de datos, de las tablas
 * Area.
 *
 * @version 1.2
 * @author Monica <JBadCode>
 */
public class Centro_Dao extends ConexionBD{ 

    private static final String COL_ID_CENTRO = "id_centro";
    private static final String COL_NOMBRE_CENTRO = "nombre_centro";
    private static final String COL_ID_REGIONAL_CENTRO = "id_regional_centro";
    private static final String COL_ID_CIUDAD_CENTRO = "id_ciudad_centro";
   
    private static final String PROCEDURE_INSERT_CENTRO = "{CALL INSERTAR_CENTRO(?,?,?,?)}";
    //private static final int PROCEDURE_INGR_CORREO_INDEX = 1;
    private static final String PROCEDURE_UPDATE_CENTRO = "{CALL EDITAR_CENTRO(?,?,?,?)}";
    private static final String PROCEDURE_DELETE_CENTRO = "{CALL ElIMINAR_CENTRO(?,?,?,?)}";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Centro_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_centro  Id del centro
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Centro_Bean InsertarCentro(String Id_centro) throws SQLException {
        Centro_Bean centro = new Centro_Bean();//el objeto en donde se guardan los resultados de la consulta
        centro.setId_centro(Id_centro);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_CATEGORIA(?,?,?,?)}");
        statement.setString(PROCEDURE_INSERT_CENTRO, Id_centro);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_CENTRO);
        statement.setString(3, COL_ID_REGIONAL_CENTRO);
        statement.setString(4, COL_ID_CIUDAD_CENTRO);
       
       
        return centro;
    }

    /**
     * @param Id_centro   Id del centro
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Centro_Bean UpdateCentro(String Id_centro) throws SQLException {
        Centro_Bean centro = new Centro_Bean();//el objeto en donde se guardan los resultados de la consulta
        centro.setId_centro(Id_centro);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_CATEGORIA(?,?,?,?)}");
        statement.setString(PROCEDURE_UPDATE_CENTRO, Id_centro);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_CENTRO);
        statement.setString(3, COL_ID_REGIONAL_CENTRO);
         statement.setString(4, COL_ID_CIUDAD_CENTRO);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return centro;
    }

    /**
     * @param Id_centro  _ Id del centro
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Centro_Bean DeleteAutor(String Id_centro) throws SQLException {
        Centro_Bean centro = new Centro_Bean();//el objeto en donde se guardan los resultados de la consulta
        centro.setId_centro(Id_centro);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_CENTRO(?,?,?,?)}");
        statement.setString(PROCEDURE_DELETE_CENTRO, Id_centro);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_CENTRO);
         statement.setString(3, COL_ID_REGIONAL_CENTRO);
         statement.setString(4, COL_ID_CIUDAD_CENTRO);
       
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return centro;
    }
   
}