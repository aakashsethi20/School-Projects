import java.util.Scanner;

public class A5Q1 {
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    System.out.println("Enter a number n:");
    int n = s.nextInt();
    int result = digitSum(n);
    System.out.println("The sum of the digits of the numbers is: "+ result);
    s.close();
    int sum = digitalRoot(n);
    System.out.println("Digital root is: "+sum);
  }
  
  public static int digitSum(int n){
    int temp = n%10;
    if(n>0){
      n = n/10;
      return temp + digitSum(n);
    }else{
      return 0;
    }
  }
  
  public static int digitalRoot(int n){
    n = digitSum(n);
    int temp = n%10;
    if(n>0){
      n/=10;
      return temp + digitalRoot(n);
    }else{
      return 0;
    }
  }
}
