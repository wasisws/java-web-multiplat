/*
 * DuyDuc94
 */

package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.ProductDAO;
import model.Product;

/**
 * @author duy20
 */
public class ProductDashboardAdminServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    //PrintWriter out = response.getWriter();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        if (request.getSession().getAttribute("admin") != null) {
            ProductDAO proDAO = new ProductDAO();
            List<Product> listProducts = proDAO.getProductList();
            request.setAttribute("listProducts", listProducts);
            request.getRequestDispatcher("product-dashboard.jsp").forward(request, response);
        } else {
            response.sendRedirect("homepage");
        }
        request.getRequestDispatcher("product-dashboard.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        
    }

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductDashboardAdminServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductDashboardAdminServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }     

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
