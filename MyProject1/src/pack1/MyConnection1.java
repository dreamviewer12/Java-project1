package pack1;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;


public class MyConnection1 
{
	Connection conn=null;
	public static Connection dbConnector()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Nupur","root","Student@125");
			//JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
			
		}
	}

}
