package it.java.util;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

final public class GetConnection {

	public static Connection getJNDIConnection() {
		String DATASOURCE_CONTEXT = "java:comp/env/jdbc/GestioneOrariDS";

		Connection result = null;
		try {
			Context initialContext = new InitialContext();
			DataSource datasource = (DataSource) initialContext.lookup(DATASOURCE_CONTEXT);
			if (datasource != null) {
				result = datasource.getConnection();
			}
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
		}
		return result;
	}

}