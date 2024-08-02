<%@page import="java.util.List"%>
<%@page import="app.user"%>
<%@page import="Profile.ProfileServlet"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession session1 = request.getSession(false);

    // التحقق من وجود الجلسة ومعرف الجلسة
    if (session != null && session.getAttribute("email") != null) {
        // المستخدم قام بتسجيل الدخول بنجاح
        String username = (String) session.getAttribute("email");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Profile</title>
    </head>
    <body >
        <jsp:include page="../Nav/navigation.jsp"></jsp:include>
        <%
            ProfileServlet cardsServelt = new ProfileServlet();

            String userId = (String) session.getAttribute("id").toString();
            List<user> cardList = cardsServelt.getUser(Integer.parseInt(userId));
            for (user card : cardList) {
        %>

        <div class="profile-card">
            <h1 >User Profile</h1>
            <p style="margin-top: 60px">ID: <%= card.getId()%></p>
            <p>Name: <%= card.getName()%></p>
            <p>Email: <%= card.getEmail()%></p>
            <p>Name: <%= card.getPassword()%></p>
            <a href="editProfile.jsp">Edit Profile</a>
        </div>
    </body>
    <% }%>





    <!--        // Use the parsed number as needed-->
</body>
<style>
    body {
        background-color: powderblue;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 70vh;
    }

    /* ????? ???? Edit Profile */
    .profile-card {
        background-color: #f2f2f2;
        height: 50vh;
        width: 300px;

        border: 1px solid #ccc;
        padding: 20px;

    }

    .profile-card h1 {

        color: #00cccc;
        font-size: 30px;
        margin-bottom: 10px;
        text-align: center;
    }

    .profile-card p {
        font-size: 20px;
        margin-bottom: 10px;


    }

    .profile-card a {
        margin-top: 40px;
        align-items: center;
        justify-content: center;
        display: inline-block;
        background-color: #4CAF50;
        color: white;
        display: flex;
        padding: 10px 20px;
        text-decoration: none;
    }

    .profile-card a:hover {
        background-color: #45a049;
    }
</style>
</html>

<%
    } else {
        // المستخدم لم يقم بتسجيل الدخول بعد
        response.sendRedirect("./login_registration_login/login.jsp");
    }
%>