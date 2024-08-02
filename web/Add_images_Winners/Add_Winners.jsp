<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form</title>
  
</head>
<body style="background-color: powderblue">
    <div class="card-container">
  <div class="card">
    <% 
    String message = request.getParameter("message");
    if (message != null && !message.isEmpty()) {
    %>
    <div id="alert" class="alert">
      <%= message %>
    </div>
    <% } %>
    
    <!-- محتوى الكارت -->
    
  </div>
</div>

<script>
  document.addEventListener('DOMContentLoaded', function() {
    var card = document.querySelector('.card');
    
    if (card) {
      setTimeout(function() {
        card.style.display = 'none';
      }, 3000);
    }
  });
</script>
 <jsp:include page="../Nav/navigation.jsp"></jsp:include>
 <script>
    // استهدف العنصر المضغوط
    var activeLink = document.querySelector('.active');

    // قم بحذف الفئة .active وإضافة الفئة .addwinners
    activeLink.classList.remove('active');
    activeLink.classList.add('addwinners');

    // قم بتغيير خلفية العنصر
    activeLink.style.backgroundColor = 'blue'; // استبدل 'blue' باللون الجديد الذي ترغب فيه
</script>
    <% String image_id = request.getParameter("image_id");%>
    <div class="card1">
        <h2 style="text-align: center; color: #00cccc;">Insert Winners </h2>
        <form action="../Add_images_Winners/Add_WinnersServlet" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="age">Age:</label>
            <input type="number" id="age" name="age" required>

            <label for="expertise">Expertise:</label>
            <input type="text" id="expertise" name="expertise" required>

            <input type="hidden" id="image_id" name="image_id" value="<%= image_id %>">

            <input type="submit" value="Submit">
        </form>
    </div>
        <jsp:include page="../Footer.jsp"></jsp:include>
</body>
  <style>
        /* CSS styles for the form */
        .card1 {
            width: 300px;
            background-color: #f2f2f2;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin: 0 auto;
            margin-top: 100px;
        }

        .card1 label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
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
         input[type="text"],input[type="number"] {
                width: 100%;
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-bottom: 10px;
            }
             .card-container {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  height: 10vh;
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
    </style>
</html>