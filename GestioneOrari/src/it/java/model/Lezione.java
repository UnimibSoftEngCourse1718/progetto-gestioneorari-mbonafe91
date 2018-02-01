package it.java.model;

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @import@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @import@// No ending comment snippet from this extension 
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

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
        + "identificativoaula ;] "
		),
@View(
		name="referenceAula",members=
        "" 	
        + "Generalità[tipologialezione  ; "
        + "iniziolezione, "
        + "finelezione  ; "
        + "identificativoattivita ;] "
		),
@View(
		name="referenceAttivita",members=
        "" 	
        + "Generalità[tipologialezione  ; "
        + "iniziolezione, "
        + "finelezione  ; "
        + "identificativoaula ;]  "
		)
})
@Tab(
properties=
     " tipologialezione "
    +",  iniziolezione "
    +",  finelezione "
    + ", identificativoattivita.nomeattivita "
    + ", identificativoaula.nomeaula"
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
    
    public Lezione() {
    }


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
}
