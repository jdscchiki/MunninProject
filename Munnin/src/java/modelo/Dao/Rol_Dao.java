package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Rol_Bean;
import util.ClassConexion;

public class Rol_Dao extends ClassConexion {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_rol;
    public String nombre_rol;
    public String descripcion_rol;

    public Rol_Dao(Rol_Bean Rol) {
        super();
        conn = this.obtenerConexion();
        id_rol = Rol.getId_rol();
        nombre_rol = Rol.getNombre_rol();
        descripcion_rol = Rol.getDescripcion_rol();

    }

    public boolean insertar_rol() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_rol(?,?,?)}");
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_rol() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_rol (?,?,?)}");
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_rol() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_rol (?)}");
        } catch (SQLException e) {
        }
        return listo;
    }

    public Rol_Bean ver_rol() {
        Rol_Bean ab = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_rol (?)}");
        } catch (SQLException e) {
        }
        return ab;
    }
}
