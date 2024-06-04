/*
 * DuyDuc94
 */

package client.controller;

import dal.WishlistDAO;
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

public class RemoveWishlistServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    
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
        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("user");
        WishlistDAO wishlistDAO = new WishlistDAO();
        int proID = Integer.parseInt(request.getParameter("proID"));
        wishlistDAO.removeWishlist(user.getID(), proID);
        response.sendRedirect(request.getHeader("referer"));
    }
}
