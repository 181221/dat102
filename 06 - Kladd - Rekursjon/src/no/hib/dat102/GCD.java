package no.hib.dat102;

public class GCD {
	public static int SFD(int a,int b){
		   if ( b == 0 )
		     return a;
		   return SFD(b,a%b);
		 }
	public static int mfm(int a, int b){
		int mfm = -1;
		if(a%b==0){
			 mfm = (a*b)/(SFD(a,b));
		}
		return mfm;
	}
	public static void main(String[] args) {
		System.out.println(SFD(28,16));
		//System.out.println(mfm(16));
	}

}
