

public class SystemMessages{

  public static void errorMessage(String error){
   if (error.equals("columnFull")){
      System.out.println("This column is full. Try placing your counter in another column.");
    }
    else if (error.equals("invalidMove")){
      System.out.println("This is an invalid move. Please try entering a number between 1 and 7.");
    }
    else if (error.equals("noArgument")){
      System.out.println("---------");
      System.out.print(Colours.RED_BGROUND + "You have not stated, in the command line, how much counters to connect in a row to win. ");
      System.out.println("This game will run as default connect 4." + Colours.RESET);
    }
    else if (error.equals("invalidArgument")){
      System.out.println("---------");
      System.out.println("You have typed in an argument in the command line which is out of range (2 < n > 7)");
      System.out.println("This game will run as default connect 4.");
    }
    else if (error.equals("non-integerArgument")){
      System.out.println("---------");
      System.out.println(Colours.RED_BGROUND +"You have typed in a non-integer argument in the command line.");
      System.out.println("This game will run as default connect 4." + Colours.RESET);
    }

    else if(error.equals("invalidInput")){
      System.out.println("Try that again. Please type in either 'Yes' to play again or 'No' to exit.");
    }
  }

  public static void printGameInformation (){
    System.out.println("----------");
		System.out.println("Welcome to Connect" + Main.getWinCondition() + " !");
		System.out.println("There are 3 players: red, yellow and blue.");
		System.out.println("You are player 1 and will play as Red. Player 2 is Yellow and player 3 is blue.");
    System.out.println("");
		System.out.println("To play the game, type in the number of the column you want to drop you counter in."); 
		System.out.println(Colours.BLACK + Colours.CYAN_BGROUND + "A player wins by connecting " + Main.getWinCondition() +  " counters in a row - vertically, horizontally or diagonally" + Colours.RESET);
		System.out.println("");
  }

  public static void columnFull(int column){
    System.out.println("Column " + column + " is full. Place your counter in another column.");
  }

  public static void counterPlaced (String playerName){
    if (playerName.equals("Player 1")){
      System.out.println("Great. Your counter has been placed!");
    }
    else{
      System.out.println( playerName + "'s counter has been placed.");
    }
  }
  
  public static void winMessage (String playerName) {
    if (playerName.equals("Player 1")){
      System.out.println(Colours.GREEN_BACKGROUND + Colours.BLACK + "Congratulations! You've won!" + Colours.RESET);
    }
    else{
      System.out.println( Colours.GREEN_BACKGROUND + Colours.BLACK + playerName + "has won the game!" + Colours.RESET);
    }
  }

  public static void gameOver(){
    System.out.println("Game over. Nobody's won!");
  } 

  public static void playAgain(){
     System.out.println("Do you want to play again? Type 'Yes' to play another game or type 'No' to exit the game" );

  }

  public static void exitMessage(){
    System.out.println(Colours.RED + "You have quit this game. Thank you for playing!" + Colours.RESET);
  }
}