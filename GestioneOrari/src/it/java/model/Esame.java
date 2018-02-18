package it.java.model;

import java.util.Collection;

import javax.persistence.*;
import org.openxava.annotations.*;

import it.java.domain.TipologiaEsame;
import it.java.validator.DisponibilitaDocentePerEsame;

/**
 * @author MBONAFE
 */
@Entity(name = "Esame")
@Table(name = "esame")

@Views({
	@View(members = "Esame{identificativoesame; Generalità [inizioesame  ,  fineesame  ;  tipologiaesame ;identificativoaula  , identificativoattivita;identificativodocente  ]; iscrizioneEsameViaIdentificativoesame } "),
	@View(name = "referenceAula", members = "Esame{Generalità [inizioesame  ,  fineesame  ;  tipologiaesame ; identificativoattivita; identificativodocente  ]} "),
	@View(name = "referenceAttivita", members = "Esame{Generalità [inizioesame  ,  fineesame  ;  tipologiaesame ;identificativoaula;identificativodocente  ]} "),
	@View(name = "referenceDocente", members = "Esame{Generalità [inizioesame  ,  fineesame  ;  tipologiaesame ;identificativoattivita, identificativoaula;  ]} "),
	@View(name = "referenceIscrizione", members = "Esame{Generalità [inizioesame  ,  fineesame  ;  tipologiaesame ;identificativoattivita, identificativoaula;identificativodocente]} ")
})
@Tab(properties = " inizioesame " + ",  fineesame " + ",  tipologiaesame, "
		+ "identificativoaula.nomeaula,identificativoaula.edificioaula,identificativoattivita.nomeattivita "

)

@EntityValidator( 
		value = DisponibilitaDocentePerEsame.class,
		properties = { 
				@PropertyValue(name = "inizioesame"),
				@PropertyValue(name = "fineesame"), 
				@PropertyValue(name = "identificativodocente"),
				@PropertyValue(name = "identificativoesame" )})
public class Esame {

	@ReadOnly
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

	@ManyToOne(fetch = FetchType.LAZY, optional = false) 
	@JoinColumn(name = "identificativoAula", referencedColumnName = "identificativoAula", nullable = false, unique = false)
	@ReferenceView("reference")
	@DescriptionsList(descriptionProperties = "nomeaula,edificioaula")
	private Aula identificativoaula;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "identificativoAttivita", referencedColumnName = "identificativoAttivita", nullable = false, unique = false)
	@ReferenceView("referenceList")
	@DescriptionsList(descriptionProperties = "nomeattivita")
	private Attivitadidattica identificativoattivita;
	
	@ManyToOne (fetch=FetchType.LAZY ,optional=false)
    @JoinColumn(name="identificativoDocente", referencedColumnName = "identificativoDocente", nullable=false, unique=true  )
    @ReferenceView ("reference") 
    private Docente identificativodocente;


	@ListProperties("identificativostudente.matricola,identificativostudente.cognome,identificativostudente.nome,identificativostudente.identificativostudente")
	@OneToMany (targetEntity=Iscrizione.class, fetch=FetchType.LAZY, mappedBy="identificativoesame")
	private Collection <Iscrizione> iscrizioneEsameViaIdentificativoesame; 
	   
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

	public Aula getIdentificativoaula() { 
		return identificativoaula;
	}

	public void setIdentificativoaula(Aula identificativoaula) {
		this.identificativoaula = identificativoaula;
	}

	public Attivitadidattica getIdentificativoattivita() { 
		return identificativoattivita;
	}

	public void setIdentificativoattivita(Attivitadidattica identificativoattivita) {
		this.identificativoattivita = identificativoattivita;
	}

    public Docente getIdentificativodocente () {
    	return identificativodocente;
    }
	
    public void setIdentificativodocente (Docente identificativodocente) {
    	this.identificativodocente = identificativodocente;
    }

	
    public Collection<Iscrizione> getIscrizioneEsameViaIdentificativoesame() {
        return iscrizioneEsameViaIdentificativoesame;
    }

    public void setIscrizioneEsameViaIdentificativoesame (Collection<Iscrizione> iscrizioneEsameViaIdentificativoesame) {
        this.iscrizioneEsameViaIdentificativoesame = iscrizioneEsameViaIdentificativoesame;
    }

}
