package it.java.model;
import javax.persistence.*;
import org.openxava.annotations.*;

import it.java.calculator.CurrentDate;
import it.java.calculator.CurrentUser;


/**
 * @author MBONAFE
 */
@Entity (name="Pubblicazione")
@Table (name="pubblicazione") 

	@View(
		members=
        "" 	
        + "identificativopubblicazione  ; "
        + "autore  ; "
        + "titolo  ; "
        + "data  ; "
        + "corpo  ; "
		)

@Tab(
properties=
     " identificativopubblicazione "
    +",  autore "
    +",  titolo "
    +",  data "
    +",  corpo "
)

public class Pubblicazione {

	
	@ReadOnly
	@Id
	@Column(name="identificativoPubblicazione" ,length=36)
	@GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String identificativopubblicazione; 

	@DefaultValueCalculator(CurrentUser.class)
    @Column(name="Autore",  length=100,  nullable=false,  unique=false)
    @Required
    @ReadOnly
    private String autore;

    @Column(name="Titolo",  length=100,  nullable=false,  unique=false)
    @Required
    private String titolo;

    @DefaultValueCalculator(CurrentDate.class)
    @Column(name="Data",    nullable=false,  unique=false)
    @Required
    @ReadOnly
	@Stereotype("DATETIME")
    private java.util.Date data;

    @Column(name="Corpo",  length=65535,  nullable=false,  unique=false)
    @Required
    private String corpo;


    public String getIdentificativopubblicazione() {
        return identificativopubblicazione;
    }
	
    public void setIdentificativopubblicazione (String identificativopubblicazione) {
        this.identificativopubblicazione =  identificativopubblicazione;
    }

    public String getAutore() {
        return autore;
    }
	
    public void setAutore (String autore) {
        this.autore =  autore;
    } 

    public String getTitolo() {
        return titolo;
    }
	
    public void setTitolo (String titolo) {
        this.titolo =  titolo;
    } 

    public java.util.Date getData() {
    	return data;
    }
	
    public void setData (java.util.Date data) {
        this.data =  data;
    } 

    public String getCorpo() {
        return corpo;
    }
	
    public void setCorpo (String corpo) {
        this.corpo =  corpo;
    } 
}
