package no.hib.dat102.potens;

public class Potens {
	// som finner verdien an basert på formelen an = a * an-1
	// når n > 0, og a0 = 1.0

	public static double potens(double a, int n) {
		double svar;
		if (n > 0) {
			svar = a * (potens(a, (n - 1)));
		} else {
			svar = 1;
		}
		return svar;
	}

	public static double potens2(double a, int n) {
		double svar;
		if (n > 0) {
			if (n % 2 == 0) {
				svar = Math.sqrt(potens(a, n)) * Math.sqrt(potens(a, n));
			} else {
				svar = a * Math.sqrt(potens(a, n)) * Math.sqrt(potens(a, n));
			}
		} else {
			svar = 1;
		}
		return svar;
	}

	public static void main(String[] args) {
		// System.out.println(potens(3,5));
		System.out.println(potens2(2, 6));
		System.out.println(potens2(2, 5));
	}
}
