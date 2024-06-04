/*
 *     DuyDuc94
 */

package client.controller;

import dal.BrandDAO;
import dal.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Brand;
import model.Product;

/**
 * @author duy20
 */
public class SearchServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("category");
        String brand = request.getParameter("brand");
        String info = request.getParameter("info");
        BrandDAO brandDAO = new BrandDAO();
        ProductDAO proDAO = new ProductDAO();
        List<Brand> listBrands = new ArrayList<>();
        List<Product> listProducts = new ArrayList<>();
        List<Product> showListProducts = new ArrayList<>();
        
        if (category != null) {
            if (category.compareTo("All") != 0) {
                if (info == null) {
                    listProducts = proDAO.getProductInCategory(category);
                    listBrands = brandDAO.getBrandListByCategory(category);
                    if (brand != null) {
                        listProducts = proDAO.getProductList(category, brand);
                    }
                } else {
                    listProducts = proDAO.getProductInCategory(category, info);
                }
            } else {
                if (info == null) {
                    listProducts = proDAO.getProductList();
                } else {
                    listProducts = proDAO.getProductList(info);
                }
            }
        } else {
            response.sendRedirect("client/homepage");
            return;
        }
        
        //Sort
        String sortBy = request.getParameter("sortBy")!=null?request.getParameter("sortBy"):"name";
        String sortType = request.getParameter("sortType")!=null?request.getParameter("sortType"):"ascending";
        listProducts = proDAO.sort(listProducts, sortBy, sortType);
        
        //Paging
        int productPerPage = 6;
        int numOfPage = listProducts.size() / productPerPage + (listProducts.size() % productPerPage == 0 ? 0 : 1);
        int currPage = 1;
        try {
            currPage = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {}
        int start = productPerPage * currPage - productPerPage;
        int end = productPerPage * currPage - 1;
        for (int i = start; i <= end; i++) {
            if (i==listProducts.size()) {
                break;
            }
            showListProducts.add(listProducts.get(i));
        }
        
        request.setAttribute("categoryChecked", category);
        request.setAttribute("brandChecked", brand);
        request.setAttribute("listBrands", listBrands);
        request.setAttribute("allProductsSize", listProducts.size());
        request.setAttribute("listProducts", showListProducts);
        request.setAttribute("sortBy", sortBy);
        request.setAttribute("sortType", sortType);
        request.setAttribute("currPage", currPage);
        request.setAttribute("numOfPage", numOfPage);
        request.getRequestDispatcher("client/view-store.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

    }
}
