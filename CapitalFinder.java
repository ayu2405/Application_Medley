package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.sql.*;
import java.io.*;	
import javax.imageio.*;
public class CapitalFinder
{
	public CapitalFinder(String userid)
	{
		//GeneralLayout l1=new GeneralLayout();
	//	JFrame f=l1.display(userid,"Capital Finder");
		JFrame f=new JFrame("Capital Finder");
		f.setResizable(false);
		//f1.getContentPane().setBackground(Color.YELLOW);

		try{
		f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mpa/p8.jpg")))));
		}
		catch(Exception e5){
			System.out.println(e5); }


	

		JButton logout=new JButton("LOGOUT");
		logout.setBounds(450,10,120,30);
		logout.setOpaque(false);
		logout.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		
		 logout.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				new First();
        			}
			});
		f.add(logout);



		JLabel l1=new JLabel("APPLICATION MEDLEY");
		l1.setBounds(150,50,300,30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Joker",Font.BOLD,24));
		f.add(l1);
		
		
		JLabel l2=new JLabel("CAPITAL FINDER");
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
		

		JLabel l3=new JLabel("Select State");
		l3.setFont(new Font("Joker",Font.BOLD,18));
		l3.setBounds(100,200,200,30);
		f.add(l3);
		JComboBox<String> li = new JComboBox<String>();
		//DefaultListModel<String> li = new DefaultListModel<>();  
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");
		PreparedStatement st=con.prepareStatement("select state from cap_finder");
		ResultSet rs=st.executeQuery();
		li.addItem("Select State");
		while(rs.next())
		{
		    li.addItem(rs.getString("state"));
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

		JLabel l=new JLabel("");
		li.setBounds(300,205,250,20);
		f.add(li);		
		JLabel l4=new JLabel("Capital:");
		l4.setFont(new Font("Joker",Font.BOLD,18));
		l4.setBounds(100,300,200,30);
		f.add(l4);
		JButton b1=new JButton("Find Capital");
		b1.setBounds(200,250,170,30);
		b1.setFont(new Font("Joker",Font.BOLD,16));
		b1.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{
			    try{
			    String state=(String)li.getSelectedItem();
			    Class.forName("com.mysql.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");
			    PreparedStatement ps1;
			    ps1=con.prepareStatement("select capital from cap_finder where state=?");
			    ps1.setString(1,state);
			    ResultSet rs1=ps1.executeQuery();
			    while(rs1.next())
			    {
			        //l=new JLabel(rs1.getString("capital"));
			        l.setText(rs1.getString("capital"));
			        l.setBounds(300,300,250,30);
			        l.setFont(new Font("Joker",Font.BOLD,16));
			        
			    }
			}
			catch(Exception e1)
			{
			System.out.println(e1);
			}
			}
			});
			f.add(b1); 

		

		f.add(l);
		f.setSize(600,500);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(0);
	}
}
