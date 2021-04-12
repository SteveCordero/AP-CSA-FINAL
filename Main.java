import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Main
{
  public static void main(String []args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please Enter A Name: ");
    String name = scan.nextLine();



    JFrame frame1 = new JFrame("Time Adventure");
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.setSize(600,500);

    //---------------------Panels-------------------
    JPanel stats = new JPanel(new GridLayout(1,4,20,20));//Jpanel to hold the stats

    JPanel path = new JPanel(new GridLayout(2,1,20,20));
    
    //--------------------Labels--------------------
    JLabel playerInfo = new JLabel("<html>Character Info<br/>Name:" + name + "<br/> Day:0<br/>Status:Alive<br/>Journey: Incomplete<br/><br/><html>");

    JLabel playerStats = new JLabel("<html>Character Stats<br/>Health:<br/>100<br/>Hunger:<br/>100<br/><br/><br/><html>");

    JLabel animalStats = new JLabel("<html>Animal Stats<br/>Health:<br/>100<br/>Hunger:<br/>100<br/><br/><br/>");

    JLabel pathway = new JLabel("<html>((((xooxoxooxooxxxxoxoxoxooxxoooxxoxoxoxoxoxoxoxoxoxoxooxooxooxooxooxoxox))))<br/>((((xxxx|<html>");

    JLabel greenLabelPic = new JLabel();

    //------------------Images------------------------
    ImageIcon greenImage = new ImageIcon(new ImageIcon("green.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT), "Stable");
    
    ImageIcon yellowImage = new ImageIcon(new ImageIcon("yellow.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT), "hurt");

    ImageIcon redImage = new ImageIcon(new ImageIcon("red.jpg").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT),"Critically damaged");
    
    greenLabelPic.setIcon(yellowImage);
    greenLabelPic.setIcon(redImage);
    

    stats.add(playerInfo);
    stats.add(playerStats); 
    stats.add(animalStats);
    stats.add(greenLabelPic);

    path.add(pathway);

    frame1.getContentPane().add(BorderLayout.NORTH, stats);

    frame1.getContentPane().add(BorderLayout.CENTER, path);

    frame1.setVisible(true);
  }//end main method



}//end main class