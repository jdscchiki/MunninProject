package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import util.ClassConexion;

import modelo.Beans.Comentario_Bean;

public class Comentario_Dao extends ClassConexion{

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
            conn = this.obtenerConexion();

            id_comentario = Comentario.getId_comentario();
            valoracion_comentario = Comentario.getValoracion_comentario();
            puntuacion_comentario = Comentario.getPuntuacion_comentario();
            fecha_comentario = Comentario.getFecha_comentario();
            id_producto_comentario = Comentario.getId_producto_comentario();
            id_funcionario_comentario = Comentario.getId_funcionario_comentario();
    }

    public boolean insertar_comentario() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_comentario (?,?,?,?,?,?)}");
            cst.setLong(1, id_comentario);
            cst.setString(2, valoracion_comentario);
            cst.setInt(3, puntuacion_comentario);
            cst.setDate(4, (java.sql.Date) fecha_comentario);
            cst.setLong(5, id_producto_comentario);
            cst.setLong(6, id_funcionario_comentario);            

            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_comentario() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_comentario (?,?,?,?,?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_comentario);
            cst.setString(2, valoracion_comentario);
            cst.setInt(3, puntuacion_comentario);
            cst.setDate(4, (java.sql.Date) fecha_comentario);
            cst.setLong(5, id_producto_comentario);
            cst.setLong(6, id_funcionario_comentario); 
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_comentario() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_comentario (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_comentario);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Comentario_Bean ver_comentario() {
        Comentario_Bean cob = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_comentario (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_comentario);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.INTEGER);
            cst.registerOutParameter(4, java.sql.Types.DATE);
            cst.registerOutParameter(5, java.sql.Types.INTEGER);
            cst.registerOutParameter(6, java.sql.Types.INTEGER);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            cob = new Comentario_Bean(id_comentario, cst.getString(2), cst.getInt(3), cst.getDate(4), cst.getLong(5),cst.getLong(6));
        } catch (SQLException e) {
        }
        return cob;
    }
}
