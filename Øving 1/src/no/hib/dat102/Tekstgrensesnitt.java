package no.hib.dat102;

import java.util.*;

import no.hib.data102.adt.CDarkivADT;

public class Tekstgrensesnitt {
	// lese opplysningene om en CD fra tastatur
	public CD lesCD() {
		Scanner sc = new Scanner(System.in);
		int cdNummer = sc.nextInt();
		String artist = sc.nextLine();
		String tittel = sc.nextLine();
		int aar = sc.nextInt();
		Sjanger sjanger = Sjanger.finnSjanger(sc.nextInt());
		String plateselskap = sc.nextLine();

		CD nycd = new CD(cdNummer, artist, tittel, aar, sjanger, plateselskap);
		// lage et nytt cd objekt?
		sc.close(); // lukke
		return nycd;
	}

	// vise en CD med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visCD(CD cd) {
		cd.toString();

	}

	// Skrive ut alle CD-er med en spesiell delstreng i tittelen
	public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng) {
		cda.sokTittel(delstreng).toString();
	}

	// Skriver ut alle CD-er av en artist / en gruppe
	public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
		cda.sokArtist(delstreng).toString();

	}

	// Skrive ut en enkel statistikk som inneholder antall CD-er totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(CDarkivADT cda) {
		System.out.println("Antall CD'er i arkivet: " + cda.hentAntall());
		System.out.println("Antall CD'er med sjangeren Rock: " + cda.hentAntall(Sjanger.finnSjanger("rock")));
		System.out.println("Antall CD'er med sjangeren Pop: " + cda.hentAntall(Sjanger.finnSjanger("pop")));
		System.out.println("Antall CD'er med sjangeren Opera: " + cda.hentAntall(Sjanger.finnSjanger("opera")));
		System.out.println("Antall CD'er med sjangeren Classic: " + cda.hentAntall(Sjanger.finnSjanger("classic")));
	}

	// … Ev. andre metoder

}
