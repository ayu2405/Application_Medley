package mpa;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PrintCard extends JPanel
{

    public PrintCard(JFrame frame)
    {
        /*JFrame frame = new JFrame("TheFrame");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
	*/
        try
        {
            BufferedImage image = new BufferedImage(600, 720, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            frame.paint(graphics2D);
            ImageIO.write(image,"jpeg", new File("C:/jdk1.8.0_91/ScoreCard.jpeg"));
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
	JOptionPane.showMessageDialog(frame,"Saved ScoreCard! Image Path: C:/jdk1.8.0_91/ScoreCard.jpeg!");
    }

    protected void paintComponent(Graphics g)
    {
        g.drawRect(50,50,50,50);
    }


}