package com.lab.examtwo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
public class DBConnectionManagerTwo {
		String driver = "com.mysql.cj.jdbc.Driver";

	 	static @Getter
	    @Setter
	    private Connection connection;
	    @Setter
	    private String url;
	    @Setter
	    private String username;
	    @Setter
	    private String password;

	    public Connection openConnection() throws SQLException {
			try {
				Class.forName(driver);
				return DriverManager.getConnection(url, username, password);
			}catch (ClassNotFoundException cnf) {
				cnf.printStackTrace();
			}
			return null;
		}

		// Close an existing database connection
		public void closeConnection(Connection connection) {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
}
