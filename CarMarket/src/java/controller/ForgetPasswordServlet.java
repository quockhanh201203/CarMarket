package controller;

import entity.Client;
import entity.Provider;
import entity.email;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAOClient;
import model.DAOProvider;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ForgetPasswordServlet", urlPatterns = {"/forgetpassword"})
public class ForgetPasswordServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ForgetPasswordServlet.class.getName());

    private static String hideEmail(String email) {
        String[] parts = email.split("@");
        String localPart = parts[0];
        String domainPart = parts[1];
        StringBuilder hiddenLocalPart = new StringBuilder(localPart.substring(0, 1));
        for (int i = 1; i < localPart.length(); i++) {
            hiddenLocalPart.append("*");
        }
        return hiddenLocalPart.toString() + "@" + domainPart;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOClient cliDao = new DAOClient();
        DAOProvider proDao = new DAOProvider();
        HttpSession session = request.getSession();
        email mail = new email();

        String lostPass = request.getParameter("lostPass");
        if (lostPass == null || lostPass.isEmpty()) {
            lostPass = "getTheMail";
        }

        try (PrintWriter out = response.getWriter()) {
            if ("getTheMail".equals(lostPass)) {
                String getEmail = request.getParameter("getEmail");
                if (getEmail == null || getEmail.isEmpty()) {
                    request.setAttribute("wrongEmail", "Email cannot be empty.");
                    request.getRequestDispatcher("JSP/forgetPassword.jsp").forward(request, response);
                    return;
                }

                Client client = cliDao.getClientByEmail(getEmail);
                Provider provider = proDao.getProviderByEmail(getEmail);

                if (client != null) {
                    session.setAttribute("acc", client);
                    String otp = mail.sendVerificaionOTPUsingEmail(client.getEmail());
                    session.setAttribute("theOTP", otp);
                    session.setMaxInactiveInterval(2 * 60); // 2 minutes
                    session.setAttribute("userEmail", client.getEmail()); // Save full email
                    session.setAttribute("userMail", hideEmail(client.getEmail()));
                    request.getRequestDispatcher("JSP/VerifyOTP.jsp").forward(request, response);
                } else if (provider != null) {
                    session.setAttribute("acc", provider);
                    String otp = mail.sendVerificaionOTPUsingEmail(provider.getEmail());
                    session.setAttribute("theOTP", otp);
                    session.setMaxInactiveInterval(2 * 60); // 2 minutes
                    session.setAttribute("userEmail", provider.getEmail()); // Save full email
                    session.setAttribute("userMail", hideEmail(provider.getEmail()));
                    request.getRequestDispatcher("JSP/VerifyOTP.jsp").forward(request, response);
                } else {
                    request.setAttribute("wrongEmail", "The Email you entered does not match with any registered email account. Try again.");
                    request.getRequestDispatcher("JSP/forgetPassword.jsp").forward(request, response);
                }
            } else if ("verifyOTP".equals(lostPass)) {
                String userOTP = request.getParameter("op1") + request.getParameter("op2")
                        + request.getParameter("op3") + request.getParameter("op4")
                        + request.getParameter("op5") + request.getParameter("op6");
                String theOTP = (String) session.getAttribute("theOTP");

                if (userOTP.equals(theOTP)) {
                    String userEmail = (String) session.getAttribute("userEmail");
                    Client client = cliDao.getClientByEmail(userEmail);
                    Provider provider = proDao.getProviderByEmail(userEmail);

                    if (client != null) {
                        session.setAttribute("currentAcc", client);
                        request.getRequestDispatcher("/JSP/home.jsp").forward(request, response);
                    } else if (provider != null) {
                        session.setAttribute("currentAcc", provider);
                        request.getRequestDispatcher("/JSP/home.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("wrongOTP", "The OTP code is incorrect, Try again.");
                    request.getRequestDispatcher("JSP/VerifyOTP.jsp").forward(request, response);
                }
            } else if ("resendOTP".equals(lostPass)) {
                String userEmail = (String) session.getAttribute("userEmail");
                if (userEmail != null) {
                    Client client = cliDao.getClientByEmail(userEmail);
                    Provider provider = proDao.getProviderByEmail(userEmail);

                    if (client != null) {
                        String otp = mail.sendVerificaionOTPUsingEmail(client.getEmail());
                        session.setAttribute("theOTP", otp);
                        session.setMaxInactiveInterval(2 * 60); // 2 minutes
                    } else if (provider != null) {
                        String otp = mail.sendVerificaionOTPUsingEmail(provider.getEmail());
                        session.setAttribute("theOTP", otp);
                        session.setMaxInactiveInterval(2 * 60); // 2 minutes
                    }
                    request.getRequestDispatcher("JSP/VerifyOTP.jsp").forward(request, response);
                } else {
                    request.setAttribute("wrongEmail", "Email session expired or not found. Try again.");
                    request.getRequestDispatcher("JSP/forgetPassword.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("JSP/forgetPassword.jsp").forward(request, response);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error processing request", e);
            request.setAttribute("errorMessage", "An unexpected error occurred. Please try again.");
            request.getRequestDispatcher("JSP/forgetPassword.jsp").forward(request, response);
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
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet for handling forgot password functionality";
    }
}
