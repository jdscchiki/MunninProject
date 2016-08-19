
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import modelo.Beans.Lista_Chequeo_Bean;
import util.ClassConexion;


public class Lista_Chequeo_Dao extends ClassConexion  {
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_lista;
    public String nombre_lista;
    public String descripcion_lista;
    public Date fecha_lista;
    public String tipo_lista;
    public long id_autor_lista;
    
    public Lista_Chequeo_Dao(Lista_Chequeo_Bean Lista_Chequeo) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_lista = Lista_Chequeo.getId_lista();
            nombre_lista = Lista_Chequeo.getNombre_lista();
            descripcion_lista = Lista_Chequeo.getDescripcion_lista();
            fecha_lista = Lista_Chequeo.getFecha_lista();
            tipo_lista = Lista_Chequeo.getTipo_lista();
            id_autor_lista = Lista_Chequeo.getId_autor_lista();
            
            

        } catch (SQLException e) {
        }
    
    } 
    
}
