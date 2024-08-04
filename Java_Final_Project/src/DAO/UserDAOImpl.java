package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.DBUtil;
import Bean.Userbean;
import DAO.UserDAO;

/**
 * @authoe jatin
 */
public class UserDAOImpl {

	@Override
	public String registerUser(Userbean user) {

		String status = "User Registration Failed!";

		boolean isRegtd = isRegistered(user.getUsername());

		if (isRegtd) {
			status = "Username Already Registered!";
			return status;
		}
		Connection conn = DBUtil.provideConnection();
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

		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(ps);

		return status;
	}
}
