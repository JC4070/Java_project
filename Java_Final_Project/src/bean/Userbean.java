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

}
