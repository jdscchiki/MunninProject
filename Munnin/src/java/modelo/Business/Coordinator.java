/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Business;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import modelo.bean.Funcionario;
import modelo.bean.Rol;
import modelo.bean.TipoDocumento;
import modelo.dao.TipoDocumentoDAO;
import util.Encriptado;
import util.PassGenerator;
import util.Mail;
import modelo.dao.FuncionarioDAO;
import modelo.dao.RolDAO;

/**
 * clase dedicada a la logica de negocio usada por el rol de coordinador
 *
 * @author Juan David Segura Castro
 *
 */
public class Coordinator {

    /**
     * registro de funcionarios con la logica de un admin
     *
     * @param funcionario Datos del funcionario a registerFunctionary
     * @param idCentro Id del centro en que va a ser registrado
     * @return un entero entre 0 y 5. 0 fallo. 1 completado. 2 existe un usuario
     * activo con los datos ingresados. 3 existe un usuario no-activo con el
     * mismo correo. 4 existe un usuario no-activo con el mismo documento. 5 el
     * correo no pudo ser enviado.
     * @throws util.Encriptado.CannotPerformOperationException Error al realizar
     * la encriptacion de la contraseña, verificar la version de java
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     * @throws java.io.UnsupportedEncodingException Problemas con los Correos de
     * origen
     * @throws javax.mail.MessagingException Problemas con el Correo de destino
     */
    public static int registerFunctionary(Funcionario funcionario, String idCentro) throws Encriptado.CannotPerformOperationException, NamingException, SQLException, UnsupportedEncodingException, MessagingException {
        /*
        0. fallo
        1. completado
        2. existe un usuario activo con los datos ingresados
        3. existe un usuario no-activo con el mismo correo
        4. existe un usuario no-activo con el mismo documento
        5. el correo no pudo ser enviado
         */

        int resultado = 0;
        funcionario.setIdCentro(idCentro);
        String contrasena = PassGenerator.getSecurePassword();
        funcionario.setContrasena(Encriptado.createHash(contrasena));
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        if (funcionarioDAO.isActiveFunctionary(funcionario.getCorreo(), funcionario.getTipoDocumento().getId(), funcionario.getDocumento())) {
            resultado = 2;
        } else {
            if (funcionarioDAO.existFunctionaryByMail(funcionario.getCorreo())) {
                resultado = 3;
            } else if (funcionarioDAO.existFunctionaryByDocument(funcionario.getDocumento(), funcionario.getTipoDocumento().getId())) {
                resultado = 4;
            } else {
                if (funcionarioDAO.registerFunctionary(funcionario)) {
                    funcionario.setContrasena(null);
                    if (Mail.enviarPrimeraContrasena(funcionario, contrasena)) {
                        resultado = 1;
                    } else {
                        resultado = 5;
                    }
                }
            }
        }

        funcionarioDAO.cerrarConexion();

        return resultado;
    }

    /**
     * consulta de los tipos de documento
     *
     * @return ArrayList de tipos de documento
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD o en el query de
     * la consulta
     */
    public static ArrayList<TipoDocumento> viewDocumentType() throws NamingException, SQLException {
        ArrayList<TipoDocumento> tiposDoc;
        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        tiposDoc = tipoDocumentoDAO.selectAll();

        tipoDocumentoDAO.cerrarConexion();

        return tiposDoc;
    }

    /**
     * Consulta los roles que son posibles asignar desde el rol de coordinador
     *
     * @return Un arreglo de Roles con su respectivo id y nombre
     * @throws NamingException
     * @throws SQLException
     */
    public static ArrayList<Rol> viewRoles() throws NamingException, SQLException {
        ArrayList<Rol> roles;

        RolDAO rolDAO = new RolDAO();
        roles = rolDAO.selectAll();
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getId() == RolDAO.ID_ADMINISTRADOR) {
                roles.remove(i);
            }
        }

        rolDAO.cerrarConexion();

        return roles;
    }

    /**
     * Consulta la cantidad de paginas necesarias para mostrar todos los
     * funcionarios
     *
     * @param idCentro Id del centro al cual se va a realizar la consulta
     * @param cantXpag Cantidad de funcionarios por pagina
     * @param search filtro de busqueda
     * @return la cantidad de paginas
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD o en el query de
     * la consulta
     */
    public static int countPagesFunctionaryCenter(String idCentro, int cantXpag, String search) throws NamingException, SQLException {
        int paginas;
        int cantFuncionarios;
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        cantFuncionarios = funcionarioDAO.countFunctionaryCenter(idCentro, search);
        funcionarioDAO.cerrarConexion();

        paginas = cantFuncionarios / cantXpag;
        if (cantFuncionarios % cantXpag != 0) {
            paginas++;
        }

        return paginas;
    }

    /**
     * Consulta los funcionarios de un centro en especifico, en una pagina
     * especifica
     *
     * @param idCentro Id del centro a consultar
     * @param pagina El numero de la pagina a consultar
     * @param cantXpag La cantidad de funcionarios por pagina
     * @param search filtro de busqueda de funcionario, por nombre, apellido, documento
     * @return
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD o en el query de
     * la consulta
     */
    public static ArrayList<Funcionario> viewPagerFunctionaryCenter(String idCentro, int pagina, int cantXpag, String search) throws NamingException, SQLException {
        ArrayList<Funcionario> funcionarios;
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarios = funcionarioDAO.selectSomeFunctionaryCenter(idCentro, pagina, cantXpag, search);

        funcionarioDAO.cerrarConexion();

        return funcionarios;
    }

    /**
     * Inhabilita la cuenta de un funcionario
     *
     * @param idFuncionario Id del funcionario a inhabilitar
     * @return True, si el funcionario fue inhabilitado correctamente
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD o en el query de
     * la consulta
     */
    public static boolean disableFunctionary(int idFuncionario) throws NamingException, SQLException {
        boolean resultado;
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        resultado = funcionarioDAO.disableFunctionary(idFuncionario);

        funcionarioDAO.cerrarConexion();

        return resultado;
    }
    
    public static boolean enableFunctionary(int idFuncionario) throws NamingException, SQLException {
        boolean resultado;
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        resultado = funcionarioDAO.enableFunctionary(idFuncionario);

        funcionarioDAO.cerrarConexion();

        return resultado;
    }

    public static Funcionario viewAllInfoFunctionary(int idFuncionario) throws NamingException, SQLException {
        Funcionario resultado = new Funcionario();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        resultado.setId(idFuncionario);
        resultado = funcionarioDAO.select(resultado);
        resultado.setRoles(funcionarioDAO.selectRolesFunctionary(resultado.getId()));
        resultado.setContrasena(null);

        funcionarioDAO.cerrarConexion();

        return resultado;
    }

    /**
     * Metodo para asignar roles a los funcionarios
     *
     * @param idFuncionario id del funcionario al cual se le cambiara el rol
     * @param strIdNewRoles ArrayList de Strings con los id de los roles
     * @return un valor entero que cambia dependiendo de la operacion: 0 ha
     * ocurrido un error, 1 operacion exitosa, 2 error en el ingreso de datos, 3
     * no se ha podido agregar algun rol al funcionario, 4 no se ha podido
     * eliminar algun rol del funcionario
     * @throws NamingException
     * @throws SQLException
     */
    public static int AssignRoles(int idFuncionario, ArrayList<String> strIdNewRoles) throws NamingException, SQLException {
        int resultado = 0;
        //transforma las id de los roles de string a int
        ArrayList<Integer> intIdNewRoles = new ArrayList<>();
        for (String idRole : strIdNewRoles) {
            try {
                intIdNewRoles.add(Integer.parseInt(idRole));
            } catch (Exception e) {
                return 2;//finaliza con error, inconsistencia en los datos ingresados
            }
        }
        //consulta los roles disponibles
        ArrayList<Rol> newRoles = verifyRol(intIdNewRoles);//valida los nuevos roles(sean roles validos para asignar)
        ArrayList<Rol> availableRoles = viewRoles();//roles disponibles
        ArrayList<Rol> currentRoles = viewAllInfoFunctionary(idFuncionario).getRoles();//roles del funcionario actualmente
        ArrayList<Rol> deleteRoles = new ArrayList<>();//roles eliminados del funcionario 
        ArrayList<Rol> addRoles = new ArrayList<>();//nuevos roles del funcionario

        for (Rol availableRole : availableRoles) {//compara los roles que ya posee el funcionario y los nuevos roles con los roles disponibles para cambiar
            boolean isCurrentRole = false;
            boolean isNewRole = false;

            for (Rol currentRole : currentRoles) {
                if (currentRole.getId() == availableRole.getId()) {
                    isCurrentRole = true;
                    break;
                }
            }
            for (Rol newRole : newRoles) {
                if (availableRole.getId() == newRole.getId()) {
                    isNewRole = true;
                    break;
                }
            }

            if (isCurrentRole != isNewRole) {//si son iguales significa que no hay ningun cambio
                if (isNewRole) {//se agrega el rol al funcionario
                    addRoles.add(availableRole);
                } else {//se quita el rol al funcionario
                    deleteRoles.add(availableRole);
                }
            }
        }
        //se realizan la operaciones en la base de datos
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        for (Rol addRole : addRoles) {
            if (!funcionarioDAO.addFunctionaryRole(idFuncionario, addRole.getId())) {
                resultado = 3;
            }
        }
        for (Rol deleteRole : deleteRoles) {
            if (!funcionarioDAO.deleteFunctionaryRole(idFuncionario, deleteRole.getId())) {
                resultado = 4;
            }
        }
        if (resultado == 0) {//si resultado no cambia en ningun momento la operacion fue exitosa
            resultado = 1;//operacion exitosa
        }
        funcionarioDAO.cerrarConexion();

        return resultado;
    }

    /**
     * Verificacion para realizar un cambio de roles, solo por seguridad se
     * revisan nuevamente los roles disponibles y se comparan con los roles que
     * vana ser cambiados
     *
     * @param intIdRoles Arreglo de enteros con el id de los roles con los que
     * el funcionario va a quedar
     * @return Arreglo de roles
     * @throws NamingException
     * @throws SQLException
     */
    private static ArrayList<Rol> verifyRol(ArrayList<Integer> intIdRoles) throws NamingException, SQLException {
        ArrayList<Rol> answer = new ArrayList<>();

        ArrayList<Rol> availableRoles = viewRoles();

        classify:
        for (Rol availableRole : availableRoles) {
            for (Integer intIdRole : intIdRoles) {
                if (availableRole.getId() == intIdRole) {
                    answer.add(availableRole);
                    continue classify;
                }
            }
        }
        return answer;
    }
    
    public static ArrayList<Funcionario> viewDisabledFunctionary(String idCentro, String filtro) throws NamingException, SQLException{
        ArrayList<Funcionario> answer;
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        answer = funcionarioDAO.selectDisabledFunctionaryCenter(idCentro, filtro);
        
        funcionarioDAO.cerrarConexion();
        
        return answer;
    }
}
