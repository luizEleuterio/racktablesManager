package br.jus.trtsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public Connection getConnection() {
	    try {
	        return DriverManager.getConnection("jdbc:mysql://10.2.36.170/racktables_db","root","pl89e6hj3");
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	
}
