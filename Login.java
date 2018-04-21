package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.sql.*;
import java.io.*;	
import javax.imageio.*;
public class Login
{
	String userid;
	public Login()
	{
		JFrame f=new JFrame("MPA");	
		f.setResizable(false);
		//f1.getContentPane().setBackground(Color.YELLOW);

		try{
		f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mpa/p18.jpg")))));
		}
		catch(Exception e5){
			System.out.println(e5); }
		JButton exit=new JButton("EXIT");
		exit.setBounds(470,2,60,30);
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		
		 exit.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
        			}
			});
		f.add(exit);

		JButton back=new JButton("BACK");
		back.setBounds(20,10,120,30);
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


		JLabel l1=new JLabel("APPLICATION MEDLEY");
		l1.setBounds(150,50,300,30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Joker",Font.BOLD,24));
		f.add(l1);	
		
		JLabel l2=new JLabel("LOGIN PORTAL");
		l2.setFont(new Font("Joker",Font.BOLD,20));
		l2.setBounds(150,100,300,30);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(l2);	
		



		JLabel l7=new JLabel("User Name");
		l7.setFont(new Font("Joker",Font.BOLD,14));
		l7.setBounds(100,200,200,30);
		JTextField tf5=new JTextField();
		tf5.setBounds(250,200,200,30);
		f.add(tf5);
		f.add(l7);


		JLabel l8=new JLabel("Password");
		l8.setFont(new Font("Joker",Font.BOLD,14));
		l8.setBounds(100,250,200,30);
		JPasswordField tf6=new JPasswordField();
		tf6.setBounds(250,250,200,30);
		f.add(tf6);
		f.add(l8);


		JButton b1=new JButton("LOGIN");
		b1.setBounds(230,300,150,50);
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
				String un,ps;
					
				un=tf5.getText();		
				ps=String.valueOf(tf6.getPassword());	
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");
				
					
			PreparedStatement st=con.prepareStatement("select u_id,uname,pass from user");
					
					

				//String sql="insert into user values("+fn+","+ln+","+em+","+cont+","+un+","+ps+")";
					ResultSet rs=st.executeQuery();
					String a;
					int y=0;
					while(rs.next())
					{
						
						if(rs.getString("pass").equals(ps) && rs.getString("uname").equals(un))
						{
							y=1;
							userid=rs.getString("u_id");
						}
					}
						if(y==1)
						{
						JOptionPane.showMessageDialog(f,"Login Successfull");
						f.dispose();
						Apps r=new Apps(userid);

						}
						else
						{
						
						JOptionPane.showMessageDialog(f,"Wrong Username or password!");
						f.dispose();
						Login r=new Login();
						}
						
					
					
					

					con.close();

				}
				catch(Exception e1)
				{ System.out.println(e1);		}
				
				}
        			}
			});

		f.add(b1);
		f.setSize(600,450);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(0);
	}
}