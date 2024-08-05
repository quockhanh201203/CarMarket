package controller;

import Common.MD5;
import entity.Client;
import entity.email;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import model.DAOClient;
import model.DAOProvider;

@WebServlet(name = "RegisterController", urlPatterns = {"/registercontroller"})
public class RegisterController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterController at " + request.getContextPath() + "</h1>");
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
        String repass = request.getParameter("repass");

        if (phoneNumber.length() > 11 || address.length() > 50 || !pass.equals(repass)) {
            request.setAttribute("mess", "The form is not in the correct format.");
            request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
        } else {
            DAOClient daoCli = new DAOClient();
            DAOProvider daoPro = new DAOProvider();
            if (daoCli.getClientByEmail(email) != null) {
                request.setAttribute("mess", "This email already exists in the system!");
                request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
            } else if (daoPro.getProviderByEmail(email) != null) {
                request.setAttribute("mess", "This email already exists in the system!");
                request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
            } else {
                Date currentDate = new Date();
                int clientId = daoCli.insertAccount(new Client(firstName, lastName, email, new MD5().getMd5(pass), phoneNumber, address, null, false, currentDate));

                // Getting the host and port dynamically
                String host = request.getServerName();
                int port = request.getServerPort();
                new email().send(email, "Register new account - click link below to activate account", "http://" + host + ":" + port + "/carmarket/verifyregister?e=" + email + "&t=" + new MD5().getMd5(email + "muichan123"));
                request.setAttribute("mess", "Please check your email to login to us!");
                request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
