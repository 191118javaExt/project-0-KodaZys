package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionFactory {
	
	private static Logger logger = Logger.getLogger(ConnectionFactory.class);
	public static Connection getConnection() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "7540";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			logger.warn("Unable to obtain connection to database", e);
		}
		return con;
	}
}
