package it.java.domain;

public enum TipologiaLezione {
   LABORATORIO("Laboratorio"), 
   TEORIA("Teoria"), 
   TUTORATO("Tutorato");
	
	private String tipologia;
	 
	TipologiaLezione(String tipologiaEsame) {
        this.tipologia = tipologiaEsame;
    }
 
    public String getTipologiaEsame() {
        return tipologia;
    }
}
