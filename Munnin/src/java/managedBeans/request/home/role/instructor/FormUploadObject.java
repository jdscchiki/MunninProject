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
        InputStream input = null;
        OutputStream output = null;
        try {
            input = file.getInputStream();
            output = new FileOutputStream(new File("C:\\Users\\Juan David Segura\\Downloads\\" + file.getSubmittedFileName()));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = input.read(bytes)) != -1) {
                output.write(bytes, 0, read);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (output != null) {
                try {
                    // outputStream.flush();
                    output.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
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
