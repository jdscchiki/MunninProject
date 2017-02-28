/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.coordinator.functionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Business.Coordinator;

/**
 *
 * @author Juan David Segura
 */
@WebServlet(name = "ServletAssignRoles", urlPatterns = {"/home/role/coordinator/assign-roles"})
public class ServletAssignRoles extends HttpServlet {

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
        try{
            ArrayList<String> idRoles = new ArrayList<> (Arrays.asList(request.getParameterValues("role")));
            String idFuncionario = request.getParameter("id");
            int idFun = Integer.parseInt(idFuncionario);
            
            switch(Coordinator.AssignRoles(idFun, idRoles)){
                case 0:
                    request.setAttribute("caseMessage", 0);
                    request.setAttribute("message", "no ha podido realizarse la operacion");
                    break;
                case 1:
                    request.setAttribute("caseMessage", 1);
                    request.setAttribute("message", "se han cambiado los roles correctamente");
                    break;
                case 2:
                    request.setAttribute("caseMessage", 0);
                    request.setAttribute("message", "ha ocurrido un error al realizar la operacion, por favor volver a cargar la pagina");
                    break;
                case 3:
                    request.setAttribute("caseMessage", 3);
                    request.setAttribute("message", "ha ocurrido un problema al agregar uno de los roles al funcionario");
                    break;
                case 4:
                    request.setAttribute("caseMessage", 3);
                    request.setAttribute("message", "ha ocurrido un problema al quitar uno de los roles al funcionario");
                    break;
            }
            request.getRequestDispatcher("/WEB-INF/model/message.jsp").forward(request, response);
        }catch(Exception e){
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
