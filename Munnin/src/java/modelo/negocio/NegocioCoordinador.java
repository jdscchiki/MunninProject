/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
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
     */
    public static boolean registarFuncionario(Funcionario funcionario, String idCentro) throws Encriptado.CannotPerformOperationException, NamingException, SQLException {
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
}
