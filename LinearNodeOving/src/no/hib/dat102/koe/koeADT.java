package no.hib.dat102.koe;
import no.hib.dat102.*;

public interface koeADT<T> {
	/**
	 * Legger til et element i slutten av køen
	 */
	public void leggTil(T element);
	
	/**
	 * Fjerner og returnerer elementet fra fronten av køen
	 * @throws EmptyCollectionException 
	 *
	 */
	public T fjernFoersteElement() throws EmptyCollectionException;
	
	/**
	 * Fjerner og returnerer elementet fra køen
	 * @throws EmptyCollectionException
	 */
	public Boolean fjernElement(T element) throws EmptyCollectionException;
	
	/**
	 * Returnerer det første elementet uten å fjerne det
	 */
	public T forste();
	
	/**
	 * Returnerer sann om køen har ingne elementer
	 */
	public boolean erTom();
	
	/**
	 * Returnerer antall elementer i køen
	 */
	public int antall();
	
	/**
	 * legger til et element fremst i køen
	 */
	public void LeggTilFoerstIKoe(T element);
	
	/**
	 * Returnerer en streng representasjon av køen
	 */
	public String toString();

}
