package no.hib.dat102;

public class Fibonnacie {
	public static int fibbonacci(int n) {
		int svar;
		if (n > 2) {
			svar = fibbonacci(n - 1) + fibbonacci(n - 2);
		} else {
			if (n == 0) {
				svar = 0;
			} else {
				svar = 1;
			}
		}
		return svar;
	}
	public static void main(String[] args) {
		System.out.println(fibbonacci(7));
	}
}
