/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.coordinator.categories;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Business.Coordinator;
import model.bean.Categoria;
import model.bean.Funcionario;

/**
 *
 * @author Monica
 */
@WebServlet(urlPatterns = {"/home/role/coordinator/categories/manage"})
public class Manage extends HttpServlet {

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
            String idCategoria = request.getParameter("id");
            int idCate;
            String opcion = request.getParameter("action");
            idCate = Integer.parseInt(idCategoria);
            if (idCate <= 0) {
                request.setAttribute("messageType", "warning");
                request.setAttribute("message", "Para realizar la operación es necesario seleccionar una de las categorias");
            } else {
                switch (opcion) {
                    case "disable":
                        HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
                        Funcionario funcionario = (Funcionario) sesion.getAttribute("usuario");
                        String idCentro = funcionario.getCentro().getId();
                        switch (Coordinator.disableCategories(idCate, idCentro)) {
                            case 0:
                                request.setAttribute("messageType", "danger");
                                request.setAttribute("message", "La categoria no ha podido ser inhabilitada");
                                break;
                            case 1:
                                request.setAttribute("messageType", "success");
                                request.setAttribute("message", "La categoria fue inhabilitada exitosamente");
                                break;
                            case 2:
                                request.setAttribute("messageType", "danger");
                                request.setAttribute("message", "Solo queda una categoria habilitada para el centro");
                                break;
                        }
                        break;
                    case "editCategories":
                        Categoria categoriaResult = Coordinator.viewAllInfoCategories(idCate);
                        request.setAttribute("categories", categoriaResult);
                        request.getRequestDispatcher("/home/role/coordinator/categories/modalEdit.jsp").forward(request, response);
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
