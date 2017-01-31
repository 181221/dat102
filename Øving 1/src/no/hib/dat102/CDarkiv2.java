package no.hib.dat102;

import no.hib.dat102.node.LinearNode;
import no.hib.data102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT {
	private int antall;
	private LinearNode<CD> start;

	public CDarkiv2() {
		start = null;
		antall = 0;
	}

	@Override
	public boolean eksisterer(CD[] tittel) {
		boolean funnet = false;
		LinearNode<CD> denne = start;
		for (int i = 0; i < antall && !funnet; i++) {
			if (denne.getElement().equals(tittel)) {
				funnet = true;
			} else {
				denne = denne.getNeste();
			}
		}
		return funnet;

	}

	@Override
	public CD[] hentCdTabell() {
		LinearNode<CD> node = start;
		CD[] cdtab = new CD[antall];
		int i = 0;
		while (i < antall && node !=null) {
			cdtab[i] = node.getElement();
			node = node.getNeste();
			i++;
		}
		return cdtab;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		LinearNode<CD> nyNode = new LinearNode<CD>(nyCd);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	public LinearNode<CD> finnCDpaaCDNr(int cdNr) {
		LinearNode<CD> node = start;
		LinearNode<CD> forjeNode = start;
		while (node != null) {
			if (node.getElement().getCdNummer() == cdNr) {
				return forjeNode;
			} else {
				forjeNode = node;
				node = forjeNode.getNeste();
			}
		}
		return null;
	}

	@Override
	public boolean slettCd(int cdNr) {
		LinearNode<CD> slett = finnCDpaaCDNr(cdNr);
		boolean slettet = false;
		if (slett != null) {
			slett.setNeste(slett.getNeste());
			antall--;
			slett = start;
			slettet = true;
		}
		return slettet;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		CD[] tittler = new CD[antall];
		LinearNode<CD> noder = start;
		int i = 0;
		while (i < antall && noder != null) {
			if (noder.getElement().getTittel().contains(delstreng)) {
				tittler[i] = noder.getElement();
			}
			noder = noder.getNeste();
			i++;
		}
		return tittler;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		CD[] artist = new CD[antall];
		LinearNode<CD> node = start;
		int i = 0;
		while (i < antall && node != null) {
			if (node.getElement().getArtist().contains(delstreng)) {
				artist[i] = node.getElement();
			}
			node = node.getNeste();
			i++;
		}
		return artist;
	}

	@Override
	public int hentAntall() {
		return antall;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		int antallsjanger = 0;
		LinearNode<CD> p = start;
		LinearNode<CD> q = start;
		int teller = 1;
		while (teller <= antall) {
			if (p.getElement().getSjanger() == sjanger) {
				antallsjanger++;
			}
			q = p;
			p = p.getNeste();
			teller++;
		}
		return antallsjanger;
	}

	/*
	 * Klassen skal ha de samme operasjoner som for CDarkiv i øving 1, men pass
	 * på at implementeringen av alle metoder blir tilpasset den nye strukturen.
	 */
}// class
