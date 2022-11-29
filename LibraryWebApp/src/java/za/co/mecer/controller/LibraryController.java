package za.co.mecer.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import za.co.mecer.process.BooksLibraryProcess;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet("/books")
public class LibraryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String sub = request.getParameter("submit");
        try {
            if (sub != null) {
                if (sub.equalsIgnoreCase("add book")) {
                    BooksLibraryProcess process = RequestActionFactory.createRequestAction();
                    process.processAddBook(request, response);
                    response.sendRedirect("books");
                }
            } else {
                BooksLibraryProcess process = RequestActionFactory.createRequestAction();
                process.processGetBooks(request, response);
            }
        } catch (SQLException iox) {
            System.out.println(String.format("Error: %s%n", iox.getMessage()));
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

    abstract static class RequestActionFactory {

        public static BooksLibraryProcess createRequestAction() {
            return new BooksLibraryProcess();
        }

    }
}
