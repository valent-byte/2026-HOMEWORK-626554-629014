package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
* ComandoAiuto: ti stampa i vari comandi presenti
*
* @author 626554-629014
* @version base
* @see Comando
*/

public class ComandoAiuto implements Comando{
	private IO io;
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio(" ");
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
	    return "aiuto";
	}
}
