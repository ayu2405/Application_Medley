package mpa;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;	
import java.sql.*;
import javax.swing.JTable;
import java.io.*;	
import javax.imageio.*;
public class ScoreCard
{
	public ScoreCard(String userid)
	{
     		JFrame f1=new JFrame("ScoreCard");

		try{
		f1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mpa/p8.jpg")))));
		}
		catch(Exception e5){
			System.out.println(e5); }

		JButton logout=new JButton("LOGOUT");
		f1.setResizable(false);
		logout.setBounds(500,10,120,30);
		logout.setOpaque(false);
		logout.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		
		 logout.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f1.dispose();
				new First();
        			}
			});
		f1.add(logout);

		JButton print=new JButton("PRINT");
		print.setBounds(100,100,120,30);
		print.setOpaque(false);
		print.setForeground(Color.RED);
		print.setContentAreaFilled(false);
		print.setBorderPainted(false);
		
		 print.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				new PrintCard(f1);
				
        			}
			});
		f1.add(print);

		JButton back=new JButton("BACK");
		back.setBounds(0,10,120,30);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		 back.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f1.dispose();
				new Quiz(userid);
				
        			}
			});
		f1.add(back);
		String j1="";
		String j2="";
		String j3="";
		String gk1="";
		String gk2="";
		String gk3="";
		String a1="";
		String a2="";
		String a3="";

		


		try
		{

		    Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");
		
		PreparedStatement st1=con.prepareStatement("select * from quiz where userid=?");

		st1.setString(1,userid);
		ResultSet rs=st1.executeQuery();
           		 while (rs.next()) 
		{
			j1=rs.getString(2);
			j2=rs.getString(3);
			j3=rs.getString(4);
			gk1=rs.getString(5);
			gk2=rs.getString(6);
			gk3=rs.getString(7);
			a1=rs.getString(8);
			a2=rs.getString(9);
			a3=rs.getString(10);
		System.out.println(j1);

		}
		if(j1==null)
			j1="0.0";

		if(j2==null){
			j2="0.0";
			System.out.println(j2);
			}

		if(j3==null)
			j3="0.0";

		if(gk1==null)
			gk1="0.0";


		if(gk2==null)
			gk2="0.0";

		if(gk3==null)
			gk3="0.0";

		if(a1==null)
			a1="0.0";

		if(a2==null)
			a2="0.0";

		if(a3==null)
			a3="0.0";

		

		}
		catch(Exception e2)
		{
		   System.out.println(e2);
		}

		System.out.println(j1);

		JLabel l1=new JLabel("SCORECARD");
		l1.setBounds(150,50,300,30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Joker",Font.BOLD,24));
		f1.add(l1);	

		maxDisplay(f1,300,100,300,30);	
		

		
		JLabel l3=new JLabel("Java");
		l3.setFont(new Font("Joker",Font.BOLD,14));
		l3.setBounds(50,150,200,30);

		
		JLabel l4=new JLabel("Paper1");
		l4.setFont(new Font("Joker",Font.BOLD,14));
		l4.setBounds(120,150,200,30);
		JTextField tf2=new JTextField(j1);
		tf2.setBounds(220,150,200,30);
		tf2.setEditable(false);
	
		f1.add(tf2);
		f1.add(l4);
		f1.add(l3);

		JLabel l5=new JLabel("Paper2");
		l5.setFont(new Font("Joker",Font.BOLD,14));
		l5.setBounds(120,200,200,30);
		JTextField tf3=new JTextField(j2);
		tf3.setBounds(220,200,200,30);
		tf3.setEditable(false);
		f1.add(tf3);
		f1.add(l5);

		JLabel l6=new JLabel("Paper3");
		l6.setFont(new Font("Joker",Font.BOLD,14));
		l6.setBounds(120,250,200,30);
		JTextField tf4=new JTextField(j3);
		tf4.setBounds(220,250,200,30);
		tf4.setEditable(false);
		f1.add(tf4);
		f1.add(l6);

		JLabel l7=new JLabel("G.K.");
		l7.setFont(new Font("Joker",Font.BOLD,14));
		l7.setBounds(50,350,200,30);

		
		JLabel l8=new JLabel("Paper1");
		l8.setFont(new Font("Joker",Font.BOLD,14));
		l8.setBounds(120,350,200,30);
		JTextField tf8=new JTextField(gk1);
		tf8.setBounds(220,350,200,30);
		tf8.setEditable(false);
		f1.add(tf8);
		f1.add(l8);
		f1.add(l7);

		JLabel l9=new JLabel("Paper2");
		l9.setFont(new Font("Joker",Font.BOLD,14));
		l9.setBounds(120,400,200,30);
		JTextField tf9=new JTextField(gk2);
		tf9.setBounds(220,400,200,30);
		tf9.setEditable(false);
		f1.add(tf9);
		f1.add(l9);

		JLabel l10=new JLabel("Paper3");
		l10.setFont(new Font("Joker",Font.BOLD,14));
		l10.setBounds(120,450,200,30);
		JTextField tf10=new JTextField(gk3);
		tf10.setBounds(220,450,200,30);
		tf10.setEditable(false);
		f1.add(tf10);
		f1.add(l10);

		JLabel l11=new JLabel("Aptitude");
		l11.setFont(new Font("Joker",Font.BOLD,14));
		l11.setBounds(50,550,200,30);

		
		JLabel l12=new JLabel("Paper1");
		l12.setFont(new Font("Joker",Font.BOLD,14));
		l12.setBounds(120,550,200,30);
		JTextField tf12=new JTextField(a1);
		tf12.setBounds(220,550,200,30);
		tf12.setEditable(false);
		f1.add(tf12);
		f1.add(l12);
		f1.add(l11);

		JLabel l13=new JLabel("Paper2");
		l13.setFont(new Font("Joker",Font.BOLD,14));
		l13.setBounds(120,600,200,30);
		JTextField tf13=new JTextField(a2);
		tf13.setBounds(220,600,200,30);
		tf13.setEditable(false);
		f1.add(tf13);
		f1.add(l13);

		JLabel l14=new JLabel("Paper3");
		l14.setFont(new Font("Joker",Font.BOLD,14));
		l14.setBounds(120,650,200,30);
		JTextField tf14=new JTextField(a3);
		tf14.setEditable(false);
		tf14.setBounds(220,650,200,30);
		f1.add(tf14);
		f1.add(l14);



		f1.setLayout(null);

		f1.setSize(600,720);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(0);
	}

	void maxDisplay(JFrame f,int x,int y,int w,int h)
	{
		JLabel l1=new JLabel("Maximum marks in each paper : 10");
		l1.setBounds(x,y,w,h);
		l1.setFont(new Font("Joker",Font.BOLD,14));
		f.add(l1);
	}
}
