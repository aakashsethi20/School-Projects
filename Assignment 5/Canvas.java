public class Canvas{
  private int numRectangles = 0;
  private Rectangle rectangles[];
  
  public Canvas(int size){
    rectangles = new Rectangle[size];
  }
  
  public void add(Rectangle aRectangle){
    if(numRectangles < rectangles.length){
      rectangles[numRectangles] = aRectangle;
      numRectangles++;
    }else{
      System.out.println("The canvas is full. Unable to add a new rectangle.");
    }
  }
  
  public int getNumRectangles(){
    return numRectangles;
  }
  
  public void printAll(){
    for(int counter=0; counter<rectangles.length; counter++){
      System.out.println("Info of rectangle number "+(counter+1));
      rectangles[counter].print();
    }
  }
  
  public int countRectanglesForColour(String colour){
    int count = 0;
    for(int counter=0; counter<rectangles.length; counter++){
      if(rectangles[counter].getColour() == colour){
        count++;
      }
    }
    return count;
  }
  
  public int totalPerimeter(){
    int total = 0;
    for(int i=0; i<rectangles.length; i++){
      total = total + rectangles[i].getPerimeter();
    }
    return total;
  }
  
  public static boolean intersect2(Rectangle r1, Rectangle r2)
    {  // If one rectangle is on left side of the other
      if (r1.getX2() < r2.getX1() || r2.getX2() < r1.getX1()){
         return false;
      }
 
      // If one rectangle is above the other
      if (r1.getY2() < r2.getY1() || r2.getY2() < r1.getY1()){
         return false;
      }
 
      return true;
    }
  
  public boolean intersectAll(){
    boolean intersects = true;
    for(int i=0; i<numRectangles-1; i++){
      if(intersect2(rectangles[i], rectangles[i+1])){
        intersects = true;
      }else{
        intersects = false;
      }
    }
    return intersects;
  }
  
  private static int min(int[] a){
    int min = 1000000;
    for(int i=0; i<a.length; i++){
      if(min>a[i]){
        min = a[i];
      }
    }
    return min;
  }
  private static int max(int[] a){
    int max = -100000;
    for(int i=0; i<a.length; i++){
      if(max<a[i]){
        max = a[i];
      }
    }
    return max;
  }
  
  public Rectangle minEnclosingRectangle(){
    int[] axmin = new int[numRectangles];
    for(int i=0; i<axmin.length; i++){
      axmin[i] = rectangles[i].getX1();
    }
    int[] axmax = new int[numRectangles];
    for(int j=0; j<axmax.length; j++){
      axmax[j] = rectangles[j].getX2();
    }
    int[] aymin = new int[numRectangles];
    for(int k=0; k<aymin.length; k++){
      aymin[k] = rectangles[k].getY1();
    }
    int[] aymax = new int[numRectangles];
    for(int p=0; p<aymin.length; p++){
      aymax[p] = rectangles[p].getY2();
    }
    
    Rectangle r = new Rectangle(min(axmin), min(aymin), max(axmax), max (aymax), "blue");
    return r;
  }
}