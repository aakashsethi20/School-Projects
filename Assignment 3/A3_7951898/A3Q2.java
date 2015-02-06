// SETHI, AAKASH
// STUDENT NO.: 7951898
// COURSE: ITI 1120
// ASSIGNMENT #3

import java.util.Scanner;

public class A3Q2 {
  public static void main(String[] args) { 
    
    // part (a) of the main
    
    Scanner keyboard = new Scanner(System.in); 
    
    System.out.println("***************************");
    System.out.println("        Part (a)");
    System.out.println("***************************");
    
    do{
      System.out.println("Enter a word and then press enter:");
      String str=keyboard.next();
      char[] word = str.toCharArray();
      
      isSquareFree(word);
      System.out.println("Do you want to test another word? Press y for yes, or another key for no");
      
    }while(keyboard.next().charAt(0)=='y');
    
    // part (b) of the main
    
    System.out.println();
    System.out.println("***************************");
    System.out.println("        Part (b)");
    System.out.println("***************************");
    
    System.out.println("How long a square free word on letters a, b and c do you want?");
    System.out.println("Enter an integer greater than zero");
    int word_length=keyboard.nextInt();
    
    char[] square_free_word = makeSquareFree(word_length);
    
    System.out.println("Here is a square-free word of length "+ word_length);
    for(int i=0; i<word_length; i++){
      System.out.print(square_free_word[i]);
    }
    System.out.println();
    
    
    /* by uncommenting the method call below, you can call isSquareFree with your created word 
     to verify that indeed it is square free */
    
    isSquareFree(square_free_word);
    
    /* uncomment the method call below if you want to test if you solution 
     for part b is correct for n=1000. To use it, type in 1000 for the length when prompted by the program, 
     the method below will tell you if the word you created is indeed a correct word of length 1000 as per Thue procedure. */
    
    test(square_free_word);
  }
  
  public static void isSquareFree(char[] word){
    // YOUR CODE FOR PART (a) GOES HERE:
    boolean squarefree=false;
    int steps = 0;
    int i = 0;
    int k = 0;
    
    while(i<word.length){
      int j = i+1;
      while(j<word.length){
        if (word[i] == word[j] & steps==0){ 
          {
            squarefree=true; 
          }
        }
        if (steps!=0 & (word[i] == word[j])){
          while(k<steps+1){
            if(j+k<word.length & i+k<word.length){
              if(word[j+k] == word[i+k]){
                squarefree = true;
              }else{
                squarefree = false;
              }
            }
            else{
              squarefree = false;
            }
            k++;
          }
          k=0;
        }
        j++; 
        steps++;
      }
      if (squarefree == true){
        break;
      }else{
        steps = 0;
        j = 0;
        i++;
      }
    }
    if(squarefree == true){
      String w = new String(word);
      System.out.println("The word, "+w+", is not square free since it has a subword twice starting at position "+(i+1));
    }else{
      System.out.println("The word is square free");
    }
  }
  
  // a method the produces a square free word of length n based on Thue's construction 
  public static char[] makeSquareFree(int n){
    
    char[] sfword = new char[n];
    sfword[0] = 'a';
    int position = 0;
    
    for(int i =0; i<n; i++){
      char[] sub = new char[n];
      position = 0;
      for(int x=0; x<=i; x++){
        if(sfword[x] == 'a'){
          char[]a = {'a','b','c','a','b'};        
          for(int y=0; y<a.length && position+y<n; y++){                 
            sub[position+y] = a[y];
          }
          position+=a.length;
        }
        else if(sfword[x] == 'b'){
          char[]a = {'a','c','a','b','c','b'};
          for(int y=0; y<a.length && position+y<n; y++){
            sub[position+y] = a[y];
          }
          position+=a.length;
        }
        else if(sfword[x] == 'c'){
          char[]a = {'a','c','b','c','a','c','b'}; 
          for(int y=0; y<a.length && position+y<n; y++){ 
            sub[position+y] = a[y];            
          }
          position+=a.length;
        }
      }  
      for(int x=0; x<n; x++){
        sfword[x] = sub[x];
      }
    }
    return sfword;
  }
  
  // a method that tests if a given word of length 1000, is a square-free produced as per Thue's construction 
  public static void test (char[] your_sfword){
    
    if(your_sfword.length != 1000){
      System.out.println("This method only tests if part (b) correctly generates a word of length 1000."+
                         "\n Enter 1000 the next time if you want to use this method");
      return;
    }
    
    String s1 = new String(your_sfword);
    String s2 ="abcabacabcbacbcacbabcabacabcbabcabacbcacbabcabacabcbacbcacbacabcbabcabacbcacbacabcbacbcacbabcabacbcacbacabcbabcabacabcbacbcacbabcabacabcbabcabacbcacbabcabacabcbacbcacbacabcbabcabacabcbacbcacbabcabacabcbabcabacbcacbacabcbacbcacbabcabacbcacbacabcbabcabacabcbacbcacbabcabacabcbabcabacbcacbabcabacabcbacbcacbacabcbabcabacbcacbacabcbacbcacbabcabacbcacbacabcbabcabacbcacbabcabacabcbacbcacbacabcbabcabacabcbacbcacbabcabacabcbabcabacbcacbacabcbacbcacbabcabacbcacbacabcbabcabacbcacbabcabacabcbacbcacbacabcbabcabacbcacbacabcbacbcacbabcabacbcacbacabcbabcabacabcbacbcacbabcabacabcbabcabacbcacbacabcbacbcacbabcabacbcacbacabcbabcabacbcacbabcabacabcbacbcacbacabcbabcabacabcbacbcacbabcabacabcbabcabacbcacbabcabacabcbacbcacbacabcbabcabacbcacbacabcbacbcacbabcabacbcacbacabcbabcabacabcbacbcacbabcabacabcbabcabacbcacbabcabacabcbacbcacbacabcbabcabacabcbacbcacbabcabacabcbabcabacbcacbacabcbacbcacbabcabacbcacbacabcbabcabacabcbacbcacbabcabacabcbabcabacbcacbabcabacabcbacbcacbacabcbabcabacbcacbacabcbacbcacbabcabacbcacbacabc";
    if(s1.equals(s2)){
      System.out.println("Your Thue-procedure-based square-free word of length 1000 is correct.");
    }
    else {
      System.out.println("Your Thue-procedure-based square-free word of length 1000 is not correct.");
    }
    
  }
  
}

