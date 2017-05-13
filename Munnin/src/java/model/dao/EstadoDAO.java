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
import model.bean.Estado;
import util.database.connectionDB;

/**
 *
 * @author Juan David Segura
 */
public class EstadoDAO extends connectionDB {

    private static final String COL_ID = "id_estado";
    private static final String COL_NOMBRE = "nombre_estado";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor connectionDB
     * @throws SQLException Error en el constructor connectionDB
     */
    public EstadoDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un estado en la base de datos
     *
     * @deprecated
     * @param estado Datos del estado insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Estado estado) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_ESTADO(?)}";
        int indexNombre = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, estado.getNombre());
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
     * Metodo para actualizar un estado en la base de datos
     *
     * @deprecated
     * @param estado Datos del estado a ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Estado estado) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_ESTADO(?,?)}";
        int indexId = 1;
        int indexNombre = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, estado.getId());
        statement.setString(indexNombre, estado.getNombre());
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
     * Metodo para borrar un estado en la base de datos
     *
     * @deprecated
     * @param estado Datos del estado
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Estado estado) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_ESTADO(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, estado.getId());

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
     * Metodo para ver los datos de un estado
     *
     * @param estado Objeto de tipo Estado que en el atributo id tiene el valor
     * del id a ser consultado
     * @return los valores almacenados en la tabla estado de la base de datos
     * @throws SQLException
     */
    public Estado select(Estado estado) throws SQLException {

        String query = "{CALL VER_ESTADO(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, estado.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            estado.setId(rs.getInt(COL_ID));
            estado.setNombre(rs.getString(COL_NOMBRE));
        }
        if (!encontrado) {
            estado = null;
        }

        return estado;
    }
    
    public ArrayList<Estado> selectAll() throws SQLException {
        ArrayList<Estado> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_ESTADO()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Estado estado = new Estado();
            estado.setId(rs.getInt(COL_ID));
            estado.setNombre(rs.getString(COL_NOMBRE));
            result.add(estado);
        }

        return result;
    }
}
