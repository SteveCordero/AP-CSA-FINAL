import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Main
{
  public static void main(String []args)
  {
    String name = JOptionPane.showInputDialog("Enter Name:");
    String foodChoice = JOptionPane.showInputDialog("Carrots or Apples?");
    final String foodC = foodChoice.toLowerCase();
    

    Stats user = new Stats(100,100,1,0);

    //-----------Intantiating all Harm Objects------------------------------
    Harm poisonBush = new Harm(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 10, 1, "poisonous bush");

    Harm cactus = new Harm(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 15, 1, "cactus");

    Harm werewolf = new Harm(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 30, 1, "werewolf");

    Harm angryChicken = new Harm(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 15, 1, "aggrivated chicken");

    //------------Instantiating all speed objects-------------------------------

    Speed horse = new Speed(45, 30, 2, user.getDaysTraveled(), "Horse", 4);

    Speed walking = new Speed(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), "Walking", 10);

    //-----------Instatiating all hunger objects--------------------------------

    Hunger carrot = new Hunger(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 10, 10);

    Hunger apple = new Hunger(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 15,15);

    Hunger hay = new Hunger(horse.getHealth(), horse.getHunger(), horse.getSpeed(), horse.getDaysTraveled(), 5, 2);

    //-----------Instantiating inventory object------------------------------------

    Inventory backpack = new Inventory(10,10);
    ArrayList<Hunger> allFoods = new ArrayList<>();

    if(foodChoice.equals("carrots"))
    {
      backpack.fillInventory(allFoods , carrot);
    }
    else
    {
      backpack.fillInventory(allFoods , apple);
    }

    backpack.fillInventory(allFoods, hay);
    
    JFrame frame1 = new JFrame("Time Adventure");
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.setSize(650,400);

    //---------------------Panels-------------------
    JPanel stats = new JPanel(new GridLayout(1,4,20,20));//Jpanel to hold the stats

    JPanel path = new JPanel(new GridLayout(3,1,20,20));

    JPanel actions = new JPanel(new GridLayout(1,3,75,75));
    
    //--------------------Labels--------------------
    JLabel playerInfo = new JLabel("<html>Character Info<br/>Name:" + name + "<br/> Day:0<br/>Status:Alive<br/>Journey: Incomplete<br/><br/><html>");

    JLabel playerStats = new JLabel("<html>Character Stats<br/>Health:<br/>" + user.getHealth() + "<br/>Hunger:<br/>" + user.getHunger() + "<br/><br/><br/><html>");

    JLabel animalStats = new JLabel("<html>Animal Stats<br/>Health:<br/>"+ horse.getHealth()+ "<br/>Hunger:<br/>" + horse.getHunger() + "<br/><br/><br/>");

    JLabel pathway = new JLabel("<html>((((xooxoxooxooxxxxoxoxoxooxxoooxxoxoxoxoxoxoxoxoxoxoxooxooxooxooxooxoxox))))<br/>((((<html>");

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
    JButton feedCharacter = new JButton("<html>Feed Character<br/>Food Left: " + backpack.getFood());

    feedCharacter.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(backpack.getFood() > 0)
        {
          backpack.setFood(backpack.getFood()-1);
          feedCharacter.setText("<html>Feed Character<br/>Food Left: " + backpack.getFood());

          if(foodC.equals("carrots"))
          {
            backpack.updateInventory(allFoods, carrot);
            user.setHealth(user.getHealth() + carrot.getHealthEffect());
            if(user.getHealth() > 100)
            {
              user.setHealth(100);
            }

            user.setHunger(user.getHunger() + carrot.getHungerEffect());
            if(user.getHunger() > 100)
            {
              user.setHunger(100);
            }
            playerStats.setText("<html>Character Stats<br/>Health:<br/>" + user.getHealth() + "<br/>Hunger:" + user.getHunger() + "<br/>100<br/><br/><br/><html>");
          }
          else
          {
            backpack.updateInventory(allFoods, apple);
            user.setHealth(user.getHealth() + apple.getHealthEffect());
            if(user.getHealth() > 100)
            {
              user.setHealth(100);
            }

            user.setHunger(user.getHunger() + apple.getHungerEffect());
            if(user.getHunger() > 100)
            {
              user.setHunger(100);
            }
            playerStats.setText("<html>Character Stats<br/>Health:<br/>" + user.getHealth() + "<br/>Hunger:<br/>" + user.getHunger() + "<br/><br/><br/><html>");
          }
        }
        else
        {
          feedCharacter.setText("<html>Feed Character<br/>Food Left: 0");
          System.out.println("You have no more food, stop trying.");
        }
      }
    });//this is the button to feed the character, it will update the health and hunger on the playerStats label and will also update the values for hunger and health of the User object


    JButton feedAnimal = new JButton("<html>Feed Animal<br/> Food Left: " + backpack.getAnimalFood());

    feedAnimal.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(backpack.getAnimalFood() > 0)
        {
          backpack.setAnimalFood(backpack.getAnimalFood()-1);
          feedAnimal.setText("<html>Feed Animal<br/>Food Left: " + backpack.getAnimalFood());

          backpack.updateInventory(allFoods, hay);
          horse.setHealth(horse.getHealth() + hay.getHealthEffect());
          if(horse.getHealth() > 45)
          {
            horse.setHealth(45);
          }

          horse.setHunger(horse.getHunger() + hay.getHungerEffect());
          if(horse.getHunger() > 30)
          {
            horse.setHunger(30);
          }
          animalStats.setText("<html>Animal Stats<br/>Health:<br/>" + horse.getHealth() + "<br/>Hunger:<br/>" + horse.getHunger() + "<br/><br/><br/>");
    
        }
        else
        {
          feedAnimal.setText("<html>Feed Animal<br/>Food Left: 0");
          System.out.println("You have no more animal food, your horse will die soon.");
        }
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