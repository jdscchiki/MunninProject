/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.technical.check;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Business.Technical;
import model.bean.EvaluacionLista;
import model.bean.Funcionario;
import model.bean.Item;
import model.bean.Lista;

/**
 *
 * @author Juan David Segura
 */
@WebServlet(urlPatterns = {"/home/role/technical/check/assign-list"})
public class AssignList extends HttpServlet {

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
            throws ServletException, IOException, NamingException, SQLException {
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
            String idVersion = request.getParameter("idVersion");
            String idLista = request.getParameter("idLista");
            int idVer = Integer.parseInt(idVersion);
            int idLis = Integer.parseInt(idLista);
            HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
            Funcionario funcionario = (Funcionario) sesion.getAttribute("usuario");
            EvaluacionLista result;
            switch (opcion) {
                case "aprobar":
                    if (Technical.AssignLista(idVer, idLis, funcionario)) {
                        request.setAttribute("messageType", "success");
                        request.setAttribute("message", "La lista se ha asignado correctamente");
                    } else {
                        request.setAttribute("messageType", "danger");
                        request.setAttribute("message", "ha ocurrido un error al realizar la operacion, por favor volver a cargar la pagina");
                    }
                    result = Technical.datosLista(idVer, idLis, funcionario);
                    if (Technical.AssignItems(result.getId(), idItems, coments)) {
                        request.setAttribute("messageType", "success");
                        request.setAttribute("message", "La lista se ha asignado correctamente");
                    } else {
                        request.setAttribute("messageType", "danger");
                        request.setAttribute("message", "ha ocurrido un error al realizar la operacion, por favor volver a cargar la pagina");
                    }
                    if (Technical.cambioEstado(idVer)) {
                        request.setAttribute("messageType", "success");
                        request.setAttribute("message", "La lista se ha asignado correctamente");
                    }
                    break;
                case "rechazar":
                    if (Technical.AssignLista(idVer, idLis, funcionario)) {
                        request.setAttribute("messageType", "success");
                        request.setAttribute("message", "La lista se ha asignado correctamente");
                    } else {
                        request.setAttribute("messageType", "danger");
                        request.setAttribute("message", "ha ocurrido un error al realizar la operacion, por favor volver a cargar la pagina");
                    }
                    result = Technical.datosLista(idVer, idLis, funcionario);
                    if (Technical.AssignItems(result.getId(), idItems, coments)) {
                        request.setAttribute("messageType", "success");
                        request.setAttribute("message", "La lista se ha asignado correctamente");
                    } else {
                        request.setAttribute("messageType", "danger");
                        request.setAttribute("message", "ha ocurrido un error al realizar la operacion, por favor volver a cargar la pagina");
                    }
                    if (Technical.cambioEstadoRechazado(idVer)) {
                        request.setAttribute("messageType", "success");
                        request.setAttribute("message", "La lista se ha asignado correctamente");
                    }
                    break;
            }
            request.getRequestDispatcher("/WEB-INF/model/message.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(AssignList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AssignList.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(AssignList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AssignList.class.getName()).log(Level.SEVERE, null, ex);
        }
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
