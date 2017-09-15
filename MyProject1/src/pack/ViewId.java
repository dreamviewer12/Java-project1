package pack;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewId {

	
		int id;
		JDialog dialog;
		JTable table;
		JScrollPane jsp;
		int cnt ,r,c;
		String []columns;
		String[][] data;
		
		
		public ViewId(int id)
		{
			this.id=id;
			String s="select * from employee where eid=?";
			Connection con=MyConnection.connect();
			try
			
			{
				PreparedStatement ps=con.prepareStatement(s);
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				columns=new String[]{"ID","Name","Gender","City","Salary","Tax"};
						rs.last();
				cnt=rs.getRow();
				rs.beforeFirst();
				data=new String[cnt][6];//object of string array
				while(rs.next())
				{
					data[r][c]=String.valueOf(rs.getInt("eid"));
					++c;
					data[r][c]=rs.getString("ename");
					++c;
					data[r][c]=rs.getString("egender");
					++c;
					data[r][c]=rs.getString("ecity");
					++c;
					data[r][c]=String.valueOf(rs.getInt("esalary"));
					++c;
					data[r][c]=String.valueOf(rs.getInt("etax"));
					c=0;
					++r;
				}
				table=new JTable(data,columns);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				jsp=new JScrollPane(table,
						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				dialog=new JDialog();
				dialog.setTitle("Tabular Display");
				dialog.setModal(true);
				dialog.setLayout(null);
				dialog.setSize(600,350);
				JButton back=new JButton("Back");
				back.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						dialog.dispose();
					}
				});
				back.setBounds(10,10,90,30);
				jsp.setBounds(10,50,400,200);
				dialog.add(back);
				dialog.getContentPane().add(jsp);
				dialog.setVisible(true);
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}

}
