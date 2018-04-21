package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.io.*;	
import javax.imageio.*;
public class First
{
	
	public First()
	{
		
		JFrame f=new JFrame("Applications Medley");	
		f.setResizable(false);
		//f.getContentPane().setBackground(Color.YELLOW);
try{
f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mpa/p17.jpeg")))));
}
catch(Exception e5){
System.out.println(e5); }
		JButton exit=new JButton("Exit");
		exit.setBounds(450,10,70,30);
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

		JLabel l1=new JLabel("APPLICATION MEDLEY");
		l1.setBounds(150,50,300,30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Joker",Font.BOLD,24));
		f.add(l1);
		
		JLabel l2=new JLabel("WELCOME");
		l2.setFont(new Font("Joker",Font.BOLD,18));
		l2.setBounds(250,100,300,30);
		//l2.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(l2);
		
		JButton b1=new JButton(new ImageIcon("mpa/login1.png"));
		b1.setBounds(140,200,100,30);
		b1.setFont(new Font("Joker",Font.BOLD,18));

		b1.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				Login l=new Login();
        			}
			});
		//b1.setBackground(Color.GREEN);
		f.add(b1);

		JButton b2=new JButton(new ImageIcon("mpa/reg.jpg"));
		b2.setBounds(300,200,150,30);
		b2.setFont(new Font("Joker",Font.BOLD,18));
		b2.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				Register r=new Register();
        			}
			});

		f.add(b2);

		f.setSize(600,400);
		f.setLayout(null);
		f.setVisible(true);	
		f.setDefaultCloseOperation(0);
	
	}
	public static void main(String args[])
	{
		new First();
	}

}