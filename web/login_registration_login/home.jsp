<%-- 
    Document   : home
    Created on : Oct 10, 2023, 7:49:32 PM
    Author     : MC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession session1 = request.getSession(false);
    boolean isLoggedIn = false;

    if (session != null && session.getAttribute("email") != null) {
        isLoggedIn = true;
    }
%>

<nav>
  <ul>
    <% if (isLoggedIn) { %>
        <li><a href="../login_registration_logout/LogoutServlet"><img src="logout-icon.png" alt="Logout"></a></li>
    <% } else { %>
        <li><a href="login.jsp">Login</a></li>
        <li><a href="registration.jsp">Registration</a></li>
    <% } %>
  </ul>
</nav>
    </body>
</html>
