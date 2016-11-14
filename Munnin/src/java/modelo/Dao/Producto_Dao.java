package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Producto_Bean;
import util.ClassConexion;
import util.ConexionBD;

public class Producto_Dao extends ConexionBD {

    private static final String COL_ID_PRODUCTO = "id_producto";
    private static final String COL_NOMBRE_PRODUCTO = "nombre_producto";
    private static final String COL_DESCRIPCION_PRODUCTO = "descripcion_producto";
    private static final String COL_PALABRAS_CLAVE_PRODUCTO = "palabras_clave_producto";
    private static final String COL_ID_TIPO_APRENDIZAJE_PRODUCTO = "id_tipo_aprendizaje_producto";

    private static final String PROCEDURE_INSERT_PRODUCTO = "{CALL INSERTAR_PRODUCTO(?,?,?,?,?)}";
    private static final String PROCEDURE_UPDATE_PRODUCTO = "{CALL EDITAR_PRODUCTO(?,?,?,?,?)}";
    private static final String PROCEDURE_DELETE_PRODUCTO = "{CALL ElIMINAR_PRODUCTO(?)}";
    
    private static final int PROCEDURE_INSERTAR_ID_PRODUCTO_AREA_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_NOMBRE_PRODUCTO_INDEX = 2;
    private static final int PROCEDURE_INSERTAR_DESCRIPCION_PRODUCTO_INDEX = 3;
    private static final int PROCEDURE_INSERTAR_PALABRAS_CLAVE_PRODUCTO_INDEX = 4;
    private static final int PROCEDURE_INSERTAR_ID_TIPO_APRENDIZ_PRODUCTO_INDEX = 5;
    
    private static final int PROCEDURE_UPDATE_ID_PRODUCTO_AREA_INDEX = 1;
    private static final int PROCEDURE_UPDATE_NOMBRE_PRODUCTO_INDEX = 2;
    private static final int PROCEDURE_UPDATE_DESCRIPCION_PRODUCTO_INDEX = 3;
    private static final int PROCEDURE_UPDATE_PALABRAS_CLAVE_PRODUCTO_INDEX = 4;
    private static final int PROCEDURE_UPDATE_ID_TIPO_APRENDIZ_PRODUCTO_INDEX = 5;
    
    private static final int PROCEDURE_DELETE_ID_PRODUCTO_AREA_INDEX = 1;
    /**
     * 
     * 
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Producto_Dao() throws NamingException, SQLException {
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
    public boolean InsertarProdcuto(Producto_Bean producto) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_PRODUCTO);
        statement.setLong(PROCEDURE_INSERTAR_ID_PRODUCTO_AREA_INDEX, producto.getId_producto());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_INSERTAR_NOMBRE_PRODUCTO_INDEX, producto.getNombre_producto());
        statement.setString(PROCEDURE_INSERTAR_DESCRIPCION_PRODUCTO_INDEX, producto.getDescripcion_producto());
        statement.setString(PROCEDURE_INSERTAR_PALABRAS_CLAVE_PRODUCTO_INDEX, producto.getPalabras_clave_producto());
        statement.setLong(PROCEDURE_INSERTAR_ID_TIPO_APRENDIZ_PRODUCTO_INDEX, producto.getId_tipo_objeto_aprendizaje_producto());        
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
    public boolean UpdateProducto(Producto_Bean producto) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_PRODUCTO);
        statement.setLong(PROCEDURE_UPDATE_ID_PRODUCTO_AREA_INDEX, producto.getId_producto());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_UPDATE_NOMBRE_PRODUCTO_INDEX, producto.getNombre_producto());
        statement.setString(PROCEDURE_UPDATE_DESCRIPCION_PRODUCTO_INDEX, producto.getDescripcion_producto());
        statement.setString(PROCEDURE_UPDATE_PALABRAS_CLAVE_PRODUCTO_INDEX, producto.getPalabras_clave_producto());
        statement.setLong(PROCEDURE_UPDATE_ID_TIPO_APRENDIZ_PRODUCTO_INDEX, producto.getId_tipo_objeto_aprendizaje_producto());
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
    public boolean DeleteProducto(Producto_Bean producto) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_PRODUCTO(?)}");
        statement.setLong(PROCEDURE_DELETE_ID_PRODUCTO_AREA_INDEX, producto.getId_producto());//asigna los valores necesarios para ejecutar el QUERY        
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
