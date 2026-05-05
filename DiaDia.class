package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {
	private Partita partita;
	private ComandoPrendi comando;
	private Attrezzo attrezzo;
	private IO io;
	
	@BeforeEach
	public void setUp() {
		partita = new Partita();
		attrezzo = new Attrezzo("spada", 1);
		comando = new ComandoPrendi("spada");
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		io = new IOConsole();
	}
	@Test
	void testPrendi() {
		comando.setIo(io);
		comando.esegui(partita);
		assertTrue(partita.getBorsa().hasAttrezzo("spada"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("spada"));
	}
	@Test
	void testPrendiNulla() {
		comando.setIo(io);
		comando.setParametro(null);
		comando.esegui(partita);
		assertFalse(partita.getBorsa().hasAttrezzo("spada"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("spada"));
	}
}
