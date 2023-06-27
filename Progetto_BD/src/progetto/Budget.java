package progetto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Budget {

	private JFrame frame;
	private static QueryManager q;
	private static int id;
	private static int budget_totale;
	private JLabel lblNewLabel_1;
	private static Object titolo;

	/**
	 * Launch the application.
	 */
	public static void main(QueryManager qu, int x, Object tit) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					titolo = tit;
					id = x;
					q = qu;
					Budget window = new Budget();
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
	public Budget() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 523, 177);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(0);
		flowLayout.setVgap(12);
		panel_9.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Aggiungi Budget Totale");
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		JLabel lblNewLabel = new JLabel("Budget totale:");
		panel_7.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		String[] tmp = q.makeQuery("select t.budget_totale from Titolo t where t.id = "+id+";");
		budget_totale = Integer.parseInt(tmp[0]);
				
		lblNewLabel_1 = new JLabel("0");
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JButton btnNewButton = new JButton("Aggiungi Produzione");
		panel_4.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produzione.main(q, id, Budget.this);
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (budget_totale != 0) {
					if(titolo.getClass().getSimpleName().equals("Film")) {
					
						Film film = (Film) titolo;
						film.budget(budget_totale);
					} else if(titolo.getClass().getSimpleName().equals("Serie") ){
					
						Serie serie = (Serie) titolo;
						serie.budget(budget_totale);
					}
				
					frame.dispose();
				}
			}
		});
	}
	
	public void aggiornaBudgetTotale(int x) {
		
		budget_totale+= x;
		
		lblNewLabel_1.setText(budget_totale + "");
		
	}

}
