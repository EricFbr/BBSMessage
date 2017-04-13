package com.oracleoaec.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//�ͷ���Դ ResultSet,Statement,Connection
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
		//��������Ĺرշ���,û�еĴ���null����
		//���ٴ��������
		close(null,stmt,conn);
	}	
	
	public static void close(
			Connection conn){
		//��������Ĺرշ���,û�еĴ���null����
		//���ٴ��������
		close(null,null,conn);
	}
	
	public static void close(
			Statement stmt){
		//��������Ĺرշ���,û�еĴ���null����
		//���ٴ��������
		close(null,stmt,null);
	}
}







