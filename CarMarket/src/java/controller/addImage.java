
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
import model.DAOPost;

@WebServlet(name = "addImage", urlPatterns = {"/addImage"})
public class addImage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addImage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addImage at " + request.getContextPath() + "</h1>");
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
        int CarId = Integer.parseInt(request.getParameter("CarID"));
        String CarName = request.getParameter("CarName");
        int Year = Integer.parseInt(request.getParameter("year"));
        int Origin = Integer.parseInt(request.getParameter("origin"));
        int GearBox = Integer.parseInt(request.getParameter("gearbox"));
        int Engine = Integer.parseInt(request.getParameter("engine"));
        int Interior = Integer.parseInt(request.getParameter("interiorColor"));
        int Exterior = Integer.parseInt(request.getParameter("exteriorColor"));
        int Seats = Integer.parseInt(request.getParameter("numberOfSeats"));
        int Doors = Integer.parseInt(request.getParameter("numberOfDoors"));
        float Price = Float.parseFloat(request.getParameter("price"));
        Date currentDate = new Date();
        Boolean Status = false;
        String Description = request.getParameter("description");
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
        post.setUserId(acc.getClientId());
        post.setCarId(CarId);
        post.setCarName(CarName);
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
        post.setDescriptions(Description);
        post.setYear(Year);
        DAOPost dao = new DAOPost();
        int result = dao.insertPost(post);
        if (result > 0) {
            request.setAttribute("postId", result);
            request.getRequestDispatcher("/JSP/addImage.jsp").forward(request, response);
        } else {
            System.out.println("Failed to insert post into database. Redirecting to login page.");
            request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
