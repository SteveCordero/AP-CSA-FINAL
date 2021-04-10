import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Main
{
  public static void main(String []args)
  {
    JFrame frame1 = new JFrame("Time Adventure");
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.setSize(600,1000);

    //---------------------Panels-------------------
    JPanel stats = new JPanel(new GridLayout(1,4,20,20));//Jpanel to hold the stats
    JPanel colors = new JPanel(new GridLayout(3,2,15,20));//JPanel to hold the color to indicate player condition within the stats JPanel

    //--------------------Labels--------------------
    JLabel playerInfo = new JLabel("<html>Character Info<br/>Name:null  <br/> Height:null<br/>Age:null<br/>Status:Alive<br/>Journey: Incomplete<html>");

    JLabel playerStats = new JLabel("<html>Character Stats<br/>Health:<br/>100<br/>Hunger:<br/>100<br/><br/><br/><html>");

    JLabel animalStats = new JLabel("<html>Animal Stats<br/>Health:<br/>100<br/>Hunger:<br/>100<br/><br/><br/>");

    //------------------Images------------------------
    ImageIcon greenImage = new ImageIcon(new ImageIcon("green.png").getImage().getScaledInstance(150,20, Image.SCALE_DEFAULT), "Stable");
    JLabel greenLabelPic = new JLabel(greenImage);

    

    stats.add(playerInfo);
    stats.add(playerStats); 
    stats.add(animalStats);
    stats.add(colors);
    colors.add(greenLabelPic);

    frame1.getContentPane().add(BorderLayout.NORTH, stats);

    frame1.setVisible(true);
  }
}//end main class