package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.io.*;	
import javax.imageio.*;
public class Difficulty
{
	
	Difficulty(String userid,int sub)
	{
		
		LayoutQuiz l=new LayoutQuiz();
		JFrame f=l.display(userid,"Choose Difficulty Level");
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
				new GiveQuiz(userid);
        			}
			});
		f.add(back);
		JLabel l2=new JLabel("CHOOSE LEVEL");
		l2.setForeground(Color.white);
		l2.setFont(new Font("Joker",Font.BOLD,18));
		l2.setBounds(250,100,300,30);
		//l2.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(l2);

		
		JButton b1=new JButton("EASY");
		b1.setBounds(230,200,150,40);
		b1.setFont(new Font("Joker",Font.BOLD,16));

		b1.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            	
				    int a=JOptionPane.showConfirmDialog(f,"Start Quiz?");  
				if(a==JOptionPane.YES_OPTION){  
				f.dispose();
				if(sub==1) { new JavaQuiz().displayQuiz(userid,1);	}
				else if(sub==2) { new GKQuiz().displayQuiz(userid,1);		}
				else
				{ 	new AptiQuiz().displayQuiz(userid,1);	
				}
				
				}
					
        			}
			});
		f.add(b1);

		JButton b2=new JButton("MEDIUM");
		b2.setBounds(230,300,150,40);
		b2.setFont(new Font("Joker",Font.BOLD,16));
		b2.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  

				    int a=JOptionPane.showConfirmDialog(f,"Start Quiz?");  
				if(a==JOptionPane.YES_OPTION){  
				
            				f.dispose();

				if(sub==1) { new JavaQuiz().displayQuiz(userid,2);	}
				else if(sub==3) { new AptiQuiz().displayQuiz(userid,2);		}
				else
				{ 
					new GKQuiz().displayQuiz(userid,2);	
					}
				
				}
        			}
			});

		f.add(b2);

		JButton b3=new JButton("DIFFICULT");
		b3.setBounds(230,400,150,40);
		b3.setFont(new Font("Joker",Font.BOLD,16));
		b3.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  	 int a=JOptionPane.showConfirmDialog(f,"Start Quiz?");  
				if(a==JOptionPane.YES_OPTION){  
				f.dispose();
				if(sub==1) { new JavaQuiz().displayQuiz(userid,3);	}
				else if(sub==3) { new AptiQuiz().displayQuiz(userid,3);		}
				else
				{ new GKQuiz().displayQuiz(userid,3);	
				}
				}
				
        			}
			});

		f.add(b3);
		f.setSize(600,600);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(0);
	
	}

}