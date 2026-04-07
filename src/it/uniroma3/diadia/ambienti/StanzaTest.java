package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza stanzaTest; 
	private Stanza stanzaNord;
	private Attrezzo bastone;
	private Attrezzo carta;
	
	@BeforeEach
	public void setUp() {
		stanzaTest = new Stanza("Aula");
		stanzaNord = new Stanza("Stanza nord");
		bastone = new Attrezzo("Bastone", 2);
		carta = new Attrezzo("Carta", 1);
		stanzaTest.addAttrezzo(bastone);
		stanzaTest.impostaStanzaAdiacente("nord", stanzaNord);
	}

	@Test
	public void testCercoAttrezzo() {
		assertEquals(true, stanzaTest.hasAttrezzo("Bastone"));
		assertEquals(false, stanzaTest.hasAttrezzo("Cucchiaio"));
	}
	
	@Test
	public void testEliminoAttrezzo() {
		assertEquals(true, stanzaTest.removeAttrezzo(bastone));
		assertEquals(false, stanzaTest.removeAttrezzo(carta));
	}
	@Test
	public void testRichiedoStanzaAdiacente() {
		assertEquals(stanzaNord, stanzaTest.getStanzaAdiacente("nord"));
		assertEquals(null, stanzaTest.getStanzaAdiacente("ovest"));
		
	}
	
	
}
