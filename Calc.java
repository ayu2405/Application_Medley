package mpa;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.script.*;
class Calc implements ActionListener
{

JFrame f;
JTextField t;

JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bdiv,bmul,bmod,badd,bsub,bsqr,bsqrt,bdel,beqi,bdec,bclr,bx,blog;
static double a=0,b=0,result=0;
static int operator=0;

    Calc(String userid)
{

    f=new JFrame("Calculator");
    t=new JTextField();
    t.setHorizontalAlignment(JTextField.RIGHT);
    b0=new JButton("0");
    b1=new JButton("1");
    b2=new JButton("2");
    b3=new JButton("3");
b4=new JButton("4");
b5=new JButton("5");
b6=new JButton("6");
b7=new JButton("7");
b8=new JButton("8");
b9=new JButton("9");
b0=new JButton("0");
bmod=new JButton("%");
badd=new JButton("+");
bsub=new JButton("-");
bmul=new JButton("*");
bdiv=new JButton("/");
bsqrt=new JButton("SQRT");
bsqr=new JButton("x^2");
bdel=new JButton("DEL");
bclr=new JButton("C");
beqi=new JButton("=");
bdec=new JButton(".");
bx=new JButton("1/x");
blog=new JButton("log");


b1.setFont(new Font("Arial", Font.PLAIN, 30));
b2.setFont(new Font("Arial", Font.PLAIN, 30));
b3.setFont(new Font("Arial", Font.PLAIN, 30));
b4.setFont(new Font("Arial", Font.PLAIN, 30));
b5.setFont(new Font("Arial", Font.PLAIN, 30));
b6.setFont(new Font("Arial", Font.PLAIN, 30));
b7.setFont(new Font("Arial", Font.PLAIN, 30));
b8.setFont(new Font("Arial", Font.PLAIN, 30));
b9.setFont(new Font("Arial", Font.PLAIN, 30));
b0.setFont(new Font("Arial", Font.PLAIN, 30));
bdec.setFont(new Font("Arial", Font.PLAIN, 30));
bdel.setFont(new Font("Arial", Font.PLAIN, 20));
bsub.setFont(new Font("Arial", Font.PLAIN, 30));
badd.setFont(new Font("Arial", Font.PLAIN, 30));
bdiv.setFont(new Font("Arial", Font.PLAIN, 30));
bmul.setFont(new Font("Arial", Font.PLAIN, 30));
bclr.setFont(new Font("Arial", Font.PLAIN, 30));
bsqrt.setFont(new Font("Arial", Font.PLAIN, 20));
bsqr.setFont(new Font("Arial", Font.PLAIN, 30));
beqi.setFont(new Font("Arial", Font.PLAIN, 30));
bx.setFont(new Font("Arial", Font.PLAIN, 30));
blog.setFont(new Font("Arial", Font.PLAIN, 30));
bmod.setFont(new Font("Arial", Font.PLAIN, 25));

t.setFont(new Font("Arial", Font.PLAIN, 30));

t.setBounds(10,20,370,70);
bmod.setBounds(10,100,90,50);
bsqrt.setBounds(110,100,90,50);
bsqr.setBounds(210,100,90,50);
bx.setBounds(310,100,80,50);
blog.setBounds(10,160,90,50);
bclr.setBounds(110,160,90,50);
bdel.setBounds(210,160,90,50);
bdiv.setBounds(310,160,80,50);
b7.setBounds(10,220,90,50);
b8.setBounds(110,220,90,50);
b9.setBounds(210,220,90,50);
bmul.setBounds(310,220,80,50);
b4.setBounds(10,280,90,50);
b5.setBounds(110,280,90,50);
b6.setBounds(210,280,90,50);
bsub.setBounds(310,280,80,50);
b1.setBounds(10,340,90,50);
b2.setBounds(110,340,90,50);
b3.setBounds(210,340,90,50);
badd.setBounds(310,340,80,50);
bdec.setBounds(10,400,90,50);
b0.setBounds(110,400,90,50);
beqi.setBounds(210,400,180,50);



f.add(t);
f.add(bmod);
f.add(bsqrt);
f.add(bsqr);
f.add(bx);
f.add(blog);
f.add(bclr);
f.add(bdel);
f.add(bdiv);
f.add(b7);
f.add(b8);
f.add(b9);
f.add(bmul);
f.add(b4);
f.add(b5);
f.add(b6);
f.add(bsub);
f.add(b1);
f.add(b2);
f.add(b3);
f.add(badd);
f.add(b0);
f.add(beqi);
f.add(bdec);



f.setLayout(null);
f.setVisible(true);
f.setSize(400,500);
f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
		f.dispose();
                    //new Apps(userid);
                }
            });

f.setResizable(false);


b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        badd.addActionListener(this);
        bdiv.addActionListener(this);
        bmul.addActionListener(this);
        bsub.addActionListener(this);
        bdec.addActionListener(this);
        beqi.addActionListener(this);
        bdel.addActionListener(this);
        bclr.addActionListener(this);
        bmod.addActionListener(this);
        bsqr.addActionListener(this);
        bsqrt.addActionListener(this);
        bx.addActionListener(this);
        blog.addActionListener(this);
       }
    int flag1=0;
    public void actionPerformed(ActionEvent e)
    {

	if(flag1==1)
	{
	t.setText("");
	}
	flag1=0;
        if(e.getSource()==b1)
            t.setText(t.getText().concat("1"));
        
        if(e.getSource()==b2)
            t.setText(t.getText().concat("2"));
        
        if(e.getSource()==b3)
            t.setText(t.getText().concat("3"));
        
        if(e.getSource()==b4)
            t.setText(t.getText().concat("4"));
        
        if(e.getSource()==b5)
            t.setText(t.getText().concat("5"));
        
        if(e.getSource()==b6)
            t.setText(t.getText().concat("6"));
        
        if(e.getSource()==b7)
            t.setText(t.getText().concat("7"));
        
        if(e.getSource()==b8)
            t.setText(t.getText().concat("8"));
        
        if(e.getSource()==b9)
            t.setText(t.getText().concat("9"));
        
        if(e.getSource()==b0)
            t.setText(t.getText().concat("0"));
        
        if(e.getSource()==bdec)
            t.setText(t.getText().concat("."));
        
        if(e.getSource()==badd)
        {

            t.setText(t.getText()+"+");

        } 

        if(e.getSource()==bsub)
        {
     
            t.setText(t.getText()+"-");

        }
        
        if(e.getSource()==bmul)
        {
   
            t.setText(t.getText()+"*");

        }
        
        if(e.getSource()==bdiv)
        {

            t.setText(t.getText()+"/");


        }
        
        if(e.getSource()==bmod)
        {

            t.setText(t.getText()+"%");


        }
        if(e.getSource()==bsqr)
        {
	flag1=1;
	try {
            a=Double.parseDouble(t.getText());
            result=a*a;
            t.setText(""+result);  
	}
	catch(Exception ex)
	{
	t.setText("NO NUMBER TO CALC.");
	}
             
        }

        if(e.getSource()==bsqrt)
        {
		flag1=1;
	try {
            a=Double.parseDouble(t.getText());
	
            result=Math.sqrt(a);
            t.setText(""+result);  
	}
	catch(Exception ex)
	{
	t.setText("NO NUMBER TO CALC.");
	}
        }
        if(e.getSource()==bx)
        {
		flag1=1;
	try {
            a=Double.parseDouble(t.getText());
             result=1/a;
            t.setText(""+result);  
	}
	catch(Exception ex)
	{
	t.setText("NO NUMBER TO CALC.");
	}
        }
         if(e.getSource()==blog)
        {

		flag1=1;
	try {
            a=Double.parseDouble(t.getText());
            result=Math.log(a);
            t.setText(""+result);  
	}
	catch(Exception ex)
	{
	t.setText("NO NUMBER TO CALC.");
	}
        }
        
        if(e.getSource()==beqi)
        {
	flag1=1;
   ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
 
        try {

            Object result = engine.eval(t.getText());
 
            System.out.println(t.getText() + " = " + result);
	      t.setText(result.toString());
        }
        catch (ScriptException e1) {
     	t.setText("INVALID");
            e1.printStackTrace();
        }



        }
        
        if(e.getSource()==bclr)
            t.setText("");
        
        if(e.getSource()==bdel)
        {
            String s=t.getText();
            t.setText("");
            for(int i=0;i<s.length()-1;i++)
            t.setText(t.getText()+s.charAt(i));
        }        
		f.setDefaultCloseOperation(0);
    }
 

}


