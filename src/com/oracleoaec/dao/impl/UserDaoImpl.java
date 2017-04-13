package com.oracleoaec.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.IUserDao;
import com.oracleoaec.entity.User;
import com.oracleoaec.util.JDBCTemplate;
import com.oracleoaec.util.PreparedStatementSetter;
import com.oracleoaec.util.ResultSetHandler;

public class UserDaoImpl extends JDBCTemplate implements IUserDao {

	@Override
	public User queryUser(final String name) {
		final User user = new User();
		String sql = "SELECT * FROM T_USER WHERE name=?";
		super.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, name);//占位符替换
			}
		}, new ResultSetHandler() {
			@Override
			public void handleRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					long id = rs.getLong(1);
					String name = rs.getString(2);
					String pwd = rs.getString(3);
					user.setId(id);
					user.setName(name);
					user.setPwd(pwd);
				}
			}
		});
		return user;
	}
	@Override
	public int addUser(final User user) {
		String sql = "INSERT INTO T_USER VALUES(T_SEQ_USER.nextval,?,?)";
		int update = super.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getPwd());
			}
		});
		return update;
	}
	@Override
	public User queryUser(final User user) {
		final User u = new User();
		String sql = "SELECT * FROM T_USER WHERE name=? AND pwd=?";
		super.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getName());//占位符替换
				pstmt.setString(2, user.getPwd());//占位符替换
			}
		}, new ResultSetHandler() {
			@Override
			public void handleRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					long id = rs.getLong(1);
					String name = rs.getString(2);
					String pwd = rs.getString(3);
					u.setId(id);
					u.setName(name);
					u.setPwd(pwd);
				}
			}
		});
		return u;
	}

}
