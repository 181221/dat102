/**
 * 
 */
package no.hib.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hib.dat102.*;
import no.hib.data102.adt.CDarkivADT;

/**
 * @author Peder Aalen
 * 
 */
public class Fil {
	private static final String SKILLE = "#";
	

	/**
	 * @param filnavn
	 * @return Referansen til CD-arkivet
	 * @throws java.io.IOException
	 */
	public static CDarkivADT lesFraFil(String filnavn) {

		CDarkivADT cda = null;

		try {
			// // 1 - FileReader
			FileReader ansFil = new FileReader(filnavn);

			// 2 - BufferedReader
			BufferedReader innfil = new BufferedReader(ansFil);

			// 3 - Leser den f�rste posten som er antall info-poster
			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);

			// Oppretter CDarkiv
			cda = new CDarkiv(n);

			// 4 - Les postene, en hel post om gangen
			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int nr = Integer.parseInt(felt[0]);
				String artist = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				Sjanger sj = Sjanger.finnSjanger(felt[4]);
				String plselskap = felt[5];
				
				CD cd = new CD(nr, artist, tittel, aar, sj, plselskap);

				cda.leggTilCd(cd);
			}

			// 4 - Lukk filen
			innfil.close();

		} catch (FileNotFoundException unntak) {// arver fra IOException m� st�
												// f�rst
												// hvis ikke vil unntaket for
												// IOException skygge
			System.out.println("Finner ikke filen " + filnavn);
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
		}

		return cda;
	}

	public static void skrivTilFil(CDarkivADT cdarkiv, String filnavn) {
		int antall = cdarkiv.hentAntall();
		try {
			FileWriter CDFil = new FileWriter(filnavn);
			PrintWriter utfil = new PrintWriter(CDFil);

			utfil.println(antall);
			for (int i = 0; i < antall; i++) {
				utfil.print(cdarkiv.hentCdTabell()[i].getCdNummer());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCdTabell()[i].getArtist());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCdTabell()[i].getTittel());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCdTabell()[i].getAar());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCdTabell()[i].getSjanger());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCdTabell()[i].getPlateselskap());
				utfil.println();
			}
			utfil.close();

		} catch (IOException e) {
			System.err.println("Feil! : " + e);
			System.exit(1);
		}
	}
}// class
