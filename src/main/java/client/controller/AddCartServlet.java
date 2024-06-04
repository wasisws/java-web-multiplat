/*
 * DuyDuc94
 */

package client.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.CartDAO;
import dal.ProductOptionDAO;
import lib.MyHttpServletRequest;
import model.Account;
import model.Product_Detail;

/**
 * @author duy20
 */
public class AddCartServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    //PrintWriter out = response.getWriter();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.sendRedirect("homepage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        Account user = (Account) request.getSession().getAttribute("user");
        
        if (user == null) {
            request.setAttribute("message", "Login to add products to your cart");
            request.setAttribute("url-request", request.getHeader("referer"));
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("view-product");
        MyHttpServletRequest myRequest = new MyHttpServletRequest(request, "POST");

        int proID = Integer.parseInt(request.getParameter("proID"));
        ProductOptionDAO proDetailDAO = new ProductOptionDAO();
        CartDAO cartDAO = new CartDAO();
        Product_Detail proDetail = new Product_Detail();
        boolean canAddToCart = true;
        int proDetailID = -1;
        try {
            proDetailID = Integer.parseInt(request.getParameter("proDetailID"));
            proDetail = proDetailDAO.getProductOpt(proDetailID);
        } catch (NumberFormatException e) {}

        if (proDetailID == -1) {
            request.setAttribute("colorMessage", "Please select color!");
            canAddToCart = false;
        }
        String selectedColor = request.getParameter("color");

        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if (quantity > 0) {
            if (canAddToCart && quantity > proDetail.getQuantity()) {
                request.setAttribute("quantityMessage", "We only have " + proDetail.getQuantity() + " products left");
                canAddToCart = false;
            }
        } else {
            request.setAttribute("quantityMessage", "Please choose quantity<br>greater than 0");
            canAddToCart = false;
        }

        if (canAddToCart) {
            if (cartDAO.isInCart(user.getID(), proDetailID)) {
                int newQuantity = cartDAO.canAddMore(user.getID(), proDetailID, quantity);
                if (newQuantity > 0) {
                    cartDAO.updateToCart(user.getID(), proDetailID, newQuantity);
                    request.setAttribute("addToCartMessage", "Add to cart successfully");
                } else {
                    request.setAttribute("quantityMessage", "There are " + cartDAO.getCartItem(user.getID(), proDetailID).getQuantity() + " products in your cart");
                }
            } else {
                cartDAO.addToCart(user.getID(), proDetailID, quantity);
                request.setAttribute("addToCartMessage", "Add to cart successfully");
            }
        }
        
        request.setAttribute("proID", proID);
        request.setAttribute("color", selectedColor);
        dispatcher.forward(myRequest, response);
    }

}
