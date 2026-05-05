package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
* ComandoNonValido: se hai digitato il comando sbagliato, il gioco ti avvisa
*
* @author 626554-629014
* @version base
* @see Comando
*/

public class ComandoNonValido implements Comando{
	private IO io;
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comando non valido, riprova");
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
		return null;   
	}
}
