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
public class RemoveAddressServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    //PrintWriter out = response.getWriter();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            AddressDAO addressDAO = new AddressDAO();
            int addressID = Integer.parseInt(request.getParameter("addressID"));
            if (request.getParameter("newAddressID") == null) {
                addressDAO.removeAddress(addressID);
                response.sendRedirect("view-address");
            } else {
                int newAddressID = Integer.parseInt(request.getParameter("newAddressID"));
                addressDAO.removeDefault(addressID, newAddressID);
                response.sendRedirect("view-address");
            }
        } else {
            response.sendRedirect("homepage");
        }
    }    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
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
            out.println("<title>Servlet RemoveAddressServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RemoveAddressServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
