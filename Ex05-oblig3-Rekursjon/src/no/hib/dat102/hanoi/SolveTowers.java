package no.hib.dat102.hanoi;

public class SolveTowers {

	/**
	 * Lager ett TowersOfHanoi spill og l�ser det
	 * @param args
	 */
	public static void main (String[] args ) {
		TowersOfHanoi towers = new TowersOfHanoi(30);
		towers.solve();
	}
}