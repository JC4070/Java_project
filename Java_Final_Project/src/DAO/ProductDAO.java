package DAO;

import java.util.List;

import bean.Productbean;

/**
 * @author Jatin
 */


public interface ProductDAO {
	
	 Productbean getProductById(int productId);
	 void updateProduct(Productbean product);
	 
}
