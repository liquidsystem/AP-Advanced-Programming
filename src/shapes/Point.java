/*
Point Interface

 
An Interface is a collection of related methods.  All methods are public 
(and abstract) Ð they provide the framework of behavior for any class.



*/

import TurtleGraphics.Pen;

public interface Point 
{
	public double area();
	public void draw(Pen p);
	public int getX();
	public int getY();
	public void move(int x, int y);
	public void StretchBy(int factor);
	public abstract String toString();//"

}