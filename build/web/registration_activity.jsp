<!DOCTYPE html>
<html>
<head>
    <title>Payment Form</title>
    <style>
        /* CSS for centering and styling */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 70vh;
            background-color: #f2f2f2;
        }
        
        .card {
            width: 300px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            text-align: center;
        }
        
        .card label {
            display: block;
            font-weight: bold;
            margin-bottom: 10px;
            text-align: left;
        }
        
        .card input[type="text"],
        .card select,
        .card input[type="number"] {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
        
        .card input[type="submit"] {
            width: 100%;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 10px;
            cursor: pointer;
        }
        
        .card input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    
    <div class="card">
        <h2>Registration in Activity</h2>
        <form action="./PaymentServlet/PaymentServlet" method="post">
            <!--<label for="name">Name:</label>-->
<!--            <input type="text" name="name" id="name" required>-->
<% String cardId = request.getParameter("id"); %>
<br>
<input type="hidden" name="name" id="name" value="<%= cardId %>">
            <label for="paymentMethod">Payment Method:</label>
            <select name="paymentMethod" id="paymentMethod">
                <option value="Demand Draft">Payment through Demand Draft</option>
                <option value="Cheque">Payment through Cheque</option>
                <option value="Cash">Payment by Cash</option>
            </select>
            <br>
            <label for="amount">Amount:</label>
            <input type="number" name="amount" id="amount" required>
            <br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>