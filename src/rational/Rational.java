package rational;

/**
 * @author Cameron Kurtz
 *
 */
public class Rational {
	public int numerator;
	public int denominator;
	public int wholeNumber;


	/** Creates a rational object with a pre-specified numerator/denominator from the user
	 * @param n - Integer to be assigned as the numerator
	 * @param d - Integer to be assigned as the denominator
	 */
	Rational(int n, int d)
	{
		int g = gcd(n, d);
		numerator = n/g;
		denominator = d/g;
		if(denominator < 0)
		{
			denominator = -denominator; 
			numerator = -numerator;
		}
	}

	//Methods

	/** Adds rational 'a' to rational 'b'
	 * @param b - A rational that will be added to rational 'a'
	 * @return Returns new object of rational a+b
	 */
	Rational add(Rational b)
	{
		Rational a = this;
		int n = (a.numerator * b.denominator) + (a.denominator * b.numerator);
		int d = (a.denominator * b.denominator);
		return new Rational(n, d);
	}

	/** Subtracts rational 'a' to rational 'b'
	 * @param b - A rational that will be subtracted to rational 'a'
	 * @return Returns new object of rational a-b
	 */
	Rational subtract(Rational b)
	{
		Rational a = this;
		int n = (a.numerator * b.denominator) - (a.denominator * b.numerator);
		int d = (a.denominator * b.denominator);
		return new Rational(n, d);
	}
	
	/** Multiply rational 'a' to rational 'b'
	 * @param b - A rational that will multiply with rational 'a'
	 * @return Returns new object of rational a*b
	 */
	Rational multiply(Rational b)
	{
		Rational a = this;
		Rational c = new Rational(a.numerator, b.denominator);
		Rational d = new Rational(b.numerator, a.denominator);
		return new Rational(c.numerator*d.numerator, c.denominator*d.denominator);
	}
	
	Rational reciprocal()
	{
		return new Rational(denominator, numerator);
	}
	/** Divide rational 'a' by rational 'b'
	 * @param b - A rational that will divide rational 'a'
	 * @return Returns new object of rational a/b
	 */
	Rational divide(Rational b)
	{
		Rational a = this;
		return a.multiply(b.reciprocal());
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	private static int gcd(int a, int b)
	{
		if(a<0)
		{
			a = -a;
		}
		if(b<0)
		{
			b = -b;
		}
		if(0  == b)
		{
			return a;
		}
		else return gcd(b, a%b);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if(denominator == 1)
		{
			return numerator + "";
		}
		else
		{
			return numerator + "/" + denominator;
		}
	}
	
	/**
	 * @return Returns rational as a double
	 */
	public double toDouble()
	{
		return (double) numerator/denominator;
	}

	/**
	 * @return Returns the numerator as an integer
	 */
	public int getNumerator() 
	{
		return this.numerator;
	}

	/**
	 * @param numerator
	 */
	public void setNumerator(int n) 
	{
		numerator = n;
	}

	/**
	 * @return Returns the denominator as an integer
	 */
	public int getDenominator() {
		return this.denominator;
	}

	/**
	 * @param denominator
	 */
	public void setDenominator(int d) 
	{
		denominator = d;
	}

	/**
	 * @return
	 */
}
