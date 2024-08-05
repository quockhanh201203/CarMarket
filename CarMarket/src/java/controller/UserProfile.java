package controller;

import entity.Client;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.File;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.PrintWriter;
import model.DAOClient;

/**
 *
 * @author admin
 */
@WebServlet(name = "UserProfile", urlPatterns = {"/profile"})
@MultipartConfig // Annotation to enable file upload
public class UserProfile extends HttpServlet {

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
            out.println("<title>Servlet UserProfile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserProfile at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("./JSP/profile.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("currentAcc");

        if (client == null) {
            request.setAttribute("mess", "Session expired or not logged in.");
            request.getRequestDispatcher("./JSP/login.jsp").forward(request, response);
            return;
        }

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        // Get the file part
        Part filePart = request.getPart("profileImage");
        String profileImagePath = client.getImage(); // Keep existing image path if no new file is uploaded

        // Handle file upload if a new file is provided
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            // Check if the file has a ".jpg" extension
            if (!fileName.toLowerCase().endsWith(".jpg")) {
                request.setAttribute("mess", "Only .jpg files are allowed for profile images.");
                request.getRequestDispatcher("./JSP/profile.jsp").forward(request, response);
                return;
            }

            String uploadDir = getServletContext().getRealPath("") + File.separator + "uploads";
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }

            File file = new File(uploadDir + File.separator + fileName);
            try (InputStream fileContent = filePart.getInputStream()) {
                Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            profileImagePath = "uploads/" + fileName;
        }

        if (firstName == null || lastName == null || email == null || phone == null || address == null) {
            request.setAttribute("mess", "All fields are required.");
            request.getRequestDispatcher("./JSP/profile.jsp").forward(request, response);
            return;
        }

        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(email);
        client.setPhoneNumber(phone);
        client.setAddress(address);
        client.setImage(profileImagePath);

        DAOClient daoCli = new DAOClient();
        try {
            int result = daoCli.updateAccount(client, client.getClientId());
            if (result > 0) {
                request.setAttribute("mess", "Update account information successfully!");
            } else {
                request.setAttribute("mess", "Failed to update account information.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mess", "Failed to update account information due to an error.");
        }

        request.getRequestDispatcher("./JSP/profile.jsp").forward(request, response);
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
