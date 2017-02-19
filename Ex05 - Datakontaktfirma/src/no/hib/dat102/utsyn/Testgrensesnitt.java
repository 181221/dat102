package no.hib.dat102.utsyn;

import java.util.Iterator;
import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.modell.Hobby;
import no.hib.dat102.modell.Medlem;
import no.hib.dat102.modell.Datakontakt;
import java.util.Scanner;

import no.hib.dat102.modell.Datakontakt;

public class Testgrensesnitt {
	private static Scanner sc;
	private static int valg;
	private static Datakontakt tab;
	private static MengdeADT<Hobby> cda;
	private static MengdeADT<Medlem> pers;

	public Testgrensesnitt(Datakontakt tab) {
		sc = new Scanner(System.in);
		this.tab = tab;
		pers = new KjedetMengde();
	}

	// leser opplysningene om et medlem fra tastatur
	public static Medlem lesMedlem() {
		System.out.print("Navn: ");
		String navn = sc.next();

		System.out.println("Status index");
		int index = sc.nextInt();

		Medlem medlem = new Medlem(navn, index);
		cda = new KjedetMengde<Hobby>();
		cda = lesHobby();

		medlem.setHobby(cda);

		return medlem;
	}

	public static MengdeADT<Hobby> lesHobby() {
		cda = new KjedetMengde<Hobby>();
		Hobby hobby = null;
		System.out.println("skriv inn hobby..  Avslutt med zzz");
		String h = sc.next();
		do {
			hobby = new Hobby(h);
			cda.leggTil(hobby);
			h = sc.next();
		} while (!h.equals("zzz"));
		return cda;

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

	public static Medlem finnMedlem(String medlem) {
		Medlem k = null;
		boolean funnet = false;
		if (!tab.erTom()) {
			Medlem[] medlemmer = tab.getMedlemmer();
			for (int i = 0; i < medlemmer.length && !funnet; i++) {
				if (medlemmer[i] != null && medlemmer[i].getNavn().equals(medlem)) {
					k = medlemmer[i];
					funnet = true;
				}
			}
		} else {
			System.out.println("tab er tom ");

		}
		return k;
	}

	public static MengdeADT<Medlem> LeggTilMedlemmerMedLikStatusIndex() {
		Medlem[] k = tab.getMedlemmer();
		boolean par = false;
		int lengden = k.length - 1;
		for (int i = 0; i < k.length && !par; i++) {
			for (int j = lengden; j >= 0 && !par; j--) {
				if (k[i] != null && k[j] != null && k[i].getStatusIndeks() != -1
						&& k[i].getStatusIndeks() == k[j].getStatusIndeks()) {
					pers.leggTil(k[i]);
					pers.leggTil(k[j]);
					par = true;
				}
			}
		}
		if (pers.antall() % 2 != 0) {
			pers.fjernTilfeldig();
		}

		return pers;
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
		if (arkiv.getAntallMedlemmer()<1) {
			System.out.println("tabellen er tom");
			return;
		}
		Medlem[] k = arkiv.getMedlemmer();
		boolean funnet = false;

		for (int i = 0; i < k.length; i++) {
			int passerPar = arkiv.finnPartnerFor(k[i]);
			for (int j = k.length - 1; j >= 0 && passerPar != -1; j--) {
				if (k[j] != null && k[j].getStatusIndeks() == passerPar) {
					pers.leggTil(k[i]);
					pers.leggTil(k[j]);
					funnet = true;
				}
			}
		}
		if (pers.antall() % 2 != 0) {
			pers.fjernTilfeldig();
		}
		Iterator<Medlem> teller = pers.oppramser();
		while (teller.hasNext()) {
			Medlem person1 = teller.next();
			Medlem person2 = teller.next();
			System.out.println(person1.getNavn() + " " + person2.getNavn() + " " + person1.getHobby());
		}
	}
}
