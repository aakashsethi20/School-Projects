import java.util.Scanner;

public class A2Q5{
  public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter the size of the rectangle.");
    int size = keyboard.nextInt();
    draw_rectangle(size);
  }
  static void draw_rectangle(int m){
    int i = 1;
    while(i <= m){
      System.out.print("*");
      i++;
    }
    System.out.print("\n" + "*");
    int j = 1;
    while(j <= m-2){
      System.out.print(" ");
      j++;
    }
    System.out.println("*");
    int k = 1;
    while(k <= m){
      System.out.print("*");
      k++;
    }
  }
}