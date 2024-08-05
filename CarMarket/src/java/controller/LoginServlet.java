/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import entity.Client;
import Common.MD5;
import entity.Brand;
import entity.Model;
import entity.Origin;
import entity.Post;
import entity.Provider;
import entity.engine;
import entity.exteriorColor;
import entity.gearbox;
import java.util.List;
import java.util.Vector;
import model.DAOClient;
import model.DAOPost;
import model.DAOProvider;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        Client acc = (Client) session.getAttribute("currentAcc");
        if (acc == null) {
            request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
        }
        session.setAttribute("currentAcc", acc);
        DAOClient daoCli = new DAOClient();
        DAOProvider daoPro = new DAOProvider();
        DAOPost daoPos = new DAOPost();
        List<Post> posts = daoPos.getPostsSortedByDate();
        Vector<Post> AllPost = daoPos.getAllPost();
        request.setAttribute("AllPost", AllPost);
        Vector<Brand> listBrand = new Vector<>();
        listBrand = daoPro.getAllBrands();
        Vector<Model> listModel = new Vector<>();
        listModel = daoPro.getAllModels();
        Vector<engine> listEngine = new Vector<>();
        listEngine = daoPos.getAllEngine();
        Vector<gearbox> listGearbox = daoPos.getAllGearbox();
        Vector<exteriorColor> listColor = daoPos.getAllExteriorColor();
        Vector<Origin> listOrigin = daoPos.getAllOrigin();
        request.setAttribute("posts", posts);
        request.setAttribute("listOrigin", listOrigin);
        request.setAttribute("listColor", listColor);
        request.setAttribute("listGearbox", listGearbox);
        request.setAttribute("listEngine", listEngine);
        request.setAttribute("listModel", listModel);
        request.setAttribute("listBrand", listBrand);
        request.getRequestDispatcher("/JSP/home.jsp").forward(request, response);
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
        DAOClient daoCli = new DAOClient();
        DAOProvider daoPro = new DAOProvider();
        DAOPost daoPos = new DAOPost();
        String username = request.getParameter("user");
        String password = request.getParameter("pass");

        Client acc = daoCli.validate(username, new MD5().getMd5(password));
        Provider accPro = daoPro.login(username, new MD5().getMd5(password));

        if (acc != null && acc.isStatus() == false) {
            request.setAttribute("mess", "Your client account is banned");
            request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
        } else if (accPro != null && accPro.isStatus() == false) {
            request.setAttribute("mess", "Your provider account is banned");
            request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
        } else if (acc != null || accPro != null) {
            HttpSession session = request.getSession();
            if (acc != null) {
                session.setAttribute("currentAcc", acc);
                session.setMaxInactiveInterval(60 * 60 * 12); // 12 hours
                session.setAttribute("userType", "client");
            }
            if (accPro != null) {
                session.setAttribute("currentAcc", accPro);
                session.setMaxInactiveInterval(60 * 60 * 12); // 12 hours
                session.setAttribute("userType", "provider");
            }
            List<Post> posts = daoPos.getPostsSortedByDate();
            Vector<Post> AllPost = daoPos.getAllPost();
            request.setAttribute("AllPost", AllPost);
            Vector<Brand> listBrand = new Vector<>();
            listBrand = daoPro.getAllBrands();
            Vector<Model> listModel = new Vector<>();
            listModel = daoPro.getAllModels();
            Vector<engine> listEngine = new Vector<>();
            listEngine = daoPos.getAllEngine();
            Vector<gearbox> listGearbox = daoPos.getAllGearbox();
            Vector<exteriorColor> listColor = daoPos.getAllExteriorColor();
            Vector<Origin> listOrigin = daoPos.getAllOrigin();
            request.setAttribute("posts", posts);
            request.setAttribute("listOrigin", listOrigin);
            request.setAttribute("listColor", listColor);
            request.setAttribute("listGearbox", listGearbox);
            request.setAttribute("listEngine", listEngine);
            request.setAttribute("listModel", listModel);
            request.setAttribute("listBrand", listBrand);
            request.getRequestDispatcher("/JSP/home.jsp").forward(request, response);
        } else {
            request.setAttribute("mess", "Invalid email or password");
            request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
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
