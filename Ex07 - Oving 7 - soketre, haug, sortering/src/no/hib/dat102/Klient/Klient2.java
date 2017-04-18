package no.hib.dat102.Klient;

import java.util.Random;

import no.hib.dat102.KjedetBinearSokeTre;

public class Klient2 {
	
	private static Random r;
	private static final int ANTALL_NODER = 1024;
	private static final int ANTALL_TRE = 100;
	
	public static void main(String[] args) {
		r = new Random();
		Integer c = 100;

		KjedetBinearSokeTre<Integer>[] bsTab = new KjedetBinearSokeTre[c];
		Double MinimalTeoretiskHoyde = (Math.log(ANTALL_NODER+1) / Math.log(2))-1;
		int[] hoydeTab = new int[ANTALL_TRE];
		//Lager 100 tre med 1024 noder hver. Summerer hoyden.
		int sum = 0;
		
		int hoyde = 0;
		for (int i = 0; i < ANTALL_TRE; i++) {
			bsTab[i] = new KjedetBinearSokeTre<Integer>();
			for(int k = 0; k < ANTALL_NODER;k++){
				Integer tilfeldigTall = new Integer(r.nextInt(10000));
				bsTab[i].leggTil(tilfeldigTall);

			}
			hoyde = bsTab[i].finnHoyde()-1;
			sum += hoyde;
			hoydeTab[i] = hoyde;
		}
		//går gjennom hoydetab
		int minste = hoydeTab[0];
		for(int i = 1; i < hoydeTab.length;i++){
			if(hoydeTab[i] < minste){
				minste = hoydeTab[i];
			}
		}
		int stoerste = hoydeTab[0];
		for(int i = 1; i < hoydeTab.length;i++){
			if(hoydeTab[i] > stoerste){
				stoerste = hoydeTab[i];
			}
		}
		
		System.out.println("Antall Noder: " + ANTALL_NODER);
		
		System.out.println("\nTeoretisk Hoyde: " + Math.round(MinimalTeoretiskHoyde));
		
		System.out.println("\nTeoretisk MiniMalHoyde: " + (ANTALL_NODER-1));
		
		System.out.println("\nSnitt hoyden: " + sum/ANTALL_TRE);
		
		System.out.println("\nMinste hoyde: " + minste);
		
		System.out.println("\nStoerste hoyde " + stoerste);
	}
	
	
}
