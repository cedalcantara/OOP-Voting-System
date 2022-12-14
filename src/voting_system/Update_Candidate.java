package voting_system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Update_Candidate extends JFrame{
	private JFrame frame;
	private JTextField stdno;
	private JTextField fname;
	private JTextField lname;
	private JTable table;
	public static void add() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Candidate window = new Update_Candidate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Update_Candidate() {
		super("Update Candidate");
		initialize();
	}
	private void initialize(){
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 442, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_Add.Add();
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblStudentNumber = new JLabel("Enter Student Number of Candidate to Update:");
		lblStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblStudentNumber.setBounds(22, 49, 350, 13);
		frame.getContentPane().add(lblStudentNumber);
		
		JFrame frame2 = new JFrame();
		frame2.setTitle("Update Candidate");
		frame2.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame2.setBounds(100, 100, 442, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		
		
		stdno = new JTextField();
		stdno.setBounds(172, 80, 100, 19);
		frame.getContentPane().add(stdno);
		stdno.setColumns(10);
	
		stdno.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e){ 
				String stdnum = stdno.getText();
				
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try{
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\voting_system\\src\\voting_system\\Database1.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT studnum, lname, fname FROM Candidates");
					int i=1;
					
					while (rs.next()) {
						String x = rs.getString("studnum");
						if (stdnum.equals(x) )
						{
							i=0;
							String y = rs.getString("fname");
							String z = rs.getString("lname");
							JLabel lblStudentNumber = new JLabel("Name: "+z+", "+y);
							lblStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
							lblStudentNumber.setHorizontalAlignment(SwingConstants.TRAILING);
							lblStudentNumber.setBounds(95, 49, 200, 20);
							frame2.getContentPane().add(lblStudentNumber);
							break;
						}
						
						else
							i=1;
					}
					
				 if (i==1) {
						JOptionPane.showMessageDialog(frame, "Student Not Found!");
					}
					else if (i==0) {
						JOptionPane.showMessageDialog(frame, "Student Found!");
						frame.dispose();
						
					
						
						JLabel lblFirstName = new JLabel("First Name:");
						lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblFirstName.setBounds(80, 82, 130, 13);
						frame2.getContentPane().add(lblFirstName);
						
						JLabel lblLastName = new JLabel("Last Name:");
						lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblLastName.setBounds(80, 117, 82, 13);
						frame2.getContentPane().add(lblLastName);
						
						JLabel lblPosition = new JLabel("Position:");
						lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblPosition.setBounds(99, 155, 82, 20);
						frame2.getContentPane().add(lblPosition);
						
						/*JTextField stdno2 = new JTextField();
						stdno2.setBounds(172, 48, 96, 19);
						frame2.getContentPane().add(stdno2);
						stdno2.setColumns(10);
						*/
						JTextField fname2 = new JTextField();
						fname2.setBounds(172, 81, 96, 19);
						frame2.getContentPane().add(fname2);
						fname2.setColumns(10);
						
						JTextField lname2 = new JTextField();
						lname2.setBounds(172, 116, 96, 19);
						frame2.getContentPane().add(lname2);
						lname2.setColumns(10);
						
						JComboBox cb = new JComboBox();
						cb.setBounds(172, 158, 96, 19);
						frame2.getContentPane().add(cb);
						cb.addItem("President");
						cb.addItem("Vice President");
						cb.addItem("Auditor");
						cb.addItem("Secretary");
						cb.addItem("Treasurer");
						
						JButton btnNewButton = new JButton("Enter");
						btnNewButton.setBounds(172, 191, 96, 22);
						frame2.getContentPane().add(btnNewButton);
						btnNewButton.addActionListener(new ActionListener() { 
							public void actionPerformed(ActionEvent e){ 
								try{ 
								Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
								}catch(ClassNotFoundException cn) {
									System.out.println("There was a problem in your code");
									cn.printStackTrace();
								}
								try {
								Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\voting_system\\src\\voting_system\\Database1.accdb");
								PreparedStatement upd = con.prepareStatement("UPDATE Candidates "+"SET fname=?, " +"lname=?, "+"pos=? "+ "WHERE studnum ='"+stdnum+"'"); 
								String pos = (String) cb.getSelectedItem();
								String first =fname2.getText();
								String second =lname2.getText();
								//upd.setString(1, stdno.getText().toString()); 
								upd.setString(1, first); 
								upd.setString(2, second); 
								
								if(pos.equals("President")) {
									upd.setString(3, "PRES");}
								else if(pos.equals("Vice President")) {
									upd.setString(3, "VP");}
								else if(pos.equals("Auditor")) {
									upd.setString(3, "AUD");}
								else if(pos.equals("Secretary")) {
									upd.setString(3, "SEC");}
								else if(pos.equals("Treasurer")) {
									upd.setString(3, "TREA");}

								upd.executeUpdate(); 

								JOptionPane.showMessageDialog(null, "Data successfully saved"); 
								frame2.dispose();
								} catch(SQLException sql) {
									sql.printStackTrace();
								}
							}
							}); 
							frame2.getContentPane().add(btnNewButton); 
							frame2.setVisible(true);
					}
				} catch(SQLException sql) {
					sql.printStackTrace();
					}

			}
		});
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(172, 110, 96, 22);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e){ 
				String stdnum = stdno.getText();
				
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try{
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\voting_system\\src\\voting_system\\Database1.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT studnum, lname, fname FROM Candidates");
					int i=1;
					
					while (rs.next()) {
						String x = rs.getString("studnum");
						if (stdnum.equals(x) )
						{
							i=0;
							String y = rs.getString("fname");
							String z = rs.getString("lname");
							JLabel lblStudentNumber = new JLabel("Name: "+z+", "+y);
							lblStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
							lblStudentNumber.setHorizontalAlignment(SwingConstants.TRAILING);
							lblStudentNumber.setBounds(95, 49, 200, 20);
							frame2.getContentPane().add(lblStudentNumber);
							break;
						}
						
						else
							i=1;
					}
					
				 if (i==1) {
						JOptionPane.showMessageDialog(frame, "Student Not Found!");
					}
					else if (i==0) {
						JOptionPane.showMessageDialog(frame, "Student Found!");
						frame.dispose();
						
					
						
						JLabel lblFirstName = new JLabel("First Name:");
						lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblFirstName.setBounds(80, 82, 130, 13);
						frame2.getContentPane().add(lblFirstName);
						
						JLabel lblLastName = new JLabel("Last Name:");
						lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblLastName.setBounds(80, 117, 82, 13);
						frame2.getContentPane().add(lblLastName);
						
						JLabel lblPosition = new JLabel("Position:");
						lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblPosition.setBounds(99, 155, 82, 20);
						frame2.getContentPane().add(lblPosition);
						
						/*JTextField stdno2 = new JTextField();
						stdno2.setBounds(172, 48, 96, 19);
						frame2.getContentPane().add(stdno2);
						stdno2.setColumns(10);
						*/
						JTextField fname2 = new JTextField();
						fname2.setBounds(172, 81, 96, 19);
						frame2.getContentPane().add(fname2);
						fname2.setColumns(10);
						
						JTextField lname2 = new JTextField();
						lname2.setBounds(172, 116, 96, 19);
						frame2.getContentPane().add(lname2);
						lname2.setColumns(10);
						
						JComboBox cb = new JComboBox();
						cb.setBounds(172, 158, 96, 19);
						frame2.getContentPane().add(cb);
						cb.addItem("President");
						cb.addItem("Vice President");
						cb.addItem("Auditor");
						cb.addItem("Secretary");
						cb.addItem("Treasurer");
						
						JButton btnNewButton = new JButton("Enter");
						btnNewButton.setBounds(172, 191, 96, 22);
						frame2.getContentPane().add(btnNewButton);
						btnNewButton.addActionListener(new ActionListener() { 
							public void actionPerformed(ActionEvent e){ 
								try{ 
								Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
								}catch(ClassNotFoundException cn) {
									System.out.println("There was a problem in your code");
									cn.printStackTrace();
								}
								try {
								Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\voting_system\\src\\voting_system\\Database1.accdb");
								PreparedStatement upd = con.prepareStatement("UPDATE Candidates "+"SET fname=?, " +"lname=?, "+"pos=? "+ "WHERE studnum ='"+stdnum+"'"); 
								String pos = (String) cb.getSelectedItem();
								String first =fname2.getText();
								String second =lname2.getText();
								//upd.setString(1, stdno.getText().toString()); 
								upd.setString(1, first); 
								upd.setString(2, second); 
								
								if(pos.equals("President")) {
									upd.setString(3, "PRES");}
								else if(pos.equals("Vice President")) {
									upd.setString(3, "VP");}
								else if(pos.equals("Auditor")) {
									upd.setString(3, "AUD");}
								else if(pos.equals("Secretary")) {
									upd.setString(3, "SEC");}
								else if(pos.equals("Treasurer")) {
									upd.setString(3, "TREA");}

								upd.executeUpdate(); 

								JOptionPane.showMessageDialog(null, "Data successfully saved"); 
								frame2.dispose();
								} catch(SQLException sql) {
									sql.printStackTrace();
								}
							}
							}); 
							frame2.getContentPane().add(btnNewButton); 
							frame2.setVisible(true);
					}
				} catch(SQLException sql) {
					sql.printStackTrace();
					}

			}
		});
			
			frame.getContentPane().add(btnNewButton); 
	}
}
