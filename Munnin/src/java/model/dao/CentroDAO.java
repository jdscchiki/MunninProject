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
import model.bean.Centro;
import model.bean.Ciudad;
import model.bean.Regional;
import util.database.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class CentroDAO extends ConexionBD {

    private static final String COL_ID = "id_centro";
    private static final String COL_NOMBRE = "nombre_centro";
    private static final String COL_ID_REGIONAL = "id_regional_centro";
    private static final String COL_ID_CIUDAD = "id_ciudad_centro";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public CentroDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un centro en la base de datos
     *
     * @deprecated
     * @param centro Datos del centro insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Centro centro) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_CENTRO(?,?,?,?)}";
        int indexId = 1;
        int indexNombre = 2;
        int indexIdRegional = 3;
        int indexIdCiudad = 4;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexId, centro.getId());
        statement.setString(indexNombre, centro.getNombre());
        statement.setString(indexIdRegional, centro.getRegional().getId());
        statement.setString(indexIdCiudad, centro.getCiudad().getId());

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
     * Metodo para actualizar un centro en la base de datos
     *
     * @deprecated
     * @param centro Datos del centro a ser modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Centro centro) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_CENTRO(?,?,?,?)}";
        int indexId = 1;
        int indexNombre = 2;
        int indexIdRegional = 3;
        int indexIdCiudad = 4;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexId, centro.getId());
        statement.setString(indexNombre, centro.getNombre());
        statement.setString(indexIdRegional, centro.getRegional().getId());
        statement.setString(indexIdCiudad, centro.getCiudad().getId());

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
     * Metodo para borrar un centro en la base de datos
     *
     * @deprecated
     * @param centro Datos del centro
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Centro centro) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_CENTRO(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexId, centro.getId());

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
     * Metodo para ver los datos de un centro
     *
     * @param centro Objeto de tipo Centro que en el atributo id tiene el valor
     * del id a ser consultado
     * @return los valores almacenados en la tabla centro de la base de datos
     * @throws SQLException
     */
    public Centro select(Centro centro) throws SQLException {

        String query = "{CALL VER_CENTRO(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexId, centro.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            centro.setId(rs.getString(COL_ID));
            centro.setNombre(rs.getString(COL_NOMBRE));
            Regional regional = new Regional();
            regional.setId(rs.getString(COL_ID_REGIONAL));
            centro.setRegional(regional);
            Ciudad ciudad = new Ciudad();
            ciudad.setId(rs.getString(COL_ID_CIUDAD));
            centro.setCiudad(ciudad);
        }
        if (!encontrado) {
            centro = null;
        }

        return centro;
    }
    
    public ArrayList<Centro> selectAll() throws SQLException {
        ArrayList<Centro> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_CENTRO()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            Centro centro = new Centro();
            centro.setId(rs.getString(COL_ID));
            centro.setNombre(rs.getString(COL_NOMBRE));
            Regional regional = new Regional();
            regional.setId(rs.getString(COL_ID_REGIONAL));
            centro.setRegional(regional);
            Ciudad ciudad = new Ciudad();
            ciudad.setId(rs.getString(COL_ID_CIUDAD));
            centro.setCiudad(ciudad);
            
            result.add(centro);
        }

        return result;
    }
}
