package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.io.*;	
import javax.imageio.*;
public class Quiz
{
	
	Quiz(String userid)
	{
		
		LayoutQuiz l=new LayoutQuiz();
		JFrame f=l.display(userid,"Fun Quiz");
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
		//l2.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(l2);
		
		JButton b1=new JButton("Scorecard");
		b1.setBounds(100,200,150,50);
		b1.setFont(new Font("Joker",Font.BOLD,18));

		b1.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				new ScoreCard(userid);
				
        			}
			});
		//b1.setBackground(Color.GREEN);
		f.add(b1);

		JButton b2=new JButton("Give Quiz");
		b2.setBounds(300,200,150,50);
		b2.setFont(new Font("Joker",Font.BOLD,18));
		b2.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				new QuizInstr(userid);
				
        			}
			});

		f.add(b2);

		f.setSize(600,400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(0);
	
	}

}