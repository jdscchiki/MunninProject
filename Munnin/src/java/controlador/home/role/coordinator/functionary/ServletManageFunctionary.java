/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.home.role.coordinator.functionary;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Business.Coordinator;
import modelo.bean.Funcionario;
import modelo.bean.Rol;

/**
 *
 * @author Juan David Segura Castro
 */
@WebServlet(name = "ServletAdminFuncionarios", urlPatterns = {"/home/role/coordinator/admin-functionary"})
public class ServletManageFunctionary extends HttpServlet {

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
            int idFun;
            String opcion = request.getParameter("operation");

            idFun = Integer.parseInt(idFuncionario);
            if (idFun <= 0) {
                request.setAttribute("caseMessage", 3);
                request.setAttribute("message", "Para realizar la operación es necesario seleccionar uno de los funcionarios");
            } else {
                switch (opcion) {
                    case "Remove":
                        if(Coordinator.inhabilitarFuncionario(idFun)){
                            request.setAttribute("caseMessage", 1);
                            request.setAttribute("message", "El funcionario fue inhabilitado exitosamente");
                        }else{
                            request.setAttribute("caseMessage", 0);
                            request.setAttribute("message", "El funcionario no ha podido ser inhabilitado");
                        }   break;
                    case "ChangeRoles":
                        Funcionario funcionarioResult = Coordinator.fullInfoFuncionario(idFun);
                        request.setAttribute("funcionario", funcionarioResult);
                        ArrayList<Rol> roles = Coordinator.verRoles();
                        request.setAttribute("roles", roles);
                        request.getRequestDispatcher("/home/role/coordinator/elements/content/forms/modalRoles.jsp").forward(request, response);
                        return;
                    default:
                        request.setAttribute("caseMessage", 0);
                        request.setAttribute("message", "no ha podido ser completada la accion");
                        break;
                }
            }
            request.getRequestDispatcher("/elements/content/message.jsp").forward(request, response);
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
