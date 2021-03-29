public class WinLogic{
  private boolean win;
  final private int winCondition;
  private String winner;
  
  public WinLogic(){
    win = false;
    winCondition = Main.getWinCondition();
    winner = "";
  }

  public boolean hasWon(){
    return win;
  }
  
  public void resetWin(){
    win = false;
  }

  public String getWinner(){
    return winner;
  }

  public void resetWinner(){
    winner = "";
  }

  //Method calls upon 4 other methods to check for a win
  public void checkWin(char board[][], Player player){
    char counter = player.getCounter();
    if(checkHorizontal(board, counter) || checkVertical(board, counter) || checkRLDiagonal(board, counter)|| checkLRDiagonal(board, counter)){
      win = true;
      winner = player.getName();
    } 
  }

  //Method checks for a horizontal win
  private boolean checkHorizontal (char board [][], char counter){
    int count = 0;
    boolean isWin = false;
		for(int row=0; row<board.length; row++){
      count = 0;
			for(int col=0; col<board[row].length; col++){
				if(board[row][col] == counter){
					count++;
					if(count >= winCondition){
						isWin= true; 
            break;
					}
				}
				else{
				  count = 0;
				}
			}
		}
    return isWin;
  }

  //Method checks for a vertical win
  private boolean checkVertical (char board [][], char counter){
    int count = 0;
    boolean isWin = false;
		for(int row=0; row<board[0].length; row++){
      count =0;
			for(int col=0; col<board.length; col++){
				if(board[col][row] == counter){
					count++;
					if(count >= winCondition){
						isWin = true;
            break;
					}
				}
				else{
					count = 0;
				}
			}
		}
    return isWin;
  }
  

  //Method checks for upwards diagonal win, from left to right.
  private boolean checkLRDiagonal (char board [][], char counter){
    boolean isWin = false;
    int rowMax = board.length;
    int colMax = board[0].length;
    int count = 0;
    int row, col;
    for (row = 0; row< rowMax; row++){
      for (col = 0; col<= colMax; col++){
        int num;
        count = 0;
        for (num = 0; num <= winCondition-1; num++){//win condition specifies number of array elements to check for counter in diagonal
          try{
            if(board[row-num][col+num] == counter){//Checks for diagonal from position [board][row] and checks upper right diagonal element 
              count++;
              if (count >= winCondition) isWin = true;
            }
            else count = 0;
          }
          catch (ArrayIndexOutOfBoundsException e) { 
            num++;
            count = 0;
          }
        }
      }
    }
    return isWin;
  }

  //Method checks for upwards diagonal win, from right to left.
  private boolean checkRLDiagonal (char board [][], char counter){
    boolean isWin = false;
    int rowMax = board.length;
    int colMax = board[0].length;
    int count = 0;
    int row;
    int col;

    for (row = 0; row< rowMax; row++){
      for (col = 0; col<= colMax; col++){
        int num;
        count = 0;
        for (num = 0; num <= winCondition-1; num++){
          try{
            if(board[row-num][col-num] == counter){
              count++;
              if (count >= winCondition) isWin = true;
            }
            else count = 0;
          }
          catch (ArrayIndexOutOfBoundsException e) {
            num++;
            count = 0;
          }
        }
      }
    }
    return isWin;
  }
}
  
 