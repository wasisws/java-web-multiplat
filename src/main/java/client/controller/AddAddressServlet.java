/*
 * DuyDuc94
 */

package client.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.AddressDAO;
import model.Account;

/**
 * @author duy20
 */
public class AddAddressServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    //PrintWriter out = response.getWriter();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        if (request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher("add-address.jsp").forward(request, response);
            return;
        } else {
            response.sendRedirect("homepage");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        Account user = (Account) request.getSession().getAttribute("user");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String urlRequest = request.getParameter("urlRequest");
        AddressDAO addressDAO = new AddressDAO();
        addressDAO.addAddress(address, city, user.getID());
        if(urlRequest==null){
            response.sendRedirect("view-address");
        }else{
            response.sendRedirect(urlRequest);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddAddressServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddAddressServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
