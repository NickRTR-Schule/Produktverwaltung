package benutzerschnittstelle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;

public class Benutzerschnittstelle extends JFrame
{

	private JPanel contentPane;
	private JTable tblProdukte;
	private JScrollPane scrProdukte;
	private JLabel lblProduktnummer;
	private JLabel lblBezeichnung;
	private JTextField txtProduktnummer;
	private JTextField txtBezeichnung;
	private JLabel lblVerkaufspreis;
	private JTextField txtVerkaufspreis;
	private JLabel lblLagerbestand;
	private JTextField txtLagerbestand;
	private JButton btnHinzufuegen;
	private JButton btnAendern;
	private JButton btnLoeschen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			System.out.println("Error setting native LAF: " + e);
		}
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Benutzerschnittstelle frame = new Benutzerschnittstelle();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Benutzerschnittstelle()
	{
		setTitle("Verwaltungsprodukte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrProdukte = new JScrollPane();
		scrProdukte.setBounds(10, 11, 598, 356);
		contentPane.add(scrProdukte);
		
		tblProdukte = new JTable();
		scrProdukte.setViewportView(tblProdukte);
		tblProdukte.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Produktnummer", "Bezeichnung", "Verkaufspreis", "Lagerbestand"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Double.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		lblProduktnummer = new JLabel("Produktnummer");
		lblProduktnummer.setBounds(10, 378, 85, 14);
		contentPane.add(lblProduktnummer);
		
		lblBezeichnung = new JLabel("Bezeichnung");
		lblBezeichnung.setBounds(105, 378, 94, 14);
		contentPane.add(lblBezeichnung);
		
		txtProduktnummer = new JTextField();
		txtProduktnummer.setEditable(false);
		txtProduktnummer.setBounds(10, 394, 86, 20);
		contentPane.add(txtProduktnummer);
		txtProduktnummer.setColumns(10);
		
		txtBezeichnung = new JTextField();
		txtBezeichnung.setBounds(105, 394, 200, 20);
		contentPane.add(txtBezeichnung);
		txtBezeichnung.setColumns(10);
		
		lblVerkaufspreis = new JLabel("Verkaufspreis");
		lblVerkaufspreis.setBounds(314, 378, 86, 14);
		contentPane.add(lblVerkaufspreis);
		
		txtVerkaufspreis = new JTextField();
		txtVerkaufspreis.setBounds(314, 394, 86, 20);
		contentPane.add(txtVerkaufspreis);
		txtVerkaufspreis.setColumns(10);
		
		lblLagerbestand = new JLabel("Lagerbestand");
		lblLagerbestand.setBounds(410, 378, 86, 14);
		contentPane.add(lblLagerbestand);
		
		txtLagerbestand = new JTextField();
		txtLagerbestand.setBounds(410, 394, 86, 20);
		contentPane.add(txtLagerbestand);
		txtLagerbestand.setColumns(10);
		
		btnHinzufuegen = new JButton("hinzufügen");
		btnHinzufuegen.setBounds(10, 425, 161, 23);
		contentPane.add(btnHinzufuegen);
		
		btnAendern = new JButton("ändern");
		btnAendern.setBounds(181, 425, 150, 23);
		contentPane.add(btnAendern);
		
		btnLoeschen = new JButton("löschen");
		btnLoeschen.setBounds(341, 425, 158, 23);
		contentPane.add(btnLoeschen);
		tblProdukte.getColumnModel().getColumn(0).setResizable(false);
		tblProdukte.getColumnModel().getColumn(0).setPreferredWidth(91);
		tblProdukte.getColumnModel().getColumn(1).setResizable(false);
		tblProdukte.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblProdukte.getColumnModel().getColumn(1).setMinWidth(200);
		tblProdukte.getColumnModel().getColumn(2).setResizable(false);
		tblProdukte.getColumnModel().getColumn(3).setResizable(false);
		tblProdukte.getColumnModel().getColumn(3).setPreferredWidth(77);
	}
}