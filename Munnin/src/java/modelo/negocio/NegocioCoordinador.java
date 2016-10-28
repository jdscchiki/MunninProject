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
import util.ContrasenaGenerator;
import util.Mail;
import modelo.dao.FuncionarioDAO;

/**
 *
 * @author Juan David Segura Castro <JBadCode>
 */
public class NegocioCoordinador {
    
    public static boolean registarFuncionario(Funcionario funcionario, String idCentro) throws Encriptado.CannotPerformOperationException, NamingException, SQLException{
        boolean resultado = false;
        funcionario.setIdCentro(idCentro);
        String contrasena = ContrasenaGenerator.GenerarContrasena();
        funcionario.setContrasena(Encriptado.createHash(contrasena));
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        if(funcionarioDAO.registrar(funcionario)){
            funcionario.setContrasena(null);
            if(Mail.enviarContrasena(funcionario, contrasena)){
                resultado = true;
            }
        }
        return resultado;
    }
    
    public static ArrayList<TipoDocumento> verTiposDocumentos() throws NamingException, SQLException{
        ArrayList<TipoDocumento> tiposDoc;
        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        tiposDoc = tipoDocumentoDAO.verTodos();
        return tiposDoc;
    }
}
