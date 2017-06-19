/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.instructor.myStuff;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import model.bean.Centro;
import model.bean.TipoArchivo;
import model.bean.Version;

/**
 *
 * @author Monica
 */
@WebServlet(urlPatterns = {"/home/role/instructor/mystuff/correccion"})
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

            String id = request.getParameter("idProducto");
            String strIdTipoArchivo = request.getParameter("objectoTipo");
            Part archivoPart = request.getPart("objectoArchivo");

            HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
            Funcionario funcionario = (Funcionario) sesion.getAttribute("usuario");

            Version version = new Version();
            Producto producto = new Producto();
            producto.setId(Integer.parseInt(id));
            version.setProducto(producto);
            TipoArchivo tipoArchivo = new TipoArchivo();
            tipoArchivo.setId(Integer.parseInt(strIdTipoArchivo));
            version.setTipoArchivo(tipoArchivo);
            version.setCentro(new Centro());
            version.getCentro().setId(funcionario.getCentro().getId());
            int operationResult = Instructor.uploadNewVersion(archivoPart, version, funcionario.getId());

            switch (operationResult) {
                case 1:
                    request.setAttribute("messageType", "success");
                    request.setAttribute("message", "Se ha subido satisfactoriamente la nueva version del objeto de aprendizaje");
                    request.getRequestDispatcher("/WEB-INF/model/message.jsp").forward(request, response);
                    break;
                default:
                    request.setAttribute("messageType", "danger");
                    request.setAttribute("message", "Lo sentimos ha ocurrido un error durante la carga");
                    request.getRequestDispatcher("/WEB-INF/model/message.jsp").forward(request, response);
                    break;
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
        return "Short description";
    }// </editor-fold>

}
