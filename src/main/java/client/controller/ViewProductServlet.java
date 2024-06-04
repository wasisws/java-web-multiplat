/*
 * DuyDuc94
 */

package client.controller;

import dal.ProductDAO;
import dal.ProductOptionDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Product;
import model.Product_Detail;

/**
 * @author duy20
 */
public class ViewProductServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    //PrintWriter out = response.getWriter();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        int proID = Integer.parseInt(request.getParameter("proID"));
        ProductDAO proDAO = new ProductDAO();
        Product mainProduct = proDAO.getProductByID(proID);
        List<Product> listRelatedProduct = proDAO.getRelatedProductList(mainProduct.getBrandID());
        ProductOptionDAO proDetDAO = new ProductOptionDAO();
        List<Product_Detail> listProductDetail = proDetDAO.getProductOptList(proID);
        Product_Detail proDetail = null;

        String color = request.getParameter("color");
        if (color != null) {
            proDetail = proDetDAO.getColor(proID, color);
        }
        
        request.setAttribute("mainProduct", mainProduct);
        request.setAttribute("listProductDetail", listProductDetail);
        request.setAttribute("listRelatedProduct", listRelatedProduct);
        request.setAttribute("proDetail", proDetail);
        request.getRequestDispatcher("client/view-product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        ProductDAO proDAO = new ProductDAO();
        int proID =  (int) request.getAttribute("proID");
        Product mainProduct = proDAO.getProductByID(proID);
        List<Product> listRelatedProduct = proDAO.getRelatedProductList(mainProduct.getBrandID());
        ProductOptionDAO proDetDAO = new ProductOptionDAO();
        List<Product_Detail> listProductDetail = proDetDAO.getProductOptList(proID);

        String color = (String) request.getAttribute("color");
        Product_Detail proDetail = proDetDAO.getColor(proID, color);

        request.setAttribute("mainProduct", mainProduct);
        request.setAttribute("listProductDetail", listProductDetail);
        request.setAttribute("listRelatedProduct", listRelatedProduct);
        request.setAttribute("proDetail", proDetail);
        request.setAttribute("colorMessage", request.getAttribute("colorMessage"));
        request.setAttribute("quantityMessage", request.getAttribute("quantityMessage"));
        request.setAttribute("addToCartMessage", request.getAttribute("addToCartMessage"));
        request.getRequestDispatcher("client/view-product.jsp").forward(request, response);
    }

}
