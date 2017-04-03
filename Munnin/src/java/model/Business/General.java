/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.bean.Funcionario;
import model.bean.Notificacion;
import model.bean.Rol;
import model.dao.FuncionarioDAO;
import model.dao.NotificacionDAO;
import util.security.Encrypt;
import util.security.PassGenerator;

/**
 * Clase dedicada a ejecutar las reglas de negocio de los usiarios de cualquier
 * rol
 *
 * @author Juan David Segura Castro
 */
public class General {

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
     * @throws util.Encriptado.CannotPerformOperationException Error al
     * encriptar la contraseña, revisar la version de java
     * @throws util.Encriptado.InvalidHashException Error al verificar la
     * contraseña, revisar los datos almacenados en la base de datos y
     * comprarlos con el funcionamiento de la aplicacion
     */
    public static Funcionario verifyFunctionary(String correo, String contrasena) throws NamingException, SQLException, Encrypt.CannotPerformOperationException, Encrypt.InvalidHashException {
        Funcionario funcionarioLog;
        FuncionarioDAO consulta = new FuncionarioDAO();
        funcionarioLog = consulta.selectFunctionaryByMail(correo);
        if (funcionarioLog != null) {
            if (!Encrypt.verifyPassword(contrasena, funcionarioLog.getContrasena())) {
                funcionarioLog = null;
            } else {
                ArrayList<Rol> roles = consulta.selectRolesFunctionary(funcionarioLog.getId());
                if (roles != null) {
                    funcionarioLog.setRoles(roles);
                }
                funcionarioLog.setContrasena(null);
            }
        }

        consulta.closeConnection();
        return funcionarioLog;
    }

    public static boolean[] changePassword(String email, String password, String newPassword) throws NamingException, SQLException, Encrypt.CannotPerformOperationException, Encrypt.InvalidHashException {
        /*
        result es un arreglo de booleanos en el que cada indice significan lo siguiente:
        
        0. para ver si se completo toda la operacion
        1. si la contraseña vieja coincide con la entregada por el usuario
        2. comprueban la seguridad de la contraseña
        3-6. muestran que cosas hacen falta para que la contraseña sea segura
         */
        boolean[] result = {false, false, false, false, false, false, false};

        Funcionario funcionario = verifyFunctionary(email, password);
        if (funcionario != null) {
            result[1] = true;
            if (PassGenerator.isSecure(newPassword)) {
                result[2]=true;
                FuncionarioDAO consulta = new FuncionarioDAO();
                if (consulta.changePassword(funcionario.getId(), Encrypt.createHash(newPassword))) {
                    result[0] = true;
                }
                consulta.closeConnection();
            } else {
                if(PassGenerator.hasNumber(newPassword)){
                    result[3]=true;
                }
                if(PassGenerator.hasLowercase(newPassword)){
                    result[4]=true;
                }
                if(PassGenerator.hasUppercase(newPassword)){
                    result[5]=true;
                }
                if(PassGenerator.isSecureLong(newPassword)){
                    result[6]=true;
                }
            }
        }
        return result;
    }
    
    public static int countPagesNotifications(int idFunctionary, int resultsInPage, int idRole) throws NamingException, SQLException{
        int result = 0;
        
        int quantityNotifications;
        NotificacionDAO notificacionDAO = new NotificacionDAO();
        quantityNotifications = notificacionDAO.countNotificationFunctionary(idFunctionary, idRole);
        notificacionDAO.closeConnection();

        result = quantityNotifications / resultsInPage;
        if (quantityNotifications % resultsInPage != 0) {
            result++;
        }
        
        return result;
    }
    
    public static ArrayList<Notificacion> viewNotifications(int idFunctionary, int resultsInPage, int page, int idRole) throws NamingException, SQLException{
        ArrayList<Notificacion> result;
        
        NotificacionDAO notificacionDAO = new NotificacionDAO();
        result = notificacionDAO.selectNotificationFunctionary(idFunctionary, idRole, resultsInPage, page);
        notificacionDAO.closeConnection();
        
        for (Notificacion notificacion : result) {
            notificacion.getMensaje().setTexto(util.message.MessageGenerator.menssageRole(notificacion));
        }

        return result;
    }
    
    public static int checkNotification(Notificacion notificacion) throws NamingException, SQLException{
        int result = 0;
        
        NotificacionDAO notificacionDAO = new NotificacionDAO();
        if(notificacionDAO.markAsSeen(notificacion)){
            result = 1;
        }
        notificacionDAO.closeConnection();
        
        return result;
    }
}
