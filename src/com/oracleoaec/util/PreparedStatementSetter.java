package com.oracleoaec.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
	//给preparedStatement设置参数的值
	public void setValues(PreparedStatement pstmt) 
			throws SQLException;
}
