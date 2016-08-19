package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import modelo.Beans.Categoria_Bean;
import util.ClassConexion;

public class Categoria_Dao extends ClassConexion {


    
   public Connection conn = null;
   public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_categoria;
    public String nombre_categoria;
    public String id_centro_categoria;

    public Categoria_Dao(Categoria_Bean Categoria) {
        super();
        conn = this.obtenerConexion();

        id_categoria = Categoria.getId_categoria();
        nombre_categoria = Categoria.getNombre_categoria();
        id_centro_categoria = Categoria.getId_centro_categoria();

    }

    public boolean insertar_categoria() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_categoria (?,?,?)}");
            cst.setLong(1, id_categoria);
            cst.setString(2, nombre_categoria);
            cst.setString(3, id_centro_categoria);

            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_categoria() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_categoria (?,?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_categoria);
            cst.setString(2, nombre_categoria);
            cst.setString(3, id_centro_categoria);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_categoria() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_categoria (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_categoria);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Categoria_Bean ver_area() {
        Categoria_Bean cb = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_categoria (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_categoria);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            cb = new Categoria_Bean(id_categoria, cst.getString(2), cst.getString(3));
        } catch (SQLException e) {
        }
        return cb;
    }
}
