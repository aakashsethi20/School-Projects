import java.util.Scanner;

public class A2Q4{
  public static void main(String args[]){
    System.out.println("Enter a positive integer");
    Scanner keyboard = new Scanner(System.in);
    int x = keyboard.nextInt();
    double sum = compute_series(x);
    System.out.println("The sum of the series is "+ sum);
  }
  
  static double compute_series(int n){
    int counter = 1;
    double total = 0;
    while(counter <= n){
      total = total + (1/Math.pow(counter,2));
      counter++;
    }
    return total;
  }
}