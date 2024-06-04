/*
 *     DuyDuc94
 */

package client.controller;

import dal.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 * @author duy20
 */
public class AddWishlistServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("client/view-wishlist.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession session = request.getSession(true);
        Account user = (Account) session.getAttribute("user");
        if (user == null) {
            request.setAttribute("message", "Login to add your favorite products");
            request.getRequestDispatcher("client/login.jsp").forward(request, response);
            return;
        }
        int proID = Integer.parseInt(request.getParameter("proID"));
        WishlistDAO wishlistDAO = new WishlistDAO();
        boolean isAddToWishlist = wishlistDAO.addToWishlist(user.getID(), proID);
        if (isAddToWishlist) {
//            request.getRequestDispatcher("view-wishlist.jsp").forward(request, response);
            response.sendRedirect(request.getHeader("referer"));
        } else {
            //Message that add to wishlist failed
            response.sendRedirect("homepage");
        }
    }
}
