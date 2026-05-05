package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
* ComandoPosa: Serve per posare gli oggetti nella stanza corrente
*
* @author 626554-629014
* @version base
* @see Comando, Attrezzo, Borsa, Stanza
*/

public class ComandoPosa implements Comando {
	private String oggetto;
	private IO io;
	@Override
	public void esegui(Partita partita) {
		if (oggetto == null)
		{
			io.mostraMessaggio("Oggetto non specificato, riprova");
			return;
		}
		Attrezzo attrezzoDaPosare = partita.getBorsa().getAttrezzo(oggetto);
		if (attrezzoDaPosare == null)
		{
			io.mostraMessaggio("Non possiedi il seguente oggetto :" + oggetto);
			return;
		}
		else
		{
			boolean posato = partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
			
			if (posato) {
				partita.getBorsa().removeAttrezzo(oggetto);
				io.mostraMessaggio("Hai posato: " + oggetto);
			} else {
				io.mostraMessaggio("La stanza è piena! Non puoi posare nulla qui.");
			}
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.oggetto = parametro;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return "posa";
	}

}
