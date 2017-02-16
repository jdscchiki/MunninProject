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
public class FormFunctionarySearch {

    //valores
    private String search;
    private String message;
    private ArrayList<Rol> roles;
    private int functionariesPerPage;
    private Integer page;
    private boolean searchChange;

    @Inject
    private LoggedInUser loggedInUser;

    public FormFunctionarySearch() {
        functionariesPerPage = 10;
        if (page == null) {
            page = 1;
        }
        if (search == null) {
            search = "";
        }
    }

    public ArrayList<Funcionario> viewFunctionaries() {
        ArrayList<Funcionario> result;
        try {
            result = Coordinator.viewPagerFunctionaryCenter(loggedInUser.getFuncionario().getIdCentro(), page, functionariesPerPage, search);
        } catch (Exception e) {
            message = e.getMessage();
            result = null;
        }
        return result;
    }

    public ArrayList<Integer> ShowPagesLinks() {
        ArrayList<Integer> result = new ArrayList<>();
        int totalPages = 0;
        
        try {
            totalPages = Coordinator.countPagesFunctionaryCenter(loggedInUser.getFuncionario().getIdCentro(), functionariesPerPage, search);
            result = Pager.showLinkedPages(page, totalPages, 10);
        } catch (Exception e) {
            message = e.getMessage();
        }
        
        return result;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
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
