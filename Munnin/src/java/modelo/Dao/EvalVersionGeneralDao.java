
package modelo.Dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.naming.NamingException;
import modelo.Beans.EvalVersionGeneralBean;
import util.ClassConexion;
import util.ConexionBD;

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * EvalVersionGeneral.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

public class EvalVersionGeneralDao extends ConexionBD {

    private static final String COL_ID_EVAL_VERSION_GENERAL= "id_eval_version_general";
    private static final String COL_ID_VERSION_EVAL_VERSION_GENERAL = "id_version_eval_version_general";
    private static final String COL_ID_LISTA_EVAL_VERSION_GENERAL = "id_lista_eval_version_general";
    private static final String COL_CALIFICACION_EVAL_VERSION_GENERAL = "calificacion_eval_version_general";
    private static final String COL_OBSERVACION_EVAL_VERSION_GENERAL = "observaciones_eval_version_general";
    private static final String COL_FECHA_EVAL_VERSION_GENERAL = "fecha_eval_version_general";
    private static final String COL_ID_EVALUADOR_EVAL_VERSION_GENERAL = "id_evaluador_eval_version_general";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public EvalVersionGeneralDao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_eval_version_general Id de Eval_version_general
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean  InsertarVersion(EvalVersionGeneralBean version) throws SQLException {
       boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL INSERTAR_EVAL_VERSION(?,?,?,?,?,?,?)}";
        int indexIdEvalVersionGeneral = 1;
        int indexIdVersionEval= 2;
        int indexIdListaEval = 3;
        int indexCalificacionEval = 4;
        int indexObservacionesEval = 5;
        int indexFechaEval= 6;
        int indexIdEvaluadorEval = 7;
        
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setLong(indexIdEvalVersionGeneral, version.getId_eval_version_general());
        statement.setLong(indexIdVersionEval, version.getId_version_eval_version_general());
        statement.setLong(indexIdListaEval, version.getId_lista_eval_version_general());
        statement.setInt(indexCalificacionEval, version.getCalificacion_eval_version_general());
        statement.setString(indexObservacionesEval, version.getObservaciones_eval_version_general());
        statement.setDate(indexFechaEval, (java.sql.Date)version.getFecha_eval_version_general());
        statement.setLong(indexIdEvaluadorEval, version.getId_evaluador_eval_version_general());

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }

    /**
     * @param id_eval_version_general Id de evalversiongeneral
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean  UpdateVersion(EvalVersionGeneralBean version) throws SQLException {
       boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_EVAL_VERSION(?,?,?,?,?,?,?)}";
        int indexIdEvalVersionGeneral = 1;
        int indexIdVersionEval= 2;
        int indexIdListaEval = 3;
        int indexCalificacionEval = 4;
        int indexObservacionesEval = 5;
        int indexFechaEval= 6;
        int indexIdEvaluadorEval = 7;
        
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setLong(indexIdEvalVersionGeneral, version.getId_eval_version_general());
        statement.setLong(indexIdVersionEval, version.getId_version_eval_version_general());
        statement.setLong(indexIdListaEval, version.getId_lista_eval_version_general());
        statement.setInt(indexCalificacionEval, version.getCalificacion_eval_version_general());
        statement.setString(indexObservacionesEval, version.getObservaciones_eval_version_general());
        statement.setDate(indexFechaEval, (java.sql.Date)version.getFecha_eval_version_general());
        statement.setLong(indexIdEvaluadorEval, version.getId_evaluador_eval_version_general());

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }


    /**
     * @param Id_eval_version_general Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean  DeleteVersion(EvalVersionGeneralBean version) throws SQLException {
       boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL ELIMINAR_EVAL_VERSION(?)}";
        int indexIdEvalVersionGeneral = 1;
        
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setLong(indexIdEvalVersionGeneral, version.getId_eval_version_general());

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }


}
