/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.technical.files;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Business.Coordinator;
import model.bean.Funcionario;
import model.bean.Item;
import model.bean.Lista;
import model.bean.Rol;
import model.bean.Version;

/**
 *
 * @author Juan David Segura Castro
 */
@WebServlet(urlPatterns = {"/home/role/technical/files/manage"})
public class ManageFile extends HttpServlet {

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
            String idFuncionario = request.getParameter("id");
            int idItem;
            String opcion = request.getParameter("action");

            idItem = Integer.parseInt(idFuncionario);
            if (idItem <= 0) {
                request.setAttribute("messageType", "warning");
                request.setAttribute("message", "Para realizar la operación es necesario seleccionar uno de los archivos");
            } else {
                switch (opcion) {
                    case "calificarArchivo":
                        Version versionResult = Coordinator.viewAllInfoVersion(idItem);
                        request.setAttribute("version", versionResult);
                        ArrayList<Item> items = Coordinator.viewItems();
                        request.setAttribute("items", items);
                        request.getRequestDispatcher("/home/role/technical/files/modalEvaluarItems.jsp").forward(request, response);
                        return;
                    case "checkList":
                        HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
                        String idCentro = ((Funcionario) sesion.getAttribute("usuario")).getCentro().getId();
                        Version versionResult2 = Coordinator.viewAllInfoVersion(idItem);
                        request.setAttribute("version", versionResult2);
                        ArrayList<Lista> listas = Coordinator.viewLista(idCentro);
                        request.setAttribute("items", listas);
                        request.getRequestDispatcher("/home/role/technical/files/modalCheckList.jsp").forward(request, response);
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
