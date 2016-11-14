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

    private static final String COL_ID_CIUDAD = "id_ciudad";
    private static final String COL_NOMBRE_CIUDAD = "nombre_ciudad";
   
   
    private static final String PROCEDURE_INSERT_CIUDAD = "{CALL INSERTAR_CIUDAD(?,?)}"; 
    private static final String PROCEDURE_UPDATE_CIUDAD = "{CALL EDITAR_CIUDAD(?,?)}";
    private static final String PROCEDURE_DELETE_CIUDAD = "{CALL ElIMINAR_CIUDAD(?,?)}";
  
    
    private static final int PROCEDURE_INSERTAR_CIUDAD_ID_CIUDAD_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_CIUDAD_NOMBRE_CIUDAD_INDEX = 2;
    private static final int PROCEDURE_UPDATE_CIUDAD_ID_CIUDAD_INDEX = 1;
    private static final int PROCEDURE_UPDATE_CIUDAD_NOMBRE_CIUDAD_INDEX = 2;
    private static final int PROCEDURE_ELIMINAR_CIUDAD_ID_CIUDAD_INDEX = 1;

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
     * @param ciudad
     * @return Retorna Null si la Ciudad no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la Ciudad.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarCiudadl(Ciudad_Bean ciudad) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_CIUDAD);
        statement.setString(PROCEDURE_INSERTAR_CIUDAD_ID_CIUDAD_INDEX, ciudad.getId_ciudad());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_INSERTAR_CIUDAD_NOMBRE_CIUDAD_INDEX, ciudad.getNombre_ciudad());        
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
     * @param ciudad
     * @return Retorna Null si la Ciudad no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la Ciudad.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateCiudad(Ciudad_Bean ciudad) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_CIUDAD);
        statement.setString(PROCEDURE_UPDATE_CIUDAD_ID_CIUDAD_INDEX, ciudad.getId_ciudad());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_UPDATE_CIUDAD_NOMBRE_CIUDAD_INDEX, ciudad.getNombre_ciudad());
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
     * @param ciudad
     * @return Retorna Null si la Ciudad no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la Ciudad
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteCiudad(Ciudad_Bean ciudad) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_CIUDAD);
        statement.setString(PROCEDURE_ELIMINAR_CIUDAD_ID_CIUDAD_INDEX, ciudad.getId_ciudad());//asigna los valores necesarios para ejecutar el QUERY
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
