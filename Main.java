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
    frame1.setSize(500,500);

    //---------------------Panels-------------------
    JPanel stats = new JPanel(new GridLayout(2,2,20,20));

    //--------------------Labels--------------------
    JLabel playerStats = new JLabel("Health:100\tHealth:100");





    stats.add(playerStats); 

    frame1.getContentPane().add(BorderLayout.NORTH,stats);

    frame1.setVisible(true);
  }
}//end main class