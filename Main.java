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
    final String board = "xooxoxooxooxxxxoxoxoxooxxoooxxoxoxoxoxoxoxoxoxoxoxooxooxooxooxooxoxox";

    Stats user = new Stats(100,100,3,0);

    //-----------Intantiating all Harm Objects------------------------------
    Harm empty = new Harm(0 ,0 ,0 ,0, 0 ,0 , "empty");

    Harm poisonBush = new Harm(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 10, 1, "poisonous bush");

    Harm cactus = new Harm(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 15, 1, "cactus");

    Harm werewolf = new Harm(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 30, 1, "werewolf");

    Harm angryChicken = new Harm(user.getHealth(), user.getHunger(), user.getSpeed(), user.getDaysTraveled(), 15, 1, "aggrivated chicken");

    ArrayList<Harm> enemies = new ArrayList<>();
    enemies.add(empty);
    enemies.add(poisonBush);
    enemies.add(cactus);
    enemies.add(werewolf);
    enemies.add(angryChicken);

    //------------Instantiating all speed objects-------------------------------

    Speed horse = new Speed(45, 30, 4, user.getDaysTraveled(), "Horse", 4);

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

    //---------------polymorphism check-------
    Stats userTest = user;
    System.out.println(userTest.currStats());

    userTest = carrot;
    System.out.println(userTest.currStats());

    userTest = horse;
    System.out.println(userTest.currStats());

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
            playerStats.setText("<html>Character Stats<br/>Health:<br/>" + user.getHealth() + "<br/>Hunger:<br/>" + user.getHunger() + "<br/><br/><br/><html>");
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
    });//this is the button to feed the transportation if transportation is available and will be in charge of updating the JLabel animal Stats to fit the new values of hunger and health
    

    JButton move = new JButton("Move");

    move.addActionListener(new ActionListener()
    {
      int position = 0;
      int enemy = 0;
      boolean done = false;
      
      public void actionPerformed(ActionEvent e)
      {
        enemy = (int)(Math.random() *(5 - 1) ) + 1;// this is to randomize the damage output when pressing the move button

        if(user.getHealth() == 0 || user.getHunger() == 0 || done)
        {
          System.out.println("Not Congrats, you have died");

          playerStats.setText("<html>Character Stats<br/>Health:<br/>0<br/>Hunger:<br/>0<br/><br/><br/><html>");

          animalStats.setText("<html>Animal Stats<br/>Health:<br/>0<br/>Hunger:<br/>0<br/><br/><br/>");

          playerInfo.setText("<html>Character Info<br/>Name:" + name + "<br/> Day:"+ user.getDaysTraveled()+"<br/>Status:Dead<br/>Journey: Incomplete<br/><br/><html>");

          pathway.setText("You are dead:(");

          done = true;
        }//end of if the user has died and will update the proper labels accordingly

        else if(!horse.isDead(horse.getHealth(), horse.getHunger()))
        {
          position += horse.getSpeed();
          user.setDaysTraveled(user.getDaysTraveled() + 1);

          if(position > board.length())
          {
            System.out.println("You won congrats");
            pathway.setText("<html>((((xooxoxooxooxxxxoxoxoxooxxoooxxoxoxoxoxoxoxoxoxoxoxooxooxooxooxooxoxox))))<br/>((((" + board+ "|<html>");

            playerInfo.setText("<html>Character Info<br/>Name:" + name + "<br/> Day:"+ user.getDaysTraveled() +"<br/>Status:Alive<br/>Journey: Complete<br/><br/><html>");
          }//this is to check if you have won the game or made it to the end of the path
          else
          {
            pathway.setText("<html>((((xooxoxooxooxxxxoxoxoxooxxoooxxoxoxoxoxoxoxoxoxoxoxooxooxooxooxooxoxox))))<br/>((((" + board.substring(0,position-1) + "|<html>");

            if(board.substring(position -1, position).equals("x"))
            {
              user.setHealth(enemies.get(enemy).updateHealth(user.getHealth(), enemies.get(enemy).getHealthEffect()));

              user.setHunger(user.getHunger()-10);

              horse.setHealth(enemies.get(enemy).updateHealth(horse.getHealth(), enemies.get(enemy).getHealthEffect()));

              horse.setHunger(horse.getHunger()-5);
              
              if(user.getHunger() <= 0)
              {
                user.setHunger(0);
              }
              if(horse.getHunger() <= 0)
              {
                horse.setHunger(0);
              }

              playerStats.setText("<html>Character Stats<br/>Health:<br/>" + user.getHealth() + "<br/>Hunger:<br/>" + user.getHunger() + "<br/><br/><br/><html>");

              animalStats.setText("<html>Animal Stats<br/>Health:<br/>" + horse.getHealth() + "<br/>Hunger:<br/>" + horse.getHunger() + "<br/><br/><br/>");


            }//to check if the player is on a X tile which means harm is meant to be dealt to them as well as the hunger effect
            else
            {
              user.setHunger(user.getHunger()-10);

              horse.setHunger(horse.getHunger()-5);

              playerStats.setText("<html>Character Stats<br/>Health:<br/>" + user.getHealth() + "<br/>Hunger:<br/>" + user.getHunger() + "<br/><br/><br/><html>");

              animalStats.setText("<html>Animal Stats<br/>Health:<br/>" + horse.getHealth() + "<br/>Hunger:<br/>" + horse.getHunger() + "<br/><br/><br/>");

            }//to go to the basic neutral platform of a O tile which will only do the normal hunger decrease
            playerInfo.setText("<html>Character Info<br/>Name:" + name + "<br/> Day:"+ user.getDaysTraveled()+"<br/>Status:Alive<br/>Journey: Incomplete<br/><br/><html>");
            
          }//end else for if the horse is still alive and user is on a "o tile"

        }//end else if the game is still continuing and the horse is still alive
        else
        {
          position += walking.getSpeed();
          user.setDaysTraveled(user.getDaysTraveled() + 1);

          if(position > board.length())
          {
            System.out.println("You won congrats");
            pathway.setText("<html>((((xooxoxooxooxxxxoxoxoxooxxoooxxoxoxoxoxoxoxoxoxoxoxooxooxooxooxooxoxox))))<br/>((((" + board+ "|<html>");

            playerInfo.setText("<html>Character Info<br/>Name:" + name + "<br/> Day:"+ user.getDaysTraveled() +"<br/>Status:Alive<br/>Journey: Complete<br/><br/><html>");
          }//this is to check if you have won the game or made it to the end of the path
          else
          {
            pathway.setText("<html>((((xooxoxooxooxxxxoxoxoxooxxoooxxoxoxoxoxoxoxoxoxoxoxooxooxooxooxooxoxox))))<br/>((((" + board.substring(0,position-1) + "|<html>");

            if(board.substring(position -1, position).equals("x"))
            {
              user.setHealth(enemies.get(enemy).updateHealth(user.getHealth(), enemies.get(enemy).getHealthEffect()));

              user.setHunger(user.getHunger()-10);

              horse.setHunger(0);
              horse.setHealth(0);

              playerStats.setText("<html>Character Stats<br/>Health:<br/>" + user.getHealth() + "<br/>Hunger:<br/>" + user.getHunger() + "<br/><br/><br/><html>");

              animalStats.setText("<html>Animal Stats<br/>Health:<br/>" + horse.getHealth() + "<br/>Hunger:<br/>" + horse.getHunger() + "<br/><br/><br/>");


            }//to check if the player is on a X tile which means harm is meant to be dealt to them as well as the hunger effect
            else
            {
              user.setHunger(user.getHunger()-10);

              horse.setHunger(0);
              horse.setHealth(0);

              playerStats.setText("<html>Character Stats<br/>Health:<br/>" + user.getHealth() + "<br/>Hunger:<br/>" + user.getHunger() + "<br/><br/><br/><html>");

              animalStats.setText("<html>Animal Stats<br/>Health:<br/>" + horse.getHealth() + "<br/>Hunger:<br/>" + horse.getHunger() + "<br/><br/><br/>");

            }//to go to the basic neutral platform of a O tile which will only do the normal hunger decrease

            playerInfo.setText("<html>Character Info<br/>Name:" + name + "<br/> Day:"+ user.getDaysTraveled()+"<br/>Status:Alive<br/>Journey: Incomplete<br/><br/><html>"); 

          }//end if character is on an O tile and horse is dead

        }//this is if the horse is dead and your new transportation is the basic walking and game is still continuing
         
        if(user.getHealth() >= 75)
        {
          greenLabelPic.setIcon(greenImage);
        }//checks if status of character is in the green area
        else if(user.getHealth() >= 50)
        {
          greenLabelPic.setIcon(yellowImage);
        }//checks if status of character is in the yellow area
        else
        {
          greenLabelPic.setIcon(redImage);
        }//checks if status of character is in the red area
      }//end of actioned performed
      
    });//this will be the button to move the "character" across the board and check on the status of the character

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