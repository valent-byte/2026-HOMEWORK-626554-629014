package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	public StanzaBuia(String nome) {
		super(nome);
	}
	
	@Override
	public String getDescrizione() {
		String risposta = "Qui c'è un buio pesto";
		
		if(this.hasAttrezzo("Lanterna")) {
			return this.toString();
		}
		
		return risposta;
	}
}
