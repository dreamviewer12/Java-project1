package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeUpdate extends JDialog implements ActionListener{
	private JTextField tid;
	private JTextField tname;
	private JTextField tsalary;
	private JTextField ttax;
	private JLabel ttid;
	private JButton submit;
	private JButton cancel;
	private JComboBox tcity;
	private JRadioButton f;
	private final ButtonGroup buttonGroup = new ButtonGroup();
    int id;
    private JRadioButton m;
	public EmployeeUpdate(int id) {
		this.id=id;//important
		setIconImage(Toolkit.getDefaultToolkit().getImage(EmployeeUpdate.class.getResource("/pack/img/nat4.png")));
		setTitle("EmployeeInfo");
		getContentPane().setLayout(null);
		
		ttid = new JLabel("Id");
		ttid.setBounds(77, 30, 37, 14);
		getContentPane().add(ttid);
		
		JLabel ttname = new JLabel("Name");
		ttname.setBounds(77, 63, 46, 14);
		getContentPane().add(ttname);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(77, 88, 46, 14);
		getContentPane().add(lblGender);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(77, 118, 46, 14);
		getContentPane().add(lblCity);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(77, 147, 46, 14);
		getContentPane().add(lblSalary);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setBounds(77, 172, 46, 14);
		getContentPane().add(lblTax);
		
		tid = new JTextField(String.valueOf(id));//imp
		tid.setBackground(Color.WHITE);//imp
		tid.setEditable(false);//imp
		tid.setBounds(155, 27, 215, 20);
		getContentPane().add(tid);
		tid.setColumns(10);
		
		tname = new JTextField();
		tname.setBackground(Color.WHITE);
		tname.setEditable(false);
		tname.setBounds(155, 60, 215, 20);
		getContentPane().add(tname);
		tname.setColumns(10);
		
		tsalary = new JTextField();
		tsalary.setBounds(155, 144, 215, 20);
		getContentPane().add(tsalary);
		tsalary.setColumns(10);
		
		m = new JRadioButton("Male");
		m.setForeground(Color.BLACK);//imp
		m.setEnabled(false);//imp
		m.setOpaque(false);//imp
		buttonGroup.add(m);
		m.setBounds(155, 84, 73, 23);
		getContentPane().add(m);
		
		f = new JRadioButton("Female");
		f.setForeground(Color.BLACK);
		f.setBackground(new Color(240,240,240));
		f.setEnabled(false);
		buttonGroup.add(f);
		f.setBounds(259, 84, 82, 23);
		getContentPane().add(f);
		
		ttax = new JTextField();
		ttax.setBounds(155, 169, 215, 20);
		getContentPane().add(ttax);
		ttax.setColumns(10);
		
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		submit.setBounds(89, 210, 89, 23);
		getContentPane().add(submit);
		
		cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancel.setBounds(238, 210, 89, 23);
		getContentPane().add(cancel);
		
		tcity = new JComboBox();
		tcity.setModel(new DefaultComboBoxModel(new String[] {"Lucknow", "Delhi", "Kashmir"}));
		tcity.setBounds(155, 115, 219, 20);
		getContentPane().add(tcity);
		
		
		getRootPane().setDefaultButton(submit);
	    setLocationRelativeTo(null);
	    setSize(400, 600);
	    setModal(true);
	    submit.addActionListener(this);
	    cancel.addActionListener(this);
	    ImageIcon ii =new ImageIcon(getClass().getResource("img/nat4.png"));
	    JLabel r=new JLabel(ii);
	    r.setBounds(0,0,400,600);
	    getContentPane().add(r);
	    fillInfo();//important
	    
	    setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob=e.getSource();
		if(ob==cancel)
		{
			dispose();
		}
		else if(ob==submit)
		{
			String s="update employee set ecity=?,esalary=?,etax=? where eid=? ";
			String city=tcity.getSelectedItem().toString();
			int salary=Integer.parseInt(tsalary.getText());
			int tax=Integer.parseInt(ttax.getText());
			Connection con=MyConnection.connect();
			try
			{
				PreparedStatement ps=con.prepareStatement(s);
				ps.setString(1, city);
				ps.setInt(2, salary);
				ps.setInt(3, tax);
				ps.setInt(4, id);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Updated");
				
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
				
		}
		
		
		
	}
	void fillInfo()
	{
		String s="select * from employee where eid=?";
		Connection con = MyConnection.connect();
		try
		{
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				tname.setText(rs.getString("ename"));
				if(rs.getString("egender").equalsIgnoreCase("Male"))
					m.setSelected(true);
				else
					f.setSelected(true);
				tcity.setSelectedItem(rs.getString("ecity"));
				tsalary.setText(String.valueOf(rs.getInt("esalary")));
				ttax.setText(String.valueOf(rs.getInt("etax")));
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
}
