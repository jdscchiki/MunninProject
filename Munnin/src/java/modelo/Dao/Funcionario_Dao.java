package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            CallableStatement cst = conn.prepareCall("{call insertar_funcionario (?,?,?,?,?,?,?)}");
            cst.setLong(1, id_funcionario);
            cst.setString(2, documento_funcionario);
            cst.setString(3, contrasena_funcionario);
            cst.setString(4, contrasena_funcionario);
            cst.setString(5, nombre_funcionario);
            cst.setString(6, apellido_funcionario);
            cst.setString(7, cargo_funcionario);
            cst.setString(6, telefono_funcionario);
            cst.setString(7, id_centro_funcionario);
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_funcionario() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_funcionario (?,?,?,?,?,?,?)}");

            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_funcionario);
            cst.setString(2, documento_funcionario);
            cst.setString(3, contrasena_funcionario);
            cst.setString(4, contrasena_funcionario);
            cst.setString(5, nombre_funcionario);
            cst.setString(6, apellido_funcionario);
            cst.setString(7, cargo_funcionario);
            cst.setString(6, telefono_funcionario);
            cst.setString(7, id_centro_funcionario);
            // Ejecuta el procedimiento almacenado
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_funcionario() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_funcionario (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_funcionario);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Funcionario_Bean ver_funcionario() {
        Funcionario_Bean evb = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_funcionario (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_funcionario);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            cst.registerOutParameter(4, java.sql.Types.VARCHAR);
            cst.registerOutParameter(5, java.sql.Types.VARCHAR);
            cst.registerOutParameter(6, java.sql.Types.VARCHAR);
            cst.registerOutParameter(7, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            evb = new Funcionario_Bean(id_funcionario, cst.getString(2), cst.getString(3), cst.getString(4), cst.getString(5), cst.getString(6), cst.getString(7));

        } catch (SQLException e) {
        }
        return evb;
    }
}
