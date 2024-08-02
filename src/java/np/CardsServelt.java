package np;

import app.Card;
import app.Eligibility_criteria;
import app.Prizes;
import app.Topics;
import app.names_of_speakers;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CardsServelt extends HttpServlet {
    // ...

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Card> cardList = getAllCards();
        request.setAttribute("cardList", cardList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cards.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the card ID from the request parameter
        String cardId = request.getParameter("cardId");
;
        HttpSession session = request.getSession();
    session.setAttribute("cardId", cardId);
        // Retrieve the card by ID
        Card card = getCardById(cardId);

        // Set the card as a request attribute
        request.setAttribute("card", card);

        // Forward the request to card_details.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("card_details.jsp");
        dispatcher.forward(request, response);
    }

    public List<Card> getAllCards() {
        List<Card> cardList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // JDBC code to retrieve card data from the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM activitys1");

            while (resultSet.next()) {
                Card card = new Card();
                card.setId(resultSet.getInt("id"));
                card.setName(resultSet.getString("name"));
//                card.setActivity_name(resultSet.getString("Activity_name"));

                card.setEmail(resultSet.getString("email"));
                card.setFees_details(resultSet.getString("fees_details"));

//                card.setNames_spks(resultSet.getString("names_spks"));
                card.setTerms_Conditions(resultSet.getString("Terms_Conditions"));
               Blob imageBlob = resultSet.getBlob("image"); // استبدل "image" بعمود الصورة في قاعدة البيانات
String base64Image = ImageUtils.blobToBase64(imageBlob);

card.setImage(base64Image);
//                card.setTeem(resultSet.getString("Terms_Conditions"));
//                card.setOpation_payments(resultSet.getString("opation_payments"));
                card.setDate_time(resultSet.getString("date_time"));
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

    public Card getCardById(String cardId) {
        // Database connection parameters

        // JDBC variables
        Connection conn;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Card card = null ;

        try {
            // Create a database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            // JDBC code to retrieve card data from the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc?zeroDateTimeBehavior=convertToNull", "root", "");

            // Create a prepared statement
//       
            String sql = "SELECT * FROM activitys1 WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            // Set the card ID parameter
            stmt.setString(1, cardId);

            // Execute the query
            rs = stmt.executeQuery();
            // Process the result set
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String Terms_Conditions = rs.getString("Terms_Conditions");
                String email = rs.getString("email");
                  Blob imageBlob = rs.getBlob("image"); // استبدل "image" بعمود الصورة في قاعدة البيانات
String base64Image = ImageUtils.blobToBase64(imageBlob);

//                card.setImage(base64Image);
                String fees_details = rs.getString("fees_details");
                String date_time = rs.getString("date_time");
                String Location = rs.getString("Location");
//                System.out.println(image+name+Terms_Conditions);
                card = new Card(id, name, base64Image, date_time, fees_details, email, Location,Terms_Conditions);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CardsServelt.class.getName()).log(Level.SEVERE, null, ex);
        }

        return card;
    }
    // ...
public  List<Topics> getTopics(String idp){
    List<Topics> topicses = new ArrayList<>();
        Connection conn;
        PreparedStatement stmt = null;
        ResultSet rs = null;
//        Topics topics = null;

        try {
            // Create a database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            // JDBC code to retrieve card data from the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc?zeroDateTimeBehavior=convertToNull", "root", "");

            // Create a prepared statement
//          
            String sql = "CALL `activitys_id_topics`(?)";
            stmt = conn.prepareStatement(sql);
            // Set the card ID parameter
            stmt.setString(1, idp);

            // Execute the query
            rs = stmt.executeQuery();
            // Process the result set
              while (rs.next()) {
                Topics card = new Topics();
                card.setId(rs.getInt("id"));
                card.setName(rs.getString("name"));
                card.setTime(rs.getTime("time"));
                topicses.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CardsServelt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return topicses;
            
}
public  List<names_of_speakers> getnames_of_speakers(String idp){
    List<names_of_speakers> name_of_speaList = new ArrayList<>();
        Connection conn;
        PreparedStatement stmt = null;
        ResultSet rs = null;
//        names_of_speakers names_of_speakers  = null;

        try {
            // Create a database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            // JDBC code to retrieve card data from the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");

            // Create a prepared statement
//          
            String sql = "CALL `activitys_id_nameof_speake`(?);";
            stmt = conn.prepareStatement(sql);
            // Set the card ID parameter
            stmt.setString(1, idp);

            // Execute the query
            rs = stmt.executeQuery();
            // Process the result set
              while (rs.next()) {
                names_of_speakers name = new names_of_speakers();
                name.setId(rs.getInt("id"));
                name.setName(rs.getString("name"));
                name.setExpert(rs.getString("expert"));
                name_of_speaList.add(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CardsServelt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name_of_speaList;
            
}
public  List<Eligibility_criteria> geteligibility_criteria(String idp){
    List<Eligibility_criteria> eligibility_list = new ArrayList<>();
        Connection conn;
        PreparedStatement stmt = null;
        ResultSet rs = null;
//        Eligibility_criteria eligibility_criteria = null;

        try {
            // Create a database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            // JDBC code to retrieve card data from the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");

            // Create a prepared statement
//          
            String sql = "CALL `activitys_ideligibility_criteria`(?);";
            stmt = conn.prepareStatement(sql);
            // Set the card ID parameter
            stmt.setString(1, idp);

            // Execute the query
            rs = stmt.executeQuery();
            // Process the result set
              while (rs.next()) {
                Eligibility_criteria e= new Eligibility_criteria();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
               eligibility_list.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CardsServelt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eligibility_list;
            
}
public  List<Prizes> getPrizes(String idp){
    List<Prizes> pslist = new ArrayList<>();
        Connection conn;
        PreparedStatement stmt = null;
        ResultSet rs = null;
//        Topics topics = null;

        try {
            // Create a database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            // JDBC code to retrieve card data from the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");

            // Create a prepared statement
//          
            String sql = "SELECT * FROM `prizes` WHERE activity_id=?";
            stmt = conn.prepareStatement(sql);
            // Set the card ID parameter
            stmt.setString(1, idp);

            // Execute the query
            rs = stmt.executeQuery();
            // Process the result set
              while (rs.next()) {
               Prizes prizes = new Prizes();
                prizes.setId(rs.getInt("id"));
                prizes.setName(rs.getString("name"));
                prizes.setDescription(rs.getString("description"));
                pslist.add(prizes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CardsServelt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pslist;
            
}
}
