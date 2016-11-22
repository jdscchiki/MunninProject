package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.ProgramaBean;
import util.ClassConexion;
import util.ConexionBD;

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * Programa.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

public class ProgramaDao extends ConexionBD {

    private static final String COL_ID_PROGRAMA = "id_programa";
    private static final String COL_NOMBRE_PROGRAMA = "nombre_programa";
    private static final String COL_ID_AREA_PROGRAMA = "id_area_programa";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public ProgramaDao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param programa
     * @return Retorna Null si el Programa no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Programa.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarPrograma(ProgramaBean programa) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL INSERTAR_PROGRAMA(?,?,?)}";
        int indexIdPrograma =1;
        int indexNombrePrograma =2;
        int indexIdAreaPrograma=3;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdPrograma, programa.getId_programa());
        statement.setString(indexNombrePrograma, programa.getNombre_programa());
        statement.setLong(indexIdAreaPrograma, programa.getId_area_programa());        
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
     * @param programa
     * @return Retorna Null si el Programa no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Programa.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean UpdatePrograma(ProgramaBean programa) throws SQLException {
       boolean resultado;// esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL EDITAR_PROGRAMA(?,?,?)}";
        int indexIdPrograma =1;
        int indexNombrePrograma =2;
        int indexIdAreaPrograma=3;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdPrograma, programa.getId_programa());
        statement.setString(indexNombrePrograma, programa.getNombre_programa());
        statement.setLong(indexIdAreaPrograma, programa.getId_area_programa());        
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
     * @param programa
     * @return Retorna Null si el Programa no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Programa.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean DeletePrograma(ProgramaBean programa) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL ELIMINAR_PROGRAMA(?)}";
        int indexIdPrograma =1;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdPrograma, programa.getId_programa());      
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
