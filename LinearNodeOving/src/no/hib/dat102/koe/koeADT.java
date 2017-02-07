package no.hib.dat102.koe;
import no.hib.dat102.*;

public interface koeADT<T> {
	/**
	 * Legger til et element i slutten av k�en
	 */
	public void leggTil(T element);
	
	/**
	 * Fjerner og returnerer elementet fra fronten av k�en
	 * @throws EmptyCollectionException 
	 *
	 */
	public T fjernFoersteElement() throws EmptyCollectionException;
	
	/**
	 * Fjerner og returnerer elementet fra k�en
	 * @throws EmptyCollectionException
	 */
	public Boolean fjernElement(T element) throws EmptyCollectionException;
	
	/**
	 * Returnerer det f�rste elementet uten � fjerne det
	 */
	public T forste();
	
	/**
	 * Returnerer sann om k�en har ingne elementer
	 */
	public boolean erTom();
	
	/**
	 * Returnerer antall elementer i k�en
	 */
	public int antall();
	
	/**
	 * legger til et element fremst i k�en
	 */
	public void LeggTilFoerstIKoe(T element);
	
	/**
	 * Returnerer en streng representasjon av k�en
	 */
	public String toString();

}
