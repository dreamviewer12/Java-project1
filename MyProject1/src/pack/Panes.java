package pack;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

public class Panes 
{
   JDialog jd;
	public Panes()
	{
		jd=new JDialog();
		jd.setTitle("Tabbed Pane");
		jd.setModal(true);
		jd.setSize(400,300);
		Cars c=new Cars();
		Buttons b=new Buttons();
		JTabbedPane jtp =new JTabbedPane();
		jtp.addTab("Car", c);
		jtp.addTab("Clicks", b);
		jd.getContentPane().add(jtp);
		jd.setLocation(100, 80);
		jd.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new Panes();

	}

}
