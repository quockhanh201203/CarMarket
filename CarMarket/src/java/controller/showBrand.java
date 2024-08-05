package controller;

import entity.Brand;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;
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

@WebServlet(name = "showBrand", urlPatterns = {"/showBrand"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
    maxFileSize = 1024 * 1024 * 10,      // 10 MB
    maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class showBrand extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet showBrand</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet showBrand at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOProvider dao = new DAOProvider();
        Vector<Brand> vector = new Vector<>();
        vector = dao.getAllBrands();
        request.setAttribute("listBrand", vector);
        request.getRequestDispatcher("./JSP/brand.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Brand br = new Brand();
        String brand = request.getParameter("BrandName");
        Part filePart = request.getPart("brandImage");
        String profileImagePath = br.getBrandImg(); // Keep existing image path if no new file is uploaded

        if (filePart != null && filePart.getSize() > 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            if (!fileName.toLowerCase().endsWith(".png")) {
                request.setAttribute("mess", "Only .png files are allowed for profile images.");
                request.getRequestDispatcher("./JSP/insertBrand.jsp").forward(request, response);
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

        br.setBrandName(brand);
        br.setBrandImg(profileImagePath);

        DAOProvider dao = new DAOProvider();
        try {
            int result = dao.insertBrands(br);
            if (result > 0) {
                request.setAttribute("mess", "Create Brand successfully!");
            } else {
                request.setAttribute("mess", "Failed to create brand.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mess", "Failed to create brand due to an error.");
        }
        request.getRequestDispatcher("./JSP/insertBrand.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
