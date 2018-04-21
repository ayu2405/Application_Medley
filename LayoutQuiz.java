package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.io.*;	
import javax.imageio.*;
public class LayoutQuiz
{
 public JFrame display(String userid,String framename)
 {
    		JFrame f=new JFrame(framename);	
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


		JLabel l1=new JLabel("APPLICATION MEDLEY");
		//l1.setForeground(Color.red);
		l1.setForeground(Color.WHITE);
		l1.setBounds(150,50,300,30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Joker",Font.BOLD,24));
		f.add(l1);
		f.setSize(600,600);
		f.setLayout(null);
		f.setVisible(true);
		return f;

 }

}