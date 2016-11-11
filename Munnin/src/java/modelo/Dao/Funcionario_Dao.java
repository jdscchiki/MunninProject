package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Funcionario_Bean;
import util.ClassConexion;
import util.ConexionBD;

public class Funcionario_Dao extends ConexionBD {

    private static final String COL_ID_FUNCIONARIO = "id_funcionario";
    private static final String COL_DOCUMENTO_FUNCIONARIO = "documento_funcionario";
    private static final String COL_CORREO_FUNCIONARIO = "correo_funcionario";
    private static final String COL_CONTRASEÑA_FUNCIONARIO = "contraseña_funcionario";
    private static final String COL_NOMBRE_FUNCIONARIO = "nombre_funcionario";
    private static final String COL_APELLIDO_FUNCIONARIO = "apellido_funcionario";
    private static final String COL_CARGO_FUNCIONARIO = "cargo_funcinario";
    private static final String COL_TELEFONO_FUNCIONARIO = "telefono_funcionario";
    private static final String COL_ID_CENTRO_FUNCIONARIO = "id_centro_funcionario";

    private static final String PROCEDURE_INSERT_FUNCIONARIO = "{CALL INSERTAR_FUNCIONARIO(?,?,?,?,?,?,?,?,?)}";
    private static final String PROCEDURE_UPDATE_FUNCIONARIO = "{CALL EDITAR_FUNCIONARIO(?,?,?,?,?,?,?,?,?)}";
    private static final String PROCEDURE_DELETE_FUNCIONARIO = "{CALL ElIMINAR_FUNCIONARIO(?,?,?,?,?,?,?,?,?)}";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Funcionario_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_funcionario Id del Funcionario
     * @return Retorna Null si el Funcionario no se encuetra en la base de datos, de lo
     * contrario retorna los datos del funcionario.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Funcionario_Bean InsertarFuncionario(Long Id_funcionario) throws SQLException {
        Funcionario_Bean funcionario = new Funcionario_Bean();//el objeto en donde se guardan los resultados de la consulta
        funcionario.setId_funcionario(Id_funcionario);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERT_FUNCIONARIO(?,?,?,?,?,?,?,?,?)}");
        statement.setLong(PROCEDURE_INSERT_FUNCIONARIO, Id_funcionario);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_DOCUMENTO_FUNCIONARIO);
        statement.setString(3, COL_CORREO_FUNCIONARIO);
        statement.setString(4, COL_CONTRASEÑA_FUNCIONARIO);
        statement.setString(5, COL_NOMBRE_FUNCIONARIO);
        statement.setString(6, COL_APELLIDO_FUNCIONARIO);
        statement.setString(7, COL_CARGO_FUNCIONARIO);
        statement.setString(8,COL_TELEFONO_FUNCIONARIO);
        statement.setString(9, COL_ID_CENTRO_FUNCIONARIO);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

        return funcionario;
    }

    /**
     * @param Id_funcionario Id del funcionario
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Funcionario_Bean UpdateFuncionario(Long Id_funcionario) throws SQLException {
        Funcionario_Bean funcionario = new Funcionario_Bean();//el objeto en donde se guardan los resultados de la consulta
        funcionario.setId_funcionario(Id_funcionario);
        CallableStatement statement = this.getConexion().prepareCall("{CALL UPDATE_FUNCIONARIO(?,?,?,?,?,?,?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_FUNCIONARIO, Id_funcionario);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_DOCUMENTO_FUNCIONARIO);
        statement.setString(3, COL_CORREO_FUNCIONARIO);
        statement.setString(4, COL_CONTRASEÑA_FUNCIONARIO);
        statement.setString(5, COL_NOMBRE_FUNCIONARIO);
        statement.setString(6, COL_APELLIDO_FUNCIONARIO);
        statement.setString(7, COL_CARGO_FUNCIONARIO);
        statement.setString(8,COL_TELEFONO_FUNCIONARIO);
        statement.setString(9, COL_ID_CENTRO_FUNCIONARIO);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return funcionario;
    }

    /**
     * @param Id_funcionario Id del funcionario
     * @return Retorna Null si el funcionario no se encuetra en la base de datos, de lo
     * contrario retorna los datos del funcionario.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Funcionario_Bean DeleteArea(long Id_funcionario) throws SQLException {
        Funcionario_Bean funcionario = new Funcionario_Bean();//el objeto en donde se guardan los resultados de la consulta
        funcionario.setId_funcionario(Id_funcionario);
        CallableStatement statement = this.getConexion().prepareCall("{CALL DELETE_AREA(?,?,?,?,?,?,?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_FUNCIONARIO, Id_funcionario);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_DOCUMENTO_FUNCIONARIO);
        statement.setString(3, COL_CORREO_FUNCIONARIO);
        statement.setString(4, COL_CONTRASEÑA_FUNCIONARIO);
        statement.setString(5, COL_NOMBRE_FUNCIONARIO);
        statement.setString(6, COL_APELLIDO_FUNCIONARIO);
        statement.setString(7, COL_CARGO_FUNCIONARIO);
        statement.setString(8,COL_TELEFONO_FUNCIONARIO);
        statement.setString(9, COL_ID_CENTRO_FUNCIONARIO);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return funcionario;
    }

}
