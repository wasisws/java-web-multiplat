/*
 * DuyDuc94
 */

package client.controller;

import dal.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Order;
import model.Account;

/**
 * @author duy20
 */
public class ViewOrderServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    //PrintWriter out = response.getWriter();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        Account user = (Account) request.getSession().getAttribute("user");
        if (user != null) {
            OrderDAO orderDAO = new OrderDAO();
            List<Order> orderList = orderDAO.getOrdersList(user.getID());
            request.setAttribute("orderList", orderList);
            request.getRequestDispatcher("view-order.jsp").forward(request, response);
        } else {
            response.sendRedirect("homepage");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

    }
}
