public class Hunger extends Stats
{
  //variables
  private int healthEffect;
  private int hungerEffect;

  //constructor
  public Hunger(int health, int hunger, int speed, int daysTraveled, int healthEffect, int hungerEffect)
  {
    super(helath, hungerm speed, daysTraveled);
    this.healthEffect = healthEffect;
    this.hungerEffect = hungerEffect;
  }//end full args constructor for hunger

  //getters and setters
  public int healthEffect()
  {
    return healthEffect;
  }

  public int hungerEffect()
  {
    return hungerEffect;
  }

  public void setHealthEffect(int healthEffect)
  {
    this.healthEffect = healthEffect;
  }
  
  public void setHungerEffect(int hungerEffect)
  {
    this.hungerEffect = hungerEffect;
  }

  //brain methods
  public int updateHunger(int originalHunger, int substractHunger)
  {
    if(originalHunger - substractHunger < 0)
    {
      return 0;
    }
    return originalHunger - substractHunger;
  }//end method to update hunger for player

  public int updateHealth(int originalHealth, int substractedHealth)
  {
    if(originalHealth - substractedHealth < 0)
    {
      return 0;
    }
    return originalHealth - substractedHealth;
  }//end method to update health 

}//end class hunger