
package modelo.Dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import modelo.Beans.Eval_Version_General_Bean;
import util.ClassConexion;


public class Eval_Version_General_Dao extends ClassConexion{
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    
    public long id_eval_version_general;
    public long id_version_eval_version_general;
    public long id_lista_eval_version_general;
    public int calificacion_eval_version_general;
    public String observaciones_eval_version_general;
    public Date fecha_eval_version_general;
    public long id_evaluador_eval_version_general;

    
    public Eval_Version_General_Dao(Eval_Version_General_Bean Evalu_Ver_General) {
        super();
            conn = this.obtenerConexion();

            id_eval_version_general = Evalu_Ver_General.getId_eval_version_general();
            id_version_eval_version_general = Evalu_Ver_General.getId_version_eval_version_general();
            id_lista_eval_version_general = Evalu_Ver_General.getId_lista_eval_version_general();
            calificacion_eval_version_general = Evalu_Ver_General.getCalificacion_eval_version_general();
            observaciones_eval_version_general = Evalu_Ver_General.getObservaciones_eval_version_general();
            fecha_eval_version_general = Evalu_Ver_General.getFecha_eval_version_general();
            id_evaluador_eval_version_general = Evalu_Ver_General.getId_evaluador_eval_version_general();
    
    }
    
    public boolean insertar_eval_version_general() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_eval_version_general (?,?,?,?,?,?,?)}");
            cst.setLong(1, id_eval_version_general);
            cst.setLong(2, id_version_eval_version_general);
            cst.setLong(3, id_lista_eval_version_general);
            cst.setInt(4, calificacion_eval_version_general);
            cst.setString(5, observaciones_eval_version_general);
            cst.setDate(6, (java.sql.Date) fecha_eval_version_general);
            cst.setLong(6, id_evaluador_eval_version_general);

            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_eval_version_general() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_eval_version_general (?,?,?,?,?,?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_eval_version_general);
            cst.setLong(2, id_version_eval_version_general);
            cst.setLong(3, id_lista_eval_version_general);
            cst.setInt(4, calificacion_eval_version_general);
            cst.setString(5, observaciones_eval_version_general);
            cst.setDate(6, (java.sql.Date) fecha_eval_version_general);
            cst.setLong(6, id_evaluador_eval_version_general); 
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_eval_version_general() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_eval_version_general (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_eval_version_general);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Eval_Version_General_Bean ver_eval_version_general() {
        Eval_Version_General_Bean evb = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_eval_version_general (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_eval_version_general);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.DOUBLE);
            cst.registerOutParameter(3, java.sql.Types.DOUBLE);
            cst.registerOutParameter(4, java.sql.Types.INTEGER);
            cst.registerOutParameter(5, java.sql.Types.VARCHAR);
            cst.registerOutParameter(6, java.sql.Types.DATE);
            cst.registerOutParameter(7, java.sql.Types.DOUBLE);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            evb = new Eval_Version_General_Bean(id_eval_version_general, cst.getLong(2), cst.getLong(3), cst.getInt(4), cst.getString(5),cst.getDate(6), cst.getLong(7));
        } catch (SQLException e) {
        }
        return evb;
    }
}
