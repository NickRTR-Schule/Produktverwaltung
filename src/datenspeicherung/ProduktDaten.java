package datenspeicherung;

public class ProduktDaten
{
	private String bezeichnung;
	private double lagerbestand;
	private int produktNr;
	private double verkaufspreis;
	
	public ProduktDaten(int pProduktNr, String pBezeichung, double pVerkaufspreis, double pLagerbestand)
	{
		produktNr = pProduktNr;
		bezeichnung = pBezeichung;
		verkaufspreis = pVerkaufspreis;
		lagerbestand = pLagerbestand;
	}
	
	public String liesBezeichnung()
	{
		return bezeichnung;
	}
	
	public double liesLagerbestand()
	{
		return lagerbestand;
	}
	
	public int liesProduktNr()
	{
		return produktNr;
	}
	
	public double liesVerkaufspreis()
	{
		return verkaufspreis;
	}
}
