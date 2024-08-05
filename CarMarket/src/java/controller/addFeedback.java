/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Client;
import entity.Feedback;
import entity.Provider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import model.DAOClient;

/**
 *
 * @author admin
 */
@WebServlet(name = "addFeedback", urlPatterns = {"/addFeedback"})
public class addFeedback extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addFeedback</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addFeedback at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        HttpSession session = request.getSession(false);

        // Check if session exists and currentAcc is set
        if (session != null) {
            Object currentAcc = session.getAttribute("currentAcc");

            // Check if the currentAcc is an instance of Client
            if (currentAcc instanceof Provider) {
                request.setAttribute("mess", "Your account cannot give feedback. Please change to another to give us some feedback");
                request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
            } // Check if the currentAcc is an instance of Provider
            else if (currentAcc instanceof Client) {
                session.setAttribute("currentAcc", currentAcc);  // No need to reset as it's already in the session
                request.getRequestDispatcher("/JSP/Feedback.jsp").forward(request, response);
            } else {
                // If currentAcc is not set or is of an unexpected type, redirect to login
                request.setAttribute("mess", "Please log in to access feedback.");
                request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
            }
        } else {
            // If session is null, redirect to login
            request.setAttribute("mess", "Please log in to access feedback.");
            request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
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
        HttpSession session = request.getSession(false);
        Client acc = (Client) session.getAttribute("currentAcc");
        if (acc == null) {
            request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
        } else {
            String rate = request.getParameter("rate");
            String comment = request.getParameter("comment");
            Date currentDate = new Date();
            Feedback feedback = new Feedback(comment, rate, currentDate, acc.getClientId());
            DAOClient dao = new DAOClient();
            int result = dao.insertFeedback(feedback);
            if (result > 0) {
                request.getRequestDispatcher("/JSP/success.jsp").forward(request, response);
            }
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
