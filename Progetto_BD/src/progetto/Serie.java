package progetto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

public class Serie {

	private JFrame frmNuovaSerie;
	private JTextField textField;
	private JTextField textField_1;
	private static QueryManager q;
	private JTextField textField_2;
	private static int budget;
	private JLabel lblNewLabel_3;
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
					budget = 0;
					q = qu;
					Serie window = new Serie();
					window.frmNuovaSerie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Serie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNuovaSerie = new JFrame();
		frmNuovaSerie.setTitle("Nuova Series");
		frmNuovaSerie.setBounds(100, 100, 540, 401);
		frmNuovaSerie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmNuovaSerie.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 238, 238));
		frmNuovaSerie.getContentPane().add(panel_1, BorderLayout.CENTER);
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
		
		JLabel lblNewLabel_2 = new JLabel("Stagioni");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_6.add(lblNewLabel_2);
		
		Panel panel_15 = new Panel();
		panel_6.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		textField_2 = new JTextField();
		panel_15.add(textField_2, BorderLayout.CENTER);
		textField_2.setColumns(10);
		
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
		
		lblNewLabel_3 = new JLabel("");
		panel_22.add(lblNewLabel_3);
		
		JPanel panel_19 = new JPanel();
		panel_8.add(panel_19);
		panel_19.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_23 = new JPanel();
		panel_19.add(panel_23);
		
		btnNewButton_1 = new JButton("Inserisci Serie");
		panel_19.add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		
		
		JPanel panel_2 = new JPanel();
		frmNuovaSerie.getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_10 = new JPanel();
		frmNuovaSerie.getContentPane().add(panel_10, BorderLayout.WEST);
		
		JPanel panel_11 = new JPanel();
		frmNuovaSerie.getContentPane().add(panel_11, BorderLayout.EAST);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty() || textField_1.getText().isEmpty() || dateChooser.getDate() == null || textField_2.getText().isEmpty())
					JOptionPane.showMessageDialog(frmNuovaSerie, "Compilare tutto il form");
				
				else {
					String titolo = textField.getText();
					Calendar data = dateChooser.getCalendar();
					String ddu = data.get(Calendar.YEAR) + "-" + (data.get(Calendar.MONTH)+1) + "-" + data.get(Calendar.DAY_OF_MONTH);
					int stagioni = Integer.parseInt(textField_2.getText());
					String regista = textField_1.getText();
					
					String[] tmp = q.makeQuery("select * from Titolo t where t.nome = \""+titolo+"\" and t.ddu = \""+ddu+"\" and t.regista = \""+regista+"\";");
					if(tmp.length != 0) {
						JOptionPane.showMessageDialog(frmNuovaSerie, "Titolo già presente");
					} else {
					
						String[] tmp1 = q.makeQuery("select max(id) from Titolo;");
						id = Integer.parseInt(tmp1[0]) + 1;
						
						q.insertValues("insert into Titolo values ("+id+"\""+titolo+"\", \""+ddu+"\", \"serie\", \""+stagioni+"\", null,\""+regista+"\", 0);");
						
						Budget.main(q, id, Serie.this);
					}
				}
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(budget == 0) {
					JOptionPane.showMessageDialog(frmNuovaSerie, "Compila tutto il form");
				} else {
					
					q.insertValues("update Titolo set budget_totale ="+budget+" where id = "+id+";");
					frmNuovaSerie.dispose();
				}
			}
		});
	}
	
	public void budget(int x) {
		 budget = x;
		 lblNewLabel_3.setText(x + "");
		 btnNewButton.setEnabled(false);
		 btnNewButton_1.setEnabled(true);
	}

}
