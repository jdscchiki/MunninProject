/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans.session;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import modelo.bean.Funcionario;

/**
 *
 * @author Juan David Segura
 */
@Named(value = "loggedInUser")
@SessionScoped
public class LoggedInUser implements Serializable {

    private Funcionario funcionario;
    
    public void LogoutUser(){
        funcionario = null;
    }
    
    public LoggedInUser() {
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
