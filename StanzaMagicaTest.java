package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	private StanzaBloccata stanzaTest;
	private Stanza stanzaAdiacente;
	private Attrezzo piedeDiPorco;
	
	@BeforeEach
	void setUp() {
		piedeDiPorco = new Attrezzo("Piede di porco", 6);
		stanzaTest = new StanzaBloccata("Aula", "Sud", "Piede di porco");
		stanzaAdiacente = new Stanza("Corridoio");
		stanzaTest.impostaStanzaAdiacente("Sud", stanzaAdiacente);
	}
	
	@Test
	void stanzaConAttrezzo() {
		stanzaTest.addAttrezzo(piedeDiPorco);
		
		assertEquals(stanzaAdiacente, stanzaTest.getStanzaAdiacente("Sud"));

		Stanza stanzaAttesa = new Stanza("Aula");
		stanzaAttesa.impostaStanzaAdiacente("Sud", stanzaAdiacente);
		stanzaAttesa.addAttrezzo(piedeDiPorco);
		
		assertEquals(stanzaAttesa.getDescrizione(), stanzaTest.getDescrizione());
	}
	
	@Test
	void stanzaSenzaAttrezzo() {
		String blocco = "Stanza bloccata nella direzione: Sud\nTi serve l'attrezzo: Piede di porco per passare.\n";

		assertEquals(stanzaTest, stanzaTest.getStanzaAdiacente("Sud"));
		
		Stanza stanzaAttesa = new Stanza("Aula");
		stanzaAttesa.impostaStanzaAdiacente("Sud", stanzaAdiacente);
		
		assertEquals(blocco + stanzaAttesa.getDescrizione(), stanzaTest.getDescrizione());
	}

}
