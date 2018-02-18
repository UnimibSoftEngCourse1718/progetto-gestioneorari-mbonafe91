package it.java.util;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public final class GetConnection {

	private GetConnection() {
		
	}
	
	public static Connection getJNDIConnection() {
		Connection result = null;
		try {
			Context initialContext = new InitialContext();
			DataSource datasource = (DataSource) initialContext.lookup("java:comp/env/jdbc/GestioneOrariDS");
			if (datasource != null) {
				result = datasource.getConnection();
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		}
		return result;
	}
	
}