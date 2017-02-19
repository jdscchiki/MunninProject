/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans.request.home.role.coordinator.functionary;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import managedBeans.session.LoggedInUser;
import modelo.Business.Coordinator;
import modelo.bean.TipoDocumento;

/**
 *
 * @author Juan David Segura
 */
@Named(value = "coordinatorFunctionaryFormRegister")
@RequestScoped
public class FormRegister {

    private int idDocumentType;
    private String document;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumbre;

    private String message;

    @Inject
    private LoggedInUser loggedInUser;

    public FormRegister() {
        idDocumentType = 1;
    }

    public ArrayList<TipoDocumento> showDocumentTypes() {
        ArrayList<TipoDocumento> result = new ArrayList<>();
        try {
            result = Coordinator.viewDocumentType();
        } catch (Exception e) {
            message = e.getMessage();
        }
        return result;
    }

    public int getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(int idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumbre() {
        return phoneNumbre;
    }

    public void setPhoneNumbre(String phoneNumbre) {
        this.phoneNumbre = phoneNumbre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
