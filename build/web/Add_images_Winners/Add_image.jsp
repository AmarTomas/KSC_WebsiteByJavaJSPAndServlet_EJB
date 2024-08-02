<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Image Form</title>

    </head>
    <body style="background-color: powderblue">
        <jsp:include page="../Nav/navigation.jsp"></jsp:include>


            <div class="card">
                <h2 style="text-align: center; color: #00cccc;">Image Form</h2>
                <form action="../Add_images_Winners/UploadServlet" method="post" enctype="multipart/form-data">
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" required>

                    <label for="image">Image:</label>
                    <input type="file" id="image" name="image" required>

                    <input type="submit" value="Submit">
                </form>
            </div>

        <jsp:include page="../Footer.jsp"></jsp:include>
    </body>
    <style>
        /* CSS styles for the card */
        .card {
            width: 300px;
            background-color: #f2f2f2;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin: 0 auto;
            margin-top: 100px;
        }

        .card label {
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
        input[type="text"],input[type="number"],input[type="file"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }
    </style>
</html>