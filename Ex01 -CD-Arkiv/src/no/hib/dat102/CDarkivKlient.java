package no.hib.dat102;

import no.hib.data102.adt.CDarkivADT;

public class CDarkivKlient {
	public static void main(String[] args) {
		// … meny
		CDarkivADT cda = new CDarkiv2();
		Meny meny = new Meny(cda);
		meny.start();
	}

}
