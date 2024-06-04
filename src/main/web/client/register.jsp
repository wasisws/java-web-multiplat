<%-- Created on : Jul 2, 2023, 2:25:06 PM by DuyDuc94--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import = "java.util.*" %>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <%@include file="../client/templates/head-libs.jsp" %>
    </head>
    <body>
        <%@include file="../client/templates/header/header.jsp" %>
        <%@include file="../client/templates/header/navigation.jsp" %>

        <!-- BREADCRUMB -->
        <div id="breadcrumb" class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="breadcrumb-tree">
                            <li><a href="homepage">Home</a></li>
                            <li class="active">Register</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- /BREADCRUMB -->

        <!-- SECTION -->
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="register-container">
                        <h2 class="text-center">Register</h2>
                        <form action="register" method="post">
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="${param.name!=null?param.name:'Enter your name'}" required>
                                <p class="error-messsage">${requestScope['nameMessage']}</p>
                            </div>
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Enter a username" required>
                                <p class="error-messsage">${requestScope['usernameMessage']}</p>
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone Number:</label>
                                <input type="text" class="form-control" id="phone" name="phone" placeholder="${param.phone!=null?param.phone:'Enter your phone number'}" required>
                                <p class="error-messsage">${requestScope['phoneMessage']}</p>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="${param.email!=null?param.email:'Enter your email address'}" required>
                                <p class="error-messsage">${requestScope['emailMessage']}</p>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter a password" required>
                                <p class="error-messsage">${requestScope['passwordMessage']}</p>
                            </div>
                            <div class="form-group">
                                <label for="confirm-password">Confirm Password:</label>
                                <input type="password" class="form-control" id="confirm-password" name="confirmPassword" placeholder="Confirm your password" required>
                                <p class="error-messsage">${requestScope['comfirmPasswordMessage']}</p>
                            </div>
                            <button type="submit" class="btn btn-primary">Register</button>
                        </form>
                        <div class="login-link">
                            <p>Already have an account? <a href="login">Login</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /SECTION -->

        <%@include file="../client/templates/footer/footer.jsp" %>
        <%@include file="../client/templates/foot-libs.jsp" %>
    </body>
</html>
