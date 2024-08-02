<%-- 
    Document   : SendMessage
    Created on : Oct 17, 2023, 11:27:08 AM
    Author     : MC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .form-container {
                background-color: #f2f2f2;
                width: 300px;
              
        margin-top:  40px ;
        padding: 20px;
        /*background-color: #f1f1f1;*/
        border-radius: 5px;
        height: 170px;
            }
        button[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                justify-content: flex-end
               
            }
     textarea {
                width: 280px; 
                max-width: 280px;
                max-height: 30px;
                /* تم تعيين طول الحقل */
                padding: 10px;
                height: 50px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 4px;}
    </style>
    <body>
        
        <form class="form-container" action="../SendMessage/SendMessageServlet" method="post">
         <h2>Send to email Notfiaction</h2>   
         <textarea  
                name="message"></textarea>
    <button type="submit">Send to email's</button>
</form>

    </body>
</html>
