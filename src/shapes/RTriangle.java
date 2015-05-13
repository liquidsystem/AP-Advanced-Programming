/*
Class:  RTriangle
This class is going to extend the AbstractShape class
to handle right triangles.  it will be based on the location
of the point at the 90 degree angle, given a height and base
length.
*/
import TurtleGraphics.Pen;
public class RTriangle extends AbstractShape
{
	// I don't need to set up anything for the point at 
	// the right angle s I will inherit that.
	private double height, base;
	
	// Constructors...	
	public RTriangle()
	{
		super(); //this is how i inherit that point!
		height = -1;
		base = -1;
	}
	
	public RTriangle(int xVal, int yVal, double h, double b)
	{
		super(xVal,yVal);
		height = h;
		base = b;
	
	}
	
	// Now I have to go over to the AbstractShape class and see
	// what needs to be defined for this class
	/*
	 * returns the area of the Rtriangle
	 */
	public double area()
	{
		return .5*base*height;
		
	}
	
	public void draw(Pen p)
	{
		
	    
	    p.up();
		p.move(x,y); //notice how i don't even have x and y defined in this class?
		p.down();
		//p.setDirection(0);
		//p.move();
		p.move(x+height, y);
		p.move(x,y+base);
		p.move(x,y);		
	}
	
	public void StretchBy(int factor)
	{
		height *= factor;
		base *= factor; 
	}
	
	public String toString()
	{
		String output = "Triangle\nBase Length: "+base
		+ "\nHeight: "+height + "\n" + super.toString();
	
		return output;
	}
}
