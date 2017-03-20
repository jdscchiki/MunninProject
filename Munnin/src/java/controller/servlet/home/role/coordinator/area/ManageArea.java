/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.coordinator.area;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Business.Coordinator;
import model.bean.Area;
import model.bean.Funcionario;

/**
 *
 * @author Juan David Segura Castro
 */
@WebServlet(urlPatterns = {"/home/role/coordinator/area/manage"})
public class ManageArea extends HttpServlet {

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
            String idArea = request.getParameter("id");
            int idAre;
            String opcion = request.getParameter("action");
            idAre = Integer.parseInt(idArea);
            if (idAre <= 0) {
                request.setAttribute("messageType", "warning");
                request.setAttribute("message", "Para realizar la operación es necesario seleccionar una de las areas");
            } else {
                switch (opcion) {
                    case "disable":
                        HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
                        Funcionario funcionario = (Funcionario) sesion.getAttribute("usuario");
                        String idCentro = funcionario.getCentro().getId();
                        switch (Coordinator.disableArea(idAre, idCentro)) {
                            case 0:
                                request.setAttribute("messageType", "danger");
                                request.setAttribute("message", "El area no ha podido ser inhabilitada");
                                break;
                            case 1:
                                request.setAttribute("messageType", "success");
                                request.setAttribute("message", "El area fue inhabilitada exitosamente");
                                break;
                            case 2:
                                request.setAttribute("messageType", "danger");
                                request.setAttribute("message", "Solo queda un area habilitada para el centro");
                                break;
                        }
                        break;
                    case "editArea":
                        Area areaResult = Coordinator.viewAllInfoArea(idAre);
                        request.setAttribute("area", areaResult);
                        request.getRequestDispatcher("/home/role/coordinator/area/modalEditArea.jsp").forward(request, response);
                        return;
                    default:
                        request.setAttribute("messageType", "danger");
                        request.setAttribute("message", "no ha podido ser completada la accion");
                        break;
                }
            }
            request.getRequestDispatcher("/WEB-INF/model/message.jsp").forward(request, response);
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
