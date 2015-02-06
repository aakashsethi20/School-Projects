import java.util.Scanner;

public class A2Q6{
  public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter the size of the tree");
    int size = keyboard.nextInt();
    draw_tree(size);
    
  }
  static void draw_tree(int n){
    for(int r=1; r<=n; r++){
      for(int i=1; i<=n-r; i++){
        System.out.print(" ");
      }
      for(int stars=1; stars<=2*r-1; stars++){
        System.out.print("*");
      }
      System.out.println("");
    }
    for(int j=0; j<2; j++){
      for(int k=1; k<=n-1; k++){
        System.out.print(" ");
      }
      System.out.println("*");
    }
  }
}