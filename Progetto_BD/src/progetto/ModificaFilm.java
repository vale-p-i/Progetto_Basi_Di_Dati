package progetto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificaFilm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static String titolo;
	private static int ore;
	private static int minuti;
	private static int anno;
	private static int mese;
	private static int giorno;
	private static String regista;
	private static int id;
	private static QueryManager q;
	

	/**
	 * Launch the application.
	 */
	public static void main(String tit, int aa, int mm, int gg, int h, int m, String reg, int ID, QueryManager qu) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					q = qu;
					id = ID;
					titolo = tit;
					ore = h;
					anno = aa;
					mese = mm-1;
					giorno = gg;
					minuti = m;
					regista = reg;
					ModificaFilm window = new ModificaFilm();
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
	public ModificaFilm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Modifica Film");
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
		spinField.setValue(ore);
		
		Panel panel_15 = new Panel();
		panel_6.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_15.add(panel_17, BorderLayout.CENTER);
		panel_17.setLayout(new GridLayout(0, 3, 0, 0));
		
		JSpinField spinField_1 = new JSpinField(0, 60);
		panel_17.add(spinField_1);
		spinField_1.setAlignmentX(1.0f);
		spinField_1.setValue(minuti);
		
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
				
				if(textField.getText().equals(titolo) && aa == anno && mm == mese && gg == giorno && spinField.getValue() == ore && spinField_1.getValue() == minuti && textField_1.getText().equals(regista))
					JOptionPane.showMessageDialog(frame, "Modificare i campi per modificare il titolo");
				else {
					q.insertValues("update Titolo set nome = \""+textField.getText()+"\", ddu= \""+aa+"-"+(mm+1)+"-"+gg+"\", durata = \""+spinField.getValue()+":"+spinField_1.getValue()+":00\", regista = \""+textField_1.getText()+"\"  where id = "+id+";");
					frame.dispose();
				}
			}
		});
	}

}
