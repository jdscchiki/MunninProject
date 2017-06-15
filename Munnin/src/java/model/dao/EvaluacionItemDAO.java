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
import model.bean.EvaluacionItem;
import model.bean.EvaluacionLista;
import model.bean.Item;
import util.database.connectionDB;

/**
 *
 * @author Juan David Segura
 */
public class EvaluacionItemDAO extends connectionDB {

    private static final String COL_ID = "id_evaluacion_item";
    private static final String COL_CALIFICACION = "calificacion_evaluacion_item";
    private static final String COL_OBSERVACION = "observarcion_evaluacion_item";
    private static final String COL_ID_EVALUACION_LISTA = "id_evaluacion_lista_evaluacion_item";
    private static final String COL_ID_ITEM = "id_item_evaluacion_item";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor connectionDB
     * @throws SQLException Error en el constructor connectionDB
     */
    public EvaluacionItemDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar una evaluacion de item de lista en la base de datos
     *
     * @deprecated
     * @param evaluacionItem Datos de la evaluacion de item de lista insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(EvaluacionItem evaluacionItem) throws SQLException {
        boolean result;

        String query = "{CALL INSERTAR_EVALUACION_ITEM(?,?,?,?)}";
        int indexCalificacion = 1;
        int indexObservacion = 2;
        int indexIdEvaluacionLista = 3;
        int indexIdItem = 4;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexCalificacion, evaluacionItem.getCalificacion());
        statement.setString(indexObservacion, evaluacionItem.getObservarcion());
        statement.setInt(indexIdEvaluacionLista, evaluacionItem.getEvaluacionLista().getId());
        statement.setInt(indexIdItem, evaluacionItem.getItem().getId());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            result = true;
        } else {
            this.getConexion().rollback();
            result = false;
        }
        return result;
    }

    /**
     * Metodo para actualizar una evaluacion de item de lista en la base de
     * datos
     *
     * @deprecated
     * @param evaluacionItem Datos de la evaluacion de item de lista a ser
     * modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(EvaluacionItem evaluacionItem) throws SQLException {
        boolean result;

        String query = "{CALL EDITAR_EVALUACION_ITEM(?,?,?,?,?)}";
        int indexId = 1;
        int indexCalificacion = 2;
        int indexObservacion = 3;
        int indexIdEvaluacionLista = 4;
        int indexIdItem = 5;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionItem.getId());
        statement.setInt(indexCalificacion, evaluacionItem.getCalificacion());
        statement.setString(indexObservacion, evaluacionItem.getObservarcion());
        statement.setInt(indexIdEvaluacionLista, evaluacionItem.getEvaluacionLista().getId());
        statement.setInt(indexIdItem, evaluacionItem.getItem().getId());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            result = true;
        } else {
            this.getConexion().rollback();
            result = false;
        }
        return result;
    }

    /**
     * Metodo para borrar una evaluacion de item de lista en la base de datos
     *
     * @deprecated
     * @param evaluacionItem Datos de la evaluacion de item de lista
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(EvaluacionItem evaluacionItem) throws SQLException {
        boolean result;

        String query = "{CALL ELIMINAR_EVALUACION_ITEM(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionItem.getId());

        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            result = true;
        } else {
            this.getConexion().rollback();
            result = false;
        }
        return result;
    }

    /**
     * Metodo para ver los datos de una evaluacion de item de lista
     *
     * @param evaluacionItem Objeto de tipo EvaluacionItem que en el atributo id
     * tiene el valor del id a ser consultado
     * @return los valores almacenados en la tabla evaluacion_item de la base de
     * datos
     * @throws SQLException
     */
    public EvaluacionItem select(EvaluacionItem evaluacionItem) throws SQLException {

        String query = "{CALL VER_EVALUACION_ITEM(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, evaluacionItem.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            evaluacionItem.setId(rs.getInt(COL_ID));
            evaluacionItem.setCalificacion(rs.getInt(COL_CALIFICACION));
            evaluacionItem.setObservarcion(rs.getString(COL_OBSERVACION));
            EvaluacionLista evaluacionLista = new EvaluacionLista();
            evaluacionLista.setId(rs.getInt(COL_ID_EVALUACION_LISTA));
            evaluacionItem.setEvaluacionLista(evaluacionLista);
            Item item = new Item();
            item.setId(rs.getInt(COL_ID_ITEM));
            evaluacionItem.setItem(item);
        }
        if (!encontrado) {
            evaluacionItem = null;
        }

        return evaluacionItem;
    }
    
    public ArrayList<EvaluacionItem> selectAll() throws SQLException {
        ArrayList<EvaluacionItem> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_EVALUACION_ITEM()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            EvaluacionItem evaluacionItem = new EvaluacionItem();
            evaluacionItem.setId(rs.getInt(COL_ID));
            evaluacionItem.setCalificacion(rs.getInt(COL_CALIFICACION));
            evaluacionItem.setObservarcion(rs.getString(COL_OBSERVACION));
            EvaluacionLista evaluacionLista = new EvaluacionLista();
            evaluacionLista.setId(rs.getInt(COL_ID_EVALUACION_LISTA));
            evaluacionItem.setEvaluacionLista(evaluacionLista);
            Item item = new Item();
            item.setId(rs.getInt(COL_ID_ITEM));
            evaluacionItem.setItem(item);
            result.add(evaluacionItem);
        }

        return result;
    }
    
    public boolean AsignEvaluacionItem(EvaluacionItem evaluacionItem) throws SQLException {
        boolean result;

        String query = "{CALL INSERTAR_EVALUACION_ITEM(?,?,?,?)}";
        int indexCalificacion = 1;
        int indexObservacion = 2;
        int indexIdEvaluacionLista = 3;
        int indexIdItem = 4;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexCalificacion, evaluacionItem.getCalificacion());
        statement.setString(indexObservacion, evaluacionItem.getObservarcion());
        statement.setInt(indexIdEvaluacionLista, evaluacionItem.getEvaluacionLista().getId());
        statement.setInt(indexIdItem, evaluacionItem.getItem().getId());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            result = true;
        } else {
            this.getConexion().rollback();
            result = false;
        }
        return result;
    }
}
