
package subscribe;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UnsubscriptionServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ksc";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
     HttpSession session = request.getSession();
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "UPDATE users SET status = 0 WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
            session.setAttribute("status", 0);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                // Update successful
                response.sendRedirect("../Subscriptions/Subscriptions.jsp");
            } else {
                // Update failed
                // Handle error or display a message to the user
                response.getWriter().println("Failed to update status. Please try again.");
            }
        } catch (SQLException e) {
            // Handle database connection or query errors
            e.printStackTrace();
            response.getWriter().println("Database error occurred. Please try again later.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UnsubscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}