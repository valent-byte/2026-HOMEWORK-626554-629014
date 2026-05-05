package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOSimulatorTest {
	private DiaDia diaDiaTest;
	private IOSimulator ioTest;
	
	@Test
	void testSimulazioneVittoria() {
		String[] comandi = {"vai nord"};
		ioTest = new IOSimulator(comandi);
		diaDiaTest = new DiaDia(ioTest);
		diaDiaTest.gioca();
		int i = 0;
		for(String messaggi : ioTest.getMessaggi()) {
			if(messaggi != null) {
				i++;
			}
		}
		assertTrue(ioTest.getMessaggi()[i-1].equals("Hai vinto!"));
	}
}
