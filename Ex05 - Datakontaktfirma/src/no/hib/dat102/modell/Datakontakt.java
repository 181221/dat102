package no.hib.dat102.modell;

public class Datakontakt {
	private Medlem[] medlemmer;
	private int antallMedlemmer;
	private static final int STDK = 100;

	/**
	 * Oppretter en tabell med medlemmer
	 * @param antall angir størrelsen.
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
	public boolean erTom(){
		return antallMedlemmer == 0;
	}

	/**
	 * legger til et nytt medlem i medlemstabellen
	 * @param person
	 *            
	 * @return
	 */
	public Medlem leggTilMedlem(Medlem person) {
		Medlem k = null;
		if(antallMedlemmer < medlemmer.length){
			medlemmer[antallMedlemmer] = person;
			k = person;
			antallMedlemmer++;
		}
		return k;
	}

	/**
	 * som finner indeksen til medlemmet i medlemstabellen dersom medlemmet er
	 * registrert, ellers returneres indeks lik -1. (Noen vil kanskje si at vi
	 * denne metoden burde returnerte en referansen slik at vi lettere kunne
	 * bytte ut til annen datastruktur, men det lar vi være)
	 * 
	 * @param medlemsnavn
	 */
	public int finnMedlemsIndeks(String medlemsnavn) {
		int index = -1;
		for(Medlem k : medlemmer){
			if(k.equals(medlemsnavn)){
				index = k.getStatusIndeks();
				break;
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
	public void finnPartnerFor(String medlemsnavn) {
		// TODO
		System.out.println("ikke implementer metode");
	}

	/**
	 * som oppdaterer medlemstabellen, slik at dette medlemmet (identifisert ved
	 * medlemsnavn) og dets partner, dersom det fins, ikke lenger er “koblet”
	 * (dvs. begge får statusindeks –1).
	 * 
	 * @param medlemsnavn
	 */
	public void tilbakestillStausIndeks(String medlemsnavn) {
		// TODO
		System.out.println("ikke implementer metode");
	}

}
