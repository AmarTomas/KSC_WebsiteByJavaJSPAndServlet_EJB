/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np;

import app.Winners;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WinnersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    String imageIdParam = request.getParameter("image_id");
    int imageId =9 ;
    List<Winners> winnersList = getWinner(imageId);
     request.setAttribute("winnersList", winnersList);
    request.getRequestDispatcher("winners.jsp").forward(request, response);
   }
 public List<Winners> getWinner(int  imageId){
    List<Winners> winnersList = new ArrayList<>();
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM winners WHERE image_id = ?");
        statement.setInt(1,imageId);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String expert = resultSet.getString("expert");
            Winners winner = new Winners(id, name, age, expert, imageId);
            winnersList.add(winner);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(WinnersServlet.class.getName()).log(Level.SEVERE, null, ex);
    }   return winnersList;
}}
 