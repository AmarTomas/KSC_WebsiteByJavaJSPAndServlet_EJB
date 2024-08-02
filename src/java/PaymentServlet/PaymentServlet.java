package PaymentServlet;

import java.io.IOException;
import java.sql.Connection;
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


public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
                  
        String userId = (String) session.getAttribute("id").toString();
        String activity_id = request.getParameter("name").toString();
        String paymentMethod = request.getParameter("paymentMethod");
        double amount = Double.parseDouble(request.getParameter("amount"));

        // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/ksc";
        String dbUsername = "root";
        String dbPassword = "";

        // Insert payment details into the database
        try  {
            
                 Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
//            INSERT INTO `payments`(`id`, `paymentMethod`, `date`, `amount`, `user_id`, `active_id`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]')
            String sql = "INSERT INTO payments (paymentMethod,date,amount,user_id,active_id) VALUES (?, ?, ?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, paymentMethod);
            statement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            statement.setDouble(3, amount);
            statement.setInt(4,Integer.parseInt(userId));
            statement.setInt(5, Integer.parseInt(activity_id));
            
            
            System.out.println("ssssssssssssssssssssssssssssssssssssssssss");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();System.out.println("srrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrs");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
try  {
    Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
      String sql = "INSERT INTO `registration`(`user_id`, `activity_id`) VALUES(?,?)";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setInt(1,Integer.parseInt(userId));
      statement.setInt(2, Integer.parseInt(activity_id));
      statement.executeUpdate();
      System.out.println("ssssssssssssssssssssssssssssssssssssssssss");
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("srrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrs");
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("../Activitys/Shared_activities.jsp");
    }
}