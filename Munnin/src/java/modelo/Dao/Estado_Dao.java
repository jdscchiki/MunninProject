
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Estado_Bean;
import util.ClassConexion;
import util.ConexionBD;


 public class Estado_Dao extends ConexionBD {

    private static final String COL_ID_ESTADO = "id_estado";
    private static final String COL_NOMBRE_ESTADO = "nombre_estado";
    

    private static final String PROCEDURE_INSERT_ESTADO = "{CALL INSERTAR_ESTADO(?,?)}";
    private static final String PROCEDURE_UPDATE_ESTADO = "{CALL EDITAR_ESTADO(?,?)}";
    private static final String PROCEDURE_DELETE_ESTADO = "{CALL ElIMINAR_ESTADO(?)}";

    
    private static final int PROCEDURE_INSERTAR_ESTADO_ID_ESTADO_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_ESTADO_NOMBRE_ESTADO_INDEX = 2;
    private static final int PROCEDURE_UPDATE_ESTADO_ID_ESTADO_INDEX = 1;
    private static final int PROCEDURE_UPDATE_ESTADO_NOMBRE_ESTADO_INDEX = 2;
    private static final int PROCEDURE_ELIMINAR_ESTADO_ID_ESTADO_INDEX = 1;

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Estado_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param estado
     * @return Retorna Null si el Estado no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Estado.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarEstado(Estado_Bean estado) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_ESTADO);
        statement.setLong(PROCEDURE_INSERTAR_ESTADO_ID_ESTADO_INDEX, estado.getId_estado());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_INSERTAR_ESTADO_NOMBRE_ESTADO_INDEX, estado.getNombre_estado());        
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
     * @param estado
     * @return Retorna Null si el Estado no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Estado.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateEstado(Estado_Bean estado) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_ESTADO);
        statement.setLong(PROCEDURE_UPDATE_ESTADO_ID_ESTADO_INDEX, estado.getId_estado());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_UPDATE_ESTADO_NOMBRE_ESTADO_INDEX, estado.getNombre_estado());
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
     * @param estado
     * @return Retorna Null si el Estado no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Estado.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteEstado(Estado_Bean estado) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_ESTADO);
        statement.setLong(PROCEDURE_ELIMINAR_ESTADO_ID_ESTADO_INDEX, estado.getId_estado());//asigna los valores necesarios para ejecutar el QUERY
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
