package no.hib.dat102;

import java.util.Scanner;

import no.hib.data102.adt.CDarkivADT;
import no.hib.data102.adt.CDarkivEgenADT;

public class Tekstgrensesnitt {
	private Scanner sc;

	/**
	 * lese opplysningene om en CD fra tastatur
	 * 
	 * @return
	 */
	public CD lesCD() {
		sc = new Scanner(System.in);

		System.out.print("CdNummer: ");
		int cdNummer = sc.nextInt();

		System.out.print("Artist: ");
		String artist = sc.next();

		System.out.print("Tittel: ");
		String tittel = sc.next();

		System.out.print("Aar: ");
		int aar = sc.nextInt();

		System.out.print("Sjanger: ");
		Sjanger sjanger = Sjanger.finnSjanger(sc.next());

		System.out.print("PlateSelskap: ");
		String plateselskap = sc.next();

		CD nycd = new CD(cdNummer, artist, tittel, aar, sjanger, plateselskap);

		return nycd;
	}

	/**
	 * skriver ut CD med alle opplysninger på skjerm (husk tekst for sjanger)
	 * 
	 * @param cd
	 *            -ref til CDklassen
	 */
	public void visCD(CD cd) {
		System.out.println(cd.toString());

	}

	/**
	 * Skrive ut alle CD-er med en spesiell delstreng i tittelen
	 * 
	 * @param cda
	 *            - interfacet med alle metoder.
	 * @param delstreng
	 *            - søkeordet.
	 */
	public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng) {
		CD[] samling = cda.sokTittel(delstreng);

		// til arkiv 1
		// System.out.println("søker etter..."+ " "+delstreng);
		//
		// if(cda.eksisterer(samling)){
		// System.out.println("Finner: " + (samling.length-1) + " tittel(er)" +"
		// med søkeord: "+ delstreng);
		// }else if (!cda.eksisterer(samling)){
		// System.out.println("Ingen resultater på " + delstreng);
		// }
		boolean tom = false;
		System.out.println("søker etter tittl(er) med søkeord... " + "'" + delstreng + "'");
		for (int i = 0; i < samling.length; i++) {
			if (samling[i] != null) {
				System.out.println(samling[i].getTittel().toString());
				tom = false;
			} else if (samling[i] == null) {
				tom = true;
			}
		}
		if (tom) {
			System.out.println("ingen tittl(er) med delstreng: " + delstreng);
		}

	}

	/**
	 * Søker etter artist og skrive ut.
	 * 
	 * @param cda
	 *            - cdArkiv tabbel
	 * @param delstreng
	 *            - Søkeord
	 */
	public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
		CD[] samling = cda.sokArtist(delstreng);

		// til cdarkiv 1.
		// System.out.println("søker etter artist(er) med søkeord... "+
		// "'"+delstreng+"'");
		//
		// if(cda.eksisterer(samling)){
		// System.out.println("Finner: " + (samling.length-1) + " Artist(er)" +"
		// med søkeord: "+ delstreng);
		// }else if (!cda.eksisterer(samling)){
		// System.out.println("Ingen resultater på " + delstreng);
		// }
		boolean tom = false;
		System.out.println("søker etter artist(er) med søkeord... " + "'" + delstreng + "'");
		for (int i = 0; i < samling.length; i++) {
			if (samling[i] != null) {
				System.out.println(samling[i].toString());
			} else if (samling[i] == null) {
				tom = true;
			}
		}
		if (tom) {
			System.out.println("ingen tittl(er) med delstreng: " + delstreng);
		}

	}

	/**
	 * Skrive ut en enkel statistikk som inneholder antall CD-er totalt og hvor
	 * mange det er i hver sjanger
	 * 
	 * @param cda
	 */
	public void skrivUtStatistikk(CDarkivADT cda) {
		System.out.println("Antall CD'er i arkivet: " + cda.hentAntall());
		System.out.println("Antall CD'er med sjangeren Rock: " + cda.hentAntall(Sjanger.finnSjanger("rock")));
		System.out.println("Antall CD'er med sjangeren Pop: " + cda.hentAntall(Sjanger.finnSjanger("pop")));
		System.out.println("Antall CD'er med sjangeren Opera: " + cda.hentAntall(Sjanger.finnSjanger("opera")));
		System.out.println("Antall CD'er med sjangeren Classic: " + cda.hentAntall(Sjanger.finnSjanger("classic")));

		// for(Sjanger s : Sjanger.values()){
		// System.out.println("Antall CD'er med sjangeren "+s.name()+": " +
		// cda.hentAntall(Sjanger.finnSjanger(s.name())));
		// }
	}

}
