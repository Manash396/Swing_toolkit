// Midpoint circle algorithm to draw a circle in na grid of pixel 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Draw_circle{
   private int r ;
  private  int screen[][] ;
   int x = 0;
   int y ;
   int p ; // decision parameter
   List<List<Integer>> points = new ArrayList<>() ;
   public Draw_circle(){
   Scanner sc = new Scanner(System.in);
    r = sc.nextInt();
    screen = new int[2*r+1][2*r+1];
    y = r;
    // this formula derived from f(x,y) = x^2 + y^2 - r^2 circle equation p<0 means circumference of the circle is more closer to east point otherwise it is closer to the southeast point .. since we have only two option east and south east for selectibg next pixel from current pixel 
    p = 1 - r;
    // now call the method that are going to calculate all the points of 1/8 of the circle (octant)
     cal();
   } 
  
   public void cal(){
      List<Integer> point ;
      while(x<=y){
         point = new ArrayList<>();
         point.add(x);
         point.add(y);
         if(p<0){
            p+=2*x+3; // east beacuse the mid point is indeide the circumference 
         }else{
            p+=2*(x-y)+5;
            y--; // to move in south east definitely we have to decrement y 
         }
         points.add(point);
         x++;
      }
     
      setScreen();
   }
   // a function that will find out all the other seven mirror point ans add it in Matrix as screen of pixels
   public void setScreen(){
      System.out.println("List of points of one ocatant :"+points);
      // select one ans start 
      List<Integer> point ;
      int i = 0;
      while(i<points.size()){
         point  = points.get(i);
         int x= point.get(0);
         int y= point.get(1);
         screen[x+r][y+r] = 1; // filled with color 
         screen[y+r][x+r] = 1; 

         screen[(-1*y)+r][x+r] = 1; 
         screen[(-1*x)+r][y+r] = 1; 
   
         screen[ y+r ][(-1*x)+r] = 1; 
         screen[ x+r ][(-1*y)+r] = 1; 

         screen[(-1*y)+r][(-1*x)+r] = 1; 
         screen[(-1*x)+r][(-1*y)+r] = 1; 
         
         i++; // for every point there will be seven more through reflection 
      }
     
   }

   public int[][] give(){
        return screen;
   }

 public static void main(String[] args) {
     while(true){
    System.out.print("Enter the radius to draw the circle in matrix as screen of pixels with axes 0 ----- n\n enter : ");
     Draw_circle obj = new Draw_circle();
     int screen[][] = obj.give(); 
   //    now i am going to use the time in java for showing the slide slow 
   try {
        for(int i = 0;i<screen.length;i++){
            for(int j = 0;j< screen.length;j++){
               if(screen[i][j] == 0){
                  System.out.print("   ");
                  Thread.sleep(2);
               }else{
                  System.out.print("  ~");
                  Thread.sleep(2);

               }
            }
            System.out.println();
        }
   } catch (Exception e) {
      e.printStackTrace();
   }
}
 }
       

}


