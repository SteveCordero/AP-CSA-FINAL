public class Speed extends Stats
{
  //Instance Variables
  private String transport;
  private int hungerEffect;
  

  //Constructor
  public Speed(int health, int hunger, int speed, int daysTraveled, String transport, int hungerEffect)
  {
    super(health, hunger, speed, daysTraveled);
    this.transport = transport;
    this.hungerEffect = hungerEffect;
  }//end full args Constructor

  //getters and setter
  public String getTransport()
  {
    return transport;
  }

  public int getHungerEffect()
  {
    return hungerEffect;
  }

  public void setTransport(String transport)
  {
    this.transport = transport;
  }

  public void setHungerEffect(int hungerEffect)
  {
    this.hungerEffect = hungerEffect;
  }

  //Brain methods

  public int updateHunger(int originalHunger, int substractHunger)
  {
    if(originalHunger - substractHunger < 0)
    {
      return 0;
    }
    return originalHunger - substractHunger;
  }//end updateHunger method to update the Hunger everytime the player moves

}//end speed class