/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.coordinator.uploadExcelData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Business.Excel;
import model.bean.Funcionario;

/**
 *
 * @author Juan David Segura
 */
@WebServlet(urlPatterns = {"/home/role/coordinator/uploadExcelData/uploadData"})
//@MultipartConfig(
//        fileSizeThreshold = 1024 * 1024 * 10, // 10 MB 
//        maxFileSize = 1024 * 1024 * 50, // 50 MB
//        maxRequestSize = 1024 * 1024 * 100)   	// 100 MB
@MultipartConfig
public class uploadData extends HttpServlet {
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
        try {            
            InputStream input = null;
            OutputStream output = null;
            Excel obj = new Excel();
            String ruta="";
            try {
                Part file = request.getPart("objectFile");
                input = file.getInputStream();
                ruta = "D:\\Sergio\\archivos\\" + file.getSubmittedFileName();
                output = new FileOutputStream(new File("D:\\Sergio\\archivos\\" + file.getSubmittedFileName()));
                int read = 0;
                byte[] bytes = new byte[1024];

                while ((read = input.read(bytes)) != -1) {
                    output.write(bytes, 0, read);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + "1");
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage()+"2");
                    }
                }
                if (output != null) {
                    try {
                        // outputStream.flush();
                        output.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage()+"3");
                    }

                }
            }
            HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
            Funcionario funcionario = (Funcionario) sesion.getAttribute("usuario");
            obj.leerArchivo(ruta, funcionario.getIdCentro());
            File fichero = new File(ruta);
            fichero.delete();
            request.setAttribute("messageType", "success");
            request.getRequestDispatcher("/home/role/instructor/uploadExcelData.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensaje", e);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
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
