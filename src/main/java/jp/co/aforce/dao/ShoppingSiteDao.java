package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.Users;


//全ての情報を取得する

public class ShoppingSiteDao extends Dao {
	public List<Users> getAllUsers() throws Exception {
		List<Users> users = new ArrayList<>();
		Connection con = getConnection();
		String sql = "SELECT * FROM users ";
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
	
	//重複チェック機能
	/*public boolean checkDuplication(String member_id) throws Exception{
		
		Connection con = getConnection();
		String sql = "SELECT COUNT(*) FROM users WHERE MEMBER_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, member_id);
		
		try (ResultSet rs = st.executeQuery()) {
	        if (rs.next()) {
	            return rs.getInt(1) > 0;
	        }
	        return false;
	    }
		
		
	}*/
	
	
	
	
	/**
	 * 
	 * @param member_id
	 * @return
	 * @throws Exception
	 */
	//名前を取得する
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
		public String addUser(String member_id, String password, String last_name, String first_name, String address, String mail_address) throws Exception {
			Connection con = getConnection();
			String sql = "INSERT INTO users (MEMBER_ID, PASSWORD, LAST_NAME, FIRST_NAME, ADDRESS, MAIL_ADDRESS) VALUES (?, ?, ?, ?, ?, ?)";
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
			return sql;

		}
		
		
	//アップデート処理
		public int updateUser(String member_id, String last_name, String first_name, String mail_address) throws Exception {
			Connection con = getConnection();
		    String sql = "UPDATE users SET LAST_NAME = ?, FIRST_NAME = ?, MAIL_ADDRESS = ? WHERE MEMBER_ID = ?";
		        PreparedStatement st = con.prepareStatement(sql);
		        st.setString(1, last_name);
		        st.setString(2, first_name);
		        st.setString(3, mail_address);
		        st.setString(4, member_id);
		        int updatedRows = st.executeUpdate();
		        
		        st.close();
				con.close();
				
				return updatedRows;
		    }
		
		//削除機能
		public String deleteUser(String member_id) throws Exception {
			Connection con = getConnection();
			String sql = "DELETE FROM users WHERE MEMBER_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, member_id);
			st.executeUpdate();
			
			st.close();
			con.close();
			return sql;
		}
		    
		

	

}
