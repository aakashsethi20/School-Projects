// SETHI, AAKASH: 
// Student number: 7951898
// Course: IT1 1120 
// Assignment Number 4

import java.util.Scanner;
import java.io.IOException;

public class a4{
  
  // main method. DO NOT MODIFY
  public static void main(String args[]) {
    Scanner keyboard = new Scanner( System.in );
    
    System.out.println("Welcome to Memory Game");
    
    int board_side;
    
    //this loop obtains the board size, or more specifically 
    // the length of the side of the board
    do{
      System.out.println("\n For 2x2 board game press 2"+
                         "\n For 4x4 board game press 4"+
                         "\n For 6x6 board game press 6");
      board_side=keyboard.nextInt();
    }while(board_side!=2 && board_side!=4 && board_side!=6);
    
    char[][] board = createBoard(board_side);
    
    // a call the the shuffle method
    shuffleBoard(board);
    
    // a call to the game playing method
    playGame(board);
    
  }
  
  
  
  
  // The following method should shuffle the input 2D array caled board 
  public static void shuffleBoard(char[][] board)
  {
    // This creates a 1D array whose size is equal to the size of the board   
    int N = board.length*board.length;
    char[] board1D = new char[N];
    
    // Copy the elements of 2D array into that 1D array here
    int s=0;
    for(int i=0; i<board.length; i++){
      for(int j=0; j<board[i].length; j++){
        board1D[s] = board[i][j];
        s++;
      }
    }
    
    // Shuffle 1D array here 
    int index;
    char temp;
    for(int count=0; count<board1D.length; count++){
      index = (int) (Math.random()*board1D.length);
      temp = board1D[count];
      board1D[count] = board1D[index];
      board1D[index] = temp;
    }
    
    
    
    //Copy shuffled 1D array back into 2D array, i.e., back to the board
    int x = 0;
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board.length; c++){
        board[r][c] = board1D[x];
        x++;
      }
    }
    
    
  }
  
  
  // a game playing method
  public static void playGame(char[][] board)
  {
    Scanner keyboard = new Scanner( System.in );
    
    // this createst a 2D array indicating what locations are paired, i.e., discovered
    // at the begining none are, so default initializaiton to false is ok 
    boolean[][]discovered=new boolean[board.length][board[0].length];
    
    
    // the code for your game playing goes here
    print(board, discovered);
    boolean all;
    boolean first;
    boolean second;
    do{
      System.out.println("Enter a pair of undiscovered distinct locations on the board that"+
                         " you want revealed. \n i.e., a pair of intergers"+
                         " in the range ["+1+", "+board.length+"]");
      int r1, r2, c1, c2;
      r1=r2=c1=c2 = 0;
      first = second = false;
      while(!first){
        System.out.println("Enter the first location");
        r1 = keyboard.nextInt();
        c1 = keyboard.nextInt();
        first = true;
        if(((r1<1 || r1>board.length) && (c1<1 || c1>board.length)) || discovered[r1-1][c1-1]){
          System.out.println("Invalid choice, try again");
          first = false;
        }
      }
      while(!second){
        System.out.println("Enter the second location");
        r2 = keyboard.nextInt();
        c2 = keyboard.nextInt();
        second = true;
        if(((r2<1 || r2>board.length) && (c2<1 || c2>board.length)) || (discovered[r2-1][c2-1]) || (r2==r1 && c2==c1)){
          System.out.println("Invalid choice, try again");
          second = false;
        }
      }
      choices(board, discovered, r1, c1, r2, c2);
      set(board, discovered, r1, c1, r2, c2);
      waitForPlayer();
      all = true;
      for(int r=0; r<board.length; r++){
        for(int c=0; c<board.length; c++){
          if(discovered[r][c] == false){
            all = false;
            break;
          }
          if(all == false){
            break;
          }
        }
      }
      System.out.println();
      print(board, discovered);
    }while(all == false);
    System.out.println("Congratulations! You've completed the game");
    
  }
  
  
  // createBoard method. DO NOT MODIFY!
  /* this method, createBoard, creates the board filled with letters of alphabet, 
   where each letter appears exactly 2 times
   e.g., for 4 x 4, the returned board would look like:
   A B C D 
   E F G H
   A B C D 
   E F G H */    
  public static char[][] createBoard(int side) 
  {
    char[][] tmp = new char[side][side];
    int letter_count=0;
    for (int row = 0; row < tmp.length/2; row++){
      for(int col = 0; col < tmp[row].length; col++)
      {
        tmp[row][col]=(char)('A'+letter_count);
        tmp[row+tmp.length/2 ][col]=tmp[row][col];
        letter_count++;
      }
    }
    return tmp;
  }
  
  
  // waitForPlayer method. Do not modify! 
  public static void waitForPlayer()
  {
    System.out.print("Press enter to continue");
    try {
      System.in.read();
    }
    catch (IOException e){
      System.out.println("Error reading from user");
    }
  }
  
  
  // to print the current board
  public static void print(char[][] board, boolean[][] discovered){
    for(int counter=0; counter<30; counter++){
      System.out.println();
    }
    for(int r=0; r<board.length; r++){
      System.out.print(r+1);
      for(int c=0; c<board.length; c++){
        if(discovered[r][c] == false){
          System.out.print(" * ");
        }else{
          System.out.print(" "+board[r][c]+" ");
        }
      }
      System.out.println();
    }
    for(int count=1; count<=board.length; count++){
      System.out.print("  "+count);
    }
    System.out.println();
  }
  
  // to print the board with the input choices
  public static void choices(char[][] board, boolean[][] discovered, int r1, int c1, int r2, int c2){
    discovered[r1-1][c1-1] = true;
    discovered[r2-1][c2-1] = true;
    for(int r=0; r<board.length; r++){
      System.out.print(r+1);
      for(int c=0; c<board.length; c++){
        if(discovered[r][c] == true){
          System.out.print(" "+board[r][c]+" ");
        }else{
          System.out.print(" * ");
        }
      }
      System.out.println();
    }
    for(int count=1; count<=board.length; count++){
      System.out.print("  "+count);
    }
    System.out.println();
    discovered[r1-1][c1-1] = false;
    discovered[r2-1][c2-1] = false;
  }
  
  // to set the discovered places
  public static boolean[][] set(char[][] board, boolean[][] discovered, int r1, int c1, int r2, int c2){
    if(board[r1-1][c1-1] == board[r2-1][c2-1]){
      discovered[r1-1][c1-1] = true;
      discovered[r2-1][c2-1] = true;
    }
    return discovered;
  }
}