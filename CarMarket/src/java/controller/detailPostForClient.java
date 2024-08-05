/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Brand;
import entity.Car;
import entity.CarImage;
import entity.Client;
import entity.Model;
import entity.Origin;
import entity.Post;
import entity.engine;
import entity.exteriorColor;
import entity.gearbox;
import entity.interiorColor;
import entity.numberOfDoors;
import entity.numberOfSeats;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.DAOPost;
import model.DAOProvider;

/**
 *
 * @author admin
 */
@WebServlet(name = "detailPostForClient", urlPatterns = {"/detailPostForClient"})
public class detailPostForClient extends HttpServlet {

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
            out.println("<title>Servlet detailPostForClient</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet detailPostForClient at " + request.getContextPath() + "</h1>");
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
        int postId = Integer.parseInt(request.getParameter("postId"));
        DAOPost dao = new DAOPost();
        DAOProvider daoPro = new DAOProvider();
        Post post = dao.getPostById(postId);
        gearbox gb = dao.getGearboxById(post.getGearboxId());
        Origin origin = dao.getOriginById(post.getOriginId());
        interiorColor inColor = dao.getInteriorColorById(post.getInteriorColorId());
        exteriorColor exColor = dao.getExteriorColorById(post.getExteriorColorId());
        numberOfDoors doors = dao.getDoorById(post.getNumberOfDoorsId());
        engine eg = dao.getEngineById(post.getEngineId());
        numberOfSeats seats = dao.getSeatById(post.getNumberOfSeatsId());
        Client client = daoPro.getClientByID(post.getUserId());
        Car car = dao.getCarById(post.getCarId());
        Brand br = dao.getBrandById(car.getBrandId());
        Model md = dao.getModelById(car.getModelId());
        List<CarImage> image = dao.getImageByPostId(postId);

        request.setAttribute("postId", postId);
        request.setAttribute("post", post);
        request.setAttribute("image", image);
        request.setAttribute("gb", gb);
        request.setAttribute("origin", origin);
        request.setAttribute("inColor", inColor);
        request.setAttribute("exColor", exColor);
        request.setAttribute("doors", doors);
        request.setAttribute("eg", eg);
        request.setAttribute("seats", seats);
        request.setAttribute("client", client);
        request.setAttribute("car", car);
        request.setAttribute("br", br);
        request.setAttribute("md", md);
        request.getRequestDispatcher("/JSP/detailPostForClient.jsp").forward(request, response);
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
