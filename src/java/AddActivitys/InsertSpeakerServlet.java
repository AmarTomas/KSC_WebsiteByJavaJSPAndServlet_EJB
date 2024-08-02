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

public class InsertSpeakerServlet extends HttpServlet {
    // JDBC connection details

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String expert = request.getParameter("expert");
        String activityId = request.getParameter("activityId");

        PreparedStatement stmt = null;
        ResultSet rs = null;
        // Database connection details

        try {
            long lastActivityId = 0;
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");
            String sql = "INSERT INTO `names of speakers` (name, expert) VALUES ( ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, expert);
            
            // Execute the statement
            statement.executeUpdate();
            String selectLastActivityIdQuery = "SELECT MAX(id) FROM `names of speakers`";
            Statement selectStatement = conn.createStatement();
            rs = selectStatement.executeQuery(selectLastActivityIdQuery);
            if (rs.next()) {

                lastActivityId = rs.getLong(1);
                System.out.println("آخر ID للنشاط: " + lastActivityId);
            }
            String sql1 = "INSERT INTO `activitys_names_of_speakers`(`activity_id`, `name_speak_id`) VALUES (?,?)";
            stmt = conn.prepareStatement(sql1);
            stmt.setString(1, activityId);
            stmt.setLong(2, lastActivityId);

            // Execute the statement
            stmt.executeUpdate();

         String message = "This data has been entered successfully.";
            // Redirect to a success page or display a success message
            response.sendRedirect("add_detailes.jsp?activity_id=" + activityId  + "&message=" + URLEncoder.encode(message, "UTF-8"));
        } catch (SQLException e) {
            // Handle any database errors
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertSpeakerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Redirect to a success page or appropriate response
    }
}
