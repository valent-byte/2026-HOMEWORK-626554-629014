package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	private StanzaMagica stanzaTest;
	private Attrezzo bastone;
	
	@BeforeEach
	void setUp() {
		stanzaTest = new StanzaMagica("Aula");
	}
	@Test
	void testVerificaMagia() {
		stanzaTest.addAttrezzo(new Attrezzo("oggetto1", 1));
		stanzaTest.addAttrezzo(new Attrezzo("oggetto2", 1));
		stanzaTest.addAttrezzo(new Attrezzo("oggetto3", 1));
		bastone = new Attrezzo("Bastone", 2);
		stanzaTest.addAttrezzo(bastone);
		assertFalse(stanzaTest.hasAttrezzo("Bastone"));
		assertTrue(stanzaTest.hasAttrezzo("enotsaB"));
		Attrezzo attrezzoMagico = stanzaTest.getAttrezzo("enotsaB");
		assertEquals(4, attrezzoMagico.getPeso());
	}

}
