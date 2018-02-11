package it.java.model;

import javax.persistence.*;
import org.openxava.annotations.*;


/**
 * @author MBONAFE
 */

@Entity (name="Disponibilitadocente")
@Table (name="disponibilitadocente") 
//@View(
//		members=
//        "" 	
//        + "identificativodisponibilita  ; "
//        + "disponibilitada  ; "
//        + "disponibilitaa  ; "
//        + "tipo  ; "
//        + "identificativodocente  ; "
//		)
//
//@Tab(
//properties=
//     " identificativodisponibilita "
//    +",  disponibilitada "
//    +",  disponibilitaa "
//    +",  tipo "
//)

@Embeddable
public class Disponibilitadocente {

	
	@ReadOnly
	@Id
	@Column(name="identificativoDisponibilita" ,length=36)
	@GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String identificativodisponibilita; 

    @Column(name="disponibilitaDa",    nullable=false,  unique=false)
    @Required
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date disponibilitada;

    @Column(name="disponibilitaA",    nullable=false,  unique=false)
    @Required
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date disponibilitaa;

    @Column(name="tipo",  length=45,  nullable=false,  unique=false)
    @Required
    private String tipo;

    @ManyToOne (fetch=FetchType.LAZY ,optional=false) //remove optional=false to aggragate but leads to a side effect when going directly to the entity: required check is not performed=> if no set DB check constraint is raised...
    @JoinColumn(name="identificativoDocente", referencedColumnName = "identificativoDocente", nullable=false,  unique=false  )
    @ReferenceView ("reference") 
    private Docente identificativodocente;
    


    public String getIdentificativodisponibilita() {
        return identificativodisponibilita;
    }
	
    public void setIdentificativodisponibilita (String identificativodisponibilita) {
        this.identificativodisponibilita =  identificativodisponibilita;
    }
    


    public java.util.Date getDisponibilitada() {
        return disponibilitada;
    }
	
    public void setDisponibilitada (java.util.Date disponibilitada) {
        this.disponibilitada =  disponibilitada;
    } 

    public java.util.Date getDisponibilitaa() {
        return disponibilitaa;
    }
	
    public void setDisponibilitaa (java.util.Date disponibilitaa) {
        this.disponibilitaa =  disponibilitaa;
    } 

    public String getTipo() {
        return tipo;
    }
	
    public void setTipo (String tipo) {
        this.tipo =  tipo;
    } 


    public Docente getIdentificativodocente () {
    	return identificativodocente;
    }
	
    public void setIdentificativodocente (Docente identificativodocente) {
    	this.identificativodocente = identificativodocente;
    }

}
