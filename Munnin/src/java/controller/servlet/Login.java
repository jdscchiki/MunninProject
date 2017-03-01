/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Funcionario;
import model.Business.General;

/**
 *
 * Se encarga de administrar la solicitudes realizadas desde el login de la
 * aplicación
 *
 * @version 1.0
 * @author Juan David Segura Castro
 */
@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {

    /**
     * Procesa las solicitudes para ambos HTTP <code>GET</code> y
     * <code>POST</code> methods. Realiza la conexion a Bases de datos y
     * redirecciona a index.jsp si los datos ingresados no son correctos y si lo
     * son correctos redirecciona a munnin.jsp, envia los datos del Usuario
     * logueado a traves de HttpSession
     *
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
            String correo = request.getParameter("textCorreo");
            String contrasena = request.getParameter("textContr");
            Funcionario funcionario = General.verifyFunctionary(correo, contrasena);
            if (funcionario == null) {
                request.setAttribute("Mensaje", "<script>usuarioNoValido()</script>");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                HttpSession sesion = (HttpSession) request.getSession();
                sesion.setAttribute("usuario", funcionario);
                response.sendRedirect(request.getContextPath()+"/home/intro.jsp");
            }
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
        return "Este servlet se encarga de procesar las peticiones de ingreso a la plataforma";
    }// </editor-fold>

}
