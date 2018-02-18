package it.java.model;

import javax.persistence.*;
import org.openxava.annotations.*;


/**
 *@author MBONAFE
 */
@Entity (name="Controllooccupazioneaula")
@Table (name="controllooccupazioneaula") @Views({
	@View(
		name="base",
		members=
        "" 	
        + "tipo  ; "
        + "identificativoaula  ; "
        + "identificativo  ; "
        + "iniziooccupazioneaula  ; "
        + "fineoccupazioneaula  ; "
        + "nomeaula  ; "
        + "edificioaula  ; "
        + "messaggio  ; "
		)})

@Tabs({
@Tab(
properties=
     " tipo "
    +",  identificativoaula "
    +",  identificativo "
    +",  iniziooccupazioneaula "
    +",  fineoccupazioneaula "
    +",  nomeaula "
    +",  edificioaula "
    +",  messaggio "
)
})

public class Controllooccupazioneaula {

    @Column(name="tipo" ,length=7)
    private String tipo; 

    @Column(name="identificativoAula",  length=36,  nullable=false,  unique=false, insertable=false, updatable=false)
    @Required
    private String identificativoaula;


    @Id
    @Column(name="identificativo",  length=36,  nullable=false,  unique=false, insertable=false, updatable=false)
    @Required
    private String identificativo;

    @Column(name="iniziooccupazioneaula",    nullable=false,  unique=false, insertable=false, updatable=false)
    @Required
    @Stereotype("DATETIME")
    private java.util.Date iniziooccupazioneaula;

    @Column(name="fineoccupazioneaula",    nullable=false,  unique=false, insertable=false, updatable=false)
    @Required
    @Stereotype("DATETIME")
    private java.util.Date fineoccupazioneaula;

    @Column(name="nomeaula",  length=100,  nullable=false,  unique=false, insertable=false, updatable=false)
    @Required
    private String nomeaula;

    @Column(name="edificioaula",  length=100,  nullable=false,  unique=false, insertable=false, updatable=false)
    @Required
    private String edificioaula;

    @Column(name="Messaggio",  length=62,   nullable=true,  unique=false, insertable=false, updatable=false)
    private String messaggio;


    public String getTipo() {
        return tipo;
    }
	
    public void setTipo (String tipo) {
        this.tipo =  tipo;
    }
    
    public String getIdentificativoaula() {
        return identificativoaula;
    }
	
    public void setIdentificativoaula (String identificativoaula) {
        this.identificativoaula =  identificativoaula;
    } 

    public String getIdentificativo() {
        return identificativo;
    }
	
    public void setIdentificativo (String identificativo) {
        this.identificativo =  identificativo;
    } 

    public java.util.Date getIniziooccupazioneaula() {
        return iniziooccupazioneaula;
    }
	
    public void setIniziooccupazioneaula (java.util.Date iniziooccupazioneaula) {
        this.iniziooccupazioneaula =  iniziooccupazioneaula;
    } 

    public java.util.Date getFineoccupazioneaula() {
        return fineoccupazioneaula;
    }
	
    public void setFineoccupazioneaula (java.util.Date fineoccupazioneaula) {
        this.fineoccupazioneaula =  fineoccupazioneaula;
    } 

    public String getNomeaula() {
        return nomeaula;
    }
	
    public void setNomeaula (String nomeaula) {
        this.nomeaula =  nomeaula;
    } 

    public String getEdificioaula() {
        return edificioaula;
    }
	
    public void setEdificioaula (String edificioaula) {
        this.edificioaula =  edificioaula;
    } 

    public String getMessaggio() {
        return messaggio;
    }
	
    public void setMessaggio (String messaggio) {
        this.messaggio =  messaggio;
    } 

}
