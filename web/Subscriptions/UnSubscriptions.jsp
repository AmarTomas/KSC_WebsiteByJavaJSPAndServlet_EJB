<!-- unsubscriptions.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession session1 = request.getSession(false);

    // التحقق من وجود الجلسة ومعرف الجلسة
    if (session != null && session.getAttribute("email") != null) {
        // المستخدم قام بتسجيل الدخول بنجاح
        String username = (String) session.getAttribute("email");
%>
<html>
    <head>
        <title>KSC Unsubscriptions</title>

    </head>
    <body>
        <%
            boolean included = true;
        %>
        <%
            if (included) {
                // عرض اسم المستخدم أو المجلد هنا
                System.out.println("className.methodName()");
            }
        %>
        <jsp:include page="../Nav/navigation.jsp" />
        <h1 style="text-align: center ;margin-top: 20px;padding-top: 25px">KSC Unsubscriptions</h1>




        <%  String status = session.getAttribute("status").toString();
            String userId = session.getAttribute("id").toString();
            int st = Integer.parseInt(status);// Function to retrieve the subscription status
        %>

        <% if (st == 1) {%>
        <!-- Display the form only if the user is subscribed -->
        <div ><p style="text-align: center">We hope you have benefited from your experience with us, and we look forward to serving you again in the future. If you have any questions or feedback, please do not hesitate to contact us.</p></div>
        <div style="margin-bottom:0px">
            <a style="text-align: center;align-content: center;text-decoration:none;justify-content: center;display: flex;" href="/KSC/home/contact.jsp"> <button class="button1" >Contact</button></a>
        </div>        <div class="container">
            <form style="margin: 0;" action="../subscribe/UnsubscriptionServlet" method="post">
                <input type="hidden" name="userId" value="<%= userId%>">
                <button type="submit">Unsubscribe</button>
            </form>
            <% } else { %>
            <p style="text-align: center ;color: #f00;margin-top: 20px ;font-size: 20px">You are already unsubscribed.</p>
            <% } %></div>
            <jsp:include page="../Footer.jsp"></jsp:include>
        </body>
        <style>
            /* CSS styles here */

            .container {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 10vh;

            }
            button {
                margin: 0;
                padding: 10px 20px;
                background-color: #f00;
                color: #fff;
                border: none;
                cursor: pointer;
            }

            button:hover {
                background-color: #0056b3;
            }
            .button1 {
                padding: 10px 20px;
                background-color: #77da74;
                color: #fff;
                border: none;
                cursor: pointer;
            }

            .button1:hover {
                background-color: #77defa;
            }
        </style>
    </html>

<%
    } else {
        // المستخدم لم يقم بتسجيل الدخول بعد
        response.sendRedirect("./login_registration_login/login.jsp");
    }
%>