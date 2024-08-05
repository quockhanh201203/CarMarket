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
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Vector;
import model.DAOPost;
import model.DAOProvider;

/**
 *
 * @author admin
 */
@WebServlet(name = "editPost", urlPatterns = {"/editPost"})
public class editPost extends HttpServlet {

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
            out.println("<title>Servlet editPost</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editPost at " + request.getContextPath() + "</h1>");
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
        Vector<Brand> listBrand = daoPro.getAllBrands();
        Vector<Model> listModel = daoPro.getAllModels();
        request.setAttribute("listModel", listModel);
        request.setAttribute("listBrand", listBrand);
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

        request.getRequestDispatcher("/JSP/editCar.jsp").forward(request, response);

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
        int id = Integer.parseInt(request.getParameter("carId"));
        int brand = Integer.parseInt(request.getParameter("brand"));
        int model = Integer.parseInt(request.getParameter("model"));
        int postId = Integer.parseInt(request.getParameter("postId"));
        HttpSession session = request.getSession(false);
        if (session != null) {
            Client acc = (Client) session.getAttribute("currentAcc");
            if (acc != null) {
                try {
                    Car car = new Car();
                    car.setCarId(id);
                    car.setBrandId(brand);
                    car.setModelId(model);
                    car.setUserId(acc.getClientId());
                    DAOProvider daoPro = new DAOProvider();
                    DAOPost dao = new DAOPost();
                    dao.updateCar(car);

                    request.setAttribute("carId", id);

                    Post post = dao.getPostById(postId);
                    gearbox gb = dao.getGearboxById(post.getGearboxId());
                    Origin origin = dao.getOriginById(post.getOriginId());
                    interiorColor inColor = dao.getInteriorColorById(post.getInteriorColorId());
                    exteriorColor exColor = dao.getExteriorColorById(post.getExteriorColorId());
                    numberOfDoors doors = dao.getDoorById(post.getNumberOfDoorsId());
                    engine eg = dao.getEngineById(post.getEngineId());
                    numberOfSeats seats = dao.getSeatById(post.getNumberOfSeatsId());
                    Client client = daoPro.getClientByID(post.getUserId());
                    Car car2 = dao.getCarById(post.getCarId());
                    Brand br = dao.getBrandById(car2.getBrandId());
                    Model md = dao.getModelById(car2.getModelId());
                    List<CarImage> image = dao.getImageByPostId(postId);
                    Vector<Brand> listBrand = daoPro.getAllBrands();
                    Vector<Model> listModel = daoPro.getAllModels();
                    request.setAttribute("listModel", listModel);
                    request.setAttribute("listBrand", listBrand);
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
                    request.setAttribute("car", car2);
                    request.setAttribute("br", br);
                    request.setAttribute("md", md);

                    Vector<engine> listEngine = dao.getAllEngine();
                    request.setAttribute("listEngine", listEngine);

                    Vector<gearbox> listGearBox = dao.getAllGearbox();
                    request.setAttribute("listGearBox", listGearBox);

                    Vector<numberOfSeats> listSeats = dao.getAllSeat();
                    request.setAttribute("listSeats", listSeats);

                    Vector<Origin> listOrigin = dao.getAllOrigin();
                    request.setAttribute("listOrigin", listOrigin);

                    Vector<exteriorColor> listExteriorColor = dao.getAllExteriorColor();
                    request.setAttribute("listExteriorColor", listExteriorColor);

                    Vector<numberOfDoors> listDoors = dao.getAllDoor();
                    request.setAttribute("listDoors", listDoors);

                    Vector<interiorColor> listInteriorColor = dao.getAllInteriorColor();
                    request.setAttribute("listInteriorColor", listInteriorColor);

                    request.getRequestDispatcher("/JSP/editPostDetail.jsp").forward(request, response);

                } catch (NumberFormatException e) {
                    request.setAttribute("mess", "Invalid input. Please enter valid data.");
                    request.getRequestDispatcher("/JSP/createCar.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
        }
//        try (PrintWriter out = response.getWriter()) {
//            int id = Integer.parseInt(request.getParameter("id"));
//            int brand = Integer.parseInt(request.getParameter("brand"));
//            int model = Integer.parseInt(request.getParameter("model"));
//            out.println(id);
//            out.println(brand);
//            out.println(model);
//        }

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
