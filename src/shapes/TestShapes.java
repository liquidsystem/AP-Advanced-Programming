/*
Program: TestTriangle
Now I want to check to see if my triangle class actually works.
Remember, in order for it to work properly the Point interface
has to be set up correctly as does the AbstractShape class which
uses that Point interface!  wow.  fingers crossed
*/
import java.awt.*;
import javax.swing.*;
import TurtleGraphics.*;

public class TestShapes 
{
  
    
    
    public static void main(String [] args)
    {
        
        Pen p1 = new StandardPen();
      
        double a;
        //AbstractShape r1 = new Rectangle(-40,-40,100,100);
        //AbstractShape t1 = new RTriangle(-20,-50,50,100);
        AbstractShape c1 = new Circle(100,0,0);
        AbstractShape c2 = new Circle(200,0,0);
        AbstractShape c3 = new Circle(150,0,0);
        c1.draw(p1);
        c2.draw(p1);
        c3.draw(p1);
        
        
        a = c1.area();
        System.out.println(c1);
    }
}

/*

1.  Look at the circle class from the last module.
   What has to be changed about it in order for it to
    work with the Point interface (and AbstractShape class)
    Make these changes and test it out in this test program.
    You should change the name of this test Program to 
    'TestShapes' or something 
    
2.  Create a Rectangle class like this RTriangle class
    then test it here as well.  

3.  See if you can draw a nice picture given these 3 shapes
    play around with the methods in the AbstractShape class!


*/