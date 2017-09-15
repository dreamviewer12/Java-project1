package pack1;



import java.awt.Dimension;


import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.tools.Tool;

import java.awt.Color;

public class t_page extends JDialog implements ActionListener,ItemListener {

	private JTextField date;
	private JComboBox time;
	private JComboBox sub;
	private JLabel lblSubject;
	private JLabel lblDate;
	private JLabel lblTime;
	private JRadioButton[] present, absent;
	String subject;
	int cnt=20;
	JCheckBox students[];
	private JButton take;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
					new t_page();
	}

	/**
	 * Create the frame.
	 */
	//JFrame frame;
	
	
	public t_page() 
	{
	    
		students = new JCheckBox[20];
		for(int i=0;i<cnt;i++)
			students[i] = new JCheckBox("");
		setTitle("Teacher");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		//contentPane = new JPanel();
		//setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		

		
		submit = new JButton("OK");
		submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submit.setBounds(519, 448, 136, 42);
		submit.addActionListener(this);
		
		take = new JButton("Take Attendance");
		take.addActionListener(this);
		take.setBounds(58, 105, 165, 35);
		getContentPane().add(take);
		getContentPane().add(submit);
		
		lblSubject = new JLabel("Batches");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSubject.setBounds(19, 47, 96, 28);
		getContentPane().add(lblSubject);
		
		sub = new JComboBox();
		sub.setModel(new DefaultComboBoxModel(new String[] {"", "Android", "Java", "Python"}));
		sub.setBounds(113, 44, 110, 31);
		getContentPane().add(sub);
		
		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBounds(433, 50, 67, 28);
		getContentPane().add(lblDate);
		LocalDate ld = LocalDate.now();
		date = new JTextField(String.valueOf(ld));
		date.setOpaque(false);
		date.setFont(new Font("Tahoma", Font.BOLD, 18));
		date.setBackground(Color.WHITE);
		date.setEditable(false);
		date.setBounds(561, 50, 120, 31);
		getContentPane().add(date);
		date.setColumns(10);
		
		lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTime.setBounds(433, 111, 67, 29);
		getContentPane().add(lblTime);
		
		time = new JComboBox();
		time.setModel(new DefaultComboBoxModel(new String[] {"", "7:00-9:00", "9:00-11:00", "11:00-1:00", "4:00-6:00", "6:00-8:00"}));
		time.setBounds(561, 111, 120, 31);
		getContentPane().add(time);
		

		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension d=tk.getScreenSize();
		int h=(int)d.getHeight();
		int w=(int)d.getWidth();
		this.setSize(w,h);
		setLocation(0,0);
		ImageIcon gff = new ImageIcon(getClass().getResource("img/tpage.jpg"));
		JLabel lblNewLabel = new JLabel(gff);
		lblNewLabel.setBounds(0, 0, w, h);
		getContentPane().add(lblNewLabel);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object ob = e.getSource();
		if(ob == take)
		{
			String subject = sub.getSelectedItem().toString();
			if(subject.length()>3)
			displayStudents(subject);
			setVisible(true);
		}
		else if(ob==submit)
		{
			subject = sub.getSelectedItem().toString();
			String status="A";
			for(int i=0;i<cnt;i++)
			{
				String name = students[i].getText();
				if(students[i].isSelected())
					status="P";
				else
					status="A";
		        String st="update "+subject+" set status='"+status+"' where stname='"+name +"'";
		        Connection con = MyConnection1.dbConnector();
				try
				{
					PreparedStatement ps = con.prepareStatement(st);
					ps.addBatch();
					int rs = ps.executeUpdate();
				}
				catch(SQLException w)
				{
				   w.printStackTrace();
					//System.out.println(w);
				}
				
			}
			JOptionPane.showMessageDialog(null, "Attendance Updated");
			dispose();
		}
	}
	void displayStudents(String subject)
	{
		for(int i=0;i<cnt;i++)
			remove(students[i]);
		String s = "select * from " + subject;
		Connection con = MyConnection1.dbConnector();
		try
		{
			PreparedStatement ps = con.prepareStatement(s);
			ResultSet rs = ps.executeQuery();
			rs.last();
			cnt = rs.getRow();
			
			students = new JCheckBox[cnt];
			rs.beforeFirst();
			int left=60,top=155;
			int i = 0;
			while(rs.next())
			{
				students[i] = new JCheckBox(rs.getString("stname"));
				students[i].setBounds(left, top, 100,30);
				getContentPane().add(students[i]);
				top+=40;
				++i;
				if(top>320)
				{
					left = 200;
					top = 120;
				}
			}
			i=0;
			rs.beforeFirst();
			while(rs.next())
			{
				students[i].addItemListener( this);
				i++;
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	int j=0;
	private JButton submit;

	public void itemStateChanged(ItemEvent e)
	{
		Object ae=e.getSource();

	}
}
