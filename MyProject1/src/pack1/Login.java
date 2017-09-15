package pack1;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Login {

	private JFrame frmLogin;
	private JTextField username;
	private JPasswordField pwd;
	protected Component frame;
	private JComboBox comboBox;

	JButton btnOk;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		frmLogin.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		frmLogin = new JFrame();
		frmLogin.setLocationRelativeTo(null);
		frmLogin.setTitle("Login\r\n");
		frmLogin.getContentPane().setBackground(new Color(153, 51, 255));
		frmLogin.getContentPane().setForeground(Color.LIGHT_GRAY);
		frmLogin.setBackground(Color.LIGHT_GRAY);
		frmLogin.setBounds(0, 0, 450, 300);
//		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblLoginInfo = new JLabel("LOGIN INFO");
		lblLoginInfo.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblLoginInfo.setBounds(10, 11, 312, 40);
		frmLogin.getContentPane().add(lblLoginInfo);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(221, 106, 88, 14);
		frmLogin.getContentPane().add(lblUsername);
		
		username = new JTextField();
		username.setBounds(221, 131, 146, 20);
		username.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent k)
			{
				check();
			}
		});
		frmLogin.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(221, 162, 88, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		pwd = new JPasswordField();
		pwd.setBounds(221, 187, 146, 20);
		pwd.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent k)
			{
				check();
			}
		});
		frmLogin.getContentPane().add(pwd);
		
		JLabel lblUsertype = new JLabel("UserType");
		lblUsertype.setForeground(Color.WHITE);
		lblUsertype.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsertype.setBounds(221, 50, 103, 20);
		frmLogin.getContentPane().add(lblUsertype);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrator", "Teacher", "Student"}));
		comboBox.setBounds(221, 75, 146, 20);
		frmLogin.getContentPane().add(comboBox);
		
		btnOk = new JButton("OK");
		btnOk.setForeground(Color.BLACK);
		btnOk.setEnabled(false);
		//btnOk.setMnemonic(KeyEvent.VK_ENTER);
		frmLogin.getRootPane().setDefaultButton(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nn= comboBox.getSelectedItem().toString();
				String uname=username.getText();
				
				String psd  = pwd.getText();
				if(nn.equals("Administrator"))
				{
				
				if(uname.equals("name")&& psd.equals("password"))
				{
					JOptionPane.showMessageDialog(frame, "You are successfully Logged in");
					frmLogin.dispose();
					admin1 ad=new admin1();
					
					
					
				}
				}
				else if(!nn.equals("Administrator"))
				{
					Connection con=MyConnection1.dbConnector();
				try
				{
					
				String query1="Select * from s_info where stid=? and password=?";
				String query2="Select * from t_info where tid=? and password=?";
				PreparedStatement pst1= con.prepareStatement(query1);
				PreparedStatement pst2= con.prepareStatement(query2);
				
				pst1.setString(1,username.getText());
				final String id=username.getText();
				
				pst1.setString(2, pwd.getText());
				pst2.setString(1,username.getText());
				pst2.setString(2, pwd.getText());
				ResultSet rs1=pst1.executeQuery();
				ResultSet rs2=pst2.executeQuery();
				
				

				
				
					if(nn.equals("Teacher"))
					{
					
					
					
						if(rs2.next())
						{
							JOptionPane.showMessageDialog(frame, "You are successfully Logged in");
							
							t_page ad=new t_page();
							ad.setVisible(true);
							frmLogin.dispose();
							
						}
					}
					else if(nn.equals("Student"))
					{
						if(rs1.next())
						{
							JOptionPane.showMessageDialog(frame, "You are successfully Logged in");
							
							System.out.println(id);
							S_page ad=new S_page(id);
							ad.setVisible(true);
							frmLogin.dispose();
						}

					}
				}
				catch(SQLException se)
				{
					System.out.println(se);
				}
				}
				else
				{
					username.setText("");
					pwd.setText("");
				JOptionPane.showMessageDialog(frame, "Invalid username/password");
				username.requestFocusInWindow();
					
				}
				
	
				
				
				}
		});
		btnOk.setBounds(91, 228, 89, 23);
		frmLogin.getContentPane().add(btnOk);
		
		JLabel label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("img/login.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(34, 62, 146, 145);
		frmLogin.getContentPane().add(label);
		
		frmLogin.setVisible(true);
	}
	void check()
	{
		String aaa=username.getText().trim();
		String bbb=new String(pwd.getPassword()).trim();
		if(aaa.length()>0 && bbb.length()>0)
		{
			btnOk.setEnabled(true);
		}
		else
		{
			btnOk.setEnabled(false);
		}
	}
}
