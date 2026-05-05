package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
* ComandoGuarda: ti stampa lo stato dei CFU, la stanza corrente e la descrizione di essa.
*
* @author 626554-629014
* @version base
* @see Comando
*/

public class ComandoGuarda implements Comando {
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("CFU: " + partita.getGiocatore().getCfu());
	}

	@Override
	public void setParametro(String parametro) {

	}

	@Override
	public void setIo(IO io) {
		this.io = io;
		
	}

	@Override
	public String getNome() {
	    return "guarda";
	}
}
