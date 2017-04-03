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
	 * Gjør ett initierende kall på metoden moveTowers() for å løse spillet.
	 * Flytter ringene fra tårn 1 til tårn 3, ved å bruke tårn 2 som hjelpe tårn
	 */
	public void solve() {
		Date tid_i_millisekunder_før = new Date();
		long før = tid_i_millisekunder_før.getTime();
		moveTower(totalDisks, 1, 3, 2);
		Date tid_i_millisekunder_etter = new Date();
		long etter = tid_i_millisekunder_etter.getTime();
		double tid_brukt = ((etter - før));
		System.out.println("Tid: " + tid_brukt);
		System.out.println("Antall flyttinger: " + flyttinger);
	}

	/**
	 * Flytter spesifisert antall ringer fra ett tårn til ett annet, ved å
	 * flytte et subtårn av n - 1 ringer ut av veien, flytte en ring, og flytte
	 * subtårnet tilbake. Base case er 1 ring.
	 * 
	 * @param numDisks
	 *            Antall ringer som skal flyttes
	 * @param start
	 *            start tårn
	 * @param end
	 *            slutt tårn
	 * @param temp
	 *            det midlertidige tårnet
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
	 * Skriver ut instruksjoner for å flytte en ring fra spesifisert start tårn
	 * til spesifisert slutt tårn.
	 * 
	 * @param start
	 *            start tårn
	 * @param end
	 *            slutt tårn
	 */
	private void moveOneDisk(int start, int end) {
		flyttinger++;
	}
}