package controller;

import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;
import model.DAOPost;
import model.DAOProvider;

@WebServlet(name = "createPost", urlPatterns = {"/createPost"})
public class createPost extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet createPost</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createPost at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOProvider daoPro = new DAOProvider();
        Vector<Brand> listBrand = daoPro.getAllBrands();
        Vector<Model> listModel = daoPro.getAllModels();
        request.setAttribute("listModel", listModel);
        request.setAttribute("listBrand", listBrand);
        request.getRequestDispatcher("/JSP/createCar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null) {
            Client acc = (Client) session.getAttribute("currentAcc");

            if (acc != null) {
                try {
                    int brand = Integer.parseInt(request.getParameter("brand"));
                    int model = Integer.parseInt(request.getParameter("model"));

                    Car car = new Car();
                    car.setBrandId(brand);
                    car.setModelId(model);
                    car.setUserId(acc.getClientId());

                    DAOPost dao = new DAOPost();
                    int result = dao.insertCar(car);

                    if (result > 0) {
                        Integer newPostCount = (Integer) session.getServletContext().getAttribute("newPostCount");
                        if (newPostCount == null) {
                            newPostCount = 0;
                        }
                        newPostCount++;
                        session.getServletContext().setAttribute("newPostCount", newPostCount);

                        request.setAttribute("carId", result);

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

                        request.getRequestDispatcher("/JSP/createPost.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mess", "Failed to create a post. Please try again.");
                        request.getRequestDispatcher("/JSP/createCar.jsp").forward(request, response);
                    }
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
    }

    @Override
    public String getServletInfo() {
        return "Servlet to create a new post for a car";
    }
}
