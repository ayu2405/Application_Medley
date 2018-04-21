package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.io.*;	
import javax.imageio.*;
public class QuizInstr
{
	
	QuizInstr(String userid)
	{
		
		LayoutQuiz l=new LayoutQuiz();
		JFrame f=l.display(userid,"Instructions");
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
				new Apps(userid);
        			}
			});
		f.add(back);
		
		JLabel l2=new JLabel("FUN QUIZ");
		l2.setForeground(Color.white);
		//l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Joker",Font.BOLD,18));
		l2.setBounds(250,100,300,30);
		
		f.add(l2);
		
	
		JLabel l8=new JLabel("Instructions");
		l8.setForeground(Color.white);
		//l2.setForeground(Color.WHITE);
		l8.setFont(new Font("Joker",Font.BOLD,16));
		l8.setBounds(250,150,300,30);
		
		f.add(l8);
		

		JLabel l3=new JLabel("Each subject has 3 levels according to difficulty of questions.");
		l3.setBounds(20,200,550,50);
		l3.setForeground(Color.white);
		l3.setFont(new Font("Joker",Font.BOLD,18));
		f.add(l3);

		JLabel l4=new JLabel("Each paper contains 10 questions.");
		l4.setBounds(20,250,550,50);
		l4.setForeground(Color.white);
		l4.setFont(new Font("Joker",Font.BOLD,18));
		f.add(l4);

		JLabel l5=new JLabel("Each question carries 1 mark.");
		l5.setBounds(20,300,550,50);
		l5.setForeground(Color.white);
		l5.setFont(new Font("Joker",Font.BOLD,18));
		f.add(l5);

		JLabel l6=new JLabel("There is no negative marking");
		l6.setBounds(20,350,550,50);
		l6.setForeground(Color.white);
		l6.setFont(new Font("Joker",Font.BOLD,18));
		f.add(l6);


		JLabel l7=new JLabel("Once the quiz starts, exiting from the quiz wil lead to loss of progress.");
		l7.setBounds(20,400,650,50);
		l7.setForeground(Color.white);
		l7.setFont(new Font("Joker",Font.BOLD,18));
		f.add(l7);

		JButton b2=new JButton("Give Quiz");
		b2.setBounds(270,500,120,30);
		b2.setFont(new Font("Joker",Font.BOLD,16));
		b2.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				new GiveQuiz(userid);
        			}
			});
	
		f.add(b2);


		f.setSize(650,600);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(0);
	
	}

}