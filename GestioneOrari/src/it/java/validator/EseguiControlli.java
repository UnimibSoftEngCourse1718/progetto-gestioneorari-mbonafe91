package it.java.validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import it.java.model.Docente;
import it.java.util.GetConnection;

public class EseguiControlli {

	private EseguiControlli(){
		
	}
	
	public static Boolean[] run(String[] query, Docente identificativodocente, Date inizio, Date fine,
			String identificativo) throws SQLException {

		Boolean[] controlli = new Boolean[4];
		for (int i = 0; i <= query.length - 1; i++) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Integer result = null;

			try {
				conn = GetConnection.getJNDIConnection();
				try {
					ps = conn.prepareStatement(query[i]);
					ps.setString(1, identificativodocente.getIdentificativodocente());
					ps.setString(2, inizio.toString());
					ps.setString(3, fine.toString());
					switch (i) {
					case 2:
						ps.setString(8, identificativo);
						continue;
					case 1:
						ps.setString(4, inizio.toString());
						ps.setString(5, fine.toString());
						ps.setString(6, inizio.toString());
						ps.setString(7, fine.toString());
						break;
					case 0:
						break;
					default:
						controlli[3] = true;
						break;
					}
					rs = ps.executeQuery();
					rs.next();
					result = rs.getInt("result");
					if (result != null && result > 0)
						controlli[i] = true;
				} catch (Exception e) {
					controlli[3] = true;
				} finally {
					if (rs != null)
						rs.close();

				}
			} catch (Exception e) {
				controlli[3] = true;
			} finally {

				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			}
		}
		return controlli;

	}
}
