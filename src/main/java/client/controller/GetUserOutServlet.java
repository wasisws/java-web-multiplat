/*
 *     DuyDuc94
 */

package client.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * @author duy20
 */

public class GetUserOutServlet extends HttpServlet {
   
    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("user") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            session.setAttribute("user", null);
            response.sendRedirect(request.getHeader("referer"));
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);

    }
}