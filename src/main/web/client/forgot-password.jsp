<%-- Created on : Jul 2, 2023, 2:25:06 PM by DuyDuc94--%>

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
        <style>
            body {
                background-color: #f5f5f5;
            }

            .forgot-password-container {
                max-width: 400px;
                margin: 0 auto;
                margin-top: 10px;
                margin-bottom: 50px;
                background-color: #fff;
                padding: 30px;
                border-radius: 5px;
                box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
            }

            .forgot-password-container .form-group {
                margin-bottom: 20px;
            }

            .forgot-password-container label {
                font-weight: bold;
            }

            .forgot-password-container input[type="email"] {
                width: 100%;
                padding: 10px;
                border-radius: 3px;
                border: 1px solid #ccc;
            }

            .forgot-password-container button[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #337ab7;
                border: 0;
                color: #fff;
                font-weight: bold;
                cursor: pointer;
            }

            .forgot-password-container .login-link {
                text-align: center;
                margin-top: 20px;
            }

            .forgot-password-container .login-link a {
                text-decoration: none;
                font-weight: bold;
            }

            .error-messsage{
                color: red;
            }
            

        </style>
    </head>
    <body>
        <%@include file="../client/templates/header/header.jsp" %>
        <%@include file="../client/templates/header/navigation.jsp" %>

        <!-- BREADCRUMB -->
        <div id="breadcrumb" class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <!--<h3 class="breadcrumb-header">Forgot Password</h3>-->
                        <ul class="breadcrumb-tree">
                            <li><a href="homepage">Home</a></li>
                            <li><a href="login">Login</a></li>
                            <li class="active">Forgot Password</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- /BREADCRUMB -->

        <!-- SECTION -->
        <div class="container">
            <div class="row">
                    <div class="forgot-password-container">
                        <form action="forgot-password" method="post">
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input name="email" type="email" class="form-control" id="email" placeholder="Enter your email address">
                                <c:if test="${requestScope['emailMessage']!=null}">
                                    <p class="error-messsage">${requestScope['emailMessage']}</p>
                                </c:if>
                            </div>
                            <button type="submit" class="btn btn-primary">Reset Password</button>
                        </form>
                        <div class="login-link">
                            <p>Remembered your password? <a href="login">Login</a></p>
                        </div>
                    </div>
                </div>
            </div>
        <!-- /SECTION -->

        <%@include file="../client/templates/footer/footer.jsp" %>
        <%@include file="../client/templates/foot-libs.jsp" %>
    </body>
</html>

