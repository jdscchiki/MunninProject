package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Tipo_Archivo_Bean;
import util.ClassConexion;

public class Tipo_Archivo_Dao extends ClassConexion  {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_tipo_archivo;
    public String extencion_tipo_archivo;

    public Tipo_Archivo_Dao(Tipo_Archivo_Bean Tipo_Archivo) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_tipo_archivo = Tipo_Archivo.getId_tipo_archivo();
            extencion_tipo_archivo = Tipo_Archivo.getExtencion_tipo_archivo();

        } catch (SQLException e) {
        }
    }

}
