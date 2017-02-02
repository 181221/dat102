package no.hib.dat102.adt;

//**************************************************************************
//  KøADT.java      
//  Definerer interface til en samling kø. Sist oppdatert 25.01
//***************************************************************************


public interface KoeADT<T>{
	
 	/**
	 *  Legge til et element bak i køen.
	 * @param element som skal legges til bak i køen
	 */
   public void innKoe (T element);
   

   /**
    * Fjerner og returnerer elementet foran i køen.
    * @return element T som returneres og fjernes fra køen
    */
   public T utKoe();
   

   /**  
    * Returnerer elementet foran i køen uten å fjerne det fra køen. 
    * @return element T som returneres 
    */      
   public T foerste();
   
      
   /**
    * Returns sann hvis denne køene ikke inneholder noen elementer..
    * @return sann hvis køen er tom ellers returneres usann
    */   
   public boolean erTom();
   

  /**
   *  Returnerer antall elementer i køen. 
   * @return antall elementer i køen
   */
   public int antall();
  
}//