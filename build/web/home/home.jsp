<%-- 
    Document   : home
    Created on : Oct 8, 2023, 8:41:01 PM
    Author     : MC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ page import="javax.servlet.http.HttpSession" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body style=" background-color: #f2f2f2;">
        <jsp:include page="../Nav/navigation.jsp"></jsp:include>
        <jsp:include page="../slider.jsp"></jsp:include>
            <br/>
            <br/>
        <jsp:include page="../cards.jsp"></jsp:include>
        <div style="margin-bottom: 200px"></div>
        <jsp:include page="../Footer.jsp"></jsp:include>
        </body>
    </html>


