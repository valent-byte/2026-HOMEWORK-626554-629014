package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
* ComandoPrendi: Serve per inserire gli oggetti in borsa(a meno che non hai abbastanza spazio)
*
* @author 626554-629014
* @version base
* @see Comando, Attrezzo, Borsa, Stanza
*/

public class ComandoPrendi implements Comando {
	private String oggetto;
	private IO io;

	public ComandoPrendi(String oggetto) {
		this.oggetto = oggetto;
	}

	@Override
	public void esegui(Partita partita) {
		if (oggetto == null) {
			io.mostraMessaggio("Oggetto non specificato, riprova");
			return;
		}
		// controllo se ESISTE l'oggetto nella stanza 
		if (!partita.getStanzaCorrente().hasAttrezzo(oggetto)) {
			io.mostraMessaggio("Non è presente il seguente oggetto nella stanza: " + oggetto);
			return;
		}
		// controllo se ho abbastanza spazio
		else if ((partita.getBorsa().getPeso() + partita.getStanzaCorrente().getAttrezzo(oggetto).getPeso()) <= partita.getBorsa().getPesoMax()) {
			Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(oggetto);
			partita.getBorsa().addAttrezzo(attrezzoDaPrendere);
			partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
			io.mostraMessaggio("Hai preso " + attrezzoDaPrendere);
			return;
		} else {
			io.mostraMessaggio("Non hai abbastanza spazio, libera peso per prendere il seguente oggetto: " + oggetto);
			return;	
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

	// ECCO IL METODO MANCANTE
	@Override
	public String getNome() {
		return "prendi";
	}
}