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
import modelo.bean.Rol;
import modelo.dao.FuncionarioDAO;
import util.Encriptado;

/**
 * Clase dedicada a Procesar los datos recividos en ServletLogin
 *
 * @author Juan David Segura Castro 
 */
public class NegocioLogin {

    /**
     * Verifica si la contraseña correspondiente al correo del funcionario es
     * correcta
     *
     * @param correo Correo usado para ingresar al aplicativo
     * @param contrasena Contraseña usado para ingresar al aplicativo
     * @return Datos funcionario, si es correcto, null si la contraseña o
     * funcionario no son los correctos
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     * @throws util.Encriptado.CannotPerformOperationException Error al encriptar la contraseña, revisar la version de java
     * @throws util.Encriptado.InvalidHashException Error al verificar la contraseña, revisar los datos almacenados en la base de datos y comprarlos con el funcionamiento de la aplicacion
     */
    public static Funcionario verificarFuncionario(String correo, String contrasena) throws NamingException, SQLException, Encriptado.CannotPerformOperationException, Encriptado.InvalidHashException {
        Funcionario funcionarioLog;
        FuncionarioDAO consulta = new FuncionarioDAO();
        funcionarioLog = consulta.buscarFuncionarioCorreo(correo);
        if (funcionarioLog != null) {
            if (!Encriptado.verifyPassword(contrasena, funcionarioLog.getContrasena())) {
                funcionarioLog = null;
            } else {
                ArrayList<Rol> roles = consulta.verRoles(funcionarioLog.getId());
                if (roles != null) {
                    funcionarioLog.setRoles(roles);
                }
                funcionarioLog.setContrasena(null); 
            }
        }
        
        consulta.cerrarConexion();
        return funcionarioLog;
    }
    
    public static Funcionario verificarContrasena(String correo, String contrasena) throws NamingException, SQLException, Encriptado.CannotPerformOperationException, Encriptado.InvalidHashException {        
        Funcionario funcionarioLog;
        FuncionarioDAO consulta = new FuncionarioDAO();
        funcionarioLog = consulta.buscarFuncionarioCorreo(correo);
        if (funcionarioLog != null) {
            if (!Encriptado.verifyPassword(contrasena, funcionarioLog.getContrasena())) {
                funcionarioLog = null;
            } else {
                ArrayList<Rol> roles = consulta.verRoles(funcionarioLog.getId());
                if (roles != null) {
                    funcionarioLog.setRoles(roles);
                }
            }
        }        
        consulta.cerrarConexion();
        return funcionarioLog;
    }
    
    public static boolean cambioContrasena(int id, String contrasena) throws NamingException, SQLException, Encriptado.CannotPerformOperationException, Encriptado.InvalidHashException {                
        boolean resultado;
        FuncionarioDAO consulta = new FuncionarioDAO();
        resultado = consulta.cambioContra(id, Encriptado.createHash(contrasena));
        consulta.cerrarConexion();
        return resultado;
    }
}
