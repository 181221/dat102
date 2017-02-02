package no.hib.dat102;

import no.hib.dat102.adt.KoeADT;

public class SirkulerKoe<T> implements KoeADT<T> {

	private static final int STD = 100;
	private int front, bak, antall;
	private T[] koe;
	
	/**
	 * Oppretter en koe med stadardkapasitet
	 */
	public SirkulerKoe() {
		this(STD);
	}
	
	/**
	 * Oppretter en koe med startkapasitet
	 * @param startKapasitet
	 */
	public SirkulerKoe(int startKapasitet) {
		koe = (T[]) (new Object[startKapasitet]);
		antall = 0;
		front = bak = 0;
	}

	/**
	 * Oppretter en ny større tabell for å lagre elementene.
	 */
	private void utvid() {
		T[] hjelpetabell = (T[]) (new Object[koe.length * 2]);
		for (int i = 0; i < antall; i++) {
			hjelpetabell[i] = koe[front];
			front = (front + 1) % koe.length;
		}
		front = 0;
		bak = antall;
		koe = hjelpetabell;
	}

	/**
	 * legger til et element i koen, utvider om fullplass
	 */
	@Override
	public void innKoe(T element) {
		if (antall() == koe.length) {
			utvid();
		}
		koe[bak] = element;
		bak = (bak + 1) % koe.length;
		antall++;
	}

	/**
	 * Fjerner og returnerer elementet foran i køen.
	 */
	@Override
	public T utKoe() throws EmptyCollectionException {
		T resultat = null;
		
		if (!erTom()) {
			resultat = koe[front];
			koe[front] = null; // kan sløyfes
			front = (front + 1) % koe.length;
			antall--;
		}else{
			throw new EmptyCollectionException("koe");
		}
		return resultat;
	}

	@Override
	public T foerste() throws EmptyCollectionException{
		if(erTom()){
			throw new EmptyCollectionException("koe");
		}
		return koe[front];
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

}