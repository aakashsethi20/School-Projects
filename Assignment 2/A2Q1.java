import java.util.Scanner;

public class A2Q1{
  public static void main(String args[]){
    System.out.println("Enter lengths of a triangle");
    Scanner keyboard = new Scanner(System.in);
    int x, y, z;
    x = keyboard.nextInt();
    y = keyboard.nextInt();
    z = keyboard.nextInt();
    boolean a = isTriangle(x, y, z);
    if(a == true){
      System.out.println("The triangle is possible with these dimensions.");
    }else{
      System.out.println("The triangle is not possible with these lengths.");
    }
  }
  public static boolean isTriangle(int x, int y, int z){
    boolean a = (x+y>z  &&  x+z>y && y+z>x);
    return a;
  }
}