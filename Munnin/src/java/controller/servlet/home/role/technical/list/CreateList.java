/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet.home.role.technical.list;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Business.Instructor;
import model.Business.Technical;
import model.bean.Funcionario;
import model.bean.Item;
import model.bean.Lista;


/**
 *
 * @author Juancho
 */
@WebServlet(urlPatterns = {"/home/role/technical/list/create"})
public class CreateList extends HttpServlet {

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
            Lista lista = new Lista();
            String nombrelista = request.getParameter("title");
            String descripcionlista  = request.getParameter("description");
            HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
            Funcionario funcionario = (Funcionario) sesion.getAttribute("usuario");
            
            lista.setNombre(nombrelista);
            lista.setDescripcion(descripcionlista);
            lista.setIdAutor(funcionario.getId());
            lista.setItems(new ArrayList<Item>());
            
            String[] items = request.getParameterValues("itemchecklist");
            for (String item : items) {
                Item newItem = new Item();
                newItem.setDescriptor(item);
                lista.getItems().add(newItem);
            }
            
            System.out.println(nombrelista);
            System.out.println(descripcionlista);
            System.out.println(funcionario.getId());
            for (int i = 0; i < items.length; i++) {
                System.out.println("N "+i+" "+items[i]);
            }
            
            int operationResult = Technical.guardarLista(lista);

            switch (operationResult) {
                case 1:
                    request.setAttribute("messageType", "success");
                    request.setAttribute("message", "Se ha creado satisfactoriamente la lista de chequeo. ");
                    request.getRequestDispatcher("/WEB-INF/model/message.jsp").forward(request, response);
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
        } catch (Exception ex) {
            request.setAttribute("mensaje", ex);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
////request parametre values
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
