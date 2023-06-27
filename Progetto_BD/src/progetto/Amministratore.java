package progetto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Amministratore {

	private static final String DB_URL ="jdbc:mysql://localhost/TVJournal";
	private static final String USER = "root";
	private static final String PASS = "Myl0vefromanotherstar*";
	
	private static QueryManager q;
	private JFrame frame;
	private JTable table;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			q = new QueryManager(DB_URL, USER, PASS);
				try {
					Amministratore window = new Amministratore();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Amministratore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				q.closeConnection();						//chiudo connessione
			}
		});
		frame.setBounds(100, 100, 554, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton = new JButton("Utenti");
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Titoli");
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		JButton btnNewButton_4 = new JButton("Modifica Titolo");
		panel_7.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Elimina Titolo");
		panel_7.add(btnNewButton_5);
		panel_7.setVisible(false);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.WEST);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.EAST);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("Aggiungi Serie");
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Aggiungi Film");
		panel_2.add(btnNewButton_2);
		
		//mostrare gli utenti
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = new DefaultTableModel() {
					
					private static final long serialVersionUID = 9016524060224892816L;

					public boolean isCellEditable(int row, int column) {
					       return false;
					    }
				};
				
				panel_7.setVisible(false);
				
				String[][] tb = q.getTable("select u.username as Username, u.nome as Nome, u.cognome as Cognome from Utente u");
				int col = q.getColumnCount();
				int row = q.getRowCount();
				
				for(int i=0; i<col; i++) 
					model.addColumn(tb[0][i].toUpperCase());
				
					
				for(int j = 1; j<=row; j++)
					model.addRow(tb[j]);
				
				table.setModel(model);
				
				
			}
		});
		
		//mostrare titoli
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = new DefaultTableModel() {
					
					/**
					 * 
					 */
					private static final long serialVersionUID = -5433641011319983104L;

					public boolean isCellEditable(int row, int column) {
					       //all cells false
					       return false;
					    }
				};
				
				panel_7.setVisible(true);
				
				String[][] tb = q.getTable("select * from Titolo");
				int col = q.getColumnCount();
				int row = q.getRowCount();
				
				for(int i=0; i<col; i++) 
					model.addColumn(tb[0][i].toUpperCase());
				
					
				for(int j = 1; j<=row; j++)
					model.addRow(tb[j]);
				
				table.setModel(model);
				
				
			}
		});
		
		//aggiungere film
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Film.main(q);
			}
		});
		
		//aggiungere serie
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Serie.main(q);
			}
		});
		
		//modificare titolo
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				int numberRow = table.getSelectedRowCount();
				
				if(row>=0 && numberRow == 1) {
					
					String titolo = (String) table.getValueAt(row, 1);
					String ddu = (String) table.getValueAt(row, 2);
					String tipo = (String) table.getValueAt(row, 3);
					String stagioni = (String) table.getValueAt(row, 4);
					String durata = (String) table.getValueAt(row, 5);
					String regista = (String) table.getValueAt(row, 6);
					
					String[] component = durata.split(":");
					String[] component1 = ddu.split("-");
					
					int anno = Integer.parseInt(component1[0]);
					int mese = Integer.parseInt(component1[1]);
					int giorno = Integer.parseInt(component1[2]);
					
					int ore = Integer.parseInt(component[0]);
					int minuti = Integer.parseInt(component[1]);
					
					String[] query = q.makeQuery("select id from Titolo where nome = \""+titolo+"\" and ddu = \""+ddu+"\" and regista = \""+regista+"\";");
					int id = Integer.parseInt(query[0]);
					
					
					if(tipo.equals("film")) {
						
						ModificaFilm.main(titolo, anno, mese, giorno, ore, minuti, regista, id, q);
					}
					
					if(tipo.equals("serie")) {
						
						ModificaSerie.main(titolo, anno, mese, giorno, stagioni, regista, id, q);
						
					}
					
				}
			}
		});
		
		//eliminare titolo
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				int numberRow = table.getSelectedRowCount();
				
				if(row>=0 && numberRow == 1) {
					
					String titolo = (String) table.getValueAt(row, 1);
					String ddu = (String) table.getValueAt(row, 2);
					String regista = (String) table.getValueAt(row, 6);
					
					String[] query = q.makeQuery("select id from Titolo where nome = \""+titolo+"\" and ddu = \""+ddu+"\" and regista = \""+regista+"\";");
					int id = Integer.parseInt(query[0]);
					
					q.insertValues("delete from Titolo where id ="+id+";");
					
					
					
					
				}
			}
		});
	}

}
