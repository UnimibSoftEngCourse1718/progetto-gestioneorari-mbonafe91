package it.java.model;

import javax.persistence.*;
import org.openxava.annotations.*;

import it.java.domain.TipologiaEsame;

/**
 * @author MBONAFE
 */
@Entity(name = "Esame")
@Table(name = "esame")

@View(members = "Generalità [inizioesame  ,  fineesame  ;  tipologiaesame ;identificativoaula  , identificativoattivita  ];  ")
@Tab(properties = " inizioesame " + ",  fineesame " + ",  tipologiaesame, "
		+ "identificativoaula.nomeaula,identificativoaula.edificioaula,identificativoattivita.nomeattivita "

)

public class Esame {

	@Hidden
	@Id
	@Column(name = "identificativoEsame")
	@GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String identificativoesame;

	@Column(name = "inizioEsame", nullable = false, unique = false)
	@Required
	@Stereotype("DATETIME")
	private java.util.Date inizioesame;

	@Column(name = "fineEsame", nullable = false, unique = false)
	@Required
	@Stereotype("DATETIME")
	private java.util.Date fineesame;

	@Column(name = "tipologiaEsame", length = 20, nullable = false, unique = false)
	@Required
	@Enumerated(EnumType.STRING)
	private TipologiaEsame tipologiaesame;

	@ManyToOne(fetch = FetchType.LAZY, optional = false) // remove
															// optional=false to
															// aggragate but
															// leads to a side
															// effect when going
															// directly to the
															// entity: required
															// check is not
															// performed=> if no
															// set DB check
															// constraint is
															// raised...
	@JoinColumn(name = "identificativoAula", referencedColumnName = "identificativoAula", nullable = false, unique = false)
	@ReferenceView("reference")
	@DescriptionsList(descriptionProperties = "nomeaula,edificioaula")
	private Aula identificativoaula;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "identificativoAttivita", referencedColumnName = "identificativoAttivita", nullable = false, unique = false)
	@ReferenceView("referenceList")
	@DescriptionsList(descriptionProperties = "nomeattivita")
	private Attivitadidattica identificativoattivita;

	public String getIdentificativoesame() {
		return identificativoesame;
	}

	public void setIdentificativoesame(String identificativoesame) {
		this.identificativoesame = identificativoesame;
	}

	public java.util.Date getInizioesame() {
		return inizioesame;
	}

	public void setInizioesame(java.util.Date inizioesame) {
		this.inizioesame = inizioesame;
	}

	public java.util.Date getFineesame() {
		return fineesame;
	}

	public void setFineesame(java.util.Date fineesame) {
		this.fineesame = fineesame;
	}

	public TipologiaEsame getTipologiaesame() {
		return tipologiaesame;
	}

	public void setTipologiaesame(TipologiaEsame tipologiaesame) {
		this.tipologiaesame = tipologiaesame;
	}

	public Aula getIdentificativoaula() { //
		return identificativoaula;
	}

	public void setIdentificativoaula(Aula identificativoaula) {
		this.identificativoaula = identificativoaula;// this.identificativoaula
														// = aula;
	}

	public Attivitadidattica getIdentificativoattivita() { //
		return identificativoattivita;
	}

	public void setIdentificativoattivita(Attivitadidattica identificativoattivita) {
		this.identificativoattivita = identificativoattivita;// this.identificativoaula
																// = aula;
	}
}
