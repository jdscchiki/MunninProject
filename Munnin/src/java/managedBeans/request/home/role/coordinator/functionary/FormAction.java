/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans.request.home.role.coordinator.functionary;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.ejb.PostActivate;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import managedBeans.session.LoggedInUser;
import modelo.Business.Coordinator;

/**
 *
 * @author Juan David Segura
 */
@Named(value = "coordinatorFunctionaryFormAction")
@RequestScoped
public class FormAction {

    private Integer idSelected;
    private String action;
    private boolean alertMessage;
    private boolean render;

    private String message;

    @Inject
    private LoggedInUser loggedInUser;

    public FormAction() {
        if (idSelected == null) {
            idSelected = -1;
        }
        if (action == null) {
            action = "none";
        }
        alertMessage = true;
        render = false;
    }

    
    public boolean selectAction() {
        if (idSelected <= 0) {
            message = "Es necesario seleccionar un funcionario para realizar la accion: " + idSelected;
        } else {
            switch (action) {
                case "disable":
                    deleteSelected();
                    break;
                default:
                    message = "ha ocurrido un error, por favor vuelve a cargar la pagina";
                    break;
            }
        }

        //FacesContext.getCurrentInstance().getExternalContext().dispatch("formFunctionaryActionMessage.xhtml");
        //FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "formFunctionaryActionMessage.xhtml?faces-redirect=true");
        //return "formFunctionaryActionMessage.xhtml?faces-redirect=true";
        if (!render) {
            render = true;
            return false;
        }
        return true;

    }

    public void deleteSelected() {

        try {
            int result = Coordinator.disableFunctionary(idSelected, loggedInUser.getFuncionario().getCentro().getId());
            switch (result) {
                case 1:
                    message = "Se ha inhabilitado el funcionario";
                    alertMessage = false;
                    break;
                case 2:
                    message = "es el ultimo coordinador del centro";
            }
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(boolean alertMessage) {
        this.alertMessage = alertMessage;
    }

    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    public Integer getIdSelected() {
        return idSelected;
    }

    public void setIdSelected(Integer idSelected) {
        this.idSelected = idSelected;
    }

}
