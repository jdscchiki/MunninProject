/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.coordinator.functionary;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Funcionario;
import model.Business.Coordinator;
import model.bean.TipoDocumento;

/**
 *
 * @author Juan David Segura Castro
 */
@WebServlet(urlPatterns = {"/home/role/coordinator/register-functionary"})
public class Register extends HttpServlet {

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
            TipoDocumento tipoDocumento = new TipoDocumento();
            tipoDocumento.setId(idTipoDoc);
            nuevoFuncionario.setTipoDocumento(tipoDocumento);
            nuevoFuncionario.setDocumento(documento);
            nuevoFuncionario.setCorreo(correo);
            nuevoFuncionario.setNombre(nombre);
            nuevoFuncionario.setApellido(apellido);
            nuevoFuncionario.setTelefono(telefono);
            switch(Coordinator.registerFunctionary(nuevoFuncionario, idCentro)){
                case 0:
                    request.setAttribute("messageType", "danger");
                    request.setAttribute("message", "no ha podido realizarse el registro");
                    break;
                case 1:
                    request.setAttribute("messageType", "success");
                    request.setAttribute("message", "el registro se ha completado exitosamente");
                    break;
                case 2:
                    request.setAttribute("messageType", "warning");
                    request.setAttribute("message", "Actualmente existe un funcionario activo con los datos ingresados");
                    break;
                case 3:
                    request.setAttribute("messageType", "warning");
                    request.setAttribute("message", "Actualmente existe un funcionario inactivo con el correo ingresado");
                    break;
                case 4:
                    request.setAttribute("messageType", "warning");
                    request.setAttribute("message", "Actualmente existe un funcionario inactivo con el documento ingresado");
                    break;
                case 5:
                    request.setAttribute("messageType", "warning");
                    request.setAttribute("message", "No ha podido ser enviado el correo con la contraseña del nuevo funcionario");
                    break;
            }
            request.getRequestDispatcher("/elements/content/message.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("message", "ha ocurrido un problema, por favor vuelva a cargar la pagina");
            request.getRequestDispatcher("/elements/content/message.jsp").forward(request, response);
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
