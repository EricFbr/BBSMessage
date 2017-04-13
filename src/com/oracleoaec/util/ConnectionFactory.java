package com.oracleoaec.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

//��װ1,2��
public class ConnectionFactory {
	private static String DRIVER;
	private static String URL;
	private static String UNAME;
	private static String UPASS;
	
	static{
		//��������getConnection()��һ��ʹ��֮ǰ��ȡ���ĸ�ֵ
		//����һ��Properties��������װ��properties�ļ��л�ȡ�ļ�ֵ��
		Properties prop = new Properties();
		try {
			//���ļ��е����ݼ��ص�prop������
			prop.load(ConnectionFactory.class.
			getResourceAsStream("jdbcinfo.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//��ȡprop�����е��ĸ�����Ӧ��ֵ
		DRIVER=prop.getProperty("driver");
		URL = prop.getProperty("url");
		UNAME = prop.getProperty("uname");
		UPASS = prop.getProperty("upass");
	}
	
	public static Connection getConnection(){
		
		Connection conn = null;	
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection
					(URL, UNAME, UPASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
