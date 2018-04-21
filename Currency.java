package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.sql.*;
import java.io.*;	
import javax.imageio.*;
public class Currency
{
	public Currency(String userid)
	{
			GeneralLayout l=new GeneralLayout();
		JFrame f=l.display(userid,"Currency Convertor");

		JLabel l2=new JLabel("CURRENCY CONVERTOR");
		l2.setFont(new Font("Joker",Font.BOLD,20));
		l2.setBounds(150,100,300,30);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(l2);	
	 	JButton back=new JButton("BACK");
		back.setBounds(0,10,120,30);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		back.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				new Apps(userid);
				
        			}
			});
		f.add(back);

		
		JLabel l7=new JLabel("Enter Value");
		l7.setFont(new Font("Joker",Font.BOLD,14));
		l7.setBounds(50,200,200,30);
		JTextField tf5=new JTextField();
		tf5.setBounds(200,200,150,30);
		f.add(tf5);
		f.add(l7);





		JComboBox<String> li = new JComboBox<String>();
		//DefaultListModel<String> li = new DefaultListModel<>();  
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");
		PreparedStatement st=con.prepareStatement("select distinct(c_from) from currency");
		ResultSet rs=st.executeQuery();
		
		while(rs.next())
		{
		    li.addItem(rs.getString("c_from"));
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

		
		li.setBounds(370,200,100,20);
		f.add(li);		

		JLabel l8=new JLabel("Convert to");
		l8.setFont(new Font("Joker",Font.BOLD,14));
		l8.setBounds(50,250,200,30);
		f.add(l8);
		JComboBox<String> li2 = new JComboBox<String>();
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");
		PreparedStatement st=con.prepareStatement("select distinct(c_to) from currency");
		ResultSet rs3=st.executeQuery();
		
		while(rs3.next())
		{
		    li2.addItem(rs3.getString("c_to"));
		}
		}
		catch(Exception e3)
		{
			System.out.println(e3);
		}
		

		
		li2.setBounds(170,250,100,20);
		f.add(li2);	
		JTextField tf=new JTextField("0.0");
		tf.setBounds(300,350,200,30);
		//tf.setFont(new Font("Joker",Font.BOLD,16));
		f.add(tf);
		JLabel l4=new JLabel("Converted Currency");
		l4.setFont(new Font("Joker",Font.BOLD,18));
		l4.setBounds(50,350,200,30);
		f.add(l4);
		JButton b1=new JButton("Convert");
		b1.setBounds(200,300,170,30);
		b1.setFont(new Font("Joker",Font.BOLD,16));
		b1.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{
			    try{
			    String from=(String)li.getSelectedItem();
			    String to=(String)li2.getSelectedItem();
			    double val=Double.parseDouble(tf5.getText());
			    Class.forName("com.mysql.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");
			    PreparedStatement ps1;
			    ps1=con.prepareStatement("select factor from currency where c_from=? and c_to=?");
			    ps1.setString(1,from);
			    ps1.setString(2,to);
			    ResultSet rs1=ps1.executeQuery();
			    double ans=val;
			    while(rs1.next())
			    {
			        
			        double fact=Double.parseDouble(rs1.getString("factor"));
			        
			        ans=(double)fact*val;
				System.out.println(ans);
			    }
			        
			        tf.setText(String.valueOf(ans));

			    
			}
			catch(Exception e1)
			{
			System.out.println(e1);
			}
			}
			});
			f.add(b1); 

		

		
		f.setSize(600,500);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(0);
	}
}
