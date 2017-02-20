/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans.request.home.role.coordinator.functionary;

import java.util.ArrayList;
import java.util.Arrays;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import managedBeans.session.LoggedInUser;
import modelo.Business.Coordinator;
import modelo.bean.Funcionario;
import modelo.bean.Rol;
import modelo.dao.RolDAO;
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
    private String message;
    private String modalMessage;

    private Funcionario selectedFuncionary;
    private int[] idSelectedRoles;
    private boolean renderChangeRole;

    @Inject
    private LoggedInUser loggedInUser;

    public FormFunctionary() {
        search = "";
        functionariesPerPage = 10;
        page = 1;
        idSelected = -1;
        alertMessage = true;

        System.out.println("render:"+renderChangeRole);
        renderChangeRole = false;
    }

    public void saveChangeRole() {
        
        ArrayList<String> rolesChanged = new ArrayList<>();
        try {
            for (int i = 0; i < idSelectedRoles.length; i++) {
                rolesChanged.add("" + idSelectedRoles[i]);
            }
            int resultCase = Coordinator.AssignRoles(selectedFuncionary.getId(), rolesChanged);
            switch(resultCase){
                case 1:
                    modalMessage = "Operacion existosa";
                    alertMessage = false;
                    break;
                default:
                    modalMessage = "Ha ocurrido un problema durante la operacion";
                    alertMessage = true;
            }
            renderChangeRole = true;
        } catch (Exception e) {
            message = e.getMessage();
        }
    }

    public void changeRoleSelected() {
        if (idSelected <= 0) {
            message = "Es necesario seleccionar un funcionario para realizar la accion";
        } else {
            try {
                selectedFuncionary = Coordinator.viewAllInfoFunctionary(idSelected);
                idSelectedRoles = new int[selectedFuncionary.getRoles().size()];
                for (int i = 0; i < selectedFuncionary.getRoles().size(); i++) {
                    if (selectedFuncionary.getRoles().get(i).getId() != RolDAO.ID_ADMINISTRADOR) {
                        idSelectedRoles[i] = selectedFuncionary.getRoles().get(i).getId();
                    }
                }
            } catch (Exception e) {
                message = e.getMessage();
            }
            renderChangeRole = true;
        }
        idSelected = -1;
    }

    public ArrayList<Rol> viewRoles() {
        ArrayList<Rol> result = new ArrayList<>();
        try {
            result = Coordinator.viewRoles();
        } catch (Exception e) {
            message = "lo sentimos ha ocurrido un error";
        }
        return result;
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
        System.out.println("render: "+renderChangeRole);
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

    public boolean isRenderChangeRole() {
        return renderChangeRole;
    }

    public void setRenderChangeRole(boolean renderChangeRole) {
        this.renderChangeRole = renderChangeRole;
    }

    public Funcionario getSelectedFuncionary() {
        return selectedFuncionary;
    }

    public void setSelectedFuncionary(Funcionario selectedFuncionary) {
        this.selectedFuncionary = selectedFuncionary;
    }

    public String getModalMessage() {
        return modalMessage;
    }

    public void setModalMessage(String modalMessage) {
        this.modalMessage = modalMessage;
    }

    public int[] getIdSelectedRoles() {
        return idSelectedRoles;
    }

    public void setIdSelectedRoles(int[] idSelectedRoles) {
        this.idSelectedRoles = idSelectedRoles;
    }

}
