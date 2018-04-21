package mpa;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;	
import java.sql.*;
import javax.swing.JTable;
import java.io.*;	
import javax.imageio.*;
public class AddContact
{
	public AddContact(String userid)
	{
     		JFrame f1=new JFrame("Add Task");

		try{
		f1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mpa/p8.jpg")))));
		}
		catch(Exception e5){
			System.out.println(e5); }

		JButton logout=new JButton("LOGOUT");
		f1.setResizable(false);
		logout.setBounds(450,10,120,30);
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
				new AddressBook(userid);
				
        			}
			});
		f1.add(back);
		JLabel l1=new JLabel("TO-DO LIST");
		l1.setBounds(150,50,300,30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Joker",Font.BOLD,24));
		f1.add(l1);	
		
		JLabel l2=new JLabel("ADD TASK");
		l2.setFont(new Font("Joker",Font.BOLD,20));
		l2.setBounds(150,100,300,30);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		f1.add(l2);	
		
		JLabel l3=new JLabel("Contact Name");
		l3.setFont(new Font("Joker",Font.BOLD,14));
		l3.setBounds(50,150,200,30);
		JTextField tf1=new JTextField();
		tf1.setBounds(200,150,200,30);
		f1.add(tf1);
		f1.add(l3);
		
		JLabel l4=new JLabel("Contact Number");
		l4.setFont(new Font("Joker",Font.BOLD,14));
		l4.setBounds(50,200,200,30);
		JTextField tf2=new JTextField();
		tf2.setBounds(200,200,200,30);
		f1.add(tf2);
		f1.add(l4);

		JLabel l5=new JLabel("Email Id");
		l5.setFont(new Font("Joker",Font.BOLD,14));
		l5.setBounds(50,250,200,30);
		JTextField tf3=new JTextField();
		tf3.setBounds(200,250,200,30);
		f1.add(tf3);
		f1.add(l5);

		JLabel l6=new JLabel("Address");
		l6.setFont(new Font("Joker",Font.BOLD,14));
		l6.setBounds(50,300,200,30);
		JTextArea tf4=new JTextArea();
		tf4.setBounds(200,300,200,40);
		f1.add(tf4);
		f1.add(l6);

		JLabel l7=new JLabel("Relationship");
		l7.setFont(new Font("Joker",Font.BOLD,14));
		l7.setBounds(50,350,200,30);
		JComboBox<String> li = new JComboBox<String>();
		li.addItem("Friend");
		li.addItem("Family");
		li.addItem("Other");
		li.setBounds(200,350,200,30);
		f1.add(li);
		f1.add(l7);


		JLabel l10=new JLabel("Other details(if any)");
		l10.setFont(new Font("Joker",Font.BOLD,14));
		l10.setBounds(50,400,200,30);
		JTextField tf9=new JTextField();
		tf9.setBounds(200,400,200,30);
		f1.add(tf9);
		f1.add(l10);

		JButton b2=new JButton("Add");
		b2.setBounds(250,450,70,30);
		b2.setFont(new Font("Joker",Font.BOLD,14));
		b2.addActionListener(new ActionListener()
		{  
		public void actionPerformed(ActionEvent e)
		{  
     			String name=tf1.getText();
 			String num=tf2.getText();
 			String em=tf3.getText();
 			String addr=tf4.getText();
 			String relation=(String)li.getSelectedItem();
 			String other="";
			if(!tf9.getText().equals(""))
				other=tf9.getText();
			if(name.equals(""))
			{
			JOptionPane.showMessageDialog(f1,"Enter Contact Name","Error", JOptionPane.ERROR_MESSAGE);

			}
			else
			{

			try
			{

			    Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");

			PreparedStatement st1=con.prepareStatement("insert into addr(u_id,name,contact,address,email,relation,other)values(?,?,?,?,?,?,?)");
		
			st1.setString(1,userid);
			st1.setString(2,name);
			st1.setString(3,num);
			st1.setString(4,em);
			st1.setString(5,addr);
			st1.setString(6,relation);
			st1.setString(7,other);
			
			int x=st1.executeUpdate();
			if(x>0)
			JOptionPane.showMessageDialog(f1,"Contact Added");
		
			else
			JOptionPane.showMessageDialog(f1,"Contact Not Added","Error", JOptionPane.ERROR_MESSAGE);
			
			new AddressBook(userid);
			//con.close();
			}
			catch(Exception e2)
			{
			   System.out.println(e2);
			}

			f1.dispose();

		
       		}
}
		});
		
		f1.add(b2);
		
		f1.setLayout(null);

		f1.setSize(600,750);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(0);
	}
}
