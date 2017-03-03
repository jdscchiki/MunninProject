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
import model.bean.Categoria;
import model.bean.Centro;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class CategoriaDAO extends ConexionBD {

    private static final String COL_ID = "id_categoria";
    private static final String COL_NOMBRE = "nombre_categoria";
    private static final String COL_ACTIVO = "activo_categoria";
    private static final String COL_ID_CENTRO = "id_centro_categoria";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public CategoriaDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar una categoria en la base de datos
     *
     * @deprecated
     * @param categoria Datos de la categoria insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Categoria categoria) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_CATEGORIA(?,?,?)}";
        int indexNombre = 1;
        int indexActivo = 2;
        int indexIdCentro = 3;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, categoria.getNombre());
        statement.setBoolean(indexActivo, categoria.isActivo());
        statement.setString(indexIdCentro, categoria.getCentro().getId());
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
     * Metodo para actualizar una categoria en la base de datos
     *
     * @deprecated
     * @param categoria Datos de la categoria a ser modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Categoria categoria) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_CATEGORIA(?,?,?,?)}";
        int indexId = 1;
        int indexNombre = 2;
        int indexActivo = 3;
        int indexIdCentro = 4;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, categoria.getId());
        statement.setString(indexNombre, categoria.getNombre());
        statement.setBoolean(indexActivo, categoria.isActivo());
        statement.setString(indexIdCentro, categoria.getCentro().getId());

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
     * Metodo para borrar una categoria en la base de datos
     *
     * @deprecated
     * @param categoria Datos de la categoria
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Categoria categoria) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_CATEGORIA(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, categoria.getId());

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
     * Metodo para ver los datos de una categoria
     *
     * @param categoria Objeto de tipo Categoria que en el atributo id tiene el
     * valor del id a ser consultado
     * @return los valores almacenados en la tabla categoria de la base de datos
     * @throws SQLException
     */
    public Categoria select(Categoria categoria) throws SQLException {

        String query = "{CALL VER_CATEGORIA(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, categoria.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            categoria.setId(rs.getInt(COL_ID));
            categoria.setNombre(rs.getString(COL_NOMBRE));
            categoria.setActivo(rs.getBoolean(COL_ACTIVO));
            Centro centro = new Centro();
            centro.setId(rs.getString(COL_ID_CENTRO));
            categoria.setCentro(centro);
        }
        if (!encontrado) {
            categoria = null;
        }

        return categoria;
    }
    
    public ArrayList<Categoria> selectAll() throws SQLException {
        ArrayList<Categoria> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_CATEGORIA()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt(COL_ID));
            categoria.setNombre(rs.getString(COL_NOMBRE));
            categoria.setActivo(rs.getBoolean(COL_ACTIVO));
            Centro centro = new Centro();
            centro.setId(rs.getString(COL_ID_CENTRO));
            categoria.setCentro(centro);
            
            result.add(categoria);
        }

        return result;
    }
}
