package it.java.domain;

public enum TipologiaEsame {
   ORALE("Orale"), 
   SCRITTO("Scritto"), 
   PRIMAPROVAINITINERE("Prima prova in itinere"), 
   SECONDAPROVAINITINERE("Seconda prova in itinere");
	
	private String tipologia;
	 
	TipologiaEsame(String tipologiaEsame) {
        this.tipologia = tipologiaEsame;
    }
 
    public String getTipologiaEsame() {
        return tipologia;
    }
}
