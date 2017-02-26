package no.hib.dat102.utsyn;

import no.hib.dat102.modell.Balansering;

public class BalanseringKlient {
	public static void main(String[] args) {
		Balansering fil = new Balansering();
		fil.lesFraFil("balanse.txt");
	}

}
