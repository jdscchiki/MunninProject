/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.instructor.myStuff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Business.Instructor;
import model.bean.Funcionario;
import model.bean.Producto;
import model.bean.TipoObjetoAprendizaje;
import javax.servlet.http.Part;

/**
 *
 * @author Monica
 */
@WebServlet(urlPatterns = {"/home/role/instructor/mystuff/correccion" })
@MultipartConfig
public class CorrectionProduct extends HttpServlet {

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
             int filter = 0;
            String search = request.getParameter("search");
            String strPage = request.getParameter("page");
            int page = 1;
            if (strPage != null) {
                page = Integer.parseInt(strPage);
            }

            int cantXpag = 10;
            String id = request.getParameter("idProducto");
            String strIdObjectoArchivo = request.getParameter("objectoTipo");
            Part archivoPart = request.getPart("objectoArchivo");
            
            HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
            Funcionario funcionario = (Funcionario) sesion.getAttribute("usuario");
            
            Producto producto = new Producto();
            producto.setId(Integer.parseInt(id));
            TipoObjetoAprendizaje tipoObjetoAprendizaje = new TipoObjetoAprendizaje();
            tipoObjetoAprendizaje.setId(Integer.parseInt(strIdObjectoArchivo));
            producto.setTipoObjetoAprendizaje(tipoObjetoAprendizaje);
            int[] operationResult = Instructor.uploadNewVersion(archivoPart, producto, funcionario.getCentro().getId(), funcionario.getId());

             switch (operationResult[0]) {
                case 1:
                    request.setAttribute("messageType", "success");
                    request.setAttribute("message", "Se ha subido satisfactoriamente el objeto de aprendizaje");
                    request.setAttribute("categories", Instructor.viewAllCategoryCenter(funcionario.getCentro().getId()));
                    request.setAttribute("learningObject", operationResult[1]);
                    request.setAttribute("messageType", "danger");
                    request.setAttribute("message", "Lo sentimos ha ocurrido un problema, por favor vuelva a intentarlo");
                    request.getRequestDispatcher("/WEB-INF/model/message.jsp").forward(request, response);
                    break;    
            }
             
            int totalPages = Instructor.countPagesCorrectionProducto(filter, cantXpag, search);
            request.setAttribute("page", page);
            request.setAttribute("pages", util.Pager.showLinkedPages(page, totalPages, cantXpag));
            request.setAttribute("contentTable",Instructor.viewObjet(filter, page, cantXpag, search));
            request.setAttribute("lastSearch", util.Pager.getSearchParameters(request));
            request.setAttribute("displayResult", "fulltable");
            request.setAttribute("idTable", "tableBodyCorrecion");
            request.setAttribute("urlServlet", (request.getContextPath()+"/home/role/instructor/mystuff/correccion"));
            request.getRequestDispatcher("/home/role/instructor/mystuff/modalSubirCorrecion.jsp").forward(request, response);
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
