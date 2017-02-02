package no.hib.dat102;

public class Butikk {

	private String navn;
	private Vare[] varer;
	private int[] antall;

	public Butikk(String n, int maxAntall) {
		navn = n;
		antall = new int[maxAntall];
		varer = new Vare[maxAntall];
	}

	public int finnVare(int vnr) {
		for (int i = 0; i < varer.length; i++) {
			if (vnr == varer[i].getVarenummer()) {
				return i;
			}
		}
		return -1;
	}

	public boolean erLedig() {

		for (Vare k : varer) {
			if (k == null) {
				return true;
			}
		}
		return false;
	}

	public boolean leggTil(int varenr) {
		if (erLedig() && finnVare(varenr) == -1) {
			for (int i = 0; i < varer.length; i++) {
				if (varer[i] == null) {
					varer[i] = new Vare(varenr);
					System.out.println("vare lagt til");
					return true;
				}
			}
		}
		System.out.println("varelager er fullt ikke lagt til");
		return false;
	}

	public boolean slettVare(int varenr) {
		if (finnVare(varenr) != -1) {
			varer[finnVare(varenr)] = null;
			return true;
		}
		System.out.println("vare ikke funnet");
		return false;
	}

	public boolean detaljSalg(int varenr) {
		if (finnVare(varenr) != -1) {
			if (antall[varenr] != 0) {
				antall[varenr]--;
			} else {
				System.out.println("Det er ikke flere varer av denne typen på lager");
			}
			return true;
		}
		System.out.println("Varen eksisterer ikke");
		return false;

	}

	public boolean grossInnkjøp(int varenr, int tall) {
		if (finnVare(varenr) != -1 && tall > 0) {
			antall[finnVare(varenr)] += tall;
			System.out.println("Det er nå: " + antall[finnVare(varenr)] + " på lager av denne varen");
			return true;
		}
		System.out.println("Varen fins ikke");
		return false;
	}

	public void salgsVerdi() {
		double total = 0.0;
		for (Vare k : varer) {
			if (k != null) {
				total += k.getPris();
			}
		}
		System.out.println(total);
	}

}
