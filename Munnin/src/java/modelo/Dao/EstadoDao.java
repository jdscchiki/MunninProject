
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.EstadoBean;
import util.ClassConexion;
import util.ConexionBD;

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * Estado.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

 public class EstadoDao extends ConexionBD {

    private static final String COL_ID_ESTADO = "id_estado";
    private static final String COL_NOMBRE_ESTADO = "nombre_estado";
    

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public EstadoDao() throws NamingException, SQLException {
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
    public boolean InsertarEstado(EstadoBean estado) throws SQLException {
        boolean resultado;//esta el la futura respuesta
        
        //datos en la consulta en base de datos
        String query="{CALL INSERTAR_ESTADO(?,?)}";
        int indexIdEstado = 1;
        int indexNombreEstado = 2;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdEstado, estado.getId_estado());
        statement.setString(indexNombreEstado, estado.getNombre_estado());        
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
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean UpdateEstado(EstadoBean estado) throws SQLException {
        boolean resultado;//esta el la futura respuesta
        
        //datos en la consulta en base de datos
        String query="{CALL EDITAR_ESTADO(?,?)}";
        int indexIdEstado = 1;
        int indexNombreEstado = 2;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdEstado, estado.getId_estado());
        statement.setString(indexNombreEstado, estado.getNombre_estado());        
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
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean DeleteEstado(EstadoBean estado) throws SQLException {
         boolean resultado;//esta el la futura respuesta
        
        //datos en la consulta en base de datos
        String query="{CALL ELIMINAR_ESTADO(?)}";
        int indexIdEstado = 1;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdEstado, estado.getId_estado());      
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
