package benutzerschnittstelle;

import java.util.ArrayList;
import datenspeicherung.ProduktDaten;


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
		System.out.format("%9s   %-50s   %13s   %12s%n",  "Produktnr", "Bezeichnung", "Verkaufspreis", "Lagerbestand");
		for (int i = 0; i < 93; i++) {
			System.out.print("-");
		}
		System.out.println();
		try {
			ArrayList<ProduktDaten> produkte;
			produkte = derSpeicher.liesProdukte();
			for (int i = 0; i < produkte.size(); i++) {
				ProduktDaten produkt = produkte.get(i);
				System.out.format("%9d   %-50s   %13.2f   %12.2f %n", produkt.liesProduktNr(), produkt.liesBezeichnung(),  produkt.liesVerkaufspreis(), produkt.liesLagerbestand());
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
}
