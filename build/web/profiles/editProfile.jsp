<%@page import="app.user"%>
<%@page import="java.util.List"%>
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
        <title>Edit Profile</title>
    </head>
    <body>
        <jsp:include page="../Nav/navigation.jsp"></jsp:include>
        <%
            ProfileServlet cardsServelt = new ProfileServlet();

   //                      HttpSession sessionp = request.getSession();
            String userId = (String) session.getAttribute("id").toString();
            List<user> cardList = cardsServelt.getUser(Integer.parseInt(userId));
            for (user card : cardList) {
        %>
        <div class="profile-card">
            <h1> Edit Profile</h1>
            <form style="align-items: center;text-align: center;margin-top: 30px" method="post" action="../Profile/UpdateProfileServlet">
                <input type="hidden" name="id1" value="<%=card.getId()%>" style="margin-top: 30px">
                <label>Name:</label>
                <input type="text" name="name1" value="<%= card.getName()%>"><br>
                <label>Email:</label>
                <input type="email" name="email1" value="<%= card.getEmail()%>"><br>
                <label>Password:</label>
                <input type="password" style="padding: 6px;padding-left: 40px " name="password" value="<%= card.getPassword()%>"><br>

                <div class="row"><input type="submit" value="Save" style="width: 100%;margin-top: 30px" > <a class="ap" href="../profiles/user.jsp" style="background-color: #4CAF50;margin-top: 20px;">Bake</a> </div> 
            </form></div>
            <%}%>
    </body>
    <style>
        /* ????? ???? Edit Profile */


        label {
            display: inline-block;
            width: 80px;
            margin-bottom: 10px;
            font-weight: bold
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            display: flex;
            justify-content: center;
            align-items: center;
            align-items: center;
            border-radius: 4px;
            cursor: pointer;
        }
        .ap {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            display: flex;
            justify-content: center;
            align-items: center;
            align-items: center;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="text"],input[type="email"],input[type="password"] {
            width: 70%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        /* ????? ???? User Profile */




        body {
            /*background-color: ;*/
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: powderblue;
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
            font-size: 30px;
            margin-bottom: 10px;
            text-align: center;
            color: #00cccc
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