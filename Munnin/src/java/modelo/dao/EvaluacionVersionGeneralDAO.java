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
import modelo.bean.EvaluacionVersionGeneral;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class EvaluacionVersionGeneralDAO extends ConexionBD {

    private static final String COL_ID = "id_eval_version_general";
    private static final String COL_ID_VERSION = "id_version_eval_version_general";
    private static final String COL_ID_LISTA = "id_lista_eval_version_general";
    private static final String COL_CALIFICACION = "calificacion_eval_version_general";
    private static final String COL_OBSERVACION = "observaciones_eval_version_general";
    private static final String COL_FECHA = "fecha_eval_version_general";
    private static final String COL_ID_EVALUADOR = "id_evaluador_eval_version_general";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public EvaluacionVersionGeneralDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar una evaluacion de version en la base de datos
     *
     * @deprecated
     * @param evaluacionVersionGeneral Datos de la evaluacion de version
     * insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(EvaluacionVersionGeneral evaluacionVersionGeneral) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_EVAL_VERSION_GENERAL(?,?,?,?,?,?,?)}";
        int indexId = 1;
        int indexIdVersion = 2;
        int indexIdLista = 3;
        int indexCalificacion = 4;
        int indexObservaciones = 5;
        int indexFecha = 6;
        int indexIdEvaluador = 7;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setLong(indexId, evaluacionVersionGeneral.getId());
        statement.setLong(indexIdVersion, evaluacionVersionGeneral.getIdVersion());
        statement.setLong(indexIdLista, evaluacionVersionGeneral.getIdLista());
        statement.setInt(indexCalificacion, evaluacionVersionGeneral.getCalificacion());
        statement.setString(indexObservaciones, evaluacionVersionGeneral.getObservaciones());
        statement.setDate(indexFecha, (java.sql.Date) evaluacionVersionGeneral.getFecha());
        statement.setLong(indexIdEvaluador, evaluacionVersionGeneral.getIdEvaluador());
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
     * Metodo para actualizar una evaluacion de version en la base de datos
     *
     * @deprecated
     * @param evaluacionVersionGeneral Datos de la evaluacion de version a ser
     * modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(EvaluacionVersionGeneral evaluacionVersionGeneral) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_EVAL_VERSION_GENERAL(?,?,?)}";
        int indexId = 1;
        int indexIdVersion = 2;
        int indexIdLista = 3;
        int indexCalificacion = 4;
        int indexObservaciones = 5;
        int indexFecha = 6;
        int indexIdEvaluador = 7;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionVersionGeneral.getId());
        statement.setInt(indexIdVersion, evaluacionVersionGeneral.getIdVersion());
        statement.setInt(indexIdLista, evaluacionVersionGeneral.getIdLista());
        statement.setInt(indexCalificacion, evaluacionVersionGeneral.getCalificacion());
        statement.setString(indexObservaciones, evaluacionVersionGeneral.getObservaciones());
        statement.setDate(indexFecha, (java.sql.Date) evaluacionVersionGeneral.getFecha());
        statement.setInt(indexIdEvaluador, evaluacionVersionGeneral.getIdEvaluador());
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
     * Metodo para borrar una evaluacion de version en la base de datos
     *
     * @deprecated
     * @param evaluacionVersionGeneral Datos de la evaluacion de version
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(EvaluacionVersionGeneral evaluacionVersionGeneral) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_EVAL_VERSION_GENERAL(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionVersionGeneral.getId());

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
     * Metodo para ver los datos de una evaluacion de version
     *
     * @param evaluacionVersionGeneral Objeto de tipo EvaluacionVersionGeneral
     * que en el atributo id tiene el valor del id a ser consultado
     * @return los valores almacenados en la tabla Eval_version_general de la
     * base de datos
     * @throws SQLException
     */
    public EvaluacionVersionGeneral select(EvaluacionVersionGeneral evaluacionVersionGeneral) throws SQLException {

        String query = "{CALL VER_EVAL_VERSION_GENERAL(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionVersionGeneral.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            evaluacionVersionGeneral.setId(rs.getInt(COL_ID));
            evaluacionVersionGeneral.setIdVersion(rs.getInt(COL_ID_VERSION));
            evaluacionVersionGeneral.setIdLista(rs.getInt(COL_ID_LISTA));
            evaluacionVersionGeneral.setCalificacion(rs.getInt(COL_CALIFICACION));
            evaluacionVersionGeneral.setObservaciones(rs.getString(COL_OBSERVACION));
            evaluacionVersionGeneral.setFecha(rs.getDate(COL_FECHA));
            evaluacionVersionGeneral.setIdEvaluador(rs.getInt(COL_ID_EVALUADOR));
        }
        if (!encontrado) {
            evaluacionVersionGeneral = null;
        }

        return evaluacionVersionGeneral;
    }
}
