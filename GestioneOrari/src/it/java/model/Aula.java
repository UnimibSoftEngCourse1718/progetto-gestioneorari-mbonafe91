package it.java.model;


import java.util.Collection;
import javax.persistence.*;
import org.openxava.annotations.*;


/**
 *@author MBONAFE
 */
@Entity (name="Aula")
@Table (name="aula") 

@Views({
	@View(
		members=
        "" 	
        + "Generalità [identificativoaula;"
        + "nomeaula  ; "
        + "indirizzoaula , "
        + "edificioaula  ]; "
	    + "esameAulaViaIdentificativoaula;" 
	    + "lezioneAulaViaIdentificativoaula;" 
	),
    @View(name="reference", 
    members="" 	
            + "Generalità [identificativoaula;"
            + "nomeaula  ; "
            + "indirizzoaula , "
            + "edificioaula  ]; "
    )
})

@Tab(
properties=
     " nomeaula "
    +",  indirizzoaula "
    +",  edificioaula "
)

public class Aula {

    @ReadOnly @Id @Column(name="identificativoAula" )
    @GeneratedValue(generator = "system-uuid")
    @org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String identificativoaula; 

    @Column(name="nomeAula",  length=100,  nullable=false,  unique=false)
    @Required
    private String nomeaula;

    @Column(name="indirizzoAula",  length=200,  nullable=false,  unique=false)
    @Required
    private String indirizzoaula;

    @Column(name="edificioAula",  length=100,  nullable=false,  unique=false)
    @Required
    private String edificioaula;

    @CollectionView("referenceAula")
    @ListProperties("inizioesame,  fineesame,  tipologiaesame, identificativoattivita.nomeattivita, identificativoesame")
    @OneToMany (targetEntity=Esame.class, fetch=FetchType.LAZY, mappedBy="identificativoaula")
	private Collection<Esame> esameAulaViaIdentificativoaula;


	@CollectionView("referenceAula")
    @ListProperties("tipologialezione,iniziolezione,finelezione,identificativoattivita.nomeattivita,identificativolezione")
    @OneToMany (targetEntity=Lezione.class, fetch=FetchType.LAZY, mappedBy="identificativoaula")
    private Collection <Lezione> lezioneAulaViaIdentificativoaula; 

    public String getIdentificativoaula() {
        return identificativoaula;
    }
	
    public void setIdentificativoaula (String identificativoaula) {
        this.identificativoaula =  identificativoaula;
    }
    
    public String getNomeaula() {
        return nomeaula;
    }
	
    public void setNomeaula (String nomeaula) {
        this.nomeaula =  nomeaula;
    } 

    public String getIndirizzoaula() {
        return indirizzoaula;
    }
	
    public void setIndirizzoaula (String indirizzoaula) {
        this.indirizzoaula =  indirizzoaula;
    } 

    public String getEdificioaula() {
        return edificioaula;
    }
	
    public void setEdificioaula (String edificioaula) {
        this.edificioaula =  edificioaula;
    } 

	public Collection<Esame> getEsameAulaViaIdentificativoaula() {
		return esameAulaViaIdentificativoaula;
	}

	public void setEsameAulaViaIdentificativoaula(Collection<Esame> esameAulaViaIdentificativoaula) {
		this.esameAulaViaIdentificativoaula = esameAulaViaIdentificativoaula;
	}
    
    
    public Collection<Lezione> getLezioneAulaViaIdentificativoaula() {
        return lezioneAulaViaIdentificativoaula;
    }

    public void setLezioneAulaViaIdentificativoaula (Collection<Lezione> lezioneAulaViaIdentificativoaula) {
        this.lezioneAulaViaIdentificativoaula = lezioneAulaViaIdentificativoaula;
    }	
    
}
