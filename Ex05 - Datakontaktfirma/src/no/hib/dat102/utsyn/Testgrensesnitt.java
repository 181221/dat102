package no.hib.dat102.utsyn;

import no.hib.dat102.modell.Datakontakt;
import no.hib.dat102.modell.Medlem;

public class Testgrensesnitt {
	
	// leser opplysningene om et medlem fra tastatur
	public static Medlem lesMedlem() {
		//TODO
		System.out.println("metode ikke implementert");
		return null;
	}
	

	// skriver ut hobbylisten for et medlem
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene ");
		System.out.println((medlem).getHobby().toString());
		//TODO
	}

	/**
	 * skriver ut på skjermen en oversikt over medlemmer som er koblet til
	 * hverandre i medlemstabellen til enhver tid. Et slikt par skal kun vises
	 * én gang på utskriftlisten. Metoden skriver også ut antall par som er
	 * funnet. Eksempel på utskrift: PARNAVN HOBBYER Erna og Jonas <ski>
	 * <musikk> <politikk> Eva og Adam <epleplukking> <paradishopping> …………………….
	 * Antall par funnet: 12
	 * 
	 * @param arkiv
	 */
	public static void skrivParListe(Datakontakt arkiv) {
		//TODO
		System.out.println("Metode ikke implementert");
	}

}
