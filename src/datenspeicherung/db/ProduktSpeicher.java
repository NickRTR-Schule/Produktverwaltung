package datenspeicherung.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datenspeicherung.ProduktDaten;

public class ProduktSpeicher
{
	private Connection con; // Verbindung zur DB
	private PreparedStatement stmt; // DB-Anfrage (Query)
	private ResultSet rs; // mögliches Ergebnis einer DB-Abfrage

	public ArrayList<ProduktDaten> liesProdukte() throws Exception
	{
		oeffneDatenbank();
		ArrayList<ProduktDaten> ergebnis = new ArrayList<>();

		// DB-Abfrage als String
		String sqlStmt = "SELECT produktnr, bezeichnung, verkaufspreis, lagerbestand ";
		sqlStmt += "FROM produkt ";
		sqlStmt += "ORDER BY produktnr";

		try
		{
			// DB-Abfrage vorbereiten
			stmt = con.prepareStatement(sqlStmt);
			// DB-Abfrage ausführen
			rs = stmt.executeQuery();

			// Ergebnis der DB-Abfrage Zeile für Zeile abarbeiten
			while (rs.next())
			{
				// DB-Zeile als Objekt in Ergebnis-Array speichern
				ergebnis.add(new ProduktDaten(rs.getInt("produktnr"),
						rs.getString("bezeichnung"),
						rs.getDouble("verkaufspreis"),
						rs.getDouble("lagerbestand")));
			}
		}
		catch (SQLException e)
		{
			throw new Exception("Fehler beim Lesen der Produkte!");
		}

		schliesseDatenbank();
		return ergebnis;
	}

	private void oeffneDatenbank() throws Exception
	{
		try
		{
			// Verbindung zur Datenbank herstellen; Struktur:
			// jdbc = Java Database Connectivity = Mechanismus zum DB-Zugriff
			// ucanaccess = 
			// C:/temp/usw. = Pfad zur Datenbank
			con = DriverManager.getConnection(
					"jdbc:ucanaccess://C:/temp/auftragswesen.accdb"); // (Zu Testzwecken)
		}
		catch (SQLException e)
		{
			throw new Exception("Fehler beim Öffnen der Datenbank!");
		}
	}

	private void schliesseDatenbank() throws Exception
	{
		try
		{
			// Ergebnismenge schließen
			if (rs != null)
			{
				rs.close();
			}
			// Statement schließen
			stmt.close();
			// Verbindung schließen
			con.close();
		}
		catch (SQLException e)
		{
			throw new Exception("Fehler beim Schließen der Datenbank!");
		}
	}

	public void fuegeHinzu(String pBezeichnung, double pVerkaufspreis,
			double pLagerbestand) throws Exception
	{
		oeffneDatenbank();

		// DB-Anfrage zum Hinzufügen eines Produktes
		String sqlStmt = "INSERT INTO produkt (bezeichnung, verkaufspreis, lagerbestand) ";
		sqlStmt += "VALUES (?, ?, ?)";

		try
		{
			// DB-Abfrage vorbereiten
			stmt = con.prepareStatement(sqlStmt);
			// ? Platzhalter durch Paramter ersetzen (Parameter nicht direkt in String einfügen um SQL-Injection zu verhindern)
			stmt.setString(1, pBezeichnung);
			stmt.setDouble(2, pVerkaufspreis);
			stmt.setDouble(3, pLagerbestand);
			// DB-Abfrage ausführen
			stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new Exception("Fehler beim Hinzufügen des Produkts!");
		}

		schliesseDatenbank();
	}

	public void aendere(int pProduktNr, String pBezeichnung,
			double pVerkaufspreis, double pLagerbestand) throws Exception
	{
		oeffneDatenbank();

		// DB-Abfrage zur Änderung von Produktdaten
		String sqlStmt = "UPDATE produkt ";
		sqlStmt += "SET bezeichnung = ? , verkaufspreis = ?, lagerbestand = ? ";
		sqlStmt += "WHERE produktnr = ?";

		try
		{
			// DB-Abfrage vorbereiten
			stmt = con.prepareStatement(sqlStmt);
			// ? Platzhalter durch Paramter ersetzen
			stmt.setString(1, pBezeichnung);
			stmt.setDouble(2, pVerkaufspreis);
			stmt.setDouble(3, pLagerbestand);
			stmt.setInt(4, pProduktNr);
			// DB-Abfrage ausführen
			stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new Exception("Fehler beim Ändern des Produkts!");
		}

		schliesseDatenbank();
	}

	public void loesche(int pProduktNr) throws Exception
	{
		oeffneDatenbank();

		// DB-Anfrage zum Löschen eines Produkts
		String sqlStmt = "DELETE FROM produkt ";
		sqlStmt += "WHERE produktnr = ?";

		try
		{
			// DB-Abfrage vorbereiten
			stmt = con.prepareStatement(sqlStmt);
			// ? Platzhalter durch Paramter ersetzen
			stmt.setInt(1, pProduktNr);
			// DB-Abfrage ausführen
			stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new Exception("Fehler beim Löschen des Produkts!");
		}

		schliesseDatenbank();
	}
}
