package no.hib.dat102;

import java.util.*;
import no.hib.data102.adt.CDarkivADT;

public class Tekstgrensesnitt {
	// lese opplysningene om en CD fra tastatur
	public CD lesCD() {
		Scanner sc = new Scanner(System.in);
		
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
		// lage et nytt cd objekt?
		
		return nycd;
	}

	// vise en CD med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visCD(CD cd) {
		System.out.println(cd.toString());

	}

	// Skrive ut alle CD-er med en spesiell delstreng i tittelen
	public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng) {
		CD[] samling = cda.sokTittel(delstreng);
		for (int i = 0; i < samling.length; i++) {
			System.out.println(samling[i].getTittel().toString());
		}

	}

	// Skriver ut alle CD-er av en artist / en gruppe
	public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
		CD[] samling = cda.sokArtist(delstreng);
		
		System.out.println("CD-er av " + samling[0].getArtist()+"\n");
		for (int i = 0; i < samling.length; i++) {
			System.out.println(samling[i].toString());
		}

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
