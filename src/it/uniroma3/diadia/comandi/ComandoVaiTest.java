package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.IOConsole;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {
	private Partita partita;
	private Stanza stanzaTest; 
	private Stanza stanzaNord;
	private Stanza stanzaVincenteSud;
	private ComandoVai comando;
	private IO io;
	
	@BeforeEach
	public void setUp() {
		partita = new Partita();
		stanzaTest = new Stanza("Aula");
		stanzaNord = new Stanza("Stanza nord");
		stanzaVincenteSud = new Stanza("Stanza vincente");
		stanzaTest.impostaStanzaAdiacente("nord", stanzaNord);
		stanzaNord.impostaStanzaAdiacente("sud", stanzaTest);
		stanzaTest.impostaStanzaAdiacente("sud", stanzaVincenteSud);
		partita.getLabirinto().setStanzaCorrente(stanzaTest);
		partita.getLabirinto().setStanzaVincente(stanzaVincenteSud);
		comando = new ComandoVai();
		io = new IOConsole();
		comando.setIo(io);
	}
	@Test
	void testStanzaVincente() {
		comando.setParametro("sud");
		comando.esegui(partita);
		assertEquals(stanzaVincenteSud, partita.getStanzaCorrente());
		assertTrue(partita.vinta());
	}
	@Test
	void testStanzaDirezioneInesistente() {
		comando.setParametro("null");
		comando.esegui(partita);
		assertEquals(stanzaTest, partita.getStanzaCorrente());
		comando.setParametro("est");
		comando.esegui(partita);
		assertEquals(stanzaTest, partita.getStanzaCorrente());
	}
	@Test
	void testAvantiIndietro() {
		comando.setParametro("nord");
		comando.esegui(partita);
		assertEquals(stanzaNord, partita.getStanzaCorrente());
		comando.setParametro("sud");
		comando.esegui(partita);
		assertEquals(stanzaTest, partita.getStanzaCorrente());
		
	}

}
