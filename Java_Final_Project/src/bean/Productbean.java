package bean;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Productbean {

	    private int productId;
	    private String productName;
	    private String category;
	    private String description;
	    private String imageUrl;
	    private BigDecimal sellerPrice;
	    private LocalDate addedDate;
	    private String foodCondition;
	    private int userId;



	    public Productbean(){
	        
	    }    
	    
	    public Productbean( String productName, String category, String description, BigDecimal sellerPrice, LocalDate addedDate, String foodCondition, int userId, String imageUrl) {
	        this.productName = productName;
	        this.category = category;
	        this.description = description;
	        this.sellerPrice = sellerPrice;
	        this.addedDate = addedDate;
	        this.foodCondition = foodCondition;
	        this.userId = userId;
	        this.imageUrl = imageUrl;
	    }

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public BigDecimal getSellerPrice() {
			return sellerPrice;
		}

		public void setSellerPrice(BigDecimal sellerPrice) {
			this.sellerPrice = sellerPrice;
		}

		public LocalDate getAddedDate() {
			return addedDate;
		}

		public void setAddedDate(LocalDate addedDate) {
			this.addedDate = addedDate;
		}

		public String getFoodCondition() {
			return foodCondition;
		}

		public void setFoodCondition(String foodCondition) {
			this.foodCondition = foodCondition;
		}
		
		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
	    
	    

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}



}
