/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans.request.home.role.instructor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import javax.servlet.http.Part;

import modelo.Business.Excel;
import util.Encriptado;

/**
 *
 * @author Sergio
 */

@Named(value = "instructorFormUploadExcelData")
@RequestScoped
public class FormUploadExcelData {
    
    private Part file;
    private String message;
    private String ruta;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    Excel obj = new Excel();
    
    public FormUploadExcelData(){
        
    }
    
    public void upload() throws IOException, Encriptado.CannotPerformOperationException, NamingException, SQLException, UnsupportedEncodingException, MessagingException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = file.getInputStream();
            ruta = "D:\\Sergio\\archivos\\" + file.getSubmittedFileName();
            output = new FileOutputStream(new File("D:\\Sergio\\archivos\\" + file.getSubmittedFileName()));
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
        obj.leerArchivo(this.getRuta());
        File fichero = new File(ruta);
        fichero.delete();
    }
}
