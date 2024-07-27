package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
		Productbean product = new Productbean();
		    product.setUserId(rs.getInt("user_id"));
		    product.setProductName(rs.getString("product_name"));
		    product.setProductId(rs.getInt("product_id"));
		    product.setProductName(rs.getString("product_name"));
	        product.setCategory(rs.getString("category"));
	        product.setDescription(rs.getString("description"));
	        product.setSellerPrice(rs.getBigDecimal("seller_price"));   
	        product.setImageUrl(rs.getString("image_url"));
	        product.setFoodCondition(rs.getString("Food_condition"));
	        product.setAddedDate(rs.getDate("added_date").toLocalDate());
		return product;
		
	}
	
	
	
	 public List<Productbean> getAllsurplusProducts(){
         List<Productbean> productsurplusList = new ArrayList<>();
         String sql = "SELECT * FROM Product WHERE seller_price = 0";
         try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Productbean product = mapResultSetToProduct(rs);
                productsurplusList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productsurplusList;
     }
	 
	 
	 public List<Productbean> getAllProducts() {
	        List<Productbean> productList = new ArrayList<>();
	        String sql = "SELECT * FROM Product WHERE seller_price != 0";
	        try (Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                Productbean product = mapResultSetToProduct(rs);
	                productList.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return productList;
	    }
	 
	 public void deleteProduct(int productId) {
	        String sql = "DELETE FROM Product WHERE product_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, productId);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	 
	 public void addProduct(Productbean product) {
	        String sql = "INSERT INTO Product (product_name, category, description, seller_price, added_date, Food_condition, user_id, image_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, product.getProductName());
	            stmt.setString(2, product.getCategory());
	            stmt.setString(3, product.getDescription());
	            stmt.setBigDecimal(4, product.getSellerPrice());
	            stmt.setDate(5, Date.valueOf(product.getAddedDate()));
	            stmt.setString(6, product.getFoodCondition());
	            stmt.setInt(7, product.getUserId());
	            stmt.setString(8, product.getImageUrl());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	 public void updateProduct(Productbean product) {
	        String sql = "UPDATE Product SET product_name = ?, category = ?, description = ?, seller_price = ?, added_date = ?, Food_condition = ?, user_id = ?, image_url = ? WHERE product_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, product.getProductName());
	            stmt.setString(2, product.getCategory());
	            stmt.setString(3, product.getDescription());
	            stmt.setBigDecimal(4, product.getSellerPrice());
	            stmt.setDate(5, Date.valueOf(product.getAddedDate()));
	            stmt.setString(6, product.getFoodCondition());
	            stmt.setInt(7, product.getUserId());
	            stmt.setString(8, product.getImageUrl());
	            stmt.setInt(9, product.getProductId());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
}
