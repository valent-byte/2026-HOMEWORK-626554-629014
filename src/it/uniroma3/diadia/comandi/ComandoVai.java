package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
* ComandoVai: Comando per spostarti tra le stanze
* (funziona solo se è una direzione specifica e una stanza adiacente a quella corrente)
* @author 626554-629014
* @version base
* @see Comando, Stanza
*/


public class ComandoVai implements Comando {
	private String direzione;
	private IO io;

	public ComandoVai() {
		
	}
	@Override
	public void setParametro(String parametro)
	{
		this.direzione = parametro;
	}
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione == null)
		{
			io.mostraMessaggio("Dove vuoi andare? Devi specificare la direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza == null)
		{
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().decrementaCfu();

	}
	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	public String getNome() {
		return "vai";
	}
}
