import java.util.Scanner;

public class A2Q3{
  public static void main(String args[]){
    System.out.println("Enter the model year of your car");
    Scanner keyboard = new Scanner(System.in);
    int model, year;
    model = keyboard.nextInt();
    System.out.println("Enter the current year.");
    year = keyboard.nextInt();
    
    boolean b = test_needed(model, year);
    if(b == true){
      System.out.println("An emission test is needed.");
    }else{
      System.out.println("The test is not needed.");
      }
  }
  
  static boolean test_needed(int x, int y){
    boolean a = ((x%2==0 && y%2==1) || (x%2==1 && y%2==0)) && (y-x>=3 && y-x<=20);
    
    return a;
  }
}