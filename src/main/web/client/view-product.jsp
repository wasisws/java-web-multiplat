<%-- Created on : Jul 6, 2023, 3:48:56 PM by DuyDuc94 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import = "java.util.*" %>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Products</title>
        <%@include file="../client/templates/head-libs.jsp" %>
    </head>

    <body>
        <%@include file="../client/templates/header/header.jsp" %>
        <%@include file="../client/templates/header/navigation.jsp" %>

        <c:set var="mainProduct" value="${requestScope['mainProduct']}"/>
        <c:set var="listProductDetail" value="${requestScope['listProductDetail']}"/>
        <c:set var="listRelatedProduct" value="${requestScope['listRelatedProduct']}"/>

        <c:set var="proDetail" value="${requestScope['proDetail']}"/>

        <!-- BREADCRUMB -->
        <div id="breadcrumb" class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="breadcrumb-tree">
                            <h3 class="breadcrumb-header">Store</h3>
                            <li class="active"><a href="homepage">Home</a></li>
                            <li><a href="search?category=All">All Categories</a></li>
                            <li><a href="search?category=${mainProduct.getCategoryName()}">${mainProduct.getCategoryName()}</a></li>
                            <li><a href="search?category=${mainProduct.getCategoryName()}&brand=${mainProduct.getBrandName()}">${mainProduct.getBrandName()}</a></li>
                            <li>${mainProduct.getName()}</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- /BREADCRUMB -->

        <!-- VIEW PRODUCT -->
        <div class="section">
            <div class="container">
                <div class="row">
                    <!-- Product main img -->
                    <div class="col-md-5 col-md-push-2">
                        <div id="product-main-img">
                            <div class="product-preview">
                                <img src="./client/assets/images/${mainProduct.getImage()}" alt="${mainProduct.getName()}">
                            </div>
                            <c:forEach var="productImage1" items="${listProductDetail}">
                                <div class="product-preview">
                                    <img src="./client/assets/images/${productImage1.getImage()}" alt="${mainProduct.getName()}">
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <!-- /Product main img -->

                    <!-- Product thumb imgs -->
                    <div class="col-md-2  col-md-pull-5">
                        <div id="product-imgs">
                            <div class="product-preview">
                                <img src="templates/img${mainProduct.getImage()}" alt="${mainProduct.getName()}">
                            </div>
                            <c:forEach var="productImage2" items="${listProductDetail}">
                                <div class="product-preview">
                                    <img src="templates/img${productImage2.getImage()}" alt="${mainProduct.getName()}">
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <!-- /Product thumb imgs -->

                    <!-- Product details -->
                    <div class="col-md-5">
                        <div class="product-details">
                            <h2 class="product-name">${mainProduct.getName()}</h2>
                            <div>
                                <h3 id="price" class="product-price">$${proDetail!=null?proDetail.getPrice():mainProduct.getPrice()}</h3>
                                <span class="product-available">Remain: ${proDetail!=null?proDetail.getQuantity():mainProduct.getQuantity()}</span>
                            </div>
                            <p>${mainProduct.getDescription()}</p>

                            <div class="product-options">
                                <label>
                                    Color
                                    <form action="view-product" method="get" id="getColor">
                                        <input type="hidden" name="proID" value="${mainProduct.getID()}">
                                        <select onchange="getColor.submit()" 
                                                style="text-transform: capitalize" 
                                                name="color" class="input-select" required>
                                            <c:if test="${proDetail==null}">
                                                <option selected></option>
                                            </c:if>
                                            <c:forEach var="productDetail" items="${listProductDetail}">
                                                <option value="${productDetail.getColor()}" ${proDetail.getColor()==productDetail.getColor()?'selected':''}>${productDetail.getColor()}</option>
                                            </c:forEach>
                                        </select>
                                    </form>
                                </label>
                                <p style="color: red; text-transform: capitalize">${requestScope['colorMessage']}</p>
                            </div>
                            <form action="add-to-cart" method="post">
                                <input type="hidden" name="proID" value="${mainProduct.getID()}">
                                <input type="hidden" name="proDetailID" value="${proDetail.getID()}">
                                <input type="hidden" name="color" value="${proDetail.getColor()==null?null:proDetail.getColor()}" required>
                                <div class="add-to-cart">
                                    <div class="qty-label">
                                        Qty
                                        <div class="input-number">
                                            <input onchange="changPrice(this.value, ${proDetail.getPrice()})" name="quantity" type="number" value="1" required>
                                            <span class="qty-up">+</span>
                                            <span class="qty-down">-</span>
                                        </div>
                                        <p style="color: red; text-transform: capitalize">${requestScope['quantityMessage']}</p>
                                    </div>
                                    <button type="submit" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                </div>
                                <p style="color: red; text-transform: capitalize">${requestScope['addToCartMessage']}</p>
                            </form>

                            <!--Add to wishlist-->
                            <c:if test="${mainProduct.isInWishlist(user.getID())==true}">
                                <form action="remove-wishlist" method="post" id="add-to-wishlist">
                                    <input type="hidden" name="proID" value="${mainProduct.getID()}">
                                </form>
                                <ul class="product-btns">
                                    <li>
                                        <a onclick="document.getElementById('add-to-wishlist').submit();" style="cursor: pointer;"><i class="fa fa-heart"></i> remove from wishlist</a>
                                    </li>
                                </ul>
                            </c:if>
                            <!--Add to wishlist-->

                            <!--Remove from wishlist-->
                            <c:if test="${mainProduct.isInWishlist(user.getID())==false}">
                                <form action="add-wishlist" method="post" id="add-to-wishlist">
                                    <input type="hidden" name="proID" value="${mainProduct.getID()}">
                                </form>
                                <ul class="product-btns">
                                    <li>
                                        <a onclick="document.getElementById('add-to-wishlist').submit();" style="cursor: pointer;"><i class="fa fa-heart-o"></i> add to wishlist</a>
                                    </li>
                                </ul>
                            </c:if>
                            <!--Remove from wishlist-->
                        </div>
                    </div>
                    <!-- /Product details -->

                    <!-- Product tab -->
                    <div class="col-md-12">
                        <div id="product-tab">
                            <!-- product tab nav -->
                            <ul class="tab-nav">
                                <li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
                                <li><a data-toggle="tab" href="#tab2">Details</a></li>
                                <li><a data-toggle="tab" href="#tab3">Reviews (3)</a></li>
                            </ul>
                            <!-- /product tab nav -->

                            <!-- product tab content -->
                            <div class="tab-content">

                                <!-- tab1  -->
                                <div id="tab1" class="tab-pane fade in active">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <p>${mainProduct.getDescription()}</p>
                                        </div>
                                    </div>
                                </div>
                                <!-- /tab1  -->

                                <!-- tab2  -->
                                <div id="tab2" class="tab-pane fade in">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h1 class="text-center">Underdeveloping</h1>
                                        </div>
                                    </div>
                                </div>
                                <!-- /tab2  -->

                                <!-- tab3  -->
                                <div id="tab3" class="tab-pane fade in">
                                    <div class="row">
                                        <h1 class="text-center">Underdeveloping</h1>
                                    </div>
                                </div>
                                <!-- /tab3  -->
                            </div>
                            <!-- /product tab content  -->
                        </div>
                    </div>
                    <!-- /product tab -->
                </div>
            </div>
        </div>
        <!-- /VIEW PRODUCT -->

        <!-- RELATED PRODUCT -->
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-title text-center">
                            <h3 class="title">Related Products</h3>
                        </div>
                    </div>
                    <c:forEach var="product" items="${listRelatedProduct}">
                        <c:if test="${product.getID()!=mainProduct.getID()}">
                            <div class="col-md-3 col-xs-6">
                                <%@include file="../client/templates/product/product-tab.jsp" %>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- /RELATED PRODUCT -->

        <%@include file="../client/templates/footer/footer.jsp" %>
        <%@include file="../client/templates/foot-libs.jsp" %>

        <script>
            function changPrice(quantity, basePrice) {
                if (basePrice == null) {
                    return;
                }
                let newPrice = quantity * basePrice;
                let priceElement = document.getElementById('price');
                if (priceElement) {
                    priceElement.innerHTML = '$' + newPrice.toFixed(2);
                }
            }
        </script>
    </body>
</html>