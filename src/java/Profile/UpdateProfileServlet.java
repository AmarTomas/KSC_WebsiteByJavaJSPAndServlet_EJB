package Profile;

import app.user;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id").toString();

        if (userId != null) {
            String id = request.getParameter("id1");
            String name = request.getParameter("name1");
            String email = request.getParameter("email1");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc", "root", "");
                String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, email);
                statement.setString(3, id);
                statement.executeUpdate();

                // تحديث بيانات الجلسة
                user user = (user) session.getAttribute("user");
                if (user != null) {
                    user.setName(name);
                    user.setEmail(email);
                }

                response.sendRedirect("../profiles/user.jsp"); // تحديث البيانات وتوجيه المستخدم إلى الصفحة الشخصية

                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UpdateProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            response.sendRedirect("login.jsp"); // توجيه المستخدم في حالة عدم وجود جلسة مفعلة
        }
    }
}