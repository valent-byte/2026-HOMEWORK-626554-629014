package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private StanzaBuia stanzaBuiaTest;
	private Attrezzo lanternaTest;
	
	@BeforeEach
	void setUp() {
		stanzaBuiaTest = new StanzaBuia("Aula");
		lanternaTest = new Attrezzo("Lanterna", 5);
		
	}
	
	@Test
	void testVerificaBuioConOggetto() {
		stanzaBuiaTest.addAttrezzo(lanternaTest);
		assertEquals(stanzaBuiaTest.toString(), stanzaBuiaTest.getDescrizione());
	}
	
	@Test
	void testVerificaBuioSenzaOggetto() {
		String descrizioneAttesa = "Qui c'è un buio pesto";
		
		assertEquals(descrizioneAttesa, stanzaBuiaTest.getDescrizione());
	}
}
