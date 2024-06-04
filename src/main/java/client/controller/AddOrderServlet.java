/*
 * DuyDuc94
 */

package client.controller;

import dal.OrderDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import model.Account;

/**
 * @author duy20
 */
public class AddOrderServlet extends HttpServlet {

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
        int addressID = Integer.parseInt(request.getParameter("addressID"));
        Date dateOrder = Date.valueOf(request.getParameter("dateOrder"));
        String paymentMethod = request.getParameter("paymentMethod");
        OrderDAO orderDAO = new OrderDAO();
        if(orderDAO.addOrder(user.getID(), dateOrder, addressID, paymentMethod)){
            response.sendRedirect("view-order");
        }else{
            response.sendRedirect("homepage");
        }
    }
    
}
