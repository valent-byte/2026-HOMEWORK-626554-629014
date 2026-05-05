package it.uniroma3.diadia.IOConsole;
import java.util.Scanner;

import it.uniroma3.diadia.IO;
public class IOConsole implements IO{
	private Scanner scannerDiLinee;
	public IOConsole() {
		this.scannerDiLinee = new Scanner(System.in);
	}
	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
	}

	@Override
	public String leggiRiga() {
		String riga = scannerDiLinee.nextLine();
		return riga;
	}
}
