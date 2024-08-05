/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Common.MD5;
import entity.Client;
import entity.Provider;
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

/**
 *
 * @author admin
 */
@WebServlet(name = "ChangePassword", urlPatterns = {"/ChangePassword"})
public class ChangePassword extends HttpServlet {

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
            out.println("<title>Servlet ChangePassword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePassword at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("./JSP/changepass.jsp").forward(request, response);
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
        DAOClient cliDao = new DAOClient();
        DAOProvider proDao = new DAOProvider();
        String newpass = request.getParameter("newpass");
        String renewpass = request.getParameter("renewpass");

        // Kiểm tra mật khẩu mới có khớp với mật khẩu nhập lại hay không
        if (!newpass.equals(renewpass)) {
            request.setAttribute("mess", "Renew pass not match with pass");
            request.getRequestDispatcher("/JSP/changepass.jsp").forward(request, response);
            return;
        }

        // Lấy đối tượng người dùng từ session
        //Object user = session.getAttribute("user");
//        String userMail = (String) session.getAttribute("userMail");
//        String userMail = (String) request.getAttribute("userMail");
//        Client client = cliDao.getClientByEmail(userMail);
        HttpSession session = request.getSession(false);
        Client acc = (Client) session.getAttribute("currentAcc");
        if (acc != null) {
//            Client client = (Client) user;
//            DAOClient cliDao = new DAOClient(); 
            MD5 md5 = new MD5();
            cliDao.changePassword(acc.getClientId(), newpass);
            request.setAttribute("mess", "Change password successfully!");
        } else {
            request.setAttribute("mess", "No user found in session!");
        }

        // Chuyển tiếp yêu cầu tới trang thay đổi mật khẩu với thông báo kết quả
        request.getRequestDispatcher("/JSP/changepass.jsp").forward(request, response);
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
