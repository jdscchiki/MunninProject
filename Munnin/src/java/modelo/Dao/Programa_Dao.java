package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Programa_Bean;
import util.ClassConexion;
import util.ConexionBD;

public class Programa_Dao extends ConexionBD {

    private static final String COL_ID_PROGRAMA = "id_programa";
    private static final String COL_NOMBRE_PROGRAMA = "nombre_programa";
    private static final String COL_ID_AREA_PROGRAMA = "id_area_programa";

    private static final String PROCEDURE_INSERT_PROGRAMA = "{CALL INSERTAR_PROGRAMA(?,?,?)}";
    private static final String PROCEDURE_UPDATE_PROGRAMA = "{CALL EDITAR_PROGRAMA(?,?,?)}";
    private static final String PROCEDURE_DELETE_PROGRAMA = "{CALL ElIMINAR_PROGRAMA(?,?,?)}";
    
    private static final int PROCEDURE_INSERTAR_ID_PROGRAMA_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_NOMBRE_PROGRAMA_INDEX = 2;
    private static final int PROCEDURE_INSERTAR_ID_AREA_PROGRAMA_INDEX = 3;
    
    private static final int PROCEDURE_UPDATE_ID_PROGRAMA_INDEX = 1;
    private static final int PROCEDURE_UPDATE_NOMBRE_PROGRAMA_INDEX = 2;
    private static final int PROCEDURE_UPDATE_ID_AREA_PROGRAMA_INDEX = 3;
    
    private static final int PROCEDURE_DELETE_ID_PROGRAMA_INDEX = 1;

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Programa_Dao() throws NamingException, SQLException {
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
    public boolean InsertarPrograma(Programa_Bean programa) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_PROGRAMA);
        statement.setLong(PROCEDURE_INSERTAR_ID_PROGRAMA_INDEX, programa.getId_programa());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_INSERTAR_NOMBRE_PROGRAMA_INDEX, programa.getNombre_programa());
        statement.setLong(PROCEDURE_INSERTAR_ID_AREA_PROGRAMA_INDEX, programa.getId_area_programa());        
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
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdatePrograma(Programa_Bean programa) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_PROGRAMA);
        statement.setLong(PROCEDURE_UPDATE_ID_PROGRAMA_INDEX, programa.getId_programa());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_UPDATE_NOMBRE_PROGRAMA_INDEX, programa.getNombre_programa());
        statement.setLong(PROCEDURE_UPDATE_ID_AREA_PROGRAMA_INDEX, programa.getId_area_programa());        
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
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeletePrograma(Programa_Bean programa) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_PROGRAMA);
        statement.setLong(PROCEDURE_DELETE_ID_PROGRAMA_INDEX, programa.getId_programa());//asigna los valores necesarios para ejecutar el QUERY        
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
