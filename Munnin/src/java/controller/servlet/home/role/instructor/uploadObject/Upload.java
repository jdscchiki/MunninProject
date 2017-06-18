/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.instructor.uploadObject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Business.Instructor;
import model.bean.Funcionario;
import model.bean.Producto;
import model.bean.TipoObjetoAprendizaje;

/**
 *
 * @author Juan David Segura
 */
@WebServlet(urlPatterns = {"/home/role/instructor/uploadobject/upload"})
//@MultipartConfig(
//        fileSizeThreshold = 1024 * 1024 * 10, // 10 MB 
//        maxFileSize = 1024 * 1024 * 50, // 50 MB
//        maxRequestSize = 1024 * 1024 * 100)   	// 100 MB
@MultipartConfig
public class Upload extends HttpServlet {

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
        try {
            String name = request.getParameter("objectName");
            String description = request.getParameter("objectDescription");
            String keywords = request.getParameter("objectKeyword");
            String strIdObjectType = request.getParameter("objectType");
            Part filePart = request.getPart("objectFile");
            HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
            Funcionario funcionario = (Funcionario) sesion.getAttribute("usuario");

            Producto producto = new Producto();
            producto.setNombre(name);
            producto.setDescripcion(description);
            producto.setPalabrasClave(keywords);
            TipoObjetoAprendizaje tipoObjetoAprendizaje = new TipoObjetoAprendizaje();
            tipoObjetoAprendizaje.setId(Integer.parseInt(strIdObjectType));
            producto.setTipoObjetoAprendizaje(tipoObjetoAprendizaje);

            int[] operationResult = Instructor.uploadNewLearningObject(filePart, producto, funcionario.getCentro().getId(), funcionario.getId());

            switch (operationResult[0]) {
                case 1:
                    request.setAttribute("messageType", "success");
                    request.setAttribute("message", "Se ha subido satisfactoriamente el objeto de aprendizaje");
                    request.setAttribute("categories", Instructor.viewAllCategoryCenter(funcionario.getCentro().getId()));
                    request.setAttribute("learningObject", operationResult[1]);
                    
                    request.getRequestDispatcher("/home/role/instructor/uploadobject/modalcategory.jsp").forward(request, response);
                    break;
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                default:
                    request.setAttribute("messageType", "danger");
                    request.setAttribute("message", "Lo sentimos ha ocurrido un problema, por favor vuelva a intentarlo");
                    request.getRequestDispatcher("/WEB-INF/model/message.jsp").forward(request, response);
                    break;    
            }
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
