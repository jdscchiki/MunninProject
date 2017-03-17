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
import model.bean.TipoLista;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class TipoListaDAO extends ConexionBD {

    private static final String COL_ID = "id_tipo_lista";
    private static final String COL_NOMBRE = "nombre_tipo_lista";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public TipoListaDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un tipo de lista en la base de datos
     *
     * @deprecated
     * @param tipoLista Datos del tipo de lista insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(TipoLista tipoLista) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_TIPO_LISTA(?)}";
        int indexNombre = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, tipoLista.getNombre());
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
     * Metodo para actualizar un tipo de lista en la base de datos
     *
     * @deprecated
     * @param tipoLista Datos del tipo de lista a ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(TipoLista tipoLista) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_TIPO_LISTA(?,?)}";
        int indexId = 1;
        int indexNombre = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, tipoLista.getId());
        statement.setString(indexNombre, tipoLista.getNombre());
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
     * Metodo para borrar un tipo de lista en la base de datos
     *
     * @deprecated
     * @param tipoLista Datos del tipo de lista
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(TipoLista tipoLista) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_TIPO_LISTA(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, tipoLista.getId());

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
     * Metodo para ver los datos de un tipo de lista
     *
     * @param tipoLista Objeto de tipo TipoLista que en el atributo id tiene el
     * valor del id a ser consultado
     * @return los valores almacenados en la tabla tipo_lista de la base de
     * datos
     * @throws SQLException
     */
    public TipoLista select(TipoLista tipoLista) throws SQLException {

        String query = "{CALL VER_TIPO_LISTA(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, tipoLista.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            tipoLista.setId(rs.getInt(COL_ID));
            tipoLista.setNombre(rs.getString(COL_NOMBRE));
        }
        if (!encontrado) {
            tipoLista = null;
        }

        return tipoLista;
    }
    
    public ArrayList<TipoLista> selectAll() throws SQLException {
        ArrayList<TipoLista> result = new ArrayList<>();

        String query = "{CALL VER_TODOS_TIPO_LISTA()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            TipoLista tipoLista = new TipoLista();
            tipoLista.setId(rs.getInt(COL_ID));
            tipoLista.setNombre(rs.getString(COL_NOMBRE));
            
            result.add(tipoLista);
        }

        return result;
    }
}
