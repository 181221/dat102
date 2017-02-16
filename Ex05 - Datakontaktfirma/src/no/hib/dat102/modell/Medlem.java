package no.hib.dat102.modell;

import no.hib.dat102.mengde.adt.MengdeADT;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobby;
	private int statusIndeks;
	
	public Medlem(){
		this("",null,-1);
	}

	public Medlem(String navn, MengdeADT<Hobby> hobby, int statusIndeks) {
		this.navn = navn;
		this.hobby = hobby;
		this.statusIndeks = statusIndeks;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobby() {
		return hobby;
	}

	public void setHobby(MengdeADT<Hobby> hobby) {
		this.hobby = hobby;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

	/**
	 * avgjør om to medlemmer passer til hverandre og
	 * altså kan danne et par. To medlemmer passer til hverandre dersom de har nøyaktig samme hobbyer
	 * @param medlem2
	 */
	public void passerTil(Medlem medlem2){
		
		System.out.println("Metode ikke implementert");
	}
	

}
