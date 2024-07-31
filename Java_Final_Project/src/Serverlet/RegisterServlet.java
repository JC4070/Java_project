package Serverlet;

import DAO.UserDAOImpl;
import Bean.Userbean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private final UserDAOImpl userService = new UserDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String userType = request.getParameter("userType");
        String status = "";

        if (password != null && password.equals(confirmPassword)) {
        	Userbean user = new Userbean(username, firstName, lastName, password, userType);

    UserDAOImpl dao = new UserDAOImpl();
      dao.registerUser(user);
    if (status.equals("User Registered Successfully!")) {
        // Registration successful, forward to login.jsp
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    } else {
        // Registration failed, forward back to register.jsp with error message
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp?message=" + status);
        rd.forward(request, response);
    }
} else {
    status = "Password not matching!";
    RequestDispatcher rd = request.getRequestDispatcher("register.jsp?message=" + status);
    rd.forward(request, response);
}
    }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}