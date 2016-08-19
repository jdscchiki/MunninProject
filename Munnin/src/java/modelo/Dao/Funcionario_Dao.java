package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import modelo.Beans.Funcionario_Bean;
import util.ClassConexion;

public class Funcionario_Dao extends ClassConexion {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_funcionario;
    public String documento_funcionario;
    public String correo_funcionario;
    public String contrasena_funcionario;
    public String nombre_funcionario;
    public String apellido_funcionario;
    public String cargo_funcionario;
    public String telefono_funcionario;
    public String id_centro_funcionario;

    public Funcionario_Dao(Funcionario_Bean Funcionario) {
        super();
        conn = this.obtenerConexion();
        id_funcionario = Funcionario.getId_funcionario();
        documento_funcionario = Funcionario.getDocumento_funcionario();
        correo_funcionario = Funcionario.getCorreo_funcionario();
        contrasena_funcionario = Funcionario.getContrasena_funcionario();
        nombre_funcionario = Funcionario.getNombre_funcionario();
        apellido_funcionario = Funcionario.getApellido_funcionario();
        cargo_funcionario = Funcionario.getCargo_funcionario();
        telefono_funcionario = Funcionario.getTelefono_funcionario();
        id_centro_funcionario = Funcionario.getId_centro_funcionario();

    }

    public boolean insertar_funcionario() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_funcionario (?,?,?)}");
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_funcionario() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_funcionario (?,?,?)}");
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_funcionario() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_funcionario (?)}");
        } catch (SQLException e) {
        }
        return listo;
    }

    public Funcionario_Bean ver_funcionario() {
        Funcionario_Bean ab = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_funcionario(?)}");
        } catch (SQLException e) {
        }
        return ab;
    }
}

