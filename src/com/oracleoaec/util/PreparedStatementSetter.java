package com.oracleoaec.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
	//��preparedStatement���ò�����ֵ
	public void setValues(PreparedStatement pstmt) 
			throws SQLException;
}
