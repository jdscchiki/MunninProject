
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import modelo.Beans.Comentario_Bean;
import util.ClassConexion;



public class Comentario_Dao extends ClassConexion  {
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    private long id_comentario;
    private String valoracion_comentario;
    private int puntuacion_comentario;
    private Date fecha_comentario;
    private long id_producto_comentario;
    private long id_funcionario_comentario;

    
    public Comentario_Dao(Comentario_Bean Comentario) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_comentario = Comentario.getId_comentario();
            valoracion_comentario = Comentario.getValoracion_comentario();
            puntuacion_comentario = Comentario.getPuntuacion_comentario();
            fecha_comentario = Comentario.getFecha_comentario();
            id_producto_comentario = Comentario.getId_producto_comentario();
            id_funcionario_comentario = Comentario.getId_funcionario_comentario();

        } catch (SQLException e) {
        }
}
    
}
