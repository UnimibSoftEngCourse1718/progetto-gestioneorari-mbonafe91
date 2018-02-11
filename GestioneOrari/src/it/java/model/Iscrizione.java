package it.java.model;

import javax.persistence.*;
import org.openxava.annotations.*;


/**
 * @author MBONAFE
 */

 @Entity (name="Iscrizione")
 @Table (name="iscrizione")
//@Views({
//	@View(
//		name="base",
//		members=
//        "" 	
//        + "identificativoiscrizione  ; "
//        + "identificativostudente  ; "
//        + "identificativoesame  ; "
//		)})
//@Tab(
//properties=
//" identificativostudente.matricola, "
//+ "identificativoesame.inizioesame ,  "
//+ "identificativoesame.fineesame ,  "
//+ "identificativoesame.tipologiaesame "
//+",  identificativoesame.identificativoattivita.nomeattivita "
//)

@Embeddable
public class Iscrizione {

	@Hidden  @Id @Column(name="identificativoIscrizione" ,length=36)
     @GeneratedValue(generator = "system-uuid")
     @org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid") 
    private String identificativoiscrizione; 
     
    @ManyToOne (fetch=FetchType.LAZY ,optional=false) 
    @JoinColumn(name="identificativoEsame", referencedColumnName = "identificativoEsame", nullable=false,  unique=false  )
    private Esame identificativoesame;
    
    @ManyToOne (fetch=FetchType.LAZY ,optional=false)
    @JoinColumn(name="identificativoStudente", referencedColumnName = "identificativoStudente", nullable=false,  unique=false  )
    private Studente identificativostudente;
    
    public String getIdentificativoiscrizione() {
        return identificativoiscrizione;
    }
	
    public void setIdentificativoiscrizione (String identificativoiscrizione) {
        this.identificativoiscrizione =  identificativoiscrizione;
    }
    
    public Esame getIdentificativoesame () {
    	return identificativoesame;
    }
	
    public void setIdentificativoesame (Esame identificativoesame) {
    	this.identificativoesame = identificativoesame;
    }
    public Studente getIdentificativostudente () {
    	return identificativostudente;
    }
	
    public void setIdentificativostudente (Studente identificativostudente) {
    	this.identificativostudente = identificativostudente;
    }

}
