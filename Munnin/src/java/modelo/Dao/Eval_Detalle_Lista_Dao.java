
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Eval_Detalle_Lista_Bean;


public class Eval_Detalle_Lista_Dao {
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_eval_detalle_lista;
    public int calificacion_eval_detalle_lista;
    public String observarcion_eval_detalle_lista;
    public long id_eval_version_general_eval_detalle_lista;
    public long id_detalle_lista_eval_detalle_lista;

    

    
    public Eval_Detalle_Lista_Dao(Eval_Detalle_Lista_Bean Evalu_Deta_lista) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_eval_detalle_lista = Evalu_Deta_lista.getId_eval_detalle_lista();
            calificacion_eval_detalle_lista = Evalu_Deta_lista.getCalificacion_eval_detalle_lista();
            observarcion_eval_detalle_lista = Evalu_Deta_lista.getObservarcion_eval_detalle_lista();
            id_eval_version_general_eval_detalle_lista = Evalu_Deta_lista.getId_eval_version_general_eval_detalle_lista();
            id_detalle_lista_eval_detalle_lista =Evalu_Deta_lista.getId_detalle_lista_eval_detalle_lista();
            

        } catch (SQLException e) {
        }
    
    }
    
}
