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
            .address-view-form table{
                max-width: 1000px;
                margin: 0 auto;
                margin-top: 10px;
                margin-bottom: 50px;
                background-color: #fff;
                padding: 30px;
                border-radius: 5px;
                box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
                width: 800px;
                height: 50px;
            }
            div.vertical-line{
                width: 0px; /* Use only border style */
                height: 100%;
                float: left;
                border: 1px inset; /* This is default border style for <hr> tag */
            }

            .address-view-form tr{
                text-align: left;
            }
            .address-view-form button{
                width: 25%;
                padding: 10px;
                background-color: #337ab7;
                border: 0;
                color: #fff;
                font-weight: bold;
                cursor: pointer;
            }

            .address-view-form .button{
                display: flex;
                flex-direction: row-reverse;
            }
            .address-view-form .check-address{
                display: flex;
                margin-left: 10px;
                align-items: center;
            }

            .address-view-form .edit{
                color: black;
                margin-bottom: 20px;

            }

            .address-view-form td{
                text-align: left;
            }
            .address{
                margin: 0 auto;
                margin-top: 10px;
                margin-bottom: 0;
                background-color: #fff;
                display: flex;
                align-items: center;
            }
            .address input{
                margin: 0;
            }
            .address-detail{
                width: 1000px;
                margin: 20px;
                margin-top: 10px;
                margin-bottom: 20px;
                background-color: #fff;
                padding: 30px;
                border-radius: 5px;
                box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
                align-items: center;
            }
        </style>

    </head>
    <body>
        <%@include file="../client/templates/header/header.jsp" %>
        <%@include file="../client/templates/header/navigation.jsp" %>

        <%
            List<Address> listAddress = (List<Address>) request.getAttribute("listAddress");
            Address defaultAddress = null;
            if(listAddress.size()!=0){
                for (Address address : listAddress) {
                if (address.isIsDefault()) {
                    defaultAddress = address;
                    listAddress.remove(address);
                    break;
                    }
                }
            }
        %>

        <c:set var="defaultAddress" value="<%=defaultAddress%>"/>
        <c:set var="otherAddress" value="<%=listAddress%>"/>

        <!-- BREADCRUMB -->
        <div id="breadcrumb" class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="breadcrumb-tree">
                            <h3 class="breadcrumb-header">My Account</h3>
                            <li><a href="homepage">Home</a></li>
                            <li class="active">My Address</li>
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
                        <h3 style="font-size: 18px; margin-bottom: 30px">${user.getUsername()}</h3>
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

                    <c:if test="${defaultAddress!=null}">
                        <div class="address-view-form col-md-8">
                            <div class="address-view-title">
                                <h3>Default</h3>
                            </div>
                            <div class="address-info-tbn">
                                <div class="address">
                                    <div class="address-detail">
                                        ${defaultAddress.getFullAddress()}
                                    </div>
                                    <div class="update-pen">
                                        <c:if test="${listAddress.size()!=0}">
                                            <a href="remove-address?addressID=${defaultAddress.getID()}&newAddressID=${listAddress[0].getID()}">
                                                <i class="fas fa-window-close fa-lg"></i>
                                            </a>
                                        </c:if>
                                        <c:if test="${listAddress.size()==0}">
                                            <a href="remove-address?addressID=${defaultAddress.getID()}">
                                                <i class="fas fa-window-close fa-lg"></i>
                                            </a>
                                        </c:if>
                                        <a href="update-address?addressID=${defaultAddress.getID()}">
                                            <i class="fas fa-edit fa-lg"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>

                            <div class="address-view-title">
                                <h3>Other</h3>
                            </div>

                            <c:forEach var="address" items="${otherAddress}">
                                <div class="address">
                                    <div class="check-address">
                                        <input onclick="getNewAddDefault(${address.getID()})" type="radio" name="select-address">
                                    </div>
                                    <div class="address-detail">
                                        ${address.getFullAddress()}
                                    </div>
                                    <div>
                                        <a href="remove-address?addressID=${address.getID()}">
                                            <i class="fas fa-window-close fa-lg"></i>
                                        </a>
                                        <a href="update-address?addressID=${address.getID()}">
                                            <i class="fas fa-edit fa-lg"></i>
                                        </a>
                                    </div>
                                </div>
                            </c:forEach>
                            <br>
                            <br>
                            <div class="button">
                                <button onclick="window.location.href = 'add-address'" class="btn btn-primary" type="button">Add Address</button>
                                <p>&nbsp;&nbsp;</p>
                                <button onclick="changeDefault(${defaultAddress.getID()})" class="btn btn-primary" type="button" style="display: none;" id="set-default">Set as Default</button>
                            </div>
                            <br>
                            <br>
                            <br>
                        </div>
                    </c:if>
                    <c:if test="${defaultAddress==null}">
                        <p class="text-center">You haven't add any address</p>
                        <p class="text-center"><a href="add-address">Add new address</a></p>
                    </c:if>
                </div>
            </div>
            <!-- /SECTION -->

            <script>
                let setDefaultButton = document.getElementById('set-default');
                let newAddID;
                function getNewAddDefault(newAddIDValue) {
                    setDefaultButton.style.display = 'block';
                    newAddID = newAddIDValue;
                }
                function changeDefault(oldAddIDValue) {
                    window.location.href = 'add-default-address?oldAddID=' + oldAddIDValue + '&newAddID=' + newAddID;
                }
            </script>

            <%@include file="../client/templates/footer/footer.jsp" %>
            <%@include file="../client/templates/foot-libs.jsp" %>
    </body>
</html>