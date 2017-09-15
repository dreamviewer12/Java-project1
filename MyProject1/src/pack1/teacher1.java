package pack1;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class teacher1 extends JPanel {
	private JTextField ttid;
	private JTextField ttname;
	String id1;


	public teacher1() {
		setBackground(Color.MAGENTA);
		setLayout(null);
		
		JLabel t = new JLabel("Teacher Info");
		t.setForeground(new Color(148, 0, 211));
		t.setBackground(Color.BLACK);
		t.setFont(new Font("Tahoma", Font.BOLD, 27));
		t.setBounds(129, 50, 800, 50);
		add(t);
		
		JLabel tid = new JLabel("Teacher Id");
		tid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tid.setBounds(57, 104, 98, 14);
		add(tid);
		
		JLabel tname = new JLabel("Teacher Name");
		tname.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tname.setBounds(57, 178, 121, 14);
		add(tname);
		
		ttid = new JTextField();
		ttid.setBackground(Color.WHITE);
		ttid.setEditable(false);
		ttid.setBounds(218, 111, 212, 20);
		generateId();
		add(ttid);
		ttid.setColumns(10);
		
		ttname = new JTextField();
		ttname.setBounds(218, 177, 212, 20);
		add(ttname);
		ttname.setColumns(10);
		
		JButton ok = new JButton("Save");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				String st="insert into t_info(tid,tname,password) values (?,?,?)";
				String id=ttid.getText();
				String name=ttname.getText();
				
				
				
				
				Connection c=MyConnection1.dbConnector();
				try
				{
					PreparedStatement ps=c.prepareStatement(st);
					ps.setString(1, id);
					ps.setString(2, name);
					ps.setString(3, name);
				
					
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Info Added");
					ttid.setText(null);
					ttname.setText(null);
					//dispose();
					
					
				}
				catch(Exception se)
				{
					System.out.println(se);
				}
			}
			
		});
		ok.setBackground(Color.GRAY);
		ok.setBounds(146, 247, 89, 23);
		add(ok);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(teacher1.class.getResource("/pack1/img/tt1.jpg")));
		lblNewLabel.setBounds(0, 0, 1400, 900);
		add(lblNewLabel);
		

	}
	void generateId()
	{
		String s="select tid from t_info";
		int largest=1;
		Connection con=MyConnection1.dbConnector();
		try
		{
			PreparedStatement ps=con.prepareStatement(s);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String temp = rs.getString("tid");
				String temp2 = temp.substring(1);
				int re = Integer.parseInt(temp2);
				//System.out.println(temp2);
				if(re>largest)
				{
					largest=re;
				}
			}
			++largest;
		    id1 = "t"+largest;
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		ttid.setText(id1);
	}

}
