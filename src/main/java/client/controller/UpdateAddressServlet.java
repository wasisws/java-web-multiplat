/*
 * DuyDuc94
 */

package client.controller;

import dal.AddressDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author duy20
 */
public class UpdateAddressServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    //PrintWriter out = response.getWriter();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        if (request.getSession().getAttribute("user") != null) {
            int addressID = Integer.parseInt(request.getParameter("addressID"));
            AddressDAO addressDAO = new AddressDAO();
            request.setAttribute("fullAddress", addressDAO.getAddress(addressID));
            request.getRequestDispatcher("update-address.jsp").forward(request, response);
        } else {
            response.sendRedirect("homepage");
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        int addressID = Integer.parseInt(request.getParameter("addressID"));
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        AddressDAO addressDAO = new AddressDAO();
        addressDAO.updateAddress(addressID, address, city);
        response.sendRedirect("view-address");
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">    
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateAddressServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateAddressServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }     

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
