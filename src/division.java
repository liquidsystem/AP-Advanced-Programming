import java.util.Random;
import javax.swing.JOptionPane;
public class division {

	public final static int STARTING_NUMBER = 1;
	public final static int ENDING_NUMBER = 100; 
	public static Random gen = new Random();
	public static int numerator = 0;
	public static int denominator = 0;
	
	public static int get_Num()
	{
		int numerator = (Math.abs(gen.nextInt()%ENDING_NUMBER) + STARTING_NUMBER);
		return numerator;
	}
	
	public static int get_Den()
	{
		int denominator = (Math.abs(gen.nextInt()%ENDING_NUMBER) + STARTING_NUMBER);
		return denominator;
	}
	
	public static int GCD(int numerator, int denominator)
	{
		if(denominator == 0)
			return numerator;
		else
			return GCD(denominator, numerator%denominator);
	}
	
	public static void main(String[] args) {
		// Initialization of variables
		int numerator = get_Num();
		int denominator = get_Den();
		int whole = 0;
		int old_num=0; 
		int old_den=0; 
		int gcd = GCD(numerator, denominator);
		
		
		old_num = numerator;
		old_den = denominator;
		
		whole = numerator/denominator;
		numerator/=gcd;
		denominator/=gcd;
		
		if(whole == 0)
		{	
			JOptionPane.showMessageDialog(null,"The answer to "+old_num+"/"+old_den+" is "+numerator+"/"+denominator);
		}
		else if(numerator == 0 || denominator == 0)
		{
			JOptionPane.showMessageDialog(null,"The answer to "+old_num+"/"+old_den+" is "+whole);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"The answer to "+old_num+"/"+old_den+" is "+whole+" "+numerator+"/"+denominator);
		}
	}
	
}
