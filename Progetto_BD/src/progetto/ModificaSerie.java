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

public class ModificaSerie {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static String titolo;
	private static String stagioni;
	private static int anno;
	private static int mese;
	private static int giorno;
	private static String regista;
	private static int id;
	private static QueryManager q;
	private JTextField textField_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String tit, int aa, int mm, int gg, String st, String reg, int ID, QueryManager qu) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					q = qu;
					id = ID;
					titolo = tit;
					anno = aa;
					mese = mm-1;
					giorno = gg;
					stagioni = st;
					regista = reg;
					ModificaSerie window = new ModificaSerie();
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
	public ModificaSerie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Modifica Serie");
		frame.setBounds(100, 100, 540, 401);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 238, 238));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
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
		textField.setText(titolo);
		
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
		
		
		Calendar data = Calendar.getInstance();
		data.set(anno, mese, giorno);
		JDateChooser dateChooser = new JDateChooser();
		panel_12.add(dateChooser, BorderLayout.CENTER);
		dateChooser.setCalendar(data);
		
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblStagioni = new JLabel("Stagioni");
		lblStagioni.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStagioni.setHorizontalAlignment(SwingConstants.LEFT);
		panel_6.add(lblStagioni);
		
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
		textField_1.setText(regista);
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		panel_8.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_22 = new JPanel();
		panel_8.add(panel_22);
		panel_22.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		
		JPanel panel_19 = new JPanel();
		panel_8.add(panel_19);
		panel_19.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_23 = new JPanel();
		panel_19.add(panel_23);
		
		JButton btnNewButton_1 = new JButton("Modifica Film");
		panel_19.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_10 = new JPanel();
		frame.getContentPane().add(panel_10, BorderLayout.WEST);
		
		JPanel panel_11 = new JPanel();
		frame.getContentPane().add(panel_11, BorderLayout.EAST);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Calendar data = dateChooser.getCalendar();
				int aa = data.get(Calendar.YEAR);
				int mm = data.get(Calendar.MONTH);
				int gg = data.get(Calendar.DAY_OF_MONTH);
				
				if(textField.getText().equals(titolo) && aa == anno && mm == mese && gg == giorno && textField_1.getText().equals(regista) && textField_2.getText().equals(stagioni))
					JOptionPane.showMessageDialog(frame, "Modificare i campi per modificare il titolo");
				else {
					q.insertValues("update Titolo set nome = \""+textField.getText()+"\", ddu= \""+aa+"-"+(mm+1)+"-"+gg+"\", regista = \""+textField_1.getText()+"\", stagioni = "+stagioni+"  where id = "+id+";");
					frame.dispose();
				}
			}
		});
	}

}