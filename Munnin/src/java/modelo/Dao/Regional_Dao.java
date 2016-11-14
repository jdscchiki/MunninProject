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


public class Regional_Dao extends ConexionBD {

    private static final String COL_ID_REGIONAL = "id_regional";
    private static final String COL_NOMBRE_REGIONAL = "nombre_regional";

    private static final String PROCEDURE_INSERT_REGIONAL = "{CALL INSERTAR_REGIONAL(?,?)}";
    private static final String PROCEDURE_UPDATE_REGIONAL = "{CALL EDITAR_REGIONAL(?,?)}";
    private static final String PROCEDURE_DELETE_REGIONAL = "{CALL ElIMINAR_REGIONAL(?)}";
    
    private static final int PROCEDURE_INSERTAR_ID_REGIONAL_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_NOMBRE_REGIONAL_INDEX = 2;
    
    private static final int PROCEDURE_UPDATE_ID_REGIONAL_INDEX = 1;
    private static final int PROCEDURE_UPDATE_NOMBRE_REGIONAL_INDEX = 2;
    
    private static final int PROCEDURE_DELETE_ID_REGIONAL_INDEX = 1;

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
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarRegional(Regional_Bean regional) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_REGIONAL);
        statement.setLong(PROCEDURE_INSERTAR_ID_REGIONAL_INDEX, regional.getId_regional());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_INSERTAR_NOMBRE_REGIONAL_INDEX, regional.getNombre_regional());        
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
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_REGIONAL);
        statement.setLong(PROCEDURE_UPDATE_ID_REGIONAL_INDEX, regional.getId_regional());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_UPDATE_NOMBRE_REGIONAL_INDEX, regional.getNombre_regional());        
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
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_REGIONAL);
        statement.setLong(PROCEDURE_DELETE_ID_REGIONAL_INDEX, regional.getId_regional());//asigna los valores necesarios para ejecutar el QUERY        
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
