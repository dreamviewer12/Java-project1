package pack;

import javax.swing.JButton;
import javax.swing.JPanel;



public class Buttons  extends JPanel 

{
     JButton b;
	public Buttons()
	{
		b=new JButton("Click");
		setLayout(null);
		b.setBounds(15,10,80,30);
		add(b);
	}

	public static void main(String[] args) {
		

	}

}
