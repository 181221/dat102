package no.hib.dat102;
/*
 * @author Peder Wiig Aalen
 */

public class CD {
	
	private int cdNummer;
	private String artist;
	private String tittel;
	private int aar;
	private Sjanger sjanger;
	private String plateselskap;
	
	/**
	 * 
	 * @param cdNummer
	 * @param artist
	 * @param tittel
	 * @param aar
	 * @param sjanger
	 * @param plateselskap
	 */
	public CD(int cn, String a, String t, int aar, Sjanger sjanger, String p){
		cdNummer = cn;
		artist = a;
		tittel = t;
		this.aar = aar;
		this.sjanger = sjanger;
		plateselskap = p;
	}
	public CD(){
		this(0, "", "", 0, null, "");
	}
	public int getCdNummer() {
		return cdNummer;
	}
	public void setCdNummer(int cdNummer) {
		this.cdNummer = cdNummer;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTittel() {
		return tittel;
	}
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	public int getAar() {
		return aar;
	}
	public void setAar(int aar) {
		this.aar = aar;
	}
	public Sjanger getSjanger() {
		return sjanger;
	}
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	public String getPlateselskap() {
		return plateselskap;
	}
	public void setPlateselskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}
	@Override
	public String toString() {
		return "CDNummer: " + cdNummer + ", artist: " + artist + ", tittel: " + tittel + ", aar: " + aar + ", sjanger: "
				+ sjanger + ", plateselskap: " + plateselskap ;
	}

}
