package benutzerschnittstelle;

import datenspeicherung.datei.ProduktSpeicher;

public class Konsole
{

	public static void main(String[] args)
	{		
//		String zeile = "1;Acer CD-R Gold 24x (10 St.);5.0;163.0";
//		String[] daten = zeile.split(";");
//
//		int produktNr = Integer.parseInt(daten[0]);
//		String bezeichnung = daten[1];
//		double verkaufsPreis = Double.parseDouble(daten[2]);
//		double lagerbestand = Double.parseDouble(daten[3]);
//		System.out.println(produktNr + " / " + bezeichnung + " / " + verkaufsPreis + " / " + lagerbestand);
		
		ProduktSpeicher derSpeicher = new ProduktSpeicher();
		System.out.println(derSpeicher.liesProdukte());
	}
	
}
