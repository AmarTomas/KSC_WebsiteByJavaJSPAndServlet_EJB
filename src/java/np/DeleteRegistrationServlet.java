/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np;

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

/**
 *
 * @author MC
 */
public class DeleteRegistrationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Retrieve the activity ID from the request parameters
    String activityId = request.getParameter("activityId");

    // Retrieve users with status = 0 from the database
        try {     Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");
 // Prepare the DELETE statement
        String sql = "DELETE FROM registration WHERE activity_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, activityId);

        // Execute the DELETE statement
        int rowsAffected = statement.executeUpdate();

        // Handle the result
        if (rowsAffected > 0) {
            // Registration deleted successfully
              response.sendRedirect("../home/home.jsp");
        } else {
            // No matching registration found
            response.getWriter().println("No matching registration found");
        }
    } catch (SQLException e) {
        // Handle any database errors
        e.printStackTrace();
        response.getWriter().println("An error occurred while deleting the registration");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(DeleteRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
