package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.io.*;	
import javax.imageio.*;
public class DifficultyLevel
{
 public void display()
 {
    		JFrame f=new JFrame("Choose Subject");	
		f.setResizable(false);
		try{
	f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mpa/p13.jpg")))));
		}
		catch(Exception e5){
		System.out.println(e5); }
		JButton logout=new JButton("LOGOUT");
		logout.setForeground(Color.white);
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
		back.setForeground(Color.white);
		back.setBounds(0,10,120,30);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		 back.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				new Quiz(userid);
        			}
			});
		f.add(back);
		JLabel l1=new JLabel("APPLICATION MEDLEY");
		//l1.setForeground(Color.red);
		l1.setForeground(Color.WHITE);
		l1.setBounds(150,50,300,30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Joker",Font.BOLD,24));
		f.add(l1);
		

 }
}