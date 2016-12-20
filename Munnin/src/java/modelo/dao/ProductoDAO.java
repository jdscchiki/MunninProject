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
import modelo.bean.Producto;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class ProductoDAO extends ConexionBD {

    private static final String COL_ID = "id_producto";
    private static final String COL_NOMBRE = "nombre_producto";
    private static final String COL_DESCRIPCION = "descripcion_producto";
    private static final String COL_PALABRAS_CLAVE = "palabras_clave_producto";
    private static final String COL_ID_TIPO_APRENDIZAJE = "id_tipo_aprendizaje_producto";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
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
    public boolean Insert(Producto producto) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_PRODUCTO(?,?,?,?,?)}";
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
        statement.setInt(indexIdTipoObjetoAprendizaj, producto.getIdTipoObjetoAprendizaje());
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
        statement.setInt(indexIdTipoObjetoAprendizaj, producto.getIdTipoObjetoAprendizaje());
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
            producto.setIdTipoObjetoAprendizaje(rs.getInt(COL_ID_TIPO_APRENDIZAJE));
        }
        if (!encontrado) {
            producto = null;
        }

        return producto;
    }
}
