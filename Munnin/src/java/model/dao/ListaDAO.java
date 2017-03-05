/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import model.bean.Lista;
import model.bean.TipoLista;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class ListaDAO extends ConexionBD {

    private static final String COL_ID = "id_lista";
    private static final String COL_NOMBRE = "nombre_lista";
    private static final String COL_DESCRIPCION = "descripcion_lista";
    private static final String COL_FECHA = "fecha_lista";
    private static final String COL_ID_TIPO_LISTA = "id_tipo_lista_lista";
    private static final String COL_ID_AUTOR = "id_autor_lista";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public ListaDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar una lista en la base de datos
     *
     * @deprecated
     * @param lista Datos de la lista insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Lista lista) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_LISTA(?,?,?,?,?,?)}";
        int indexNombre = 1;
        int indexDescripcion = 2;
        int indexFecha = 3;
        int indexTipo = 4;
        int indexIdAutor = 5;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, lista.getNombre());
        statement.setString(indexDescripcion, lista.getDescripcion());
        statement.setDate(indexFecha, (java.sql.Date) lista.getFecha());
        statement.setInt(indexTipo, lista.getTipoLista().getId());
        statement.setInt(indexIdAutor, lista.getIdAutor());
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
     * Metodo para actualizar una lista en la base de datos
     *
     * @deprecated
     * @param lista Datos de la lista a ser modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Lista lista) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_LISTA(?,?,?,?,?,?)}";
        int indexId = 1;
        int indexNombre = 2;
        int indexDescripcion = 3;
        int indexFecha = 4;
        int indexTipo = 5;
        int indexIdAutor = 6;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, lista.getId());
        statement.setString(indexNombre, lista.getNombre());
        statement.setString(indexDescripcion, lista.getDescripcion());
        statement.setDate(indexFecha, (java.sql.Date) lista.getFecha());
        statement.setInt(indexTipo, lista.getTipoLista().getId());
        statement.setInt(indexIdAutor, lista.getIdAutor());
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
     * Metodo para borrar una lista en la base de datos
     *
     * @deprecated
     * @param lista Datos de la lista
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Lista lista) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_LISTA(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, lista.getId());

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
     * Metodo para ver los datos de una lista
     *
     * @param lista Objeto de tipo Lista que en el atributo id tiene el valor
     * del id a ser consultado
     * @return los valores almacenados en la tabla lista de la base de datos
     * @throws SQLException
     */
    public Lista select(Lista lista) throws SQLException {

        String query = "{CALL VER_LISTA(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, lista.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            lista.setId(rs.getInt(COL_ID));
            lista.setNombre(rs.getString(COL_NOMBRE));
            lista.setDescripcion(rs.getString(COL_DESCRIPCION));
            lista.setFecha(rs.getDate(COL_FECHA));
            TipoLista tipoLista = new TipoLista();
            tipoLista.setId(rs.getInt(COL_ID_TIPO_LISTA));
            lista.setTipoLista(tipoLista);
            lista.setIdAutor(rs.getInt(COL_ID_AUTOR));
        }
        if (!encontrado) {
            lista = null;
        }

        return lista;
    }
}
