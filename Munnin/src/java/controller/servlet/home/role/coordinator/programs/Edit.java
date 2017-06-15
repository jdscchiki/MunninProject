/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.coordinator.programs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Business.Coordinator;
import model.bean.Programa;

/**
 * Servlet encargado de editar los valores guardados en base de datos sobre las
 * áreas de un centro
 *
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/home/role/coordinator/programs/edit"})
public class Edit extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try {
            String nombre = request.getParameter("nombre");
            String id = request.getParameter("id");

            Programa edit = new Programa();
            edit.setNombre(nombre);
            edit.setId(Integer.parseInt(id));
            switch (Coordinator.updateProgram(edit)) {
                case 0:
                    request.setAttribute("messageType", "danger");
                    request.setAttribute("message", "no ha podido realizarse la edicion");
                    break;
                case 1:
                    request.setAttribute("messageType", "success");
                    request.setAttribute("message", "la edicion se ha completado exitosamente");
                    break;
            }
            request.getRequestDispatcher("/WEB-INF/model/message.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("message", "ha ocurrido un problema, por favor vuelva a cargar la pagina");
            request.getRequestDispatcher("/WEB-INF/model/message.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("mensaje", ex);
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
