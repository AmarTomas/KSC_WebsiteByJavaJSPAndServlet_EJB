//import app.Card;
//import java.io.IOException;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class CardServlet extends HttpServlet {
//    private Connection getConnection() throws SQLException
//        {
//             String url = "jdbc:mysql://localhost:3306/ksc?zeroDateTimeBehavior=convertToNull";
//    String username = "root";
//    String password = "";
//            return DriverManager.getConnection(url, username, password);
//        }
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Card> cards = new ArrayList<>();
//        
//        // Database connection parameters
//    
//        
//        // JDBC variables
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        
//        try {
//            // Create a database connection
//             Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("ssssssssssssss11111111111111111111111111111111");
//     
//             conn=getConnection();
//            
//            // Create a SQL statement
//            String sql = "SELECT * FROM card ;";
//            stmt = conn.createStatement();
//            
//            // Execute the SQL statement
//            rs = stmt.executeQuery(sql);
//            
//            // Process the result set
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String image = rs.getString("imagePath");
//                String title = rs.getString("title");
//                String description = rs.getString("description");
//                
//                Card card = new Card(id, image, title, description);
//                cards.add(card);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(CardServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            // Close the JDBC objects
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (stmt != null) {
//                    stmt.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        
//        request.setAttribute("cards", cards);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("card.jsp");
//        dispatcher.forward(request, response);
//    }
//}