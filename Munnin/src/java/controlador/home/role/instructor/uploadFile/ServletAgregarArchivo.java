/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.home.role.instructor.uploadFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Juan David Segura
 */
@WebServlet(name = "ServletAgregarArchivo", urlPatterns = {"/home/role/instructor/upload-file"})
//@MultipartConfig(
//        fileSizeThreshold = 1024 * 1024 * 10, // 10 MB 
//        maxFileSize = 1024 * 1024 * 50, // 50 MB
//        maxRequestSize = 1024 * 1024 * 100)   	// 100 MB
@MultipartConfig
public class ServletAgregarArchivo extends HttpServlet {

    private final static Logger LOGGER = Logger.getLogger(ServletAgregarArchivo.class.getCanonicalName());

    private static final String UPLOAD_DIR = "uploads";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String path = "C:\\Users\\Juan David Segura\\Downloads\\order";
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            writer.println("New file " + fileName + " created at " + path);
            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
                    new Object[]{fileName, path});
        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                    new Object[]{fne.getMessage()});
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
//        response.setContentType("text/html;charset=UTF-8");
//        String applicationPath = request.getServletContext().getRealPath("");
//        // constructs path of the directory to save uploaded file
//        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
//
//        // creates the save directory if it does not exists
//        File fileSaveDir = new File(uploadFilePath);
//        if (!fileSaveDir.exists()) {
//            fileSaveDir.mkdirs();
//        }
//        System.out.println("Upload File Directory=" + fileSaveDir.getAbsolutePath());
//
//        String fileName = null;
//        //Get all the parts from request and write it to the file on server
//        for (Part part : request.getParts()) {
//            fileName = getFileName(part);
//            
//            System.out.println("uploadFilePath: " + uploadFilePath);
//            System.out.println("file.Separator: " + File.separator);
//            System.out.println("fileName: " + fileName);
//            
//            part.write(fileName);
//        }
//        System.out.println("bandera");
//
//        request.setAttribute("message", fileName + " File uploaded successfully!");
//        getServletContext().getRequestDispatcher("/home/role/instructor/uploadFile.jsp").forward(request, response);
    }

    private String getFileName(Part part) {
//        String contentDisp = part.getHeader("content-disposition");
//        System.out.println("content-disposition header= " + contentDisp);
//        String[] tokens = contentDisp.split(";");
//        for (String token : tokens) {
//            if (token.trim().startsWith("filename")) {
//                return token.substring(token.indexOf("=") + 2, token.length() - 1);
//            }
//        }
//        return "";
        final String partHeader = part.getHeader("content-disposition");
        
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
