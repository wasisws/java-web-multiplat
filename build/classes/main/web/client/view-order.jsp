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
            .order-view-form table{
                max-width: 1000px;
                margin: 0 auto;
                margin-top: 10px;
                margin-bottom: 50px;
                background-color: #fff;
                padding: 30px;
                width: 500px;
                height: 50px;
            }
            div.vertical-line{
                width: 0px; /* Use only border style */
                height: 100%;
                float: left;
                border: 1px inset; /* This is default border style for <hr> tag */
            }

            .order-view-form tr{
                text-align: left;
            }
            .order-view-form button{
                width: 25%;
                padding: 10px;
                background-color: #337ab7;
                border: 0;
                color: #fff;
                font-weight: bold;
                cursor: pointer;
            }

            .order-view-form .button{
                display: flex;
                flex-direction: row-reverse;
            }
            .order-view-form .check-address{
                display: flex;
                margin-left: 10px;
                align-items: center;
            }

            .order-view-form .edit{
                color: black;
                margin-bottom: 20px;
                font-size: 18px;
                font-weight: bold;
            }

            .order-view-form td{
                text-align: left;
            }
            .order{
                width: 1000px;
                margin: 0 auto;
                margin-top: 10px;
                margin-bottom: 0;
                background-color: #fff;
                display: flex;
                align-items: center;
            }
            .order input{
                margin: 0;
            }
            .order-detail{
                width: 1000px;
                margin: 20px;
                margin-top: 10px;
                margin-bottom: 20px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
                align-items: center;
            }
            .order-view-form .product-name{
                width: 200px;
            }
            /*                .order-view-form .view-order-detail{
                                text-decoration: underline;
                                margin-top:  50px;
                                margin-bottom: 20px;
                            }*/
            .order-view-form .order-table{
                margin-bottom: 20px;
            }
            table, th, td{
                border-top:1px solid #ccc;
                border-bottom:1px solid #ccc;
            }
            table{
                border-collapse:collapse;
            }
            th, td{
                text-align:left;
                padding:10px;
            }
            .total{
                font-weight: bold;
            }
            .total-price{
                color: #2986CC;
                font-weight: bold;
                font-size: 18px;
            }
            .half-order1{
                display: flex;
            }
            .hafl-order2 div{
                width: 310px;
                margin-top: 5px;
            }
        </style>

    </head>
    <body>
        <%@include file="../client/templates/header/header.jsp" %>
        <%@include file="../client/templates/header/navigation.jsp" %>

        <c:set var="orderList" value="${requestScope['orderList']}" />

        <!-- BREADCRUMB -->
        <div id="breadcrumb" class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h3 class="breadcrumb-header">My Account</h3>
                        <ul class="breadcrumb-tree">
                            <li><a href="homepage">Home</a></li>
                            <li><a href="account">Account</a></li>
                            <li class="active">My Order</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- /BREADCRUMB -->

        <!-- SECTION -->
        <div class="section">
            <div class="container">
                <div class="row" >
                    <!-- Options -->
                    <div class="update-option-container col-md-3">
                        <h3 style="font-size: 18px; margin-bottom: 30px">${user.getUsername()}</h3></form>
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

                    <div class="order-view-form col-md-8">
                        <div class="address-view-title">
                            <h3>MY ORDER</h3>
                        </div>

                        <div class="order-info-tbn">

                            <c:forEach var="order" items="${orderList}" >
                                <div class="order">
                                    <div class="order-detail">
                                        <div class="col-md-8 half-order1">
                                            <div class="product-in-order ">
                                                <table class="order-table">
                                                    <th>Order ID: ${order.getID()}</th>
                                                        <c:forEach var="orderDetail" items="${order.getOrderDetailList()}">
                                                        <tr>
                                                            <td class="product-name">${orderDetail.getProductDetatilName()} (${orderDetail.getQuantity()}x)</td>
                                                            <td>$${orderDetail.getPrice()}</td>
                                                        </tr>
                                                    </c:forEach>
                                                    <tr>
                                                        <td class="total">TOTAL:</td>
                                                        <td class="total-price">$${order.getTotalPrice()}</td>
                                                    </tr>
                                                </table>
                                            </div>
                                            <div class="col-md-4 hafl-order2">
                                                <div>
                                                    <strong>Status: </strong>${order.getStatusString()}
                                                </div>
                                                <div >
                                                    <strong>Ordered on: </strong>${order.getDateOrder()}
                                                </div>
                                                <div>
                                                    <strong>To: </strong>${order.getShippingAddress()}
                                                </div>
                                                <div>
                                                    <strong>Payment method: </strong>${order.getPaymentMethod()}                                               
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <c:if test="${order.getStatus()!=1 && order.getStatus()!=4}">
                                        <div class="cancel">
                                            <a href="cancel-order?orderID=${order.getID()}" title="Cancel order">
                                                <i class="fas fa-window-close fa-lg"></i>
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                            </c:forEach>
                            <c:if test="${orderList.size()==0}">
                                <p class="text-center">You have not created any orders yet!</p>
                            </c:if>
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