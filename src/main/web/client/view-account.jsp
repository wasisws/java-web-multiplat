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
            .Account-info-container table{
                max-width: 1000px;
                margin: 0 auto;
                margin-top: 10px;
                margin-bottom: 50px;
                background-color: #fff;
                padding: 30px;
                border-radius: 5px;
                box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
                width: 800px;
                height: 200px;
            }
            .Account-info-container .field{
                max-width: 100%;
                font-weight: 700;
            }
            .Account-info-container tr{
                text-align: center;
                margin-top: 20px;
            }
            .Account-info-container .option{
                margin-top: 20px;
            }
            div.vertical-line{
                width: 0px; /* Use only border style */
                height: 100%;
                float: left;
                border: 1px inset; /* This is default border style for <hr> tag */
            }


            .Account-info-container button{
                width: 25%;
                padding: 10px;
                background-color: #337ab7;
                border: 0;
                color: #fff;
                font-weight: bold;
                cursor: pointer;
            }

            .Account-info-container .button{
                display: flex;
                flex-direction: row-reverse;
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
                            <li class="active">My Account</li>
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

                    <!-- Account info- -->
                    <div class="Account-info-container col-md-8">
                        <div>
                            <h3>ACOUNT INFORMATION</h3>
                        </div>

                        <div class="account-info-tbn">
                            <table>
                                <tbody>
                                    <tr>
                                        <td class="field">Username</td>
                                        <td>:</td>
                                        <td class="info">${user.getUsername()}</td>
                                    </tr>
                                    <tr>
                                        <td class="field">Name</td>
                                        <td>:</td>
                                        <td class="info">${user.getName()}</td>
                                    </tr>
                                    <tr>
                                        <td class="field">Email</td>
                                        <td>:</td>
                                        <td class="info">${user.getEmail()}</td>
                                    </tr>
                                    <tr>
                                        <td class="field">Phone</td>
                                        <td>:</td>
                                        <td class="info">${user.getPhone()}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="button text-center">
                            <button onclick="window.location.href = 'update-account'" class="btn btn-primary" type="button">Update</button>
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