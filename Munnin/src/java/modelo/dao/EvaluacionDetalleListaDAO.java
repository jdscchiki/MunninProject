/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import modelo.bean.EvaluacionDetalleLista;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class EvaluacionDetalleListaDAO extends ConexionBD {

    private static final String COL_ID = "id_eval_detalle_lista";
    private static final String COL_CALIFICACION = "calificacion_eval_detalle_lista";
    private static final String COL_OBSERVACION = "observarcion_eval_detalle_lista";
    private static final String COL_ID_EVAL_VERSION_GENERAL = "id_eval_version_general_eval_detalle_lista";
    private static final String COL_ID_DETALLE_LISTA = "id_detalle_lista_eval_detalle_lista";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public EvaluacionDetalleListaDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar una evaluacion de detalle de lista en la base de
     * datos
     *
     * @deprecated
     * @param evaluacionDetalleLista Datos de la evaluacion de detalle de lista
     * insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(EvaluacionDetalleLista evaluacionDetalleLista) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_EVAL_DETALLE_LISTA(?,?,?,?,?)}";
        int indexId = 1;
        int indexCalificacion = 2;
        int indexObservacion = 3;
        int indexIdEvalVersionGeneral = 4;
        int indexIdDetalleLista = 5;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionDetalleLista.getId());
        statement.setInt(indexCalificacion, evaluacionDetalleLista.getCalificacion());
        statement.setString(indexObservacion, evaluacionDetalleLista.getObservarcion());
        statement.setInt(indexIdEvalVersionGeneral, evaluacionDetalleLista.getIdEvaluacion());
        statement.setInt(indexIdDetalleLista, evaluacionDetalleLista.getIdDetalleLista());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para actualizar una evaluacion de detalle de lista en la base de
     * datos
     *
     * @deprecated
     * @param evaluacionDetalleLista Datos de la evaluacion de detalle de lista
     * a ser modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(EvaluacionDetalleLista evaluacionDetalleLista) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_EVAL_DETALLE_LISTA(?,?,?,?,?)}";
        int indexId = 1;
        int indexCalificacion = 2;
        int indexObservacion = 3;
        int indexIdEvalVersionGeneral = 4;
        int indexIdDetalleLista = 5;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionDetalleLista.getId());
        statement.setInt(indexCalificacion, evaluacionDetalleLista.getCalificacion());
        statement.setString(indexObservacion, evaluacionDetalleLista.getObservarcion());
        statement.setInt(indexIdEvalVersionGeneral, evaluacionDetalleLista.getIdEvaluacion());
        statement.setInt(indexIdDetalleLista, evaluacionDetalleLista.getIdDetalleLista());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para borrar una evaluacion de detalle de lista en la base de datos
     *
     * @deprecated
     * @param evaluacionDetalleLista Datos de la evaluacion de detalle de lista
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(EvaluacionDetalleLista evaluacionDetalleLista) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_EVAL_DETALLE_LISTA(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionDetalleLista.getId());

        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para ver los datos de una evaluacion de detalle de lista
     *
     * @param evaluacionDetalleLista Objeto de tipo EvaluacionDetalleLista que
     * en el atributo id tiene el valor del id a ser consultado
     * @return los valores almacenados en la tabla eval_detalle_lista de la base
     * de datos
     * @throws SQLException
     */
    public EvaluacionDetalleLista select(EvaluacionDetalleLista evaluacionDetalleLista) throws SQLException {

        String query = "{CALL VER_EVAL_DETALLE_LISTA(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionDetalleLista.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            evaluacionDetalleLista.setId(rs.getInt(COL_ID));
            evaluacionDetalleLista.setCalificacion(rs.getInt(COL_CALIFICACION));
            evaluacionDetalleLista.setObservarcion(rs.getString(COL_OBSERVACION));
            evaluacionDetalleLista.setIdEvaluacion(rs.getInt(COL_ID_EVAL_VERSION_GENERAL));
            evaluacionDetalleLista.setIdDetalleLista(rs.getInt(COL_ID_DETALLE_LISTA));
        }
        if (!encontrado) {
            evaluacionDetalleLista = null;
        }

        return evaluacionDetalleLista;
    }
}
