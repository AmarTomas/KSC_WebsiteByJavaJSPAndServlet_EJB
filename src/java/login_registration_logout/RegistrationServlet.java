/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_registration_logout;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MC
 */
@WebServlet("/registrationServlet")
public class RegistrationServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password1 = request.getParameter("password");
    int stu = 0;
    int admin = 0;
    // Database connection parameters
//    String url = "jdbc:mysql://localhost:3306/mydatabase";
//    String username = "your-username";
//    String password = "your-password";

    // JDBC code for registration
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc","root","");

      // Prepare the SQL statement
      String sql = "INSERT INTO users (name, email, password,status,admin_is) VALUES (?, ?, ?,?,?)";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, name);
      statement.setString(2, email);
      statement.setString(3, password1);
  statement.setInt(4, stu);
  statement.setInt(5, admin);
      // Execute the query
      int rowsInserted = statement.executeUpdate();
//       ResultSet resultSet = statement.executeQuery();

      if (rowsInserted > 0) {
              
        // Registration successful, set user session and redirect
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
         session.setAttribute("admin_is", admin);
          session.setAttribute("status", stu);
         response.sendRedirect("../Hi.jsp");
      } else {
        // Registration failed, redirect to an error page or display an error message
        response.sendRedirect("../login_registration_login/loginFailed.jsp");
      }

      // Close database resources
      statement.close();
      connection.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      // Handle database connection or query errors
      response.sendRedirect("../error.jsp");
    }
  }
}
