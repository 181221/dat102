package no.hib.dat102;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hib.dat102.adt.KoeADT;



public class KoeTest {
	//referanse til stabel;
	private KoeADT<Character> stabel;
	protected static final int SIZE = 100;
	
	private String s0 = "dette er en test";
	private String s1 = "";
	private String s2 = "lolololol";
	private String s3 = "heieihei";
	
	private Character e0 = 'A';
	private Character e1 = 'B';
	private Character e2 = 'C';
	private Character e3 = 'D';
	/**
	 * Hent en ny stabel for hver test.
	 */
	@Before
	public final void setup(){
		stabel = new SirkulerKoe<Character>(SIZE);
	}
	
	/**
	 * Test på at en ny stabel er tom.
	 */
	@Test
	public final void nyStabelErTom(){
		assertTrue(stabel.erTom());
	}
	/**
	 * test på å legge til element. 
	 */
	@Test
	public final void testInn(){
		for(int i = 0; i < s0.length(); i++){
			stabel.innKoe(new Character(s0.charAt(i)));
		}
		assertFalse(stabel.erTom());
		assertTrue(stabel.antall() == s0.length());
	}
	
	/**
	 * Test på leggtil element og ta det ut igjen 
	 */
	@Test
	public final void testInnOgUt(){
		stabel.innKoe(e0);
		stabel.innKoe(e1);
		stabel.innKoe(e2);
		
		try{
			assertEquals(e0, stabel.utKoe());
			assertEquals(e1, stabel.utKoe());
			assertEquals(e2, stabel.utKoe());
			
		}catch(EmptyCollectionException e){
			fail("utkoe feilet uventet " + e.getMessage());
		}
	}
	@Test
	public final void InnOgUtMedDup(){
		
		stabel.innKoe(e0);
		stabel.innKoe(e0);
		stabel.innKoe(e0);
		stabel.innKoe(e2);
		
		try {
			assertEquals(e0, stabel.utKoe());
			assertEquals(e0, stabel.utKoe());
			assertEquals(e0, stabel.utKoe());
			assertEquals(e2, stabel.utKoe());
			
		}catch (EmptyCollectionException e) {
			fail("pop feilet uventet " + e.getMessage());
		}	
	}
	@Test
	public final void innUtInnInnUtSe(){
		
		try {
			stabel.innKoe(e0);
			stabel.utKoe();
			stabel.innKoe(e0);
			stabel.innKoe(e1);
			stabel.utKoe();
			assertEquals(e1,stabel.foerste());

		} catch (EmptyCollectionException e) {
			fail("pop eller peek feilet uventet " + e.getMessage());
		}
	}
	
	@Test
	public final void erIkkeTom(){
		stabel.innKoe(e0);
		stabel.innKoe(e1);
		assertFalse(stabel.erTom());
	}
	@Test
	public final void InnUtErTom(){
		try{
			stabel.innKoe(e0);
			stabel.utKoe();
			assertTrue(stabel.erTom());
		}catch (EmptyCollectionException e){
			fail("push eller pop feilet uventet " + e.getMessage());
		}
	}
	/**
	 * Test på størrelsen
	 */
	@Test
	public final void stor(){
		stabel.innKoe(e1);
		stabel.innKoe(e1);
		stabel.innKoe(e1);
		assertEquals(3, stabel.antall());
	}
	
	/**
	 * Forsøk på pop av en tom stabel skal gi "underflow excepton" *
	 * 
	 * @throws EmptyCollectionException
	 *             expected exception
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void popFromEmptyIsUnderflowed()
			throws EmptyCollectionException {
		stabel.utKoe();
	}

}
