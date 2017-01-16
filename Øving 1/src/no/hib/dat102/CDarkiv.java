package no.hib.dat102;

import no.hib.data102.adt.CDarkivADT;

public class CDarkiv implements CDarkivADT {
	//Instansvariable
	 private CD[] cdTabell;
	 private int antall;
	 
	 //Konstruktører og andre metoder
	public CDarkiv(int maxAntall){
		cdTabell = new CD[maxAntall];
		antall = 0;
	}
	 @Override
	public CD[] hentCdTabell() {
		return cdTabell;
	}
	@Override
	public void leggTilCd(CD nyCd) {
		if(antall < cdTabell.length){
			cdTabell[antall] = nyCd;
			antall++;
		}
	}
	@Override
	public boolean slettCd(int cdNr) {
		boolean slett = false;
		if(finsCD(cdNr) != -1){
			cdTabell[finsCD(cdNr)] = cdTabell[antall];
			cdTabell[antall] = null;
			antall--;
			slett = true;
		}
		return slett;
	}
	@Override
	public CD sokTittel(String delstreng) {
		CD tittel = null;
		for(int i = 0; i < antall; i++){
			if(cdTabell[i].getTittel().equals(delstreng)){
				tittel = cdTabell[i];
			}
		}
		return tittel;
	}
	@Override
	public CD sokArtist(String delstreng) {
		CD artist = null;
		for(int i = 0; i < antall; i++){
			if(cdTabell[i].getArtist().equals(delstreng)){
				artist = cdTabell[i];
			}
		}
		return artist;
	}
	@Override
	public int hentAntall() {
		
		return antall;
	}
	@Override
	public int hentAntall(Sjanger sjanger) {
		int antallSjanger = 0;
		for(int i = 0; i < antall;i++){
			if(cdTabell[i].getSjanger().equals(sjanger)){
				antallSjanger++;
			}
		}
		return antallSjanger;
	}
	
	public int finsCD(int cdNr) {
		boolean finnes = false;
		for(int i = 0; i < antall && !finnes; i ++){
			if(cdTabell[i].getCdNummer() == cdNr){
				return i;
			}
		}
		return -1;
	}


}
