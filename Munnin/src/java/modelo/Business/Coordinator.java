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
     * @return un entero entre 0 y 5.
     *  0 fallo.
     *  1 completado.
     *  2 existe un usuario activo con los datos ingresados.
     *  3 existe un usuario no-activo con el mismo correo.
     *  4 existe un usuario no-activo con el mismo documento.
       5 el correo no pudo ser enviado.
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
        
        if (funcionarioDAO.isActiveFunctionary(funcionario.getCorreo(), funcionario.getIdTipoDocumento(), funcionario.getDocumento())) {
            resultado = 2;
        } else {
            if (funcionarioDAO.existFunctionaryMail(funcionario.getCorreo())) {
                resultado = 3;
            } else if (funcionarioDAO.existFunctionaryDocument(funcionario.getDocumento(), funcionario.getIdTipoDocumento())) {
                resultado = 4;
            } else {
                if (funcionarioDAO.registerFunctionary(funcionario)) {
                    funcionario.setContrasena(null);
                    if (Mail.enviarPrimeraContrasena(funcionario, contrasena)) {
                        resultado = 1;
                    }else{
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
     * @throws SQLException Error en el constructor ConexionBD
     */
    public static ArrayList<TipoDocumento> verTiposDocumentos() throws NamingException, SQLException {
        ArrayList<TipoDocumento> tiposDoc;
        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        tiposDoc = tipoDocumentoDAO.verTodos();
        tipoDocumentoDAO.cerrarConexion();
        return tiposDoc;
    }

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

    public static ArrayList<Funcionario> verFuncionariosCentro(String idCentro, int pagina, int cantXpag) throws NamingException, SQLException {
        ArrayList<Funcionario> funcionarios;
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarios = funcionarioDAO.selectFunctionaryCenter(idCentro, pagina, cantXpag);
        funcionarioDAO.cerrarConexion();
        return funcionarios;
    }

    public static boolean inhabilitarFuncionario(int idFuncionario) throws NamingException, SQLException {
        boolean resultado;
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        resultado = funcionarioDAO.inhabilitarFuncionario(idFuncionario);
        funcionarioDAO.cerrarConexion();

        return resultado;
    }
}
