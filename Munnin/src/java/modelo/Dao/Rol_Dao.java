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
            cst.setLong(1, id_rol);
            cst.setString(2, nombre_rol);
            cst.setString(3, descripcion_rol);
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_rol() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_rol (?,?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_rol);
            cst.setString(2, nombre_rol);
            cst.setString(3, descripcion_rol);;
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_rol() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_rol (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_rol);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Rol_Bean ver_rol() {
        Rol_Bean rol = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_rol (?)}");
             // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_rol);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            rol = new Rol_Bean(id_rol, cst.getString(2), cst.getString(3));
        } catch (SQLException e) {
        }
        return rol;
    }
}
