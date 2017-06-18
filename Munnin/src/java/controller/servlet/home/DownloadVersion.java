/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Business.General;
import model.bean.Version;

/**
 *
 * @author Juan David Segura
 */
@WebServlet(urlPatterns = {"/home/download"})
public class DownloadVersion extends HttpServlet {

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
        String strIdVersion = request.getParameter("idVersion");
        int idVersion = 0;
        int license;
        if (request.getAttribute("license") != null) {
            license = (int) request.getAttribute("license");
        } else {
//            response.setContentType("text/html");
//            request.setAttribute("mensaje", "No posee los permisos para realizar esta acción");
//            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        license = 1;
        try {
            idVersion = Integer.parseInt(strIdVersion);

            Version version = new Version();
            version.setId(idVersion);
            String urlVersion = General.viewUrlVersion(version);
            if (urlVersion == null) {
                response.setContentType("text/html;charset=UTF-8");
                request.setAttribute("mensaje", "No se ha encontrado una version con el id = " + idVersion);
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            } else {
                FileInputStream inStream = null;
                OutputStream outStream = null;
                try {
                    File downloadFile = new File(urlVersion);
                    inStream = new FileInputStream(downloadFile);

                    // obtains ServletContext
                    ServletContext context = getServletContext();

                    // gets MIME type of the file
                    String mimeType = context.getMimeType(urlVersion);
                    if (mimeType == null) {
                        // set to binary type if MIME mapping not found
                        mimeType = "application/octet-stream";
                    }

                    // modifies response
                    response.setContentType(mimeType);
                    response.setContentLength((int) downloadFile.length());

                    // forces download
                    String headerKey = "Content-Disposition";
                    String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
                    response.setHeader(headerKey, headerValue);

                    // obtains response's output stream
                    outStream = response.getOutputStream();

                    byte[] buffer = new byte[1024];
                    int bytesRead = -1;

                    while ((bytesRead = inStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }
                } catch (IOException exception) {
                    response.setContentType("text/html;charset=UTF-8");
                    request.setAttribute("mensaje", exception);
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                } finally {
                    if (inStream != null) {
                        inStream.close();
                    }
                    if (outStream != null) {
                        outStream.close();
                    }
                }
            }
        } catch (Exception e) {
            response.setContentType("text/html;charset=UTF-8");
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
