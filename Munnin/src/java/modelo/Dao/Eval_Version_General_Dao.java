
package modelo.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import modelo.Beans.Eval_Version_General_Bean;
import util.ClassConexion;


public class Eval_Version_General_Dao extends ClassConexion {
    
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
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_eval_version_general = Evalu_Ver_General.getId_eval_version_general();
            id_version_eval_version_general = Evalu_Ver_General.getId_version_eval_version_general();
            id_lista_eval_version_general = Evalu_Ver_General.getId_lista_eval_version_general();
            calificacion_eval_version_general = Evalu_Ver_General.getCalificacion_eval_version_general();
            observaciones_eval_version_general = Evalu_Ver_General.getObservaciones_eval_version_general();
            fecha_eval_version_general = Evalu_Ver_General.getFecha_eval_version_general();
            id_evaluador_eval_version_general = Evalu_Ver_General.getId_evaluador_eval_version_general();
            

        } catch (SQLException e) {
        }
    
    } 
}
