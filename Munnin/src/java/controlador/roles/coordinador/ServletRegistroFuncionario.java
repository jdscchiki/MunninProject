/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.roles.coordinador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.bean.Funcionario;
import modelo.negocio.NegocioCoordinador;

/**
 *
 * @author Juan David Segura Castro
 */
@WebServlet(name = "ServletRegistroFuncionario", urlPatterns = {"/registro"})
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
        String tipoDoc = request.getParameter("tipoDoc");
        int idTipoDoc;
        String documento = request.getParameter("documento");
        String correo = request.getParameter("correo");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
        String idCentro = ((Funcionario)sesion.getAttribute("usuario")).getIdCentro();
        try {//conversion de datos
            idTipoDoc = Integer.parseInt(tipoDoc);
            Funcionario nuevoFuncionario = new Funcionario();
            nuevoFuncionario.setIdTipoDocumento(idTipoDoc);
            nuevoFuncionario.setDocumento(documento);
            nuevoFuncionario.setCorreo(correo);
            nuevoFuncionario.setNombre(nombre);
            nuevoFuncionario.setApellido(apellido);
            nuevoFuncionario.setTelefono(telefono);
            if (NegocioCoordinador.registarFuncionario(nuevoFuncionario, idCentro)) {
                request.setAttribute("Mensaje", "<script>registroCompletado()</script>");
                request.getRequestDispatcher("roles/coordinador/formularios/registro-funcionario.jsp").forward(request, response);
            } else {
                //debe mandar un mensaje con js, diciendo que el registro no se ha podido realizar
                response.sendRedirect(request.getContextPath()+"/roles/coordinador/formularios/registro-funcionario.jsp");
            }
        } catch (NumberFormatException e) {
            //debe mandar un mensaje con js, diciendo que ha ocurrido un error al seleccionar un tipo de documento
            request.getRequestDispatcher(request.getContextPath()+"/roles/coordinador/formularios/registro-funcionario.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("mensaje", ex);
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
