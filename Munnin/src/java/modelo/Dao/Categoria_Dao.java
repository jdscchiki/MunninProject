
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Categoria_Bean;


public class Categoria_Dao {
    
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
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_categoria = Categoria.getId_categoria();
            nombre_categoria = Categoria.getNombre_categoria();
            id_centro_categoria = Categoria.getId_centro_categoria();

        } catch (SQLException e) {
        }
    
}
}
