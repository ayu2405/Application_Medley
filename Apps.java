package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.io.*;	
import javax.imageio.*;
public class Apps
{
	CapitalFinder cf;
	Calc calci;
	Currency currency;
	ToDoList tdl;
	AddressBook ab;
	Quiz q;
	public Apps(String userid)
	{
		JFrame f=new JFrame("Applications");
		f.setResizable(false);
		//f1.getContentPane().setBackground(Color.YELLOW);

		try{
		f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mpa/p5.jpg")))));
		}
		catch(Exception e5){
			System.out.println(e5); }


	

		JButton logout=new JButton("LOGOUT");
		logout.setBounds(450,10,120,30);
		//logout.setForeground(Color.white);
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



		JLabel l1=new JLabel("APPLICATION MEDLEY");
		l1.setBounds(120,70,300,30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Joker",Font.BOLD,26));
		//l1.setForeground(Color.white);
		f.add(l1);
		JButton b1=new JButton(new ImageIcon("mpa/cap.jpg"));
		b1.setBounds(20,150,170,170);
		b1.setFont(new Font("Joker",Font.BOLD,24));
		b1.setToolTipText("Capital Finder(Indian  States)");
		 b1.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				cf=new CapitalFinder(userid);
        			}
			});
	
		f.add(b1);

		JButton b2=new JButton(new ImageIcon("mpa/cc.png"));
		b2.setBounds(180,150,170,170);
		b2.setFont(new Font("Joker",Font.BOLD,24));
		b2.setToolTipText("Currency Convertor");
		b2.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				currency=new Currency(userid);
        			}
			});
	
		f.add(b2);


		JButton b3=new JButton(new ImageIcon("mpa/calci.png"));
		b3.setBounds(350,150,170,170);
		b3.setFont(new Font("Joker",Font.BOLD,24));
		b3.setToolTipText("Calculator");
	b3.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				calci=new Calc(userid);
				
        			}
			});
	
		f.add(b3);
		f.add(b3);

		JButton b4=new JButton(new ImageIcon("mpa/add.jpg"));
		b4.setBounds(20,330,170,170);
		b4.setFont(new Font("Joker",Font.BOLD,24));
		b4.setToolTipText("Address Book");
		b4.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				ab=new AddressBook(userid);
        			}
			});
		f.add(b4);

		JButton b5=new JButton(new ImageIcon("mpa/to.png"));
		b5.setBounds(180,330,170,170);
		b5.setFont(new Font("Joker",Font.BOLD,24));
		b5.setToolTipText("ToDo List");
		b5.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				tdl=new ToDoList(userid);
        			}
			});
	
		
		f.add(b5);

		JButton b6=new JButton(new ImageIcon("mpa/quiz.png"));
		b6.setBounds(350,330,170,170);
		b6.setFont(new Font("Joker",Font.BOLD,24));
		b6.setToolTipText("Fun Quiz");
		b6.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				q=new Quiz(userid);
        			}
			});
	
		f.add(b6);


		JButton b7=new JButton("View and Edit Personal Details");
		//b7.setForeground(Color.white);
		b7.setBounds(5,510,400,40);
		b7.setFont(new Font("Joker",Font.ITALIC,18));
		b7.setOpaque(false);
		b7.setContentAreaFilled(false);
		b7.setBorderPainted(false);
		b7.addActionListener(new ActionListener()
			{  
			public void actionPerformed(ActionEvent e)
			{  
            				f.dispose();
				new ChangeDetails(userid);
        			}
			});
	
		f.add(b7);
	
		f.setSize(600,600);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(0);
		
	}	

}