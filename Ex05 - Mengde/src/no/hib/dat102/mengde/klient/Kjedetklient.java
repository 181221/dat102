package no.hib.dat102.mengde.klient;
import no.hib.dat102.mengde.kjedet.*;
import no.hib.dat102.mengde.tabell.TabellIterator;
import no.hib.dat102.mengde.tabell.TabellMengde;
import no.hib.dat102.mengde.adt.*;
//********************************************************************
//Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

public class Kjedetklient {
	public static void main(String[] args) {
		final int ANTALL = 5;
		KjedetMengde<String> ordliste1 = new KjedetMengde<String>();
		KjedetMengde<String> ordliste2 = new KjedetMengde<String>();
		KjedetMengde<String> unionen = new KjedetMengde<String>(); //mindre effektivt
		KjedetMengde<String> unionEff = new KjedetMengde<String>(); //effektiv endre antall...
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
		
		
		/*
		 * algoritmer for å effektivisere unionen 
		 */
		unionen = (KjedetMengde<String>) ordliste1.union(ordliste2); //legger elementer i m1 og m2 sammen
//		unionEff.leggTilAlle(ordliste1);
//		unionEff.leggTilAlle(ordliste2);
		
		KjedetIterator<String> opprams = (KjedetIterator<String>) unionen.oppramser();
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

