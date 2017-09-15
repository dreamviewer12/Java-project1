package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class HomePage implements ActionListener
{
    JFrame frame;
    JMenuItem add,update,del,id,all,m1,m2,m3,m4,cp;
	public HomePage() 
	{
	  frame=new JFrame("HomePage");
	  frame.setSize(frame.getMaximumSize());//important
	  
	  JMenuBar menuBar = new JMenuBar();
	  frame.setJMenuBar(menuBar);
	  
	  JMenu mnEmployee = new JMenu("Employee");
	  menuBar.add(mnEmployee);
	  
	  add = new JMenuItem("New");
	  mnEmployee.add(add);
	  
	  update = new JMenuItem("Update");
	  update.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));//important
	  mnEmployee.add(update);
	  
	  del = new JMenuItem("Delete");
	  mnEmployee.add(del);
	  
	  JMenu mnView = new JMenu("View");
	  mnEmployee.add(mnView);
	  
	  id = new JMenuItem("By Id");
	  mnView.add(id);
	  
	  all = new JMenuItem("View All");
	  mnView.add(all);
	  
	  JMenu mnSubMenus = new JMenu("Sub Menus");
	  menuBar.add(mnSubMenus);
	  
	  m1 = new JMenuItem("Menu 1");
	  mnSubMenus.add(m1);
	  
	  m2 = new JMenuItem("Menu 2");
	  mnSubMenus.add(m2);
	  
	  m3 = new JMenuItem("Menu 3");
	  mnSubMenus.add(m3);
	  
	  m4 = new JMenuItem("Menu 4");
	  mnSubMenus.add(m4);
	  
	  JMenu mnExit = new JMenu("Exit");
	  menuBar.add(mnExit);
	  
	  cp = new JMenuItem("Close Program");
	  mnExit.add(cp);
	  
	  add.addActionListener(this);
	  update.addActionListener(this);
	  del.addActionListener(this);
	  id.addActionListener(this);
	   all.addActionListener(this);
	   
	   
	  m1.addActionListener(this);
      m2.addActionListener(this);
      m3.addActionListener(this);
      m4.addActionListener(this);
      
      cp.addActionListener(this);




	  frame.setVisible(true);
	}

	public static void main(String[] args) {
		new HomePage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob =e.getSource();
		if(ob==add)
		{
			new EmployeeAdd();
		}
		else if(ob== update )
		{
			String re=JOptionPane.showInputDialog(null,"Enter ID");
			int wq=Integer.parseInt(re);//important
			new EmployeeUpdate(wq);
			
		}
		else if(ob==del)
		{
			
		}
		else if(ob==id)
		{
			String re=JOptionPane.showInputDialog(null,"Enter ID");//important
			int wq=Integer.parseInt(re);
			new ViewId(wq);

		}
		else if(ob==all)
		{
			
		}
		else if(ob==m1)
		{
			selectFile();
		}
		else if(ob==m2)
		{
			new Panes();
		}
		else if(ob==m3)
		{
			new Controls();
		}
		else if(ob==m4)
		{
			
		}
		else if(ob==cp)
		{
			int w=JOptionPane.showConfirmDialog(null, "Sure To Exit","Swings",JOptionPane.YES_NO_OPTION);//important
			if(w==0)
			{
				System.exit(0);
			}
		}
		
			
		
	}
	void selectFile()
	{
		JFileChooser jfc=new JFileChooser("C:/");
		int re=jfc.showOpenDialog(null);
		switch(re)
		{
		case JFileChooser.APPROVE_OPTION:
			String f=jfc.getSelectedFile().toString();
			JOptionPane.showMessageDialog(null, "Select File:"+f);
		}
	}

}
