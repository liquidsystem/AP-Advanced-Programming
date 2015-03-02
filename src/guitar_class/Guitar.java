package guitar_class;
/*Program: Guitar.java
 *Purpose: Class to create Guitar objects
 *Programmers: Jackson Lee, Jared Schwartz, Cameron Kurtz
 * 
 */
public class Guitar 
{
	String brand, make, color;
	static int num_strings = 6;
	char tuning;
	
	Guitar()
	{
		brand = " ";
		make = " ";
		color = " ";
		num_strings = 6;
		tuning = 'E';
	}
	
	Guitar(String b, String m, String c, char t)
	{
		brand = b;
		make = m;
		color = c;
		num_strings = 6;
		tuning = t;
	}
	
	Guitar(String b, String m, String c)
	{
		brand = b;
		make = m;
		color = c;
		num_strings = 6;
		tuning = 'E';
	}
	
	Guitar(String b, String m)
	{
		brand = b;
		make = m;
		color = "Black";
		num_strings = 6;
		tuning = 'E';
	}
	
}
