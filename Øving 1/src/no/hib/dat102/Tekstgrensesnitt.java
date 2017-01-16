package no.hib.dat102;
import java.util.*;

import no.hib.data102.adt.CDarkivADT;
public class Tekstgrensesnitt {
	// lese opplysningene om en CD fra tastatur
	 public CD lesCD(){
		 Scanner sc = new Scanner(System.in);
		 int cdNummer = sc.nextInt();
		 String artist = sc.nextLine();
		 String tittel = sc.nextLine();
		 int aar = sc.nextInt();
		 int sjanger = sc.nextInt();
		 String plateselskap = sc.nextLine();
		 
		 //lage et nytt cd objekt?
		return null;
		 
	 }
	// vise en CD med alle opplysninger på skjerm (husk tekst for sjanger)
	 public void visCD(CD cd){
		 cd.toString();
		 
	 }
	// Skrive ut alle CD-er med en spesiell delstreng i tittelen
	 public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng){
		 
	 }
	// Skriver ut alle CD-er av en artist / en gruppe
	 public void skrivUtCdArtist(CDarkivADT cda) {
		 
	 }
	// Skrive ut en enkel statistikk som inneholder antall CD-er totalt
	// og hvor mange det er i hver sjanger
	 public void skrivUtStatistikk(CDarkivADT cda){
		 
	 }
	//… Ev. andre metoder

}
