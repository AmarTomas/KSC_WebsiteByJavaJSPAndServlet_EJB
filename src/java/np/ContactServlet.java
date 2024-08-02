package np;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactServlet extends HttpServlet {
 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        // Insert data into the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");
            String sql = "INSERT INTO contact (name, email, message) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, message);
             String successMessage = "Form submitted successfully!";
        request.setAttribute("successMessage", successMessage);

            statement.executeUpdate();
            statement.close();
            conn.close();
// String message1 = "This data has been entered successfully.";
//             + "&message1=" + URLEncoder.encode(message1, "UTF-8")
        // Provide feedback to the user
        response.sendRedirect("../home/contact.jsp" );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle the error appropriately
        }

        // Redirect to a success page
    }
}