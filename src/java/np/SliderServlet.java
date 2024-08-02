package np;

import app.Image;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/slider")
public class SliderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Image> images = getAllimages();

        // Retrieve image data from the database using JDB
        request.setAttribute("images", images);

        RequestDispatcher dispatcher = request.getRequestDispatcher("slider.jsp");
        dispatcher.forward(request, response);
    }
      public List<Image> getAllimages() {
        List<Image> imageList = new ArrayList<>();
         try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
 Class.forName("com.mysql.jdbc.Driver");
            // JDBC code to retrieve card data from the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc","root","");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `images`");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Blob imageUrl = resultSet.getBlob("image");
                String base64Image = ImageUtils.blobToBase64(imageUrl);
                Image image = new Image(id, name, base64Image);
                imageList.add(image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SliderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      return imageList;
      
      }
       

}