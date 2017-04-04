package no.hib.dat102;

public class finnMinste {
	/**
	 * metode for å finne miste i en tab (rekursjon);
	 * 
	 * @param tab
	 * @return
	 */

	public static int finnMinste(int[] tab, int lengde) {
		if (lengde > 0) {
			return Math.min(tab[lengde], finnMinste(tab, lengde - 1));
		} else {
			return tab[0];
		}
	}
	public static int finnMinste(int[] tab, int start, int lengde) {
		if (lengde > start) {
			return Math.min(tab[lengde], finnMinste(tab, lengde - 1));
		} else {
			return tab[start];
		}
	}

	public static int finneMinste2(int[] tab) {
		int siste = tab.length - 1;
		int start = 0;
		int midten = (start+siste)/2;
		int p = finnMinste(tab,start,midten);
		int k = finnMinste(tab,midten+1,siste);
		return Math.min(p, k);
		
	}
	public static void main(String[] args) {
		int[] tab = { 10, 8, 2, 2, 10, 3, 2, 7, 8, 9, 10 };
		int[] tab1 = new int[tab.length / 2];
		System.out.println(finnMinste(tab, tab.length - 1));
		System.out.println(finneMinste2(tab));
		

	}

}
