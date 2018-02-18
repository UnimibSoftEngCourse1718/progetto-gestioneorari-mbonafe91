package it.java.validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import org.openxava.util.*;
import org.openxava.validators.*;

import it.java.model.Docente;
import it.java.util.GetConnection;

public class DisponibilitaDocentePerEsame implements IValidator {

	Date inizioesame;
	Date fineesame;
	Docente identificativodocente;
	String identificativoesame;

	private static String RESULT_FIELD = "result";

	@Override
	public void validate(Messages errors) throws Exception {

		Boolean check = false;
		String[] query = new String[3];

		/**
		 * Query per verificare disponibilità Docente in base a alla tabella
		 * delle disponibilità
		 */
		query[0] = "select count(1) as result from  disponibilitadocente a  where  a.identificativoDocente = ? "
				+ "and (? between disponibilitaDa and disponibilitaA) "
				+ "and (? between disponibilitaDa and disponibilitaA)";

		/**
		 * Query per verificare disponibilità Docente in base alle lezioni
		 */
		query[1] = "select count(1) as result from  lezione a  " + "where  a.identificativoDocente = ?  "
				+ "and (? between iniziolezione and finelezione) "
				+ "and (? between iniziolezione and finelezione)"
				+ "or ((iniziolezione between ? and ?) "
				+ "and (finelezione between ? and ?))";
		/**
		 * Query per verificare disponibilità Docente in base agli altri esame
		 */
		query[2] = "select count(1) as result from  esame a  " + "where  a.identificativoDocente = ?  "
				+ "and (? between inizioesame and fineesame) "
				+ "and (? between inizioesame and fineesame)"
				+ "or((inizioesame between ? and ?) "
				+ "and (fineesame between ? and ?))"
				+ "and identificativoesame <> ?";

		String[] message = new String[3];

		message[0] = "Docente non disponibile, verificare date/orari di inizio e fine rispetto alle disponibilità del docente";
		message[1] = "Docente non disponibile, verificare date/orari di inizio e fine, docente impegnato già con una lezione";
		message[2] = "Docente non disponibile, verificare date/orari di inizio e fine, docente impegnato già con un esame";

		for (int i = 0; i <= query.length-1; i++) {
			Connection conn = null;
			check = false;
			try {
				conn = GetConnection.getJNDIConnection();
				PreparedStatement ps = null;

				try {
					ps = conn.prepareStatement(query[i]);
					ps.setString(1, identificativodocente.getIdentificativodocente());
					ps.setString(2, inizioesame.toString());
					ps.setString(3, fineesame.toString());
					if (i > 0) {
						ps.setString(4, inizioesame.toString());
						ps.setString(5, fineesame.toString());
						ps.setString(6, inizioesame.toString());
						ps.setString(7, fineesame.toString());
					}
					if (i > 1)
						ps.setString(8, identificativoesame);
					ResultSet rs = null;
					try {
						rs = ps.executeQuery();
						while (rs.next()) {
							Integer result = null;
							try {
								result = rs.getInt(RESULT_FIELD);
							} finally {
								if (result > 0)
									check = true;
							}
						}
					} finally {
						if (rs != null)
							rs.close();
					}
					if (check) {
						errors.add(message[i]);
					}
				} finally {
					if (ps != null)
						ps.close();
				}
			} catch (Exception e) {
				errors.add("Errore di Sistema contattare l'amministratore");
			} finally {
				if (conn != null)
					conn.close();
			}
		}
	}

	public Docente getIdentificativodocente() {
		return identificativodocente;
	}

	public void setIdentificativodocente(Docente identificativodocente) {
		this.identificativodocente = identificativodocente;
	}

	public Date getInizioesame() {
		return inizioesame;
	}

	public void setInizioesame(Date inizioesame) {
		this.inizioesame = inizioesame;
	}

	public Date getFineesame() {
		return fineesame;
	}

	public void setFineesame(Date fineesame) {
		this.fineesame = fineesame;
	}

	public String getIdentificativoesame() {
		return identificativoesame;
	}

	public void setIdentificativoesame(String identificativoesame) {
		this.identificativoesame = identificativoesame;
	}

}
