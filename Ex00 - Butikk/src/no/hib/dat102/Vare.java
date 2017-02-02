package no.hib.dat102;
import java.util.*;
public class Vare {
	
	private int varenummer;
	private String navn;
	private double pris;
	
	
	public Vare(){
		this(0,"",0.0);
	}
	public Vare(int vn, String n, double p){
		this.varenummer = vn;
		this.navn = n;
		this.pris = p;
	}
	public Vare(int vn){
		this(vn, "",0.0);
	}
	public void setVarenummer(int vn){
		this.varenummer = vn;
	}
	public int getVarenummer(){
		return varenummer;
	}
	public void setNavn(String n){
		this.navn = n;
	}
	public String getNavn(){
		return navn;
	}
	public void setPris(double p){
		this.pris = p;
	}
	public double getPris(){
		return pris; 
	}
	public void lesVare(int vn){
		System.out.println("Registrer pris");
		
		Scanner tastatur = new Scanner(System.in);
		this.pris = tastatur.nextDouble();
		
		System.out.println("Register Navn");
		this.navn = tastatur.nextLine();
		
		while(pris < 0){
			System.out.println("feil input");
			this.pris = tastatur.nextDouble();
		}
		tastatur.close();
	}
}
