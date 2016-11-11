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
    private static final String PROCEDURE_DELETE_PRODUCTO = "{CALL ElIMINAR_PRODUCTO(?,?,?,?,?)}";

    /**
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
     * @param Id_producto Id del Prodcuto
     * @return Retorna Null si el Prodcuto no se encuetra en la base de datos, de lo
     * contrario retorna los datos del producto.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Producto_Bean InsertarProdcuto(Long Id_producto) throws SQLException {
        Producto_Bean producto = new Producto_Bean();//el objeto en donde se guardan los resultados de la consulta
        producto.setId_producto(Id_producto);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_PRODUCTO(?,?,?,?,?))}");
        statement.setLong(PROCEDURE_INSERT_PRODUCTO, Id_producto);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_PRODUCTO);
        statement.setString(3, COL_DESCRIPCION_PRODUCTO);
        statement.setString(4, COL_PALABRAS_CLAVE_PRODUCTO);
        statement.setString(5, COL_ID_TIPO_APRENDIZAJE_PRODUCTO);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

       
        return producto;
    }

    /**
     * @param Id_prodcuto Id del Producto
     * @return Retorna Null si el Producto no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Producto.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Producto_Bean UpdateProducto(Long Id_producto) throws SQLException {
        Producto_Bean producto = new Producto_Bean();//el objeto en donde se guardan los resultados de la consulta
        producto.setId_producto(Id_producto);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_PRODUCTO(?,?,?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_PRODUCTO, Id_producto);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_PRODUCTO);
        statement.setString(3, COL_DESCRIPCION_PRODUCTO);
        statement.setString(4, COL_PALABRAS_CLAVE_PRODUCTO);
        statement.setString(5, COL_ID_TIPO_APRENDIZAJE_PRODUCTO);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return producto;
    }

    /**
     * @param Id_ Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Producto_Bean DeleteProducto(long Id_producto) throws SQLException {
        Producto_Bean producto = new Producto_Bean();//el objeto en donde se guardan los resultados de la consulta
        producto.setId_producto(Id_producto);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_PRODUCTO(?,?,?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_PRODUCTO, Id_producto);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_PRODUCTO);
        statement.setString(3, COL_DESCRIPCION_PRODUCTO);
        statement.setString(4, COL_PALABRAS_CLAVE_PRODUCTO);
        statement.setString(5, COL_ID_TIPO_APRENDIZAJE_PRODUCTO);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return producto;
    }

}
