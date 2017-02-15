package no.hib.dat102.mengde.klient;

import java.util.Scanner;

import no.hib.dat102.mengde.tabell.TabellIterator;
import no.hib.dat102.mengde.tabell.TabellMengde;

public class TabellKlient {
	public static void main(String[] args) {
		final int ANTALL = 5;
		TabellMengde<String> ordliste1 = new TabellMengde<String>(ANTALL);
		TabellMengde<String> ordliste2 = new TabellMengde<String>(ANTALL);
		TabellMengde<String> unionen = new TabellMengde<String>(ordliste1.antall() + ordliste2.antall());

		String AvsluttOrd = "zzz";

		System.out.println("skriv inn 5 ord:.. Avslutt med 'zzz'");
		Scanner sc = new Scanner(System.in);
		String LeggTilOrd = "";
		int teller = 1;

		while (teller <= ANTALL && !LeggTilOrd.equals(AvsluttOrd)) {
			LeggTilOrd = sc.nextLine();
			ordliste1.leggTil(LeggTilOrd);
			System.out.println("Antall elementer i mengde1: " + ordliste1.antall());
			teller++;

		}

		System.out.println();
		System.out.println("Ord registrert i mengde1 = " + ordliste1.antall());
		System.out.println();

		teller = 1;
		LeggTilOrd = "";
		System.out.println("skriv inn ord for å se om det ligger i listen - avslutt med 'zzz'");
		while (!LeggTilOrd.equals(AvsluttOrd) && teller <= 5) {
			LeggTilOrd = sc.nextLine();
			ordliste2.leggTil(LeggTilOrd);
			teller++;
			if (ordliste1.inneholder(LeggTilOrd)) {
				System.out.println("ordet eksisterer i listen ");
			} else {
				System.out.println("ordet ligger ikke i listen");
			}
			System.out.println(" Antall elementer i mengde2: " + ordliste2.antall());
		}
		System.out.println();
		unionen = (TabellMengde<String>) ordliste1.union(ordliste2);
		TabellIterator<String> opprams = (TabellIterator<String>) unionen.oppramser();
		System.out.println("Unionen av mengdene er:...");
		teller = 0;
		while (opprams.hasNext()) {
			System.out.println(opprams.next());
			teller++;
		}
		System.out.println();
		System.out.println("Antall ord lagt i unionen = " + teller);
		sc.close();
	}

}
