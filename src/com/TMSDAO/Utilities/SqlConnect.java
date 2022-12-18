package com.TMSDAO.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnect {
	public static Connection provideConnection() {
		Connection connect = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/TMS_DATABASE";
		try {
			connect = DriverManager.getConnection(url, "root", "Sagar@109");
		} catch (SQLException e) {

			e.getMessage();
		}

		return connect;

	}

}
