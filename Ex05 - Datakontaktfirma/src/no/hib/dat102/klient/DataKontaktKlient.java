package no.hib.dat102.klient;

import java.util.Iterator;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.modell.Datakontakt;
import no.hib.dat102.modell.Hobby;
import no.hib.dat102.modell.Medlem;
import no.hib.dat102.utsyn.Testgrensesnitt;

public class DataKontaktKlient {
	public static void main(String[] args) {
		Datakontakt tabell = new Datakontakt();
		Testgrensesnitt lol = new Testgrensesnitt();
		MengdeADT<Hobby> m1 = new KjedetMengde<Hobby>();
		MengdeADT<Hobby> m2 = new KjedetMengde<Hobby>();

		Medlem e1 = new Medlem("Peder", -1);
		Medlem e2 = new Medlem("Cecilie", -1);

		Hobby h1 = new Hobby("Musikk");
		Hobby h2 = new Hobby("Sport");
		Hobby h3 = new Hobby("Loping");
		Hobby h4 = new Hobby("Film");

		m1.leggTil(h1);
		m1.leggTil(h2);

		m2.leggTil(h1);
		m2.leggTil(h2);
		m2.leggTil(h4);
		
		e1.setHobby(m2);
		e2.setHobby(m2);

		tabell.leggTilMedlem(e1);
		tabell.leggTilMedlem(e2);
		

		System.out.println("Parter for " + e1.getNavn() + " " + tabell.finnPartnerFor(e1));
		System.out.println("MedlemsIndex for " + e1.getNavn() + " " + tabell.finnMedlemsIndeks(e1));
		System.out.println("MedlemsIndex for " + e2.getNavn() + " " + tabell.finnMedlemsIndeks(e2));
		System.out.println("Medlem " + e1.getNavn() + " passer til " + e2.getNavn() + " : " + e1.passerTil(e2));
		
		System.out.println("parlistetest");
		Testgrensesnitt.skrivParListe(tabell);
		
		Iterator<Hobby> teller = m1.oppramser();
		while(teller.hasNext()){
			System.out.println(teller.next());
			
		}
	}
	

}
