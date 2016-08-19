package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
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
            CallableStatement cst = conn.prepareCall("{call insertar_producto (?,?,?)}");
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_producto (?,?,?)}");
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_producto (?)}");
        } catch (SQLException e) {
        }
        return listo;
    }

    public Producto_Bean ver_producto() {
        Producto_Bean ab = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_producto(?)}");
        } catch (SQLException e) {
        }
        return ab;
    }
}
