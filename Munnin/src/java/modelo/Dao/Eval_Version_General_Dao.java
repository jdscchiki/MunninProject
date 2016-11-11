
package modelo.Dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.naming.NamingException;
import modelo.Beans.Eval_Version_General_Bean;
import util.ClassConexion;
import util.ConexionBD;

public class Eval_Version_General_Dao extends ConexionBD {

    private static final String COL_ID_EVAL_VERSION_GENERAL= "id_eval_version_general";
    private static final String COL_ID_VERSION_EVAL_VERSION_GENERAL = "id_version_eval_version_general";
    private static final String COL_ID_LISTA_EVAL_VERSION_GENERAL = "id_lista_eval_version_general";
    private static final String COL_CALIFICACION_EVAL_VERSION_GENERAL = "calificacion_eval_version_general";
    private static final String COL_OBSERVACION_EVAL_VERSION_GENERAL = "observaciones_eval_version_general";
    private static final String COL_FECHA_EVAL_VERSION_GENERAL = "fecha_eval_version_general";
    private static final String COL_ID_EVALUADOR_EVAL_VERSION_GENERAL = "id_evaluador_eval_version_general";

    private static final String PROCEDURE_INSERT_EVAL_VERSION= "{CALL INSERTAR_EVAL_VERSION(?,?,?,?,?,?,?)}";
    private static final String PROCEDURE_UPDATE_EVAL_VERSION = "{CALL EDITAR_EVAL_VERSION(?,?,?,?,?,?,?)}";
    private static final String PROCEDURE_DELETE_EVAL_VERSION = "{CALL ElIMINAR_EVAL_VERSION(?,?,?,?,?,?,?)}";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Eval_Version_General_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_eval_version_general Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Eval_Version_General_Bean InsertarArea(Long Id_eval_version_general) throws SQLException {
        Eval_Version_General_Bean evalver = new Eval_Version_General_Bean();//el objeto en donde se guardan los resultados de la consulta
        evalver.setId_eval_version_general(Id_eval_version_general);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_EVAL_VERSION(?,?,?,?,?,?,?)}");
        statement.setLong(PROCEDURE_INSERT_EVAL_VERSION, Id_eval_version_general);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_ID_VERSION_EVAL_VERSION_GENERAL);
        statement.setString(3, COL_ID_LISTA_EVAL_VERSION_GENERAL);
        statement.setString(4, COL_CALIFICACION_EVAL_VERSION_GENERAL);
        statement.setString(5, COL_OBSERVACION_EVAL_VERSION_GENERAL);
        statement.setString(6, COL_FECHA_EVAL_VERSION_GENERAL);
        statement.setString(7, COL_ID_EVALUADOR_EVAL_VERSION_GENERAL);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

       
        return evalver;
    }

    /**
     * @param id_eval_version_general Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Eval_Version_General_Bean UpdateArea(Long Id_eval_version_general) throws SQLException {
        Eval_Version_General_Bean evalver = new Eval_Version_General_Bean();//el objeto en donde se guardan los resultados de la consulta
        evalver.setId_eval_version_general(Id_eval_version_general);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_EVAL_VERSION(?,?,?,?,?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_EVAL_VERSION, Id_eval_version_general);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_ID_VERSION_EVAL_VERSION_GENERAL);
        statement.setString(3, COL_ID_LISTA_EVAL_VERSION_GENERAL);
        statement.setString(4, COL_CALIFICACION_EVAL_VERSION_GENERAL);
        statement.setString(5, COL_OBSERVACION_EVAL_VERSION_GENERAL);
        statement.setString(6, COL_FECHA_EVAL_VERSION_GENERAL);
        statement.setString(7, COL_ID_EVALUADOR_EVAL_VERSION_GENERAL);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return evalver;
    }

    /**
     * @param Id_eval_version_general Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Eval_Version_General_Bean DeleteArea(long Id_eval_version_general) throws SQLException {
        Eval_Version_General_Bean evalver = new Eval_Version_General_Bean();//el objeto en donde se guardan los resultados de la consulta
        evalver.setId_eval_version_general(Id_eval_version_general);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_EVAL_VERSION(?,?,?,?,?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_EVAL_VERSION, Id_eval_version_general);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_ID_VERSION_EVAL_VERSION_GENERAL);
        statement.setString(3, COL_ID_LISTA_EVAL_VERSION_GENERAL);
        statement.setString(4, COL_CALIFICACION_EVAL_VERSION_GENERAL);
        statement.setString(5, COL_OBSERVACION_EVAL_VERSION_GENERAL);
        statement.setString(6, COL_FECHA_EVAL_VERSION_GENERAL);
        statement.setString(7, COL_ID_EVALUADOR_EVAL_VERSION_GENERAL);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return evalver;
    }

}
