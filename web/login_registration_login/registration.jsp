<!-- registration.jsp -->
<html>
    <head>
        <title>Registration</title>
    </head>


    <body style="background-color: powderblue">
        <h2>Registration</h2>
        <div class="container">

            <form action="../login_registration_logout/RegistrationServlet" method="POST">
                <label>Name:</label>
                <input type="text" name="name" required><br>
                <label>Email:</label>
                <input type="text" name="email" required><br>
                <label>Password:</label>
                <input type="password" name="password" required><br>
                <input type="submit" value="Register">
            </form></div>
    </body>
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 50vh;
        }

        form {
            width: 300px;
            padding: 20px;
            background-color: #f2f2f2;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            margin-top: 60px;


        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
    </style>
</html>