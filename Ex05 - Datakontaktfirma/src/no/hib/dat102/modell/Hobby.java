package no.hib.dat102.modell;

public class Hobby {
	private String hobbyNavn;

	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}
	public Hobby(){
		this("");
	}

	public void setHobbyNavn(String n) {
		hobbyNavn = n;
	}

	public String getHobbyNavn() {
		return hobbyNavn;
	}

	@Override
	public String toString() {
		return "Hobbynavn: " +"          < "+hobbyNavn+" >";
	}
	/**
	 * Tester om objektene er like. 
	 */
	@Override
	public boolean equals(Object hobby2) { //
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}

}
