<%@page import="np.UserActivitiesServlet"%>
<%@page import="app.Card"%>
<%@page import="np.CardsServelt"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Card List</title>
    </head>  

    <body>
        <jsp:include page="../Nav/navigation.jsp" />
        <div class="card-container">
            <%
                UserActivitiesServlet activitiesServlet = new UserActivitiesServlet();
                String userId = (String) session.getAttribute("id").toString();
                List<Card> cardList = activitiesServlet.getAllActivitys_user_id(userId);// Call the servlet function to retrieve card data

                if (cardList != null && !cardList.isEmpty()) {
                    for (Card card : cardList) {
            %>
            <div class="card" onclick="viewCardDetails('<%= card.getId()%>')">
                <img src="data:image/jpeg;base64,<%= card.getImage() %>"  alt="<%= card.getName() %>">
                <h2 ><%= card.getName()%></h2>
        <!--        <p>ID: <%= card.getId()%></p>-->
                <p>Description: <%= card.getFees_details()%></p>
            </div>
            <%
                }
            } else {
            %>
            <p>No cards found.</p>
            <% }%>

        </div>
        <jsp:include page="../Footer.jsp"></jsp:include>
    </body>
    <script>
        function viewCardDetails(cardId) {
            window.location.href = "../home/card_det_rec.jsp?id=" + cardId;
        }
    </script>
       <style>
        .card-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin: 10px;
}

.card {
  /* Adjust card styles according to your design */
  width: calc(33%); /* Adjust width as needed */
  margin-bottom: 20px; /* Adjust margin as needed */
 margin: 20px;
            display: flex;
            flex-direction: column;
/*            align-items: center;*/
            /*padding: 10px;*/
            /*margin: 10px;*/
            border: 1px solid #ccccff;
            border-radius: 15px;
            width: auto; max-width: 330px;
            height: auto;max-height: 310px;
        }

        .card img {
            width: 330px;
            height:210px;
            object-fit: cover;
            
  object-position: center;
  margin: 0;
            margin-bottom: 10px
        }
p, h2 {
  text-align: right;
}
        .card h2 {
            margin-bottom: 0;
            font-size: 18px;
/*            margin-bottom: 3px;*/
            padding-left: 10px;
           text-align: start
        }

        .card p {
            color: #ff3333;
            padding-left: 10px;
            font-size: 14px;
            text-align: start;
        }
    </style>
</html>
