package no.hib.dat102.Klient;

import java.util.Random;

import no.hib.dat102.KjedetBinearSokeTre;



class KlientBSTre {
	public static void main(String[] a) {
		// Lager BS-tre med 8 noder
		// Skriv ut i in-orden, dvs sortert
		// Sjekker om verdien 10 er i treet
		//

		final int ANTALL_NODER = 16;
		Random tilfeldig = new Random();

		KjedetBinearSokeTre<Integer> bs = new KjedetBinearSokeTre<Integer>();
		Integer resultat = null;

		for (int i = 0; i < ANTALL_NODER; i++) {
			Integer element = new Integer(tilfeldig.nextInt(30));
			bs.leggTil(element);
		}

		System.out.println("Treet med  " + ANTALL_NODER + " noder.");

		bs.visInorden();

		Integer el = new Integer(10);

		// ************************************************************************

		resultat = bs.finn(el);
		if (resultat != null)
			System.out.println("\nSoekte etter " + el + " og fant " + resultat);
		else
			System.out.println("\nSoekte etter " + el + " som ikke var i treet ");

		// ****************************************************************************

		resultat = bs.fjernMaks();
		if (resultat != null)
			System.out.println("\nFjernet stoerste " + resultat);
		else
			System.out.println("Treet er tomt");
		System.out.println("Treet er nå: ");
		bs.visInorden();

		// ****************************************************************************
		resultat = bs.fjernMin();
		if (resultat != null)
			System.out.println("\nFjernet minste " + resultat);
		else
			System.out.println("Tree er tomt ");
		System.out.println("Treet er nå: ");
		bs.visInorden();
		// ****************************************************************************

		resultat = bs.finnMin();
		if (resultat != null)
			System.out.println("\nMinste element " + resultat);
		else
			System.out.println("Treet er tomt");

		// ******************************************************************************

		resultat = bs.finnMaks();
		if (resultat != null)
			System.out.println("\nStoerste element " + resultat);
		else
			System.out.println("Treet er tomt");

		// ****************************************************************************
		
		
		
		System.out.println("\nHoyden i treet er: " + bs.finnHoyde());
		System.out.println("Antall: " + bs.antall());
		System.out.println("Treet er nå: ");
		//bs.visInorden();
		bs.visPreorden();

	}
}// class