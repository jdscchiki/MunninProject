
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.FuncionarioRolBean;
import util.ClassConexion;
import util.ConexionBD;


public class FuncionarioRolDao extends ConexionBD {

    private static final String COL_ID_FUNCIONARIO_FUNCI_ROL = "id_funcionario_funci_rol";
    private static final String COL_ID_ROL_FUNCI_ROL = "id_rol_funci_rol";
  
    private static final String PROCEDURE_INSERT_FUNCIONARIO_ROL = "{CALL INSERTAR_FUNCIONARIO_ROL(?,?)}";
    private static final String PROCEDURE_UPDATE_FUNCIONARIO_ROL = "{CALL EDITAR_FUNCIONARIO_ROL(?,?)}";
    private static final String PROCEDURE_DELETE_FUNCIONARIO_ROL = "{CALL ElIMINAR_FUNCIONARIO_ROL(?,?)}";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public FuncionarioRolDao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_area Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public FuncionarioRolBean InsertarFuncionarioRol(Long Id_funcionario_funci_rol) throws SQLException {
        FuncionarioRolBean funcirol = new FuncionarioRolBean();//el objeto en donde se guardan los resultados de la consulta
        funcirol.setId_funcionario_funci_rol(Id_funcionario_funci_rol);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERT_FUNCIONARIO_ROL(?,?)}");
        statement.setLong(PROCEDURE_INSERT_FUNCIONARIO_ROL, Id_funcionario_funci_rol);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_ID_ROL_FUNCI_ROL);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

       
        return funcirol;
    }

    /**
     * @param Id_funcionario_funci_rol  Id del Funcionario_rol
     * @return Retorna Null si el Funcionario_rol no se encuetra en la base de datos, de lo
     * contrario retorna los datos del funcionario_rol.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public FuncionarioRolBean UpdateFuncionarioRol(Long Id_funcionario_funci_rol) throws SQLException {
        FuncionarioRolBean funcirol = new FuncionarioRolBean();//el objeto en donde se guardan los resultados de la consulta
        funcirol.setId_funcionario_funci_rol(Id_funcionario_funci_rol);
        CallableStatement statement = this.getConexion().prepareCall("{CALL UPDATE_FUNCIONARIO_ROL(?,?)}");
        statement.setLong(PROCEDURE_UPDATE_FUNCIONARIO_ROL, Id_funcionario_funci_rol);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_ID_ROL_FUNCI_ROL);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return funcirol;
    }

    /**
     * @param Id_funcionario_funci_rol  Id del funcionario rol
     * @return Retorna Null si el funcionario rol no se encuetra en la base de datos, de lo
     * contrario retorna los datos del funcionario rol.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  FuncionarioRolBean DeleteArea(long Id_funcionario_funci_rol) throws SQLException {
        FuncionarioRolBean funcirol = new FuncionarioRolBean();//el objeto en donde se guardan los resultados de la consulta
        funcirol.setId_funcionario_funci_rol(Id_funcionario_funci_rol);
        CallableStatement statement = this.getConexion().prepareCall("{CALL DELETE_FUNCIONARIO_ROL(?,?)}");
        statement.setLong(PROCEDURE_DELETE_FUNCIONARIO_ROL, Id_funcionario_funci_rol);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_ID_ROL_FUNCI_ROL);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return funcirol;
    }

}
