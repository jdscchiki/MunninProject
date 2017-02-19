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
import modelo.bean.Funcionario;
import modelo.bean.Rol;
import util.Pager;

/**
 *
 * @author Juan David Segura
 */
@Named(value = "coordinatorFunctionary")
@RequestScoped
public class FormFunctionary {

    private String search;
    private ArrayList<Rol> roles;
    private int functionariesPerPage;
    private Integer page;

    private Integer idSelected;
    private boolean alertMessage;
    private boolean render;

    private String message;

    @Inject
    private LoggedInUser loggedInUser;

    public FormFunctionary() {
        search = "";
        functionariesPerPage = 10;
        page = 1;
        idSelected = -1;
        alertMessage = true;
        render = false;
    }

    public void deleteSelected() {
        if (idSelected <= 0) {
            message = "Es necesario seleccionar un funcionario para realizar la accion";
        } else {
            try {
                int result = Coordinator.disableFunctionary(idSelected, loggedInUser.getFuncionario().getCentro().getId());
                switch (result) {
                    case 1:
                        message = "Se ha inhabilitado el funcionario";
                        alertMessage = false;
                        break;
                    case 2:
                        message = "Es el ultimo coordinador del centro";
                }
            } catch (Exception ex) {
                message = ex.getMessage();
            }
        }
        idSelected = -1;
    }

    public ArrayList<Funcionario> viewFunctionaries() {
        ArrayList<Funcionario> result;
        try {
            result = Coordinator.viewPagerFunctionaryCenter(loggedInUser.getFuncionario().getCentro().getId(), page, functionariesPerPage, search);
        } catch (Exception e) {
            message = e.getMessage();
            result = null;
        }
        return result;
    }

    public ArrayList<Integer> showPagesLinks() {
        ArrayList<Integer> result = new ArrayList<>();
        int totalPages = 0;

        try {
            totalPages = Coordinator.countPagesFunctionaryCenter(loggedInUser.getFuncionario().getCentro().getId(), functionariesPerPage, search);
            result = Pager.showLinkedPages(page, totalPages, 10);
        } catch (Exception e) {
            message = e.getMessage();
        }

        return result;
    }

    public void changePage(int page) {
        this.page = page;
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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public ArrayList<Rol> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Rol> roles) {
        this.roles = roles;
    }

    public int getFunctionariesPerPage() {
        return functionariesPerPage;
    }

    public void setFunctionariesPerPage(int functionariesPerPage) {
        this.functionariesPerPage = functionariesPerPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

}
