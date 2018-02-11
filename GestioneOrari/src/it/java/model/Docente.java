package it.java.model;

import java.util.Set;
import java.util.HashSet;

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
		    + "attivitadidatticaDocenteViaIdentificativodocente { attivitadidatticaDocenteViaIdentificativodocente };" 
		    + "corsoDocenteViaIdentificativodocente { corsoDocenteViaIdentificativodocente };" 
		    + "disponibilitadocenteDocenteViaIdentificativodocente { disponibilitadocenteDocenteViaIdentificativodocente };" 
		    + "esameDocenteViaIdentificativodocente { esameDocenteViaIdentificativodocente };" 
		    + "lezioneDocenteViaIdentificativodocente { lezioneDocenteViaIdentificativodocente };" 
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

    @OneToMany (targetEntity=Attivitadidattica.class, fetch=FetchType.LAZY, mappedBy="identificativodocente", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Attivitadidattica> attivitadidatticaDocenteViaIdentificativodocente = new HashSet<Attivitadidattica>(); 
   
    @OneToMany (targetEntity=Corso.class, fetch=FetchType.LAZY, mappedBy="identificativodocente", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Corso> corsoDocenteViaIdentificativodocente = new HashSet<Corso>(); 

    @OneToMany (targetEntity=Disponibilitadocente.class, fetch=FetchType.LAZY, mappedBy="identificativodocente", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Disponibilitadocente> disponibilitadocenteDocenteViaIdentificativodocente = new HashSet<Disponibilitadocente>(); 

    @OneToMany (targetEntity=Esame.class, fetch=FetchType.LAZY, mappedBy="identificativodocente", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Esame> esameDocenteViaIdentificativodocente = new HashSet<Esame>(); 
   
    @OneToMany (targetEntity=Lezione.class, fetch=FetchType.LAZY, mappedBy="identificativodocente", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Lezione> lezioneDocenteViaIdentificativodocente = new HashSet<Lezione>(); 
   
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

    public Set<Attivitadidattica> getAttivitadidatticaDocenteViaIdentificativodocente() {
        if (attivitadidatticaDocenteViaIdentificativodocente == null){
            attivitadidatticaDocenteViaIdentificativodocente = new HashSet<Attivitadidattica>();
        }
        return attivitadidatticaDocenteViaIdentificativodocente;
    }

    public void setAttivitadidatticaDocenteViaIdentificativodocente (Set<Attivitadidattica> attivitadidatticaDocenteViaIdentificativodocente) {
        this.attivitadidatticaDocenteViaIdentificativodocente = attivitadidatticaDocenteViaIdentificativodocente;
    }	
    
    public void addAttivitadidatticaDocenteViaIdentificativodocente (Attivitadidattica attivitadidattica) {
    	    getAttivitadidatticaDocenteViaIdentificativodocente().add(attivitadidattica);
    }
    
    public Set<Corso> getCorsoDocenteViaIdentificativodocente() {
        if (corsoDocenteViaIdentificativodocente == null){
            corsoDocenteViaIdentificativodocente = new HashSet<Corso>();
        }
        return corsoDocenteViaIdentificativodocente;
    }

    public void setCorsoDocenteViaIdentificativodocente (Set<Corso> corsoDocenteViaIdentificativodocente) {
        this.corsoDocenteViaIdentificativodocente = corsoDocenteViaIdentificativodocente;
    }	
    
    public void addCorsoDocenteViaIdentificativodocente (Corso corso) {
    	    getCorsoDocenteViaIdentificativodocente().add(corso);
    }
    
    public Set<Disponibilitadocente> getDisponibilitadocenteDocenteViaIdentificativodocente() {
        if (disponibilitadocenteDocenteViaIdentificativodocente == null){
            disponibilitadocenteDocenteViaIdentificativodocente = new HashSet<Disponibilitadocente>();
        }
        return disponibilitadocenteDocenteViaIdentificativodocente;
    }

    public void setDisponibilitadocenteDocenteViaIdentificativodocente (Set<Disponibilitadocente> disponibilitadocenteDocenteViaIdentificativodocente) {
        this.disponibilitadocenteDocenteViaIdentificativodocente = disponibilitadocenteDocenteViaIdentificativodocente;
    }	
    
    public void addDisponibilitadocenteDocenteViaIdentificativodocente (Disponibilitadocente disponibilitadocente) {
    	    getDisponibilitadocenteDocenteViaIdentificativodocente().add(disponibilitadocente);
    }
    
    public Set<Esame> getEsameDocenteViaIdentificativodocente() {
        if (esameDocenteViaIdentificativodocente == null){
            esameDocenteViaIdentificativodocente = new HashSet<Esame>();
        }
        return esameDocenteViaIdentificativodocente;
    }

    public void setEsameDocenteViaIdentificativodocente (Set<Esame> esameDocenteViaIdentificativodocente) {
        this.esameDocenteViaIdentificativodocente = esameDocenteViaIdentificativodocente;
    }	
    
    public void addEsameDocenteViaIdentificativodocente (Esame esame) {
    	    getEsameDocenteViaIdentificativodocente().add(esame);
    }
    
    public Set<Lezione> getLezioneDocenteViaIdentificativodocente() {
        if (lezioneDocenteViaIdentificativodocente == null){
            lezioneDocenteViaIdentificativodocente = new HashSet<Lezione>();
        }
        return lezioneDocenteViaIdentificativodocente;
    }

    public void setLezioneDocenteViaIdentificativodocente (Set<Lezione> lezioneDocenteViaIdentificativodocente) {
        this.lezioneDocenteViaIdentificativodocente = lezioneDocenteViaIdentificativodocente;
    }	
    
    public void addLezioneDocenteViaIdentificativodocente (Lezione lezione) {
    	    getLezioneDocenteViaIdentificativodocente().add(lezione);
    }
    
}
