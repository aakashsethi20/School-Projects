import java.util.Scanner;

public class A2Q2{
  public static void main(String args[]){
    System.out.println("Enter a number to play Yo-Jo");
    Scanner keyboard = new Scanner(System.in);
    int x = keyboard.nextInt();
    
    boolean b = is_string(x);
    if(b == true){
      System.out.println("The number is not safe.");
    }else{
      System.out.println("The number is safe.");
    }
  }
  
  static boolean is_string(int y){
    int p = y/10;
    int q = y%10;
    
    boolean a = (p == 9 || q == 9 || (p+q)%9 == 0);
    return a;
  }
}