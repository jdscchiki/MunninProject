package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Programa_Bean;

public class Programa_Dao {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_programa;
    public String nombre_programa;
    public long id_area_programa;

    public Programa_Dao(Programa_Bean Programa) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_programa = Programa.getId_programa();
            nombre_programa = Programa.getNombre_programa();
            id_area_programa = Programa.getId_area_programa();

        } catch (SQLException e) {
        }
    }

}
