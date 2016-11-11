package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Programa_Bean;
import util.ClassConexion;
import util.ConexionBD;

public class Programa_Dao extends ConexionBD {

    private static final String COL_ID_PROGRAMA = "id_programa";
    private static final String COL_NOMBRE_PROGRAMA = "nombre_programa";
    private static final String COL_ID_AREA_PROGRAMA = "id_area_programa";

    private static final String PROCEDURE_INSERT_PROGRAMA = "{CALL INSERTAR_PROGRAMA(?,?,?)}";
    private static final String PROCEDURE_UPDATE_PROGRAMA = "{CALL EDITAR_PROGRAMA(?,?,?)}";
    private static final String PROCEDURE_DELETE_PROGRAMA = "{CALL ElIMINAR_PROGRAMA(?,?,?)}";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Programa_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_programa Id del Programa
     * @return Retorna Null si el Programa no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Programa.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Programa_Bean InsertarPrograma(Long Id_programa) throws SQLException {
        Programa_Bean programa = new Programa_Bean();//el objeto en donde se guardan los resultados de la consulta
        programa.setId_programa(Id_programa);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_PROGRAMA(?,?,?)}");
        statement.setLong(PROCEDURE_INSERT_PROGRAMA, Id_programa);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_PROGRAMA);
        statement.setString(3, COL_ID_AREA_PROGRAMA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

       
        return programa;
    }

    /**
     * @param Id_programa Id del Programa
     * @return Retorna Null si el Programa no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Programa.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Programa_Bean UpdatePrograma(Long Id_programa) throws SQLException {
        Programa_Bean programa = new Programa_Bean();//el objeto en donde se guardan los resultados de la consulta
        programa.setId_programa(Id_programa);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_PROGRAMA(?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_PROGRAMA, Id_programa);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_PROGRAMA);
        statement.setString(3, COL_ID_AREA_PROGRAMA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return programa;
    }

    /**
     * @param Id_programa Id del Programa
     * @return Retorna Null si el Programa no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Programa.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Programa_Bean DeletePrograma(long Id_programa) throws SQLException {
        Programa_Bean programa = new Programa_Bean();//el objeto en donde se guardan los resultados de la consulta
        programa.setId_programa(Id_programa);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_PROGRAMA(?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_PROGRAMA, Id_programa);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_PROGRAMA);
        statement.setString(3, COL_ID_AREA_PROGRAMA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return programa;
    }

}
