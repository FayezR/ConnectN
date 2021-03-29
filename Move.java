import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Move{

  private static BufferedReader input;
  private Random random;

  public Move(){
    input = new BufferedReader(new InputStreamReader(System.in));
    random = new Random();
  }

  //Method generates random values from 0-7. These values will be the computer-player moves.
  public int randMove(){
    int upperBound = 7;
    int randomMove = random.nextInt(upperBound);
    return randomMove;
  }

  //Method reads console for user input and checks for erroneous input
  public  int getPlayerMove(){
    boolean validMove = false;
    while (!validMove){
      try{
        int move = Integer.parseInt(getUserInput());
        if (move >=1 && move <= 7){ //checks if a user's move is out of range of Array
          validMove = true;
          return move;
        }
        else {
          SystemMessages.errorMessage("invalidMove");
        }
      }
      catch (NumberFormatException e){
        SystemMessages.errorMessage("invalidMove");
      }
    }
    return 0;
  }
  
  //Method gains input from console
  public String getUserInput(){
    String toReturn = null;
    try{
      toReturn = input.readLine();
      return toReturn;
    }
    catch (Exception e){
      System.out.println("Oops, something's gone wrong. Try typing in your move again.");
    }
    return toReturn;
  }


}