

public class Board{

  private char [][] board;
  private boolean win;
  private Move m;


  public Board() {
   board = new char [6][7];
    win = false;
    m = new Move();

  }

  public char [][] getBoard(){
    return board;
  }

  public void resetBoard(){
    board = new char [6][7];
  }

  //Method places player counter
  public void placeCounter(Player player, int col){
    boolean placed = false;
    while(!placed){
      try {
        int emptyRow = isEmptyRow(col);
        board[emptyRow][col] = player.getCounter();
        SystemMessages.counterPlaced(player.getName());
        placed = true;
      }
      //If player selects a valid column, but all rows are full; the error is caught
      catch (ArrayIndexOutOfBoundsException e){
        int newMove;
        if (player.getType().equals("Computer")){// a new move is automatically generated for computer players
          newMove = m.randMove();
          placeCounter(player, newMove-1);
          break;
        }
        else if (player.getType().equals("Human")){//human players are asked to type in another position
          SystemMessages.columnFull(col+1);
          newMove = m.getPlayerMove();
          placeCounter(player, newMove-1);
          break;
        }
      }
    }
  }
  
  // Helper method finds the first empty row (from the bottom) and returns this value
  private int isEmptyRow (int col){
   int row;
   for (row = board.length-1; row>=0; row--){
      if (board[row][col] != 0){
        continue;
      }
      else{
        break;
      } 
    }
    if (row < 0){
      return -1;
    }
    return row;
  } 

  //Method checks whether board is full.
  public boolean isFull(){
    boolean full = true;
    for (int row =0; row<board.length; row++){
      for (int col =0; col<board[row].length; col++){
        if (board [row][col] == 0){
          full = false;
        }
      } 
    }
    return full;
  }

  //Method analyses and interprets contents of 2d array, and converts into a string  
  public String getPrintableBoard(Player p1, Player p2, Player p3){
    String printableBoard = "\n";
    for (int row =0; row<board.length; row++){
      for (int col =0; col<board[row].length; col++){
        
        if (board [row][col] == p1.getCounter()) {
          printableBoard+= ("| " + Colours.RED + p1.getCounter() +" " + Colours.RESET);
        }
        else if(board[row][col] == p2.getCounter()){
					printableBoard += ("| "+ Colours.YELLOW + p2.getCounter() +" " + Colours.RESET);
				}
        else if(board[row][col] == p3.getCounter()){
					printableBoard += ("| "+ Colours.BLUE + p3.getCounter() +" " + Colours.RESET);
				}
        else{
					printableBoard += ("|   ");
				}
      }
      printableBoard += ("|" + "\n");
    }
    //Prints column numbers
    printableBoard += ("  1   2   3   4   5   6   7" + "\n");
    return printableBoard;
  }

}