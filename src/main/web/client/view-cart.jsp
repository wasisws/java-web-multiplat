<%-- Created on : Jul 3, 2023, 4:26:22 PM by DuyDuc94 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import = "java.util.*" %>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Your Cart</title>
        <%@include file="../client/templates/head-libs.jsp" %>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
            }

            .container {
                max-width: 1200px;
                margin: 0px auto;
            }

            .cart-title {
                font-size: 40px;
                font-weight: bold;
                margin-bottom: 20px;
            }

            .product-card {
                display: flex;
                align-items: center;
                justify-content: space-between;
                margin-bottom: 20px;
                padding: 15px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
            }

            .product-card {
                width: auto;
                height: auto;
                margin-right: 0px;
                object-fit: contain;
            }

            .product-image img {
                width: 150px;
                height: 150px;
            }

            .product-card .product-info {
                flex-grow: 0.6;
            }

            .product-card .product-info .product-name {
                font-weight: bold;
                margin-bottom: 10px;

            }

            .product-name {
                font-size: 25px;
            }


            .product-card .product-info .product-price {
                color: #888;
                margin-bottom: 10px;
                font-size: 20px;
            }

            .product-color {
                margin-bottom: 10px;
            }

            .product-color label {
                font-weight: bold;
                margin-right: 5px;
            }

            .product-color select {
                padding: 5px;
                border-radius: 3px;
                border: 1px solid #ccc;
            }

            .product-card .add-to-cart {
                text-align: right;
            }

            .add-to-cart-button {
                display: flex;
                align-items: center;
                justify-content: center;
                width: 200px;
                padding: 10px;
                background-color: #337ab7;
                color: #fff;
                font-weight: bold;
                text-align: center;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            .add-to-cart-button:hover {
                background-color: #23527c;
            }

            .product-quantity {
                display: flex;
                align-items: center;
            }

            .quantity-label {
                margin-right: 5px;
                font-weight: bold;
            }

            .quantity-input{
                width: 80px;
            }

            .quantity-button {
                width: 30px;
                height: 26px;
                border: none;
                background-color: #eee;
                color: #888;
                font-weight: bold;
                cursor: pointer;
            }


            .view-product-button {
                display: flex;
                align-items: center;
                justify-content: center;
                width: 200px;
                padding: 10px;
                background-color: #337ab7;
                color: #fff;
                font-weight: bold;
                text-align: center;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            .view-product-button:hover {
                background-color: #23527c;
            }

            .remove-product-button {
                display: flex;
                align-items: center;
                justify-content: center;
                width: 200px;
                padding: 10px;
                margin-top: 10px;
                background-color: #d9534f;
                color: #fff;
                font-weight: bold;
                text-align: center;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s;
            }
            .remove-product-button:hover {
                background-color: #c9302c;
            }


            .checkout-button {
                margin-top: 10px;
                padding: 15px 30px;
                background-color: #337ab7;
                margin-bottom: 20px;
                color: #fff;
                font-weight: bold;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s;
                float: right;
            }

            .checkout-button:hover {
                background-color: #23527c;
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
                        <h3 class="breadcrumb-header">Cart</h3>
                        <ul class="breadcrumb-tree">
                            <li><a href="homepage">Home</a></li>
                            <li class="active">Your Cart</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- /BREADCRUMB -->

        <!-- SECTION -->
        <div class="section">
            <div class="container">
                <c:if test="${cart.size()==0}">
                    <div class="text-center">
                        <p>You haven't added any products to your cart</p>
                        <p>Go to <a href="search?category=All"><b>store</b></a></p>
                    </div>
                    <br>
                    <br>
                    <br>
                </c:if>
                <div class="row">
                    <c:forEach var="product" items="${cart}">
                        <%@include file="../client/templates/product/product-card.jsp" %>
                    </c:forEach>
                    <c:if test="${cart.size()!=0}">
                        <button onclick="window.location.href='view-checkout'" class="checkout-button">Proceed to Checkout</button>
                    </c:if>
                </div>
            </div>
        </div>
        <!-- /SECTION -->

        <%@include file="../client/templates/footer/footer.jsp" %>
        <%@include file="../client/templates/foot-libs.jsp" %>

        <script>
            // Add Quantity Button Click Handler
            $(document).on('click', '.quantity-button', function () {
                var input = $(this).siblings('.quantity-input');
                var value = parseInt(input.val());

                if ($(this).text() === '-') {
                    if (value > 1) {
                        input.val(value - 1);
                    }
                } else {
                    input.val(value + 1);
                }
            });
        </script>
    </body>
</html>

