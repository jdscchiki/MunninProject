/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.bean.EvaluacionLista;
import model.bean.Funcionario;
import model.bean.Lista;
import model.bean.Version;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class EvaluacionListaDAO extends ConexionBD {

    private static final String COL_ID = "id_evaluacion_lista";
    private static final String COL_ID_VERSION = "id_version_evaluacion_lista";
    private static final String COL_ID_LISTA = "id_lista_evaluacion_lista";
    private static final String COL_CALIFICACION = "calificacion_evaluacion_lista";
    private static final String COL_OBSERVACION = "observaciones_evaluacion_lista";
    private static final String COL_FECHA = "fecha_evaluacion_lista";
    private static final String COL_ID_EVALUADOR = "id_evaluador_evaluacion_lista";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public EvaluacionListaDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar una evaluacion de version en la base de datos
     *
     * @deprecated
     * @param evaluacionLista Datos de la evaluacion de version insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(EvaluacionLista evaluacionLista) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_EVALUACION_LISTA(?,?,?,?,?,?)}";
        int indexIdVersion = 1;
        int indexIdLista = 2;
        int indexCalificacion = 3;
        int indexObservaciones = 4;
        int indexFecha = 5;
        int indexIdEvaluador = 6;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexIdVersion, evaluacionLista.getVersion().getId());
        statement.setInt(indexIdLista, evaluacionLista.getLista().getId());
        statement.setInt(indexCalificacion, evaluacionLista.getCalificacion());
        statement.setString(indexObservaciones, evaluacionLista.getObservaciones());
        statement.setDate(indexFecha, (java.sql.Date) evaluacionLista.getFecha());
        statement.setInt(indexIdEvaluador, evaluacionLista.getEvaluador().getId());
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
     * @param evaluacionLista Datos de la evaluacion de version a ser modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(EvaluacionLista evaluacionLista) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_EVALUACION_LISTA(?,?,?)}";
        int indexId = 1;
        int indexIdVersion = 2;
        int indexIdLista = 3;
        int indexCalificacion = 4;
        int indexObservaciones = 5;
        int indexFecha = 6;
        int indexIdEvaluador = 7;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionLista.getId());
        statement.setInt(indexIdVersion, evaluacionLista.getVersion().getId());
        statement.setInt(indexIdLista, evaluacionLista.getLista().getId());
        statement.setInt(indexCalificacion, evaluacionLista.getCalificacion());
        statement.setString(indexObservaciones, evaluacionLista.getObservaciones());
        statement.setDate(indexFecha, (java.sql.Date) evaluacionLista.getFecha());
        statement.setInt(indexIdEvaluador, evaluacionLista.getEvaluador().getId());
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
     * @param evaluacionLista Datos de la evaluacion de version
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(EvaluacionLista evaluacionLista) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_EVALUACION_LISTA(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionLista.getId());

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
     * @param evaluacionLista Objeto de tipo EvaluacionLista que en el atributo
     * id tiene el valor del id a ser consultado
     * @return los valores almacenados en la tabla evaluacion_lista de la base
     * de datos
     * @throws SQLException
     */
    public EvaluacionLista select(EvaluacionLista evaluacionLista) throws SQLException {

        String query = "{CALL VER_EVALUACION_LISTA(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionLista.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            evaluacionLista.setId(rs.getInt(COL_ID));
            Version version = new Version();
            version.setId(rs.getInt(COL_ID_VERSION));
            evaluacionLista.setVersion(version);
            Lista lista = new Lista();
            lista.setId(rs.getInt(COL_ID_LISTA));
            evaluacionLista.setLista(lista);
            evaluacionLista.setCalificacion(rs.getInt(COL_CALIFICACION));
            evaluacionLista.setObservaciones(rs.getString(COL_OBSERVACION));
            evaluacionLista.setFecha(rs.getDate(COL_FECHA));
            Funcionario evaluador = new Funcionario();
            evaluador.setId(rs.getInt(COL_ID_EVALUADOR));
            evaluacionLista.setEvaluador(evaluador);
        }
        if (!encontrado) {
            evaluacionLista = null;
        }

        return evaluacionLista;
    }
    
    public ArrayList<EvaluacionLista> selectAll() throws SQLException {
        ArrayList<EvaluacionLista> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_EVALUACION_LISTA()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            EvaluacionLista evaluacionLista = new EvaluacionLista();
            evaluacionLista.setId(rs.getInt(COL_ID));
            Version version = new Version();
            version.setId(rs.getInt(COL_ID_VERSION));
            evaluacionLista.setVersion(version);
            Lista lista = new Lista();
            lista.setId(rs.getInt(COL_ID_LISTA));
            evaluacionLista.setLista(lista);
            evaluacionLista.setCalificacion(rs.getInt(COL_CALIFICACION));
            evaluacionLista.setObservaciones(rs.getString(COL_OBSERVACION));
            evaluacionLista.setFecha(rs.getDate(COL_FECHA));
            Funcionario evaluador = new Funcionario();
            evaluador.setId(rs.getInt(COL_ID_EVALUADOR));
            evaluacionLista.setEvaluador(evaluador);
            
            result.add(evaluacionLista);
        }

        return result;
    }
    
    public boolean agregarListaVersion(EvaluacionLista evaluacionLista) throws SQLException {
        boolean resultado;

        String query = "{CALL ASIGNAR_EVALUACION_LISTA(?,?,?,?,?,?,?)}";
        int indexId = 1;
        int indexIdVersion = 2;
        int indexIdLista = 3;
        int indexCalificacion = 4;
        int indexObservaciones = 5;
        int indexFecha = 6;
        int indexIdEvaluador = 7;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionLista.getId());
        statement.setInt(indexIdVersion, evaluacionLista.getVersion().getId());
        statement.setInt(indexIdLista, evaluacionLista.getLista().getId());
        statement.setInt(indexCalificacion, evaluacionLista.getCalificacion());
        statement.setString(indexObservaciones, evaluacionLista.getObservaciones());
        statement.setDate(indexFecha, (java.sql.Date) evaluacionLista.getFecha());
        statement.setInt(indexIdEvaluador, evaluacionLista.getEvaluador().getId());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }
}
