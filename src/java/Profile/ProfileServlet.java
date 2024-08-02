package Profile;

import app.user;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // تعديل التوصيل بقاعدة البيانات وفقا لتفاصيل الخاصة بك
   

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
                 
        String userId = (String) session.getAttribute("id");
        List<user> user=(List<user>) getUser(Integer.parseInt(userId));

        if (userId != null) {
            request.setAttribute("user", user);

                    request.getRequestDispatcher("../profiles/user.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp"); // توجيه المستخدم في حالة عدم وجود جلسة مفعلة
        }
    }
    public List<user> getUser(int  user_id){
    List<user> list=new ArrayList<>();
    try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksc","root","");
                String sql = "SELECT * FROM `users` WHERE id=?";
                PreparedStatement statement = conn.prepareStatement(sql);
                 
                statement.setInt(1, user_id);
                ResultSet result = statement.executeQuery();

                if (result.next()) {
                    String id = result.getString("id");
                    String name = result.getString("name");
                    String email = result.getString("email");
                    String password = result.getString("password");
                    user user = new user(id, name, email,password);

                    list.add(user);
                } 
                result.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    return list;
    }
}