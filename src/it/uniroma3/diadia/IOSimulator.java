package it.uniroma3.diadia;

public class IOSimulator implements IO {
	private String[] messaggiDaLeggere;
	private String[] comandiDaSvolgere;
	private int indiceMessaggio;
	private int indiceComando;
	
	public IOSimulator(String[] comandiDaSvolgere) {
		this.comandiDaSvolgere = comandiDaSvolgere;
		this.messaggiDaLeggere = new String[1000];
		this.indiceComando = 0;
		this.indiceMessaggio = 0;
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiDaLeggere[indiceMessaggio++]= messaggio;
	}

	@Override
	public String leggiRiga() {
		return this.comandiDaSvolgere[indiceComando++];
	}
	
	public String[] getMessaggi() {
		return this.messaggiDaLeggere;
	}
}
