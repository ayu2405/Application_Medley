package mpa;
import javax.swing.*;
interface QuizLayout
{
abstract JFrame displayQuiz(String userid,int level);


abstract void displayQues(String userid,int level,int qno,JLabel l2,JLabel l3,JRadioButton l4,JRadioButton l5,JRadioButton l6,JRadioButton l7);

abstract void evaluateAns(String userid,int level,int qno,String selected,String corr);

abstract void displayScore(String userid,int level);
}