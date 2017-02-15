/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans.request.home.role.instructor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import util.FileManager;

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

    public FormUploadObject() {

    }

    public void upload() {
        if(FileManager.saveFile(file, "C:\\Users\\Juan David Segura\\Downloads\\test")){
            message = "se guardo correctamente el archivo";
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

}
