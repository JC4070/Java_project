package DAO;

import bean.Userbean;

/**
 *@author Jatin
 */
public interface UserDAO {

	 public String registerUser(String username,String firstName,String lastName, String password, String userType);
	 public boolean isRegistered(String UserName);
	 public String isValidCredential(String UserName, String password);
	 public String getName(String UserName);
	 public Userbean getUserDetails(String UserName, String password);
	 public String getUserType(String username);
}
