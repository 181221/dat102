package no.hib.dat102.mengde.kjedet;

import no.hib.dat102.mengde.adt.*;
import no.hib.dat102.mengde.tabell.TabellMengde;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (!erTom()) {
			int valg = rand.nextInt(antall) + 1;
			if (valg == 1) {
				resultat = start.getElement();
				start = start.getNeste();
			} else {
				forgjenger = start;
				for (int nr = 2; nr < valg; nr++) {
					forgjenger = forgjenger.getNeste();
				}
				aktuell = forgjenger.getNeste();
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste());
			}
			antall--;
		} // if
		return resultat;
	}//

	public T slettForan() {
		assert antall > 0;// listen kan ikke være tom.
		LinearNode<T> p = start;
		start = p.getNeste();
		antall--;
		return p.getElement();
	}

	@Override
	public T fjern(T element) {
		boolean funnet = false;
		LinearNode<T> forgjenger = null;
		LinearNode<T> aktuell = start;
		T resultat = null;

		while (aktuell != null && !funnet) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				forgjenger = aktuell;
				aktuell = aktuell.getNeste();
			}
		}
		if (funnet) {
			if (forgjenger == null) {// funnet i 1.node i listen
				slettForan();
			} else if (aktuell.getNeste() == null) {// Funnet i siste node i
													// listen.
				forgjenger.setNeste(null);
				antall--;
			} else {
				// funnet i node inne i listen
				forgjenger.setNeste(aktuell.getNeste());
			}
		}
		return resultat;
	}//

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {// OBS! En bedre i kladdeopg4
		MengdeADT<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			begge.leggTil(aktuell.getElement());
			aktuell = aktuell.getNeste();
		} // while
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}
		return begge;
	}//

	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int sok = 0; sok < antall && !funnet; sok++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean erLik(MengdeADT<T> m2) {
		if (this.antall != m2.antall()) {
			return false;
		}
		boolean likeMengder = true;
		T element = null;

		Iterator<T> m1 = m2.oppramser();
		while (m1.hasNext() && likeMengder) {
			element = m1.next();
			if (!this.inneholder(element)) {
				likeMengder = false;
			}
		}
		return likeMengder;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}

	@Override
	public MengdeADT<T> EffUnion(MengdeADT<T> m2) {
		KjedetMengde<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		T element;
		Iterator<T> oppram = m2.oppramser();

		while (aktuell != null) {
			begge.settInn(aktuell.getElement());
			aktuell = aktuell.getNeste();
		}
		while (oppram.hasNext()) {
			element = oppram.next();
			if (!inneholder(element)) {
				begge.settInn(element);
			}
			
		}
		return begge;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		KjedetMengde<T> snitt = new KjedetMengde<T>();
		Iterator<T> oppram = m2.oppramser();
		LinearNode<T> aktuell = start;
		T element;

		while (aktuell != null) {
			snitt.settInn(aktuell.getElement());
			aktuell = aktuell.getNeste();
		}
		return snitt;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		KjedetMengde<T> AikkeB = new KjedetMengde<T>();
		Iterator<T> teller = this.oppramser();
		LinearNode<T> aktuell = start;
		T element;
		

		while (teller.hasNext()) {
			element = teller.next();
			if (!m2.inneholder(element)) {
				AikkeB.settInn(element);
			}
		}
		return AikkeB;
	}

}// class
