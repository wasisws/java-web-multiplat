<%-- Created on : Jul 9, 2023, 10:30:04 PM by DuyDuc94 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="product-widget">
    <div class="product-img">
        <img src="templates/img${product.getImage()}" alt="${product.getImage()}">
    </div>
    <div class="product-body">
        <h3 class="product-name">
            <a href="view-product?proID=${product.getProductID()}&color=${product.getProductColor()}">${product.getProductName()}</a>
        </h3>
        <h4 class="product-price" >
            <span class="qty" style="text-transform: capitalize">${product.getProductColor()}</span>
        </h4>
        <h4 class="product-price">
            <span class="qty">${product.getQuantity()}x</span>$${product.getPrice()}
        </h4>
    </div>
</div>

