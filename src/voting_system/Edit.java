package voting_system;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Edit {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit window = new Edit();
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
	public Edit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("Presidents Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(63, 85, 150, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnVicePresidentsTable = new JButton("Vice Presidents Table");
		btnVicePresidentsTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVicePresidentsTable.setBounds(63, 126, 150, 30);
		frame.getContentPane().add(btnVicePresidentsTable);
		
		JButton btnSecretariesTable = new JButton("Secretaries Table");
		btnSecretariesTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSecretariesTable.setBounds(63, 167, 150, 30);
		frame.getContentPane().add(btnSecretariesTable);
		
		JButton btnAuditorsTable = new JButton("Auditors Table");
		btnAuditorsTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAuditorsTable.setBounds(223, 105, 150, 30);
		frame.getContentPane().add(btnAuditorsTable);
		
		JButton btnTreasurersTable = new JButton("Treasurers Table");
		btnTreasurersTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTreasurersTable.setBounds(223, 146, 150, 30);
		frame.getContentPane().add(btnTreasurersTable);
	}

}
