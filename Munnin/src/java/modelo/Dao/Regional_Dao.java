package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Regional_Bean;
import util.ClassConexion;
import util.ConexionBD;


public class Regional_Dao extends ConexionBD {

    private static final String COL_ID_REGIONAL = "id_regional";
    private static final String COL_NOMBRE_REGIONAL = "nombre_regional";

    private static final String PROCEDURE_INSERT_REGIONAL = "{CALL INSERTAR_REGIONAL(?,?)}";
    private static final String PROCEDURE_UPDATE_REGIONAL = "{CALL EDITAR_REGIONAL(?,?)}";
    private static final String PROCEDURE_DELETE_REGIONAL = "{CALL ElIMINAR_REGIONAL(?,?)}";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Regional_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_regional Id de la Regional
     * @return Retorna Null si la Regional no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la Regional.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Regional_Bean InsertarRegional(Long Id_regional) throws SQLException {
        Regional_Bean regional = new Regional_Bean();//el objeto en donde se guardan los resultados de la consulta
        regional.setId_regional(Id_regional);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_REGIONAL(?,?)}");
        statement.setLong(PROCEDURE_INSERT_REGIONAL, Id_regional);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_REGIONAL);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

       
        return regional;
    }

    /**
     * @param Id_regional Id de la Regional
     * @return Retorna Null si la Regional no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la Regional.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Regional_Bean UpdateRegional(Long Id_regional) throws SQLException {
        Regional_Bean regional = new Regional_Bean();//el objeto en donde se guardan los resultados de la consulta
        regional.setId_regional(Id_regional);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_REGIONAL(?,?)}");
        statement.setLong(PROCEDURE_UPDATE_REGIONAL, Id_regional);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_REGIONAL);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return regional;
    }

    /**
     * @param Id_regional Id de la Regional
     * @return Retorna Null si la Regional no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la Regional.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Regional_Bean DeleteRegional(long Id_regional) throws SQLException {
        Regional_Bean regional = new Regional_Bean();//el objeto en donde se guardan los resultados de la consulta
        regional.setId_regional(Id_regional);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_REGIONAL(?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_REGIONAL, Id_regional);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_REGIONAL);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return regional;
    }

}
