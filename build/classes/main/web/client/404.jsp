<%-- Created on : Jul 11, 2023, 12:30:20 PM by DuyDuc94 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import = "java.util.*" %>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet"/>
        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="assets/css/bootstrap.min.css" />
        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="assets/css/slick.css" />
        <link type="text/css" rel="stylesheet" href="assets/css/slick-theme.css" />
        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="assets/css/nouislider.min.css" />
        <!-- Font Awesome Kit v5 -->
        <script src="https://kit.fontawesome.com/db3e6c46fb.js" crossorigin="anonymous"></script>
        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="assets/css/style.css" />
        <title>Home Page</title>
    </head>

    <body>

        <%@include file="templates/header/header.jsp" %>
        <%@include file="templates/header/navigation.jsp" %>


        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="text-center">
                        <h1>404 :( Page not found</h1>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>                        
                    </div>
                </div>
            </div>
        </div>


        <%@include file="templates/footer/footer.jsp" %>

        <!-- jQuery Plugins -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/slick.min.js"></script>
        <script src="assets/js/nouislider.min.js"></script>
        <script src="assets/js/jquery.zoom.min.js"></script>
        <script src="assets/js/main.js"></script>
        <!-- /jQuery Plugins -->
    </body>
</html>
