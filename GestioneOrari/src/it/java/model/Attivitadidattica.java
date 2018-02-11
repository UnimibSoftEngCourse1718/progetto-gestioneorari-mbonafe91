package it.java.model;

import java.util.Collection;

import javax.persistence.*;
import org.openxava.annotations.*;

/**
 * @author MBONAFE
 */

@Entity(name = "Attivitadidattica")
@Table(name = "attivitadidattica")
@Views({ @View(members = "Generalità [nomeattivita; descrizioneattivita]; "
		+ "Dettagli [cfu,annodicorso,annoaccademico; identificativocorso,identificativodocente ]; "
		+ "lezioneAttivitadidatticaViaIdentificativoattivita;" + "esameAttivitadidatticaViaIdentificativoattivita;"),
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
	@DescriptionsList(descriptionProperties = "nomecorso")
	private Corso identificativocorso;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "identificativoDocente", referencedColumnName = "identificativoDocente", nullable = false, unique = false)
	@ReferenceView("reference")
	@DescriptionsList(descriptionProperties = "denominazione")
	private Docente identificativodocente;

	@CollectionView("referenceAttivita")
	@ListProperties("tipologialezione,iniziolezione,finelezione,identificativoaula.nomeaula, identificativolezione")
	@OneToMany(targetEntity = Lezione.class, fetch = FetchType.LAZY, mappedBy = "identificativoattivita")
	private Collection<Lezione> lezioneAttivitadidatticaViaIdentificativoattivita;

	@CollectionView("referenceAttivita")
	@ListProperties("inizioesame,  fineesame,  tipologiaesame, identificativoaula.nomeaula, identificativoesame")
	@OneToMany(targetEntity = Esame.class, fetch = FetchType.LAZY, mappedBy = "identificativoattivita")
	private Collection<Esame> esameAttivitadidatticaViaIdentificativoattivita;

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

	public Docente getIdentificativodocente() {
		return identificativodocente;
	}

	public void setIdentificativodocente(Docente identificativodocente) {
		this.identificativodocente = identificativodocente;
	}

	public Collection<Lezione> getLezioneAttivitadidatticaViaIdentificativoattivita() {
		return lezioneAttivitadidatticaViaIdentificativoattivita;
	}

	public void setLezioneAttivitadidatticaViaIdentificativoattivita(
			Collection<Lezione> lezioneAttivitadidatticaViaIdentificativoattivita) {
		this.lezioneAttivitadidatticaViaIdentificativoattivita = lezioneAttivitadidatticaViaIdentificativoattivita;
	}

	public Collection<Esame> getEsameAttivitadidatticaViaIdentificativoattivita() {
		return esameAttivitadidatticaViaIdentificativoattivita;
	}

	public void setEsameAttivitadidatticaViaIdentificativoattivita(
			Collection<Esame> esameAttivitadidatticaViaIdentificativoattivita) {
		this.esameAttivitadidatticaViaIdentificativoattivita = esameAttivitadidatticaViaIdentificativoattivita;
	}

}
