package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Producto_Bean;
import util.ClassConexion;

public class Producto_Dao extends ClassConexion {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_producto;
    public String nombre_producto;
    public String descripcion_producto;
    public String palabras_clave_producto;
    public long id_tipo_objeto_aprendizaje_producto;

    public Producto_Dao(Producto_Bean Producto) {
        super();
        conn = this.obtenerConexion();
        id_producto = Producto.getId_producto();
        nombre_producto = Producto.getNombre_producto();
        descripcion_producto = Producto.getDescripcion_producto();
        palabras_clave_producto = Producto.getPalabras_clave_producto();
        id_tipo_objeto_aprendizaje_producto = Producto.getId_tipo_objeto_aprendizaje_producto();

    }

    public boolean insertar_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_producto (?,?,?,?,?)}");
            cst.setLong(1, id_producto);
            cst.setString(2, nombre_producto);
            cst.setString(3, descripcion_producto);
            cst.setString(4, palabras_clave_producto);
            cst.setLong(5, id_tipo_objeto_aprendizaje_producto);
            
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_producto (?,?,?,?,?)}");
             // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_producto);
            cst.setString(2, nombre_producto);
            cst.setString(3, descripcion_producto);
            cst.setString(4, palabras_clave_producto);
            cst.setLong(5, id_tipo_objeto_aprendizaje_producto);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_producto (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_producto);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Producto_Bean ver_producto() {
        Producto_Bean pro = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_producto(?)}");
             // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_producto);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            cst.registerOutParameter(4, java.sql.Types.VARCHAR);
            cst.registerOutParameter(5, java.sql.Types.VARCHAR);
            
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            pro = new Producto_Bean(id_producto, cst.getString(2), cst.getString(3), cst.getString(4), cst.getLong(5));
        } catch (SQLException e) {
        }
        return pro;
    }
}

