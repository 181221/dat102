package no.hib.dat102;

public class Metoder {
	public static void snuTall(int tall) {
		// tall må være > 0
		int sistesiffer = tall % 10;
		System.out.println(sistesiffer);
		tall = tall / 10;

		if (tall == 0) {// basis, gjør ingenting

		} else {
			snuTall(tall);
		} /*
			 * if(tall != 0){ snuTall(tall);
			 */
	}

	// oppgave 2

	public static void snuTabell(int[] tab, int fra, int til) {
		if (fra > til) { // basistilfelle
		} else {
			int temp = tab[fra];
			tab[fra] = tab[til];
			tab[til] = temp;
			fra++;
			snuTabell(tab, fra, til - 1);
		}
	}

	public static int sumOpp(int m, int n) {
		int resultat = 0;
		if (m > n) {

		} else {
			resultat = m * sumOpp(m + 1, n);
			System.out.println(m);

		}

		return resultat;
	}

	public static int sum(int num, int stopp) {
		int resultat = 0;
		if (num > stopp) {
		} else {
			resultat = num * num + sum(num + 1, stopp);
		}
		return resultat;
	}

}
