package Serverlet;

import DAO.UserDAOImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    private final UserDAOImpl userService = new UserDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String validationStatus = userService.isValidCredential(username, password);

        if ("valid".equals(validationStatus)) {
            String userType = userService.getUserType(username);

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            switch (userType) {
                case "Retailer":
                    response.sendRedirect("retailer.jsp");
                    break;
                case "Consumer":
                    response.sendRedirect("consumer.jsp");
                    break;
                case "Charitable Consumer":
                    response.sendRedirect("charitable.jsp");
                    break;
                default:
                    response.sendRedirect("loginFailed.jsp");
                    break;
            }
        } else {
            request.setAttribute("errorMessage", "Invalid Username or Password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginFailed.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}
