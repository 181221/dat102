package no.hib.dat102.hanoi;

import java.util.Date;

public class TowersOfHanoi {
	private int totalDisks;
	private long flyttinger;

	/**
	 * Setter opp spillet med spesifisert nummer av ringer
	 * 
	 * @param disks
	 *            Antall ringer spillet skal bruke
	 */
	public TowersOfHanoi(int disks) {
		totalDisks = disks;
	}

	/**
	 * Gj�r ett initierende kall p� metoden moveTowers() for � l�se spillet.
	 * Flytter ringene fra t�rn 1 til t�rn 3, ved � bruke t�rn 2 som hjelpe t�rn
	 */
	public void solve() {
		Date tid_i_millisekunder_f�r = new Date();
		long f�r = tid_i_millisekunder_f�r.getTime();
		moveTower(totalDisks, 1, 3, 2);
		Date tid_i_millisekunder_etter = new Date();
		long etter = tid_i_millisekunder_etter.getTime();
		double tid_brukt = ((etter - f�r));
		System.out.println("Tid: " + tid_brukt);
		System.out.println("Antall flyttinger: " + flyttinger);
	}

	/**
	 * Flytter spesifisert antall ringer fra ett t�rn til ett annet, ved �
	 * flytte et subt�rn av n - 1 ringer ut av veien, flytte en ring, og flytte
	 * subt�rnet tilbake. Base case er 1 ring.
	 * 
	 * @param numDisks
	 *            Antall ringer som skal flyttes
	 * @param start
	 *            start t�rn
	 * @param end
	 *            slutt t�rn
	 * @param temp
	 *            det midlertidige t�rnet
	 */
	private void moveTower(int numDisks, int start, int end, int temp) {
		if (numDisks == 1) {
			moveOneDisk(start, end);
		} else {
			moveTower(numDisks - 1, start, temp, end);
			moveOneDisk(start, end);
			moveTower(numDisks - 1, temp, end, start);
		}
	}

	/**
	 * Skriver ut instruksjoner for � flytte en ring fra spesifisert start t�rn
	 * til spesifisert slutt t�rn.
	 * 
	 * @param start
	 *            start t�rn
	 * @param end
	 *            slutt t�rn
	 */
	private void moveOneDisk(int start, int end) {
		flyttinger++;
	}
}