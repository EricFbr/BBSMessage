package com.oracleoaec.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetHandler {
	//��������
	public void handleRs(ResultSet rs)
			throws SQLException;
}
