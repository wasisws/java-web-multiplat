<%-- Created on : Jul 2, 2023, 2:25:06 PM by DuyDuc94 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import = "java.util.*" %>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Electro.</title>
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
                            <li class="active">Login</li>
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
                    <div class="login-container">
                        <h2 class="text-center">Login</h2>
                        <form action="login" method="post">
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Enter username" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
                            </div>
                            <p class="error-messsage">${requestScope['message']}</p>
                            <!--Use to get back where it need user to login-->
                            <input type="hidden" name="url-request" value="${requestScope['url-request']}">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </form>
                            
                        <div class="forgot-password">
                            <a href="forgot-password">Forgot Password?</a>
                        </div>
                        <div class="register-link">
                            <p>Don't have an account? <a href="register">Register</a></p>
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
