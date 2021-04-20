import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Main
{
  public static void main(String []args)
  {
    String name = JOptionPane.showInputDialog("Enter Name:");

    Stats user = new Stats(100,100,1,0);

    Harm poisonBush = new Harm(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 10, 1, "poisonous bush");

    Harm cactus = new Harm(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 15, 1, "cactus");

    Harm werewolf = new Harm(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 30, 1, "werewolf");

    Harm angryChicken = new Harm(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 15, 1, "aggrivated chicken");

    System.out.println(angryChicken.getName());
    
    JFrame frame1 = new JFrame("Time Adventure");
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.setSize(650,400);

    //---------------------Panels-------------------
    JPanel stats = new JPanel(new GridLayout(1,4,20,20));//Jpanel to hold the stats

    JPanel path = new JPanel(new GridLayout(3,1,20,20));

    JPanel actions = new JPanel(new GridLayout(1,3,75,75));
    
    //--------------------Labels--------------------
    JLabel playerInfo = new JLabel("<html>Character Info<br/>Name:" + name + "<br/> Day:0<br/>Status:Alive<br/>Journey: Incomplete<br/><br/><html>");

    JLabel playerStats = new JLabel("<html>Character Stats<br/>Health:<br/>100<br/>Hunger:<br/>100<br/><br/><br/><html>");

    JLabel animalStats = new JLabel("<html>Animal Stats<br/>Health:<br/>100<br/>Hunger:<br/>100<br/><br/><br/>");

    JLabel pathway = new JLabel("<html>((((xooxoxooxooxxxxoxoxoxooxxoooxxoxoxoxoxoxoxoxoxoxoxooxooxooxooxooxoxox))))<br/>((((xxxx|<html>");

    JLabel emptyLabel = new JLabel();
    JLabel emptyLabel2 = new JLabel();

    JLabel greenLabelPic = new JLabel();

    //------------------Images------------------------
    ImageIcon greenImage = new ImageIcon(new ImageIcon("green.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT), "Stable");
    
    ImageIcon yellowImage = new ImageIcon(new ImageIcon("yellow.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT), "hurt");

    ImageIcon redImage = new ImageIcon(new ImageIcon("red.jpg").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT),"Critically damaged");
    
    greenLabelPic.setIcon(yellowImage);
    // greenLabelPic.setIcon(redImage);
    
    //-----------------Buttons------------------------
    JButton feedCharacter = new JButton("Feed Character");

    feedCharacter.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        System.out.println("This currently does nothing");
      }
    });//this is the button to feed the character


    JButton feedAnimal = new JButton("Feed Animal");

    feedAnimal.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        System.out.println("This also does nothing");
      }
    });//this is the button to feed the transportation if available
    

    JButton move = new JButton("Move");

    move.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        System.out.println("And at last this one currently does nothign as well");
      }
    });//this will be the button to move the "character" across the board

    //---------------Setting the Dimensions of the Buttons------
    Dimension d = new Dimension(100,100);
    feedCharacter.setPreferredSize(d);
    feedAnimal.setPreferredSize(d);
    move.setPreferredSize(d);

    //Adding all components to their respective Panels
    stats.add(playerInfo);
    stats.add(playerStats); 
    stats.add(animalStats);
    stats.add(greenLabelPic);

    path.add(emptyLabel);
    path.add(pathway);
    path.add(emptyLabel2);

    actions.add(feedCharacter);
    actions.add(feedAnimal);
    actions.add(move);

    frame1.getContentPane().add(BorderLayout.NORTH, stats);

    frame1.getContentPane().add(BorderLayout.CENTER, path);

    frame1.getContentPane().add(BorderLayout.SOUTH, actions);

    frame1.setVisible(true);
  }//end main method



}//end main class