/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.role.coordinator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.bean.Funcionario;
import modelo.Business.Coordinator;

/**
 *
 * @author Juan David Segura Castro
 */
@WebServlet(name = "ServletRegistroFuncionario", urlPatterns = {"/home/role/coordinator/register"})
public class ServletRegistroFuncionario extends HttpServlet {

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
        try {//conversion de datos
            String tipoDoc = request.getParameter("tipoDoc");
            int idTipoDoc;
            String documento = request.getParameter("documento");
            String correo = request.getParameter("correo");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String telefono = request.getParameter("telefono");
            HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
            String idCentro = ((Funcionario) sesion.getAttribute("usuario")).getIdCentro();
            idTipoDoc = Integer.parseInt(tipoDoc);
            
            Funcionario nuevoFuncionario = new Funcionario();
            nuevoFuncionario.setIdTipoDocumento(idTipoDoc);
            nuevoFuncionario.setDocumento(documento);
            nuevoFuncionario.setCorreo(correo);
            nuevoFuncionario.setNombre(nombre);
            nuevoFuncionario.setApellido(apellido);
            nuevoFuncionario.setTelefono(telefono);
            
            if (Coordinator.registarFuncionario(nuevoFuncionario, idCentro)) {
                request.setAttribute("message", 4);
                request.getRequestDispatcher("/home/role/coordinator/elements/content/functionary/messages.jsp").forward(request, response);
            } else {
                request.setAttribute("message", 2);
                request.getRequestDispatcher("/home/role/coordinator/elements/content/functionary/messages.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("message", 5);
            request.getRequestDispatcher("/home/role/coordinator/elements/content/functionary/messages.jsp").forward(request, response);
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
