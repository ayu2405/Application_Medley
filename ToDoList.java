package mpa;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;	
import java.sql.*;
import java.io.*;	
import javax.imageio.*;
import javax.swing.JTable;
import java.lang.*;
public class ToDoList
{
	public ToDoList(String userid)
	{
		JFrame f=new JFrame("To-Do-List");
		//f.setResizable(false);
		JPanel p = new JPanel();


/*ImageIcon icon = new ImageIcon("mpa/p8.jpg"); 
JLabel thumb = new JLabel();
thumb.setIcon(icon);*/


		JButton logout=new JButton("LOGOUT");
		logout.setBounds(520,10,120,30);
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
		JLabel l1=new JLabel("APPLICATION MEDLEY");
		l1.setBounds(200,50,300,30);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Joker",Font.BOLD,24));
		f.add(l1);	
		

		JLabel l2=new JLabel("TO-DO LIST");
		l2.setFont(new Font("Joker",Font.BOLD,20));
		l2.setBounds(180,130,300,30);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(l2);	
 DefaultTableModel model = new DefaultTableModel();
String[] columnNames = {"S.No.","Task","Status"};
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable();
        table.setModel(model);
table.getColumnModel().getColumn(0).setPreferredWidth(30);
table.getColumnModel().getColumn(1).setPreferredWidth(300);
table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        int snum = 0;
        String task = "";
        int status = 0;

 String stat="NOT DONE";
        try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");
	PreparedStatement pst=con.prepareStatement("select * from todo where u_id=?");
	pst.setString(1,userid);
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                snum = rs.getInt("sno");
                task = rs.getString("task");
                status = rs.getInt("status");
	if(status==0)
	stat="NOT DONE";
	else
	stat="DONE";
                model.addRow(new Object[]{snum,task,stat});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
      //  f.add(scroll);

	//	f.setSize(600,600);
		//f.setLayout(null);
	//	f.setVisible(true);

 	p.setLayout(new GridBagLayout());
        
	p.setBackground(Color.lightGray);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.ipadx= 500;
        gbc.ipady = 200;
        gbc.insets = new Insets(2, 2, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;
 //       gbc.anchor = GridBagConstraints.NORTHWEST;

        p.add(scroll, gbc);
JButton b3=new JButton("Add Task");
b3.setBounds(50,500,100,30);
 b3.addActionListener(new ActionListener()
	{  
	public void actionPerformed(ActionEvent e)
	{  
		

		f.dispose();
		new AddTask(userid);
       	}
	});
		f.add(b3);
JButton b4=new JButton("DeleteTask");
b4.setBounds(250,500,100,30);
 b4.addActionListener(new ActionListener()
{  
 public void actionPerformed(ActionEvent e)
{  
     	int row = table.getSelectedRow();
	if(row==-1)
	{   JOptionPane.showMessageDialog(f, "Select a task to delete", "Error", JOptionPane.ERROR_MESSAGE);
	}
	else{
	 String Selected= (table.getModel().getValueAt(row, 0).toString());
	int Data=Integer.parseInt(Selected);	
	int dialogResult = JOptionPane.showConfirmDialog (f, "Are you sure you want to delete task?");
   	if(dialogResult == JOptionPane.YES_OPTION){
	//JOptionPane.showMessageDialog(null, "Deleted!"+Data);
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");				PreparedStatement st1=con.prepareStatement("delete from todo where sno=?");
		st1.setInt(1,Data);
		int x=st1.executeUpdate();
		if(x>0){
		JOptionPane.showMessageDialog(f,"Task Deleted");
		f.dispose();
		new ToDoList(userid);
		}
		else
		JOptionPane.showMessageDialog(f,"Task Not Deleted","Error", JOptionPane.ERROR_MESSAGE);

	}
	catch(Exception ed)
	{ System.out.println(ed);
	}
	}
 

	}//else of selected data
       	}
	});
		f.add(b4);
JButton b5=new JButton("Update Status");
b5.setBounds(450,500,150,30);
 b5.addActionListener(new ActionListener()
	{  
	public void actionPerformed(ActionEvent e)
	{  
 	int row = table.getSelectedRow();
	if(row==-1)
	{   JOptionPane.showMessageDialog(f, "Select a task to update status", "Error", JOptionPane.ERROR_MESSAGE);
	}
	else{
	 String Selected= (table.getModel().getValueAt(row, 0).toString());
	int Data=Integer.parseInt(Selected);	

	//JOptionPane.showMessageDialog(null, "Deleted!"+Data);
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpa","root","tiger");
		PreparedStatement ps2=con.prepareStatement("select status from todo where sno=?");
		ps2.setInt(1,Data);
		int st=0;
		ResultSet rs3=ps2.executeQuery();
		while(rs3.next())
		{
		if(rs3.getInt(1)==0)
			st=1;
		else
			st=0;
		}
		int dialogResult = JOptionPane.showConfirmDialog (f, "Do u want to change status of task?");
   		if(dialogResult == JOptionPane.YES_OPTION) {
		PreparedStatement st1=con.prepareStatement("update todo set status=? where sno=?");
		st1.setInt(1,st);
		st1.setInt(2,Data);
		int x=st1.executeUpdate();
		if(x>0){
		JOptionPane.showMessageDialog(f,"Status Updated");
		f.dispose();
		new ToDoList(userid);
		}
		}

	}
	catch(Exception ed2)
	{  System.out.println(ed2);
	}
		} 

       	}
	}); 
		f.add(b5);

 f.add(p);
		f.setSize(700,700);
		//f.setLayout(null);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(0);
	}

}





