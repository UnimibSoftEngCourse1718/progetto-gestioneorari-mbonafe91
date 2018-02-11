package it.java.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;
import org.openxava.annotations.*;

/**
 * @author MBONAFE
 */

@Entity(name = "Corso")
@Table(name = "corso")
@Views({
@View(members = "Generalit‡[nomecorso; descrizionecorso;]; Dettagli[facolta; durata, cfu, tipologia; attivo;identificativodocente]; Attivit‡Didattiche[attivitadidatticaCorsoViaIdentificativocorso]"),
@View(name="reference" ,members = "Generalit‡[nomecorso; descrizionecorso;]; Dettagli[facolta; durata, cfu, tipologia; attivo;identificativodocente]")
})
@Tab(properties = " nomecorso, descrizionecorso, facolta, durata, attivo, cfu, tipologia ")

public class Corso {

	@Hidden
	@Id
	@Column(name = "identificativoCorso")
	@GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String identificativocorso;

	@Column(name = "nomeCorso", length = 100, nullable = false, unique = false)
	@Required
	private String nomecorso;

	@Stereotype("MEMO")
	@Column(name = "descrizioneCorso", length = 500, nullable = false, unique = false)
	@Required
	private String descrizionecorso;
	
	@Column(name = "facolta", length = 100, nullable = false, unique = false)
	@Required
	private String facolta;
	
	@Column(name = "durata", nullable = false, unique = false)
	@Required
	private Integer durata;
	
	@Column(name = "attivo", nullable = false, unique = false)
	@Required
	private Short attivo;
	
	@Column(name = "CFU", nullable = false, unique = false)
	@Required
	private Integer cfu;
	
	@Column(name = "tipologia", length = 100, nullable = false, unique = false)
	@Required
	private String tipologia;
	
    @ManyToOne (fetch=FetchType.LAZY ,optional=false)
    @JoinColumn(name="identificativoDocente", referencedColumnName = "identificativoDocente", nullable=false,  unique=false  )
    @ReferenceView ("reference") 
    private Docente identificativodocente;
	
	@OneToMany(targetEntity = Attivitadidattica.class, fetch = FetchType.LAZY, mappedBy = "identificativocorso", cascade = CascadeType.REMOVE)
	private Set<Attivitadidattica> attivitadidatticaCorsoViaIdentificativocorso = new HashSet<Attivitadidattica>();

	public String getIdentificativocorso() {
		return identificativocorso;
	}

	public void setIdentificativocorso(String identificativocorso) {
		this.identificativocorso = identificativocorso;
	}

	public String getNomecorso() {
		return nomecorso;
	}

	public void setNomecorso(String nomecorso) {
		this.nomecorso = nomecorso;
	}

	public String getDescrizionecorso() {
		return descrizionecorso;
	}

	public void setDescrizionecorso(String descrizionecorso) {
		this.descrizionecorso = descrizionecorso;
	}
	
	public String getFacolta() {
		return facolta;
	}

	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}
	
	public Integer getDurata() {
		return durata;
	}

	public void setDurata(Integer durata) {
		this.durata = durata;
	}
	
	public Short getAttivo() {
		return attivo;
	}

	public void setAttivo(Short attivo) {
		this.attivo = attivo;
	}
	
	public Integer getCfu() {
		return cfu;
	}

	public void setCfu(Integer cfu) {
		this.cfu = cfu;
	}
	
	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
    public Docente getIdentificativodocente () {  //
    	return identificativodocente;
    }
	
    public void setIdentificativodocente (Docente identificativodocente) {
    	this.identificativodocente = identificativodocente;//this.identificativodocente = docente;
    }

	
	public Set<Attivitadidattica> getAttivitadidatticaCorsoViaIdentificativocorso() {
		if (attivitadidatticaCorsoViaIdentificativocorso == null) {
			attivitadidatticaCorsoViaIdentificativocorso = new HashSet<Attivitadidattica>();
		}
		return attivitadidatticaCorsoViaIdentificativocorso;
	}

	public void setAttivitadidatticaCorsoViaIdentificativocorso(
			Set<Attivitadidattica> attivitadidatticaCorsoViaIdentificativocorso) {
		this.attivitadidatticaCorsoViaIdentificativocorso = attivitadidatticaCorsoViaIdentificativocorso;
	}

	public void addAttivitadidatticaCorsoViaIdentificativocorso(Attivitadidattica attivitadidattica) {
		getAttivitadidatticaCorsoViaIdentificativocorso().add(attivitadidattica);
	}

	
}
