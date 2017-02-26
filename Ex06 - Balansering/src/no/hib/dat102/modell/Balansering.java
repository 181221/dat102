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
	private boolean erApent(char aapent){
		switch (aapent) {
		case '(':
			return true;
		case '[':
			return true;
		case '{':
			return true;
		default:
			return false;
		}
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
	}//
		// -----------------------------------------
		//
		// Balansering av uttrykk med parenteser {},(),[]
		// } ] ) kalles lukkete symboler (høyre)
		// { [ ( kalles for åpne symboler (venstre)
		// ...{... [...(...)...]...}... lovlig (balansert) utrykk
		// ...{...(...[...)...]...}... ulovlig (ikke balansert) uttrykk
		// algoritme balansering
		// Lag en tom stabel
		// så lenge( ikke-slutt på strengen og fortsatt balansert){
		// hvis symbolet er åpent
		// stable det på
		// ellers hvis symbolet er lukket
		// hvis stabelen er tom
		// sett fortsatt = usann, feilmelding
		// ellers
		// stable av symbol (åpent symbol)
		// hvis det åpne symbolet ikke svarer til det sist leste
		// lukkete symbolet
		// sett fortsatt = usann, feilmelding
		// }
		// hvis stabelen er ikke-tom så feilmelding */

	public void foretaBalansering(String innDataStreng, int linjenr) {
		int lengde = innDataStreng.length();
		boolean balansert = true;
		KjedetStabel<Parentesinfo> test = new KjedetStabel<Parentesinfo>();
		int k = 0;
		while (k < lengde && balansert) {
			if (innDataStreng.contains(")")||innDataStreng.contains("}")||innDataStreng.contains("]")) {
				Parentesinfo lol = new Parentesinfo(-1,k,innDataStreng.charAt(k));
				test.push(lol);
			}else if(stabel.erTom() ){
					balansert = false;
				}else{ 
					Parentesinfo informasjon = stabel.pop();
					if(!passer(test.pop().getVenstreparentes(),informasjon.getVenstreparentes())){
						System.out.println("Parentes er ikke lukket på linje nr " + informasjon.getPosisjon());
						balansert = false;
					}
				}
			}
		
		if(!stabel.erTom()){
			System.out.println("feil");
		}
		if(balansert){
			System.out.println("er balansert");
		}

	}//

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ike filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		try {
			int linjenr = tekstLeser.read();
			linje = tekstLeser.readLine();
			while (linje != null) {
				linje += tekstLeser.readLine();
				linjenr++;
				for(int i = 0; i < linje.length();i++){
					if(linje.contains("(")||linje.contains("{")||linje.contains("[")){
						Parentesinfo setning = new Parentesinfo(linjenr,i,linje.charAt(i));
						stabel.push(setning);
					}
				}
			} // while
			foretaBalansering(linje,0);
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}// metode

}// class
