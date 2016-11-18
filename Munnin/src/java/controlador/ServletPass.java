/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.bean.Funcionario;
import modelo.negocio.NegocioLogin;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "ServletPass", urlPatterns = {"/cambioContrasena"})
public class ServletPass extends HttpServlet {

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
        String contrasena = request.getParameter("passwordActual");
        String contrasenaNueva = request.getParameter("passwordNew1");
        String contrasenaNueva2 = request.getParameter("passwordNew2");
        if (!contrasenaNueva.equals(contrasenaNueva2)) {
            request.setAttribute("Mensaje2", "<script>contrasenaMal()</script>");
            request.getRequestDispatcher("cambioPass.jsp").forward(request, response);
        }
        HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
        Funcionario funcionario2 = (Funcionario) sesion.getAttribute("usuario");
        try {
            Funcionario funcionario = NegocioLogin.verificarFuncionario(funcionario2.getCorreo(), contrasena);
            if (funcionario == null) {
                request.setAttribute("Mensaje", "<script>contrasenaNoValido()</script>");
                request.getRequestDispatcher("cambioPass.jsp").forward(request, response);
            } else {
                boolean resultado = NegocioLogin.cambioContrasena(funcionario2.getId(), contrasenaNueva);

                if (resultado) {
                    request.setAttribute("Mensaje", "<script>contrasenaOK()</script>");
                    request.getRequestDispatcher("cambioPass.jsp").forward(request, response);
                } else {
                    request.setAttribute("Mensaje", "<script>contrasenaNoValido()</script>");
                    request.getRequestDispatcher("cambioPass.jsp").forward(request, response);
                }
            }

            request.getRequestDispatcher("cambioPass.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Error 2: " + e);
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
