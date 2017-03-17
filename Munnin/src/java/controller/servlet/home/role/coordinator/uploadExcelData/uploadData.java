/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.coordinator.uploadExcelData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import util.FileManager;

/**
 *
 * @author Juan David Segura
 */
@WebServlet(urlPatterns = {"/home/role/coordinator/uploadexceldata/uploaddata"})
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

            Part file = request.getPart("objectFile");
            String ruta = File.separator + "excel" + File.separator + "t" + System.currentTimeMillis();

            if (!FileManager.saveFileMunninServer(file, ruta)) {
                request.setAttribute("messageType", "danger");
                request.setAttribute("message", "Se ha presentado un error al guardar el archivo");
                request.getRequestDispatcher("/WEB-INF/model/message.jsp").forward(request, response);
            } else {
                String realPath = "C:" + File.separator + "MunninRepository" + File.separator + ruta + File.separator + file.getSubmittedFileName();

                Excel obj = new Excel();

                HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
                Funcionario funcionario = (Funcionario) sesion.getAttribute("usuario");
                
                ArrayList[] readResult = obj.leerArchivo(realPath, funcionario.getCentro().getId());
                
                File fichero = new File(realPath);
                fichero.delete();
                
                if (readResult[0].isEmpty() && readResult[1].isEmpty()) {
                    request.setAttribute("messageType", "danger");
                    request.setAttribute("message", "El archivo enviado no tiene ningun contenido");
                } else {
                    if (readResult[1].size() == 1) {
                        request.setAttribute("messageType", "success");
                        request.setAttribute("message", "Se ha registrado " + readResult[1].size() + " elemento correctamente");
                        request.getRequestDispatcher("/WEB-INF/model/message.jsp").include(request, response);
                    } else if (readResult[1].size() > 0) {
                        request.setAttribute("messageType", "success");
                        request.setAttribute("message", "Se han registrado " + readResult[1].size() + " elementos correctamente");
                        request.getRequestDispatcher("/WEB-INF/model/message.jsp").include(request, response);
                    }

                    String msn = "";
                    for (int i = 0; i < readResult[0].size(); i++) {
                        msn = msn + " " + readResult[0].get(i).toString();
                    }
                    
                    if (readResult[0].size() == 1) {
                        request.setAttribute("messageType", "danger");
                        request.setAttribute("message", "Se han presentado errores en la linea " + msn);
                        request.getRequestDispatcher("/WEB-INF/model/message.jsp").include(request, response);
                    } else if (readResult[0].size() > 0) {
                        request.setAttribute("messageType", "danger");
                        request.setAttribute("message", "Se han presentado errores en las lineas " + msn);
                        request.getRequestDispatcher("/WEB-INF/model/message.jsp").include(request, response);
                    }
                }

            }

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
