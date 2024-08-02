<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Contact List</title>
</head>
<body>
    <h1>Contact List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Message</th>
        </tr>
        <% 
        String DB_URL = "jdbc:mysql://localhost:3306/ksc";
    String DB_USER = "root";
     String DB_PASSWORD = "";
// Replace with your actual MySQL password

        try {  Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            
            Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT `id`, `name`, `email`, `message` FROM `contact`"); 

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String message = resultSet.getString("message");
        %>
            <tr>
                <td><%= id %></td>
                <td><%= name %></td>
                <td><%= email %></td>
                <td><%= message %></td>
            </tr>
        <% 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        %>
    </table>
</body>    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        
        th, td {
            padding: 8px;
            text-align: left;
            
            border-bottom: 1px solid #ddd;
        }
        
        th {
            background-color: #f2f2f2;
        }
    </style>
</html>