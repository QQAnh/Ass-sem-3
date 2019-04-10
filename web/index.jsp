<%@ page import="entity.Feedback" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Quynh_Anh
  Date: 4/8/19
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%HttpSession session1 = request.getSession();%>
<%%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<!-- Navigation -->
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand text-white" href="#">FeedBack</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <%if (session1.getAttribute("username") != null) {%>
                    <a class="nav-link text-white" href="#"><%=session1.getAttribute("username") %>
                    </a>
                    <%} else {%>
                    <a class="nav-link text-white" href="#">Home</a>
                    <%}%>
                </li>
                <li class="nav-item">
                    <%if (session1.getAttribute("username") != null) {%>
                    <a class="nav-link text-white" href="/logout">Logout</a>
                    <%
                        } else {

                        }
                    %>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- Navigation -->
<%
    List<Feedback> data = (List<Feedback>) request.getAttribute("data");
    if (data == null) {
        data = new ArrayList<>();
    }
%>
<!-- Carousel Slider -->
<div id="carouselLogo" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselLogo" data-slide-to="0" class="active"></li>
        <li data-target="#carouselLogo" data-slide-to="1"></li>
        <li data-target="#carouselLogo" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="carousel-item active">
            <img class="d-block img-fluid"
                 src="http://www.facenet.org/wp-content/themes/executive/assets/images/header.jpg" alt="First slide">
        </div>
        <div class="carousel-item">
            <img class="d-block img-fluid"
                 src="http://www.facenet.org/wp-content/themes/executive/assets/images/header.jpg" alt="First slide">
        </div>
        <div class="carousel-item">
            <img class="d-block img-fluid"
                 src="http://www.facenet.org/wp-content/themes/executive/assets/images/header.jpg" alt="First slide">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselLogo" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselLogo" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!-- Carousel Slider -->
<ul class="carousel-inner">
    <%
        for (Feedback item : data) {
    %>
    <li class="media">

        <div>
            <hr class="bg-dark mb-4 w-25">
            <div class="row">
                <div class="col-md-4">
                    <div class="card">
                        <img class="card-img-top" src="https://dummyimage.com/350x250/c7c7c7/000.png"
                             alt="Card image cap">
                        <div class="card-block p-3">
                            <h4 class="card-title"><%= item.getDescription()%>
                            </h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </li>
    <%
        }
    %>
</ul>

<!-- Card -->


</body>
</html>
