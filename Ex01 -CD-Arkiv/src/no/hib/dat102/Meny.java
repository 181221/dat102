package no.hib.dat102;


import java.util.Scanner;

import no.hib.data102.adt.CDarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private CDarkivADT cda;
	private int valg;
	private Scanner tast;

	public Meny(CDarkivADT cda) {
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}

	public Tekstgrensesnitt getTekstgr() {
		return tekstgr;
	}

	public void setTekstgr(Tekstgrensesnitt tekstgr) {
		this.tekstgr = tekstgr;
	}

	public CDarkivADT getCda() {
		return cda;
	}

	public void setCda(CDarkivADT cda) {
		this.cda = cda;
	}
	
	public void start() {
		tast = new Scanner(System.in);
		
		hovedMeny();
		
		tast.close();
	}
	public void hovedMeny(){
		
		String meny = "\n1 - Skrive nytt arkiv" + "\n2 - Fortsette p� arkviv fra fil" + "\n3 - Avslutt for � lagre" +"\n\nValg: " ;
		do{
			System.out.print(meny);
			valg = tast.nextInt();
			switch(valg){
			case 1: 
				OpprettNyttArkiv();
				break;
			case 2:
				BrukEksisterendeArkivMeny();
				break;
			case 3:
				break;
			default:
				System.out.println("Ukjent menyvalg");
				}
			}
			while(valg != 3);
		
	}
	public void ArkivValg(){
		String meny = "\n1 - Legg til CD \n2 - Slett CD \n3 - Sok paa Tittel \n4 - Sok paa Artist \n5 - SkrivUtStatistikk \n6 - Avslutt for � lagre  ";
		do{
			System.out.print(meny);
			valg = tast.nextInt();
			switch(valg){
			case 1: 
				cda.leggTilCd(tekstgr.lesCD());  //skriver inn CD-info
				break;
			case 2:
				//s�ker p� cdnummer og sletter
				System.out.print("Oppgi cd nummer");
				int nr = tast.nextInt();
				if(cda.slettCd(nr)){
					System.out.println("slettet cd med cd'nummer "+ nr);
				}
				break;
			case 3:
				//s�ker p� tittel
				System.out.print("S�k p� tittel: ");
				String delstreng = tast.next();
				tekstgr.skrivUtCdDelstrengITittel(cda, delstreng);
				break;
			case 4:
				//s�ker p� artist
				System.out.print("S�k p� artist: ");
				String dels = tast.next();
				tekstgr.skrivUtCdArtist(cda, dels);
				break;
			case 5:
				//skriver ut statistikk
				tekstgr.skrivUtStatistikk(cda);
				break;
			case 6:
				break;
			default:
				System.out.println("Ukjent menyvalg");
				}
			}
			while(valg != 6);
		
	}
	public void OpprettNyttArkiv(){
		
		System.out.print("Oppgi navn p� arkiv: ");
		String navnPaaArkiv = tast.next();
		ArkivValg();
		Fil.skrivTilFil(cda, navnPaaArkiv + ".txt");
		
	}
	public void BrukEksisterendeArkivMeny(){
		
		System.out.print("Oppgi fil p� arkiv: ");
		String filnavn = tast.next();
		cda = Fil.lesFraFil(filnavn + ".txt");
		ArkivValg();
		
		Fil.skrivTilFil(cda, filnavn +".txt");
		
		
	}
}// class
