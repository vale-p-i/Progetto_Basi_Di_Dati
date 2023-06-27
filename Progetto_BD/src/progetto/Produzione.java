package progetto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Produzione {

	private JFrame frame;
	private JTextField textField;
	private static QueryManager q;
	private JComboBox cB;
	private static int id;
	private static Budget budgetTot;

	/**
	 * Launch the application.
	 */
	public static void main(QueryManager qu, int x, Budget b) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					budgetTot = b;
					id = x;
					q = qu;
					Produzione window = new Produzione();
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
	public Produzione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 220);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Budget");
		panel_6.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel panel_3 = new JPanel();
		panel_6.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.NORTH);
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8, BorderLayout.SOUTH);
		
		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Casa Produttrice");
		panel_9.add(lblNewLabel_1);
		
		JPanel panel_10 = new JPanel();
		panel_9.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		String[] caseProduzione = q.makeQuery("select nome from Casa_produzione");
		for(String s: caseProduzione)
			System.out.println(s);
		
		cB = new JComboBox(caseProduzione);
		cB.setSelectedItem(null);
		panel_10.add(cB);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_11.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_11);
		
		JButton btnNewButton = new JButton("Nuova Casa Di Produzione");
		panel_11.add(btnNewButton);
		
		JPanel panel_12 = new JPanel();
		panel_2.add(panel_12);
		
		JButton btnNewButton_1 = new JButton("Aggiungi");
		panel_12.add(btnNewButton_1);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5, BorderLayout.EAST);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CasaProduzione.main(q, Produzione.this);
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty() || cB.getSelectedItem() == null)
						JOptionPane.showMessageDialog(frame, "Compilare tutto il form");
				
				else {
					
					int budget = Integer.parseInt(textField.getText());
					String casaproduzione = (String) cB.getSelectedItem();
					
					if(budget < 0) {
						JOptionPane.showMessageDialog(frame, "Inserire un budget corretto");
					} else {
						
						q.insertValues("insert into Produzione values (\""+casaproduzione+"\", \""+id+"\", "+budget+");");
						budgetTot.aggiornaBudgetTotale(budget);
						frame.dispose();
						
					}
				}
			}
		});
	}
	
	public void aggiornaComboBox() {
		
		cB.removeAllItems();
		String[] caseProduzione = q.makeQuery("select nome from Casa_produzione");
		
		for(String s: caseProduzione)
			cB.addItem(s);	
		
		cB.setSelectedItem(null);
		
	}
	
	

}
