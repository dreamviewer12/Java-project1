package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginF extends JDialog implements ActionListener
{
	private JTextField u;
	private JPasswordField p;
	private JButton submit;
	private JButton cancel;

	public LoginF() 
	{
		getContentPane().setBackground(new Color(255, 0, 0));
		setResizable(false);
		setTitle("Login");
	    getContentPane().setLayout(null);
	    
	    JLabel user = new JLabel("Username");
	    user.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	    user.setBounds(45, 78, 124, 30);
	    getContentPane().add(user);
	    
	    JLabel pass = new JLabel("Password");
	    pass.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	    pass.setBounds(45, 119, 124, 30);
	    getContentPane().add(pass);
	    
	    u = new JTextField();
	    u.setBounds(200, 75, 174, 30);
	    getContentPane().add(u);
	    u.setColumns(10);
	    
	    p = new JPasswordField();
	    p.setBounds(200, 122, 174, 27);
	    getContentPane().add(p);
	    
	    submit = new JButton("Login");
	    submit.setBackground(Color.GREEN);
	    submit.setMnemonic('l');
	    submit.setBounds(94, 204, 89, 23);
	    getContentPane().add(submit);
	    
	    cancel = new JButton("Cancel");
	    cancel.setBackground(Color.CYAN);
	    cancel.setMnemonic('c');
	    cancel.setBounds(222, 204, 89, 23);
	    getContentPane().add(cancel);
	    
	    
	    setSize(400, 300);
	    getRootPane().setDefaultButton(submit);//important
	    setLocationRelativeTo(null);//important
	    submit.addActionListener(this);
	    cancel.addActionListener(this);
	    setVisible(true);
	}

	public static void main(String[] args) {
		
          new LoginF();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==cancel)
		{
			System.exit(0);
		}
		else if(ob==submit)
		{
			String user=u.getText();
		
			String pass=new String (p.getPassword());
			String s="select * from login where username=? and password=?";
			Connection con=MyConnection.connect();
			try
			{
				PreparedStatement ps=con.prepareStatement(s);
				ps.setString(1,user);
				ps.setString(2, pass);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{new HomePage();
				dispose();
				}//important.....is checking whether this employee exists...checks whether it returns 1 row or not?
				else 
				{
					p.setText("");
					u.setText("");
					JOptionPane.showMessageDialog(null, "Invalid");
					u.requestFocusInWindow();
					
				}//important
				
			}
			catch(SQLException se)
			{
				System.out.println(se);
			}
			
			
		}
	}
}
