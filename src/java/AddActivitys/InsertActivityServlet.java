package AddActivitys;

import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import java.net.URLEncoder;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class InsertActivityServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
//        String activityId = request.getParameter("activityId");
        String activityName = request.getParameter("activityName");

        Part filePart = request.getPart("activityImage");

        InputStream activityImage = filePart.getInputStream();
        String dateTime = request.getParameter("dateTime");
        String feesDetails = request.getParameter("feesDetails");
        String email = request.getParameter("email");
        String Location = request.getParameter("Location");
        String termsConditions = request.getParameter("termsConditions");
//         Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        // Database connection details

        try {
            long lastActivityId = 0;
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");

            // Insert into activitys1 table
            String insertActivityQuery = "INSERT INTO activitys1(name, image, date_time, fees_details, email, Location,Terms_Conditions) VALUES (?, ?, ?, ?, ?,?, ?)";
            PreparedStatement activityStatement = conn.prepareStatement(insertActivityQuery, Statement.RETURN_GENERATED_KEYS);
//            activityStatement.setString(1, activityId);
            activityStatement.setString(1, activityName);
            activityStatement.setBlob(2, activityImage);
            activityStatement.setString(3, dateTime);

            activityStatement.setString(4, feesDetails);
            activityStatement.setString(5, email);
            activityStatement.setString(6, Location);
            activityStatement.setString(7, termsConditions);
            activityStatement.executeUpdate();
            String selectLastActivityIdQuery = "SELECT MAX(id) FROM activitys1";
            Statement selectStatement = conn.createStatement();
            rs = selectStatement.executeQuery(selectLastActivityIdQuery);
            if (rs.next()) {

                lastActivityId = rs.getLong(1);
                System.out.println("آخر ID للنشاط: " + lastActivityId);
            }

            selectStatement.close();
            activityStatement.close();

            // Close the database connection
            conn.close();

            // Redirect to a success page
            String message = "This data has been entered successfully.";

// Redirect to a success page with the message as a parameter
            response.sendRedirect("add_detailes.jsp?activity_id=" + lastActivityId + "&message=" + URLEncoder.encode(message, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            // Redirect to an error page
            response.sendRedirect("error.jsp");
        }
    }
}
