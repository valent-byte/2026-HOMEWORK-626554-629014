package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
* ComandoFine: finisce la partita quando lo esegui
*
* @author 626554-629014
* @version base
* @see Comando
*/

public class ComandoFine implements Comando{
	private IO io;
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
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
	    return "fine";
	}
}
