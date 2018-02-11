package it.java.model;


import javax.persistence.*;
import org.openxava.annotations.*;


/**
 *
 * @author MBONAFE
 */
@Entity (name="Lezione")
@Table (name="lezione") 

@Views({
@View(
		members=
        "" 	
        + "Generalità[tipologialezione  ; "
        + "iniziolezione, "
        + "finelezione  ; "
        + "identificativoattivita, "
        + "identificativoaula;"
        + "identificativodocente ;] "
		),
@View(
		name="referenceAula",members=
        "" 	
        + "Generalità[tipologialezione  ; "
        + "iniziolezione, "
        + "finelezione  ; "
        + "identificativoattivita; "
        + "identificativodocente;] "
		),
@View(
		name="referenceAttivita",members=
        "" 	
        + "Generalità[tipologialezione  ; "
        + "iniziolezione, "
        + "finelezione  ; "
        + "identificativoaula;"
        + "identificativodocente ;]  "
		),
@View(
		name="referenceDocente",members=
        "" 	
        + "Generalità[tipologialezione  ; "
        + "iniziolezione, "
        + "finelezione  ; "
        + "identificativoattivita, "
        + "identificativoaula;] "
		),
})
@Tab(
properties=
     " tipologialezione "
    +",  iniziolezione "
    +",  finelezione "
    + ", identificativoattivita.nomeattivita "
    + ", identificativoaula.nomeaula"
    + ", identificativodocente.cognome"
)

public class Lezione {

    @Hidden  @Id @Column(name="identificativoLezione" )
    @GeneratedValue(generator = "system-uuid")
    @org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String identificativolezione; 

    @Column(name="tipologiaLezione",  length=100,  nullable=false,  unique=false)
    @Required
    private String tipologialezione;

    @Column(name="inizioLezione",    nullable=false,  unique=false)
    @Required
	@Stereotype("DATETIME")
    private java.util.Date iniziolezione;

    @Column(name="fineLezione",    nullable=false,  unique=false)
    @Required
	@Stereotype("DATETIME")
    private java.util.Date finelezione;

    @ManyToOne (fetch=FetchType.LAZY ,optional=false)
    @JoinColumn(name="identificativoAttivita", referencedColumnName = "identificativoAttivita", nullable=false,  unique=false  )
    @NoCreate
    @NoModify
    @DescriptionsList(descriptionProperties="nomeattivita")
    private Attivitadidattica identificativoattivita;
    
    @ManyToOne (fetch=FetchType.LAZY ,optional=false)
    @JoinColumn(name="identificativoAula", referencedColumnName = "identificativoAula", nullable=false,  unique=false  )
    @NoCreate
    @NoModify
    @DescriptionsList(descriptionProperties="nomeaula, edificioaula")
    private Aula identificativoaula;
    
    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="identificativoDocente", referencedColumnName = "identificativoDocente",  nullable=true,  unique=false  )
    @ReferenceView ("reference") 
    private Docente identificativodocente;
    
    public String getIdentificativolezione() {
        return identificativolezione;
    }
	
    public void setIdentificativolezione (String identificativolezione) {
        this.identificativolezione =  identificativolezione;
    }
    
    public String getTipologialezione() {
        return tipologialezione;
    }
	
    public void setTipologialezione (String tipologialezione) {
        this.tipologialezione =  tipologialezione;
    } 

    public java.util.Date getIniziolezione() {
        return iniziolezione;
    }
	
    public void setIniziolezione (java.util.Date iniziolezione) {
        this.iniziolezione =  iniziolezione;
    } 

    public java.util.Date getFinelezione() {
        return finelezione;
    }
	
    public void setFinelezione (java.util.Date finelezione) {
        this.finelezione =  finelezione;
    } 

    public Attivitadidattica getIdentificativoattivita () {  //
    	return identificativoattivita;
    }
	
    public void setIdentificativoattivita (Attivitadidattica identificativoattivita) {
    	this.identificativoattivita = identificativoattivita;
    }
    public Aula getIdentificativoaula () { 
    	return identificativoaula;
    }
	
    public void setIdentificativoaula (Aula identificativoaula) {
    	this.identificativoaula = identificativoaula;
    }
    
    public Docente getIdentificativodocente () {  //
    	return identificativodocente;
    }
	
    public void setIdentificativodocente (Docente identificativodocente) {
    	this.identificativodocente = identificativodocente;//this.identificativodocente = docente;
    }

}
