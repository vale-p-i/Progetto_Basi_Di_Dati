package progetto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class CasaProduzione {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static QueryManager q;
	private static Produzione p;

	/**
	 * Launch the application.
	 */
	public static void main(QueryManager qu, Produzione produzione) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					p = produzione;
					q = qu;
					CasaProduzione window = new CasaProduzione();
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
	public CasaProduzione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(SystemColor.window);
		panel_4.add(panel_1_1);
		panel_1_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3_1 = new JPanel();
		panel_1_1.add(panel_3_1);
		panel_3_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3_1.add(lblNome);
		
		JPanel panel_9 = new JPanel();
		panel_3_1.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		panel_9.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JPanel panel_4_1 = new JPanel();
		panel_1_1.add(panel_4_1);
		panel_4_1.setLayout(new GridLayout(0, 1, 0, 2));
		
		JLabel lblStato = new JLabel("Stato");
		lblStato.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStato.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4_1.add(lblStato);
		
		JPanel panel_12 = new JPanel();
		panel_4_1.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		textField_1 = new JTextField();
		panel_12.add(textField_1, BorderLayout.CENTER);
		textField_1.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_1_1.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Città");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_6.add(lblNewLabel_2);
		
		Panel panel_15 = new Panel();
		panel_6.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		textField_2 = new JTextField();
		panel_15.add(textField_2, BorderLayout.CENTER);
		textField_2.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_1_1.add(panel_7);
		panel_7.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Data di fondazione");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_7.add(lblNewLabel_4);
		
		JPanel panel_18 = new JPanel();
		panel_7.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		JDateChooser dateChooser = new JDateChooser();
		panel_18.add(dateChooser, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_1_1.add(panel_8);
		panel_8.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_22 = new JPanel();
		panel_8.add(panel_22);
		panel_22.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel panel_19 = new JPanel();
		panel_8.add(panel_19);
		panel_19.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_23 = new JPanel();
		panel_19.add(panel_23);
		
		JButton btnNewButton_1 = new JButton("Aggiungi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() || dateChooser.getDate()== null)
					JOptionPane.showMessageDialog(frame, "Compila tutto il form");
				
				else {
					String nome = textField.getText();
					String stato = textField_1.getText();
					String citta = textField_2.getText();
					Calendar data = dateChooser.getCalendar();
					String dd = data.get(Calendar.YEAR) + "-" + data.get(Calendar.MONTH) + "-" + data.get(Calendar.DAY_OF_MONTH);
					
					String[] cp = q.makeQuery("select nome from Casa_produzione");
					
					boolean flag = false;
					
					for(String s: cp)
						if(s.equals(nome)) {
							flag = true;
						}
					
					if(flag) {
						JOptionPane.showMessageDialog(frame, "Questa casa di produzione è già presente");
					} else {
						q.insertValues("insert into Casa_produzione values (\""+nome+"\", \""+stato+"\", \""+citta+"\", \""+dd+"\");");
					
						p.aggiornaComboBox();
						frame.dispose();
					}
				}
			}
		});
		panel_19.add(btnNewButton_1);
		
		
	}

}
