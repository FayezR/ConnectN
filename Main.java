class Main {
  private static int winCondition;
  public static void main(String[] args) {
   
   if (args.length == 0){
     winCondition = 4;
     SystemMessages.errorMessage("noArgument");
    }
   else {
     try{
        int i = Integer.parseInt(args[0]);  
        if (i>=2 && i<=7) {
          winCondition = i;
        }
        else {
          SystemMessages.errorMessage("invalidArgument");
          winCondition = 4;
        }
      }
      catch (NumberFormatException e){
        SystemMessages.errorMessage("non-integerArgument");
        winCondition = 4;
      }
    }
   new GameLogic();
    
  }
  
  public static int getWinCondition(){
    return winCondition;
  }
}

