package mpa;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.event.*;
public class MyTimerTask extends TimerTask {
JavaQuiz gq;
    @Override
    public void run() {
    //    System.out.println("Timer task started at:"+new Date());

        gq=new JavaQuiz();
        JFrame f=gq.displayQuiz("123",1);
        completeTask();
        f.dispose();
       // System.out.println("Timer task finished at:"+new Date());
    }

    private void completeTask() {
        try {
            //assuming it takes 5 secs to complete the task
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        TimerTask timerTask = new MyTimerTask();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.schedule(timerTask,0);

        System.out.println("TimerTask started");
        //cancel after sometime
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        timer.cancel();
        System.out.println("TimerTask cancelled");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}