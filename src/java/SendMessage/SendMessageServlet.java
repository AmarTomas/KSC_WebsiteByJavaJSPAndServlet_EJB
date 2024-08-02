package SendMessage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendMessageServlet extends HttpServlet {
  


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve message from the form
        String message = request.getParameter("message");

        // Retrieve users with status = 0 from the database
        try {     Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");

              String sql = "SELECT email FROM users WHERE status = 1";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                // Send email to each user
                sendEmail(email, message);
            }
        } catch (SQLException e) {
            // Handle any database errors
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SendMessageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Redirect to a success page or appropriate response
        response.sendRedirect("../home/home.jsp");
    }

    private void sendEmail(String email, String message) {
        // SMTP server configuration
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "ksc";
        String password = "ksc656000hdsuytytrer2r5r82565r";

        // Sender and recipient email addresses
        String fromEmail = "ksc6560@gmail.com";
        String toEmail = email;

        // Email subject and content
        String subject = "KSC ";
        String content = message;

        // SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with SMTP authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage object
            MimeMessage mimeMessage = new MimeMessage(session);

            // Set From: header field
            mimeMessage.setFrom(new InternetAddress(fromEmail));

            // Set To: header field
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            // Set Subject: header field
            mimeMessage.setSubject(subject);

            // Set Content: text/plain
            mimeMessage.setText(content);

            // Send the email
            Transport.send(mimeMessage);

            System.out.println("Email sent successfully to: " + toEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}