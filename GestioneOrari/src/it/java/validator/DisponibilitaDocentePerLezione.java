package it.java.validator;

import java.util.Date;
import org.openxava.util.*;
import org.openxava.validators.*;

import it.java.model.Docente;

public class DisponibilitaDocentePerLezione implements IValidator {

	Date iniziolezione;
	Date finelezione;
	Docente identificativodocente;
	String identificativolezione;

	@Override
	public void validate(Messages errors) throws Exception {

		String[] query = new String[3];

		/**
		 * Query per verificare disponibilità Docente in base a alla tabella
		 * delle disponibilità
		 */
		query[0] = "select count(1) as result from  disponibilitadocente a  where  a.identificativoDocente = ? "
				+ "and (? between disponibilitaDa and disponibilitaA) "
				+ "and (? between disponibilitaDa and disponibilitaA)";

		/**
		 * Query per verificare disponibilità Docente in base agli esami
		 */
		query[1] = "select count(1) as result from  esame a  " + "where  a.identificativoDocente = ?  "
				+ "and (? between inizioesame and fineesame) " + "and (? between inizioesame and fineesame)"
				+ "or ((inizioesame between ? and ?) " + "and (fineesame between ? and ?))";
		/**
		 * Query per verificare disponibilità Docente in base alle altre lezioni
		 */
		query[2] = "select count(1) as result from  lezione a  " + "where  a.identificativoDocente = ?  "
				+ "and (? between iniziolezione and finelezione) " + "and (? between iniziolezione and finelezione)"
				+ "or((iniziolezione between ? and ?) " + "and (finelezione between ? and ?))"
				+ "and identificativolezione <> ?";

		String[] message = new String[4];

		message[0] = "Docente non disponibile, verificare date/orari di inizio e fine rispetto alle disponibilità del docente";
		message[1] = "Docente non disponibile, verificare date/orari di inizio e fine, docente impegnato già con un esame";
		message[2] = "Docente non disponibile, verificare date/orari di inizio e fine, docente impegnato già con una lezione";
		message[3] = "Errore di Sistema contattare l'amministratore";

		Boolean[] controlli = EseguiControlli.run(query, identificativodocente, iniziolezione, finelezione, identificativolezione); 

		for(int i=0; i<controlli.length;i++)
			if(controlli[i] != null && controlli[i])
				errors.add(message[i]);
		
	}

	public Docente getIdentificativodocente() {
		return identificativodocente;
	}

	public void setIdentificativodocente(Docente identificativodocente) {
		this.identificativodocente = identificativodocente;
	}

	public Date getIniziolezione() {
		return iniziolezione;
	}

	public void setIniziolezione(Date iniziolezione) {
		this.iniziolezione = iniziolezione;
	}

	public Date getFinelezione() {
		return finelezione;
	}

	public void setFinelezione(Date finelezione) {
		this.finelezione = finelezione;
	}

	public String getIdentificativolezione() {
		return identificativolezione;
	}

	public void setIdentificativolezione(String identificativolezione) {
		this.identificativolezione = identificativolezione;
	}

}
