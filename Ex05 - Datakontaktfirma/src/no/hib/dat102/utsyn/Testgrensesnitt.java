package no.hib.dat102.utsyn;

import java.util.Iterator;
import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.modell.Hobby;
import no.hib.dat102.modell.Medlem;
import java.util.Scanner;

import no.hib.dat102.modell.Datakontakt;

public class Testgrensesnitt {
	private static Scanner sc;

	// leser opplysningene om et medlem fra tastatur
	public static Medlem lesMedlem() {
		sc = new Scanner(System.in);

		System.out.print("Navn: ");
		String navn = sc.nextLine();

		System.out.print("StatusIndex: ");
		int index = sc.nextInt();

		Medlem medlem = new Medlem(navn, index);
		return medlem;
	}

	// skriver ut hobbylisten for et medlem
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene ");
		MengdeADT<Hobby> hobby = medlem.getHobby();
		Iterator<Hobby> teller = hobby.oppramser();

		while (teller.hasNext()) {
			System.out.println(teller.next().getHobbyNavn().toString());
		}

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
		Medlem[] k = arkiv.getMedlemmer();
		KjedetMengde<Integer> tall = new KjedetMengde<Integer>();
		
		int j = 0;
		int teller = 0;

		for (int i = 0; i < k.length; i++) {
			while (k[i].getStatusIndeks() != -1) {
				if (k[i] != null && arkiv.finnPartnerFor(k[i]) == k[i].getStatusIndeks()) {
					tall.leggTil(arkiv.finnMedlemsIndeks(k[i]));
					tall.leggTil(arkiv.finnMedlemsIndeks(k[i]));
				}
			}
		}
		System.out.println("Antall par funnet: " + teller);
		for (int i = 0; i < tall.antall(); i++) {
			System.out.println("PARNAVN HOBBYER " + k[i].getNavn() + " og " + k[i + 1].getNavn() + k[i].getHobby().toString());
		}
	}
}
