<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert Data</title>

    </head>
    <body>
        <jsp:include page="../Nav/navigation.jsp"></jsp:include>
        <div style="margin-bottom: 5px"></div>
        <div class="card-container">
            <div class="card">
                <%
                    String message = request.getParameter("message");
                    if (message != null && !message.isEmpty()) {
                %>
                <div id="alert" class="alert">
                    <%= message%>
                </div>
                <% } %>

                <!-- محتوى الكارت -->

            </div>
        </div>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var card = document.querySelector('.card');

                if (card) {
                    setTimeout(function () {
                        card.style.display = 'none';
                    }, 3000);
                }
            });
        </script>
        
        <% String activity_id = request.getParameter("activity_id");%>
        <h1 class="h">Insert Data</h1>
        <div class="forms-container">

            <form action="../AddActivitys/InsertSpeakerServlet" method="post">
                <h1>Insert names of speakers</h1>
                <input type="hidden" name="activityId" id="activityId" value="<%= activity_id%>">
                <label for="name">Name:</label>
                <input type="text" name="name" id="name">
                <label for="expert">Expert:</label>
                <input type="text" name="expert" id="expert">
                <button type="submit">Submit</button>
            </form>
            <br>
            <form action="../AddActivitys/InsertEligibilityCriteriaServlet" method="post">
                <input type="hidden" name="activityId" id="activityId" value="<%= activity_id%>">
                <h1>Insert Eligibility Ccriteria</h1>
                <label for="name">Name:</label>
                <input type="text" name="name" id="name">
                <button type="submit">Submit</button>
            </form>
            <br>
            <form action="../AddActivitys/InsertPrizeServlet" method="post">
                <h1>Insert Prizes</h1>
                <input type="hidden" name="activityId" id="activityId" value="<%= activity_id%>">
                <label for="name">Name:</label>
                <input type="text" name="name" id="name">
                <label for="description">Description:</label>
                <input type="text" name="description" id="description">

                <button type="submit">Submit</button>
            </form>
            <br>
            <form action="../AddActivitys/InsertTopicServlet" method="post">
                <!--        <label for="topicId">Topic ID:</label>-->
                <h1>Insert Topics</h1>
                <input type="hidden" name="activity_id" id="activity_id" value="<%= activity_id%>">
                <label for="name">Name:</label>
                <input type="text" name="name" id="name">
                <label for="time">Time:</label>
                <input type="text" name="time" id="time">
                <button type="submit">Submit</button>
            </form>

        </div>
        <jsp:include page="../SendMessage/SendMessage.jsp"></jsp:include>
        <div style="margin-bottom: 100px"></div>
        <jsp:include page="../Footer.jsp"></jsp:include>
    </body>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: powderblue
        }

        h1 {
            text-align: center;
            font-size: 15px;
        }
        .h {
            text-align: center;
            font-size: 30px;
        }

        .forms-container {
            display: flex;
            /*            flex-wrap: wrap;*/
            justify-content: space-between;
            /*width: 400px;*/
        }

        .forms-container form {
            flex-basis: 48%;
            width: 280px;
            padding: 20px;
            margin-left: 20px;
            background-color: #f2f2f2;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 20px;
        }

        .forms-container label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        .forms-container input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        .forms-container button[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .card-container {
            display: flex;
            justify-content: flex-end;
            align-items: center;
            height: 15vh;
            
        }

        .card {
            width: 300px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 15px;
            background-color: #f2f2f2;
            text-align: center;
        }

        .alert {
            color: #66ff99;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .forms-container button[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</html>