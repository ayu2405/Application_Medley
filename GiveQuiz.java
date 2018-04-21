package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.io.*;	
import javax.imageio.*;
public class GiveQuiz
{
	
	GiveQuiz(String userid)
	{
		
		LayoutQuiz l=new LayoutQuiz();
		JFrame f=l.display(userid,"Choose Subject");
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
		JLabel l2=new JLabel("SUBJECTS");
		l2.setForeground(Color.white);
		l2.setFont(new Font("Joker",Font.BOLD,18));
		l2.setBounds(250,100,300,30);
		//l2.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(l2);
		
		JButton b1=new JButton("JAVA");
		b1.setBounds(230,200,150,40);
		b1.setFont(new Font("Joker",Font.BOLD,16));

		b1.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				new Difficulty(userid,1);
				
        			}
			});
		//b1.setBackground(Color.GREEN);
		f.add(b1);

		JButton b2=new JButton("GENERAL KNOWLEDGE");
		b2.setBounds(190,300,250,40);
		b2.setFont(new Font("Joker",Font.BOLD,16));
		b2.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				new Difficulty(userid,2);
				
        			}
			});

		f.add(b2);

		JButton b3=new JButton("GENERAL APTITUDE");
		b3.setBounds(190,400,250,40);
		b3.setFont(new Font("Joker",Font.BOLD,16));
		b3.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				new Difficulty(userid,3);
				
        			}
			});

		f.add(b3);
		f.setSize(600,600);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(0);
	
	}

}