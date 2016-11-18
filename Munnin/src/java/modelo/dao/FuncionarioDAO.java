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
 * @author Juan David Segura Castro
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

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
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
     * @throws java.sql.SQLException existe un priblema en la consulta
     */
    public Funcionario buscarFuncionarioCorreo(String correo) throws SQLException {
        Funcionario funcionario = new Funcionario();//el objeto en donde se guardan los resultados de la consulta

        //datos de la consulta en base de datos
        String query = "{CALL LOGIN(?)}";
        int indexCorreo = 1;

        funcionario.setCorreo(correo);
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexCorreo, correo);//asigna los valores necesarios para ejecutar el QUERY
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

        return funcionario;
    }

    /**
     * Metodo para realizar el registro de un nuevo funcionario en la base de
     * datos de la aplicacion.
     *
     * @param funcionario Nuevo funcionario registrado
     * @return True, si el funcionario fue registrado correctamente en la base
     * de datos, false en caso contrario
     * @throws SQLException existe un priblema en la consulta
     */
    public boolean registrar(Funcionario funcionario) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL REGISTRAR_FUNCIONARIO(?,?,?,?,?,?,?,?)}";
        int indexTipoDoc = 1;
        int indexDoc = 2;
        int indexCorreo = 3;
        int indexContrasena = 4;
        int indexNombre = 5;
        int indexApellido = 6;
        int indexTelefono = 7;
        int indexIdCentro = 8;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexTipoDoc, funcionario.getIdTipoDocumento());
        statement.setString(indexDoc, funcionario.getDocumento());
        statement.setString(indexCorreo, funcionario.getCorreo());
        statement.setString(indexContrasena, funcionario.getContrasena());
        statement.setString(indexNombre, funcionario.getNombre());
        statement.setString(indexApellido, funcionario.getApellido());
        statement.setString(indexTelefono, funcionario.getTelefono());
        statement.setString(indexIdCentro, funcionario.getIdCentro());

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
     * Consulta los roles de un funcionario
     *
     * @param id id del funcionario
     * @return ArrayList de los roles
     * @throws SQLException existe un priblema en la consulta
     */
    public ArrayList<Rol> verRoles(int id) throws SQLException {
        ArrayList<Rol> roles = new ArrayList<>();//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_ROLES_FUNCIONARIO(?)}";
        int indexIdFunc = 1;

        String resId_rol = "id_rol_funci_rol";//nombre de la columna del select
        String resNombre_rol = "nombre_rol";//nombre de la columna del select

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexIdFunc, id);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta

        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            Rol rol = new Rol();
            rol.setId(rs.getInt(resId_rol));
            rol.setNombre(rs.getString(resNombre_rol));
            roles.add(rol);
        }

        return roles;
    }

    /**
     * Consulta los funcionario pertenecientes a un centro en especifico
     *
     * @param idCentro id del centro a consultar en la base de datos
     * @param pagina pagina a realizar consulta(usado para consultas a centros
     * grandes)
     * @param cantXpag resultados por pagina al realizar consulta(usado para
     * consultas a centros grandes)
     * @return ArrayList de los funcionarios pertenecientes a un centro por
     * intervalos
     * @throws SQLException existe un priblema en la consulta
     */
    public ArrayList<Funcionario> verFuncionariosCentro(String idCentro, int pagina, int cantXpag) throws SQLException {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_FUNCIONARIOS_CENTRO(?,?,?)}";
        int indexCentro = 1;
        int indexPagina = 2;
        int indexCantXPag = 3;

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexCentro, idCentro);
        statement.setInt(indexPagina, pagina);
        statement.setInt(indexCantXPag, cantXpag);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt(COL_ID));
            funcionario.setIdTipoDocumento(rs.getInt(COL_ID_TIPODOCUMENTO));
            funcionario.setDocumento(rs.getString(COL_DOCUMENTO));
            funcionario.setNombre(rs.getString(COL_NOMBRE));
            funcionario.setApellido(rs.getString(COL_APELLIDO));
            funcionario.setCorreo(rs.getString(COL_CORREO));
            funcionarios.add(funcionario);
        }
        return funcionarios;
    }

    public int conteoFuncionariosCentro(String idCentro) throws SQLException {
        int conteo = 0;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL CONTEO_FUNCIONARIOS_CENTRO(?)}";
        int indexCentro = 1;

        String resConteo = "conteo";//nombre de la columna del select

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexCentro, idCentro);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            conteo = rs.getInt(resConteo);
        }
        return conteo;
    }

    public boolean inhabilitarFuncionario(int idFuncionario) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL INHABILITAR_FUNCIONARIO(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, idFuncionario);

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el update se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el update cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }
    
    public boolean cambioContra(int id, String correo) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL CAMBIOCONTRASENA(?,?)}";
        int indexId = 1;
        int indexContrasena = 2;
        
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, id);
        statement.setString(indexContrasena, correo);

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
