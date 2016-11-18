package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Regional_Bean;
import util.ClassConexion;
import util.ConexionBD;

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * Regional.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */
public class Regional_Dao extends ConexionBD {

    private static final String COL_ID_REGIONAL = "id_regional";
    private static final String COL_NOMBRE_REGIONAL = "nombre_regional";
    
    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Regional_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param regional
     * @return Retorna Null si la Regional no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la Regional.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean InsertarRegional(Regional_Bean regional) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL INGRESAR_REGIONAL(?,?)}";
        int indexIdRegional =1;
        int indexNombreRegional = 2;
         
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdRegional, regional.getId_regional());
        statement.setString(indexNombreRegional, regional.getNombre_regional());        
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
     * @param regional
     * @return Retorna Null si la Regional no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la Regional.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateRegional(Regional_Bean regional) throws SQLException {
       boolean resultado;// esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_REGIONAL(?,?)}";
        int indexIdRegional =1;
        int indexNombreRegional = 2;
         
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdRegional, regional.getId_regional());
        statement.setString(indexNombreRegional, regional.getNombre_regional());        
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
     * @param regional
     * @return Retorna Null si la Regional no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la Regional.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteRegional(Regional_Bean regional) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL ELIMINAR_REGIONAL(?,?)}";
        int indexIdRegional =1;
         
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdRegional, regional.getId_regional());      
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
