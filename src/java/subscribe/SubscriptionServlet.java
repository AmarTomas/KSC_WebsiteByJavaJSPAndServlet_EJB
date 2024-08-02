package subscribe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SubscriptionServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ksc";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
     HttpSession session = request.getSession();
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "UPDATE users SET status = 1 WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
           statement.executeUpdate();
             String sql1 = "INSERT INTO `subscriptions`( `date`, `user_id`) VALUES (?,?)";
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            statement1.setDate(1,Date.valueOf(LocalDate.now()));
            statement1.setInt(2, userId);
            statement1.executeUpdate();
session.setAttribute("status", 1);
//            if (rowsUpdated > 0) {
//                // Update successful
//                response.sendRedirect("../Subscriptions/Subscriptions.jsp");
//            } else {
                // Update failed
                // Handle error or display a message to the user
//                response.getWriter().println("Failed to update status. Please try again.");
response.sendRedirect("../Subscriptions/Subscriptions.jsp");
//            }
        } catch (SQLException e) {
            // Handle database connection or query errors
            e.printStackTrace();
            response.getWriter().println("Database error occurred. Please try again later.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
          
    }
}