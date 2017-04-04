package no.hib.dat102;

public class binaersoeking {
	public static void main(String[] args) {
		Integer[] array = { 2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 23, 27, 29, 30, 31 };
		System.out.println(binaerSoek(array, 0, array.length - 1, 16));
	}
	
	public static <T extends Comparable<T>> int binaerSoek(T[] data, int min, int maks, T el) {
		if (min > maks) {
			return -1;
		}
		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);
		if (resultat == 0) {
			return midtpunkt;
		}
		if ( resultat < 0) {
			return binaerSoek(data, min, midtpunkt - 1,  el);
		} else {
			return binaerSoek(data, midtpunkt + 1, maks, el);
		}
	}
}