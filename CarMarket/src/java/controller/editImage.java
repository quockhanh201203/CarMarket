/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.CarImage;
import entity.Client;
import entity.Post;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import model.DAOPost;

/**
 *
 * @author admin
 */
@WebServlet(name = "editImage", urlPatterns = {"/editImage"})
public class editImage extends HttpServlet {

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
            out.println("<title>Servlet editImage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editImage at " + request.getContextPath() + "</h1>");
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
        int PostId = Integer.parseInt(request.getParameter("PostID"));
        int carId = Integer.parseInt(request.getParameter("CarID"));
        String carName = request.getParameter("CarName");
        int Year = Integer.parseInt(request.getParameter("year"));
        int Origin = Integer.parseInt(request.getParameter("origin"));
        int GearBox = Integer.parseInt(request.getParameter("gearbox"));
        int Engine = Integer.parseInt(request.getParameter("engine"));
        int Interior = Integer.parseInt(request.getParameter("interiorColor"));
        int Exterior = Integer.parseInt(request.getParameter("exteriorColor"));
        int Seats = Integer.parseInt(request.getParameter("numberOfSeats"));
        int Doors = Integer.parseInt(request.getParameter("numberOfDoors"));
        float Price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        Boolean Status = false;
        Date currentDate = new Date();
        // For demonstration purposes, printing values to the console
        HttpSession session = request.getSession(false);
        if (session == null) {
            request.setAttribute("mess", "Session is null. Redirecting to login page.");
            request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
            return;
        }
        
        Client acc = (Client) session.getAttribute("currentAcc");
        String userType = (String) session.getAttribute("userType");
        
        if (acc == null) {
            request.setAttribute("mess", "User not logged in. Redirecting to login page.");
            request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
            return;
        }
        
        Post post = new Post();
        post.setPostId(PostId);
        post.setUserId(acc.getClientId());
        post.setCarId(carId);
        post.setCarName(carName);
        post.setOriginId(Origin);
        post.setGearboxId(GearBox);
        post.setEngineId(Engine);
        post.setInteriorColorId(Interior);
        post.setExteriorColorId(Exterior);
        post.setNumberOfSeatsId(Seats);
        post.setNumberOfDoorsId(Doors);
        post.setPriceCar(Price);
        post.setPostDate(currentDate);
        post.setStatus(Status);
        post.setDescriptions(description);
        post.setYear(Year);
        DAOPost dao = new DAOPost();
        boolean result = dao.updatePostByID(post);
        if (result== true) {
            List<CarImage> images = dao.getImageByPostId(PostId);
            request.setAttribute("images", images);
            request.setAttribute("postId", PostId);
            request.getRequestDispatcher("/JSP/editImage.jsp").forward(request, response);
        } else {
            System.out.println("Failed to insert post into database. Redirecting to login page.");
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
