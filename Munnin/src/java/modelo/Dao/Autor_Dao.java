package modelo.Dao;

import java.sql.*;
import java.sql.Statement;
import modelo.Beans.Autor_Bean;
import util.ClassConexion;

public class Autor_Dao extends ClassConexion {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_funcionario_autor;
    public long id_version_autor;

    public Autor_Dao(Autor_Bean Autor) {
        super();
        conn = this.obtenerConexion();
        id_funcionario_autor = Autor.getId_funcionario_autor();
        id_version_autor = Autor.getId_funcionario_autor();

    }

    public boolean insertar_autor() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_autor (?,?,?)}");
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_autor() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_autor (?,?,?)}");
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_autor() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_autor (?)}");
            } catch (SQLException e) {
        }
        return listo;
    }

    public Autor_Bean ver_autor() {
        Autor_Bean ab = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_autor (?)}");
        } catch (SQLException e) {
        }
        return ab;
    }
}


