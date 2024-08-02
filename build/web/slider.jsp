<%@page import="app.Winners"%>
<%@page import="np.WinnersServlet"%>
<%@page import="app.Image"%>
<%@page import="np.SliderServlet"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <!-- Include CSS and JavaScript files for the image slider library -->
  <link rel="stylesheet" href="path/to/slick.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="path/to/slick.min.js"></script>
  <style>
    .slider-container {
      position: relative;
      width: 100%;
      height: 400px;
      overflow: hidden;
    }
    
    .slider {
      display: flex;
      transition: transform 0.3s ease-in-out;
    }
    
    .slide {
      flex: 0 0 100%;
    }
    
    .slide img {
      height: 400px;
      width: 100%;
      object-fit: cover;
    }
    
    .prev,
    .next {
      position: absolute;
      top: 50%;
      transform: translateY(-50%);
      padding: 10px;
      font-size: 24px;
      color: white;
      background-color: rgba(0, 0, 0, 0.5);
      cursor: pointer;
      z-index: 2;
    }
    
    .prev {
      left: 10px;
    }
    
    .next {
      right: 10px;
    }
    
    .slider-indicators {
      position: absolute;
      bottom: 10px;
      left: 50%;
      transform: translateX(-50%);
      display: flex;
    }
    
    .indicator {
      width: 10px;
      height: 10px;
      border-radius: 50%;
      background-color: rgba(0, 0, 0, 0.3);
      margin: 0 5px;
      cursor: pointer;
    }
    .image-text {
  position: absolute;
  top: 40px;
  right: 200px;
  font-size: 18px;
  color: black;
  background-color: #ffffff;
  padding: 5px;
}
 
    .active {
      background-color: rgba(0, 0, 0, 0.7);
    }
  </style>
</head>
<body>
  <div class="slider-container">
    <div class="slider">
      <% 
      SliderServlet sliderServlet = new SliderServlet();
      List<Image> images = sliderServlet.getAllimages();
      
      if (images != null && !images.isEmpty()) {
        for (int i = 0; i < images.size(); i++) {
          Image image = images.get(i);
          %>
          <div class="slide">
            <img src="data:image/jpeg;base64,<%= image.getImage() %>" style="width: 100%" alt="<%= image.getName() %>">
        
           
          </div>
          
                 <div class="image-text">
                     <h2>Winners</h2>
                     <% 
      WinnersServlet winnersServlet = new WinnersServlet();
      List<Winners> winnerw = winnersServlet.getWinner(image.getId());
      int ip=1;
      if (images != null && !images.isEmpty()) {
        for (Winners elem : winnerw) {
          
          %>
          <span ><%= ip++%>-<%= elem.getName() %></span> 
          <p></p>
          <br/>
 <%   
        }
      } else {
        %>
        <p>No images found.</p>
        <%
      }
      %></div>
          <%
        }
      } else {
        %>
        <p>No images found.</p>
        <%
      }
      %>
    </div>
  
    <a class="prev" onclick="changeSlide(-1)">&#10094;</a>
    <a class="next" onclick="changeSlide(1)">&#10095;</a>
  
    <div class="slider-indicators">
      <% for (int i = 0; i < images.size(); i++) { %>
      <span class="indicator <% if (i == 0) { %>active<% } %>" onclick="goToSlide(<%= i %>);"></span>
      <% } %>
    </div>
  </div>
  
  <script>
    var slideIndex = 0;
    var slides = document.getElementsByClassName("slide");
    var indicators = document.getElementsByClassName("indicator");

    function showSlide(index) {
      if (index < 0) {
        slideIndex = slides.length - 1;
      } else if (index >= slides.length) {
        slideIndex = 0;
      }
    
      for (var i = 0; i < slides.length; i++) {
        slides[i].style.transform = "translateX(" + (i - slideIndex) * 100 + "%)";
      }

      for (var i = 0; i < indicators.length; i++) {
        indicators[i].classList.remove("active");
      }

      indicators[slideIndex].classList.add("active");
    }

    function changeSlide(n) {
      showSlide(slideIndex + n);
    }

    function goToSlide(index) {
      showSlide(index);
    }

    $(document).ready(function() {
      showSlide(slideIndex);
    });
  </script>
</body>
</html>