<%-- Created on : Jul 4, 2023, 5:06:20 PM by DuyDuc94 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- product widget -->
<div class="product-widget">
    <div class="product-img">
        <img src="./client/assets/images/${product.getImage()}" alt="${product.getImage()}">
    </div>
    <div class="product-body">
        <p class="product-category">${product.getCategoryName()}</p>
        <h3 class="product-name"><a href="view-product?proID=${product.getID()}">${product.getName()}</a></h3>
        <h4 class="product-price">$${product.getPrice()}</h4>
    </div>
</div>
<!-- /product widget -->
