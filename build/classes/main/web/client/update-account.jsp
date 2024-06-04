<%-- Created on : Jul 4, 2023, 11:23:29 AM by DuyDuc94 --%>

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
            .update-container{
                max-width: 400px;
                margin: 0 auto;
                margin-top: 10px;
                margin-bottom: 50px;
                background-color: #fff;
                padding: 30px;
                border-radius: 5px;
                box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
            }
            .update-container .field{
                margin-bottom: 20px
            }

            label {
                display: inline-block;
                max-width: 100%;
                margin-bottom: 5px;
                font-weight: 700;
            }

            .update-container input{
                width: 100%;
                padding: 10px;
                border-radius: 3px;
                border: 1px solid #ccc;
            }
            .input-form{
                display: block;
                width: 100%;
                height: 34px;
                padding: 6px 12px;
                font-size: 14px;
                line-height: 1.42857143;
                color: #555;
                background-color: #fff;
                background-image: none;
                border: 1px solid #ccc;
                border-radius: 4px;
                -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
                -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
                transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            }
            .update-container button{
                width: 100%;
                padding: 10px;
                background-color: #337ab7;
                border: 0;
                color: #fff;
                font-weight: bold;
                cursor: pointer;
            }

            .update-title{
                text-align: center  ;
            }

            div.vertical-line{
                width: 0px; /* Use only border style */
                height: 100%;
                float: left;
                border: 1px inset; /* This is default border style for <hr> tag */
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
                        <h3 class="breadcrumb-header">My Account</h3>
                        <ul class="breadcrumb-tree">
                            <li><a href="homepage">Home</a></li>
                            <li><a href="view-account">My Account</a></li>
                            <li class="active">Update Account</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- /BREADCRUMB -->

        <!-- SECTION -->
        <div class="section">
            <div class="container">
                <div class="row">
                    <!-- Options -->
                    <div class="update-option-container col-md-3">
                        <form ><h3 style="font-size: 18px; margin-bottom: 30px">${user.getUsername()}</h3></form>
                        <div class="input-checkbox">
                            <br>
                            <div class="option">
                                <a href="view-account">
                                    1. My Account
                                </a>
                            </div>
                            <br>
                            <div class="option">
                                <a href="view-address">
                                    2. My Address
                                </a>  
                            </div>
                            <br>
                            <div class="option">
                                <a href="view-order">
                                    3. My Order
                                </a>
                            </div>
                            <br>
                            <div class="option">
                                <a href="update-password">
                                    4. Change my password
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="vertical-line" style="height:10cm;"></div>

                    <div class="update-form col-md-8">
                        <div class="update-container">
                            <div class="update-title">
                                <h3>UPDATE INFOMATION</h3>
                            </div>
                            <form action="update-account" method="post">
                                <div class="field required">
                                    <label for="name" >Name:</label>
                                    <input class="input-form" type="text" name="name" value="${user.getName()}" id="name" required>
                                    <p style="color: red">${requestScope['nameMessage']}</p>
                                </div>
                                <div class="field required">
                                    <label for="phone">Phone number:</label>
                                    <input class="input-form" type="text" name="phone" value="${user.getPhone()}" id="phone" required>
                                    <p style="color: red">${requestScope['phoneMessage']}</p>
                                </div>
                                <div class="field required">
                                    <label for="email">Email:</label>
                                    <input class="input-form" type="email" name="email" value="${user.getEmail()}" id="email" required>
                                    <p style="color: red">${requestScope['emailMessage']}</p>
                                </div>
                                <button style="display: none" type="submit" class="btn btn-primary" id="change">Change</button>
                                <button onclick="window.location.href = 'view-account'" type="button" class="btn btn-primary" id="cancel">Cancel</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /SECTION -->

        <script>
            let nameInput = document.getElementById('name');
            let phoneInput = document.getElementById('phone');
            let emailInput = document.getElementById('email');

            let changeButton = document.getElementById('change');
            let cancelButton = document.getElementById('cancel');
            function update() {
                if (nameInput.value || phoneInput.value || emailInput.value) {
                    cancelButton.style.display = 'none';
                    changeButton.style.display = 'block';
                } else {
                    cancelButton.style.display = 'block';
                    changeButton.style.display = 'none';
                }
            }
            nameInput.addEventListener('input', update);
            phoneInput.addEventListener('input', update);
            emailInput.addEventListener('input', update);
        </script>

        <%@include file="../client/templates/footer/footer.jsp" %>
        <%@include file="../client/templates/foot-libs.jsp" %>
    </body>
</html>