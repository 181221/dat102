package no.hib.dat102.modell;

public class Datakontakt {
	private Medlem[] medlemmer;
	private int antallMedlemmer;
	private static final int STDK = 100;

	/**
	 * Oppretter en tabell med medlemmer
	 * 
	 * @param antall
	 *            angir størrelsen.
	 */
	public Datakontakt(int antall) {
		medlemmer = new Medlem[antall];
		antallMedlemmer = 0;
	}

	public Datakontakt() {
		this(STDK);
	}

	/**
	 * @return en tabell med medlemmer
	 */
	public Medlem[] getMedlemmer() {
		return medlemmer;
	}

	public void setMedlemmer(Medlem[] medlemmer) {
		this.medlemmer = medlemmer;
	}

	public int getAntallMedlemmer() {
		return antallMedlemmer;
	}

	public void setAntallMedlemmer(int antallMedlemmer) {
		this.antallMedlemmer = antallMedlemmer;
	}

	public boolean erTom() {
		return antallMedlemmer == 0;
	}

	private void utvidKapasitet() {
		Medlem[] hjelpetabell = new Medlem[(int) Math.ceil(2 * medlemmer.length)];
		for (int i = 0; i < medlemmer.length; i++) {
			hjelpetabell[i] = medlemmer[i];
		}
		medlemmer = hjelpetabell;
	}

	/**
	 * legger til et nytt medlem i medlemstabellen
	 * 
	 * @param person
	 * 
	 * @return
	 */
	public void leggTilMedlem(Medlem person) {
		if (antallMedlemmer == medlemmer.length) {
			utvidKapasitet();
		}
		medlemmer[antallMedlemmer] = person;
		antallMedlemmer++;
	}

	/**
	 * som finner indeksen til medlemmet i medlemstabellen dersom medlemmet er
	 * registrert, ellers returneres indeks lik -1. (Noen vil kanskje si at vi
	 * denne metoden burde returnerte en referansen slik at vi lettere kunne
	 * bytte ut til annen datastruktur, men det lar vi være)
	 * 
	 * @param medlemsnavn
	 */
	public int finnMedlemsIndeks(Medlem medlemsnavn) {
		int index = -1;
		for(int i = 0; i < antallMedlemmer;i++){
			if(medlemmer[i].getNavn().equals(medlemsnavn.getNavn())){
				index = i;
			}
		}
		return index;
	}

	/**
	 * som finner ut om et medlem (identifisert med medlemsnavn) passer med et
	 * annet medlem (dersom det finnes) i medlemstabellen. Dette medlemmet skal
	 * være det første som passer og ikke er “koblet”. Metoden oppdaterer
	 * medlemstabellen dersom det finner en partner, og returnerer eventuell
	 * indeks til partneren i medlemstabellen (eller -1).
	 * 
	 * @param medlemsnavn
	 */
	public int finnPartnerFor(Medlem medlemsnavn) {
		int koblet = -1;
		int medlemIndex = finnMedlemsIndeks(medlemsnavn);

		for (int i = 0; i < antallMedlemmer && koblet == -1; i++) {
			if (medlemmer[medlemIndex].passerTil(medlemmer[i])) {
				medlemsnavn.setStatusIndeks(medlemIndex);
				medlemmer[i].setStatusIndeks(medlemIndex);
				koblet = i;
			}
		}
		return koblet;
	}

	/**
	 * som oppdaterer medlemstabellen, slik at dette medlemmet (identifisert ved
	 * medlemsnavn) og dets partner, dersom det fins, ikke lenger er “koblet”
	 * (dvs. begge får statusindeks –1).
	 * 
	 * @param medlemsnavn
	 */
	public void tilbakestillStausIndeks(Medlem medlemsnavn) {

		int personPar = finnPartnerFor(medlemsnavn); // to personer på returnere index
		int medlemIndex = finnMedlemsIndeks(medlemsnavn);

		if (personPar != -1 && medlemIndex != -1) {

			medlemmer[personPar].setStatusIndeks(-1);
			medlemmer[medlemIndex].setStatusIndeks(-1);

		} else {
			System.out.println("Par er ikke koblet");
		}
	}

}
