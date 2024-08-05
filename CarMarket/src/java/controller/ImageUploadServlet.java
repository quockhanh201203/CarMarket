import entity.CarImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.DAOPost;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/doneCreatePost")
@MultipartConfig
public class ImageUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ImageUploadServlet.class.getName());
    private static final String UPLOAD_DIR = "uploads";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Lấy giá trị PostID từ form
            String postIdStr = request.getParameter("PostID");
            if (postIdStr == null || postIdStr.isEmpty()) {
                out.println("PostID không được cung cấp");
                return;
            }

            int postId = Integer.parseInt(postIdStr);

            // Kiểm tra và in ra giá trị PostID để debug
            LOGGER.info("PostID: " + postId);

            // Đảm bảo thư mục upload tồn tại
            String applicationPath = getServletContext().getRealPath("");
            String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
            File uploadFolder = new File(uploadFilePath);
            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs();
                LOGGER.info("Created upload directory: " + uploadFilePath);
            }

            // Lấy các phần khác của request
            boolean allUploaded = true;
            for (Part part : request.getParts()) {
                String fileName = getFileName(part);
                if (fileName != null && !fileName.isEmpty()) {
                    String filePath = uploadFilePath + File.separator + fileName;
                    try {
                        part.write(filePath);
                        LOGGER.info("File uploaded to: " + filePath);

                        CarImage img = new CarImage();
                        img.setPostId(postId); // Thiết lập postId cho hình ảnh
                        img.setPostImg(UPLOAD_DIR + "/" + fileName); // Lưu đường dẫn tệp thay vì nội dung

                        DAOPost dao = new DAOPost();
                        int result = dao.insertImg(img);

                        if (result <= 0) {
                            LOGGER.warning("Failed to insert image path to database for file: " + fileName);
                            allUploaded = false;
                        } else {
                            LOGGER.info("Image path inserted into database for file: " + fileName);
                        }
                    } catch (IOException e) {
                        LOGGER.log(Level.SEVERE, "Failed to upload file: " + fileName, e);
                        allUploaded = false;
                    }
                }
            }

            if (allUploaded) {
                response.sendRedirect(request.getContextPath() + "/JSP/success.jsp");
            } else {
                out.println("Lưu một hoặc nhiều ảnh thất bại.");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occurred while uploading images", e);
        }
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        if (contentDisp != null) {
            for (String cd : contentDisp.split(";")) {
                if (cd.trim().startsWith("filename")) {
                    return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                }
            }
        }
        return null;
    }
}
