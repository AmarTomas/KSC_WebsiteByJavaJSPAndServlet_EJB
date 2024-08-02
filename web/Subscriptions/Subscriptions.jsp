<!-- subscription.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
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
        <title>KSC Subscription</title>

    </head>
    <body>
        <jsp:include page="/Nav/navigation.jsp" />
        <h1>KSC Subscription</h1>
        <p>Subscribe to receive updates on new offers and seminars about KSC.</p>
        <h2>About KSC University</h2>
        <p>KSC University is a leading educational institution that offers a wide range of programs and courses in various disciplines. With state-of-the-art facilities and a dedicated faculty, KSC University strives to provide a transformative learning experience for its students. The university is committed to academic excellence, research, and community engagement.</p>

        <%-- Check if the user is already subscribed --%>
        <%  String status = session.getAttribute("status").toString();
            String userId = session.getAttribute("id").toString();
            int st = Integer.parseInt(status);
          if (st == 0) {%>
        <form action="../subscribe/SubscriptionServlet" method="post">
            <input type="hidden" name="userId" value="<%= userId%>">
            <button type="submit">Subscribe</button>
        </form>
        <% } else { %>
        <p class="already-subscribed">You are already subscribed.</p>
        <% } %>

        <%-- Display the activity on the new subsec pages --%>
        <h2>Activity:</h2>
        <p>Display the activity here...</p>
<a href="../Activitys/deactivitys.jsp">
                                <button style="color: white ;background-color: salmon;border: white;border-radius: 10px;margin: 10px;padding-left: 20px;padding-right: 20px;padding-bottom:  10px;padding-top: 10px">Activitys</button></a>
                  
        <%-- Add content about the university here --%>

        <jsp:include page="../Footer.jsp"></jsp:include>
        </body>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
            }

            h1 {
                color: #333;
            }

            h2 {
                color: #555;
                font-size: 20px;
            }

            p {
                color: #777;
                line-height: 1.5;
            }

            form {
                margin-top: 10px;
            }

            button {
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                border: none;
                cursor: pointer;
            }

            button:hover {
                background-color: #0056b3;
            }

            .already-subscribed {
                color: #f00;
                font-weight: bold;
            }
        </style>
    </html>

<%
    } else {
        // المستخدم لم يقم بتسجيل الدخول بعد
        response.sendRedirect("./login_registration_login/login.jsp");
    }
%>
