package no.hib.dat102.modell;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import no.hib.dat102.KjedetStabel;

public class Balansering {
	private KjedetStabel<Parentesinfo> stabel;
	Parentesinfo info;

	public Balansering() {
		stabel = new KjedetStabel<Parentesinfo>();
		info = new Parentesinfo();
	}

	private boolean passer(char aapent, char lukket) {
		switch (aapent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}

	public void foretaBalansering(String innDataStreng, int linjenr) {
		int lengde = innDataStreng.length();
		boolean balansert = true;
		int k = 0;
		Parentesinfo T;
		Character hallo;

		while (k < lengde && balansert) {

			hallo = innDataStreng.charAt(k);

			if (hallo.equals(')') || hallo.equals('}') || hallo.equals(']')) {
				T = stabel.pop();
				System.out.print(T.getVenstreparentes());
				// System.out.println(hallo);
				System.out.println(innDataStreng.charAt(k));
				if (!passer(T.getVenstreparentes(), innDataStreng.charAt(k))) {
					System.out.println("Parentesfeil på linje.. " + T.getLinjenr() + " posisjon: " + T.getPosisjon());
					balansert = false;
				}
			} else if (stabel.erTom()) {
				// balansert = false;
				System.out.println("filen er balansert");
			}
			System.out.println(balansert);
			k++;
		} // while

		if (balansert) {
			System.out.println("Ingen kompilator feil. Fil er balansert");
		}

	}//

	public void lesFraFil(String filnavn) {
		BufferedReader tekstLeser = null;
		
		Parentesinfo T;
		try {
			tekstLeser = new BufferedReader(new FileReader(filnavn));
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen!");
			System.exit(-1);
		}
		try {
			int linjenr = 0;
			boolean balansert = true;
			for (String linjer = tekstLeser.readLine(); linjer != null && balansert; linjer = tekstLeser.readLine()) {
				for (int i = 0; i < linjer.length(); i++) {
					Character hallo = linjer.charAt(i);
					if (hallo.equals('(') || hallo.equals('[') || hallo.equals('{')) {
						Parentesinfo setning = new Parentesinfo(linjenr, i, linjer.charAt(i));
						stabel.push(setning);
					} else if ((hallo.equals(')') || hallo.equals(']') || hallo.equals('}'))) {
						if (stabel.erTom()) {
							balansert = false;
							System.out.println("feil på Linje:" + (linjenr + 1) + " posisjon " + i);
						} else {
							T = stabel.pop();
							if (!passer(T.getVenstreparentes(), hallo)) {
								System.out.println("Par passer ikke " + "på linjenr " + (linjenr + 1) + " posisjon " + i);
								balansert = false;
							}
						}
					}
				}
				linjenr++;
			} // for
			if(!stabel.erTom()){
				T = stabel.pop();
				System.out.println("feilmelding: parentes ikke lukket på linje " + (linjenr+1) + " på posisjon " + (T.getPosisjon())  );
				balansert = false;
			}
			if (balansert) {
				System.out.println("filen er Balansert");
			}
		} catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}
		

	}// metode

}// class
