package no.hib.dat102.utsyn;

import java.util.Scanner;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.modell.Medlem;

public class Meny {
	private Testgrensesnitt tekstgr;
	private MengdeADT<Medlem> cda;
	private int valg;
	private Scanner tast;
	private String meny;
	
	public Meny(MengdeADT<Medlem> cda){
		tekstgr = new Testgrensesnitt();
		this.cda = cda;
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
	public void start(){
		tast = new Scanner(System.in);
		hovedMeny();
		tast.close();
	}
	public void hovedMeny(){
		//TODO
	}

}
