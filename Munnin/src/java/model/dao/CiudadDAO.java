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
import model.bean.Ciudad;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class CiudadDAO extends ConexionBD {

    private static final String COL_ID = "id_ciudad";
    private static final String COL_NOMBRE = "nombre_ciudad";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public CiudadDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar una ciudad en la base de datos
     *
     * @deprecated
     * @param ciudad Datos de la ciudad insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Ciudad ciudad) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_CIUDAD(?,?)}";
        int indexId = 1;
        int indexNombre = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexId, ciudad.getId());
        statement.setString(indexNombre, ciudad.getNombre());
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
     * Metodo para actualizar una ciudad en la base de datos
     *
     * @deprecated
     * @param ciudad Datos de la ciudad a ser modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Ciudad ciudad) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_CIUDAD(?,?)}";
        int indexId = 1;
        int indexNombre = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexId, ciudad.getId());
        statement.setString(indexNombre, ciudad.getNombre());
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
     * Metodo para borrar una ciudad en la base de datos
     *
     * @deprecated
     * @param ciudad Datos de la ciudad
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Ciudad ciudad) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_CIUDAD(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexId, ciudad.getId());

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
     * Metodo para ver los datos de una ciudad
     *
     * @param ciudad Objeto de tipo Ciudad que en el atributo id tiene el valor
     * del id a ser consultado
     * @return los valores almacenados en la tabla ciudad de la base de datos
     * @throws SQLException
     */
    public Ciudad select(Ciudad ciudad) throws SQLException {

        String query = "{CALL VER_CIUDAD(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexId, ciudad.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            ciudad.setId(rs.getString(COL_ID));
            ciudad.setNombre(rs.getString(COL_NOMBRE));
        }
        if (!encontrado) {
            ciudad = null;
        }

        return ciudad;
    }
    
    public ArrayList<Ciudad> selectAll() throws SQLException {
        ArrayList<Ciudad> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_CIUDAD()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Ciudad ciudad = new Ciudad();
            ciudad.setId(rs.getString(COL_ID));
            ciudad.setNombre(rs.getString(COL_NOMBRE));
            result.add(ciudad);
        }

        return result;
    }
}
