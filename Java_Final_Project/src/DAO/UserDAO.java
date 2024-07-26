package DAO;

/**
 *@author Jatin
 */
public interface UserDAO {

	public boolean isRegistered(String UserName);
	 public String isValidCredential(String UserName, String password);
	 public String getName(String UserName);
}
