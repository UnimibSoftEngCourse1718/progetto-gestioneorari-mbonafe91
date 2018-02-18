package it.java.model;

import javax.persistence.*;
import org.openxava.annotations.*;

import it.java.domain.SiNo;

/**
 * @author MBONAFE
 */

@Entity(name = "Risorsa")
@Table(name = "risorsa")
@View(members = "Risorsa[tipoRisorsa ; libera ] ; descrizioneRisorsa   ; ")
@Tab(properties = " tipoRisorsa ,  descrizioneRisorsa ,  libera ")
public class Risorsa {

	@ReadOnly
	@Id
	@Column(name = "identificativoRisorsa")
	@GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String identificativoRisorsa;

	
	@Column(name = "tipoRisorsa", length = 45, nullable = false, unique = false)
	@Required
	private String tipoRisorsa;
	
	@Stereotype("MEMO")
	@Column(name = "descrizioneRisorsa", length = 500,nullable = false, unique = false)
	@Required
	private String descrizioneRisorsa;
	
	
	@Column(name = "libera", nullable = false, unique = false)
	@Required
	@Enumerated(EnumType.STRING)
	private SiNo libera;
	
	
	public String getidentificativoRisorsa() {
		return identificativoRisorsa;
	}

	public void setidentificativoRisorsa(String identificativoRisorsa) {
		this.identificativoRisorsa = identificativoRisorsa;
	}

	public String gettipoRisorsa() {
		return tipoRisorsa;
	}

	public void settipoRisorsa(String tipoRisorsa) {
		this.tipoRisorsa = tipoRisorsa;
	}
	
	public String getdescrizioneRisorsa() {
		return descrizioneRisorsa;
	}


	public void setdescrizioneRisorsa(String descrizioneRisorsa) {
		this.descrizioneRisorsa = descrizioneRisorsa;
	}
	
	public SiNo getLibera() {
		return libera;
	}

	public void setLibera(SiNo libera) {
		this.libera = libera;
	}
	
}
