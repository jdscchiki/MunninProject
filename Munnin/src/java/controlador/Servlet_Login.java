/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Beans.FuncionarioBean;
import modelo.Dao.FuncionarioDao;

/**
 *
 * @author Juan David
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/validar"})
public class Servlet_Login extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("textOption"));
        Long id_funcionario = Long.parseLong(request.getParameter("textId"));
        String documento_funcionario = request.getParameter("textDocumento");
        String correo_funcionario = request.getParameter("textCorreo");
        String contrasena_funcionario = request.getParameter("textContrasena");
        String nombre_funcionario = request.getParameter("textNombre");
        String apellido_funcionario = request.getParameter("textApellido");
        String cargo_funcionario = request.getParameter("textCargo");
        String telefono_funcionario = request.getParameter("textTelefono");
        String id_centro_funcionario = request.getParameter("textIdCentro");
        
        FuncionarioBean BFuncionario = new FuncionarioBean(id_funcionario, documento_funcionario, correo_funcionario, contrasena_funcionario, nombre_funcionario, apellido_funcionario, cargo_funcionario, telefono_funcionario, id_centro_funcionario);
        FuncionarioDao DFuncionario = new FuncionarioDao(BFuncionario);
        ResultSet rs;
        
//        switch(opcion){
//            case 1://agregar registro
//                if (Funcionario_Dao.agregarRegistro()) {
//                    request.setAttribute("Exito", "<script> alert('El usuario fue registrado correctamente') </script>");
//                } else{
//                    request.setAttribute("Error", "<script> alert('El usuario no se registro correctamente') </script>");
//                }
//                request.getRequestDispatcher("registrar_usuario.jsp").forward(request, response);
//                break;
//            case 2://validar usuario
//                if (DUsuario.validar(usuLogin, usuPassword)) {
//                    request.getRequestDispatcher("menu.jsp").forward(request, response);
//                } else{
//                    request.setAttribute("Error", "<script> alert('Usuario y/o contraseña no son validos') </script>");
//                    request.getRequestDispatcher("index.jsp").forward(request, response);
//                }
//                break;
//        }
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
