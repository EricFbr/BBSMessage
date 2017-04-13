package com.oracleoaec.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetHandler {
	//处理结果集
	public void handleRs(ResultSet rs)
			throws SQLException;
}
