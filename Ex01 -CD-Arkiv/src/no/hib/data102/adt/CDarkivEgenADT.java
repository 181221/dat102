package no.hib.data102.adt;

import no.hib.dat102.CD;

public interface CDarkivEgenADT {
	/**
	 * 
	 * @return eksisterer eller ikke.
	 */
	boolean eksisterer(CD[] tittel);

}
