package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Programa_Producto_Bean;
import util.ClassConexion;

public class Programa_Producto_Dao extends ClassConexion {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_producto_prog_prod;
    public long id_programa_prog_prod;

    public Programa_Producto_Dao(Programa_Producto_Bean Programa_Prod) {
        super();
        conn = this.obtenerConexion();
        id_producto_prog_prod = Programa_Prod.getId_producto_prog_prod();
        id_programa_prog_prod = Programa_Prod.getId_programa_prog_prod();

    }
    
public boolean insertar_programa_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_programa_producto (?,?,?)}");
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_programa_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_programa_producto (?,?,?)}");
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_programa_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call elimina_programa_producto (?)}");
            } catch (SQLException e) {
        }
        return listo;
    }

    public Programa_Producto_Bean ver_programa_producto() {
        Programa_Producto_Bean ab = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_programa_producto (?)}");
        } catch (SQLException e) {
        }
        return ab;
    }
}
