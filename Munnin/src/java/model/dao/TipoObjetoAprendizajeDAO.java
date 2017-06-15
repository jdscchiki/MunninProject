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
import model.bean.TipoObjetoAprendizaje;
import util.database.connectionDB;

/**
 *
 * @author Juan David Segura
 */
public class TipoObjetoAprendizajeDAO extends connectionDB {

    private static final String COL_ID = "id_tipo_objeto_aprendizaje";
    private static final String COL_NOMBRE = "nombre_tipo_obj_apren";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor connectionDB
     * @throws SQLException Error en el constructor connectionDB
     */
    public TipoObjetoAprendizajeDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un tipo de objeto de aprendizaje en la base de datos
     *
     * @deprecated
     * @param tipoObjetoAprendizaje Datos del tipo de objeto de aprendizaje
     * insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(TipoObjetoAprendizaje tipoObjetoAprendizaje) throws SQLException {
        boolean result;

        String query = "{CALL INSERTAR_TIPO_OBJETO_APRENDIZAJE(?)}";
        int indexNombre = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, tipoObjetoAprendizaje.getNombre());
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
     * Metodo para actualizar un tipo de objeto de aprendizaje en la base de
     * datos
     *
     * @deprecated
     * @param tipoObjetoAprendizaje Datos del tipo de objeto de aprendizaje a
     * ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(TipoObjetoAprendizaje tipoObjetoAprendizaje) throws SQLException {
        boolean result;

        String query = "{CALL EDITAR_TIPO_OBJETO_APRENDIZAJE(?,?)}";
        int indexId = 1;
        int indexNombre = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, tipoObjetoAprendizaje.getId());
        statement.setString(indexNombre, tipoObjetoAprendizaje.getNombre());
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
     * Metodo para borrar un tipo de objeto de aprendizaje en la base de datos
     *
     * @deprecated
     * @param tipoObjetoAprendizaje Datos del tipo de objeto de aprendizaje
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(TipoObjetoAprendizaje tipoObjetoAprendizaje) throws SQLException {
        boolean result;

        String query = "{CALL ELIMINAR_TIPO_OBJETO_APRENDIZAJE(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, tipoObjetoAprendizaje.getId());

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
     * Metodo para ver los datos de un tipo de objeto de aprendizaje
     *
     * @param tipoObjetoAprendizaje Objeto de tipo TipoObjetoAprendizaje que en
     * el atributo id tiene el valor del id a ser consultado
     * @return los valores almacenados en la tabla tipo_objeto_aprendizaje de la
     * base de datos
     * @throws SQLException
     */
    public TipoObjetoAprendizaje select(TipoObjetoAprendizaje tipoObjetoAprendizaje) throws SQLException {

        String query = "{CALL VER_TIPO_OBJETO_APRENDIZAJE(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, tipoObjetoAprendizaje.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            tipoObjetoAprendizaje.setId(rs.getInt(COL_ID));
            tipoObjetoAprendizaje.setNombre(rs.getString(COL_NOMBRE));
        }
        if (!encontrado) {
            tipoObjetoAprendizaje = null;
        }

        return tipoObjetoAprendizaje;
    }
    
    public ArrayList<TipoObjetoAprendizaje> selectAll() throws SQLException {
        ArrayList<TipoObjetoAprendizaje> result = new ArrayList<>();

        String query = "{CALL VER_TODOS_TIPO_OBJETO_APRENDIZAJE()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            TipoObjetoAprendizaje tipoObjetoAprendizaje = new TipoObjetoAprendizaje();
            tipoObjetoAprendizaje.setId(rs.getInt(COL_ID));
            tipoObjetoAprendizaje.setNombre(rs.getString(COL_NOMBRE));
            
            result.add(tipoObjetoAprendizaje);
        }

        return result;
    }
}
