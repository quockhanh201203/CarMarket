/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Brand;
import entity.Client;
import entity.Model;
import entity.Origin;
import entity.Post;
import entity.Provider;
import entity.engine;
import entity.exteriorColor;
import entity.gearbox;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Vector;
import model.DAOClient;
import model.DAOPost;
import model.DAOProvider;

/**
 *
 * @author admin
 */
@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {

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
            out.println("<title>Servlet Home</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Home at " + request.getContextPath() + "</h1>");
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
        Provider acc = (Provider) session.getAttribute("currentAcc");
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
