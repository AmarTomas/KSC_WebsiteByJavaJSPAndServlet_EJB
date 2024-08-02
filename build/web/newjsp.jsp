<!--//pagas card details-->
<%@page import="np.CardsServelt"%>
<%@page import="app.Card" %>
<%@page import="java.sql.Date"%>
<!DOCTYPE html>
<html>
<head>
    <title>Card Details</title>
</head>
<body>
    <h1>Card Details</h1>
 


    <% String cardId = request.getParameter("id");
     CardsServelt cardsServelt = new CardsServelt();
               
       Card card = (Card) cardsServelt.getCardById(cardId);
       if (card != null) {
    %>
    <div class="card-details">
        <img src="<%= card.getActivity_name() %>" alt="Card Image" style="width: 1800px;height: 250px">
        <h2 style="alignment-adjust:  center ;text-align: center"><%= card.getName()%></h2>
        
        <div class="row">
            <p>ID: <%= card.getId() %></p>  <p>ID: <%= card.getId() %></p>
        </div>
       
       
    </div>
    <% 
       } else {
    %>
    <p>Card details not found.</p>
    <% } %>
</body>
</html>