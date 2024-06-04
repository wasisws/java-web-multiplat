/*
 *     DuyDuc94
 */
package client.controller;

import dal.AccountDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 * @author duy20
 */
public class GetUserInServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("client/login.jsp").forward(request, response);
        } else {
            response.sendRedirect("homepage");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String requestUrl = request.getParameter("url-request");
        AccountDAO userDAO = new AccountDAO();
        Account user = userDAO.getUser(username, password);
        if (user == null) {
            request.setAttribute("message", "Username or Password is <b>INCORRECT</b><br>Try again!");
            request.setAttribute("url-request", requestUrl);
            request.getRequestDispatcher("client/login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession(true);
            //Check if account is not disable
            if (user.isStatus()) {
                session.setAttribute("user", user);
                //Check if account is user
                if (user.isRole()) {
                    session.setAttribute("isAdmin", true);
                }
                //Return previous page if have
                if (requestUrl != null && !requestUrl.isEmpty()) {
                    response.sendRedirect(requestUrl);
                } else {
                    response.sendRedirect("homepage");
                }
            } else {
                request.setAttribute("message", "Your account has been <b>disabled</b>");
                request.setAttribute("url-request", (String) request.getParameter("url-request"));
                request.getRequestDispatcher("client/login.jsp").forward(request, response);
            }
        }
    }
}
