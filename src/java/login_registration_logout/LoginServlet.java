package login_registration_logout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String email = request.getParameter("email");
    String password1 = request.getParameter("password");

    // Database connection parameters
//    String url = "jdbc:mysql://localhost:3306/mydatabase";
//    String username = "your-username";
//    String password = "your-password";

    // JDBC code for login verification
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc","root","");

      // Prepare the SQL statement
      String sql = "SELECT * FROM users WHERE email=? AND password=?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, email);
      statement.setString(2, password1);

      // Execute the query
      ResultSet resultSet = statement.executeQuery();

      // Check if the user exists
      if (resultSet.next()) {
          int userId = resultSet.getInt("id");
          int status =resultSet.getInt("status");
          int admin_is =resultSet.getInt("admin_is");
        // Login successful, set user session and redirect
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
         session.setAttribute("id", userId); 
          session.setAttribute("status", status); 
          session.setAttribute("admin_is", admin_is); 
        response.sendRedirect("../home/home.jsp");
      } else {
        // Login failed, redirect to an error page or display an error message
        response.sendRedirect("../login_registration_login/loginFailed.jsp");
      }

      // Close database resources
      resultSet.close();
      statement.close();
      connection.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      // Handle database connection or query errors
      response.sendRedirect("error.jsp");
    }
  }
}
