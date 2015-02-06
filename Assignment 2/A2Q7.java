import java.util.Scanner;

public class A2Q7{
  public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Choose a game mode: ");
    System.out.println("1. Easy game \n2. Difficult game \n3. Very Difficult game");
    int choice = keyboard.nextInt();
    int chances=0;
    if(choice == 1){
      chances = 20 + (int)(Math.random()*((10)+1));
    }
    if(choice == 2){
      chances = 10 +(int)(Math.random()*((5)+1));
    }
    if(choice == 3){
      chances = 1 + (int)(Math.random()*((4)+1));
    }else{
      System.out.println("Invalid choice.");
    }
    int random = 1 + (int)(Math.random()*((99)+1));
    guess(chances, random);    
  }
  
  static void guess(int x, int random){
    int i=0;
    boolean a = false;
    System.out.println("You have "+x+" guesses. Now try guessing the number.");
    Scanner keyboard2 = new Scanner(System.in);
    while(i < x){
      int guess = keyboard2.nextInt();
      if(guess<random){
        System.out.println("guess < number.");
        i++;
      }
      if(guess>random){
        System.out.println("guess > number.");
        i++;
      }
      if(guess == random){
        System.out.println("You win in "+i+" guesses - the secret number is "+random);
        i=x;
        a = true;
      }
    }if(a != true){
    System.out.println("GAME OVER - the secret number is "+random);
    }
  }
  
}