package it.java.model;

import java.util.Collection;

import javax.persistence.*;
import org.openxava.annotations.*;

/**
 * @author MBONAFE
 */

@Entity (name="Docente")
@Table (name="docente") 
@Views({
	@View(
			members=
	        "" 	
	        + "identificativodocente  ; "
	        + "denominazione  ; "
	        + "specializzazione  ; "
	        + "Dettagli{"
		    + "attivitadidatticaDocenteViaIdentificativodocente;" 
		    + "corsoDocenteViaIdentificativodocente;" 
		    + "disponibilitadocenteDocenteViaIdentificativodocente;" 
		    + "esameDocenteViaIdentificativodocente;" 
		    + "lezioneDocenteViaIdentificativodocente "
		    + "};" 
	),
	@View( name="reference",
			members=
	        "" 	
	        + "identificativodocente  ; "
	        + "denominazione  ; "
	        + "specializzazione  ; "
	)
	
})	

@Tab(
properties=
     " identificativodocente "
    +",  denominazione "
    +",  specializzazione "
)
public class Docente {

	@ReadOnly
	@Id
	@Column(name="identificativoDocente" ,length=36)
	@GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String identificativodocente; 


    @Column(name="denominazione",  length=100,  nullable=false,  unique=false)
    @Required
    private String denominazione;

    @Column(name="specializzazione",  length=100,  nullable=false,  unique=false)
    @Required
    private String specializzazione;

    @ReadOnly
    @ListProperties("nomeattivita; descrizioneattivita,cfu,annodicorso,annoaccademico, identificativocorso.nomecorso")
    @OneToMany (targetEntity=Attivitadidattica.class, fetch=FetchType.LAZY, mappedBy="identificativodocente")
    private Collection <Attivitadidattica> attivitadidatticaDocenteViaIdentificativodocente; 
   
    @ReadOnly
    @ListProperties("nomecorso, descrizionecorso, facolta, durata, cfu, tipologia, attivo")
    @OneToMany (targetEntity=Corso.class, fetch=FetchType.LAZY, mappedBy="identificativodocente")
    private Collection <Corso> corsoDocenteViaIdentificativodocente; 

    @OneToMany (targetEntity=Disponibilitadocente.class, fetch=FetchType.LAZY, mappedBy="identificativodocente")
    private Collection <Disponibilitadocente> disponibilitadocenteDocenteViaIdentificativodocente; 

    @ReadOnly
    @ListProperties("inizioesame  ,  fineesame  ,  tipologiaesame ,identificativoaula.nomeaula  , identificativoattivita.nomeattivita")
    @OneToMany (targetEntity=Esame.class, fetch=FetchType.LAZY, mappedBy="identificativodocente")
    private Collection <Esame> esameDocenteViaIdentificativodocente; 
   
    @ReadOnly
    @ListProperties("iniziolezione  ,  finelezione  ,  tipologialezione ,identificativoaula.nomeaula  , identificativoattivita.nomeattivita")
    @OneToMany (targetEntity=Lezione.class, fetch=FetchType.LAZY, mappedBy="identificativodocente")
    private Collection <Lezione> lezioneDocenteViaIdentificativodocente; 
   
    public String getIdentificativodocente() {
        return identificativodocente;
    }
	
    public void setIdentificativodocente (String identificativodocente) {
        this.identificativodocente =  identificativodocente;
    }
    
    public String getDenominazione() {
        return denominazione;
    }
	
    public void setDenominazione (String denominazione) {
        this.denominazione =  denominazione;
    } 


    public String getSpecializzazione() {
        return specializzazione;
    }
	
    public void setSpecializzazione (String specializzazione) {
        this.specializzazione =  specializzazione;
    } 

    public Collection<Attivitadidattica> getAttivitadidatticaDocenteViaIdentificativodocente() {
       return attivitadidatticaDocenteViaIdentificativodocente;
    }

    public void setAttivitadidatticaDocenteViaIdentificativodocente (Collection<Attivitadidattica> attivitadidatticaDocenteViaIdentificativodocente) {
        this.attivitadidatticaDocenteViaIdentificativodocente = attivitadidatticaDocenteViaIdentificativodocente;
    }	
    
    public Collection<Corso> getCorsoDocenteViaIdentificativodocente() {
        return corsoDocenteViaIdentificativodocente;
    }

    public void setCorsoDocenteViaIdentificativodocente (Collection<Corso> corsoDocenteViaIdentificativodocente) {
        this.corsoDocenteViaIdentificativodocente = corsoDocenteViaIdentificativodocente;
    }	
    
    public Collection<Disponibilitadocente> getDisponibilitadocenteDocenteViaIdentificativodocente() {
        return disponibilitadocenteDocenteViaIdentificativodocente;
    }

    public void setDisponibilitadocenteDocenteViaIdentificativodocente (Collection<Disponibilitadocente> disponibilitadocenteDocenteViaIdentificativodocente) {
        this.disponibilitadocenteDocenteViaIdentificativodocente = disponibilitadocenteDocenteViaIdentificativodocente;
    }	
    
    public Collection<Esame> getEsameDocenteViaIdentificativodocente() {
        return esameDocenteViaIdentificativodocente;
    }

    public void setEsameDocenteViaIdentificativodocente (Collection<Esame> esameDocenteViaIdentificativodocente) {
        this.esameDocenteViaIdentificativodocente = esameDocenteViaIdentificativodocente;
    }	
    
    public Collection<Lezione> getLezioneDocenteViaIdentificativodocente() {
        return lezioneDocenteViaIdentificativodocente;
    }

    public void setLezioneDocenteViaIdentificativodocente (Collection<Lezione> lezioneDocenteViaIdentificativodocente) {
        this.lezioneDocenteViaIdentificativodocente = lezioneDocenteViaIdentificativodocente;
    }	
    
}
