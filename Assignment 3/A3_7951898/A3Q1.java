// SETHI, AAKASH
// STUDENT NO.: 7951898
// COURSE: ITI 1120
// ASSIGNMENT #3

import java.util.Scanner;

public class A3Q1{
 public static void main(String[] args){
  Scanner input = new Scanner(System.in);
  System.out.println("How many numbers do you want a median of?");
  int n = input.nextInt();
  int a[] = new int[n];
  System.out.println("Enter "+n+" numbers");
  for(int counter=0; counter<a.length; counter++){
   a[counter] = input.nextInt();
  }
  
  int[] x = median(a);
  System.out.println("The sorted list of the entered numbers is: ");
  for(int k: x){
   System.out.print(k+"\t");
  }
}
  
  public static int[] median(int b[]){
  
  for(int i=0; i<b.length; i++){
   for(int j=0; j<b.length; j++){
    if(b[j]>=b[i]){
     int temp;
     temp = b[i];
     b[i] = b[j];
     b[j] = temp;
    }
   }
  }
  System.out.println("\n");
  int y = 0;
  if((b.length)%2 == 1){
    y = b[(b.length-1)/2];
  }else{
   y = b[(b.length-2)/2];
  }
  System.out.println("The median of the numbers is: "+y);
  return b;
 }
}