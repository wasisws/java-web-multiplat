/*
 *     DuyDuc94
 */
package client.controller;

import dal.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Product;

/**
 *
 * @author duy20
 */
public class ViewHomepageServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        ProductDAO proDAO = new ProductDAO();
        List<Product> listBestSellLaptops = proDAO.getBestSellProducts("Laptops");
        List<Product> listBestSellSmartphones = proDAO.getBestSellProducts("Smartphones");
        List<Product> listBestSellTablets = proDAO.getBestSellProducts("Tablets");
        List<Product> listBestSellAccessories = proDAO.getBestSellProducts("Accessories");
        request.setAttribute("listBestSellLaptops", listBestSellLaptops);
        request.setAttribute("listBestSellSmartphones", listBestSellSmartphones);
        request.setAttribute("listBestSellTablets", listBestSellTablets);
        request.setAttribute("listBestSellAccessories", listBestSellAccessories);
        request.getRequestDispatcher("client/homepage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

    }
}
