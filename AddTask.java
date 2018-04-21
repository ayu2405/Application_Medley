package mpa;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;	
import java.sql.*;
import javax.swing.JTable;
import java.io.*;	
import javax.imageio.*;
public class AddTask
{
	public AddTask(String userid)
	{
     		JFrame f1=new JFrame("Add Task");
		//f1.getContentPane().setBackground(Color.YELLOW);

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
				new ToDoList(userid);
				
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
		
		JLabel l3=new JLabel("Task");
		l3.setFont(new Font("Joker",Font.BOLD,14));
		l3.setBounds(50,150,50,30);
		JTextField tf1=new JTextField();
		tf1.setBounds(200,150,250,30);
		f1.add(tf1);
		f1.add(l3);	


		JLabel l4=new JLabel("Status");
		l4.setFont(new Font("Joker",Font.BOLD,14));
		l4.setBounds(50,200,100,30);
		f1.add(l4);
		JRadioButton r1=new JRadioButton("Not done",true);    
		JRadioButton r2=new JRadioButton("Done");    
		r1.setBounds(150,200,100,30);    
		r2.setBounds(250,200,100,30);    
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);bg.add(r2);    
		//f1.add(bg);
		JButton b2=new JButton("Add");
		b2.setBounds(250,250,70,30);
		b2.setFont(new Font("Joker",Font.BOLD,14));
		b2.addActionListener(new ActionListener()
		{  
		public void actionPerformed(ActionEvent e)
		{  
     			String task=tf1.getText();
		    int st=0;
			    if(r1.isSelected())
			        st=0;
			   else
			      st=1;
			try
			{

			    Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");

			PreparedStatement st1=con.prepareStatement("insert into todo(u_id,task,status)values(?,?,?)");
		
			st1.setString(1,userid);
			st1.setString(2,task);
			st1.setInt(3,st);
			
			int x=st1.executeUpdate();
			if(x>0)
			JOptionPane.showMessageDialog(f1,"Task Added");
		
			else
			JOptionPane.showMessageDialog(f1,"Task Not Added","Error", JOptionPane.ERROR_MESSAGE);
			
			new ToDoList(userid);
			//con.close();
			}
			catch(Exception e2)
			{
			   System.out.println(e2);
			}

			f1.dispose();

		
       		}
		});
		f1.add(b2);
		
		f1.setLayout(null);
		f1.add(r1);f1.add(r2);     
		f1.setSize(600,400);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(0);
	}
}
