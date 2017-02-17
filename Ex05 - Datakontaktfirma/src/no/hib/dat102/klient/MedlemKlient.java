package no.hib.dat102.klient;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.modell.Hobby;
import no.hib.dat102.modell.Medlem;

public class MedlemKlient {
	public static void main(String[] args) {
		MengdeADT<Hobby> m1 = new KjedetMengde<Hobby>();
		MengdeADT<Hobby> m2 = new KjedetMengde<Hobby>();
		
		Medlem personEn = new Medlem("Peder",-1);
		Medlem personTo = new Medlem("Gunnar",-1);
		
		Hobby e1 = new Hobby("Musikk");
		Hobby e2 = new Hobby("Spill");
		Hobby e3 = new Hobby("Øl");
		Hobby e4 = new Hobby("Fotball");
		Hobby e5 = new Hobby("Gitar");
		
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		
		m2.leggTil(e5);
		m2.leggTil(e2);
		
		personEn.setHobby(m1);
		personTo.setHobby(m2);
		
		System.out.println();
		
		
		
		
		
		
	}

}
