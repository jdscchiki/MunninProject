/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans.request;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import managedBeans.session.LoggedInUser;
import modelo.Business.General;
import modelo.bean.Funcionario;

/**
 *
 * @author Juan David Segura
 */
@Named(value = "formLogin")
@RequestScoped
public class FormLogin {

    private String mail;
    private String password;
    private String menssage;

    @Inject
    private LoggedInUser loggedInUser;

    public void doLogin() throws IOException {
        try {
            Funcionario tryLogin = General.verifyFunctionary(mail, password);
            if (tryLogin == null) {
                menssage = "Usuario o contraseña incorrecta";
            } else {
                loggedInUser.setFuncionario(tryLogin);
                FacesContext.getCurrentInstance().getExternalContext().redirect("home/index.xhtml");
            }
        } catch (Exception e) {
            menssage = "error: " + e;
        }

    }

    public FormLogin() {
    }

    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }
}
