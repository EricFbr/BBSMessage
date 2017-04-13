package com.oracleoaec.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//释放资源 ResultSet,Statement,Connection
public class DBUtils {
	
	public static void close(ResultSet rs,
			Statement stmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt,
			Connection conn){
		//调用上面的关闭方法,没有的传入null即可
		//减少代码冗余度
		close(null,stmt,conn);
	}	
	
	public static void close(
			Connection conn){
		//调用上面的关闭方法,没有的传入null即可
		//减少代码冗余度
		close(null,null,conn);
	}
	
	public static void close(
			Statement stmt){
		//调用上面的关闭方法,没有的传入null即可
		//减少代码冗余度
		close(null,stmt,null);
	}
}







