package it.java.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;
import org.openxava.annotations.*;

/**
 * @author MBONAFE
 */

@Entity(name = "Attivitadidattica")
@Table(name = "attivitadidattica")
@Views({ @View(members = "Generalità [nomeattivita; descrizioneattivita]; "
		+ "Dettagli [cfu,annodicorso,annoaccademico; identificativocorso]; "
		+ "lezioneAttivitadidatticaViaIdentificativoattivita;"
	+ "esameAttivitadidatticaViaIdentificativoattivita;"),
	@View(name = "reference", members = "Generalità [nomeattivita; descrizioneattivita]; "
				+ "Dettagli [cfu,annodicorso,annoaccademico; identificativocorso.nomecorso];"),
		
		@View(name = "referenceList", members = "nomeattivita; descrizioneattivita")

})

@Tab(properties = " nomeattivita, descrizioneattivita, cfu, annodicorso, annoaccademico, identificativocorso.nomecorso")

public class Attivitadidattica {

	@Hidden
	@Id
	@Column(name = "identificativoAttivita", length = 36)
	@GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String identificativoattivita;

	@Column(name = "nomeAttivita", length = 100, nullable = false, unique = false)
	@Required
	private String nomeattivita;

	@Column(name = "descrizioneAttivita", length = 2147483647, nullable = false, unique = false)
	@Required
	private String descrizioneattivita;

	@Column(name = "CFU", nullable = false, unique = false)
	@Required
	private Integer cfu;

	@Column(name = "annoDiCorso", nullable = false, unique = false)
	@Required
	private Integer annodicorso;

	@Column(name = "annoAccademico", length = 9, nullable = false, unique = false)
	@Required
	private String annoaccademico;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "identificativoCorso", referencedColumnName = "identificativoCorso", nullable = false, unique = false)
	@ReferenceView("reference")
	@DescriptionsList(descriptionProperties="nomecorso")
	private Corso identificativocorso;

	
	@CollectionView("referenceAttivita")
    @ListProperties("tipologialezione,iniziolezione,finelezione,identificativoaula.nomeaula")
	@OneToMany(targetEntity = Lezione.class, fetch = FetchType.LAZY, mappedBy = "identificativoattivita")
	private Set<Lezione> lezioneAttivitadidatticaViaIdentificativoattivita = new HashSet<Lezione>();

	@OneToMany(targetEntity = Esame.class, fetch = FetchType.LAZY, mappedBy = "identificativoattivita")
	private Set<Esame> esameAttivitadidatticaViaIdentificativoattivita = new HashSet<Esame>();


	public String getIdentificativoattivita() {
		return identificativoattivita;
	}

	public void setIdentificativoattivita(String identificativoattivita) {
		this.identificativoattivita = identificativoattivita;
	}

	public String getNomeattivita() {
		return nomeattivita;
	}

	public void setNomeattivita(String nomeattivita) {
		this.nomeattivita = nomeattivita;
	}

	public String getDescrizioneattivita() {
		return descrizioneattivita;
	}

	public void setDescrizioneattivita(String descrizioneattivita) {
		this.descrizioneattivita = descrizioneattivita;
	}

	public Integer getCfu() {
		return cfu;
	}

	public void setCfu(Integer cfu) {
		this.cfu = cfu;
	}

	public Integer getAnnodicorso() {
		return annodicorso;
	}

	public void setAnnodicorso(Integer annodicorso) {
		this.annodicorso = annodicorso;
	}

	public String getAnnoaccademico() {
		return annoaccademico;
	}

	public void setAnnoaccademico(String annoaccademico) {
		this.annoaccademico = annoaccademico;
	}

	public Corso getIdentificativocorso() {
		return identificativocorso;
	}

	public void setIdentificativocorso(Corso identificativocorso) {
		this.identificativocorso = identificativocorso;
	}

	public Set<Lezione> getLezioneAttivitadidatticaViaIdentificativoattivita() {
		if (lezioneAttivitadidatticaViaIdentificativoattivita == null) {
			lezioneAttivitadidatticaViaIdentificativoattivita = new HashSet<Lezione>();
		}
		return lezioneAttivitadidatticaViaIdentificativoattivita;
	}

	public void setLezioneAttivitadidatticaViaIdentificativoattivita(
			Set<Lezione> lezioneAttivitadidatticaViaIdentificativoattivita) {
		this.lezioneAttivitadidatticaViaIdentificativoattivita = lezioneAttivitadidatticaViaIdentificativoattivita;
	}

	public void addLezioneAttivitadidatticaViaIdentificativoattivita(Lezione lezione) {
		getLezioneAttivitadidatticaViaIdentificativoattivita().add(lezione);
	}


	public Set<Esame> getEsameAttivitadidatticaViaIdentificativoattivita() {
		if (esameAttivitadidatticaViaIdentificativoattivita == null) {
			esameAttivitadidatticaViaIdentificativoattivita = new HashSet<Esame>();
		}
		return esameAttivitadidatticaViaIdentificativoattivita;
	}

	public void setEsameAttivitadidatticaViaIdentificativoattivita(
			Set<Esame> esameAttivitadidatticaViaIdentificativoattivita) {
		this.esameAttivitadidatticaViaIdentificativoattivita = esameAttivitadidatticaViaIdentificativoattivita;
	}

	public void addEsameAttivitadidatticaViaIdentificativoattivita(Esame esame) {
		getEsameAttivitadidatticaViaIdentificativoattivita().add(esame);
	}
	
}
