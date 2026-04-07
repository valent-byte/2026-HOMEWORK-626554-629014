package it.uniroma3.diadia;

import it.uniroma3.diadia.IOConsole.IOConsole;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		IOConsole.mostroMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = IOConsole.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else
			IOConsole.mostroMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			IOConsole.mostroMessaggio("Hai vinto!");
			return true;
		} 
		if (this.partita.isFinita())
		{
			IOConsole.mostroMessaggio("Non hai più CFU!");
		}
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			IOConsole.mostroMessaggio(elencoComandi[i]+" ");
		IOConsole.mostroMessaggio(" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			IOConsole.mostroMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			IOConsole.mostroMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			this.partita.getGiocatore().decrementaCfu();
		}
		IOConsole.mostroMessaggio(partita.getStanzaCorrente().getDescrizione());
		IOConsole.mostroMessaggio("CFU: " + this.partita.getGiocatore().getCfu());
	}
	/**
	 * Posi l'oggetto in una stanza
	 * (può anche essere di una stanza diversa) e stampa i diversi errori
	 */
	private void posa(String oggetto) {
		if (oggetto == null)
			IOConsole.mostroMessaggio("Oggetto non specificato, riprova");
		Attrezzo attrezzoDaPosare = partita.getBorsa().getAttrezzo(oggetto);
		if (attrezzoDaPosare == null)
		{
			IOConsole.mostroMessaggio("Non possiedi il seguente oggetto :" + oggetto);
		}
		else
		{
			partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
			partita.getBorsa().removeAttrezzo(oggetto);
			IOConsole.mostroMessaggio("Hai posato il seguente oggetto: " + attrezzoDaPosare);
		}
	}
	/**
	 * Prendi un oggetto nella stanza e lo metto in borsa 
	 * se non c'è abbastanza spazio non lo mette
	 */
	private void prendi(String oggetto) {
		if (oggetto == null)
			IOConsole.mostroMessaggio("Oggetto non specificato, riprova");
		// controllo se ESISTE l'oggetto nella stanza 
		if (!partita.getStanzaCorrente().hasAttrezzo(oggetto))
			IOConsole.mostroMessaggio("Non è presente il seguente oggetto nella stanza: " + oggetto);
		// controllo se ho abbastanza spazio, se non ce n'è abbastanza non te lo fa prendere, a meno che non lo fai tu
		else if ((partita.getBorsa().getPeso() + partita.getStanzaCorrente().getAttrezzo(oggetto).getPeso()) <= partita.getBorsa().getPesoMax())
		{
			Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(oggetto);
			partita.getBorsa().addAttrezzo(attrezzoDaPrendere);
			partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
			IOConsole.mostroMessaggio("Hai preso " + attrezzoDaPrendere);
		}
		else
			IOConsole.mostroMessaggio("Non hai abbastanza spazio, libera peso per prendere il seguente oggetto: " + oggetto);
	}
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		IOConsole.mostroMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}