/*
 * DuyDuc94
 */

package client.controller;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lib.MyValidated;
import model.Account;

/**
 * @author duy20
 */
public class UpdateAccountServket extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    //PrintWriter out = response.getWriter();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        if (request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher("update-account.jsp").forward(request, response);
        } else {
            response.sendRedirect("homepage");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String urlRequest = request.getParameter("urlRequest");
        boolean canUpdate = true;

        //Check legit of name
        if (!MyValidated.isLegitName(name)) {
            request.setAttribute("nameMessage", "Name not valid!");
            canUpdate = false;
        }
        //Check phone
        if (!MyValidated.isLegitPhone(phone)) {
            request.setAttribute("phoneMessage", "Phone only contain number!");
            canUpdate = false;
        }

        //Check email
        if (!MyValidated.isLegitEmail(email)) {
            request.setAttribute("emailMessage", "Email is not valid!");
            canUpdate = false;
        }

        if (canUpdate) {
            HttpSession session = request.getSession();
            AccountDAO userDAO = new AccountDAO();
            Account user = (Account) session.getAttribute("user");
            user = userDAO.updateUserInfomation(user.getID(), name, phone, email);
            session.setAttribute("user", user);
            if (urlRequest == null) {
                response.sendRedirect("view-account");
            } else {
                response.sendRedirect(urlRequest);
            }
        } else {
            if (urlRequest == null) {
                request.getRequestDispatcher("update-account.jsp").forward(request, response);
            } else {
                response.sendRedirect(urlRequest);
            }
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
            out.println("<title>Servlet UpdateAccountServket</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateAccountServket at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
