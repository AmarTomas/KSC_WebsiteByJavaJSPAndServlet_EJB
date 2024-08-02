<%@page import="app.Prizes"%>
<%@page import="app.names_of_speakers"%>
<%@page import="app.Topics"%>
<%@page import="java.util.List"%>
<%@page import="app.Card"%>
<%@page import="np.CardsServelt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>صفحة السلايدر</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }

            table th {
                padding: 10px;
                background-color: #f0f0f0;
            }

            table td {
                padding: 10px;
                border: 1px solid #ccc;

            </style>

        </head>
        <body >
            <jsp:include page="../Nav/navigation.jsp" />
            <div class="container">
                <% String cardId = request.getParameter("id");
                    CardsServelt cardsServelt = new CardsServelt();

                    Card card = (Card) cardsServelt.getCardById(cardId);
                    if (card != null) {
                %>
                <div class="card-details">
                    <!--<img src="" alt="Card Image" style="width: 100%;height: 350px">-->

 <img src="data:image/jpeg;base64,<%= card.getImage() %>"  style="width: 100%;height: 350px" alt="<%= card.getName() %>">
                    </div>


                    <h2 style="text-align: center;padding-top: 10px;align-content: center"><%= card.getName() %></h2>

                    <div class="row"style="padding-top: 15px ">
                        <div class="col text-center">
                            <h3>Date</h3>
                            <p><%= card.getDate_time() %></p>
                        </div>
                        <div class="col text-right">
                            <h2>Location</h2>
                            <h3> <%= card.getLocation() %></h3> 
                        </div>
                    </div>
                    <%
                    } else {
                    %>
                    <p>No cards found.</p>
                    <%
                        }
                    %><hr>
                    <div class="row">

                        <div class="col-md-7">
                            <h4>Topics</h4>
                            <%
                                List<Topics> topicd = cardsServelt.getTopics(cardId); // Call the servlet function to retrieve card data

                                if (topicd != null) {
                            %>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Time</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for (Topics elem : topicd) {
                                    %>
                                    <tr>
                                        <td><%= elem.getName()%></td>
                                        <td><%= elem.getTime()%> </td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                            <%
                            } else {
                            %>
                            <p>No cards found.</p>
                            <%
                                }
                            %></div>
                        <div class="col-md-5">
                            <h4>Speakers</h4>
                            <%
                                List<names_of_speakers> nameList = cardsServelt.getnames_of_speakers(cardId);
                                // Call the servlet function to retrieve card data

                                if (nameList != null) {
                            %>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>expert</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for (names_of_speakers elem : nameList) {
                                    %>
                                    <tr>
                                        <td><%= elem.getName()%></td>
                                        <td><%= elem.getExpert()%></td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                            <%
                            } else {
                            %>
                            <p>No cards found.</p>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <div class="row">

                        <div class="col-md-4">
                            <h4>Prizse </h4>
                            <%
                                List<Prizes> priList = cardsServelt.getPrizes(cardId);
                                // Call the servlet function to retrieve card data

                                if (priList != null) {
                            %>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>description</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for (Prizes elem : priList) {
                                    %>
                                    <tr>
                                        <td><%= elem.getName()%></td>
                                        <td><%= elem.getDescription()%></td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                            <%
                            } else {
                            %>
                            <p>No cards found.</p>
                            <%
                                }
                            %></div>
                        <div class="col-md-4" style="padding: 20px">
                            <h4>payment options</h4>
                            <ul>
                                <li>	Payment through Demand Draft	
                                </li>
                                <li> Payment through Cheque</li>
                                <li>Payment by cash</li>
                            </ul>
                        </div>
                        <div class="col-md-4" style="padding: 20px">
                            <h4>Fees_details</h4>
                            <ul>
                                <li style="color: red">	$<%= card.getFees_details() %>	
                                </li>

                            </ul>
                        </div>
                    </div>
                    <div class="row">

                        <div class="col-md-6">
                            <h4 style="margin: 10px;padding: 10px">Address for sending the participation </h4>
                        </div>

                        <div class="col-md-4">
                            <a href="../registration_activity.jsp?id=<%= cardId%>">
                                <button style="color: white ;background-color: salmon;border: white;border-radius: 10px;margin: 10px;padding: 10px">Registration</button></a>
                        </div>
                    </div>
                </div>


            </body>
        </html>
