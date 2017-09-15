package pack1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;

import javax.swing.ImageIcon;

public class S_page extends JFrame   

{
	
	

	private JPanel contentPane;
	private JLabel att1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					S_page frame = new S_page(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public S_page(final String sid) {
	
		
		
		setTitle("Student Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setBackground(new Color(100, 149, 237));
		btnLogout.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "You are successfully Logged out");
						dispose();
						Login ad=new Login();
						
					}
				});
		  
		  JButton btnOk = new JButton("OK");
		  btnOk.setBackground(Color.LIGHT_GRAY);
		  btnOk.addActionListener(new ActionListener() {
		  			
		  			@Override
		  			public void actionPerformed(ActionEvent e) 
		  			{
		  				String batch=comboBox.getSelectedItem().toString();
		  				System.out.println("In action performed batch="+batch);
		  				System.out.println("In action performed sid="+sid);
		  				String st="select status from "+batch+" where stid='" + sid +"'";
		  				System.out.println(sid);
		  				Connection con = MyConnection1.dbConnector();
		  				try
		  				{
		  					PreparedStatement ps = con.prepareStatement(st);
		  					ResultSet rs = ps.executeQuery();
		  					String status1;
		  					
		  					while(rs.next())
		  					{
		  						String sta=rs.getString(1);
		  						if(sta.equals("P"))
		  							status1="Present";
		  						else
		  							status1="Absent";
		  						att1.setText(status1);
		  					
		  						
		  					}
		  				}
		  				catch(SQLException se)
		  				{
		  					System.out.println(se);
		  				}
		  			}
		  		});
		  btnOk.setBounds(338, 84, 121, 45);
		  contentPane.add(btnOk);
		  
		  att1 = new JLabel("");
		  att1.setFont(new Font("Tahoma", Font.BOLD, 20));
		  att1.setBounds(204, 174, 168, 35);
		  contentPane.add(att1);
		
		  comboBox = new JComboBox();
		  comboBox.setBackground(new Color(255, 255, 255));
		  comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Android ", "Python", "Java"}));
		  
		  		comboBox.setBounds(63, 81, 137, 45);
		  		contentPane.add(comboBox);
		btnLogout.setBounds(5, 5, 1357, 35);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(S_page.class.getResource("/pack1/img/s1page.jpg")));
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension d=tk.getScreenSize();
		int h=(int)d.getHeight();
		int w=(int)d.getWidth();
	  // setLocation(0,0);
		lblNewLabel.setBounds(0, 0, w, h);
		
		contentPane.add(lblNewLabel);
		this.setSize(this.getMaximumSize());
		this.setLocation(0, 0);
		this.setVisible(true);
		
		
	}
}
