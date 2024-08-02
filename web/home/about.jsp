<%-- 
    Document   : about
    Created on : Oct 15, 2023, 1:44:06 PM
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
        <jsp:include page="/Nav/navigation.jsp" />

        <h2 style="padding-top: 10px;padding-left: 10px">About KSC University</h2>
        <p style="margin-left: 20px;">KSC University is a leading educational institution that offers a wide range of programs and courses in various disciplines. With state-of-the-art facilities and a dedicated faculty, KSC University strives to provide a transformative learning experience for its students. The university is committed to academic excellence, research, and community engagement.</p>

        <h3 style="padding-top: 10px;padding-left: 10px">Facilities</h3>
        <p style="margin-left: 20px;">The university campus is equipped with modern facilities including libraries, laboratories, sports complexes, and student lounges. These facilities provide students with a conducive environment for learning and personal development.</p>

        <h3 style="padding-top: 10px;padding-left: 10px">Research Opportunities</h3>
        <p style="margin-left: 20px;">KSC University encourages research and innovation among its students and faculty. The university provides numerous research opportunities and supports cutting-edge projects in various fields. Students have the chance to collaborate with faculty members on research initiatives and contribute to the advancement of knowledge.</p>

        <h3 style="padding-top: 10px;padding-left: 10px">Community Engagement</h3>
        <p class="highlight" style="margin-left: 20px;">KSC University actively engages with the community through various outreach programs and social initiatives. Students are encouraged to participate in community service activities and make a positive impact on society.</p>
    </body>
    <style>
        h2 {
            color: blue;
            font-size: 24px;
        }

        h3 {
            color: green;
            font-size: 20px;
        }

        p {
            color: black;
            font-size: 16px;
        }

        .highlight {
            background-color: yellow;
        }
    </style>
</html>

