<%-- Created on : Jul 2, 2023, 10:29:31 AM  by DuyDuc94 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    //Always load user's infomation, user's wishlist, user's cart when enter a site
    Account user = (Account) session.getAttribute("user");
    WishlistDAO wishlistDAO = new WishlistDAO();
    CartDAO cartDAO = new CartDAO();
    
    List<Product> wishlist = null;
    List<Cart_Item> cart = null;
    
    //If the user is logged in, get user's wishlist and cart
    if (user != null) {
        wishlist = wishlistDAO.getWishlistOf(user.getID());
        cart = cartDAO.getCartListOf(user.getID());
    }
%>

<c:set var="user" value="<%=user%>"/>
<c:set var="wishlist" value="<%=wishlist%>"/>
<c:set var="cart" value="<%=cart%>"/>

<header>
    <!--TOP-HEADER-->
    <div id="top-header">
        <div class="container">

            <!--Left-top-header-->
            <ul class="header-links pull-left">
                <li>
                    <a href="">
                        <i class="fas fa-phone-alt"></i>+84 943.218.394
                    </a>
                </li>
                <li>
                    <a href="mailto:duyduc.luonghuu@gmail.com">
                        <i class="fas fa-paper-plane"></i>duyduc.luonghuu@gmail.com
                    </a>
                </li>
                <li>
                    <a href="https://goo.gl/maps/i71FMA5LcMEcYZde6" target="_blank">
                        <i class="fas fa-map-marker-alt"></i>Hai Duong, Viet Nam
                    </a>
                </li>
            </ul>
            <!--Left-top-header-->

            <!--Right-top-header-->
            <ul class="header-links pull-right">
                <li>
                    <div class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-globe"></i>English
                        </a>
                        <div class="dropdown-menu dropdown-menu-left" style="background-color: #1E1F29;">
                            <a class="dropdown-item" href="#">English</a><br>
                            <a class="dropdown-item" href="#">Vietnamese</a>
                        </div>
                    </div>
                </li>

                <c:if test="${user==null}">
                    <li>
                        <a href="login">
                            <i class="fas fa-sign-in-alt"></i>Login
                        </a>
                    </li>
                    <li>
                        <a href="register">
                            <i class="fas fa-user-plus"></i>Register
                        </a>
                    </li>
                </c:if>

                <c:if test="${user!=null}">
                    <li>
                        <a href="view-account">
                            <i class="fas fa-user"></i>${user.getUsername()}
                        </a>
                    </li>
                    <li>
                        <a href="logout">
                            <i class="fas fa-sign-out-alt"></i>Logout
                        </a>
                    </li>
                    <c:if test="${sessionScope['isAdmin']==true}">
                        <li>
                            <a href="#">
                                <i class="fas fa-columns fa-spin"></i>Dashboard
                            </a>
                        </li>
                    </c:if>
                </c:if>
            </ul>
            <!--Right-top-header-->

        </div>
    </div>
    <!--TOP-HEADER-->

    <!--MAIN-HEADER-->
    <div id="header">
        <div class="container">
            <div class="row">

                <!--Logo-->
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="homepage" class="logo">
                            <img src="./client/assets/images/logo.png" alt="Logo" title="Home Page">
                        </a>
                    </div>
                </div>
                <!--Logo-->

                <!--Search-bar-->
                <div class="col-md-6">
                    <div class="header-search">
                        <form action="search" method="GET">
                            <select name="category" class="input-select">
                                <option value="All">All Categories</option>
                                <option value="Laptops">Laptops</option>
                                <option value="Smartphones">Smartphones</option>
                                <option value="Tablets">Tablets</option>
                                <option value="Accessories">Accessories</option>
                            </select>
                            <input name="info" class="input" placeholder="${param.info==""||param.info==null?'Search here':param.info}">
                            <button type="submit" class="search-btn">
                                <i class="fas fa-search"></i>&nbsp;Search
                            </button>
                        </form>
                    </div>
                </div>
                <!--Search-bar-->

                <!--Account-->
                <div class="col-md-3 clearfix">
                    <div class="header-ctn">

                        <!--Wishlist-->
                        <div>
                            <a href="view-wishlist">
                                <i class="fas fa-heart"></i>
                                <span>Your Wishlist</span>
                                <c:if test="${wishlist!=null && wishlist.size()>0}">
                                    <div class="qty">${wishlist.size()}</div>
                                </c:if>
                            </a>
                        </div>
                        <!--Wishlist-->

                        <!--Cart-->
                        <div class="dropdown">
                            <a href="view-cart" ${(cart!=null && cart.size()==0)?'':'class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"'}>
                                <i class="fas fa-shopping-cart"></i>
                                <span>Your Cart</span>
                                <c:if test="${cart!=null && cart.size()>0}">
                                    <div class="qty">${cart.size()}</div>
                                </c:if>
                            </a>

                            <c:if test="${cart!=null && cart.size()>0}">
                                <div class="cart-dropdown">
                                    <div class="cart-list">
                                        <c:forEach var="product" items="${cart}">
                                            <%@include file="../product/cart-item-widget.jsp" %>
                                        </c:forEach>
                                    </div>
                                    <div class="cart-summary">
                                        <small>${cart.size()} Item(s) selected</small>
                                        <h5>TOTAL: $${user.getTotalPriceInCart(cart)}</h5>
                                    </div>
                                    <div class="cart-btns">
                                        <a href="view-cart">
                                            <i class="fas fa-shopping-cart"></i>  View Cart
                                        </a>
                                        <a href="view-checkout">
                                            Checkout  <i class="fa fa-arrow-circle-right"></i>
                                        </a>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                        <!--Cart-->

                        <!--Menu Toogle (use for responsive)-->
                        <div class="menu-toggle">
                            <a href="#">
                                <i class="fa fa-bars"></i>
                                <span>Menu</span>
                            </a>
                        </div>
                        <!--Menu Toogle (use for responsive)-->

                    </div>
                </div>
                <!--Account-->

            </div>
        </div>
    </div>
    <!--MAIN-HEADER-->
</header>

