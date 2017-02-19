/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans.request.home.role.instructor;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import managedBeans.session.LoggedInUser;
import modelo.Business.Instructor;
import modelo.bean.Producto;
import modelo.bean.TipoObjetoAprendizaje;

/**
 *
 * @author Juan David Segura
 */
@Named(value = "instructorFormUploadObject")
@RequestScoped
public class FormUploadObject {

    private String name;
    private String description;
    private String keywords;
    private int objectTipe;
    private Part file;
    private String message;
    private boolean alertMessage;

    @Inject
    private LoggedInUser loggedInUser;

    public FormUploadObject() {
        alertMessage = true;
    }

    public void upload() {
        Producto producto = new Producto();
        producto.setNombre(name);
        producto.setDescripcion(description);
        producto.setPalabrasClave(keywords);
        producto.setTipoObjetoAprendizaje(new TipoObjetoAprendizaje());
        producto.getTipoObjetoAprendizaje().setId(1);
        
        try {
            int operationResult = Instructor.uploadNewLearningObject(file, producto, loggedInUser.getFuncionario().getCentro().getId());
            switch(operationResult){
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                    message = "Lo sentimos ha ocurrido un problema, por favor vuelva a intentarlo";
                    alertMessage = true;
                    break;
                case 1:
                    message = "Se ha subido satisfactoriamente el objeto de aprendizaje ";
                    alertMessage = false;
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getObjectTipe() {
        return objectTipe;
    }

    public void setObjectTipe(int objectTipe) {
        this.objectTipe = objectTipe;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public boolean isAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(boolean alertMessage) {
        this.alertMessage = alertMessage;
    }

    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

}
