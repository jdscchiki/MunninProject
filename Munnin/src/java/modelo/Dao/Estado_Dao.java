
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Estado_Bean;
import util.ClassConexion;
import util.ConexionBD;


 public class Estado_Dao extends ConexionBD {

    private static final String COL_ID_ESTADO = "id_estado";
    private static final String COL_NOMBRE_ESTADO = "nombre_estado";
    

    private static final String PROCEDURE_INSERT_ESTADO = "{CALL INSERTAR_ESTADO(?,?)}";
    private static final String PROCEDURE_UPDATE_ESTADO = "{CALL EDITAR_ESTADO(?,?)}";
    private static final String PROCEDURE_DELETE_ESTADO = "{CALL ElIMINAR_ESTADO(?,?)}";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Estado_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_estado Id del estado
     * @return Retorna Null si el Estado no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Estado_Bean InsertarEstado(Long Id_estado) throws SQLException {
        Estado_Bean estado = new Estado_Bean();//el objeto en donde se guardan los resultados de la consulta
        estado.setId_estado(Id_estado);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_ESTADO(?,?)}");
        statement.setLong(PROCEDURE_INSERT_ESTADO, Id_estado);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_ESTADO);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
       
        return estado;
    }

    /**
     * @param Id_estado Id del Estado
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Estado_Bean Updateestado(Long Id_estado) throws SQLException {
        Estado_Bean estado = new Estado_Bean();//el objeto en donde se guardan los resultados de la consulta
        estado.setId_estado(Id_estado);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_ESTADO(?,?)}");
        statement.setLong(PROCEDURE_UPDATE_ESTADO, Id_estado);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_ESTADO);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return estado;
    }

    /**
     * @param Id_area Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Estado_Bean DeleteEstado(long Id_estado) throws SQLException {
        Estado_Bean estado = new Estado_Bean();//el objeto en donde se guardan los resultados de la consulta
        estado.setId_estado(Id_estado);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_ESTADO(?,?)}");
        statement.setLong(PROCEDURE_DELETE_ESTADO, Id_estado);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_ESTADO);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return estado;
    }

}
