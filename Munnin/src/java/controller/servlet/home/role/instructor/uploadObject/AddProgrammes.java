/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.instructor.uploadObject;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Business.Instructor;
import model.bean.Funcionario;
import model.bean.Producto;
import model.bean.Programa;

/**
 *
 * @author Juan David Segura
 */
@WebServlet(urlPatterns = {"/home/role/instructor/uploadobject/addprogrammes"})
public class AddProgrammes extends HttpServlet {

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
            HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
            String idCentro = ((Funcionario) sesion.getAttribute("usuario")).getCentro().getId();
            int idLearningObject = Integer.parseInt(request.getParameter("learningObject"));

            String[] arrayProgrammes = {};
            if (request.getParameterValues("programmes")!=null) {
                arrayProgrammes = request.getParameterValues("programmes");
            }

            if (arrayProgrammes.length < 1) {
                request.setAttribute("messageType", "warning");
                request.setAttribute("message", "Deben agregarse uno o más programas");
                request.setAttribute("programmes", Instructor.viewAllProgrammes(idCentro));
                request.setAttribute("learningObject", idLearningObject);
                request.getRequestDispatcher("/home/role/instructor/uploadobject/modalprogram.jsp").forward(request, response);
            } else {
                Producto producto = new Producto();
                producto.setId(idLearningObject);
                ArrayList<Programa> programas = new ArrayList<>();
                for (String idProgram : arrayProgrammes) {
                    Programa programa = new Programa();
                    programa.setId(Integer.parseInt(idProgram));
                    programas.add(programa);
                }
                producto.setProgramas(programas);
                int addedProgrammes = Instructor.setProgrammesProduct(producto);
                
                if (addedProgrammes < 1) {
                    request.setAttribute("messageType", "warning");
                    request.setAttribute("message", "Ha ocurrido un problema al agregar los programas");
                    request.setAttribute("programmes", Instructor.viewAllProgrammes(idCentro));
                    request.setAttribute("learningObject", idLearningObject);
                    request.getRequestDispatcher("/home/role/instructor/uploadobject/modalprogram.jsp").forward(request, response);
                } else {
                    request.setAttribute("messageType", "success");
                    request.setAttribute("message", "Se han agregado " + addedProgrammes + " programas al objeto de aprenizaje, y se ha creado con exito el nuevo objeto de aprendizaje");
                    request.getRequestDispatcher("/WEB-INF/model/message.jsp").forward(request, response);
                }
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
