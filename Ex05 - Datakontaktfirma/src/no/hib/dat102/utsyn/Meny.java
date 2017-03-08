package no.hib.dat102.utsyn;

import java.util.Scanner;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.modell.Datakontakt;
import no.hib.dat102.modell.Medlem;

public class Meny {
	private Testgrensesnitt tekstgr;
	private MengdeADT<Medlem> cda;
	private int valg;
	private Scanner tast;
	private String meny;
	private static Datakontakt tab;

	public Meny() {
		tab = new Datakontakt();
		tekstgr = new Testgrensesnitt(tab);
		cda = new KjedetMengde<Medlem>();
	}

	public Testgrensesnitt getTekstgr() {
		return tekstgr;
	}

	public void setTekstgr(Testgrensesnitt tekstgr) {
		this.tekstgr = tekstgr;
	}

	public MengdeADT<Medlem> getCda() {
		return cda;
	}

	public void setCda(MengdeADT<Medlem> cda) {
		this.cda = cda;
	}

	public void start() {
		tast = new Scanner(System.in);
		hovedMeny();
		tast.close();
	}

	public void hovedMeny() {
		meny = "\n1 - Opprett medlem \n2 - Skriv pariste \n3 - Skriv Hobbyliste \n4 - Avslutt";
		do {
			System.out.print(meny);
			valg = tast.nextInt();
			switch (valg) {
			case 1:
				Medlem medlem = Testgrensesnitt.lesMedlem();
				tab.leggTilMedlem(medlem);
				System.out.println(tab.getAntallMedlemmer());
				break;
			case 2:
				Testgrensesnitt.skrivParListe(tab);
				break;
			case 3:
				System.out.println("Hobby navn: ");
				String person = tast.next();
				Medlem en = tekstgr.finnMedlem(person);
				if (en != null){
					Testgrensesnitt.skrivHobbyListe(en);
					
				}else{
					System.out.println("medlem finnes ikke");
				}
				break;
			default:
				System.out.println("Ukjent meny valg");
			}
		} while (valg != 4);
	}
}
