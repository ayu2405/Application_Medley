package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.io.*;	
import javax.imageio.*;
import java.sql.*;
import java.util.Calendar;
import java.text.*;
class GKQuiz implements QuizLayout
{
int i=1;
int score=0;
JFrame f;
static long startTime;
static ButtonGroup bg;
public JFrame displayQuiz(String userid,int level)
{

	f=new JFrame("Applications Medley");	

	f.setResizable(false);
	try{
	f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mpa/p8.jpg")))));
	}
	catch(Exception e5){
		System.out.println(e5); }
	JLabel l1=new JLabel("GENERAL KNOWLEDGE QUIZ");
	l1.setBounds(220,50,1000,50);
	//l1.setForeground(Color.white);
	l1.setHorizontalAlignment(SwingConstants.CENTER);
	l1.setFont(new Font("Joker",Font.BOLD,60));
	f.add(l1);
	JButton exit=new JButton("Exit");
	//exit.setForeground(Color.white);
	exit.setBounds(1250,10,70,30);
	exit.setOpaque(false);
	exit.setFont(new Font("Joker",Font.BOLD,20));
	exit.setContentAreaFilled(false);
	exit.setBorderPainted(false);	
	 exit.addActionListener(new ActionListener()
		{  
		public void actionPerformed(ActionEvent e)
		{  
		int dialogResult = JOptionPane.showConfirmDialog (f, "Are you sure you want to exit from quiz?");
   		if(dialogResult == JOptionPane.YES_OPTION){
            			f.dispose();
			if(i!=10) {
			score=0;
			JOptionPane.showMessageDialog(null, "Result not saved!");
			new Quiz(userid);
			}
		}
        		}
		});
	f.add(exit);
	JLabel l2=new JLabel();
	l2.setBounds(20,150,500,50);
	//l2.setHorizontalAlignment(SwingConstants.CENTER);
	l2.setFont(new Font("Joker",Font.BOLD,20));

	JLabel l3=new JLabel();
	l3.setBounds(20,200,1400,50);
	//l3.setHorizontalAlignment(SwingConstants.CENTER);
	l3.setFont(new Font("Joker",Font.BOLD,20));

	JRadioButton l4=new JRadioButton();    
	JRadioButton l5=new JRadioButton();  
	JRadioButton l6=new JRadioButton();    
	JRadioButton l7=new JRadioButton();    


	l4.setBounds(20,250,500,50);
	//l4.setHorizontalAlignment(SwingConstants.CENTER);
	l4.setFont(new Font("Joker",Font.BOLD,20));
	l4.setOpaque(false);
	l4.setContentAreaFilled(false);
	l4.setBorderPainted(false);
	
	l5.setBounds(20,300,500,50);
	//l5.setHorizontalAlignment(SwingConstants.CENTER);
	l5.setFont(new Font("Joker",Font.BOLD,20));
	l5.setOpaque(false);
	l5.setContentAreaFilled(false);
	l5.setBorderPainted(false);

	
	l6.setBounds(20,350,500,50);
	//l6.setHorizontalAlignment(SwingConstants.CENTER);
	l6.setFont(new Font("Joker",Font.BOLD,20));
	l6.setOpaque(false);
	l6.setContentAreaFilled(false);
	l6.setBorderPainted(false);

	
	l7.setBounds(20,400,500,50);
	//l7.setHorizontalAlignment(SwingConstants.CENTER);
	l7.setFont(new Font("Joker",Font.BOLD,20));
	l7.setOpaque(false);
	l7.setContentAreaFilled(false);
	l7.setBorderPainted(false);

  	//ButtonGroup bg
	bg=new ButtonGroup();    
	bg.add(l4);bg.add(l5);bg.add(l6);bg.add(l7);   

	f.add(l2);
	f.add(l3);
	f.add(l4);
	f.add(l5);
	f.add(l6);
	f.add(l7);	
	
		displayQues(userid,level,i,l2,l3,l4,l5,l6,l7);
	


	f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	f.setUndecorated(true);
	f.setVisible(true);
	return f;

}

public void displayQues(String userid,int level,int qno,JLabel l2,JLabel l3,JRadioButton l4,JRadioButton l5,JRadioButton l6,JRadioButton l7)
{
	 String ques,op1,op2,op3,op4,corr="";
			//System.out.println("i="+i);
	       try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");
	PreparedStatement pst=con.prepareStatement("select * from quesgk where level=? and q_no=?");
	pst.setInt(1,level);
	pst.setInt(2,qno);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //qno = rs.getInt("q_no");
               ques= rs.getString("ques");
               op1= rs.getString("op1");
               op2= rs.getString("op2");
               op3= rs.getString("op3");
               op4= rs.getString("op4");
               corr= rs.getString("correct");
	//System.out.println(qno+" "+ques+" "+op1+" "+op2+" "+op3+" "+op4+" "+corr);
	l2.setText("Question "+qno);
	l3.setText(ques);
	l4.setText(op1);
	l4.setActionCommand(op1);
	l5.setText(op2);
	l5.setActionCommand(op2);
	l6.setText(op3);
	l6.setActionCommand(op3);
	l7.setText(op4);
	l7.setActionCommand(op4);
	}
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
	String next;
	final String correct=corr;

	JButton b2=new JButton();

	int last=0;
	if(i==10){
	next="Submit";
	last=1;
	}
	else
	next="Next";

	b2.setText(next);

	b2.setBounds(300,600,100,30);
	b2.setFont(new Font("Joker",Font.BOLD,20));
 	b2.addActionListener(new ActionListener()
	{  
	public void actionPerformed(ActionEvent e)
	{  	String selected;
		
		if(bg.getSelection()==null)
		{
			selected="";
		}
		else {
		selected=bg.getSelection().getActionCommand();
		}
		evaluateAns(userid,level,qno,selected,correct);
		if(i!=10) {
		++i;
		f.dispose();
		JFrame f=displayQuiz(userid,level);
		//displayQues(level,++i,l2,l3,l4,l5,l6,l7);
		}
		else
		{
			f.dispose();
			displayScore(userid,level);
		}

       	}
	});
	f.add(b2);	
	
	

}
public void evaluateAns(String userid,int level,int qno,String selected,String corr)
{
if(selected.equals(corr))
{
	score++;
}

}

public void displayScore(String userid,int level)
{
	String paper;


	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");
	PreparedStatement pst1=con.prepareStatement("select userid from quiz");
	ResultSet rs=pst1.executeQuery();
	int idPresent=0;
	while(rs.next())
	{
		if((rs.getString(1)).equals(userid))
		{
		idPresent=1;
		break;
		}
	}
	if(idPresent==0)
	{
	PreparedStatement pst2=con.prepareStatement("insert into quiz(userid)values(?)");
	pst2.setString(1,userid);
	pst2.executeUpdate();
	}
	PreparedStatement pst;
	if(level==1) 
		pst=con.prepareStatement("update quiz set gk1= ? where userid=?");
	else if(level==2)
		 pst=con.prepareStatement("update quiz set gk2= ? where userid=?");
	else
		 pst=con.prepareStatement("update quiz set gk3= ? where userid=?");

	pst.setString(1,String.valueOf(score));
	pst.setString(2,userid);
	int x=pst.executeUpdate();
	if(x>0)
	{
                JOptionPane.showMessageDialog(null, "Congratulations!\nYou Completed the Quiz\nYour Score for level "+level+"= "+score+"/10");
	new Quiz(userid);
	}
	else
	{	
                JOptionPane.showMessageDialog(null, "Score Not Stored!", "Error", JOptionPane.ERROR_MESSAGE);
	new Quiz(userid);
	}
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
}

}