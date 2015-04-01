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
	
	public Guitar()
	{
		brand = " ";
		make = " ";
		color = " ";
		num_strings = 6;
		tuning = 'E';
	}
	
	public Guitar(String b, String m, String c, char t)
	{
		brand = b;
		make = m;
		color = c;
		num_strings = 6;
		tuning = t;
	}
	
	public Guitar(String b, String m, String c)
	{
		brand = b;
		make = m;
		color = c;
		num_strings = 6;
		tuning = 'E';
	}
	
	public Guitar(String b, String m)
	{
		brand = b;
		make = m;
		color = "Black";
		num_strings = 6;
		tuning = 'E';
	}

	@Override
	public String toString() {
		return "Guitar [brand=" + brand + ", make=" + make + ", color=" + color
				+ ", tuning=" + tuning + "]";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static int getNum_strings() {
		return num_strings;
	}

	public static void setNum_strings(int num_strings) {
		Guitar.num_strings = num_strings;
	}

	public char getTuning() {
		return tuning;
	}

	public void setTuning(char tuning) {
		this.tuning = tuning;
	}
	
	
}
