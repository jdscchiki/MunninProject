
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Programa_Producto_Bean;


public class Programa_Producto_Dao {
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_producto_prog_prod;
    public long id_programa_prog_prod;


    public Programa_Producto_Dao(Programa_Producto_Bean Programa_Prod) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_producto_prog_prod = Programa_Prod.getId_producto_prog_prod();
            id_programa_prog_prod = Programa_Prod.getId_programa_prog_prod();
           

        } catch (SQLException e) {
        }
    }
}
