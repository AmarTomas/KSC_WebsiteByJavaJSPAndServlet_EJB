package Add_images_Winners;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        Part filePart = request.getPart("image");
        
        InputStream imageStream = filePart.getInputStream();
        ResultSet rs = null;
        
        try {
            long lastActivityId = 1;
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");
            String sql = "INSERT INTO images (name, image) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setBlob(2, imageStream);
            statement.executeUpdate();
            String selectLastActivityIdQuery = "SELECT MAX(id) FROM images";
            Statement selectStatement = conn.createStatement();
            rs = selectStatement.executeQuery(selectLastActivityIdQuery);
            if (rs.next()) {
                lastActivityId = rs.getLong(1);
                System.out.println("آخر ID للنشاط: " + lastActivityId);
            }
            statement.close();
            conn.close();
            
         String message = "This data has been entered successfully.";
            response.sendRedirect("Add_Winners.jsp?image_id=" + lastActivityId + "&message=" + URLEncoder.encode(message, "UTF-8"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}