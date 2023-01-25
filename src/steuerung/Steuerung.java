package steuerung;

import benutzerschnittstelle.Benutzerschnittstelle;
import datenspeicherung.db.ProduktSpeicher;

public class Steuerung 
{
	private ProduktSpeicher speicher;
	
	public Steuerung(Benutzerschnittstelle pBenutzerschnittstelle)
	{
		speicher = new ProduktSpeicher();
		try {
			pBenutzerschnittstelle.zeigeProdukte(speicher.liesProdukte());
		} catch (Exception e) {
			e.printStackTrace();
			//gui.zeigeMeldung(e.getLocalizedMessage());
		}
	}
	
	public void geklicktAendern(int pProduktNr, String pBezeichnung, double pVerkaufspreis, double pLagerbestand)
	{
		speicher.aendere(pProduktNr, pBezeichnung, pVerkaufspreis, pLagerbestand);
	}
	
	public void geklicktHinzufuegen(String pBezeichnung, double pVerkaufspreis, double pLagerbestand)
	{
		speicher.fuegeHinzu(pBezeichnung, pVerkaufspreis, pLagerbestand);
	}	

	public void geklicktLoeschen(int pProduktNr)
	{
		speicher.loesche(pProduktNr);
	}

}
