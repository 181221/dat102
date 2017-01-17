package no.hib.dat102;
/**
 * 
 * Sjanger enum Rock - Pop - Opera - Classic.
 *
 */
public enum Sjanger {
      ROCK(0), POP(1), OPERA(2), CLASSIC(3);
	  
      private int nr;
	  
      private Sjanger(int n) { // KonstruktÃ¸r mÃ¥ enten vÃ¦re private eller "pakke-synlig"
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

	/** Søker og henter sjanger med string som input
	 * @param navn Navn på sjanger
	 * @return Sjanger
	 */
	public static Sjanger finnSjanger(String navn) {
		Sjanger sjang = null;
		for (Sjanger sj: Sjanger.values()) {
			if (sj.toString().equals(navn.toUpperCase())) {
				sjang = sj;
				break;
			}
		}
		return sjang;
	} // metode

}

