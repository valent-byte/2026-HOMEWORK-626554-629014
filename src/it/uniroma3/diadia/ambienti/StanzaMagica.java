package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaMagica - una stanza in un gioco di ruolo.
 * Questa stanza ha la particolarità in più che se si hanno 
 * abbastanza attrezzi posati, allora invertirà il suo nome 
 * e raddoppierà il peso.
 * 
 * @author 626554-629014
 * @see Attrezzo, Stanza
 * @version base
*/

class StanzaMagica extends Stanza {
    final static private int SOGLIA_MAGICA_DEFAULT = 3;
    private int contatoreAttrezziPosati;
    private int sogliaMagica;

    public StanzaMagica(String nome) {
        this(nome, SOGLIA_MAGICA_DEFAULT);
    }

    public StanzaMagica(String nome, int soglia) {
        super(nome);
        this.contatoreAttrezziPosati = 0;
        this.sogliaMagica = soglia;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        this.contatoreAttrezziPosati++;
        if (this.contatoreAttrezziPosati>this.sogliaMagica)
            attrezzo = this.modificaAttrezzo(attrezzo);
        return super.addAttrezzo(attrezzo);
    }

    private Attrezzo modificaAttrezzo (Attrezzo attrezzo) {
        StringBuilder nomeInvertito;
        int pesoX2 = attrezzo.getPeso() * 2;
        nomeInvertito = new StringBuilder(attrezzo.getNome());
        nomeInvertito = nomeInvertito.reverse();
        attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
        return attrezzo;
    }
}