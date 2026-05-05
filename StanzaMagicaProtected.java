package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String attrezzoPerSbloccare;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoPerSbloccare) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoPerSbloccare = attrezzoPerSbloccare;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(this.hasAttrezzo(attrezzoPerSbloccare)) {
			return super.getStanzaAdiacente(dir);
		}
		return this;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoPerSbloccare)) {
			return super.getDescrizione();
		}
		
		String blocco = "Stanza bloccata nella direzione: " + direzioneBloccata + "\nTi serve l'attrezzo: " + attrezzoPerSbloccare + " per passare.\n";
		return blocco + super.getDescrizione();
	}
}