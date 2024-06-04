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
import lib.MyValidated;
import model.Account;

/**
 * @author duy20
 */

public class AddUserServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("client/register.jsp").forward(request, response);
        } else {
            response.sendRedirect("homepage");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("password");
        boolean canRegister = true;
        AccountDAO userDAO = new AccountDAO();
        
        //Check legit of name
        if (!MyValidated.isLegitName(name)) {
            request.setAttribute("nameMessage", "Name not valid!");
            canRegister = false;
        }

        //Check exist of username
        if (userDAO.checkUsernameExist(username) == true) {
            request.setAttribute("usernameMessage", "Username has exist!");
            canRegister = false;
        }else{
            if(!MyValidated.isLegitUsername(username)){
                request.setAttribute("usernameMessage", "Username can only contain 6 to 12 alphanumeric characters");
                canRegister = false;
            }
        }
        
        //Check phone
        if (!MyValidated.isLegitPhone(phone)) {
            request.setAttribute("phoneMessage", "Invaild phone number!");
            canRegister = false;
        }
        
        //Check email
        if (!MyValidated.isLegitEmail(email)) {
            request.setAttribute("emailMessage", "Email is not valid!");
            canRegister = false;
        }
        
        //Check confirm password
        if (password.compareTo(confirmPassword) != 0) {
            request.setAttribute("comfirmPasswordMessage", "Password not match!");
            canRegister = false;
        }

        if (canRegister) {
            HttpSession session = request.getSession(true);
            Account newUser = userDAO.addUser(username, password, name, phone, email);
            session.setAttribute("user", newUser);
            response.sendRedirect("homepage");
            return;
        }
        
        request.getRequestDispatcher("client/register.jsp").forward(request, response);
    }
}