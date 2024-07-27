package DAO;

import java.sql.*;
import bean.Productbean;

/**
 * @author Jatin
 */
public class ProductDAOImpl implements ProductDAO {
	private Connection connection;
	
	public Productbean getProductById(int productId) {
		 Productbean product = null;
	        String sql = "SELECT * FROM Product WHERE product_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, productId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                product = mapResultSetToProduct(rs);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return product;
	    }

	
	
	public List<Productbean> getProductsByUserId(int userId) {
        List<Productbean> productList = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Productbean product = mapResultSetToProduct(rs);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
	
	
	private Productbean mapResultSetToProduct(ResultSet rs) throws SQLException {
		return null;
	}
	
	
}
