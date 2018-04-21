package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.sql.*;
import java.util.Random;
import java.io.*;	
import javax.imageio.*;
public class Register
{
	Register()
	{
		JFrame f=new JFrame("MPA");	
		f.setResizable(false);
		//f1.getContentPane().setBackground(Color.YELLOW);

		try{
		f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mpa/p8.jpg")))));
		}
		catch(Exception e5){
			System.out.println(e5); }
		JButton exit=new JButton("EXIT");
		exit.setBounds(470,2,60,30);
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);

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
				new First();
        			}
			});
		f.add(back);

				
		 exit.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
        			}
			});
		f.add(exit);

		JLabel l1=new JLabel("APPLICATION MEDLEY");
		l1.setBounds(150,50,300,30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Joker",Font.BOLD,24));
		f.add(l1);	
		
		JLabel l2=new JLabel("REGISTRATION PORTAL");
		l2.setFont(new Font("Joker",Font.BOLD,20));
		l2.setBounds(150,100,300,30);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(l2);	
		

		JLabel l3=new JLabel("First Name");
		l3.setFont(new Font("Joker",Font.BOLD,14));
		l3.setBounds(50,150,200,30);
		JTextField tf1=new JTextField();
		tf1.setBounds(200,150,200,30);
		f.add(tf1);
		f.add(l3);
		
		JLabel l4=new JLabel("Last Name");
		l4.setFont(new Font("Joker",Font.BOLD,14));
		l4.setBounds(50,200,200,30);
		JTextField tf2=new JTextField();
		tf2.setBounds(200,200,200,30);
		f.add(tf2);
		f.add(l4);

		JLabel l5=new JLabel("Email Id");
		l5.setFont(new Font("Joker",Font.BOLD,14));
		l5.setBounds(50,250,200,30);
		JTextField tf3=new JTextField();
		tf3.setBounds(200,250,200,30);
		f.add(tf3);
		f.add(l5);

		JLabel l6=new JLabel("Contact Number");
		l6.setFont(new Font("Joker",Font.BOLD,14));
		l6.setBounds(50,300,200,30);
		JTextField tf4=new JTextField();
		tf4.setBounds(200,300,200,30);
		f.add(tf4);
		f.add(l6);

		JLabel l7=new JLabel("User Name");
		l7.setFont(new Font("Joker",Font.BOLD,14));
		l7.setBounds(50,350,200,30);
		JTextField tf5=new JTextField();
		tf5.setBounds(200,350,200,30);
		f.add(tf5);
		f.add(l7);


		JLabel l8=new JLabel("Password");
		l8.setFont(new Font("Joker",Font.BOLD,14));
		l8.setBounds(50,400,200,30);
		JPasswordField tf6=new JPasswordField();
		tf6.setBounds(200,400,200,30);
		f.add(tf6);
		f.add(l8);


			

		JButton b1=new JButton("REGISTER");
		b1.setBounds(170,450,150,50);
		b1.setFont(new Font("Joker",Font.BOLD,18));
		
		b1.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
				if(tf5.getText().equals(""))
					JOptionPane.showMessageDialog(f,"Enter username","Invalid",JOptionPane.WARNING_MESSAGE);
				else if(tf6.getPassword().length==0)
					JOptionPane.showMessageDialog(f,"Enter password","Invalid",JOptionPane.WARNING_MESSAGE);

				
				else
				{
				String fn,ln,em,un,ps,cont;
				fn=tf1.getText();
				System.out.println(fn);		
				ln=tf2.getText();		
				em=tf3.getText();		
				cont=tf4.getText();		
				un=tf5.getText();		
				ps=String.valueOf(tf6.getPassword());	
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/mpa","root","tiger");
					//String sql="insert into user values(?,?,?,?,?,?)";
					Random rand=new Random();
					
					int y=rand.nextInt(10);
					String userid=un+y+".";
				PreparedStatement st=con.prepareStatement("insert into user(fname,lname,email,contact,uname,pass,u_id) values(?,?,?,?,?,?,?)");
					st.setString(1,fn);
					st.setString(2,ln);
					st.setString(3,em);
					st.setString(4,cont);
					st.setString(5,un);
					st.setString(6,ps);
					st.setString(7,userid);
					//st.setInt(7,unhex(replace(uuid(),'-',''));
					//String sql="insert into user values("+fn+","+ln+","+em+","+cont+","+un+","+ps+")";
					int x=st.executeUpdate();
					
					if(x>0){
					JOptionPane.showMessageDialog(f,"Registered! Kindly Login!");
            					}
					f.dispose();
					Login r=new Login();
					con.close();

				}
				catch(Exception e1)
				{ System.out.println(e1);		}
				
				}
        			}
			});

		f.add(b1);
		f.setSize(600,600);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(0);

	}
}