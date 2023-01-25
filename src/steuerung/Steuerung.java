package steuerung;

import benutzerschnittstelle.Benutzerschnittstelle;
import datenspeicherung.db.ProduktSpeicher;

public class Steuerung 
{
	private ProduktSpeicher speicher;
	private Benutzerschnittstelle benutzerschnittstelle;
	
	public Steuerung(Benutzerschnittstelle pBenutzerschnittstelle)
	{
		benutzerschnittstelle = pBenutzerschnittstelle;
		speicher = new ProduktSpeicher();
		try {
			benutzerschnittstelle.zeigeProdukte(speicher.liesProdukte());
		} catch (Exception e) {
			e.printStackTrace();
			benutzerschnittstelle.zeigeMeldung(e.getLocalizedMessage());
		}
	}
	
	public void geklicktAendern(int pProduktNr, String pBezeichnung, double pVerkaufspreis, double pLagerbestand)
	{
		try {
			speicher.aendere(pProduktNr, pBezeichnung, pVerkaufspreis, pLagerbestand);
			benutzerschnittstelle.zeigeProdukte(speicher.liesProdukte());
		} catch (Exception e) {
			e.printStackTrace();
			benutzerschnittstelle.zeigeMeldung(e.getLocalizedMessage());
		}
	}
	
	public void geklicktHinzufuegen(String pBezeichnung, double pVerkaufspreis, double pLagerbestand)
	{
		try {
			speicher.fuegeHinzu(pBezeichnung, pVerkaufspreis, pLagerbestand);
			benutzerschnittstelle.zeigeProdukte(speicher.liesProdukte());
		} catch (Exception e) {
			e.printStackTrace();
			benutzerschnittstelle.zeigeMeldung(e.getLocalizedMessage());
		}
	}	

	public void geklicktLoeschen(int pProduktNr)
	{
		try {
			speicher.loesche(pProduktNr);
			benutzerschnittstelle.zeigeProdukte(speicher.liesProdukte());
		} catch (Exception e) {
			e.printStackTrace();
			benutzerschnittstelle.zeigeMeldung(e.getLocalizedMessage());
		}
	}

}
