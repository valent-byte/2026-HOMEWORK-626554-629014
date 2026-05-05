package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {
	private Partita partita;
	private ComandoPrendi comando;
	private Attrezzo attrezzo;
	
	@BeforeEach
	public void setUp() {
		partita = new Partita();
		attrezzo = new Attrezzo("osso", 1);
		comando = new ComandoPrendi("osso");
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
	}
	@Test
	void testPrendi() {
		comando.esegui(partita);
		assertTrue(partita.getBorsa().hasAttrezzo("osso"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("osso"));
	}
	@Test
	void testPrendiNulla() {
		comando.setParametro(null);
		comando.esegui(partita);
		assertFalse(partita.getBorsa().hasAttrezzo("osso"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("osso"));
	}
}
