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
    public static int registarFuncionario(Funcionario funcionario, String idCentro) throws Encriptado.CannotPerformOperationException, NamingException, SQLException, UnsupportedEncodingException, MessagingException {
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
            if (funcionarioDAO.existFunctionaryMail(funcionario.getCorreo())) {
                resultado = 3;
            } else if (funcionarioDAO.existFunctionaryDocument(funcionario.getDocumento(), funcionario.getTipoDocumento().getId())) {
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
    public static ArrayList<TipoDocumento> verTiposDocumentos() throws NamingException, SQLException {
        ArrayList<TipoDocumento> tiposDoc;
        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        tiposDoc = tipoDocumentoDAO.verTodos();
        tipoDocumentoDAO.cerrarConexion();
        return tiposDoc;
    }

    public static ArrayList<Rol> verRoles() throws NamingException, SQLException {
        ArrayList<Rol> roles = null;
        return roles;
    }
    
    /**
     * Consulta la cantidad de paginas necesarias para mostrar todos los
     * funcionarios
     *
     * @param idCentro Id del centro al cual se va a realizar la consulta
     * @param cantXpag Cantidad de funcionarios por pagina
     * @return la cantidad de paginas
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD o en el query de
     * la consulta
     */
    public static int verPaginasFuncionarios(String idCentro, int cantXpag) throws NamingException, SQLException {
        int paginas;
        int cantFuncionarios;
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        cantFuncionarios = funcionarioDAO.countFunctionaryCenter(idCentro);
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
     * @return
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD o en el query de
     * la consulta
     */
    public static ArrayList<Funcionario> verFuncionariosCentro(String idCentro, int pagina, int cantXpag) throws NamingException, SQLException {
        ArrayList<Funcionario> funcionarios;
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarios = funcionarioDAO.selectFunctionaryCenter(idCentro, pagina, cantXpag);
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
    public static boolean inhabilitarFuncionario(int idFuncionario) throws NamingException, SQLException {
        boolean resultado;
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        resultado = funcionarioDAO.inhabilitarFuncionario(idFuncionario);
        funcionarioDAO.cerrarConexion();

        return resultado;
    }
}
