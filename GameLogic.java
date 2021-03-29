

public class GameLogic {
	
  private Board board;
  private Move m;
  private WinLogic winLogic;
  private Player p1;
  private Player p2;
  private Player p3;
  
	public GameLogic(){
		board = new Board();
    m = new Move();
    winLogic = new WinLogic();
    p1 = new Player('R', "Player 1", "Human", "RED");
    p2 = new Player('Y', "Player 2", "Computer", "YELLOW");
    p3 = new Player('B', "Player 3", "Computer", "BLUE");
		playGame();
	}
	
  //method contains code that calls upon methods in different classes to enact the functionality of the game
	private void playGame(){
    SystemMessages.printGameInformation();
    System.out.println(board.getPrintableBoard(p1, p2, p3));      
		
    while(!winLogic.hasWon() && !board.isFull()){
			// player 1
			int move = m.getPlayerMove();
			board.placeCounter(p1, move-1);
			winLogic.checkWin(board.getBoard(), p1);
      System.out.println(board.getPrintableBoard(p1, p2, p3));
      
      if (winLogic.hasWon()) break;
      
      //player 2
			board.placeCounter(p2, m.randMove()-1);
      winLogic.checkWin(board.getBoard(), p2);
      System.out.println(board.getPrintableBoard(p1, p2, p3));
      if (winLogic.hasWon()) break;
      
                
      //player 3
      board.placeCounter(p3, m.randMove()-1);
      winLogic.checkWin(board.getBoard(), p3);
      System.out.println(board.getPrintableBoard(p1, p2, p3));
      if (winLogic.hasWon()) break;

		}
    if(board.isFull()){
      SystemMessages.gameOver();
    }
    if(winLogic.hasWon()){
      SystemMessages.winMessage(winLogic.getWinner());
    }
    resetGame();
	}
 
 //Method resets game by resetting board, boolean win, and winner.
  private void resetGame(){
    SystemMessages.playAgain(); //User is told to type in 'yes' to play again and 'no' to exit
    String input = m.getUserInput(); 
    if (input.equals("Yes")){
      board.resetBoard();
      winLogic.resetWin();
      winLogic.resetWinner();
      playGame();
    }
    else if (input.equals("No")){
      SystemMessages.exitMessage();
      System.exit(0);
    }
    else{
      SystemMessages.errorMessage("invalidInput");
      resetGame();
    }
  }
}

