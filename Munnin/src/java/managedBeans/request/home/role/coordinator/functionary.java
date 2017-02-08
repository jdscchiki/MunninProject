/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans.request.home.role.coordinator;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import managedBeans.session.LoggedInUser;
import modelo.Business.Coordinator;
import modelo.bean.Funcionario;
import modelo.bean.Rol;

/**
 *
 * @author Juan David Segura
 */
@Named(value = "coordinator.functionary")
@RequestScoped
public class functionary {

    //id jsf input
    private String searchId;
    private String searchDisabledId;
    private String formSearchId;

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

    @Inject
    private LoggedInUser loggedInUser;

    public functionary() {
        searchId = "search";
        formSearchId = "searchForm";
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
            if (totalPages > 10) {
                if (page > (totalPages - 5)) {
                    result = totalPages - 10;
                } else if (page > 5) {
                    result = page - 5;
                }
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return result;
    }

    public int lastLinkPage() {
        int result = 10;
        try {
            int totalPages = Coordinator.countPagesFunctionaryCenter(loggedInUser.getFuncionario().getIdCentro(), functionariesPerPage, search);

            if (totalPages > 10) {
                if (page > (totalPages - 5)) {
                    result = totalPages;
                } else if (page > 5) {
                    result = page + 5;
                }
            } else {
                result = totalPages;
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return result;
    }

    public ArrayList<Integer> ShowPagesLinks() {
        ArrayList<Integer> result = new ArrayList<>();
        int end = lastLinkPage();
        for (int i = firstLinkPage(); i < end; i++) {
            result.add(i);
        }
        return result;
    }

    public void ajaxSearchRequest() {
        String newSearch = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(formSearchId + ":" + searchId);
        String strNewPage = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("page");
        try{
            page = Integer.parseInt(strNewPage);
        }catch(Exception e){
            message = e.getMessage();
        }
        if (newSearch != null) {
            search = newSearch;
        }
        System.out.println("bandera 2");
    }

    public String getSearchDisabled() {
        return searchDisabled;
    }

    public void setSearchDisabled(String searchDisabled) {
        this.searchDisabled = searchDisabled;
    }

    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getFunctionariesPerPage() {
        return functionariesPerPage;
    }

    public void setFunctionariesPerPage(int functionariesPerPage) {
        this.functionariesPerPage = functionariesPerPage;
    }

    public String getFormSearchId() {
        return formSearchId;
    }

    public void setFormSearchId(String formSearchId) {
        this.formSearchId = formSearchId;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public String getSearchDisabledId() {
        return searchDisabledId;
    }

    public void setSearchDisabledId(String searchDisabledId) {
        this.searchDisabledId = searchDisabledId;
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

}
