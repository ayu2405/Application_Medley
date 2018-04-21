package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.sql.*;
import java.io.*;	
import javax.imageio.*;
public class ChangePass
{
	
	 ChangePass(String userid)
	{
		
		JFrame f1=new JFrame("MPA");	
		f1.setResizable(false);

		try{
		f1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mpa/p5.jpg")))));
		}
		catch(Exception e5){
			System.out.println(e5); }

		JButton logout=new JButton("CANCEL");
		logout.setBounds(350,10,120,30);
		logout.setOpaque(false);
		logout.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		
		 logout.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f1.dispose();
			
        			}
			});
		f1.add(logout);

		JLabel l1=new JLabel("APPLICATION MEDLEY");
		l1.setBounds(100,50,300,30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Joker",Font.BOLD,24));
		f1.add(l1);
		
		JLabel l2=new JLabel("CHANGE PASSWORD");
		l2.setFont(new Font("Joker",Font.BOLD,18));
		l2.setBounds(200,100,300,30);
		//l2.setHorizontalAlignment(SwingConstants.CENTER);
		f1.add(l2);
		
	
		


		JLabel l8=new JLabel("New Password");
		l8.setFont(new Font("Joker",Font.BOLD,14));
		l8.setBounds(30,150,200,30);
		JPasswordField tf6=new JPasswordField();
		tf6.setBounds(200,150,200,30);
		f1.add(tf6);
		f1.add(l8);

		JLabel l9=new JLabel("Confirm New Password");
		l9.setFont(new Font("Joker",Font.BOLD,14));
		l9.setBounds(30,200,200,30);
		JPasswordField tf7=new JPasswordField();
		tf7.setBounds(200,200,200,30);
		f1.add(tf7);
		f1.add(l9);
			

		JButton b1=new JButton("Change Password");
		b1.setBounds(150,250,150,30);
		//b1.setFont(new Font("Joker",Font.BOLD,18));
		
		b1.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
	
				 String ps=String.valueOf(tf6.getPassword());
				  String nps=String.valueOf(tf7.getPassword());
				if(!ps.equals(nps))
				{
				     JOptionPane.showMessageDialog(f1,"Passwords dont match! Try again");
				     f1.dispose();
				     new ChangePass(userid);
				}
				else
				{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");
				PreparedStatement st=con.prepareStatement("update user set pass= ? where u_id=?");
					st.setString(1,ps);
					st.setString(2,userid);

					int x=st.executeUpdate();
					
					if(x>0){
					JOptionPane.showMessageDialog(f1,"Updated Password Successfully!");
            					}
					else
					 	JOptionPane.showMessageDialog(f1,"Password Not Changed!");
					f1.dispose();
					con.close();

				}
				catch(Exception e1)
				{ System.out.println(e1);		}
				}
				
				
        			}
			});

		f1.add(b1);
		f1.setSize(500,330);
		f1.setLayout(null);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(0);
	
	}

}