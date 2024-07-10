package com.gn.user.service;
import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.close;
import java.sql.Connection;

import com.gn.user.dao.UserDao;
import com.gn.user.vo.User;

public class UserService {
	public int createUser(User u) {
		Connection conn = getConnection();
		int result = new UserDao().create(u,conn);
		close(conn);
		return result;
	}
	public User loginUser(String id, String pwd) {
		Connection conn = getConnection();
		User result = new UserDao().login(id,pwd,conn);
		close(conn);
		return result;
	}
}
