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
            CallableStatement cst = conn.prepareCall("{call insertar_autor (?,?)}");
            cst.setLong(1, id_funcionario_autor);
            cst.setLong(2, id_version_autor);
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_autor() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_autor (?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_funcionario_autor);
            cst.setLong(2, id_version_autor);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_autor() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_autor (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_funcionario_autor);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Autor_Bean ver_autor() {
        Autor_Bean au = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_auro(?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_funcionario_autor);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();

            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            au = new Autor_Bean(id_funcionario_autor, cst.getLong(2));
        } catch (SQLException e) {
        }
        return au;
    }
}
