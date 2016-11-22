package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.FuncionarioBean;
import util.ClassConexion;
import util.ConexionBD;

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * Funcionario.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

public class FuncionarioDao extends ConexionBD {

    private static final String COL_ID_FUNCIONARIO = "id_funcionario";
    private static final String COL_DOCUMENTO_FUNCIONARIO = "documento_funcionario";
    private static final String COL_CORREO_FUNCIONARIO = "correo_funcionario";
    private static final String COL_CONTRASEÑA_FUNCIONARIO = "contraseña_funcionario";
    private static final String COL_NOMBRE_FUNCIONARIO = "nombre_funcionario";
    private static final String COL_APELLIDO_FUNCIONARIO = "apellido_funcionario";
    private static final String COL_CARGO_FUNCIONARIO = "cargo_funcinario";
    private static final String COL_TELEFONO_FUNCIONARIO = "telefono_funcionario";
    private static final String COL_ID_CENTRO_FUNCIONARIO = "id_centro_funcionario";


    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public FuncionarioDao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_funcionario Id del Funcionario
     * @return Retorna Null si el Funcionario no se encuetra en la base de datos, de lo
     * contrario retorna los datos del funcionario.
     * @version 1.3
     * @throws java.sql.SQLException
     */
   public boolean InsertFuncionario(FuncionarioBean funcionario) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL INSERTAR_FUNCIONARIO(?,?,?,?,?,?,?,?)}";
        int indexTipoDoc = 1;
        int indexDoc = 2;
        int indexCorreo = 3;
        int indexContrasena = 4;
        int indexNombre = 5;
        int indexApellido = 6;
        int indexTelefono = 7;
        int indexIdCentro = 8;
        
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexTipoDoc, funcionario.getDocumento_funcionario());
        statement.setString(indexDoc, funcionario.getDocumento_funcionario());
        statement.setString(indexCorreo, funcionario.getCorreo_funcionario());
        statement.setString(indexContrasena, funcionario.getContrasena_funcionario());
        statement.setString(indexNombre, funcionario.getNombre_funcionario());
        statement.setString(indexApellido, funcionario.getApellido_funcionario());
        statement.setString(indexTelefono, funcionario.getTelefono_funcionario());
        statement.setString(indexIdCentro, funcionario.getId_centro_funcionario());

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }


    /**
     * @param Id_funcionario Id del funcionario
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Boolean UpdateFuncionario(FuncionarioBean funcionario) throws SQLException {
         boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_FUNCIONARIO(?,?,?,?,?,?,?,?)}";
        int indexTipoDoc = 1;
        int indexDoc = 2;
        int indexCorreo = 3;
        int indexContrasena = 4;
        int indexNombre = 5;
        int indexApellido = 6;
        int indexTelefono = 7;
        int indexIdCentro = 8;
        
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexTipoDoc, funcionario.getDocumento_funcionario());
        statement.setString(indexDoc, funcionario.getDocumento_funcionario());
        statement.setString(indexCorreo, funcionario.getCorreo_funcionario());
        statement.setString(indexContrasena, funcionario.getContrasena_funcionario());
        statement.setString(indexNombre, funcionario.getNombre_funcionario());
        statement.setString(indexApellido, funcionario.getApellido_funcionario());
        statement.setString(indexTelefono, funcionario.getTelefono_funcionario());
        statement.setString(indexIdCentro, funcionario.getId_centro_funcionario());

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }

    /**
     * @param Id_funcionario Id del funcionario
     * @return Retorna Null si el funcionario no se encuetra en la base de datos, de lo
     * contrario retorna los datos del funcionario.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Boolean DeleteArea(FuncionarioBean funcionario) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_FUNCIONARIO(?)}";
        int indexTipoDoc = 1;
        int indexIdCentro = 8;
        
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexTipoDoc, funcionario.getDocumento_funcionario());

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }

}
