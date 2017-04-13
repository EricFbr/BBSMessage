package com.oracleoaec.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplate {
	//通用查询方法
	public void query(String sql,
			PreparedStatementSetter setter,
			ResultSetHandler handler){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(setter!=null){
				setter.setValues(pstmt);
			}
			rs = pstmt.executeQuery();
			if(handler!=null){
				handler.handleRs(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(rs, pstmt, conn);
		}
	}
	
	//增删改通用方法
	public int update(String sql,
			PreparedStatementSetter setter){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rows = 0;		
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(setter!=null){
				setter.setValues(pstmt);
			}
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(pstmt, conn);
		}
		return rows;
	}
}







