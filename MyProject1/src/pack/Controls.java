package pack;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class Controls extends JDialog implements ItemListener{
	private JTextField radio;
	private JTextField gender;
	private JTextField check;
	private JTextField combo;
	
	JComboBox city;
	JCheckBox wa,ea,sl;
	JRadioButton m,f,hs,ss,gr;

	public Controls()
	{
		getContentPane().setLayout(null);
		
		m = new JRadioButton("Male");
		m.setBounds(22, 30, 135, 23);
		getContentPane().add(m);
		
		f = new JRadioButton("Female");
		f.setBounds(22, 71, 135, 23);
		getContentPane().add(f);
		
		hs = new JRadioButton("Secondary");
		hs.setBounds(22, 142, 135, 23);
		getContentPane().add(hs);
		
		ss = new JRadioButton("Senior Secondary");
		ss.setBounds(22, 177, 135, 23);
		getContentPane().add(ss);
		
		gr = new JRadioButton("Graduate");
		gr.setBounds(22, 214, 135, 23);
		getContentPane().add(gr);
		
		wa = new JCheckBox("Whatsapp");
		wa.setBounds(22, 276, 97, 23);
		getContentPane().add(wa);
		
		sl = new JCheckBox("Sleeping");
		sl.setBounds(22, 314, 97, 23);
		getContentPane().add(sl);
		
		ea = new JCheckBox("Eating");
		ea.setBounds(22, 346, 97, 23);
		getContentPane().add(ea);
		
		city = new JComboBox();
		city.setModel(new DefaultComboBoxModel(new String[] {"", "Lucknow", "Delhi"}));
		city.setBounds(29, 386, 90, 29);
		getContentPane().add(city);
		
		radio = new JTextField();
		radio.setColumns(10);
		radio.setBounds(163, 155, 188, 20);
		getContentPane().add(radio);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(163, 45, 188, 20);
		getContentPane().add(gender);
		
		check = new JTextField();
		check.setColumns(10);
		check.setBounds(163, 301, 188, 20);
		getContentPane().add(check);
		
		combo = new JTextField();
		combo.setColumns(10);
		combo.setBounds(163, 390, 188, 20);
		getContentPane().add(combo);
		setSize(400, 600);
		
		
		ButtonGroup bg1 =new ButtonGroup();
		ButtonGroup bg2 =new ButtonGroup();
		bg1.add(m);
		bg1.add(f);
		bg2.add(hs);
		bg2.add(ss);
		bg2.add(gr);
		
		hs.addItemListener(this);
		ss.addItemListener(this);
		gr.addItemListener(this);
		ea.addItemListener(this);
		city.addItemListener(this);
		sl.addItemListener(this);
		wa.addItemListener(this);
		
		setLocation(150,90);
		setModal(true);
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		

	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
		
		Object ob=e.getSource();
		if(ob==hs)
		{
			radio.setText(hs.getText());
			
		}
		else if(ob==ss)
		{
			radio.setText("10+2");
		}
		else if(ob==gr)
		{
			radio.setText("Graduate");
			
		}
		else if(ob==city)
		{
			String cc=city.getSelectedItem().toString();
			combo.setText(cc);
		}
		else if(ob==wa||ob==sl||ob==ea)
		{
			String msg="";
			if(wa.isSelected())
			{
				msg+="Whatsapp";
			}
			if(sl.isSelected())
			{
				msg+="Sleeping";
			}
			if(ea.isSelected())
			{
				msg+="Eating";
			}
			check.setText(msg);
			
		}
		
		
		
	}
}
