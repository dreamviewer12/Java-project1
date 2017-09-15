package pack1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class admin1 
{
   JDialog jd;
   JButton logout;
   private int w;
   private int h;
	public admin1()
	{
		jd=new JDialog();
		jd.setTitle("Admin Panel");
		jd.setModal(true);
		
		jd.setBounds(0, 0, 450, 300);
		student1 c=new student1();
		//jd.setSize(jd.getMaximumSize());
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension d=tk.getScreenSize();
		int h=(int)d.getHeight();
		int w=(int)d.getWidth();
		jd.setSize(w,h-40);
		
		
		teacher1 b=new teacher1();
	
		JTabbedPane jtp =new JTabbedPane();
		jtp.addTab("Add Student", c);
		
		
		jtp.addTab("Add Teacher", b);
		
		

		jd.getContentPane().add(jtp);
		jd.setLocation(0, 0);
		logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You are successfully Logged out");
				jd.dispose();
				Login ad=new Login();
				
			}
		});

		logout.setBackground(Color.GRAY);
		logout.setBounds(5, 5, 80, 30);
		jd.getContentPane().add(logout, BorderLayout.SOUTH);
		
		jd.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new admin1();

	}


}

