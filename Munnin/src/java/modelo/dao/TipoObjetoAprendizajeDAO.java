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
import modelo.bean.TipoObjetoAprendizaje;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class TipoObjetoAprendizajeDAO extends ConexionBD {

    private static final String COL_ID = "id_tipo_objeto_aprendizaje";
    private static final String COL_NOMBRE = "nombre_tipo_objeto_aprendizaje";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
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
        boolean resultado;

        String query = "{CALL INSERTAR_TIPO_OBJETO_APRENDIZAJE(?)}";
        int indexNombre = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, tipoObjetoAprendizaje.getNombre());
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
        boolean resultado;

        String query = "{CALL EDITAR_TIPO_OBJETO_APRENDIZAJE(?,?)}";
        int indexId = 1;
        int indexNombre = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, tipoObjetoAprendizaje.getId());
        statement.setString(indexNombre, tipoObjetoAprendizaje.getNombre());
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
     * Metodo para borrar un tipo de objeto de aprendizaje en la base de datos
     *
     * @deprecated
     * @param tipoObjetoAprendizaje Datos del tipo de objeto de aprendizaje
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(TipoObjetoAprendizaje tipoObjetoAprendizaje) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_TIPO_OBJETO_APRENDIZAJE(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, tipoObjetoAprendizaje.getId());

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
}
