package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
	private Partita partita;
	private ComandoPosa comando;
	private Attrezzo attrezzo;
	
	@BeforeEach
	public void setUp() {
		partita = new Partita();
		attrezzo = new Attrezzo("osso", 1);
		comando = new ComandoPosa();
		partita.getBorsa().addAttrezzo(attrezzo);
	}
	@Test
	void testPosoEsistente() {
		comando.setParametro("osso");
		comando.esegui(partita);
		assertFalse(partita.getBorsa().hasAttrezzo("osso"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("osso"));
	}
	@Test
	void testPosoVuoto() {
		comando.setParametro("nonInBorsa");
		comando.esegui(partita);
		assertTrue(partita.getBorsa().hasAttrezzo("osso"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("nonInBorsa"));
	}
	@Test
	void testParametroNullo() {
		comando.setParametro(null);
		comando.esegui(partita);
		assertTrue(partita.getBorsa().hasAttrezzo("osso"));
	}

}
