package no.hib.dat102;
public enum Sjanger {
      ROCK(0), POP(1), OPERA(2), CLASSIC(3);
	  
      private int nr;
	  
      private Sjanger(int n) { // Konstruktør må enten være private eller "pakke-synlig"
           nr = n;
       }
	   
	  public int getNr() { 
	       return nr;
      }
        
    public static Sjanger finnSjanger(int n) {
        Sjanger sjang = null;
        for (Sjanger sj : Sjanger.values()) {
            if (sj.nr == n) {
                sjang = sj;
                break;
            }
        }
        return sjang;
    }

}

