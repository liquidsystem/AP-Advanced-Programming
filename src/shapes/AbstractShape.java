/*
Abstract class:  AbstractShape
Notice the keyword abstract in the class header.  
This class implements the Point interface

An abstract class declares common attributes and behaviors
of the various classes using it.  It usually contains at least 
one abstract method that subclasses have to override (like 
our toString() method).

In the programs extending the abstract class, you will use
the method super() to reference the instance variables in
an abstract class.

Notice this is a lot like the 'point' class, but so much more...
*/

import TurtleGraphics.Pen;

abstract public class AbstractShape implements Point
{
	//These are the variables that all of the subclasses have in
	// common!
	protected int x;
	protected int y;
	
	// Even tho we will never be instantiating an object of this
	// class type it still needs constructors to initialize the
	// variables
	
	public AbstractShape()
	{
		x = 0;
		y = 0;
	}
	
	public AbstractShape(int xPos, int yPos)
	{
		x = xPos;
		y = yPos;
	}
	
	// These next 3 methods will actually be defined in
	// the classes that use them.  here, they are just
	// headers.  Since they are not defined they are abstract.
	// All of the subclasses that use them must define these
	// methods.  For example, I could have subclasses like circle,
	// triangle, rectangle, etc.  All of these would have the
	// following methods defined differently...
	abstract public double area();
	abstract public void draw(Pen p);
	abstract public void StretchBy(int factor);
	
	// These are the methods that will not be changed by the subclasses
	// for example a circle, rectangle, triangle share these things.
	public final int getX()
	{
		return x;
	}
	
	public final int getY()
	{
		return y;
	}

	public final void move(int xPos, int yPos)
	{
		x = xPos;
		y = yPos;
	}
	
	//Subclasses will override this toString method
	// Notice that the method makes a call to the area()
	// method!  
	public String toString()
	{
		String output = "(x,y) position is (" + x + ","+ y + ")\n" 
								+ "Area is " + area();
		return output; 
	
	}

}