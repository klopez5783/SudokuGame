package com.klopez1;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final int gridSize = 9;

    public static void main( String[] args )
    {
       

        int[][] board = {
            {7, 0, 2, 0, 5, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {1, 0, 0, 0, 0, 9, 5, 0, 0},
            {8, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 4, 3, 0, 0, 0, 7, 5, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 9, 7, 0, 0, 0, 0, 5},
            {0, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 7, 0, 4, 0, 2, 0, 3} 
          };
            
          System.out.println( solveBoard(board) ? "Solved!!" : "Not solveable" );
          
        //   printBoard(board);
        
    }


  private static boolean rowDup(int[][] board,int number, int row){
        for(int i = 0 ; i < gridSize ; i++ ){
            if(board[row][i] == number){
                return true;
            }
        }
        return false;
    }
  
   private static boolean colDup(int[][] board, int number, int col){
        for (int i = 0; i < gridSize; i++) {
      if (board[i][col] == number) {
        return true;
      }
    }
    return false;
    }
  
  

  private static boolean BoxDup(int[][] board,int number, int row, int col){
        int localBoxRow = row - row % 3;
        int localBoxColumn = col - col % 3;
        
        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
        for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
            if (board[i][j] == number) {
            return true;
            }
        }
        }
        return false;
    }

    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                if (board[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= gridSize; numberToTry++) {
                        if (ValidePlace(board, numberToTry, row, column)) {
                            board[row][column] = numberToTry;
                            
                            if (solveBoard(board)) {
                                return true;
                            }
                            else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
    return true;
    }



      
    private static boolean ValidePlace(int[][] board, int number , int row, int col){
        return !rowDup(board,number,row) &&
                !colDup(board,number,col) &&
                !BoxDup(board,number,row,col) ;
    }
    
  

    private static void printBoard(int[][] board) {
        for (int row = 0; row < gridSize; row++) {
          if (row % 3 == 0 && row != 0) {
            System.out.println("-----------");
          }
          for (int column = 0; column < gridSize; column++) {
            if (column % 3 == 0 && column != 0) {
              System.out.print("|");
            }
            System.out.print(board[row][column]);
          }
          System.out.println();
        }
      }
     

}
