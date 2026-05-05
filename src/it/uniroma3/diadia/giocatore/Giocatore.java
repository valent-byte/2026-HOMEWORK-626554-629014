package it.uniroma3.diadia.giocatore;


/**
* Nome-classe: classe che gestisce i CFU del giocatore (e possibilmente la vita)
*
* @author 626554-629014
* @version base
*/

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	public int getCfu() {
		return this.cfu;
	}
	public void decrementaCfu() {
		this.cfu = cfu - 1;		
	}
}
