package mpa;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;	
import java.sql.*;
import javax.swing.JTable;
import java.io.*;	
import javax.imageio.*;
public class ViewContact
{
	public ViewContact(String userid,int c_no,String name,String cont,String addre,String email,String relation,String otherdetails)
	{
     		JFrame f1=new JFrame("View Contact");

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
		JLabel l1=new JLabel("ADDRESS BOOK");
		l1.setBounds(150,50,300,30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Joker",Font.BOLD,24));
		f1.add(l1);	
		
		JLabel l2=new JLabel("View/Edit Contact");
		l2.setFont(new Font("Joker",Font.BOLD,20));
		l2.setBounds(150,100,300,30);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		f1.add(l2);	
		
		JLabel l3=new JLabel("Contact Name");
		l3.setFont(new Font("Joker",Font.BOLD,14));
		l3.setBounds(50,150,200,30);
		JTextField tf1=new JTextField(name);
		tf1.setBounds(200,150,200,30);
		f1.add(tf1);
		f1.add(l3);
		
		JLabel l4=new JLabel("Contact Number");
		l4.setFont(new Font("Joker",Font.BOLD,14));
		l4.setBounds(50,200,200,30);
		JTextField tf2=new JTextField(cont);
		tf2.setBounds(200,200,200,30);
		f1.add(tf2);
		f1.add(l4);

		JLabel l5=new JLabel("Email Id");
		l5.setFont(new Font("Joker",Font.BOLD,14));
		l5.setBounds(50,250,200,30);
		JTextField tf3=new JTextField(email);
		tf3.setBounds(200,250,200,30);
		f1.add(tf3);
		f1.add(l5);

		JLabel l6=new JLabel("Address");
		l6.setFont(new Font("Joker",Font.BOLD,14));
		l6.setBounds(50,300,200,30);
		JTextArea tf4=new JTextArea(addre);
		tf4.setBounds(200,300,200,40);
		f1.add(tf4);
		f1.add(l6);

		JLabel l7=new JLabel("Relationship");
		l7.setFont(new Font("Joker",Font.BOLD,14));
		l7.setBounds(50,350,200,30);
		JComboBox<String> li = new JComboBox<String>();
		li.addItem(relation);
		if(relation.equals("Family"))
		{
		li.addItem("Friend");		
		li.addItem("Other");
		}
		else if(relation.equals("Friend"))
		{
		li.addItem("Family");		
		li.addItem("Other");
		}
		else
		{
		li.addItem("Friend");		
		li.addItem("Family");
		}

		li.setBounds(200,350,200,30);
		f1.add(li);
		f1.add(l7);




		JLabel l8=new JLabel("Other details(if any)");
		l8.setFont(new Font("Joker",Font.BOLD,14));
		l8.setBounds(50,400,200,30);
		JTextField tf6=new JTextField(otherdetails);
		tf6.setBounds(200,400,200,30);
		f1.add(tf6);
		f1.add(l8);

		JButton b2=new JButton("Save Changes");
		b2.setBounds(250,450,150,30);
		b2.setFont(new Font("Joker",Font.BOLD,14));
		b2.addActionListener(new ActionListener()
		{  
		public void actionPerformed(ActionEvent e)
		{  
     			String name1=tf1.getText();
 			String num1=tf2.getText();
 			String em1=tf3.getText();
 			String addre1=tf4.getText();
 			String relation1=(String)li.getSelectedItem();
 			String other1=tf6.getText();
			/*if(!tf6.getText().equals(""))
				other1=tf6.getText();
			*/

			try
			{

			    Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");

			PreparedStatement st1=con.prepareStatement("update addr set name = ?,contact= ?,address= ?, email= ?,other= ?, relation= ?  where u_id= ? and cno= ?");


	
			st1.setString(1,name1);
			st1.setString(2,num1);
			st1.setString(4,em1);
			st1.setString(3,addre1);
			st1.setString(6,relation1);
			st1.setString(5,other1);
			st1.setString(7,userid);
			st1.setInt(8,c_no);
	
			int x=st1.executeUpdate();

			if(x>0)
			JOptionPane.showMessageDialog(f1,"Contact Edited");
		
			else
			JOptionPane.showMessageDialog(f1,"Contact Not Edited","Error", JOptionPane.ERROR_MESSAGE);
			
			//new AddressBook(userid);
			//con.close();
			}
			catch(Exception e2)
			{
			   System.out.println(e2);
			}

			f1.dispose();
			new AddressBook(userid);

		
       		}
		});
		
		f1.add(b2);
		
		f1.setLayout(null);

		f1.setSize(600,750);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(0);
	}
}
