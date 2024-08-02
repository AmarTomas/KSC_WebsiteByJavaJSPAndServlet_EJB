<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Insert Activity</title>

    </head>
    <body style="background-color: powderblue">
        <jsp:include page="../Nav/navigation.jsp"></jsp:include>
            <div class="form-container">
                <h2>Insert Activity</h2>

                <form action="../AddActivitys/InsertActivityServlet" method="post" enctype="multipart/form-data">


                    <div class="row">
                        <label for="activityName1">Activity Name:</label>
                        <input type="text" id="activityName1" name="activityName" required>

                    </div>

                    <div class="row">
                        <label for="activityImage1">Activity Image:</label>
                        <input type="file" id="activityImage1" name="activityImage" required>
                    </div>

                    <div class="row">

                        <label for="dateTime1">Date:</label>
                        <input type="date" id="dateTime1" name="dateTime" required>

                    </div>

                    <div class="row">
                        <label for="feesDetails1">Fees Details:</label>
                        <input type="text" id="feesDetails1" name="feesDetails" required>
                    </div>

                    <div class="row">

                        <label for="email1">Email:</label>
                        <input type="email" id="email1" name="email" required>
                    </div>
                     <div class="row">

                        <label for="email1">Location:</label>
                        <input type="text" id="Location" name="Location" required>
                    </div>

                    <div class="row">
                        <label for="termsConditions1">Terms and Conditions:</label>
                        <!--<input type="" >-->
                        <textarea id="termsConditions1" name="termsConditions" style="max-height: 50px"></textarea>
                    </div>

                    <input type="submit" value="Submit">
                </form>
            </div>

        <jsp:include page="../Footer.jsp"></jsp:include>
    </body>

    <style>
        .form-container {
            background-color: #f2f2f2;
            width: 500px;
            margin: 0 auto;
            margin-top:  80px ;
            padding: 20px;
            /*background-color: #f1f1f1;*/
            border-radius: 5px;
            height: 520px;
        }
        .form-container h2 {
            text-align: center;
        }
        .form-container label {
            display: block;
            margin-bottom: 10px;
        }
        .form-container .row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }
        .form-container .row input[type="text"] {
            width: 300px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-container .row input[type="email"] {
            width: 300px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-container .row input[type="file"] {
            width: 300px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-container .row input[type="date"] {
            width: 300px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-container textarea {
            width: 300px; /* تم تعيين طول الحقل */
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;}
        .form-container input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
        }
    </style>
</html>