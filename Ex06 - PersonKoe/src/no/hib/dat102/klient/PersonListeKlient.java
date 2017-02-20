package no.hib.dat102.klient;

import no.hib.dat102.liste.kjedet.KjedetOrdnetListe;
import no.hib.dat102.modell.Person;

public class PersonListeKlient {
	public static void main(String[] args) {
		KjedetOrdnetListe<Person> liste = new KjedetOrdnetListe<Person>();
		Person p0 = new Person("Peder", "Aalen", 1993);
		Person p1 = new Person("Cecilie", "Valdivia", 1995);
		Person p2 = new Person("Halvor", "Aalen", 1993);
		Person p3 = new Person("Thea", "Wiig", 1990);
		Person p4 = new Person("Gunner", "hegden", 1990);
		Person p5 = new Person("Sissel", "Gro", 1992);

		liste.leggTil(p0);
		liste.leggTil(p1);
		liste.leggTil(p2);
		liste.leggTil(p3);
		liste.leggTil(p4);
		liste.leggTil(p5);
		int antall = liste.antall();

		for (int i = 0; i < antall; i++) {
			System.out.println(liste.fjern(liste.foerste()));
		}

	}

}
