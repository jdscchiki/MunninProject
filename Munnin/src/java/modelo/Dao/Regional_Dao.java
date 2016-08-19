package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Regional_Bean;
import util.ClassConexion;

public class Regional_Dao extends ClassConexion  {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_regional;
    public String nombre_regional;

    public Regional_Dao(Regional_Bean Regional) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_regional = Regional.getId_regional();
            nombre_regional = Regional.getNombre_regional();

        } catch (SQLException e) {
        }
    }

}
