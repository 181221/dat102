package no.hib.dat102.Sortering;

public class Sortering {

	public static <T extends Comparable<T>> void bobleSortering(T[] tab) {
		T temp;
		for (int i = tab.length - 1; i >= 0; i--) {
			for (int k = 0; k < i ; k++) {
				if (tab[k].compareTo(tab[i]) > 0) {
					temp = tab[i];
					tab[i] = tab[k];
					tab[k] = temp;
				}
			}
		}
	}

	public static <T extends Comparable<T>> void utvalgsSortering(T[] tab) {
		T resultat;
		int minste;
		for (int neste = 0; neste < tab.length - 1; neste++) {
			minste = neste;
			for (int soek = neste + 1; soek < tab.length; soek++) {
				if (tab[minste].compareTo(tab[neste]) > 0) {
					minste = neste;
				}
			}
			// bytting
			resultat = tab[minste];
			tab[minste] = tab[neste];
			tab[neste] = resultat;
		}
	}

	public static <T extends Comparable<T>> void innStikkSortering(T[] tab) {
		for (int i = 1; i < tab.length; i++) {
			T element = tab[i];
			int p = i;
			while (p > 0 && tab[p - 1].compareTo(element) > 0) {
				tab[p] = tab[p - 1];
				p--;
			}
			tab[p] = element;
		}

	}

	public static <T extends Comparable<T>> void fletteSort(T[] data, int foerste, int siste) {
		if (foerste < siste) {
			int midten = (foerste + siste) / 2;

			fletteSort(data, foerste, midten);

			fletteSort(data, midten + 1, siste);

			flette(data, foerste, midten, siste);
		}

	}

	public static <T extends Comparable<T>> void flette(T[] tabell, int foerste, int midten, int siste) {
		int stor = siste - foerste + 1;
		T[] hjelpeTabell = (T[]) (new Comparable[stor]);

		int foerste1 = foerste;
		int siste1 = midten;

		int foerste2 = midten + 1;
		int siste2 = siste;

		int indeks = 0;

		while ((foerste1 <= siste1) && (foerste2 <= siste2)) {
			if (tabell[foerste1].compareTo(tabell[foerste2]) <= 0) {
				hjelpeTabell[indeks] = tabell[foerste1];
				foerste1++;
			} else {
				hjelpeTabell[indeks] = tabell[foerste2];
				foerste2++;
			}
			indeks++;
		}

		while (foerste1 <= siste1) {
			hjelpeTabell[indeks] = tabell[foerste1];
			foerste1++;
			indeks++;
		}

		while (foerste2 <= siste2) {
			hjelpeTabell[indeks] = tabell[foerste2];
			foerste2++;
			indeks++;
		}
		int h = 0;
		for (indeks = foerste; indeks <= siste; indeks++) {
			tabell[indeks] = hjelpeTabell[h];
			h++;
		}
	}

	public static <T extends Comparable<T>> void kvikkSortNy(T[] data, int min, int maks) {
		kvikkSort2(data, min, maks);
		sorteringVedInnsetting2(data, min, maks);
	}

	public static <T extends Comparable<T>> void sorteringVedInnsetting2(T[] data, int forste, int siste) {
		for (int indeks = forste + 1; indeks <= siste; indeks++) {
			T nokkel = data[indeks];
			int p = indeks;
			// Forskyv større verdier mot høyre
			while (p > 0 && data[p - 1].compareTo(nokkel) > 0) {
				data[p] = data[p - 1];
				p--;
			}
			data[p] = nokkel;
		} // ytre
	}// metode

	public static <T extends Comparable<T>> void kvikkSort2(T[] data, int min, int maks) {
		int posPartisjon;
		if (maks - min + 1 > min) {// antall elementer > MIN ?
			/** Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);
			/** Sorterer venstre side */
			kvikkSort2(data, min, posPartisjon - 1);
			/** Sorterer høyre side */
			kvikkSort2(data, posPartisjon + 1, maks);
		}
	}

	public static <T extends Comparable<T>> int finnPartisjon(T[] data, int min, int maks) {
		int venstre;
		int hoeyre;
		T temp;
		T pivot;

		// Pivot som første element
		pivot = data[min];
		venstre = min;
		hoeyre = maks;

		while (venstre < hoeyre) {
			/* Søker et element som er større enn pivot */
			while (venstre < hoeyre && data[venstre].compareTo(pivot) <= 0) {
				venstre++;
			}
			/* Søker et element som er <= enn pivot */
			while (data[hoeyre].compareTo(pivot) > 0) {
				hoeyre--;
			}
			if (venstre < hoeyre) {
				temp = data[venstre];
				data[venstre] = data[hoeyre];
				data[hoeyre] = temp;
			}
		} // while
		/* Flytter pivot til riktig og endelig plass */
		temp = data[min];
		data[min] = data[hoeyre];
		data[hoeyre] = temp;
		return hoeyre;
	} // metode
}
