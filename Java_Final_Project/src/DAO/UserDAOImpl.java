package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Userbean;
import DAO.UserDAO;
import Utility.DButility;

/**
 * @authoe jatin
 */
public class UserDAOImpl {

	/**
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public String registerUser(Userbean user) {

		String status = "User Registration Failed!";

		boolean isRegtd = isRegistered(user.getUsername());

		if (isRegtd) {
			status = "Username Already Registered!";
			return status;
		}
		Connection conn = DButility.provideConnection();
		PreparedStatement ps = null;
		if (conn != null) {
			System.out.println("Connected Successfully!");
		}

		try {

			ps = conn.prepareStatement("INSERT INTO Users (username, firstName, lastName, password, userType) VALUES(?,?,?,?,?) ");

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFirstName());
                        ps.setString(3, user.getLastName());
                        ps.setString(4, user.getPassword());
			ps.setString(5, user.getUserType());

			int k = ps.executeUpdate();

			if (k > 0) {
				status = "User Registered Successfully!";
				//MailMessage.registrationSuccess(user.getUsername(), user.getUsername().split(" ")[0]);
			}

		} catch (SQLException e) {
			status = "Error: " + e.getMessage();
			e.printStackTrace();
		}

		DButility.closeConnection(ps);
		DButility.closeConnection(ps);

		return status;
	}
	
	/**
	 * 
	 * @param UserName
	 * @param password
	 * @return
	 */
	
	public String isValidCredential(String UserName, String password) {
		String status = "Login Denied! Incorrect Username or Password";

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = con.prepareStatement("select * from users where username=? and password=?");

			ps.setString(1, UserName);
			ps.setString(2, password);

			rs = ps.executeQuery();

			if (rs.next())
				status = "valid";

		} catch (SQLException e) {
			status = "Error: " + e.getMessage();
			e.printStackTrace();
		}

		DButility.closeConnection(con);
		DButility.closeConnection(ps);
		DButility.closeConnection(rs);
		return status;
	}
	
	/**
	 * 
	 * @param username
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param userType
	 * @return
	 */
	  @Override
		public String registerUser(String username,String firstName,String lastName, String password, String userType) {

			bean.Userbean user = new Userbean( username, firstName, lastName,password, userType);

			String status = registerUser(user);

			return status;
		}

	  
	  /**
	   * 
	   * @param UserName
	   * @return
	   */
	  public boolean isRegistered(String UserName) {
			boolean flag = false;

			Connection con = DButility.provideConnection();

			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = con.prepareStatement("select * from user where username=?");

				ps.setString(1, UserName);

				rs = ps.executeQuery();

				if (rs.next())
					flag = true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			DButility.closeConnection(con);
			DButility.closeConnection(ps);
			DButility.closeConnection(rs);

			return flag;
		}
	  
	  
}
