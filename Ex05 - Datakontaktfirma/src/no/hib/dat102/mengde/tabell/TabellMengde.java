package no.hib.dat102.mengde.tabell;

import no.hib.dat102.mengde.adt.*;
import no.hib.dat102.modell.Medlem;

import java.util.Iterator;
import java.util.Random;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) new Object[start];
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}

	@Override
	public T fjern(T element) {
		// Søker etter og fjerner element.Retur med null ved ikke-funn
		//
		T svar = null;
		if (inneholder(element)) {
			for (int i = 0; i < antall; i++) {
				if (tab[i].equals(element)) {
					svar = tab[i];
					tab[i] = tab[antall - 1];
					tab[antall - 1] = null;
					antall--;
				}
			}
		}

		return svar;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			begge.leggTil(tab[i]);
		}
		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}

		return begge;
	}

	@Override
	public MengdeADT<T> EffUnion(MengdeADT<T> m2) {
		TabellMengde<T> begge = new TabellMengde<T>(this.antall + m2.antall());
		Iterator<T> oppram = m2.oppramser();

		for (int i = 0; i < antall; i++) {
			begge.settInn(this.tab[i]);
		}
		while (oppram.hasNext()) {
			begge.leggTil(oppram.next());
		}
		return begge;
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		int pos = -1;
		for (int i = 0; (i < antall) && (pos == -1); i++) {
			if (tab[i].equals(element))
				pos = i;
		}
		return (pos != -1);
	}

	@Override
	public boolean erLik(MengdeADT<T> m2) {
		assert this.antall() == m2.antall();
		boolean likeMengder = true;
		T element;
		Iterator<T> tellerLike = m2.oppramser();

		while (tellerLike.hasNext()) {
			element = tellerLike.next();
			if (!this.inneholder(element)) {
				return false;
			}
		}
		return likeMengder;
	}

	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		TabellMengde<T> snitt = new TabellMengde<T>(this.antall + m2.antall());
		Iterator<T> oppram = m2.oppramser();
		T element;
		
		for (int i = 0; i < this.antall; i++) {
			snitt.settInn(this.tab[i]);
		}

		while (oppram.hasNext()) {
			element = oppram.next();
			if (m2.inneholder(element)) {
				snitt.settInn(element);
			}
		}
		return snitt;
	}
	/*
	 * A = {1,2,3,4} 
	 * B = {1,3,5,6,7}
	 * A\B = {2,4}
	 */
	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		TabellMengde<T> AikkeB = new TabellMengde<T>(this.antall + m2.antall());
		Iterator<T> teller = this.oppramser();
		T element;
		
		while (teller.hasNext()) {
			element = teller.next();
			if(!m2.inneholder(element)){
				AikkeB.settInn(element);
			}
		}
		return AikkeB;
	}

	@Override
	public Medlem inneholder(String element) {
		// TODO Auto-generated method stub
		return null;
	}

}// class
