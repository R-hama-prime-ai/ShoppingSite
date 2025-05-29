package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.Users;



public class ShoppingSiteDao extends Dao {
	public List<Users> getAllUsers() throws Exception {
		List<Users> users = new ArrayList<>();
		Connection con = getConnection();
		String sql = "SELECT * FROM users";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			String member_id = rs.getString("member_id");
			String password = rs.getString("password");
			String last_name = rs.getString("last_name");
			String first_name = rs.getString("first_name");
			String address = rs.getString("address");
			String mail_address = rs.getString("mail_address");
			Users user = new Users(member_id, password, last_name, first_name, address, mail_address);
			users.add(user);
		}

		st.close();
		con.close();
		return users;
	}
	
	
	public String getInfo(String member_id) throws Exception {
		String fullName = null;
		Connection con = getConnection();
		String sql = "SELECT LAST_NAME, FIRST_NAME FROM users WHERE MEMBER_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, member_id);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			String last_name = rs.getString("LAST_NAME");
			String first_name = rs.getString("FIRST_NAME");
			fullName = last_name + first_name;
		}
		
		st.close();
		con.close();
		return fullName;
	}
	
	
	
	
	//Userを新規登録するメソッド
		public void addUser(String member_id, String password, String last_name, String first_name, String address, String mail_address) throws Exception {
			Connection con = getConnection();
			String sql = "INSERT INTO users (member_id, password, last_name, first_name, address, mail_address) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, member_id);
			st.setString(2, password);
			st.setString(3, last_name);
			st.setString(4, first_name);
			st.setString(5, address);
			st.setString(6, mail_address);
			st.executeUpdate();

			st.close();
			con.close();

		}
	

}
