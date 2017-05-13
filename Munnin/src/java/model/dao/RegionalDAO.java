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
import model.bean.Regional;
import util.database.connectionDB;

/**
 *
 * @author Juan David Segura
 */
public class RegionalDAO extends connectionDB {

    private static final String COL_ID = "id_regional";
    private static final String COL_NOMBRE = "nombre_regional";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor connectionDB
     * @throws SQLException Error en el constructor connectionDB
     */
    public RegionalDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar una regional en la base de datos
     *
     * @deprecated
     * @param regional Datos de la regional insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Regional regional) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_REGIONAL(?,?)}";
        int indexId = 1;
        int indexNombre = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexId, regional.getId());
        statement.setString(indexNombre, regional.getNombre());
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
     * Metodo para actualizar una regional en la base de datos
     *
     * @deprecated
     * @param regional Datos de la regional a ser modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Regional regional) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_REGIONAL(?,?)}";
        int indexId = 1;
        int indexNombre = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexId, regional.getId());
        statement.setString(indexNombre, regional.getNombre());
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
     * Metodo para borrar una regional en la base de datos
     *
     * @deprecated
     * @param regional Datos de la regional
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Regional regional) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_REGIONAL(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexId, regional.getId());

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
     * Metodo para ver los datos de una regional
     *
     * @param regional Objeto de tipo Regional que en el atributo id tiene el
     * valor del id a ser consultado
     * @return los valores almacenados en la tabla regional de la base de datos
     * @throws SQLException
     */
    public Regional select(Regional regional) throws SQLException {

        String query = "{CALL VER_REGIONAL(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexId, regional.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            regional.setId(rs.getString(COL_ID));
            regional.setNombre(rs.getString(COL_NOMBRE));
        }
        if (!encontrado) {
            regional = null;
        }

        return regional;
    }
    
    public ArrayList<Regional> selectAll() throws SQLException {
        ArrayList<Regional> result = new ArrayList<>();

        String query = "{CALL VER_TODOS_REGIONAL()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Regional regional = new Regional();
            regional.setId(rs.getString(COL_ID));
            regional.setNombre(rs.getString(COL_NOMBRE));
            
            result.add(regional);
        }

        return result;
    }
}
