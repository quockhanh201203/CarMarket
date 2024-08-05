/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Common.MD5;
import entity.Client;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Vector;
import model.DAOClient;
import model.DAOProvider;

/**
 *
 * @author admin
 */
@WebServlet(name = "ManageCustomerProfile", urlPatterns = {"/managecustomerprofile"})
public class ManageCustomerProfile extends HttpServlet {

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
            out.println("<title>Servlet ManageCustomerProfile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageCustomerProfile at " + request.getContextPath() + "</h1>");
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
        DAOProvider dao = new DAOProvider();
        Vector<Client> listClient = dao.getAllClient();
        request.setAttribute("listClient", listClient);
        request.getRequestDispatcher("/JSP/listCustomer.jsp").forward(request, response);

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
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("Address");
        String pass = request.getParameter("pass");

        if (phoneNumber.length() > 11 || address.length() > 50) {
            request.setAttribute("mess", "The form is not in the correct format.");
            request.getRequestDispatcher("/JSP/listCustomer.jsp").forward(request, response);
        } else {
            DAOClient daoCli = new DAOClient();
            if (daoCli.getClientByEmail(email) != null) {
                DAOProvider dao = new DAOProvider();
                Vector<Client> listClient = dao.getAllClient();
                request.setAttribute("listClient", listClient);
                request.setAttribute("mess", "This email already exists in the system!");
                request.getRequestDispatcher("/JSP/listCustomer.jsp").forward(request, response);
            } else {
                Date currentDate = new Date();
                int clientId = daoCli.insertAccount(new Client(firstName, lastName, email, new MD5().getMd5(pass), phoneNumber, address, null, true, currentDate));
                response.sendRedirect("managecustomerprofile");
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
