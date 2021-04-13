public class ]Stats
{
  //Instance Variables
  private int health;
  private int hunger;
  private int speed;
  private int daysTraveled;

  //Constructors
  public Stats(int health, int hunger, int speed, int daysTraveled)
  {
    this.health = health;
    this.hunger = hunger;
    this.speed = speed;
    this.daysTraveled = daysTraveled;
  }//end full args constructor

  //getters and setters
  public int getHealth()
  {
    return health;
  }

  public int getHunger()
  {
    return hunger;
  }

  public int getSpeed()
  {
    return speed;
  }

  public int getDaysTraveled()
  {
    return daysTraveled;
  }

  public void setHealth(int health)
  {
    this.health = health;
  }

  public void setHunger(int hunger)
  {
    this.hunger = hunger;
  }

  public void setSpeed(int speed)
  {
    this.speed = speed;
  }

  public void setDaysTraveled(int daysTraveled)
  {
    this.daysTraveled = daysTraveled;
  }

  //toString
  public String toString()
  {
    return "Congratulations!!! you have made it to the end";
  }//end toString or the ending message for the game

}//end Character Class