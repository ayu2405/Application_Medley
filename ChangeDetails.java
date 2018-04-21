package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.sql.*;
import java.io.*;	
import javax.imageio.*;
public class ChangeDetails
{
	 ChangeDetails(String userid)
	{
		
		JFrame f=new JFrame("MPA");	
		f.setResizable(false);

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

		JLabel l1=new JLabel("APPLICATION MEDLEY");
		l1.setBounds(170,50,300,30);
		//l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Joker",Font.BOLD,24));
		f.add(l1);
		
		JLabel l2=new JLabel("PERSONAL DETAILS");
		l2.setFont(new Font("Joker",Font.BOLD,18));
		l2.setBounds(200,100,300,30);
		f.add(l2);
		

		

		String fn="",ln="",un="",em="",cont="";
		String ps="";
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/mpa","root","tiger");
		//String sql="insert into user values(?,?,?,?,?,?)";
				
		PreparedStatement st=con.prepareStatement("select * from user where u_id=?");
		st.setString(1,userid);


		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			fn=rs.getString(1);
			ln=rs.getString(2);
			em=rs.getString(3);
			cont=rs.getString(4);
			un=rs.getString(5);
			ps=rs.getString(6);
		}
		} //try block
		catch(Exception ex) {
			System.out.println(ex);  }


		JLabel l3=new JLabel("First Name");
		l3.setFont(new Font("Joker",Font.BOLD,14));
		l3.setBounds(50,150,200,30);
		JTextField tf1=new JTextField(fn);
		tf1.setBounds(200,150,200,30);
		f.add(tf1);
		f.add(l3);
		
		JLabel l4=new JLabel("Last Name");
		l4.setFont(new Font("Joker",Font.BOLD,14));
		l4.setBounds(50,200,200,30);
		 JTextField tf2=new JTextField(ln);
		tf2.setBounds(200,200,200,30);
		f.add(tf2);
		f.add(l4);

		JLabel l5=new JLabel("Email Id");
		l5.setFont(new Font("Joker",Font.BOLD,14));
		l5.setBounds(50,250,200,30);
		JTextField tf3=new JTextField(em);
		tf3.setBounds(200,250,200,30);
		f.add(tf3);
		f.add(l5);

		JLabel l6=new JLabel("Contact Number");
		l6.setFont(new Font("Joker",Font.BOLD,14));
		l6.setBounds(50,300,200,30);
		JTextField tf4=new JTextField(cont);
		tf4.setBounds(200,300,200,30);
		f.add(tf4);
		f.add(l6);

		JLabel l7=new JLabel("User Name");
		l7.setFont(new Font("Joker",Font.BOLD,14));
		l7.setBounds(50,350,200,30);
		JTextField tf5=new JTextField(un);
		tf5.setBounds(200,350,200,30);
		f.add(tf5);
		f.add(l7);

		final String newp=ps;
		JButton pass=new JButton("Change password");
		pass.setBounds(50,400,200,30);
		//pass.setFont(new Font("Joker",Font.BOLD,18));		
		 pass.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
				
				String old=JOptionPane.showInputDialog(f,"Enter Old Password");
				if(old.equals(newp))
				{
            				new ChangePass(userid);
				}
				else
				{
				JOptionPane.showMessageDialog(f,"Wrong password!");
				f.dispose();
				new ChangeDetails(userid);					
				}
				

				
        			}
			});
		f.add(pass);



		
		JButton b2=new JButton("Save Changes");
		b2.setBounds(400,400,150,30);
		//b2.setFont(new Font("Joker",Font.BOLD,18));
		b2.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				
				String fn1,ln1,em1,un1,cont1;
				fn1=tf1.getText();	
				ln1=tf2.getText();		
				em1=tf3.getText();		
				cont1=tf4.getText();		
				un1=tf5.getText();		
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mpa","root","tiger");
										
				PreparedStatement st1=con.prepareStatement("update user set fname= ?,lname= ?,email= ?, contact= ?, uname= ? where u_id= ?");
					st1.setString(1,fn1);
					st1.setString(2,ln1);
					st1.setString(3,em1);
					st1.setString(4,cont1);
					st1.setString(5,un1);
					st1.setString(6,userid);

					int x=st1.executeUpdate();
					
					if(x>0){
					JOptionPane.showMessageDialog(f,"Personal Details Updated");  }

				

				f.dispose();
				Apps r=new Apps(userid);
        	

				}
				catch(Exception e1)
				{ System.out.println(e1);		}
		}
			});
		
		f.add(b2);		
		f.setSize(600,600);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(0);
	
	}


}