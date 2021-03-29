

public class Player{

  private char counter;
  private String name;
  private String type;
  private String colour;

  public Player(char counter, String name, String type, String colour){
    this.counter = counter;
    this.name = name;
    this.type = type;
    this.colour = colour;
  }

  public String getColour(){
    return colour;
  }

  public char getCounter(){
    return counter;
  }

  public String getName(){
    return name;
  }

  public String getType(){
    return type;
  }
}