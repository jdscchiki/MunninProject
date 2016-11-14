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
 
    private static final int PROCEDURE_INSERTAR_CENTRO_ID_CENTRO_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_CENTRO_NOMBRE_CENTRO_INDEX = 2;
    private static final int PROCEDURE_INSERTAR_CENTRO_ID_REGIONAL_CENTRO_INDEX = 3;
    private static final int PROCEDURE_INSERTAR_CENTRO_ID_CIUDAD_CENTRO_INDEX = 4;
    private static final int PROCEDURE_UPDATE_CENTRO_ID_CENTRO_INDEX = 1;
    private static final int PROCEDURE_UPDATE_CENTRO_NOMBRE_AREA_INDEX = 2;
    private static final int PROCEDURE_UPDATE_CENTRO_ID_REGIONAL_CENTRO_INDEX = 3;
    private static final int PROCEDURE_UPDATE_CENTRO_ID_CIUDAD_CENTRO_INDEX = 4;
    private static final int PROCEDURE_ELIMINAR_CENTRO_ID_CENTRO_INDEX = 1;

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
     * @param centro
     * @return Retorna Null si el Centro no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Centro.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarCentro(Centro_Bean centro) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_CENTRO);
        statement.setString(PROCEDURE_INSERTAR_CENTRO_ID_CENTRO_INDEX, centro.getId_centro());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_INSERTAR_CENTRO_NOMBRE_CENTRO_INDEX, centro.getNombre_centro());
        statement.setString(PROCEDURE_INSERTAR_CENTRO_ID_REGIONAL_CENTRO_INDEX, centro.getId_regional_centro()); 
         statement.setString(PROCEDURE_INSERTAR_CENTRO_ID_CIUDAD_CENTRO_INDEX, centro.getId_ciudad_centro()); 
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
     * @param centro
     * @return Retorna Null si el Centro no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Centro.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateCentro(Centro_Bean centro) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_CENTRO);
        statement.setString(PROCEDURE_UPDATE_CENTRO_ID_CENTRO_INDEX, centro.getId_centro());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_UPDATE_CENTRO_NOMBRE_AREA_INDEX, centro.getNombre_centro());
        statement.setString(PROCEDURE_UPDATE_CENTRO_ID_REGIONAL_CENTRO_INDEX, centro.getId_regional_centro());
        statement.setString(PROCEDURE_UPDATE_CENTRO_ID_CIUDAD_CENTRO_INDEX, centro.getId_ciudad_centro());
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
     * @param centro
     * @return Retorna Null si el Centro no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Centro.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteCentro(Centro_Bean centro) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_CENTRO);
        statement.setString(PROCEDURE_ELIMINAR_CENTRO_ID_CENTRO_INDEX, centro.getId_centro());//asigna los valores necesarios para ejecutar el QUERY
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
