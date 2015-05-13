
/**
 * Class: Rectangle
 * 
 * @author Lori Hunt 
 * @version 4/22/15
 * This class is going to extend the AbstractShape class
to handle rectangles.  It will be based on the location
of the point at the top left corner, given a height and base
length.
*/
import TurtleGraphics.Pen;
public class Rectangle extends AbstractShape
{
    // Since rectangles have a height and base, I will
    // include those as my instance variables.
    // I will inherit all of the stuff from point so I don't
    // need to include any of that.
    private double height, base;

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle()
    {
        super(); // I am inheriting the point class stuff!!
        height = -1;
        base = -1;
    }

     public Rectangle(int topLeftX, int topLeftY, double h, double b)
    {
        super(topLeftX, topLeftY); // I am inheriting the point class stuff!!
        height = h;
        base = b;
    }
    /**
     // Now I have to go over to the AbstractShape class and see
	// what needs to be defined for this class
     */
    /*
	 * returns the area of the Rectangle
	 */
	public double area()
	{
		return base*height;
		
	}
	// If I skip any of the methods that are listed in the AbstractShape
	// class, I will be in deep trouble :(
	
	public void StretchBy(int factor)
	{
		height *= factor;
		base *= factor; 
	}
    //and this method uses the draw method definition from the 
    // abstract class.
    	public void draw(Pen p)
	{
		p.up();
		p.move(x,y); //notice how i don't even have x and y defined in this class?
		p.down();
		//p.setDirection(0);
		//p.move();
		p.move(x+height, y);
		p.move(x+height,y+base);
		p.move(x,y+base);
		p.move(x,y);	
		
	}
	//Notice that the toString method here is especially cool.
	// I am making a polymorphic call to another toString method!!!
	// Where is the toString method that i am making a call to (that
	// is, which class is it located in?)?
	public String toString()
	{
		String output = "Rectangle\nBase Length: "+base
		+ "\nHeight: "+height + "\n" + super.toString();
	
		return output;
	}
	
}
