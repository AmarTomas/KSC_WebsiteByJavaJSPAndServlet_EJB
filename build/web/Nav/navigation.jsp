<%-- 
    Document   : navigation
    Created on : Oct 15, 2023, 9:45:49 AM
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
    boolean is_admin = false;
    if (session != null && session.getAttribute("email") != null) {
        isLoggedIn = true;
          String Admin =session.getAttribute("admin_is").toString();
     int ad=Integer.parseInt(Admin);
    
     if (session != null && ad == 1) {
        is_admin = true;
    }
    }
   
%>


  
    
  
<header>
 <nav>
    <ul>
        <% if (isLoggedIn) { %>
            <li style="float: right;"><a href="../login_registration_logout/LogoutServlet"><img src="logout-icon.png" alt="Logout"></a></li>
        <% } else { %>
            <li style="float: right;"><a href="/KSC/login_registration_login/registration.jsp" >Registration</a></li>
            <li style="float: right;"><a href="/KSC/login_registration_login/login.jsp">Login</a></li>
        <% } %>
            <!--<li><img  src="../images/h.PNG" /></li>-->
           <img src="../images/logo1.jpg" alt="KSC logo" style="width: 50px;height:60px ;float: left ;margin-right: 15px;">
        
           <li><a href="/KSC/home/home.jsp" >Home</a></li>
        <% if (is_admin) { %>
           <li><a href="/KSC/AddActivitys/addActivity.jsp"class="addactivitys">AddActivitys</a></li>
            <li><a href="/KSC/Add_images_Winners/Add_image.jsp"class="addwinners">AddWinners</a></li>
        <% } %>
        <% if (isLoggedIn) { %>
            <li><a href="/KSC/Activitys/Shared_activities.jsp"class="active"class="enroll">Application/Enroll</a></li>
            <li><a href="/KSC/profiles/user.jsp">Update/Edit</a></li>
            <li><a href="/KSC/Subscriptions/Subscriptions.jsp">Subscribe</a></li>
            <li><a href="/KSC/Subscriptions/UnSubscriptions.jsp" class="unsub">Unsubscribe</a></li>
            <li><a href="/KSC/Activitys/deactivitys.jsp">Deactivate</a></li>
        <% } %>
            <li><a href="/KSC/home/about.jsp" class="about">About Us</a></li>
            <li><a href="/KSC/home/contact.jsp" class="contac">Contact Information</a></li>
    </ul>
</nav>
</header>
    </body>
    <style>/* navigation.css */
header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    /*background-color: #333;*/
    background-color: #00cccc;
    height: 60px;
    z-index: 9999; /* إضافة خاصية z-index للتأكد من ظهور الشريط الثابت فوق المحتوى الآخر */
}

nav ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
}

nav ul li {
    float: left;
}


nav ul li a {
    display: block;
    color: #fff;
    text-align: center;
    padding: 20px;
    text-decoration: none;
    transition: background-color 0.3s;
}

nav ul li a.active {
    background-color:  #4caf50;
}

nav ul li a:hover {
    background-color:  #4caf50;
}

/*nav ul li a:hover {
    background-color:  #4caf50;
}*/

/* CSS animation for navigation links */
nav ul li a {
    animation-duration: 0.5s;
    animation-name: slideIn;
}

@keyframes slideIn {
    0% {
        transform: translateY(-30px);
        opacity: 0;
    }
    100% {
        transform: translateY(0);
        opacity: 1;
    }
}

body {
    margin-top: 60px; /* Add margin to body to prevent content from being hidden behind the fixed navigation bar */
}</style>
    <script>
    // استهدف العنصر المضغوط
    var activeLink = document.querySelector('.active');

    // قم بتعيين اللون الجديد عند النقر على الزر
    activeLink.addEventListener('click', function() {
        activeLink.style.backgroundColor = 'red'; // استبدل 'red' باللون الجديد الذي ترغب فيه
    });
</script>
</html>
