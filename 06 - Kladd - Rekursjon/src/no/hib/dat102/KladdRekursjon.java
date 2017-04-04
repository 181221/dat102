package no.hib.dat102;

public class KladdRekursjon {
	public static boolean palindrom (String ord){
		int lengden = ord.length();
		if(lengden < 2){
			return true;
		}
		if(ord.charAt(0) == ord.charAt(lengden-1)){
			return palindrom(ord.substring(1,lengden-1));
		}
		return false;
	}
	public static void main(String[] args){
		String ord = "abba";
		
		System.out.println(palindrom(ord));
	}
}
