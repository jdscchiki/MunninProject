package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import util.ClassConexion;
import modelo.Beans.Ciudad_Bean;
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
public class Ciudad_Dao extends ConexionBD{ 

    private static final String COL_ID_CIUDAD = "id_centro";
    private static final String COL_NOMBRE_CIUDAD = "nombre_centro";
   
   
    private static final String PROCEDURE_INSERT_CIUDAD = "{CALL INSERTAR_CIUDAD(?,?)}"; 
    private static final String PROCEDURE_UPDATE_CIUDAD = "{CALL EDITAR_CIUDAD(?,?)}";
    private static final String PROCEDURE_DELETE_CIUDAD = "{CALL ElIMINAR_CIUDAD(?,?)}";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Ciudad_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_ciudad  Id de la ciudad
     * @return Retorna Null si la ciudad no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Ciudad_Bean InsertarCiudad(String Id_ciudad) throws SQLException {
        Ciudad_Bean ciudad = new Ciudad_Bean();//el objeto en donde se guardan los resultados de la consulta
        ciudad.setId_ciudad(Id_ciudad);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_CIUDAD(?,?)}");
        statement.setString(PROCEDURE_INSERT_CIUDAD, Id_ciudad);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_CIUDAD);
        
       
        return ciudad;
    }

    /**
     * @param Id_ciudad   Id de la ciudad
     * @return Retorna Null si la ciudad no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Ciudad_Bean UpdateCentro(String Id_ciudad) throws SQLException {
        Ciudad_Bean ciudad = new Ciudad_Bean();//el objeto en donde se guardan los resultados de la consulta
        ciudad.setId_ciudad(Id_ciudad);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_CIUDAD(?,?)}");
        statement.setString(PROCEDURE_UPDATE_CIUDAD, Id_ciudad);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_CIUDAD);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return ciudad;
    }

    /**
     * @param Id_ciudad  _ Id de la ciudad
     * @return Retorna Null si la ciudad no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Ciudad_Bean DeleteAutor(String Id_ciudad) throws SQLException {
        Ciudad_Bean ciudad = new Ciudad_Bean();//el objeto en donde se guardan los resultados de la consulta
        ciudad.setId_ciudad(Id_ciudad);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_CIUDAD(?,?)}");
        statement.setString(PROCEDURE_DELETE_CIUDAD, Id_ciudad);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_CIUDAD);
       
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return ciudad;
    }
    
   

}