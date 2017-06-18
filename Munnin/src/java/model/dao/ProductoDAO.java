/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.bean.Categoria;
import model.bean.Producto;
import model.bean.Programa;
import model.bean.TipoObjetoAprendizaje;
import util.database.connectionDB;

/**
 *
 * @author Juan David Segura
 */
public class ProductoDAO extends connectionDB {

    private static final String COL_ID = "id_producto";
    private static final String COL_NOMBRE = "nombre_producto";
    private static final String COL_DESCRIPCION = "descripcion_producto";
    private static final String COL_PALABRAS_CLAVE = "palabras_clave_producto";
    private static final String COL_ID_TIPO_APRENDIZAJE = "id_tipo_objeto_aprendizaje_producto";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor connectionDB
     * @throws SQLException Error en el constructor connectionDB
     */
    public ProductoDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un producto en la base de datos
     *
     * @deprecated
     * @param producto Datos del producto insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean insert(Producto producto) throws SQLException {
        boolean result;

        String query = "{CALL INSERTAR_PRODUCTO(?,?,?,?)}";
        int indexNombre = 1;
        int indexDescripcion = 2;
        int indexPalabrasClave = 3;
        int indexIdTipoObjetoAprendizaj = 4;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, producto.getNombre());
        statement.setString(indexDescripcion, producto.getDescripcion());
        statement.setString(indexPalabrasClave, producto.getPalabrasClave());
        statement.setInt(indexIdTipoObjetoAprendizaj, producto.getTipoObjetoAprendizaje().getId());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            result = true;
        } else {
            this.getConexion().rollback();
            result = false;
        }
        return result;
    }

    /**
     * Metodo para actualizar un producto en la base de datos
     *
     * @deprecated
     * @param producto Datos del producto a ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Producto producto) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_PRODUCTO(?,?,?,?,?)}";
        int indexId = 1;
        int indexNombre = 2;
        int indexDescripcion = 3;
        int indexPalabrasClave = 4;
        int indexIdTipoObjetoAprendizaj = 5;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, producto.getId());
        statement.setString(indexNombre, producto.getNombre());
        statement.setString(indexDescripcion, producto.getDescripcion());
        statement.setString(indexPalabrasClave, producto.getPalabrasClave());
        statement.setInt(indexIdTipoObjetoAprendizaj, producto.getTipoObjetoAprendizaje().getId());
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
     * Metodo para borrar un producto en la base de datos
     *
     * @deprecated
     * @param producto Datos del producto
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Producto producto) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_PRODUCTO(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, producto.getId());

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
     * Metodo para ver los datos de un producto
     *
     * @param producto Objeto de tipo Producto que en el atributo id tiene el
     * valor del id a ser consultado
     * @return los valores almacenados en la tabla producto de la base de datos
     * @throws SQLException
     */
    public Producto select(Producto producto) throws SQLException {

        String query = "{CALL VER_PRODUCTO(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, producto.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            producto.setId(rs.getInt(COL_ID));
            producto.setNombre(rs.getString(COL_NOMBRE));
            producto.setDescripcion(rs.getString(COL_DESCRIPCION));
            producto.setPalabrasClave(rs.getString(COL_PALABRAS_CLAVE));
            TipoObjetoAprendizaje tipoObjetoAprendizaje = new TipoObjetoAprendizaje();
            tipoObjetoAprendizaje.setId(rs.getInt(COL_ID_TIPO_APRENDIZAJE));
            producto.setTipoObjetoAprendizaje(tipoObjetoAprendizaje);
        }
        if (!encontrado) {
            producto = null;
        }

        return producto;
    }

    public ArrayList<Producto> selectAll() throws SQLException {
        ArrayList<Producto> result = new ArrayList<>();

        String query = "{CALL VER_TODOS_PRODUCTO()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Producto producto = new Producto();
            producto.setId(rs.getInt(COL_ID));
            producto.setNombre(rs.getString(COL_NOMBRE));
            producto.setDescripcion(rs.getString(COL_DESCRIPCION));
            producto.setPalabrasClave(rs.getString(COL_PALABRAS_CLAVE));
            TipoObjetoAprendizaje tipoObjetoAprendizaje = new TipoObjetoAprendizaje();
            tipoObjetoAprendizaje.setId(rs.getInt(COL_ID_TIPO_APRENDIZAJE));
            producto.setTipoObjetoAprendizaje(tipoObjetoAprendizaje);
            
            result.add(producto);
        }

        return result;
    }

    public int create(Producto producto) throws SQLException {
        int result = 0;

        String query = "INSERT INTO producto ("
                + COL_NOMBRE + ","
                + COL_DESCRIPCION + ","
                + COL_PALABRAS_CLAVE + ","
                + COL_ID_TIPO_APRENDIZAJE + ") "
                + "VALUES(?,?,?,?)";

        PreparedStatement statement = this.getConexion().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setString(1, producto.getNombre());
        statement.setString(2, producto.getDescripcion());
        statement.setString(3, producto.getPalabrasClave());
        statement.setInt(4, producto.getTipoObjetoAprendizaje().getId());

        if (statement.executeUpdate() != 1) {
            this.getConexion().rollback();
        } else {
            this.getConexion().commit();
        }

        ResultSet rs = statement.getGeneratedKeys();
        while (rs.next()) {
            result = rs.getInt(1);
        }

        return result;
    }

    public int insertCategories(Producto producto) throws SQLException {
        int result = 0;

        String query = "{CALL INSERTAR_CATEGORIA_PRODUCTO(?,?)}";
        int indexIdCategoria = 1;
        int indexId = 2;

        for (Categoria categoria : producto.getCategorias()) {
            CallableStatement statement = this.getConexion().prepareCall(query);
            statement.setInt(indexIdCategoria, categoria.getId());
            statement.setInt(indexId, producto.getId());
            if (statement.executeUpdate() == 1) {
                this.getConexion().commit();
                result++;
            } else {
                this.getConexion().rollback();
            }
        }

        return result;
    }
    
    public int insertProgrammes(Producto producto) throws SQLException {
        int result = 0;

        String query = "{CALL INSERTAR_PROGRAMA_PRODUCTO(?,?)}";
        int indexId = 1;
        int indexIdPrograma = 2;

        for (Programa programa : producto.getProgramas()) {
            CallableStatement statement = this.getConexion().prepareCall(query);
            statement.setInt(indexId, producto.getId());
            statement.setInt(indexIdPrograma, programa.getId());
            if (statement.executeUpdate() == 1) {
                this.getConexion().commit();
                result++;
            } else {
                this.getConexion().rollback();
            }
        }

        return result;
    }
}
