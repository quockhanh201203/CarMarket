package controller;

import Common.MD5;
import entity.Client;
import java.io.IOException;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import model.DAOClient;

@WebServlet(name = "createClient", urlPatterns = {"/createClient"})
public class createClient extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet createClient</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createClient at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
            request.getRequestDispatcher("managecustomerprofile").forward(request, response);
        } else {
            DAOClient daoCli = new DAOClient();
            if (daoCli.getClientByEmail(email) != null) {
                request.setAttribute("mess", "This email already exists in the system!");
                request.getRequestDispatcher("managecustomerprofile").forward(request, response);
            } else {
                Date currentDate = new Date();
                int clientId = daoCli.insertAccount(new Client(firstName, lastName, email, new MD5().getMd5(pass), phoneNumber, address, null, true, currentDate));
                response.sendRedirect("managecustomerprofile");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
