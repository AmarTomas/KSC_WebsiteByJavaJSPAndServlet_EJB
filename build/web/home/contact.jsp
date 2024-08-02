<!DOCTYPE html>
<html>
    <head>
        <title>Contact Us</title>

    </head>
    <body style="background-color: powderblue;">
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
    
    <!-- ????? ?????? -->
    
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
<jsp:include page="../Nav/navigation.jsp" />
        <h1>Contact Us</h1>
        <p>Fill out the form below to get in touch with us:</p>

        <form action="../np/ContactServlet" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>

            <label for="message">Message:</label>
            <textarea id="message" name="message" rows="5" required></textarea><br>

            <input type="submit" value="Submit">
        </form>

        <p>Alternatively, you can reach us using the contact information below:</p>

        <div class="contact-info">
            <p><strong>Address:</strong> 123 Main St, Sana`a</p>
            <p><strong>Phone:</strong> +967 774-160-821 </p>
            <p><strong>Email:</strong> info@amar.com</p>
        </div>

    </body>

    <style>
     .card-container {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  height: 2vh;
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

        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
            margin-top: 20px;
            padding-top: 25px
        }

        p {
            color: #666;
            margin-bottom: 10px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="email"],
        textarea {
            width: 90%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
        }

        .contact-info {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .contact-info p {
            margin-bottom: 10px;
        }
    </style>
</html>