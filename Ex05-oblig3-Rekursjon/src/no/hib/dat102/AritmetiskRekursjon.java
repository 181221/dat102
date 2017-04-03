package no.hib.dat102;

public class AritmetiskRekursjon {
	public static int sum(int n) {
		if (n > 1) {
			return sum(n - 1) + n;
		} else {
			return 1;
		}
	}

	public static int tallFoelge(int n) {
		// an = 5an-1 - 6an-2 + 2 for n > 1 og startkrav a0 = 2, a1 = 5
		if (n == 0) {
			return 2;
		} else if (n == 1) {
			return 5;
		} else {
			return 5 * tallFoelge(n - 1) - (6 * tallFoelge(n - 2))+2;
		}
	}

	public static void main(String[] args) {
		System.out.println("summen = " + sum(10));
		for(int i= 0; i <10;i++){
			System.out.println("tall " +i + ": " +tallFoelge(i));
		}
	}

}
