package it.uniroma3.diadia.IOConsole;
import java.util.Scanner;
public class IOConsole {
	
	public static void mostroMessaggio(String msg) {
		System.out.println(msg);
	}
	
	public static String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		
		return riga;
	}
}
