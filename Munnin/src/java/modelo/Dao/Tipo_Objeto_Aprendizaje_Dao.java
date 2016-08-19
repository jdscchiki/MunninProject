
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Tipo_Objeto_Aprendizaje_Bean;


public class Tipo_Objeto_Aprendizaje_Dao {
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_tipo_objeto_aprendizaje;
    public String nombre_tipo_objeto_aprendizaje;


    public Tipo_Objeto_Aprendizaje_Dao(Tipo_Objeto_Aprendizaje_Bean Tipo_Objeto_Apre) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_tipo_objeto_aprendizaje = Tipo_Objeto_Apre.getId_tipo_objeto_aprendizaje();
            nombre_tipo_objeto_aprendizaje = Tipo_Objeto_Apre.getNombre_tipo_objeto_aprendizaje();

        } catch (SQLException e) {
        }
    }

    
}
