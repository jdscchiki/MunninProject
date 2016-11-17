/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;

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
 * clase dedicada a la logica de negocio usada por el coordinador
 *
 * @author Juan David Segura Castro 
 *
 */
public class NegocioCoordinador {

    /**
     * registro de funcionarios con la logica de un admin
     *
     * @param funcionario Datos del funcionario a registrar
     * @param idCentro Id del centro en que va a ser registrado
     * @return True si la operacion fue completada
     * @throws util.Encriptado.CannotPerformOperationException Error al realizar la encriptacion de la contraseña, verificar la version de java
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     * @throws java.io.UnsupportedEncodingException Problemas con los Correos de origen
     * @throws javax.mail.MessagingException Problemas con el Correo de destino
     */
    public static boolean registarFuncionario(Funcionario funcionario, String idCentro) throws Encriptado.CannotPerformOperationException, NamingException, SQLException, UnsupportedEncodingException, MessagingException {
        boolean resultado = false;
        funcionario.setIdCentro(idCentro);
        String contrasena = PassGenerator.getSecurePassword();
        funcionario.setContrasena(Encriptado.createHash(contrasena));
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        if (funcionarioDAO.registrar(funcionario)) {
            funcionario.setContrasena(null);
            funcionarioDAO.cerrarConexion();
            if (Mail.enviarPrimeraContrasena(funcionario, contrasena)) {
                resultado = true;
            }
        }
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
    
    public static int verPaginasFuncionarios(String idCentro, int cantXpag)  throws NamingException, SQLException {
        int paginas;
        int cantFuncionarios;
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        cantFuncionarios = funcionarioDAO.conteoFuncionariosCentro(idCentro);
        funcionarioDAO.cerrarConexion();
        paginas = cantFuncionarios / cantXpag;
        if(cantFuncionarios % cantXpag > 0){
            paginas ++;
        }
        return paginas;
    }
    
    public static ArrayList<Funcionario> verFuncionariosCentro(String idCentro, int pagina, int cantXpag)  throws NamingException, SQLException {
        ArrayList<Funcionario> funcionarios;
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarios = funcionarioDAO.verFuncionariosCentro(idCentro, pagina, cantXpag);
        funcionarioDAO.cerrarConexion();
        return funcionarios;
    }
}
