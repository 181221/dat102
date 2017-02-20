package no.hib.dat102.klient;

import no.hib.dat102.koe.adt.TabellKoe;
import no.hib.dat102.modell.Person;

public class PersonKoeKlient {
	public static void main(String[] args) {
		TabellKoe<Person> koe = new TabellKoe<Person>();
		Person p0 = new Person("Peder", "Aalen", 1993);
		Person p1 = new Person("Cecilie", "Valdivia", 1995);
		Person p2 = new Person("Halvor", "Aalen", 1996);
		Person p3 = new Person("Thea", "Wiig", 1990);

		koe.innKoe(p0);
		koe.innKoe(p1);
		koe.innKoe(p2);
		koe.innKoe(p3);

		System.out.println(koe.utKoe().toString());
		System.out.println(koe.utKoe().toString());
		System.out.println(koe.utKoe().toString());
		System.out.println(koe.utKoe().toString());
		if (koe.erTom()) {
			System.out.println("ingen elementer i koen: ");
		}
	}
}
