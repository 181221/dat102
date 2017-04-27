package no.hib.dat102.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * 
 * @author Peder Oppgave 6e hashing. Sml mellom hashSet og tabell.
 */

public class SmlTId {
	public static <T extends Comparable<T>> int binaerSoek(T[] data, int min, int maks, T el) {
		if (min > maks) {
			return -1;
		}
		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);
		if (resultat == 0) {
			return midtpunkt;
		}
		if (resultat < 0) {
			return binaerSoek(data, min, midtpunkt - 1, el);
		} else {
			return binaerSoek(data, midtpunkt + 1, maks, el);
		}
	}

	public static void main(String[] args) {
		int antElement = 100000;
		Integer tab[] = new Integer[antElement];
		HashSet<Integer> tabHash = new HashSet<>();
		int tall = 376; // Her kan vi bruke eit vilkårleg tal
		for (int i = 0; i < antElement; i++) {
			// legg tall til i HashSet og tabell
			tall = (tall + 45713) % 1000000; // Sjå nedanfor om 45713
			tabHash.add(tall);
			tab[i] = tall;
		}
		Arrays.sort(tab);

		Random r = new Random();
		long tidFor;
		long tidEtter;
		long resultat;
		int tilfeldigeTall;

		tidFor = System.currentTimeMillis();
		for (int i = 0; i < tab.length; i++) {
			tilfeldigeTall = r.nextInt(999999);
			binaerSoek(tab, 0, tab.length - 1, tilfeldigeTall);

		}
		tidEtter = System.currentTimeMillis();
		resultat = (tidEtter - tidFor);
		System.out.println("Resultat for tabell: tid i ms " + resultat);

		tidFor = System.currentTimeMillis();
		for (int i = 0; i < tab.length; i++) {
			tilfeldigeTall = r.nextInt(999999);
			tabHash.contains(tilfeldigeTall);
		}
		tidEtter = System.currentTimeMillis();
		resultat = (tidEtter - tidFor);
		System.out.println("Resultat for hashset: tid i ms " + resultat);

	}
}
