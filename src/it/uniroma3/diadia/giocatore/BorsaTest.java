package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	private Borsa borsa;
	private Attrezzo bastone;
	private Attrezzo peso;
	
	@BeforeEach
	public void setUp() {
		bastone = new Attrezzo("Bastone", 2);
		peso = new Attrezzo("Peso", 11);
		borsa = new Borsa();
	}
	
	@Test
	void testAggiuntaAttrezzo() {
		assertEquals(true, borsa.addAttrezzo(bastone));
		assertEquals(false, borsa.addAttrezzo(peso));
	}
	
	@Test
	void testRimozioneAttrezzo() {
		borsa.addAttrezzo(bastone);
		assertEquals(bastone, borsa.removeAttrezzo("Bastone"));
		assertEquals(null, borsa.removeAttrezzo("Libro"));
	}
	
	@Test
	void testCercaAttrezzo() {
		borsa.addAttrezzo(bastone);
		assertEquals(true, borsa.hasAttrezzo("Bastone"));
		assertEquals(false, borsa.hasAttrezzo("Libro"));
	}
}
