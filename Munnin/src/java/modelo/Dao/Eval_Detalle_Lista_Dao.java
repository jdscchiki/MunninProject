package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Area_Bean;
import modelo.Beans.Eval_Detalle_Lista_Bean;
import util.ClassConexion;
import util.ConexionBD;

public class Eval_Detalle_Lista_Dao extends ConexionBD {

    private static final String COL_ID_EVAL_DETALLE_LISTA = "id_eval_detalle_lista";
    private static final String COL_CALIFICACION_EVAL_DETALLE_LISTA = "calificacion_eval_detalle_lista";
    private static final String COL_OBSERVACION_EVAL_DETALLE_LISTA = "observarcion_eval_detalle_lista";
    private static final String COL_ID_EVAL_VERSION_GENERAL_EVAL_DETALLE_LISTA = "id_eval_version_general_eval_detalle_lista";
    private static final String COL_ID_DETALLE_LISTA_EVAL_DETALLE_LISTA = "id_detalle_lista_eval_detalle_lista";

    private static final String PROCEDURE_INSERT_EVAL_DETALLE = "{CALL INSERTAR_EVAL_DETALLE(?,?,?,?,?)}";
    private static final String PROCEDURE_UPDATE_EVAL_DETALLE = "{CALL EDITAR_EVAL_DETALLE(?,?,?,?,?)}";
    private static final String PROCEDURE_DELETE_EVAL_DETALLE = "{CALL ElIMINAR_EVAL_DETALLE(?,)}";

    
    private static final int PROCEDURE_INSERTAR_EVAL_DETALLE_ID_EVAL_DETALLE_LISTA_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_EVAL_DETALLE_CALIFICACION_EVAL_DETALLE_LISTA_INDEX = 2;
    private static final int PROCEDURE_INSERTAR_EVAL_DETALLE_OBSERVACION_EVAL_DETALLE_LISTA_INDEX = 3;
    private static final int PROCEDURE_INSERTAR_EVAL_DETALLE_ID_EVAL_VERSION_GENERAL_EVAL_DETALLE_LISTA = 4;
    private static final int PROCEDURE_INSERTAR_EVAL_DETALLE_ID_DETALLE_LISTA_EVAL_DETALLE_LISTA = 5;
    private static final int PROCEDURE_UPDATE_EVAL_DETALLE_ID_EVAL_DETALLE_LISTA_INDEX = 1;
    private static final int PROCEDURE_UPDATE_EVAL_DETALLE_CALIFICACION_EVAL_DETALLE_LISTA_INDEX = 2;
    private static final int PROCEDURE_UPDATE_EVAL_DETALLE_OBSERVACION_EVAL_DETALLE_LISTA_INDEX  = 3;
    private static final int PROCEDURE_UPDATE_EVAL_DETALLE_ID_EVAL_VERSION_GENERAL_EVAL_DETALLE_LISTA= 4;
    private static final int PROCEDURE_UPDATE_EVAL_DETALLE_ID_DETALLE_LISTA_EVAL_DETALLE_LISTA = 5;
    private static final int PROCEDURE_ELIMINAR_DETALLE_ID_EVAL_DETALLE_LISTA_INDEX = 1;

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Eval_Detalle_Lista_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param eval_detalle_lista
     * @return Retorna Null si el Eval_Detalle_lista no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Eval_Detalle_lista.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarEvalDetalleLista(Eval_Detalle_Lista_Bean detalle) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_EVAL_DETALLE);
        statement.setLong(PROCEDURE_INSERTAR_EVAL_DETALLE_ID_EVAL_DETALLE_LISTA_INDEX, detalle.getId_eval_detalle_lista());//asigna los valores necesarios para ejecutar el QUERY
        statement.setLong(PROCEDURE_INSERTAR_EVAL_DETALLE_CALIFICACION_EVAL_DETALLE_LISTA_INDEX, detalle.getCalificacion_eval_detalle_lista());
        statement.setString(PROCEDURE_INSERTAR_EVAL_DETALLE_OBSERVACION_EVAL_DETALLE_LISTA_INDEX, detalle.getObservarcion_eval_detalle_lista());
        statement.setLong(PROCEDURE_INSERTAR_EVAL_DETALLE_ID_EVAL_VERSION_GENERAL_EVAL_DETALLE_LISTA, detalle.getId_eval_version_general_eval_detalle_lista()); 
        statement.setLong(PROCEDURE_INSERTAR_EVAL_DETALLE_ID_DETALLE_LISTA_EVAL_DETALLE_LISTA, detalle.getId_eval_detalle_lista());
       
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
     * @param eval_detalle_lista
     * @return Retorna Null si el Eval_Detalle_lista no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Eval_Detalle_Lista.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateArea(Eval_Detalle_Lista_Bean detalle) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_EVAL_DETALLE);
        statement.setLong(PROCEDURE_UPDATE_EVAL_DETALLE_ID_EVAL_DETALLE_LISTA_INDEX, detalle.getId_eval_detalle_lista());//asigna los valores necesarios para ejecutar el QUERY
        statement.setLong(PROCEDURE_UPDATE_EVAL_DETALLE_CALIFICACION_EVAL_DETALLE_LISTA_INDEX, detalle.getCalificacion_eval_detalle_lista());
        statement.setString(PROCEDURE_UPDATE_EVAL_DETALLE_OBSERVACION_EVAL_DETALLE_LISTA_INDEX, detalle.getObservarcion_eval_detalle_lista());
        statement.setLong(PROCEDURE_UPDATE_EVAL_DETALLE_ID_EVAL_VERSION_GENERAL_EVAL_DETALLE_LISTA, detalle.getId_eval_version_general_eval_detalle_lista()); 
        statement.setLong(PROCEDURE_UPDATE_EVAL_DETALLE_ID_DETALLE_LISTA_EVAL_DETALLE_LISTA, detalle.getId_eval_detalle_lista());
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
     * @param eval_cetalle_lista
     * @return Retorna Null si el Eval_detalle_lista no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Eval_detalle_lista.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteArea(Eval_Detalle_Lista_Bean detalle) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_EVAL_DETALLE);
        statement.setLong(PROCEDURE_ELIMINAR_DETALLE_ID_EVAL_DETALLE_LISTA_INDEX, detalle.getId_detalle_lista_eval_detalle_lista());//asigna los valores necesarios para ejecutar el QUERY
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
