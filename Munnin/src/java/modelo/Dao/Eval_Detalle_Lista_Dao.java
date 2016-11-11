package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Eval_Detalle_Lista_Bean;
import util.ClassConexion;
import util.ConexionBD;

public class Eval_Detalle_Lista_Dao extends ConexionBD {

    private static final String COL_ID_EVAL_DETALLE_LISTA = "id_eval_detalle_lista";
    private static final String COL_CALIFICACION_EVAL_DETALLE_LISTA = "calificacion_eval_detalle_lista";
    private static final String COL_OBSERVACION_EVAL_DETALLE_LISTA = "observarcion_eval_detalle_lista";
    private static final String COL_ID_EVAL_VERSION_GENERAL_EVAL_DETALLE_LISTA = "id_eval_version_general_eval_detalle_lista";
    private static final String COL_ID_DETALLE_LISTA_EVAL_DETALLE_LISTA = "id_detalle_lista_eval_detalle_lista";

    private static final String PROCEDURE_INSERT_EVAL_DETALLE = "{CALL INSERTAR_EVAL_DETALLE(?,?,?,?,?)}";
    private static final String PROCEDURE_UPDATE_EVAL_DETALLE = "{CALL EDITAR_EVAL_DETALLE(?,?,?,?,?)}";
    private static final String PROCEDURE_DELETE_EVAL_DETALLE = "{CALL ElIMINAR_EVAL_DETALLE(?,?,?,?,?)}";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Eval_Detalle_Lista_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_eval_detalle_lista Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Eval_Detalle_Lista_Bean InsertarEvalDetalle(Long Id_eval_detalle_lista) throws SQLException {
        Eval_Detalle_Lista_Bean evaldet = new Eval_Detalle_Lista_Bean();//el objeto en donde se guardan los resultados de la consulta
        evaldet.setId_eval_detalle_lista(Id_eval_detalle_lista);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_EVAL_DETALLE(?,?,?,?,?)}");
        statement.setLong(PROCEDURE_INSERT_EVAL_DETALLE, Id_eval_detalle_lista);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_CALIFICACION_EVAL_DETALLE_LISTA);
        statement.setString(3, COL_OBSERVACION_EVAL_DETALLE_LISTA);
        statement.setString(4, COL_ID_EVAL_VERSION_GENERAL_EVAL_DETALLE_LISTA);
        statement.setString(5, COL_ID_DETALLE_LISTA_EVAL_DETALLE_LISTA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

       
        return evaldet;
    }

    /**
     * @param Id_eval_detalle_lista Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Eval_Detalle_Lista_Bean UpdateEvalDetalle(Long Id_eval_detalle_lista) throws SQLException {
        Eval_Detalle_Lista_Bean evaldet = new Eval_Detalle_Lista_Bean();//el objeto en donde se guardan los resultados de la consulta
        evaldet.setId_eval_detalle_lista(Id_eval_detalle_lista);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_EVAL_DETALLE(?,?,?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_EVAL_DETALLE, Id_eval_detalle_lista);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_CALIFICACION_EVAL_DETALLE_LISTA);
        statement.setString(3, COL_OBSERVACION_EVAL_DETALLE_LISTA);
        statement.setString(4, COL_ID_EVAL_VERSION_GENERAL_EVAL_DETALLE_LISTA);
        statement.setString(5, COL_ID_DETALLE_LISTA_EVAL_DETALLE_LISTA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return evaldet;
    }

    /**
     * @param Id_eval_detalle_lista Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Eval_Detalle_Lista_Bean DeleteEvalDetalle(long Id_eval_detalle_lista) throws SQLException {
        Eval_Detalle_Lista_Bean evaldet = new Eval_Detalle_Lista_Bean();//el objeto en donde se guardan los resultados de la consulta
        evaldet.setId_eval_detalle_lista(Id_eval_detalle_lista);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_EVAL_DETALLE(?,?,?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_EVAL_DETALLE, Id_eval_detalle_lista);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_CALIFICACION_EVAL_DETALLE_LISTA);
        statement.setString(3, COL_OBSERVACION_EVAL_DETALLE_LISTA);
        statement.setString(4, COL_ID_EVAL_VERSION_GENERAL_EVAL_DETALLE_LISTA);
        statement.setString(5, COL_ID_DETALLE_LISTA_EVAL_DETALLE_LISTA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return evaldet;
    }

}
