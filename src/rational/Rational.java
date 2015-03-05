package rational;

/**
 * @author Cameron Kurtz
 *
 */
public class Rational {
	public int numerator;
	public int denominator;
	public int wholeNumber;


	/**
	 * @param n
	 * @param d
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
	/**
	 * @param n
	 * @param d
	 * @return
	 */
	Rational add(Rational b)
	{
		Rational a = this;
		int n = (a.numerator * b.denominator) + (a.denominator * b.numerator);
		int d = (a.denominator * b.denominator);
		return new Rational(n, d);
	}

	/**
	 * @param n
	 * @param d
	 * @return
	 */
	Rational subtract(Rational b)
	{
		Rational a = this;
		int n = (a.numerator * b.denominator) - (a.denominator * b.numerator);
		int d = (a.denominator * b.denominator);
		return new Rational(n, d);
	}
	
	/**
	 * @param n
	 * @param d
	 * @return
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
	
	public double toDouble()
	{
		return (double) numerator/denominator;
	}

	/**
	 * @return 
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
	 * @return
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
	public int getWholeNumber() {
		return this.wholeNumber;
	}

	/**
	 * @param wholeNumber
	 */
}
