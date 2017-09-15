package pack1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class student1 extends JPanel
{
	private JTextField name;
	private JButton cancel;
	private JButton clear;
	private JButton save;
	private JLabel sem;
	private JLabel lblStName;
	private JLabel lblStId;
	private JLabel lblStudentInfo;
	private JLabel lblNewLabel;
	private JTextField id;
	private JPanel j;
	String id1;

	
	private JComboBox comboBox_2;
	public student1() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(Color.MAGENTA);
		setLayout(null);
		
		
		
		lblStId = new JLabel("St Id");
		lblStId.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblStId.setBounds(29, 85, 46, 14);
		add(lblStId);
		
		lblStName = new JLabel("St Name");
		lblStName.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblStName.setBounds(29, 123, 78, 14);
		add(lblStName);
		
		sem = new JLabel("Batch");
		sem.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		sem.setBounds(29, 162, 78, 14);
		add(sem);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(183, 82, 239, 20);
		add(id);
		id.setColumns(10);
		generateId();
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(183, 120, 239, 20);
		add(name);
		
		save = new JButton("Save");
		save.setBackground(Color.GRAY);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String st="insert into s_info(stid,stname,stbatch,password) values (?,?,?,?)";
				String sid=id.getText();
				String sname=name.getText();
				String sbatch=comboBox_2.getSelectedItem().toString();
				
				
				
				Connection c=MyConnection1.dbConnector();
				try
				{
					PreparedStatement ps=c.prepareStatement(st);
					ps.setString(1, sid);
					ps.setString(2, sname);
					ps.setString(4, sbatch);
					ps.setString(5, sname);
					
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Info Added");
					//dispose();
					
					
				}
				catch(Exception se)
				{
					System.out.println(se);
				}
			}
		});
		
		save = new JButton("Save");
		save.setBackground(Color.GRAY);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String sid=id.getText();
				String sname=name.getText();
				//String scourse=course.getText();
				String sbatch=comboBox_2.getSelectedItem().toString();
				Connection c=MyConnection1.dbConnector();
				
				if(sbatch.equalsIgnoreCase("android"))
				{
                   String st1="insert into android(stid,stname) values (?,?)";
					
					try {
						PreparedStatement ps1 = c.prepareStatement(st1);
									
						ps1.setString(1, sid);
				        ps1.setString(2, sname);
				        
					     ps1.executeUpdate();
					     JOptionPane.showMessageDialog(null, "Info Added");
							
					}
					catch(Exception se)
					{
						System.out.println(se);
					}
				}
				else if(sbatch.equalsIgnoreCase("java"))
				{
                   String st1="insert into java(stid,stname) values (?,?)";
					
					try {
						PreparedStatement ps1 = c.prepareStatement(st1);
									
						ps1.setString(1, sid);
				        ps1.setString(2, sname);
				        
					     ps1.executeUpdate();
					     JOptionPane.showMessageDialog(null, "Info Added");
							
					}
					catch(Exception se)
					{
						System.out.println(se);
					}
				}/**/
				else if(sbatch.equalsIgnoreCase("python"))
				{
                   String st1="insert into python(stid,stname) values (?,?)";
					
					try {
						PreparedStatement ps1 = c.prepareStatement(st1);
									
						ps1.setString(1, sid);
				        ps1.setString(2, sname);
				        
					     ps1.executeUpdate();
					     JOptionPane.showMessageDialog(null, "Info Added");
							
					}
					catch(Exception se)
					{
						System.out.println(se);
					}
				}
				
				
				
				
				
				
				
				String st="insert into s_info(stid,stname,stbatch,password) values (?,?,?,?)";
				
				try
				{
					PreparedStatement ps=c.prepareStatement(st);
					ps.setString(1, sid);
					ps.setString(2, sname);
					//ps.setString(3, scourse);
					ps.setString(3, sbatch);
					ps.setString(4, sname);
					
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Info Added");
					id.setText(null);
					name.setText(null);
					comboBox_2.removeAllItems();;
					//dispose();
					
					
				}
				catch(Exception se)
				{
					System.out.println(se);
				}
			}
		});
		save.setBounds(42, 215, 89, 23);
		add(save);
		clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				id.setText(null);
				name.setText(null);
				comboBox_2.removeAllItems();
			}
		});
		clear.setBackground(Color.GRAY);
		clear.setBounds(171, 215, 89, 23);
		add(clear);
		
		cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		cancel.setBackground(Color.GRAY);
		cancel.setBounds(293, 215, 89, 23);
		add(cancel);
		
		lblStudentInfo = new JLabel("Student Info");
		lblStudentInfo.setForeground(new Color(165, 42, 42));
		lblStudentInfo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblStudentInfo.setBounds(400, 20, 500, 100);
		add(lblStudentInfo);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setForeground(Color.BLACK);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "Android", "Python", "Java"}));
		comboBox_2.setBounds(183, 161, 239, 20);
		add(comboBox_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(student1.class.getResource("/pack1/img/st.jpg")));
		lblNewLabel.setBounds(0, 0,1400, 900);
		add(lblNewLabel);
		
		
		
		
		
		
	}
	void generateId()
	{
		String s="select stid from s_info";
		int largest=1;
		Connection con=MyConnection1.dbConnector();
		try
		{
			PreparedStatement ps=con.prepareStatement(s);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String temp = rs.getString("stid");
				String temp2 = temp.substring(1);
				int re = Integer.parseInt(temp2);
				//System.out.println(temp2);
				if(re>largest)
				{
					largest=re;
				}
			}
			++largest;
		    id1 = "s"+largest;
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		id.setText(id1);
	}
	
}
