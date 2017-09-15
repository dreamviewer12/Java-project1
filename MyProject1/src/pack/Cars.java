package pack;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Cars extends JPanel
{
   JComboBox car;
	public Cars() 
	{
		car = new JComboBox();
		car.addItem("Alto");
		car.addItem("Audi");
		car.addItem("Nano");
		car.addItem("Swift");
		car.addItem("Wagen R");
		setLayout(null);
		car.setBounds(10,20,100,40);
		add(car);
		
	}

	public static void main(String[] args) {
		

	}

}
