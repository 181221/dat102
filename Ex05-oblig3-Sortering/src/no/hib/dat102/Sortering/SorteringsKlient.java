package no.hib.dat102.Sortering;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class SorteringsKlient {
	private static final int antall = 100000;
	public static void main(String[] args) {
		
		Integer[] lol = new Integer[antall];
		Random p = new Random();
		int[] lol1 = new int[antall];
		
		for (int i = 0; i < lol.length; i++) {
			lol[i] = p.nextInt();
		}
		
		Instant foer = Instant.now();
		Sortering.kvikkSort2(lol, 0, lol.length-1);
		Instant etter = Instant.now();
		

		Duration tid = Duration.between(foer, etter);
		System.out.println("Tid i millisekund: " + tid.toMillis()); 

	}

}
