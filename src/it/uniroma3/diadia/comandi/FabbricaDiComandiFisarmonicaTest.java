package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandiFisarmonica fabbrica;
	private Comando comando;
	@BeforeEach
	void setUp() {
		fabbrica = new FabbricaDiComandiFisarmonica();
	}
	@Test
	void testComandoInesistente() {
		comando = fabbrica.costruisciComando("boh");
		assertEquals(comando.getNome(), null);
	}
	void testComandiEsistenti() {
		comando = fabbrica.costruisciComando("posa");
		assertEquals(comando.getNome(), null);
		comando = fabbrica.costruisciComando("prendi");
		assertEquals(comando.getNome(), "prendi");
		comando = fabbrica.costruisciComando("vai");
		assertEquals(comando.getNome(), "vai");
		comando = fabbrica.costruisciComando("posa");
		assertEquals(comando.getNome(), "posa");
		comando = fabbrica.costruisciComando("aiuto");
		assertEquals(comando.getNome(), "aiuto");
		comando = fabbrica.costruisciComando("fine");
		assertEquals(comando.getNome(), "fine");
		comando = fabbrica.costruisciComando("guarda");
		assertEquals(comando.getNome(), "guarda");
	}

}
