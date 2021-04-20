public class Harm extends Stats
{
  //Variables
  private int healthEffect;
  private int speedEffect;
  private String name;

  //Constructors
  public Harm(int health, int hunger, int speed, int daysTraveled, int healthEffect, int speedEffect, String name)
  {
    super(health, hunger, speed, daysTraveled);
    this.healthEffect = healthEffect;
    this.speedEffect = speedEffect;
    this.name = name;
  }//end full args constructor for Harm

  //getters and setters
  public int getHealthEffect()
  {
    return healthEffect;
  }

  public int getSpeedEffect()
  {
    return speedEffect;
  }

  public String getName()
  {
    return name;
  }

  public void setHealthEffect(int healthEffect)
  {
    this.healthEffect = healthEffect;
  }

  public void setSpeedEffect(int speedEffect)
  {
    this.speedEffect = speedEffect;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  //brain methods
  public int updateHealth(int originalHealth, int substractedHealth)
  {
    if(originalHealth - substractedHealth < 0)
    {
      return 0;
    }
    return originalHealth - substractedHealth;
  }//end brain method to update the health when encountering harm objects

  public int updateSpeed(int originalSpeed, int substractedSpeed)
  {
    if(originalSpeed - substractedSpeed < 0)
    {
      return 0;
    }
    return originalSpeed - substractedSpeed;
  }//end brain method to update speed when encountering harm objects

}//end Harm Class