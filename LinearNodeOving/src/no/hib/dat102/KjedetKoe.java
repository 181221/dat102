package no.hib.dat102;

import no.hib.dat102.koe.koeADT;

public class KjedetKoe<T> implements koeADT<T> {
	private int antall;
	private LinearNode<T> start, siste;

	public KjedetKoe() {
		antall = 0;
		start = siste = null;
	}

	@Override
	public void leggTil(T element) {
		LinearNode<T> node = new LinearNode<T>(element);

		if (erTom()) {
			start = node;
		} else {
			siste.setNeste(node);
		}
		siste = node;
		antall++;
	}

	@Override
	public T fjernFoersteElement() throws EmptyCollectionException {
		if (erTom())
			throw new EmptyCollectionException("køen");

		T resultat = start.getElement();
		start = start.getNeste();
		antall--;

		if (erTom())
			siste = null;
		return resultat;
	}

	@Override
	public T forste() {
		return start.getElement();
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
	public Boolean fjernElement(T elem) throws EmptyCollectionException {
		if (erTom())
			throw new EmptyCollectionException("køen");

		LinearNode<T> p;
		LinearNode<T> q;
		p = start;
		q = p;

		if (p.getElement().equals(elem)) {
			fjernFoersteElement();
			return true;
		}
		while (p != null) {
			if (p.getElement().equals(elem)) {
				q.setNeste(p.getNeste());
				q = p.getNeste();
				return true;
			}
			q = p;
			p = p.getNeste();
		}
		if (erTom())
			siste = null;
		return false;
	}

	@Override
	public void LeggTilFoerstIKoe(T element) {
		LinearNode<T> node = new LinearNode<T>(element);
		
		node.setNeste(start);
		start = node;
		antall++;
	}
	

}
