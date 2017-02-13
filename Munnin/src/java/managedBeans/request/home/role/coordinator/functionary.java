/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans.request.home.role.coordinator;

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
public class functionary {

    //valores
    private int idFunctionary;
    private int idFunctionaryDisabled;
    private String search;
    private String searchDisabled;
    private String operation;
    private String message;
    private ArrayList<Rol> roles;
    private int functionariesPerPage;
    private Integer page;
    private boolean searchChange;

    @Inject
    private LoggedInUser loggedInUser;

    public functionary() {
        functionariesPerPage = 10;
        if (page == null) {
            page = 1;
        }
        if (search == null) {
            search = "";
        }
        idFunctionary = 0;
        idFunctionaryDisabled = 0;
        searchDisabled = "";
        operation = "";
    }

    public ArrayList<Funcionario> viewContentEnabledFunctionaries() {
        ArrayList<Funcionario> result;
        try {
            result = Coordinator.viewPagerFunctionaryCenter(loggedInUser.getFuncionario().getIdCentro(), page, functionariesPerPage, search);
        } catch (Exception e) {
            message = e.getMessage();
            result = null;
        }
        return result;
    }

    public ArrayList<Funcionario> viewContentDisabledFunctionaries() {
        ArrayList<Funcionario> result;
        try {
            result = Coordinator.viewDisabledFunctionary(loggedInUser.getFuncionario().getIdCentro(), searchDisabled);
        } catch (Exception e) {
            message = e.getMessage();
            result = null;
        }

        return result;
    }

    public int firstLinkPage() {
        int result = 1;

        try {
            int totalPages = Coordinator.countPagesFunctionaryCenter(loggedInUser.getFuncionario().getIdCentro(), functionariesPerPage, search);

            result = Pager.firstPage(page, totalPages, 10);
        } catch (Exception e) {
            message = e.getMessage();
        }
        return result;
    }

    public int lastLinkPage() {
        int result = 10;
        try {
            int totalPages = Coordinator.countPagesFunctionaryCenter(loggedInUser.getFuncionario().getIdCentro(), functionariesPerPage, search);

            result = Pager.lastPage(page, totalPages, 10);
        } catch (Exception e) {
            message = e.getMessage();
        }
        return result;
    }

    public ArrayList<Integer> ShowPagesLinks() {
        ArrayList<Integer> result = new ArrayList<>();
        int end = lastLinkPage();
        for (int i = firstLinkPage(); i <= end; i++) {
            result.add(i);
        }
        return result;
    }

    public int getIdFunctionary() {
        return idFunctionary;
    }

    public void setIdFunctionary(int idFunctionary) {
        this.idFunctionary = idFunctionary;
    }

    public int getIdFunctionaryDisabled() {
        return idFunctionaryDisabled;
    }

    public void setIdFunctionaryDisabled(int idFunctionaryDisabled) {
        this.idFunctionaryDisabled = idFunctionaryDisabled;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearchDisabled() {
        return searchDisabled;
    }

    public void setSearchDisabled(String searchDisabled) {
        this.searchDisabled = searchDisabled;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public boolean isSearchChange() {
        return searchChange;
    }

    public void setSearchChange(boolean searchChange) {
        this.searchChange = searchChange;
    }

    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
