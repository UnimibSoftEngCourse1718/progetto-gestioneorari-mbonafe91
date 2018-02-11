package it.java.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;
import org.openxava.annotations.*;


/**
 * @author MBONAFE
 */
@Entity (name="Studente")
@Table (name="studente") 
	@View(
		members=
        "" 	
        + "Generalità{identificativostudente  ; "
        + "nome  ; "
        + "cognome  ; "
        + "matricola  ;} "
	    + "Iscrizioni{iscrizioneStudenteViaIdentificativostudente};" 
	)


@Tab(
filter=it.java.filter.StudentUserFilter.class,
properties=
     " identificativostudente "
    +",  nome "
    +",  cognome "
    +",  matricola ",
baseCondition="trim(matricola)= ?"
)


    public class Studente {

	@Hidden  @Id @Column(name="identificativoStudente" ,length=36)
    @GeneratedValue(generator = "system-uuid")
    @org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid") 
    private String identificativostudente; 

     @Column(name="nome",  length=45,  nullable=false,  unique=false)
    @Required
    private String nome;

     @Column(name="cognome",  length=45,  nullable=false,  unique=false)
    @Required
    private String cognome;

    @Column(name="matricola",  length=10,  nullable=false,  unique=false)
    @Required
    private String matricola;

    
    @RemoveAction("Collection.add")
    @ListProperties("identificativoesame.inizioesame , identificativoesame.fineesame ,  identificativoesame.tipologiaesame,identificativoesame.identificativoattivita.nomeattivita")
    @OneToMany (targetEntity=Iscrizione.class, fetch=FetchType.LAZY, mappedBy="identificativostudente")
    private Set <Iscrizione> iscrizioneStudenteViaIdentificativostudente = new HashSet<Iscrizione>(); 
   

    public String getIdentificativostudente() {
        return identificativostudente;
    }
	
    public void setIdentificativostudente (String identificativostudente) {
        this.identificativostudente =  identificativostudente;
    }
    


    public String getNome() {
        return nome;
    }
	
    public void setNome (String nome) {
        this.nome =  nome;
    } 

    public String getCognome() {
        return cognome;
    }
	
    public void setCognome (String cognome) {
        this.cognome =  cognome;
    } 

    public String getMatricola() {
        return matricola;
    }
	
    public void setMatricola (String matricola) {
        this.matricola =  matricola;
    } 

    public Set<Iscrizione> getIscrizioneStudenteViaIdentificativostudente() {
        if (iscrizioneStudenteViaIdentificativostudente == null){
            iscrizioneStudenteViaIdentificativostudente = new HashSet<Iscrizione>();
        }
        return iscrizioneStudenteViaIdentificativostudente;
    }

    public void setIscrizioneStudenteViaIdentificativostudente (Set<Iscrizione> iscrizioneStudenteViaIdentificativostudente) {
        this.iscrizioneStudenteViaIdentificativostudente = iscrizioneStudenteViaIdentificativostudente;
    }	
    
    public void addIscrizioneStudenteViaIdentificativostudente (Iscrizione iscrizione) {
    	    getIscrizioneStudenteViaIdentificativostudente().add(iscrizione);
    }
    
}
