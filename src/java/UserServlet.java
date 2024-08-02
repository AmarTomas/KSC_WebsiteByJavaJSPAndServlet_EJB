import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc?zeroDateTimeBehavior=convertToNull", "root", "")) {
            if ("create".equals(action)) {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, name);
                    stmt.setString(2, email);
                    stmt.executeUpdate();
                }
            } else if ("edit".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String sql = "UPDATE users SET name=?, email=? WHERE id=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//                    stmt.setStringApologies for the incomplete response. Here's the remaining code for the `UserServlet`:stmt.setString(1, name);
                       stmt.setString(2, email);
                       stmt.setInt(3, id);
                       stmt.executeUpdate();
                   }
               } else if ("delete".equals(action)) {
                   int id = Integer.parseInt(request.getParameter("id"));
                   String sql = "DELETE FROM users WHERE id=?";
                   try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                       stmt.setInt(1, id);
                       stmt.executeUpdate();
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
               // Handle database error
           }

           response.sendRedirect("index.jsp");
       }
   }