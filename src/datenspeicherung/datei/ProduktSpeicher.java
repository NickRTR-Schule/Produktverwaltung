package datenspeicherung.datei;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import datenspeicherung.ProduktDaten;

public class ProduktSpeicher
{
	public ProduktSpeicher()
	{
		
	}
	
	public void aendere(int pProduktNr, String pBezeichnung, double pVerkaufspreis, double pLagerbestand)
	{
		
	}
	
	public void fuegeHinzu(String pBezeichnung, double pVerkaufspreis, double pLagerbestand)
	{
		ArrayList<ProduktDaten> daten = new ArrayList<>();
	}
	
	public ArrayList<ProduktDaten> liesProdukte() throws Exception
	{
		ArrayList<ProduktDaten> daten = new ArrayList<>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("produkt.csv"));
			String zeile;
			while((zeile = br.readLine()) != null)
			{
				String[] zeilenDaten = zeile.split(";");

				int produktNr = Integer.parseInt(zeilenDaten[0]);
				String bezeichnung = zeilenDaten[1];
				double verkaufsPreis = Double.parseDouble(zeilenDaten[2]);
				double lagerbestand = Double.parseDouble(zeilenDaten[3]);

				daten.add(new ProduktDaten(produktNr, bezeichnung, verkaufsPreis, lagerbestand));
			}
			
			br.close();
		}
		catch (Exception e)
		{
			throw new Exception("Fehler: " + e.getLocalizedMessage());
		}
		
		return daten;
	}
	
	public void loesche(int pProduktNr)
	{
		
	}
}
