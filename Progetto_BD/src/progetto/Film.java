package progetto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import java.awt.Panel;
import com.toedter.components.JSpinField;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;


public class Film {
	
	

	private JFrame frmNuovoTitolo;
	private JTextField textField;
	private JTextField textField_1;
	private static QueryManager q;
	private static int budget;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton;
	private static int id = 0;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(QueryManager qu) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					budget= 0;
					q = qu;
					Film window = new Film();
					window.frmNuovoTitolo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Film() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNuovoTitolo = new JFrame();
		frmNuovoTitolo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNuovoTitolo.setTitle("Nuovo Film");
		frmNuovoTitolo.setBounds(100, 100, 540, 401);
		
		JPanel panel = new JPanel();
		frmNuovoTitolo.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 238, 238));
		frmNuovoTitolo.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Titolo");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(lblNewLabel);
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		panel_9.add(textField);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 2));
		
		JLabel lblDataDiUscita = new JLabel("Data di uscita");
		panel_4.add(lblDataDiUscita);
		lblDataDiUscita.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDataDiUscita.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JDateChooser dateChooser = new JDateChooser();
		panel_12.add(dateChooser, BorderLayout.CENTER);
		
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Ore");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_6.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Minuti");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_6.add(lblNewLabel_3);
		
		Panel panel_14 = new Panel();
		panel_6.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_20 = new JPanel();
		panel_14.add(panel_20, BorderLayout.SOUTH);
		
		JPanel panel_21 = new JPanel();
		panel_14.add(panel_21, BorderLayout.CENTER);
		panel_21.setLayout(new GridLayout(0, 3, 0, 0));
		
		JSpinField spinField = new JSpinField(0,24);
		panel_21.add(spinField);
		spinField.getSpinner().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		spinField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		Panel panel_15 = new Panel();
		panel_6.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_15.add(panel_17, BorderLayout.CENTER);
		panel_17.setLayout(new GridLayout(0, 3, 0, 0));
		
		JSpinField spinField_1 = new JSpinField(0, 60);
		panel_17.add(spinField_1);
		spinField_1.setAlignmentX(1.0f);
		
		JPanel panel_16 = new JPanel();
		panel_15.add(panel_16, BorderLayout.SOUTH);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Regista");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_7.add(lblNewLabel_4);
		
		JPanel panel_18 = new JPanel();
		panel_7.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		textField_1 = new JTextField();
		panel_18.add(textField_1, BorderLayout.CENTER);
		textField_1.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		panel_8.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_22 = new JPanel();
		panel_8.add(panel_22);
		panel_22.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		btnNewButton = new JButton("Budget");
		panel_22.add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("");
		panel_22.add(lblNewLabel_5);
		
		JPanel panel_19 = new JPanel();
		panel_8.add(panel_19);
		panel_19.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_23 = new JPanel();
		panel_19.add(panel_23);
		
		btnNewButton_1 = new JButton("Inserisci Film");
		panel_19.add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		
		JPanel panel_2 = new JPanel();
		frmNuovoTitolo.getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_10 = new JPanel();
		frmNuovoTitolo.getContentPane().add(panel_10, BorderLayout.WEST);
		
		JPanel panel_11 = new JPanel();
		frmNuovoTitolo.getContentPane().add(panel_11, BorderLayout.EAST);
		
		//inserire budget totale
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isEmpty() || textField_1.getText().isEmpty() || dateChooser.getDate() == null || (spinField.getValue() == 0 && spinField_1.getValue() == 0))
					JOptionPane.showMessageDialog(frmNuovoTitolo, "Compilare tutto il form");
				
				else {
					String titolo = textField.getText();
					Calendar data = dateChooser.getCalendar();
					String ddu = data.get(Calendar.YEAR) + "-" + (data.get(Calendar.MONTH)+1) + "-" + data.get(Calendar.DAY_OF_MONTH);
					int ore = spinField.getValue();
					int minuti = spinField_1.getValue();
					String regista = textField_1.getText();
					
					String[] tmp = q.makeQuery("select * from Titolo t where t.nome = \""+titolo+"\" and t.ddu = \""+ddu+"\" and t.regista = \""+regista+"\";");
					if(tmp.length != 0) {
						JOptionPane.showMessageDialog(frmNuovoTitolo, "Titolo già presente");
					} else {
					
						String[] tmp1 = q.makeQuery("select max(id) from Titolo;");
						id = Integer.parseInt(tmp1[0]) + 1;
						
						q.insertValues("insert into Titolo values ("+id+",\""+titolo+"\", \""+ddu+"\", \"film\", null,  \""+ore+":"+minuti+":00\",\""+regista+"\", 0);");
						
						Budget.main(q, id, Film.this);
					}
				}
			}
		});
		
		//inserire film
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(budget == 0) {
					JOptionPane.showMessageDialog(frmNuovoTitolo, "Compila tutto il form");
				} else {
					
					q.insertValues("update Titolo set budget_totale ="+budget+" where id = "+id+";");
					
					frmNuovoTitolo.dispose();
				}
				
				
			}
		});
	}
	
	public void budget(int x) {
		 budget = x;
		 lblNewLabel_5.setText(x + "");
		 btnNewButton.setEnabled(false);
		 btnNewButton_1.setEnabled(true);
		 
	}
}
