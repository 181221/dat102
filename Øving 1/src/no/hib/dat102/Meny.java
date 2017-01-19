package no.hib.dat102;

import java.util.Scanner;

import no.hib.data102.adt.CDarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private CDarkivADT cda;
	private int valg;

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
		Scanner sc = new Scanner(System.in);
		hovedMeny(sc);
	}
	public void hovedMeny(Scanner tast){
		
		String meny = "\n1 - Skrive nytt arkiv" + "\n2 - Fortsette på arkviv fra fil" + "\n3 - Avslutt for å lagre" +"\n\nValg: " ;
		
		do{
			System.out.print(meny);
			valg = tast.nextInt();
			switch(valg){
			case 1: 
				OpprettNyttArkiv(tast);
				break;
			case 2:
				BrukEksisterendeArkivMeny(tast);
				break;
			case 3:
				break;
			default:
				System.out.println("Ukjent menyvalg");
				}
			}
			while(valg != 3);
		
	}
	public void ArkivValg(Scanner tast){
		String meny = "\n1 - Legg til CD \n2 - Slett CD \n3 - Sok paa Tittel \n4 - Sok paa Artist \n5 - SkrivUtStatistikk \n6 - Avslutt for å lagre  ";
		do{
			System.out.print(meny);
			valg = tast.nextInt();
			switch(valg){
			case 1: 
				cda.leggTilCd(tekstgr.lesCD());  //skriver inn CD-info
				break;
			case 2:
				//søker på cdnummer og sletter
				System.out.print("Oppgi cd nummer");
				int nr = tast.nextInt();
				cda.slettCd(nr);
				break;
			case 3:
				//søker på tittel
				System.out.print("Søk på tittel: ");
				String delstreng = tast.next();
				tekstgr.skrivUtCdDelstrengITittel(cda, delstreng);
				break;
			case 4:
				//søker på artist
				System.out.print("Søk på artist: ");
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
	public void OpprettNyttArkiv(Scanner tast){
		
		System.out.print("Oppgi navn på arkiv: ");
		String navnPaaArkiv = tast.next();
		
		System.out.print("Hvor stort er arkivet?   (heltall)");
		int MAX = tast.nextInt();
		CDarkiv akriv = new CDarkiv(MAX);
		
		ArkivValg(tast);
		Fil.skrivTilFil(cda, navnPaaArkiv + ".txt");
		
	}
	public void BrukEksisterendeArkivMeny(Scanner tast){
		
		System.out.print("Oppgi fil på arkiv: ");
		String filnavn = tast.next();
		cda = Fil.lesFraFil(filnavn + ".txt");
		
		
		ArkivValg(tast);
		
		Fil.skrivTilFil(cda, filnavn +".txt");
		
		
	}
}// class
