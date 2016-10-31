/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import util.ConexionBD;
import modelo.bean.Funcionario;
import modelo.bean.Rol;

//cosas a tener en cuenta:
//  documentar los metodos, es facil con la herramienta javadoc
//  traten de ser lo mas explicitos posibles en la descripcion de los metodos
/**
 * Esta clase realiza y procesa las consultas a bases de datos, de las tablas
 * funcionario, rol y rol funcionario
 *
 * @version 1.2
 * @author Juan David Segura Castro <JBadCode>
 */
public class FuncionarioDAO extends ConexionBD {

    private static final String COL_ID = "id_funcionario";
    private static final String COL_ACTIVO = "activo_funcionario";
    private static final String COL_ID_TIPODOCUMENTO = "id_tipo_documento_funcionario";
    private static final String COL_DOCUMENTO = "documento_funcionario";
    private static final String COL_CORREO = "correo_funcionario";
    private static final String COL_CONTRASENA = "contrasena_funcionario";
    private static final String COL_NOMBRE = "nombre_funcionario";
    private static final String COL_APELLIDO = "apellido_funcionario";
    private static final String COL_TELEFONO = "telefono_funcionario";
    private static final String COL_ID_CENTRO = "id_centro_funcionario";

    private static final String PROCEDURE_INGRESO = "{CALL LOGIN(?)}";
    private static final int PROCEDURE_INGRESO_CORREO_INDEX = 1;

    private static final String PROCEDURE_REGISTRO_FUNCIONARIO = "{CALL REGISTRAR_FUNCIONARIO(?,?,?,?,?,?,?,?)}";//tal ves no funcione aun
    private static final int PROCEDURE_REGISTRO_FUNCIONARIO_TIPODOC_INDEX = 1;
    private static final int PROCEDURE_REGISTRO_FUNCIONARIO_DOCUMENTO_INDEX = 2;
    private static final int PROCEDURE_REGISTRO_FUNCIONARIO_CORREO_INDEX = 3;
    private static final int PROCEDURE_REGISTRO_FUNCIONARIO_CONTASENA_INDEX = 4;
    private static final int PROCEDURE_REGISTRO_FUNCIONARIO_NOMBRE_INDEX = 5;
    private static final int PROCEDURE_REGISTRO_FUNCIONARIO_APELLIDO_INDEX = 6;
    private static final int PROCEDURE_REGISTRO_FUNCIONARIO_TELEFONO_INDEX = 7;
    private static final int PROCEDURE_REGISTRO_FUNCIONARIO_IDCENTRO_INDEX = 8;

    private static final String PROCEDURE_VER_ROLES_FUNCIONARIO = "{CALL VER_ROLES_FUNCIONARIO(?)}";
    private static final int PROCEDURE_VER_ROLES_FUNCIONARIO_ID_INDEX = 1;
    private static final String RPROCEDURE_VER_ROLES_FUNCIONARIO_ID_ROL = "id_rol_funci_rol";
    private static final String RPROCEDURE_VER_ROLES_FUNCIONARIO_NORBRE_ROL = "nombre_rol";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public FuncionarioDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Consulta los datos del funcionario
     *
     * @param correo Correo del usuario
     * @return Retorna Null si el correo no se encuetra en la base de datos, de
     * lo contrario retorna los datos del Usuario.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Funcionario buscarFuncionarioCorreo(String correo) throws SQLException {
        Funcionario funcionario = new Funcionario();//el objeto en donde se guardan los resultados de la consulta
        funcionario.setCorreo(correo);
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INGRESO);
        statement.setString(PROCEDURE_INGRESO_CORREO_INDEX, correo);//asigna los valores necesarios para ejecutar el QUERY
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        boolean encontrado = false;//una bandera
        while (rs.next()) {
            encontrado = true;
            //asigna los valores resultantes de la consulta
            funcionario.setId(rs.getInt(COL_ID));
            funcionario.setActivo(rs.getBoolean(COL_ACTIVO));
            funcionario.setIdTipoDocumento(rs.getInt(COL_ID_TIPODOCUMENTO));
            funcionario.setDocumento(rs.getString(COL_DOCUMENTO));
            funcionario.setContrasena(rs.getString(COL_CONTRASENA));
            funcionario.setNombre(rs.getString(COL_NOMBRE));
            funcionario.setApellido(rs.getString(COL_APELLIDO));
            funcionario.setTelefono(rs.getString(COL_TELEFONO));
            funcionario.setIdCentro(rs.getString(COL_ID_CENTRO));
        }
        if (!encontrado) {
            funcionario = null;//si no existe el correo en la base de datos retorna null
        }
        if (this.cerrarConexion() != null) {
            System.out.println("Error al cerrar la conexion con la base de datos");
        }
        return funcionario;
    }

    /**
     * Metodo para realizar el registro de un nuevo funcionario en la base de
     * datos de la aplicacion.
     *
     * @param funcionario Nuevo funcionario registrado
     * @return True, si el funcionario fue registrado correctamente en la base
     * de datos, false en caso contrario
     * @throws SQLException
     */
    public boolean registrar(Funcionario funcionario) throws SQLException {
        boolean resultado;
        CallableStatement statement = getConexion().prepareCall(PROCEDURE_REGISTRO_FUNCIONARIO);
        statement.setInt(PROCEDURE_REGISTRO_FUNCIONARIO_TIPODOC_INDEX, funcionario.getIdTipoDocumento());
        statement.setString(PROCEDURE_REGISTRO_FUNCIONARIO_DOCUMENTO_INDEX, funcionario.getDocumento());
        statement.setString(PROCEDURE_REGISTRO_FUNCIONARIO_CORREO_INDEX, funcionario.getCorreo());
        statement.setString(PROCEDURE_REGISTRO_FUNCIONARIO_CONTASENA_INDEX, funcionario.getContrasena());
        statement.setString(PROCEDURE_REGISTRO_FUNCIONARIO_NOMBRE_INDEX, funcionario.getNombre());
        statement.setString(PROCEDURE_REGISTRO_FUNCIONARIO_APELLIDO_INDEX, funcionario.getApellido());
        statement.setString(PROCEDURE_REGISTRO_FUNCIONARIO_TELEFONO_INDEX, funcionario.getTelefono());
        statement.setString(PROCEDURE_REGISTRO_FUNCIONARIO_IDCENTRO_INDEX, funcionario.getIdCentro());

        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }

    /**
     * Consulta los roles de un funcionario
     *
     * @param id id del funcionario
     * @return ArrayList de los roles
     * @throws SQLException
     */
    public ArrayList<Rol> verRoles(int id) throws SQLException {
        ArrayList<Rol> roles = new ArrayList<>();
        CallableStatement statement = getConexion().prepareCall(PROCEDURE_VER_ROLES_FUNCIONARIO);
        statement.setInt(PROCEDURE_VER_ROLES_FUNCIONARIO_ID_INDEX, id);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            Rol rol = new Rol();
            rol.setId(rs.getInt(RPROCEDURE_VER_ROLES_FUNCIONARIO_ID_ROL));
            rol.setNombre(rs.getString(RPROCEDURE_VER_ROLES_FUNCIONARIO_NORBRE_ROL));
            roles.add(rol);
        }
        return roles;
    }

}
