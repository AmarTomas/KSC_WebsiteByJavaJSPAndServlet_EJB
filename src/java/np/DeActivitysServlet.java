/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np;

import app.Card;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MC
 */
public class DeActivitysServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String userId = (String) session.getAttribute("id").toString();
        List<Card> cardList0 = getAllActivitys_user_id(userId);
//        request.setAttribute("cardList", cardList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("deactivitys.jsp");
        dispatcher.forward(request, response);

    }

    public List<Card> getAllActivitys_user_id(String userId) {
        List<Card> cardList = new ArrayList<>();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // JDBC code to retrieve card data from the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");
//            Statement statement = connection.createStatement();
            String query = "CALL `activitys_No_user_id`(?)";
            stmt = connection.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(userId));

            rs = stmt.executeQuery();
            while (rs.next()) {
                Card card = new Card();
                card.setId(rs.getInt("id"));
                card.setName(rs.getString("name"));
//                card.setActivity_name(resultSet.getString("Activity_name"));

                card.setEmail(rs.getString("email"));
                card.setFees_details(rs.getString("fees_details"));

//                card.setNames_spks(resultSet.getString("names_spks"));
                card.setTerms_Conditions(rs.getString("Terms_Conditions"));
                  Blob imageBlob = rs.getBlob("image"); // استبدل "image" بعمود الصورة في قاعدة البيانات
String base64Image = ImageUtils.blobToBase64(imageBlob);

card.setImage(base64Image);
//                card.setTeem(resultSet.getString("Terms_Conditions"));
//                card.setOpation_payments(resultSet.getString("opation_payments"));
                card.setDate_time(rs.getString("date_time"));
                cardList.add(card);
            }

//            resultSet.close();
//            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(cardList);

        return cardList;
    }
}
