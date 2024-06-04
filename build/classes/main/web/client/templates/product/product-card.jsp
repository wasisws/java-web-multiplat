<%-- Created on : Jul 7, 2023, 10:22:55 PM by DuyDuc94 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="remove-cart" method="post" id="product-card-form">
    <div class="product-card">
        <div class="product-image">
            <img src="templates/img${product.getImage()}" alt="Airpod Max">
        </div>
        <div class="product-info">
            <h3 class="product-name"><a href="view-product?proID=${product.getProductID()}&color=${product.getProductColor()}">${product.getProductName()}</a></h3>
            <div class="product-price">$${product.getPrice()}</div>
            <div class="product-color">
                <label for="product-color">Color:</label> 
                <span style="text-transform: capitalize">${product.getProductColor()}</span>
                <!--<select id="product-color">
                    <option value="black">Black</option>
                    <option value="grey">Grey</option>
                    <option value="white">White</option>
                </select>-->
            </div>
        </div>
        <div class="add-to-cart">
            <div class="product-quantity">
                <div class="quantity-label">Quantity:</div> ${product.getQuantity()}
                <!--<button class="quantity-button">-</button>
                    <input type="text" class="quantity-input" value="1" readonly>
                <button class="quantity-button">+</button>-->
            </div>
        </div>
        <div class="action-buttons">
            <input type="hidden" name="cartID" value="${product.getID()}">
            <button type="submit" class="remove-product-button">Remove Product</button>
        </div>
    </div>
</form>
