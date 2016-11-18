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

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * Eval_Detalle_Lista
 * .
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

public class Eval_Detalle_Lista_Dao extends ConexionBD {

    private static final String COL_ID_EVAL_DETALLE_LISTA = "id_eval_detalle_lista";
    private static final String COL_CALIFICACION_EVAL_DETALLE_LISTA = "calificacion_eval_detalle_lista";
    private static final String COL_OBSERVACION_EVAL_DETALLE_LISTA = "observarcion_eval_detalle_lista";
    private static final String COL_ID_EVAL_VERSION_GENERAL_EVAL_DETALLE_LISTA = "id_eval_version_general_eval_detalle_lista";
    private static final String COL_ID_DETALLE_LISTA_EVAL_DETALLE_LISTA = "id_detalle_lista_eval_detalle_lista";

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
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean InsertarEvalDetalleLista(Eval_Detalle_Lista_Bean detalle) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL INSERTAR_EVAL_DETALLE(?,?,?,?,?)}";
        int indexIdEvalDetalleLista =1;
        int indexCalificacionEvalDetalleLista =2;
        int indexObservacionEvalDetalleLista =3;
        int indexIdEvalVersionGeneralDetalleLista =4;
        int indexIdDetalleListaEvalDetalleLista =5;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdEvalDetalleLista, detalle.getId_eval_detalle_lista());
        statement.setLong(indexCalificacionEvalDetalleLista, detalle.getCalificacion_eval_detalle_lista());
        statement.setString(indexObservacionEvalDetalleLista, detalle.getObservarcion_eval_detalle_lista());
        statement.setLong(indexIdEvalVersionGeneralDetalleLista, detalle.getId_eval_version_general_eval_detalle_lista()); 
        statement.setLong(indexIdDetalleListaEvalDetalleLista, detalle.getId_detalle_lista_eval_detalle_lista());
       
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
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean UpdateArea(Eval_Detalle_Lista_Bean detalle) throws SQLException {
       boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL EDITAR_EVAL_DETALLE(?,?,?,?,?)}";
        int indexIdEvalDetalleLista =1;
        int indexCalificacionEvalDetalleLista =2;
        int indexObservacionEvalDetalleLista =3;
        int indexIdEvalVersionGeneralDetalleLista =4;
        int indexIdDetalleListaEvalDetalleLista =5;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdEvalDetalleLista, detalle.getId_eval_detalle_lista());
        statement.setLong(indexCalificacionEvalDetalleLista, detalle.getCalificacion_eval_detalle_lista());
        statement.setString(indexObservacionEvalDetalleLista, detalle.getObservarcion_eval_detalle_lista());
        statement.setLong(indexIdEvalVersionGeneralDetalleLista, detalle.getId_eval_version_general_eval_detalle_lista()); 
        statement.setLong(indexIdDetalleListaEvalDetalleLista, detalle.getId_detalle_lista_eval_detalle_lista());
       
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
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL ELIMINAR_EVAL_DETALLE(?)}";
        int indexIdEvalDetalleLista =1;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdEvalDetalleLista, detalle.getId_eval_detalle_lista());
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
