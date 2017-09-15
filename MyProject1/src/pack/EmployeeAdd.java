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

public class EmployeeAdd extends JDialog implements ActionListener{
	private JTextField tid;
	private JTextField tname;
	private JTextField tsalary;
	private JTextField ttax;
	private JLabel ttid;
	private JButton submit;
	private JButton cancel;
	private JComboBox tcity;
	private JRadioButton m;
	private JRadioButton f;
	private final ButtonGroup buttonGroup = new ButtonGroup();//important
    int id;
	public EmployeeAdd() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EmployeeAdd.class.getResource("/pack/img/nat4.png")));
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
		
		tid = new JTextField();
		tid.setBackground(Color.WHITE);//imp
		tid.setEditable(false);//imp
		tid.setBounds(155, 27, 215, 20);
		getContentPane().add(tid);
		tid.setColumns(10);
		
		tname = new JTextField();
		tname.setBounds(155, 60, 215, 20);
		getContentPane().add(tname);
		tname.setColumns(10);
		
		tsalary = new JTextField();
		tsalary.setBounds(155, 144, 215, 20);
		getContentPane().add(tsalary);
		tsalary.setColumns(10);
		
		m = new JRadioButton("Male");
		m.setOpaque(false);//imp
		buttonGroup.add(m);//imp
		m.setBounds(155, 84, 73, 23);
		getContentPane().add(m);
		
		f = new JRadioButton("Female");
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
	    setModal(true);//imp
	    submit.addActionListener(this);
	    cancel.addActionListener(this);
	    ImageIcon ii =new ImageIcon(getClass().getResource("img/nat4.png"));
	    JLabel r=new JLabel(ii);
	    r.setBounds(0,0,400,500);
	    getContentPane().add(r);
	    generateId();//imp..is a function made by us in the bottom.
	    setVisible(true);
	}

	public static void main(String[] args) {
		
      new EmployeeAdd();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object ob=e.getSource();
		if(ob==cancel)
		{
			dispose();
		}
		else if(ob == submit)
		{
			String st="insert into employee(eid,esalary,etax,ename,egender,ecity) values (?,?,?,?,?,?)";
			int salary=Integer.parseInt(tsalary.getText());
			int tax=Integer.parseInt(ttax.getText());
			String name=tname.getText();
			String city=tcity.getSelectedItem().toString();//important
			String gender="";
			if(m.isSelected())
			{
				gender="Male";
				
			}
			else 
				gender="Female";
			Connection c=MyConnection.connect();
			try
			{
				PreparedStatement ps=c.prepareStatement(st);
				ps.setInt(1, id);
				ps.setInt(2, salary);
				ps.setInt(3, tax);
				ps.setString(4, name);
				ps.setString(5, gender);
				ps.setString(6, city);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Info Added");//imp
				dispose();
				
				
			}
			catch(SQLException se)
			{
				System.out.println(se);
			}
		}
		
	}
	void generateId()
	{
		String s="select max(eid) from employee";
		Connection con=MyConnection.connect();
		try
		{
			PreparedStatement ps=con.prepareStatement(s);
			ResultSet rs=ps.executeQuery();
			rs.next();
			id=rs.getInt(1);
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		++id;
		tid.setText(String.valueOf(id));
	}
}
