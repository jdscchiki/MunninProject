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


/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * Centro.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */
public class Centro_Dao extends ConexionBD{ 

    private static final String COL_ID_CENTRO = "id_centro";
    private static final String COL_NOMBRE_CENTRO = "nombre_centro";
    private static final String COL_ID_REGIONAL_CENTRO = "id_regional_centro";
    private static final String COL_ID_CIUDAD_CENTRO = "id_ciudad_centro";
  

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
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean InsertarCentro(Centro_Bean centro) throws SQLException {
        boolean resultado; //esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL INSERTAR_CENTRO(?,?,?,?)}";
        int indexIdCentro=1;
        int indexNombreCentro=2;
        int indexIdRegionalCentro=3;
        int indexIdCiudadCentro =4;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexIdCentro, centro.getId_centro());
        statement.setString(indexNombreCentro, centro.getNombre_centro());
        statement.setString(indexIdRegionalCentro, centro.getId_regional_centro()); 
         statement.setString(indexIdRegionalCentro, centro.getId_ciudad_centro()); 
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
     * @version 1.
     * @throws java.sql.SQLException
     */
    public boolean UpdateCentro(Centro_Bean centro) throws SQLException {
         boolean resultado; //esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL EDITAR_CENTRO(?,?,?,?)}";
        int indexIdCentro=1;
        int indexNombreCentro=2;
        int indexIdRegionalCentro=3;
        int indexIdCiudadCentro =4;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexIdCentro, centro.getId_centro());
        statement.setString(indexNombreCentro, centro.getNombre_centro());
        statement.setString(indexIdRegionalCentro, centro.getId_regional_centro()); 
         statement.setString(indexIdRegionalCentro, centro.getId_ciudad_centro()); 
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
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean DeleteCentro(Centro_Bean centro) throws SQLException {
        boolean resultado; //esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL ELIMINAR_CENTRO(?,?,?,?)}";
        int indexIdCentro=1;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexIdCentro, centro.getId_centro());
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
