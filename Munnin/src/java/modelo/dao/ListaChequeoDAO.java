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
import modelo.bean.ListaChequeo;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class ListaChequeoDAO extends ConexionBD {

    private static final String COL_ID = "id_lista";
    private static final String COL_NOMBRE = "nombre_lista";
    private static final String COL_DESCRIPCION = "descripcion_lista";
    private static final String COL_FECHA = "fecha_lista";
    private static final String COL_TIPO = "tipo_lista";
    private static final String COL_ID_AUTOR = "id_autor_lista";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public ListaChequeoDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar una lista de chequeo en la base de datos
     *
     * @deprecated
     * @param listaChequeo Datos de la lista de chequeo insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(ListaChequeo listaChequeo) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_LISTA(?,?,?,?,?,?)}";
        int indexId = 1;
        int indexNombre = 2 ;
        int indexDescripcion = 3;
        int indexFecha = 4;
        int indexTipo = 5;
        int indexIdAutor = 6;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, listaChequeo.getId());
        statement.setString(indexNombre, listaChequeo.getNombre());
        statement.setString(indexDescripcion, listaChequeo.getDescripcion());
        statement.setDate(indexFecha, (java.sql.Date) listaChequeo.getFecha());
        statement.setString(indexTipo, listaChequeo.getTipo());
        statement.setInt(indexIdAutor, listaChequeo.getIdAutor());
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
     * Metodo para actualizar una lista de chequeo en la base de datos
     *
     * @deprecated
     * @param listaChequeo Datos de la lista de chequeo a ser modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(ListaChequeo listaChequeo) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_LISTA(?,?,?,?,?,?)}";
        int indexId = 1;
        int indexNombre = 2 ;
        int indexDescripcion = 3;
        int indexFecha = 4;
        int indexTipo = 5;
        int indexIdAutor = 6;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, listaChequeo.getId());
        statement.setString(indexNombre, listaChequeo.getNombre());
        statement.setString(indexDescripcion, listaChequeo.getDescripcion());
        statement.setDate(indexFecha, (java.sql.Date) listaChequeo.getFecha());
        statement.setString(indexTipo, listaChequeo.getTipo());
        statement.setInt(indexIdAutor, listaChequeo.getIdAutor());
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
     * Metodo para borrar una lista de chequeo en la base de datos
     *
     * @deprecated
     * @param listaChequeo Datos de la lista de chequeo
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(ListaChequeo listaChequeo) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_LISTA_CHEQUEO(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, listaChequeo.getId());

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
     * Metodo para ver los datos de una lista de chequeo
     *
     * @param listaChequeo Objeto de tipo ListaChequeo que en el atributo id tiene el
     * valor del id a ser consultado
     * @return los valores almacenados en la tabla lista_chequeo de la base de datos
     * @throws SQLException
     */
    public ListaChequeo select(ListaChequeo listaChequeo) throws SQLException {

        String query = "{CALL VER_LISTA_CHEQUEO(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, listaChequeo.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            listaChequeo.setId(rs.getInt(COL_ID));
            listaChequeo.setNombre(rs.getString(COL_NOMBRE));
            listaChequeo.setDescripcion(rs.getString(COL_DESCRIPCION));
            listaChequeo.setFecha(rs.getDate(COL_FECHA));
            listaChequeo.setTipo(rs.getString(COL_TIPO));
            listaChequeo.setIdAutor(rs.getInt(COL_ID_AUTOR));
        }
        if (!encontrado) {
            listaChequeo = null;
        }

        return listaChequeo;
    }
}
