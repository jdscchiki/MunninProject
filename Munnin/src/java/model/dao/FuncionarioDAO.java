/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.bean.Centro;
import util.database.ConexionBD;
import model.bean.Funcionario;
import model.bean.Rol;
import model.bean.TipoDocumento;

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
     * Metodo para insertar un funcionario en la base de datos
     *
     * @deprecated
     * @param funcionario Datos del funcionario insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Funcionario funcionario) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_FUNCIONARIO(?,?,?,?,?,?,?,?,?)}";
        int indexActivo = 1;
        int indexIdTipoDocumento = 2;
        int indexDocumento = 3;
        int indexCorreo = 4;
        int indexContrasena = 5;
        int indexNombre = 6;
        int indexApellido = 7;
        int indexTelefono = 8;
        int indexIdCentro = 9;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setBoolean(indexActivo, funcionario.isActivo());
        statement.setInt(indexIdTipoDocumento, funcionario.getTipoDocumento().getId());
        statement.setString(indexDocumento, funcionario.getDocumento());
        statement.setString(indexCorreo, funcionario.getCorreo());
        statement.setString(indexContrasena, funcionario.getContrasena());
        statement.setString(indexNombre, funcionario.getNombre());
        statement.setString(indexApellido, funcionario.getApellido());
        statement.setString(indexTelefono, funcionario.getTelefono());
        statement.setString(indexIdCentro, funcionario.getCentro().getId());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para actualizar un funcionario en la base de datos
     *
     * @deprecated
     * @param funcionario Datos del funcionario a ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Funcionario funcionario) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_FUNCIONARIO(?,?,?,?,?,?,?)}";
        int indexId = 1;
        int indexActivo = 2;
        int indexIdTipoDocumento = 3;
        int indexDocumento = 4;
        int indexCorreo = 5;
        int indexContrasena = 6;
        int indexNombre = 7;
        int indexApellido = 8;
        int indexTelefono = 9;
        int indexIdCentro = 10;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, funcionario.getId());
        statement.setBoolean(indexActivo, funcionario.isActivo());
        statement.setInt(indexIdTipoDocumento, funcionario.getTipoDocumento().getId());
        statement.setString(indexDocumento, funcionario.getDocumento());
        statement.setString(indexCorreo, funcionario.getCorreo());
        statement.setString(indexContrasena, funcionario.getContrasena());
        statement.setString(indexNombre, funcionario.getNombre());
        statement.setString(indexApellido, funcionario.getApellido());
        statement.setString(indexTelefono, funcionario.getTelefono());
        statement.setString(indexIdCentro, funcionario.getCentro().getId());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para borrar un funcionario en la base de datos
     *
     * @deprecated
     * @param funcionario Datos del funcionario
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Funcionario funcionario) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_FUNCIONARIO(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, funcionario.getId());

        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para ver los datos de un funcionario
     *
     * @param funcionario Objeto de tipo Funcionario que en el atributo id tiene
     * el valor del id a ser consultado
     * @return los valores almacenados en la tabla funcionario de la base de
     * datos
     * @throws SQLException
     */
    public Funcionario select(Funcionario funcionario) throws SQLException {

        String query = "{CALL VER_FUNCIONARIO(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, funcionario.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            funcionario.setId(rs.getInt(COL_ID));
            funcionario.setActivo(rs.getBoolean(COL_ACTIVO));
            TipoDocumento tipoDocumento = new TipoDocumento();
            tipoDocumento.setId(rs.getInt(COL_ID_TIPODOCUMENTO));
            funcionario.setTipoDocumento(tipoDocumento);
            funcionario.setDocumento(rs.getString(COL_DOCUMENTO));
            funcionario.setContrasena(rs.getString(COL_CONTRASENA));
            funcionario.setNombre(rs.getString(COL_NOMBRE));
            funcionario.setApellido(rs.getString(COL_APELLIDO));
            funcionario.setTelefono(rs.getString(COL_TELEFONO));
            Centro centro = new Centro();
            centro.setId(rs.getString(COL_ID_CENTRO));
            funcionario.setCentro(centro);
        }
        if (!encontrado) {
            funcionario = null;
        }

        return funcionario;
    }
    
    public ArrayList<Funcionario> selectAll() throws SQLException {
        ArrayList<Funcionario> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_FUNCIONARIO()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt(COL_ID));
            funcionario.setActivo(rs.getBoolean(COL_ACTIVO));
            TipoDocumento tipoDocumento = new TipoDocumento();
            tipoDocumento.setId(rs.getInt(COL_ID_TIPODOCUMENTO));
            funcionario.setTipoDocumento(tipoDocumento);
            funcionario.setDocumento(rs.getString(COL_DOCUMENTO));
            funcionario.setContrasena(rs.getString(COL_CONTRASENA));
            funcionario.setNombre(rs.getString(COL_NOMBRE));
            funcionario.setApellido(rs.getString(COL_APELLIDO));
            funcionario.setTelefono(rs.getString(COL_TELEFONO));
            Centro centro = new Centro();
            centro.setId(rs.getString(COL_ID_CENTRO));
            funcionario.setCentro(centro);
            
            result.add(funcionario);
        }

        return result;
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
    public Funcionario selectFunctionaryByMail(String correo) throws SQLException {
        Funcionario funcionario = new Funcionario();//el objeto en donde se guardan los resultados de la consulta

        //datos de la consulta en base de datos
        String query = "{CALL VER_FUNCIONARIO_CORREO(?)}";
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
            TipoDocumento tipoDocumento = new TipoDocumento();
            tipoDocumento.setId(rs.getInt(COL_ID_TIPODOCUMENTO));
            funcionario.setTipoDocumento(tipoDocumento);
            funcionario.setDocumento(rs.getString(COL_DOCUMENTO));
            funcionario.setContrasena(rs.getString(COL_CONTRASENA));
            funcionario.setNombre(rs.getString(COL_NOMBRE));
            funcionario.setApellido(rs.getString(COL_APELLIDO));
            funcionario.setTelefono(rs.getString(COL_TELEFONO));
            Centro centro = new Centro();
            centro.setId(rs.getString(COL_ID_CENTRO));
            funcionario.setCentro(centro);
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
    public boolean registerFunctionary(Funcionario funcionario) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL INSERTAR_FUNCIONARIO_REGISTRO(?,?,?,?,?,?,?,?)}";
        int indexTipoDoc = 1;
        int indexDoc = 2;
        int indexCorreo = 3;
        int indexContrasena = 4;
        int indexNombre = 5;
        int indexApellido = 6;
        int indexTelefono = 7;
        int indexIdCentro = 8;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexTipoDoc, funcionario.getTipoDocumento().getId());
        statement.setString(indexDoc, funcionario.getDocumento());
        statement.setString(indexCorreo, funcionario.getCorreo());
        statement.setString(indexContrasena, funcionario.getContrasena());
        statement.setString(indexNombre, funcionario.getNombre());
        statement.setString(indexApellido, funcionario.getApellido());
        statement.setString(indexTelefono, funcionario.getTelefono());
        statement.setString(indexIdCentro, funcionario.getCentro().getId());

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
     * Metodo para comprobar si existe un funcionario registrsado en la
     * plataforma con el mismo correo
     *
     * @param mail correo del funcionario
     * @return true si ese correo ya se encuentra registrado en la plataforma
     * @throws SQLException
     */
    public boolean existFunctionaryByMail(String mail) throws SQLException {
        boolean result = false;

        String query = "{CALL VER_FUNCIONARIO_CORREO(?)}";
        int indexMail = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexMail, mail);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            result = true;
        }

        return result;
    }

    /**
     * Metodo para comprobar si un funcionario se encuentra activo en la
     * plataforma
     *
     * @param correo correo del funcionario
     * @param documentType id del tipo de documento del funcionario
     * @param document documento del funcionario
     * @return True si existe un funcionario con el mismo documento, y correo en
     * la plataforma, ademas de encontrarse activo
     * @throws SQLException
     */
    public boolean isActiveFunctionary(String correo, int documentType, String document) throws SQLException {
        boolean result = false;

        String query = "{CALL VER_FUNCIONARIO_ACTIVO(?,?,?)}";
        int indexCorreo = 1;
        int indexDocumentType = 2;
        int indexDocument = 3;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexCorreo, correo);
        statement.setInt(indexDocumentType, documentType);
        statement.setString(indexDocument, document);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            result = true;
        }

        return result;
    }

    /**
     * Metodo para comprobar si existe un funcionario registrsado en la
     * plataforma con el mismo documento
     *
     * @param document documento del funcionario
     * @param documentType id del tipo de documento del funcionario
     * @return True si existe un funcionario registrado en la aplicacion con el
     * mismo documento
     * @throws SQLException
     */
    public boolean existFunctionaryByDocument(String document, int documentType) throws SQLException {
        boolean result = false;

        String query = "{CALL VER_FUNCIONARIO_DOCUMENTO(?,?)}";
        int indexDocument = 1;
        int indexDocumentType = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexDocument, document);
        statement.setInt(indexDocumentType, documentType);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            result = true;
        }

        return result;
    }

    /**
     * Consulta los roles de un funcionario
     *
     * @param id id del funcionario
     * @return ArrayList de los roles
     * @throws SQLException existe un priblema en la consulta
     */
    public ArrayList<Rol> selectRolesFunctionary(int id) throws SQLException {
        ArrayList<Rol> roles = new ArrayList<>();//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_TODOS_ROL_FUNCIONARIO(?)}";
        int indexIdFunc = 1;

        String resIdRol = "id_rol_funcionario_rol";//nombre de la columna del select
        String resNombreRol = "nombre_rol";//nombre de la columna del select

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexIdFunc, id);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta

        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            Rol rol = new Rol();
            rol.setId(rs.getInt(resIdRol));
            rol.setNombre(rs.getString(resNombreRol));
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
     * @param search busqueda de funcionario por nombre, apellido o documento
     * @param active busca entre funcionarios activos o inhabilitados (true para los activos)
     * @return ArrayList de los funcionarios pertenecientes a un centro por
     * intervalos
     * @throws SQLException existe un priblema en la consulta
     */
    public ArrayList<Funcionario> selectSomeFunctionariesCenter(String idCentro, int pagina, int cantXpag, String search, boolean active) throws SQLException {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_TODOS_FUNCIONARIO_CENTRO(?,?,?,?,?)}";
        int indexCentro = 1;
        int indexPagina = 2;
        int indexCantXPag = 3;
        int indexSearch = 4;
        int indexActive = 5;

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexCentro, idCentro);
        statement.setInt(indexPagina, pagina);
        statement.setInt(indexCantXPag, cantXpag);
        statement.setString(indexSearch, search);
        statement.setBoolean(indexActive, active);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt(COL_ID));
            TipoDocumento tipoDocumento = new TipoDocumento();
            tipoDocumento.setId(rs.getInt(COL_ID_TIPODOCUMENTO));
            funcionario.setTipoDocumento(tipoDocumento);
            funcionario.setDocumento(rs.getString(COL_DOCUMENTO));
            funcionario.setNombre(rs.getString(COL_NOMBRE));
            funcionario.setApellido(rs.getString(COL_APELLIDO));
            funcionario.setCorreo(rs.getString(COL_CORREO));
            funcionarios.add(funcionario);
        }
        return funcionarios;
    }

    /**
     * Metodo para realizar un conteo del los funcionarios del centro
     *
     * @param idCentro id del centro
     * @param search filtro de busqueda
     * @param active busca entre funcionarios activos o inhabilitados (true para los activos)
     * @return Entero con la catidad de funcionario registrados en el centro
     * @throws SQLException
     */
    public int countFunctionariesCenter(String idCentro, String search, boolean active) throws SQLException {
        int conteo = 0;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_FUNCIONARIO_CENTRO_CONTEO(?,?,?)}";
        int indexIdCentro = 1;
        int indexSearch = 2;
        int indexActive = 3;

        String resConteo = "conteo";//nombre de la columna del select

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexIdCentro, idCentro);
        statement.setString(indexSearch, search);
        statement.setBoolean(indexActive, active);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            conteo = rs.getInt(resConteo);
        }
        return conteo;
    }

    /**
     * Methodo para inhabilitar fuincionarios registrados en la aplicación, de
     * esta manera no se les permitira ingresar a la plataforma
     *
     * @param idFuncionario id del funcionario que va a ser inhabiltado
     * @return true si fue inhabilitado
     * @throws SQLException
     */
    public boolean disableFunctionary(int idFuncionario) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_FUNCIONARIO_INHABILITAR(?)}";
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

    public boolean enableFunctionary(int idFuncionario) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_FUNCIONARIO_HABILITAR(?)}";
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

    /**
     * Metodo para realizar un cambio de contraseña en la aplicacion
     *
     * @param id id del funcionario
     * @param password Nueva contraseña, debe estar encriptada para que pueda
     * ingresar a la plataforma
     * @return True si la contraseña fue cambiada correctamente
     * @throws SQLException
     */
    public boolean changePassword(int id, String password) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_FUNCIONARIO_CONTRASENA(?,?)}";
        int indexId = 1;
        int indexContrasena = 2;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, id);
        statement.setString(indexContrasena, password);

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
     * metodo para asignar un rol a un funcionario
     *
     * @param idFuncionario id del funcionario
     * @param idRol id del rol que va a ser asignado al funcionario
     * @return true si el rol fue asignado correctamente al funcionario
     * @throws SQLException
     */
    public boolean addFunctionaryRole(int idFuncionario, int idRol) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL INSERTAR_FUNCIONARIO_ROL(?,?)}";
        int indexIdFuncionario = 1;
        int indexIdRol = 2;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexIdFuncionario, idFuncionario);
        statement.setInt(indexIdRol, idRol);

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
     * metodo para privar a un funcionario de los privilegios de un rol
     *
     * @param idFuncionario id del funcionario
     * @param idRol id del rol del que va a ser privado el funcionario
     * @return true si fueron eliminados correctamente los permisos del
     * funcionrio
     * @throws SQLException
     */
    public boolean deleteFunctionaryRole(int idFuncionario, int idRol) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL ELIMINAR_FUNCIONARIO_ROL(?,?)}";
        int indexIdFuncionario = 1;
        int indexIdRol = 2;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexIdFuncionario, idFuncionario);
        statement.setInt(indexIdRol, idRol);

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }

    public boolean isLastCoordinatorEnableCenter(String idCentro, int idFuncionario) throws SQLException {
        boolean answer = false;

        //datos de la consulta en base de datos
        String query = "{CALL VER_FUNCIONARIO_ES_ULTIMO_COORDINADOR(?,?)}";
        int indexIdCentro = 1;
        int indexIdFuncionario = 2;
        String colAnswer = "RESULTADO";

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexIdCentro, idCentro);
        statement.setInt(indexIdFuncionario, idFuncionario);

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            answer = rs.getBoolean(colAnswer);
        }
        return answer;
    }
}
