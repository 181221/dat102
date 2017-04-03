package no.hib.dat102;

import no.hib.dat102.adt.KoeADT;

public class SirkulerKoeKlient {
	public static void main(String[] args) {

		KoeADT<Character> tegnKoe = new SirkulerKoe<Character>();

		String streng = "Denne koen er en FIFO datastruktur";
		int lengde = streng.length();
		
		System.out.println(streng);
		
		for (int i = 0; i < lengde; i++) {
			tegnKoe.innKoe(new Character(streng.charAt(i)));
		}
		while (!tegnKoe.erTom()) {
			Character tegn_obj = (Character) tegnKoe.utKoe();
			System.out.print(tegn_obj);
		}
		System.out.println();
	}
}
