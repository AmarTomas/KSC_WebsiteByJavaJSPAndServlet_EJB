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

public class InsertTopicServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String time = request.getParameter("time");
        String activity_id = request.getParameter("activity_id");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            long lastActivityId = 0;
            // Establish database connection
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");

            // Prepare SQL statement
            String sql = "INSERT INTO topics (name, time) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, time);
            String selectLastActivityIdQuery = "SELECT MAX(id) FROM topics";
            Statement selectStatement = conn.createStatement();
            rs = selectStatement.executeQuery(selectLastActivityIdQuery);
            if (rs.next()) {

                lastActivityId = rs.getLong(1);
                System.out.println("آخر ID للنشاط: " + lastActivityId);
            }
            // Execute the statement
            stmt.executeUpdate();
            String sql1 = "INSERT INTO `activity_topics`(`activity_id`, `Topic_id`) VALUES (?,?)";
            stmt = conn.prepareStatement(sql1);
            stmt.setString(1, activity_id);
            stmt.setLong(2, lastActivityId);

            // Execute the statement
            stmt.executeUpdate();

         String message = "This data has been entered successfully.";
            // Redirect to a success page or display a success message
            response.sendRedirect("add_detailes.jsp?activity_id=" + activity_id  + "&message=" + URLEncoder.encode(message, "UTF-8"));
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any database errors or display an error message
            response.sendRedirect("error.html");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertTopicServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
