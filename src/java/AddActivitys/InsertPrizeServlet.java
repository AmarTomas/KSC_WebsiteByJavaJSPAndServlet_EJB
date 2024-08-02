package AddActivitys;

import java.io.IOException;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertPrizeServlet extends HttpServlet {
    // JDBC connection details

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String activityId = request.getParameter("activityId");
        Connection conn = null;
    
        ResultSet rs = null;
        try {
            long lastActivityId = 0;
            // Establish database connection
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");
            String sql = "INSERT INTO prizes (name, description, activity_id) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setString(3, activityId);
            statement.executeUpdate();
            String selectLastActivityIdQuery = "SELECT MAX(id) FROM prizes";
            Statement selectStatement = conn.createStatement();
            rs = selectStatement.executeQuery(selectLastActivityIdQuery);
            if (rs.next()) {

                lastActivityId = rs.getLong(1);
                System.out.println("آخر ID للنشاط: " + lastActivityId);
            }
            // Execute the statement
            

         String message = "This data has been entered successfully.";
            // Redirect to a success page or display a success message
            response.sendRedirect("add_detailes.jsp?activity_id=" + activityId  + "&message=" + URLEncoder.encode(message, "UTF-8"));
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any database errors or display an error message
            response.sendRedirect("error.html");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertTopicServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
