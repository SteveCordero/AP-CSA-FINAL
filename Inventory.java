import java.util.ArrayList;

public class Inventory
{
  //variables
  private int food;
  private int animalFood;

  //constructor
  public Inventory(int food, int animalFood)
  {
    this.food = food;
    this.animalFood = animalFood;
  }

  //getters and setters
  public int getFood()
  {
    return food;
  }

  public int getAnimalFood()
  {
    return animalFood;
  }

  public void setFood(int food)
  {
    this.food = food;
  }

  public void setAnimalFood(int animalFood)
  {
    this.animalFood = animalFood;
  }


  //Brain method
  public void updateInventory(ArrayList<Hunger> backpack, Hunger food)
  {
    backpack.remove(food);
  }

  public void fillInventory(ArrayList<Hunger> backpack, Hunger food)
  {
    for(int i = 0; i < 10; i++)
    {
        backpack.add(food);
    }
  }
  //toString
  public String toString()
  {
    return "You currently have " + food +  " human food items and " +  animalFood + " animal food items left";
  }
  
}//end class Inventory