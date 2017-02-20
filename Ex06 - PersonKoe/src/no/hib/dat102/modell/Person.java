package no.hib.dat102.modell;

public class Person implements Comparable<Person> {

	private String fornavn;
	private String etternavn;
	private int aar;

	public Person(String f, String e, int a) {
		fornavn = f;
		etternavn = e;
		aar = a;
	}

	Person() {
		this("", "", 1900);
	}

	/**
	 * @return the fornavn
	 */
	public String getFornavn() {
		return fornavn;
	}

	/**
	 * @param fornavn
	 *            the fornavn to set
	 */
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	/**
	 * @return the etternavn
	 */
	public String getEtternavn() {
		return etternavn;
	}

	/**
	 * @param etternavn
	 *            the etternavn to set
	 */
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	/**
	 * @return the aar
	 */
	public int getAar() {
		return aar;
	}

	/**
	 * @param aar
	 *            the aar to set
	 */
	public void setAar(int aar) {
		this.aar = aar;
	}

	@Override
	public String toString() {
		return "Person:  " + aar + "  " + etternavn + ", " + fornavn;
	}

	@Override
	public int compareTo(Person denAndre) {
		Person p2 = denAndre;
		int verdi = -1;
		if (this.aar == denAndre.getAar()) {
			verdi = this.etternavn.compareTo(p2.getEtternavn());
			if (verdi == 0) {
				verdi = this.fornavn.compareTo(p2.getFornavn());
			}
		}else if (this.aar > p2.getAar()){
			verdi = 1;
		}

		return verdi;
	}

}
