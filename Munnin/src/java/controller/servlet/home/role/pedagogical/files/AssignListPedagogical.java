/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.pedagogical.files;

import controller.servlet.home.role.technical.files.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Business.Coordinator;
import model.Business.Pedagogical;
import model.bean.EvaluacionLista;
import model.bean.Funcionario;

/**
 *
 * @author Juan David Segura
 */
@WebServlet(urlPatterns = {"/home/role/pedagogical/files/assign-list"})
public class AssignListPedagogical extends HttpServlet {

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
            ArrayList<String> idItems = new ArrayList<>(Arrays.asList(request.getParameterValues("item")));
            ArrayList<String> coments = new ArrayList<>();
            
            Enumeration<String> parameterNames = request.getParameterNames();

            while (parameterNames.hasMoreElements()) {
                String parameterName = parameterNames.nextElement();
                if (!"item".equals(parameterName)) {
                    String[] parameterValues = request.getParameterValues(parameterName);
                    for (String parameterValue : parameterValues) {
                        coments.add(parameterName + "=" + parameterValue);
                    }
                }
            }  
            String opcion = request.getParameter("action");
            System.out.println(opcion);
            String idVersion = request.getParameter("idVersion");
            String idLista = request.getParameter("idLista");
            System.out.println("bandera 4");
            System.out.println(idLista);
            int idVer = Integer.parseInt(idVersion);
            int idLis = Integer.parseInt(idLista);            
            HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
            Funcionario funcionario = (Funcionario) sesion.getAttribute("usuario");
            EvaluacionLista result;
            switch (opcion) {
                case "aprobar":
                    if (Pedagogical.AssignLista(idVer, idLis, funcionario)) {
                            request.setAttribute("messageType", "success");
                            request.setAttribute("message", "La lista se ha asignado correctamente");
                    }
                    else{
                            request.setAttribute("messageType", "danger");
                            request.setAttribute("message", "ha ocurrido un error al realizar la operacion, por favor volver a cargar la pagina");
                    }
                    result = Pedagogical.datosLista(idVer, idLis, funcionario);
                    if (Pedagogical.AssignItems(result.getId(), idItems, coments)) {
                        request.setAttribute("messageType", "success");
                        request.setAttribute("message", "La lista se ha asignado correctamente");
                    } else {
                        request.setAttribute("messageType", "danger");
                        request.setAttribute("message", "ha ocurrido un error al realizar la operacion, por favor volver a cargar la pagina");
                    }
                    if (Pedagogical.cambioEstado(idVer)) {
                        request.setAttribute("messageType", "success");
                        request.setAttribute("message", "La lista se ha asignado correctamente");
                    }
                    request.getRequestDispatcher("/WEB-INF/model/message.jsp").forward(request, response);
                    break;
                case "rechazar":
                    if (Pedagogical.AssignLista(idVer, idLis, funcionario)) {
                            request.setAttribute("messageType", "success");
                            request.setAttribute("message", "La lista se ha asignado correctamente");
                    }
                    else{
                            request.setAttribute("messageType", "danger");
                            request.setAttribute("message", "ha ocurrido un error al realizar la operacion, por favor volver a cargar la pagina");
                    }
                    result = Pedagogical.datosLista(idVer, idLis, funcionario);
                    if (Pedagogical.AssignItems(result.getId(), idItems, coments)) {
                        request.setAttribute("messageType", "success");
                        request.setAttribute("message", "La lista se ha asignado correctamente");
                    } else {
                        request.setAttribute("messageType", "danger");
                        request.setAttribute("message", "ha ocurrido un error al realizar la operacion, por favor volver a cargar la pagina");
                    }
                    if (Pedagogical.cambioEstadoRechazado(idVer)) {
                        request.setAttribute("messageType", "success");
                        request.setAttribute("message", "La lista se ha asignado correctamente");
                    }
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
