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
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_funcionario_autor = Autor.getId_funcionario_autor();
            id_version_autor = Autor.getId_funcionario_autor();

        } catch (SQLException e) {
        }
    }
}