package com.gn.user.dao;
import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gn.user.vo.User;
public class UserDao {
	public int create(User u, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO user (user_id, user_pw, user_name) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUser_id());
			pstmt.setString(2, u.getUser_pwd());
			pstmt.setString(3, u.getUser_name());
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public User login(String id, String pwd, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User result = null;
		try {
			String sql = "SELECT user_no, user_id, user_pw, user_name FROM `user` WHERE user_id = ? AND user_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new User();
				result.setUser_no(rs.getInt("user_no"));
				result.setUser_id(rs.getString("user_id"));
				result.setUser_pwd(rs.getString("user_pw"));
				result.setUser_name(rs.getString("user_name"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
}
