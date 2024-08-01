package bean;


public class Userbean {
	
	 private int UserId;
	    private String username;
	    private String firstName;
	    private String lastName;
	    private String userType;
	    private String password;

	    
	    public Userbean(){
	        
	    }

	    public Userbean( String username,String firstName,String lastName,String password, String userType) {
	        super();
	        this.username =username;
	        this.firstName=firstName;
	        this.lastName=lastName;
	        this.userType = userType;
	        this.password = password;

	    }

		public int getUserId() {
			return UserId;
		}

		public void setUserId(int userId) {
			UserId = userId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUserType() {
			return userType;
		}

		public void setUserType(String userType) {
			this.userType = userType;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	    
	    

}
