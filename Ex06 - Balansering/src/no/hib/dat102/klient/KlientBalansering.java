package no.hib.dat102.klient;

import no.hib.dat102.modell.Balansering;

public class KlientBalansering{
     public static void main(String[] args){
        final String filnavn = "data.txt";
        //Leser inn en tekst fra fil
        Balansering balansering = new Balansering();
        balansering.lesFraFil(filnavn);
       
     
     }//main

}//class
