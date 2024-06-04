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
import model.Account;

/**
 * @author duy20
 */
public class UpdatePasswordServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    //PrintWriter out = response.getWriter();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        if (request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher("change-password.jsp").forward(request, response);
        } else {
            response.sendRedirect("homepage");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        Account user = (Account) request.getSession().getAttribute("user");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
        boolean canChange = true;

        if (user.getPassword().compareTo(oldPassword) != 0) {
            request.setAttribute("oldPasswordMessage", "Old password is not correct!");
            canChange = false;
        }
        if (newPassword.compareTo(confirmNewPassword) != 0) {
            request.setAttribute("confirmPasswordMessage", "Password is not match!");
            canChange = false;
        }
        if(canChange){
            AccountDAO accountDAO = new AccountDAO();
            request.getSession().setAttribute("user", accountDAO.updateUserPassword(user.getID(), newPassword));
            response.sendRedirect("view-account");
        }else{
            request.getRequestDispatcher("change-password.jsp").forward(request, response);
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
            out.println("<title>Servlet UpdatePasswordServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdatePasswordServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
