package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.ProductoBean;
import util.ClassConexion;
import util.ConexionBD;

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * Producto.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

public class ProductoDao extends ConexionBD {

    private static final String COL_ID_PRODUCTO = "id_producto";
    private static final String COL_NOMBRE_PRODUCTO = "nombre_producto";
    private static final String COL_DESCRIPCION_PRODUCTO = "descripcion_producto";
    private static final String COL_PALABRAS_CLAVE_PRODUCTO = "palabras_clave_producto";
    private static final String COL_ID_TIPO_APRENDIZAJE_PRODUCTO = "id_tipo_aprendizaje_producto";

    /**
     * 
     * 
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public ProductoDao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param producto
     * @return Retorna Null si el Prodcuto no se encuetra en la base de datos, de lo
     * contrario retorna los datos del producto.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarProdcuto(ProductoBean producto) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        //datos en la consulta en base de datos
        String query ="{CALL INSERTAR_PRODUCTO(?,?,?,?,?)}";
        int indexIdProducto =1;
        int indexNombreProducto = 2;
        int indexDescripcionProducto =3;
        int indexPalabrasClaveProducto=4;
        int indexIdTipoObjetoAprendizajProducto =5;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdProducto, producto.getId_producto());
        statement.setString(indexNombreProducto, producto.getNombre_producto());
        statement.setString(indexDescripcionProducto, producto.getDescripcion_producto());
        statement.setString(indexPalabrasClaveProducto, producto.getPalabras_clave_producto());
        statement.setLong(indexIdTipoObjetoAprendizajProducto, producto.getId_tipo_objeto_aprendizaje_producto());        
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * @param producto
     * @return Retorna Null si el Producto no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Producto.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateProducto(ProductoBean producto) throws SQLException {
         boolean resultado;// esta es la futura respuesta
        
        //datos en la consulta en base de datos
        String query ="{CALL EDITAR_PRODUCTO(?,?,?,?,?)}";
        int indexIdProducto =1;
        int indexNombreProducto = 2;
        int indexDescripcionProducto =3;
        int indexPalabrasClaveProducto=4;
        int indexIdTipoObjetoAprendizajProducto =5;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdProducto, producto.getId_producto());
        statement.setString(indexNombreProducto, producto.getNombre_producto());
        statement.setString(indexDescripcionProducto, producto.getDescripcion_producto());
        statement.setString(indexPalabrasClaveProducto, producto.getPalabras_clave_producto());
        statement.setLong(indexIdTipoObjetoAprendizajProducto, producto.getId_tipo_objeto_aprendizaje_producto());        
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * @param producto
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteProducto(ProductoBean producto) throws SQLException {
         boolean resultado;// esta es la futura respuesta
        
        //datos en la consulta en base de datos
        String query ="{CALL ELIMINAR_PRODUCTO(?)}";
        int indexIdProducto =1;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdProducto, producto.getId_producto());;        
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

}
