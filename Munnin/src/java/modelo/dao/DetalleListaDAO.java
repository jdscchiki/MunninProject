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
import modelo.bean.DetalleLista;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class DetalleListaDAO extends ConexionBD {

    private static final String COL_ID = "id_detalle_lista";
    private static final String COL_ID_LISTA = "id_lista_detalle_lista";
    private static final String COL_ID_ITEM = "id_item_detalle_lista";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public DetalleListaDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un detalle de lista en la base de datos
     *
     * @deprecated
     * @param detalleLista Datos del detalle de lista insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(DetalleLista detalleLista) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_DETALLE_LISTA(?,?,?)}";
        int indexId = 1;
        int indexIdLista = 2;
        int indexIdItem = 3;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, detalleLista.getId());
        statement.setInt(indexIdLista, detalleLista.getIdLista());
        statement.setInt(indexIdItem, detalleLista.getIdItem());
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
     * Metodo para actualizar un detalle de lista en la base de datos
     *
     * @deprecated
     * @param detalleLista Datos del detalle de lista a ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(DetalleLista detalleLista) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_DETALLE_LISTA(?,?,?)}";
        int indexId = 1;
        int indexIdLista = 2;
        int indexIdItem = 3;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, detalleLista.getId());
        statement.setInt(indexIdLista, detalleLista.getIdLista());
        statement.setInt(indexIdItem, detalleLista.getIdItem());
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
     * Metodo para borrar un detalle de lista en la base de datos
     *
     * @deprecated
     * @param detalleLista Datos del detalle de lista
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(DetalleLista detalleLista) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_DETALLE_LISTA(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, detalleLista.getId());

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
     * Metodo para ver los datos de un detalle de lista
     *
     * @param detalleLista Objeto de tipo DetalleLista que en el atributo id
     * tiene el valor del id a ser consultado
     * @return los valores almacenados en la tabla detalle_lista de la base de
     * datos
     * @throws SQLException
     */
    public DetalleLista select(DetalleLista detalleLista) throws SQLException {

        String query = "{CALL VER_DETALLE_LISTA(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, detalleLista.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            detalleLista.setId(rs.getInt(COL_ID));
            detalleLista.setIdLista(rs.getInt(COL_ID_LISTA));
            detalleLista.setIdItem(rs.getInt(COL_ID_ITEM));
        }
        if (!encontrado) {
            detalleLista = null;
        }

        return detalleLista;
    }
}
