package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto LabirintoDefault;
	private Giocatore giocatore;
	private Borsa borsa;
	//private Stanza stanzaCorrente;
	//private Stanza stanzaVincente;
	private boolean finita;
	
	public Partita(){
		//creaStanze();
		this.LabirintoDefault = new Labirinto();
		this.giocatore = new Giocatore();
		this.borsa = new Borsa();
		this.finita = false;
	}



	public Stanza getStanzaVincente() {
		return LabirintoDefault.getstanzaVincente();
	}

	public Stanza getStanzaCorrente() {
		return LabirintoDefault.stanzaCorrente;
	}
	
	public Giocatore getGiocatore()
	{
		return this.giocatore;
	}
	public Labirinto getLabirinto() {
		return this.LabirintoDefault;
	}
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

}
