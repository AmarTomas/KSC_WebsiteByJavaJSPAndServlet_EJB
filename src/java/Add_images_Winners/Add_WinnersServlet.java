package Add_images_Winners;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Add_WinnersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String expertise = request.getParameter("expertise");
        String imageId = request.getParameter("image_id");

    
  ResultSet rs = null;
        
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");
            String sql = "INSERT INTO winners (name, age, expert, image_id) VALUES (?, ?, ?, ?)";		
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, expertise);
            statement.setString(4, imageId);
            statement.executeUpdate();

            statement.close();
            conn.close();
          
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Add_WinnersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         String message = "This data has been entered successfully.";
response.sendRedirect("Add_Winners.jsp?image_id=" + imageId  + "&message=" + URLEncoder.encode(message, "UTF-8"));
    }
}