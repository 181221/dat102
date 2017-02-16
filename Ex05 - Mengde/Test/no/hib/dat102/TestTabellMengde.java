package no.hib.dat102;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import no.hib.dat102.mengde.tabell.TabellMengde;

public class TestTabellMengde {
	private TabellMengde<Integer> m1;
	private TabellMengde<Integer> m2;
	private TabellMengde<Integer> begge;
	
	private Integer e1 = 1;
	private Integer e2 = 2;
	private Integer e3 = 3;
	private Integer e4 = 4;
	private Integer e5 = 5;
	
	@Before
	public final void setup(){
		m1 = new TabellMengde<Integer>();
	}
	
	@Test
	public final void leggTil() {
		m1.leggTil(e1);
		assertEquals(1,m1.antall());
	}
	@Test
	public final void antall(){
		for(int i = 0; i < 110; i++){
			m1.leggTil(e1+i);
		}
		assertEquals(110, m1.antall());
	}
	@Test
	public final void fjernTom(){
		assertEquals(null,m1.fjern(e1));
	}
	@Test
	public final void LeggTilOgFjern(){
		m1.leggTil(e1);
		
		assertEquals(e1,m1.fjern(e1));
	}
	@Test
	public final void erTom(){
		assertEquals(0,m1.antall());
	}
	@Test
	public final void erLik(){
		m2 = new TabellMengde<Integer>();
		m1.leggTil(e1);
		m2.leggTil(e1);
		assertTrue(m1.erLik(m2));
	}
	@Test
	public final void snitt(){
		m2 = new TabellMengde<Integer>();
		begge = new TabellMengde<Integer>();
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e4);
		m2.leggTil(e3);
		m2.leggTil(e1);
		
		begge = (TabellMengde<Integer>) m1.snitt(m2);
		
		assertTrue(begge.inneholder(e1));
		assertFalse(begge.inneholder(e2));
		assertFalse(begge.inneholder(e3));
		assertFalse(begge.inneholder(e4));
	}
	@Test
	public final void differanse(){
		m2 = new TabellMengde<Integer>();
		TabellMengde<Integer> adiffB = new TabellMengde<Integer>();
		
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e4);
		m2.leggTil(e3);
		m2.leggTil(e1);
		
		//m1 = {e1,e2,e4}
		//m2 = {e3,e1}
		//adiffb = {e2,e4}
		
		adiffB = (TabellMengde<Integer>) m1.differens(m2);
		
		assertTrue(adiffB.inneholder(e2));
		assertTrue(adiffB.inneholder(e4));
		assertFalse(adiffB.inneholder(e3));
		assertFalse(adiffB.inneholder(e1));
	}

}
