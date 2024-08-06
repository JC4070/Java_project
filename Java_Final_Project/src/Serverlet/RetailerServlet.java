package Serverlet;


	
	import java.io.IOException;
	import java.math.BigDecimal;
	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.time.LocalDate;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import Utility.DButility;
	import DAO.ProductDAO;
	import DAO.ProductDAOImpl;
	import bean.Productbean;

	@WebServlet("/RetailerServlet")
	public class RetailerServlet extends HttpServlet {
	    private ProductDAO productDAO;
	    
	    public RetailerServlet() {
	        // Initialize ProductDAOImpl here with your database connection
	        Connection connection = DButility.provideConnection(); // Get connection from DBUtil
	        this.productDAO = new ProductDAOImpl(connection);
	    }
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Retrieve form parameters
	        String productName = request.getParameter("productName");
	        String category = request.getParameter("category");
	        String description = request.getParameter("description");
	        BigDecimal sellerPrice = new BigDecimal(request.getParameter("sellerPrice"));
	        LocalDate addedDate = LocalDate.parse(request.getParameter("addedDate"));
	        String foodCondition = request.getParameter("foodCondition");
	        int userId = Integer.parseInt(request.getParameter("userId"));
	        String imageUrl = request.getParameter("imageUrl");

	        // Create Productbean object
	        Productbean product = new Productbean();
	        product.setProductName(productName);
	        product.setCategory(category);
	        product.setDescription(description);
	        product.setSellerPrice(sellerPrice);
	        product.setAddedDate(addedDate);
	        product.setFoodCondition(foodCondition);
	        product.setUserId(userId);
	        product.setImageUrl(imageUrl);

	        // Add product to the database
	        productDAO.addProduct(product);

	        // Redirect back to retailer home page or display a success message
	        response.sendRedirect(request.getContextPath() + "/AddProductMessage.jsp");
	    }
	
	}
