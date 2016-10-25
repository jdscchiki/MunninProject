/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;
import java.sql.SQLException;
import javax.naming.NamingException;
import modelo.bean.Funcionario;
import modelo.dao.FuncionarioDAO;
import util.Encriptado;

/**
 * Clase dedicada a Procesar los datos recividos en ServletLogin
 * 
 * @author Juan David Segura Castro <JBadCode>
 */
public class LoginClass {
    /**
     * Verifica si la contraseña correspondiente al correo del funcionario es correcta
     * 
     * @param correo
     * @param contrasena
     * @return Datos funcionario, si es correcto, null si la contraseña o funcionario no son los correctos
     * @throws NamingException
     * @throws SQLException
     * @throws util.Encriptado.CannotPerformOperationException
     * @throws util.Encriptado.InvalidHashException 
     */
    public static Funcionario verificarFuncionario(String correo, String contrasena) throws NamingException, SQLException, Encriptado.CannotPerformOperationException, Encriptado.InvalidHashException {
        Funcionario funcionarioLog;
        FuncionarioDAO consulta = new FuncionarioDAO();
        funcionarioLog = consulta.buscarFuncionarioCorreo(correo);
        if(funcionarioLog != null){
            if(!Encriptado.verifyPassword(contrasena, funcionarioLog.getContrasena())){
                funcionarioLog = null;
            }else{
                funcionarioLog.setContrasena(null);
            }
        }
        return funcionarioLog;
    }
    
}
