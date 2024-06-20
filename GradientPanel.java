import javax.swing.*;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.geom.Point2D;
import java.awt.Graphics;
import java.awt.Graphics2D;



public class GradientPanel extends JPanel {
    // colours for gradient making 
  Color c1 ;
  Color c2;
  // 2D points end and start 

  Point2D p1 ;
  Point2D p2 ;

   
  // constructor for initialising all the 

public GradientPanel(Point2D p1 , Point2D p2, Color c1, Color c2){
     this.p1 =p1;
     this.p2 = p2;
     this.c1=c1;
     this.c2=c2;
}

@Override
protected void paintComponent(Graphics g){
  // for calling the Jcomponent method 
    super.paintComponent(g);
    // type castin grapgics to Graphics2D

    Graphics2D g2d = (Graphics2D)g;

    GradientPaint paint = new GradientPaint(p2, c2, p1, c1);
    // set 
    g2d.setPaint(paint);
    // fill it 
    g2d.fillRect(0, 0, getWidth(), getHeight());


}



}
