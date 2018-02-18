package it.java.check;

import javax.persistence.*;
import org.openxava.annotations.*;


/**
 * @author MBONAFE
 */
@Entity (name="Controlloimpegnidocente")
@Table (name="controlloimpegnidocente") 

public class ControlloImpegniDocente {

     @Id @Column(name="tipo" ,length=7)
    private String tipo; 

    @Column(name="identificativodocente",  length=36,   nullable=true,  unique=false, insertable=false, updatable=false)
    private String identificativodocente;

    @Column(name="identificativoimpegnodocente",  length=36,  nullable=false,  unique=false, insertable=false, updatable=false)
    @Required
    private String identificativoimpegnodocente;

    @Column(name="inizioimpegnodocente",    nullable=false,  unique=false, insertable=false, updatable=false)
    @Required
    @Stereotype("DATETIME")
    private java.util.Date inizioimpegnodocente;

    @Column(name="fineimpegnodocente",    nullable=false,  unique=false, insertable=false, updatable=false)
    @Required
    @Stereotype("DATETIME")
    private java.util.Date fineimpegnodocente;

    @Column(name="Messaggio",  length=52,   nullable=true,  unique=false, insertable=false, updatable=false)
    private String messaggio;

    public String getTipo() {
        return tipo;
    }
	
    public void setTipo (String tipo) {
        this.tipo =  tipo;
    }
    

    public String getIdentificativodocente() {
        return identificativodocente;
    }
	
    public void setIdentificativodocente (String identificativodocente) {
        this.identificativodocente =  identificativodocente;
    } 


    public String getMessaggio() {
        return messaggio;
    }
	
    public void setMessaggio (String messaggio) {
        this.messaggio =  messaggio;
    }

	public String getIdentificativoimpegnodocente() {
		return identificativoimpegnodocente;
	}

	public void setIdentificativoimpegnodocente(String identificativoimpegnodocente) {
		this.identificativoimpegnodocente = identificativoimpegnodocente;
	}

	public java.util.Date getInizioimpegnodocente() {
		return inizioimpegnodocente;
	}

	public void setInizioimpegnodocente(java.util.Date inizioimpegnodocente) {
		this.inizioimpegnodocente = inizioimpegnodocente;
	}

	public java.util.Date getFineimpegnodocente() {
		return fineimpegnodocente;
	}

	public void setFineimpegnodocente(java.util.Date fineimpegnodocente) {
		this.fineimpegnodocente = fineimpegnodocente;
	} 

}
