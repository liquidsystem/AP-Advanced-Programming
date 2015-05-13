import TurtleGraphics.Pen;
/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle extends AbstractShape
{
    // instance variables - replace the example below with your own
    private double radius;

    /**
     * Constructor for objects of class Circle
     */
    public Circle()
    {
        // initialise instance variables
        
        radius = 0;
    }
    
    public Circle(double r) {
        super();
        radius = r;
    }
    
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
    
    public Circle(int r, int x, int y) {
        super(x,y);
        radius = r;
    }
    
    public void draw(Pen p) {
      double side = 2.0 * Math.PI * radius / 120.0;
      p.up();
      p.move(x + radius, y - side / 2.0); 
      p.setDirection(90); 
      p.down();
      for (int i = 0; i < 120; i++){
         p.move(side); 
         p.turn(3);
      }
    }
    
    public void StretchBy(int z) {
        radius = radius * z;
    }
}
