package it.java.model;

import javax.persistence.*;
import org.openxava.annotations.*;

/**
 *@author MBONAFE
 */
@Entity (name="ControlloOccupazioneAula")
@Table(name="controllooccupazioneaula")


public class ControlloOccupazioneAula {

	@ReadOnly
	@Column(name="tipo", length=50)
    private String tipo;
    
	@ReadOnly
	@Column(name="identificativoAula", length=36)    
    private String identificativoAula;

	@ReadOnly
	@Id
	@Column(name="identificativo", length=36)    
    private String identificativo;
    
    @ReadOnly
	@Stereotype("DATETIME")
    @Column(name="iniziooccupazioneaula")  
    private java.util.Date  inizioOccupazioneAula;
    
    @ReadOnly
	@Stereotype("DATETIME")
    @Column(name="fineoccupazioneaula")  
    private java.util.Date  fineOccupazioneAula;


    @Column(name="nomeAula",  length=100)
    @ReadOnly
    private String nomeaula;

    @Column(name="edificioAula",  length=100)
    @ReadOnly
    private String edificioaula;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIdentificativoAula() {
		return identificativoAula;
	}

	public void setIdentificativoAula(String identificativoAula) {
		this.identificativoAula = identificativoAula;
	}

	public String getIdentificativo() {
		return identificativo;
	}

	public void setIdentificativo(String identificativo) {
		this.identificativo = identificativo;
	}

	

	public String getNomeaula() {
		return nomeaula;
	}

	public void setNomeaula(String nomeaula) {
		this.nomeaula = nomeaula;
	}

	public String getEdificioaula() {
		return edificioaula;
	}

	public void setEdificioaula(String edificioaula) {
		this.edificioaula = edificioaula;
	}

	public java.util.Date getInizioOccupazioneAula() {
		return inizioOccupazioneAula;
	}

	public void setInizioOccupazioneAula(java.util.Date inizioOccupazioneAula) {
		this.inizioOccupazioneAula = inizioOccupazioneAula;
	}

	public java.util.Date getFineOccupazioneAula() {
		return fineOccupazioneAula;
	}

	public void setFineOccupazioneAula(java.util.Date fineOccupazioneAula) {
		this.fineOccupazioneAula = fineOccupazioneAula;
	}

}
