<%-- Created on : Jul 3, 2023, 4:26:22 PM by DuyDuc94--%>

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
                        <!--<h3 class="breadcrumb-header">Wishlist</h3>-->
                        <ul class="breadcrumb-tree">
                            <li><a href="homepage">Home</a></li>
                            <li><a href="cart">Your Cart</a></li>
                            <li class="active">Checkout</li>
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
                    <div class="col-md-7">

                        <!-- Billing Details -->
                        <div class="billing-details">
                            <div class="section-title">
                                <h3 class="title">Billing address</h3>
                            </div>
                            <form action="update-account" method="post">
                                <div class="form-group">
                                    <input class="input" type="text" name="name" value="${user.getName()}" readonly id="name">
                                </div>
                                <div class="form-group">
                                    <input class="input" type="email" name="email" value="${user.getEmail()}" required id="email">
                                </div>
                                <div class="form-group">
                                    <input class="input" type="number" name="phone"value="${user.getPhone()}" required id="phone">
                                </div>
                                <input type="hidden" name="urlRequest" value="view-checkout">
                                <div class="text-right">
                                    <input id="change" style="display:none;" class="primary-btn order-submit" type="submit" value="Change">
                                </div>
                            </form>
                        </div>
                        <!-- /Billing Details -->

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

                        <!-- Shiping Details -->
                        <c:if test="${defaultAddress!=null}">
                            <div class="shiping-details">
                                <div class="section-title">
                                    <h3 class="title">Shiping address</h3>
                                </div>
                                <div class="section-title">
                                    <h5 class="title">Default address</h5>
                                    <span>: </span>
                                    ${defaultAddress.getFullAddress()}
                                </div>
                                <div class="section-title">
                                    <h5 class="title">Other address</h5>
                                </div>
                                <div class="payment-method">
                                    <c:forEach var="address" items="${otherAddress}">
                                        <div class="input-radio">
                                            <input onclick="changeAddress(this.value)" type="radio" name="paymentMethod" id="${address.getID()}" value="${address.getID()}">
                                            <label for="${address.getID()}">
                                                <span></span>
                                                ${address.getFullAddress()}
                                            </label>
                                        </div>
                                    </c:forEach>
                                </div>

                                <div class="input-checkbox">
                                    <input type="checkbox" id="shiping-address">
                                    <label for="shiping-address">
                                        <span></span>
                                        Ship to a diffrent address?
                                    </label>
                                    <div class="caption">
                                        <form action="add-address" method="post">
                                            <div class="form-group">
                                                <input class="input" type="text" name="address" placeholder="Address" required id="address1">
                                            </div>
                                            <div class="form-group">
                                                <input class="input" type="text" name="city" placeholder="City" required id="city1">
                                            </div>
                                            <input type="hidden" name="urlRequest" value="view-checkout">
                                            <div class="text-right">
                                                <input id="add-new-address1" style="display: none;" class="primary-btn order-submit" type="submit" value="Add new address">
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${defaultAddress==null}">
                            <div class="shiping-details">
                                <div class="section-title">
                                    <h3 class="title">Shiping address</h3>
                                </div>
                                <form action="add-address" method="post">
                                    <div class="form-group">
                                        <input class="input" type="text" name="address" placeholder="Address" required id="address2" value="">
                                    </div>
                                    <div class="form-group">
                                        <input class="input" type="text" name="city" placeholder="City" required id="city2" value="">
                                    </div>
                                    <p style="color: red" id="addressMessage2"></p>
                                    <input type="hidden" name="urlRequest" value="view-checkout">
                                    <div class="text-right">
                                        <input style="display: inline;" class="primary-btn order-submit" type="submit" value="Add new address">
                                    </div>
                                </form>
                            </div>
                        </c:if>
                        <!-- /Shiping Details -->
                    </div>

                    <!-- Order Details -->
                    <form action="add-order" method="post" id="place-order-form">
                        <div class="col-md-5 order-details">
                            <div class="section-title text-center">
                                <h3 class="title">Your Order</h3>
                            </div>
                            <div class="order-summary">
                                <div class="order-col">
                                    <div><strong>PRODUCT</strong></div>
                                    <div><strong>TOTAL</strong></div>
                                </div>
                                <div class="order-products">
                                    <c:forEach var="cartItem" items="${cart}">
                                        <div class="order-col">
                                            <div>${cartItem.getProductName()} ${cartItem.getProductColor()} (${cartItem.getQuantity()}x)</div>
                                            <div>$${cartItem.getPrice()}</div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div class="order-col">
                                    <div>Shiping</div>
                                    <div><strong>FREE</strong></div>
                                </div>
                                <div class="order-col">
                                    <div><strong>TOTAL</strong></div>
                                    <div><strong class="order-total">$${user.getTotalPriceInCart(cart)}</strong></div>
                                </div>
                            </div>
                            <div class="payment-method">
                                <div class="input-radio">
                                    <input type="radio" name="paymentMethod" id="payment-1" value="Cash On Delivery">
                                    <label for="payment-1"><span></span>
                                        Cash On Delivery
                                    </label>
                                </div>
                                <div class="input-radio">
                                    <input type="radio" name="paymentMethod" id="payment-2" value="Direct Bank Transfer">
                                    <label for="payment-2"><span></span>
                                        Direct Bank Transfer
                                    </label>
                                    <div class="caption">
                                        <p><strong>Transfer money to account</strong></p>
                                        <p><strong>BIDV</strong>: 21199002359999</p>
                                        <p><strong>Account Name</strong>: LUONG HUU DUC DUY</p>
                                    </div>
                                </div>
                                <p style="color: red;" id="paymentMessage"></p>
                            </div>
                            <input type="hidden" name="addressID" id="addressID" value="${defaultAddress.getID()}">
                            <input type="hidden" name="dateOrder" id="date" value="">
                            <input onclick="validateForm(event)" style="width: 100%" class="primary-btn order-submit" type="submit" value="Place order">
                        </div>
                    </form>
                    <!-- /Order Details -->
                </div>
            </div>
        </div>
        <!-- /SECTION -->

        <script>
            let nameInput = document.getElementById('name');
            let phoneInput = document.getElementById('phone');
            let emailInput = document.getElementById('email');

            let addressInput1 = document.getElementById('address1');
            let cityInput1 = document.getElementById('city1');
            let addressInput2 = document.getElementById('address2');
            let cityInput2 = document.getElementById('city2');

            let changeButton = document.getElementById('change');
            let addButton1 = document.getElementById('add-new-address1');

            function update() {
                if (nameInput.value || phoneInput.value || emailInput.value) {
                    changeButton.style.display = 'inline';
                } else {
                    changeButton.style.display = 'none';
                }
            }

            function addOtherAddress() {
                if (addressInput1.value || cityInput1.value) {
                    addButton1.style.display = 'inline';
                } else {
                    addButton1.style.display = 'none';
                }
            }

            nameInput.addEventListener('input', update);
            phoneInput.addEventListener('input', update);
            emailInput.addEventListener('input', update);
            addressInput1.addEventListener('input', addOtherAddress);
            cityInput1.addEventListener('input', addOtherAddress);


            let addressID = document.getElementById('addressID').value;
            function changeAddress(addressIDValue) {
                document.getElementById('addressID').value = addressIDValue;
            }


            function validateForm(event) {
                var today = new Date();
                var year = today.getFullYear();
                var month = String(today.getMonth() + 1).padStart(2, '0');
                var day = String(today.getDate()).padStart(2, '0');
                var formattedDate = year + '-' + month + '-' + day;
                document.getElementById('date').value = formattedDate;
                let paymentMessage = document.getElementById('paymentMessage');
                let addressMessage2 = document.getElementById('addressMessage2');
                let paymentMethods = document.getElementsByName('paymentMethod');
                let address2 = document.getElementById('address2');
                let city2 = document.getElementById('city2');
                let addressID = document.getElementById('addressID').value;
                let addressChecked = false;
                let paymentChecked = false;

                if (address2 !== null && city2 !== null) {
                    if (address2.value.trim() === '' || city2.value.trim() === '') {
                        addressChecked = false;
                    } else {
                        addressChecked = true;
                    }
                } else {
                    addressChecked = true;
                }

                for (var i = 0; i < paymentMethods.length; i++) {
                    if (paymentMethods[i].checked) {
                        paymentChecked = true;
                        break;
                    }
                }

                if (!paymentChecked || !addressChecked || addressID === '') {
                    if (address2 !== null && city2 !== null) {
                        if (!addressChecked) {
                            addressMessage2.innerHTML = 'Please fill out the address';
                        } else {
                            addressMessage2.innerHTML = '';
                        }
                    }
                    if (addressMessage2 !== null) {
                        if (addressID === '') {
                            addressMessage2.innerHTML = 'Please add new address';
                        } else {
                            addressMessage2.innerHTML = '';
                        }
                    }
                    if (!paymentChecked) {
                        paymentMessage.innerHTML = 'Please choose a payment method';
                    } else {
                        paymentMessage.innerHTML = '';
                    }
                    event.preventDefault(); // Prevent form submission if no option is selected
                }
            }
        </script>

        <%@include file="../client/templates/footer/footer.jsp" %>
        <%@include file="../client/templates/foot-libs.jsp" %>
    </body>
</html>
