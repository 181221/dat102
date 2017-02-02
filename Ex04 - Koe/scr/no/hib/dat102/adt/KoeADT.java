package no.hib.dat102.adt;

//**************************************************************************
//  K�ADT.java      
//  Definerer interface til en samling k�. Sist oppdatert 25.01
//***************************************************************************


public interface KoeADT<T>{
	
 	/**
	 *  Legge til et element bak i k�en.
	 * @param element som skal legges til bak i k�en
	 */
   public void innKoe (T element);
   

   /**
    * Fjerner og returnerer elementet foran i k�en.
    * @return element T som returneres og fjernes fra k�en
    */
   public T utKoe();
   

   /**  
    * Returnerer elementet foran i k�en uten � fjerne det fra k�en. 
    * @return element T som returneres 
    */      
   public T foerste();
   
      
   /**
    * Returns sann hvis denne k�ene ikke inneholder noen elementer..
    * @return sann hvis k�en er tom ellers returneres usann
    */   
   public boolean erTom();
   

  /**
   *  Returnerer antall elementer i k�en. 
   * @return antall elementer i k�en
   */
   public int antall();
  
}//