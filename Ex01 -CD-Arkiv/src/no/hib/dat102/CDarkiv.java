package no.hib.dat102;

import no.hib.data102.adt.CDarkivADT;
import no.hib.data102.adt.CDarkivEgenADT;

/**
 * 
 * @author Peder
 * CD-Arkiv med alle CDene og metodene fra interface. 
 *
 */

public class CDarkiv implements CDarkivADT, CDarkivEgenADT {
	// Instansvariable
	final static int STK = 100;
	private CD[] cdTabell;
	private int antall;

	// Konstruktører og andre metoder
	/**
	 * Tilordner maxAntall til Array
	 * @param maxAntall
	 */
	public CDarkiv(int maxAntall) {
		cdTabell = new CD[maxAntall];
		antall = 0;
		
	}
	/**
	 * 100 plasser som standard verdi.
	 */
	public CDarkiv(){
		this(STK);
	}

	@Override
	public CD[] hentCdTabell() {
		return cdTabell;
	}
	/**
	 *Utvider tabellen med 10 prosent 
	 */
	private void utvidKapasitet() {
		CD[] hjelpetabell = new CD[(int) Math.ceil(1.1 * cdTabell.length)];
		for (int i = 0; i < cdTabell.length; i++) {
			hjelpetabell[i] = cdTabell[i];
		}
		cdTabell = hjelpetabell;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		if (antall == cdTabell.length) {
			utvidKapasitet();
		}
		cdTabell[antall] = nyCd;
		antall++;
	}

	@Override
	public boolean slettCd(int cdNr) {
		boolean slett = false;
		if (finsCD(cdNr) != -1) {
			cdTabell[finsCD(cdNr)] = cdTabell[antall-1];
			cdTabell[antall-1] = null;
			antall--;
			slett = true;
		}
		return slett;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		CD[] tittel = new CD[antall];
		for (int i = 0; i < antall; i++) {
			if (cdTabell[i].getTittel().contains(delstreng)) {
				tittel[i] = cdTabell[i];
			}
		}
		trimTab(tittel, antall);
		return tittel;
	}
	@Override
	public boolean eksisterer(CD[] tittel){
		
		for(int i = 0; i < antall; i++){
			if(tittel[i] != null){
				return true;
			}
		}
		return false;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		CD[] artist = new CD[antall];
		for (int i = 0; i < antall; i++) {
			if (cdTabell[i].getArtist().contains(delstreng)) {
				artist[i] = cdTabell[i];
			}
		}
		trimTab(artist, antall);
		return artist;
	}

	@Override
	public int hentAntall() {
		return antall;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		int antallSjanger = 0;
		for (int i = 0; i < antall; i++) {
			if (cdTabell[i].getSjanger()==(sjanger)) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}
	/**
	 * 
	 * @param cdNr - cdnummer
	 * @return if eksist "1" else "-1" 
	 */
	public int finsCD(int cdNr) {
		for (int i = 0; i < antall ; i++) {
			if (cdTabell[i].getCdNummer() == cdNr) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Ved hjelp av å trimme tabellen, vil eventuelle null-referanser alltid
	 * være på slutten av tabellen. Alle referanser som referer til objekter vil
	 * komme sammenhengenede etter hverandre. Forusatt da at tabellen ikke er
	 * blitt tom.
	 * 
	 * @param tab
	 *            Tabell av CD-er
	 * @param n
	 *            N er antall elementer
	 * @return En ny full tabell
	 */
	private CD[] trimTab(CD[] tab, int n) {
		CD[] cdtab2 = new CD[n];
		int i = 0;
		while (i < n) {
			cdtab2[i] = tab[i];
			i++;
		} // while
		return cdtab2;
	}

}
