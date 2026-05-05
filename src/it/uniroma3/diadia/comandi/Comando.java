package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
* Comando: interface del comando per rendere più organizzata la gestione dei comandi
*
* @author 626554-629014
* @version base
*/

public interface Comando {

	/**
	* esecuzione del comando
	*/
	public void esegui(Partita partita);
	/**
	* set parametro del comando
	*/
	public void setParametro(String parametro);
	public void setIo(IO io);
	String getNome();
}
