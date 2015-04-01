package rational;

public class Rational_tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rational r = new Rational(1, 3);
		Rational x = new Rational(10, 2);
			System.out.println(r);
			//r.setNumerator(872);
			//r.setDenominator(8);
			System.out.println(r.add(x));
			System.out.println(r.subtract(x));
			System.out.println(r.multiply(x));
			System.out.println("Rational: (" + r + ") / (" + x + ") = " + r.divide(x));
			System.out.println("Rational: (" + r + ") as double: " + r.toDouble());
	}

}
