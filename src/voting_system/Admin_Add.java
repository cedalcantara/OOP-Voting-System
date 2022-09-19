package voting_system;


import java.awt.*;
import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.sql.*;

public class Admin_Add {

	private JFrame frmAdd;
	
	public static void Add() {
		
					Admin_Add window = new Admin_Add();
					window.frmAdd.setVisible(true);
				
	}
	public Admin_Add() {
		initialize();
	}
	private void initialize() {
		frmAdd = new JFrame();
		frmAdd.setTitle("Administrator");
		frmAdd.setBounds(100, 100, 450, 300);
		frmAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdd.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdd.dispose();
				Admin_Login.NewWindow();
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		frmAdd.getContentPane().add(btnBack);
		
		JButton btnAddVoter = new JButton("Add Voter");
		btnAddVoter.setBounds(150, 95, 164, 23);
		frmAdd.getContentPane().add(btnAddVoter);
		btnAddVoter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Add_Voter.add();
				frmAdd.dispose();
			}
		});

		JButton btnAddCandidate = new JButton("Add Candidate");
		btnAddCandidate.setBounds(150, 55, 164, 23);
		frmAdd.getContentPane().add(btnAddCandidate);
        btnAddCandidate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Add_Candidate.add();
				frmAdd.dispose();
			}
		});
        
        JButton btnDltCandidate = new JButton("Delete Candidate");
		btnDltCandidate.setBounds(150, 135, 164, 23);
		frmAdd.getContentPane().add(btnDltCandidate);
        btnDltCandidate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Delete_Candidate.delete();
				frmAdd.dispose();
			}
		});
        JButton btnUpdtCandidate = new JButton("Update Candidate");
		btnUpdtCandidate.setBounds(150, 175, 164, 23);
		frmAdd.getContentPane().add(btnUpdtCandidate);
		btnUpdtCandidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_Candidate.add();
				frmAdd.dispose();
			}
		});
		JButton btnShow = new JButton("Show Data");
		btnShow.setBounds(150, 215, 164, 23);
		frmAdd.getContentPane().add(btnShow);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show();
				frmAdd.dispose();
			}
		});
	}
	
	public void pres() {
		
		JTable table;
		JScrollPane sp = new JScrollPane();
		JFrame frShow = new JFrame("PRESENT DATA");
		frShow.setBounds(100, 100, 600, 450);
		frShow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frShow.setVisible(true);
		frShow.getContentPane().setLayout(null);
		table = new JTable();
		sp.setBounds(70, 80, 460, 260);
		frShow.getContentPane().add(sp);
		JLabel lblNewLabel = new JLabel("PRESIDENTS TABLE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(180, 28, 330, 40);
		frShow.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frShow.dispose();
				show();
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		frShow.getContentPane().add(btnBack);

		try{
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\voting_system\\src\\voting_system\\Database1.accdb");
			String qr  = "SELECT lname,fname,Tally FROM Candidates WHERE pos LIKE 'PRES'";
			PreparedStatement stmt = con.prepareStatement(qr);
			ResultSet rs = stmt.executeQuery();
			sp.setViewportView(table);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void vp() {
		
		JTable table;
		JScrollPane sp = new JScrollPane();
		JFrame frShow = new JFrame("PRESENT DATA");
		frShow.setBounds(100, 100, 600, 450);
		frShow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frShow.setVisible(true);
		frShow.getContentPane().setLayout(null);
		table = new JTable();
		sp.setBounds(70, 80, 460, 260);
		frShow.getContentPane().add(sp);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frShow.dispose();
				show();
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		frShow.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("VICE PRESIDENTS TABLE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(129, 28, 373, 41);
		frShow.getContentPane().add(lblNewLabel);
		
		
		try{
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\voting_system\\src\\voting_system\\Database1.accdb");
			String qr  = "SELECT lname,fname,Tally FROM Candidates WHERE pos LIKE 'VP'";
			PreparedStatement stmt = con.prepareStatement(qr);
			ResultSet rs = stmt.executeQuery();
			sp.setViewportView(table);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sec() {
		
		JTable table;
		JScrollPane sp = new JScrollPane();
		JFrame frShow = new JFrame("PRESENT DATA");
		frShow.setBounds(100, 100, 600, 450);
		frShow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frShow.setVisible(true);
		frShow.getContentPane().setLayout(null);
		table = new JTable();
		sp.setBounds(70, 80, 460, 260);
		frShow.getContentPane().add(sp);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frShow.dispose();
				show();
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		frShow.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("SECRETARIES TABLE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(156, 28, 338, 41);
		frShow.getContentPane().add(lblNewLabel);
		
		try{
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\voting_system\\src\\voting_system\\Database1.accdb");
			String qr  = "SELECT lname,fname,Tally FROM Candidates WHERE pos LIKE 'SEC'";
			PreparedStatement stmt = con.prepareStatement(qr);
			ResultSet rs = stmt.executeQuery();
			sp.setViewportView(table);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void audit() {
		
		JTable table;
		JScrollPane sp = new JScrollPane();
		JFrame frShow = new JFrame("PRESENT DATA");
		frShow.setBounds(100, 100, 600, 450);
		frShow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frShow.setVisible(true);
		frShow.getContentPane().setLayout(null);
		table = new JTable();
		sp.setBounds(70, 80, 460, 260);
		frShow.getContentPane().add(sp);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frShow.dispose();
				show();
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		frShow.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("AUDITORS TABLE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(191, 28, 338, 41);
		frShow.getContentPane().add(lblNewLabel);
		
		try{
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\voting_system\\src\\voting_system\\Database1.accdb");
			String qr  = "SELECT lname,fname,Tally FROM Candidates WHERE pos LIKE 'AUD'";
			PreparedStatement stmt = con.prepareStatement(qr);
			ResultSet rs = stmt.executeQuery();
			sp.setViewportView(table);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void trea() {
		
		JTable table;
		JScrollPane sp = new JScrollPane();
		JFrame frShow = new JFrame("PRESENT DATA");
		frShow.setBounds(100, 100, 600, 450);
		frShow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frShow.setVisible(true);
		frShow.getContentPane().setLayout(null);
		table = new JTable();
		sp.setBounds(70, 80, 460, 260);
		frShow.getContentPane().add(sp);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frShow.dispose();
				show();
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		frShow.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("TREASURERS TABLE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(165, 28, 364, 41);
		frShow.getContentPane().add(lblNewLabel);
		
		try{
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\voting_system\\src\\voting_system\\Database1.accdb");
			String qr  = "SELECT lname,fname,Tally FROM Candidates WHERE pos LIKE 'TREA'";
			PreparedStatement stmt = con.prepareStatement(qr);
			ResultSet rs = stmt.executeQuery();
			sp.setViewportView(table);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void show() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Add();
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("Presidents Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				pres();
			}
		});
		btnNewButton.setBounds(63, 85, 150, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnVicePresidentsTable = new JButton("Vice Presidents Table");
		btnVicePresidentsTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				vp();
			}
		});
		btnVicePresidentsTable.setBounds(63, 126, 150, 30);
		frame.getContentPane().add(btnVicePresidentsTable);
		
		JButton btnSecretariesTable = new JButton("Secretaries Table");
		btnSecretariesTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				sec();
			}
		});
		btnSecretariesTable.setBounds(63, 167, 150, 30);
		frame.getContentPane().add(btnSecretariesTable);
		
		JButton btnAuditorsTable = new JButton("Auditors Table");
		btnAuditorsTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				audit();
			}
		});
		btnAuditorsTable.setBounds(223, 105, 150, 30);
		frame.getContentPane().add(btnAuditorsTable);
		
		JButton btnTreasurersTable = new JButton("Treasurers Table");
		btnTreasurersTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				trea();
			}
		});
		btnTreasurersTable.setBounds(223, 146, 150, 30);
		frame.getContentPane().add(btnTreasurersTable);
	}
}
