package it.java.domain;

public enum TipologiaCorso {
   LAUREA_TRIENNALE("Laurea Triennale"), 
   LAUREA_MAGRISTRALE("Laurea Magistrale"), 
   LAUREA_MAGISTRALEAACICLOUNICO("Laurea Magistrale a Ciclo Unico"), 
   MASTER_DI_PRIMO_LIVELLO("Master di Primo Livello"),
   MASTER_DI_SECONDO_LIVELLO("Master di Secondo Livello"),
   EXECUTIVE_MASTER("Execuvive Master");
	
	private String tipologia;
	 
	TipologiaCorso(String tipologiaEsame) {
        this.tipologia = tipologiaEsame;
    }
 
    public String getTipologiaEsame() {
        return tipologia;
    }
}
