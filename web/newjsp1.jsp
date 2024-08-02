<%-- 
    Document   : newjsp1
    Created on : Oct 8, 2023, 5:44:14 PM
    Author     : MC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="slider-container">
  <div class="slider">
    <% for (int i = 0; i < 4; i++) { %>
      <div class="slide <% if (i == 0) { %>active<% } %>">
        <img src="h.PNG" alt="Slide <%= i+1 %>">
      </div>
    <% } %>
  </div>
  
  <a class="prev" onclick="changeSlide(-1)">&#10094;</a>
  <a class="next" onclick="changeSlide(1)">&#10095;</a>
  
  <div class="slider-indicators">
    <% for (int i = 0; i < 4; i++) { %>
      <span class="indicator <% if (i == 0) { %>active<% } %>"
            onclick="goToSlide(<%= i %>);"></span>
    <% } %>
  </div>
</div>
    </body>
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

  showSlide(slideIndex);
</script>
    <style>.slider-container {
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
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.prev, .next {
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

.active {
  background-color: rgba(0, 0, 0, 0.7);
}</style>
</html>
