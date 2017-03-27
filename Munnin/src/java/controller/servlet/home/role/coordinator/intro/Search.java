/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.coordinator.intro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Business.General;
import model.bean.Funcionario;
import model.dao.RolDAO;

/**
 *
 * @author Juan David Segura
 */
@WebServlet(urlPatterns = {"/home/role/coordinator/intro/search"})
public class Search extends HttpServlet {

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

            String strPage = request.getParameter("page");
            int page = 1;
            if (strPage != null) {
                page = Integer.parseInt(strPage);
            }

            
            int cantXpag = 10;

            HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
            Funcionario funcionario = (Funcionario) sesion.getAttribute("usuario");

            int totalPages = General.countPagesNotifications(funcionario.getId(), cantXpag, RolDAO.ID_COORDINADOR);
            request.setAttribute("page", page);
            request.setAttribute("pages", util.Pager.showLinkedPages(page, totalPages, cantXpag));
            request.setAttribute("contentTable", General.viewNotifications(funcionario.getId(), cantXpag, page, RolDAO.ID_COORDINADOR));
            request.setAttribute("lastSearch", util.Pager.getSearchParameters(request));
            request.setAttribute("displayResult", "fulltable");
            request.setAttribute("urlServlet", (request.getContextPath()+"/home/role/coordinator/intro/search"));
            request.getRequestDispatcher("/home/role/coordinator/intro/table.jsp").forward(request, response);
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
