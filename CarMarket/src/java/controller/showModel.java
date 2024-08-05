package controller;

import entity.Model;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Vector;
import model.DAOProvider;

/**
 *
 * @author admin
 */
@WebServlet(name = "showModel", urlPatterns = {"/showModel"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
    maxFileSize = 1024 * 1024 * 10,      // 10 MB
    maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class showModel extends HttpServlet {

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
            out.println("<title>Servlet showModel</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet showModel at " + request.getContextPath() + "</h1>");
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
        DAOProvider dao = new DAOProvider();
        Vector<Model> vector = new Vector<>();
        vector = dao.getAllModels();
        request.setAttribute("listModel", vector);
        request.getRequestDispatcher("./JSP/model.jsp").forward(request, response);
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
        Model md = new Model();
        String model = request.getParameter("ModelName");
        Part filePart = request.getPart("modelImage");
        String profileImagePath = md.getModelImg();

        if (filePart != null && filePart.getSize() > 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            if (!fileName.toLowerCase().endsWith(".png")) {
                request.setAttribute("mess", "Only .png files are allowed for profile images.");
                request.getRequestDispatcher("./JSP/insertModel.jsp").forward(request, response);
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

        md.setModelName(model);
        md.setModelImg(profileImagePath);

        DAOProvider dao = new DAOProvider();
        try {
            int result = dao.insertModel(md);
            if (result > 0) {
                request.setAttribute("mess", "Create Model successfully!");
            } else {
                request.setAttribute("mess", "Failed to create model.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mess", "Failed to create model due to an error.");
        }
        request.getRequestDispatcher("./JSP/insertModel.jsp").forward(request, response);
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
